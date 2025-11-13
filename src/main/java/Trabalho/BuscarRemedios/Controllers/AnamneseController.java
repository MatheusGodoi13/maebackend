package Trabalho.BuscarRemedios.Controllers;

import Trabalho.BuscarRemedios.DTO.AnamneseDTO;
import Trabalho.BuscarRemedios.Service.AnamneseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ficha_anamnese")
public class AnamneseController {

    @Autowired
    private AnamneseService anamneseService;

    @PostMapping
    public ResponseEntity<String> criarAnamnese(@RequestBody AnamneseDTO anamneseDTO) {
        try {
            anamneseService.salvar(anamneseDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Salvo");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }
}