package Trabalho.BuscarRemedios.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

@Service
public class IaService {

    @Value("${openai.api.key}")
    private String openaiApiKey; // definir em application.yml ou env var

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static class IaResult {
        public List<String> keywords = new ArrayList<>();
        public List<String> candidates = new ArrayList<>();
    }

    public IaResult extrairPalavrasChave(String userText) {
        try {
            String prompt = buildPrompt(userText);


            Map<String, Object> body = new HashMap<>();
            body.put("model", "gpt-4o-mini");
            List<Map<String, String>> messages = List.of(
                    Map.of("role", "system", "content", "Você é um assistente técnico para extrair termos para busca em banco de medicamentos."),
                    Map.of("role", "user", "content", prompt)
            );
            body.put("messages", messages);
            body.put("max_tokens", 300);
            body.put("temperature", 0.0);

            String requestBody = objectMapper.writeValueAsString(body);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .timeout(Duration.ofSeconds(30))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + openaiApiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {

                IaResult fallback = new IaResult();
                fallback.keywords.add(userText);
                return fallback;
            }

            JsonNode root = objectMapper.readTree(response.body());

            String content = root.path("choices").get(0).path("message").path("content").asText();

            // Tenta parsear o JSON retornado pelo modelo
            IaResult result = new IaResult();
            try {
                JsonNode parsed = objectMapper.readTree(content);
                if (parsed.has("keywords")) {
                    parsed.get("keywords").forEach(n -> result.keywords.add(n.asText()));
                }
                if (parsed.has("candidates")) {
                    parsed.get("candidates").forEach(n -> result.candidates.add(n.asText()));
                }
            } catch (Exception ex) {
                String cleaned = content.replaceAll("[\\r\\n]+", " ");
                String[] parts = cleaned.split(",");
                for (String p : parts) {
                    String t = p.trim();
                    if (!t.isEmpty()) result.keywords.add(t);
                }

                if (result.keywords.isEmpty()) result.keywords.add(userText);
            }


            result.keywords = normalizeList(result.keywords);
            result.candidates = normalizeList(result.candidates);

            return result;

        } catch (Exception e) {
            IaResult fallback = new IaResult();
            fallback.keywords.add(userText);
            return fallback;
        }
    }

    private String buildPrompt(String userText) {
        return "Input: \"" + userText + "\"\n\n"
                + "Retorne JSON com {\"keywords\": [...], \"candidates\": [...]} conforme regras: "
                + "max 6 keywords, max 8 candidates. Use termos úteis para buscar em colunas: nome_comercial, principio_ativo, form_farmaceutica, concentracao.";
    }

    private List<String> normalizeList(List<String> list) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (String s: list) {
            String n = s.toLowerCase().trim();
            n = removeAccents(n);
            if (!n.isEmpty()) set.add(n);
        }
        return new ArrayList<>(set);
    }

    private String removeAccents(String s) {
        return java.text.Normalizer.normalize(s, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }
}
