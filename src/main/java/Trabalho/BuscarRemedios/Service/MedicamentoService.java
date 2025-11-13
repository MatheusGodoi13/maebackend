package Trabalho.BuscarRemedios.Service;


import Trabalho.BuscarRemedios.Repository.MedicamentoFitoterapicoRepository;
import Trabalho.BuscarRemedios.Repository.MedicamentoRepository;
import Trabalho.BuscarRemedios.model.Medicamento;
import Trabalho.BuscarRemedios.model.MedicamentoFitoterapico;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoFitoterapicoRepository fitoterapicoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository,
                              MedicamentoFitoterapicoRepository fitoterapicoRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.fitoterapicoRepository = fitoterapicoRepository;
    }

    public List<Object> searchByTerms(List<String> termos) {
        List<Object> resultados = new ArrayList<>();

        for (String termo : termos) {
            resultados.addAll(medicamentoRepository.searchByTerm(termo.toLowerCase()));
            resultados.addAll(fitoterapicoRepository.searchByTerm(termo.toLowerCase()));
        }
        return resultados.stream().distinct().toList();
    }

    public List<Medicamento> searchMedicamentos(List<String> termos) {
        return medicamentoRepository.searchByTerms(termos);
    }

    public List<MedicamentoFitoterapico> searchFitoterapicos(List<String> termos) {
        return fitoterapicoRepository.searchByTerms(termos);
    }
}
