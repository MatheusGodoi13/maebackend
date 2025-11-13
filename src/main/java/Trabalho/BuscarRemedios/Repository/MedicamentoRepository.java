package Trabalho.BuscarRemedios.Repository;

import Trabalho.BuscarRemedios.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    @Query(value = "SELECT * FROM Medicamento m " +
            "WHERE CAST(m.concentracao AS NVARCHAR) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "   OR LOWER(m.nome_comercial) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "   OR LOWER(m.principio_ativo) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "   OR LOWER(m.forma_farmaceutica) LIKE LOWER(CONCAT('%', :termo, '%'))",
            nativeQuery = true)
    List<Medicamento> searchByTerm(@Param("termo") String termo);

    default List<Medicamento> searchByTerms(List<String> termos) {
        List<Medicamento> results = new java.util.ArrayList<>();
        for (String termo : termos) {
            String[] palavras = termo.split("\\s+");
            for (String palavra : palavras) {
                results.addAll(searchByTerm(palavra));
            }
        }
        return results.stream()
                .distinct()
                .toList();
    }
}