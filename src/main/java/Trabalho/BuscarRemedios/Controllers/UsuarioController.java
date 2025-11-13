package Trabalho.BuscarRemedios.Controllers;

import Trabalho.BuscarRemedios.DTO.UsuarioDTO;
import Trabalho.BuscarRemedios.Service.UsuarioService;
import Trabalho.BuscarRemedios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioService.salvar(usuarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar usuário: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
