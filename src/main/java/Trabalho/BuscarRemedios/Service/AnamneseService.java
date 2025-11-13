package Trabalho.BuscarRemedios.Service;

import Trabalho.BuscarRemedios.DTO.AnamneseDTO;
import Trabalho.BuscarRemedios.Repository.AnamneseRepository;
import Trabalho.BuscarRemedios.model.Anamnese;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnamneseService {

    @Autowired
    private AnamneseRepository anamneseRepository;

    @Transactional
    public Anamnese salvar(AnamneseDTO anamneseDTO) {
        Anamnese anamnese = new Anamnese();
        anamnese.setNome(anamneseDTO.getNome());
        anamnese.setIdade(anamneseDTO.getIdade());
        anamnese.setAdicionais(anamneseDTO.getAdicionais());
        anamnese.setDataConsulta(anamneseDTO.getDataconsulta());
        anamnese.setTemAsma(anamneseDTO.getTemasma());
        anamnese.setAlergiasMedicamentos(anamneseDTO.getAlergiasmedicamentos());
        anamnese.setConsomeAlcool(anamneseDTO.getConsomealcool());
        anamnese.setDoencasCronicas(anamneseDTO.getDoencascronicas());
        anamnese.setFumante(anamneseDTO.getFumante());
        anamnese.setGestante(anamneseDTO.getGestante());
        anamnese.setUsoContinuoRemedios(anamneseDTO.getUsocontinuoremedios());

        return anamneseRepository.save(anamnese);
    }
}