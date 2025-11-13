package Trabalho.BuscarRemedios.Repository;

import Trabalho.BuscarRemedios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
