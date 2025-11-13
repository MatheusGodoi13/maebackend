package Trabalho.BuscarRemedios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DatabaseQueryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void deveExecutarConsultaSimples() {
        Long totalUsuarios = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Usuario", Long.class);
        Assertions.assertNotNull(totalUsuarios, "A consulta ao banco retornou nulo");
        System.out.println("Total de usuários cadastrados: " + totalUsuarios);
    }
}

