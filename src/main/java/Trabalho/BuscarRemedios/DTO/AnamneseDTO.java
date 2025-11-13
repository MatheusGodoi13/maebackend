package Trabalho.BuscarRemedios.DTO;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

@Data
public class AnamneseDTO {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("dataconsulta")
    private LocalDate dataconsulta = LocalDate.now();

    @JsonProperty("idade")
    private Integer idade;

    @JsonProperty("alergiasmedicamentos")
    private String alergiasmedicamentos;

    @JsonProperty("doencascronicas")
    private String doencascronicas;

    @JsonProperty("gestante")
    private String gestante;

    @JsonProperty("usocontinuoremedios")
    private String usocontinuoremedios;

    @JsonProperty("consomeAlcool")
    private String consomealcool;

    @JsonProperty("fumante")
    private String fumante;

    @JsonProperty("temasma")
    private String temasma;

    @JsonProperty("temdiabetes")
    private String temdiabetes;

    @JsonProperty("adicionais")
    private String adicionais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(LocalDate dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getAlergiasmedicamentos() {
        return alergiasmedicamentos;
    }

    public void setAlergiasmedicamentos(String alergiasmedicamentos) {
        this.alergiasmedicamentos = alergiasmedicamentos;
    }

    public String getDoencascronicas() {
        return doencascronicas;
    }

    public void setDoencascronicas(String doencascronicas) {
        this.doencascronicas = doencascronicas;
    }

    public String getGestante() {
        return gestante;
    }

    public void setGestante(String gestante) {
        this.gestante = gestante;
    }

    public String getUsocontinuoremedios() {
        return usocontinuoremedios;
    }

    public void setUsocontinuoremedios(String usocontinuoremedios) {
        this.usocontinuoremedios = usocontinuoremedios;
    }

    public String getConsomealcool() {return consomealcool;}

    public void setConsomealcool(String consomealcool) {
        this.consomealcool = consomealcool;
    }

    public String getFumante() {
        return fumante;
    }

    public void setFumante(String fumante) {
        this.fumante = fumante;
    }

    public String getTemasma() {
        return temasma;
    }

    public void setTemasma(String temasma) {
        this.temasma = temasma;
    }

    public String getTemdiabetes() {
        return temdiabetes;
    }

    public void setTemdiabetes(String temdiabetes) {
        this.temdiabetes = temdiabetes;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }
}
