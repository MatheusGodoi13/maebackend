package Trabalho.BuscarRemedios.Controllers;

import Trabalho.BuscarRemedios.DTO.RecomendarDTO;
import Trabalho.BuscarRemedios.Repository.MedicamentoFitoterapicoRepository;
import Trabalho.BuscarRemedios.Repository.MedicamentoRepository;
import Trabalho.BuscarRemedios.Service.IaService;
import Trabalho.BuscarRemedios.model.Medicamento;
import Trabalho.BuscarRemedios.model.MedicamentoFitoterapico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final IaService iaService;
    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoFitoterapicoRepository medicamentoFitoterapicoRepository;

    public MedicamentoController(IaService iaService,
                                 MedicamentoRepository medicamentoRepository,
                                 MedicamentoFitoterapicoRepository medicamentoFitoterapicoRepository) {
        this.iaService = iaService;
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoFitoterapicoRepository = medicamentoFitoterapicoRepository;
    }
    @PostMapping("/recomendar")
    public ResponseEntity<?> recomendar(@RequestBody RecomendarDTO req) {
        String termo = req.termo != null ? req.termo : "";
        List<String> termosBusca;

        if (req.sintomas != null && !req.sintomas.isEmpty()) {
            termosBusca = req.sintomas;
        } else {
            IaService.IaResult result = iaService.extrairPalavrasChave(termo);
            termosBusca = !result.keywords.isEmpty() ? result.keywords :
                    !result.candidates.isEmpty() ? result.candidates :
                            List.of(termo);
        }

        List<Medicamento> meds = medicamentoRepository.searchByTerms(termosBusca);
        List<MedicamentoFitoterapico> fitos = medicamentoFitoterapicoRepository.searchByTerms(termosBusca);

        Map<String, Object> resp = new HashMap<>();
        resp.put("termo_usuario", termo);
        resp.put("sintomas", req.sintomas);
        resp.put("parteCorpo", req.parteCorpo);
        resp.put("termos_usados_na_busca", termosBusca);
        resp.put("medicamentos", meds);
        resp.put("fitoterapicos", fitos);

        return ResponseEntity.ok(resp);
    }
}
