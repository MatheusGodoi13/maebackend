package Trabalho.BuscarRemedios.Repository;

import Trabalho.BuscarRemedios.model.MedicamentoFitoterapico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoFitoterapicoRepository extends JpaRepository<MedicamentoFitoterapico, Long> {

    @Query(value = "SELECT * FROM dbo.MedicamentoFitoterapico m " +
            "WHERE LOWER(CAST(m.nome_popular AS NVARCHAR)) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "   OR LOWER(CAST(m.indicacoes AS NVARCHAR)) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "   OR LOWER(CAST(m.modo_preparo AS NVARCHAR)) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "   OR LOWER(CAST(m.contraindicacoes AS NVARCHAR)) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "   OR LOWER(CAST(m.parte_usada AS NVARCHAR)) LIKE LOWER(CONCAT('%', :termo, '%'))",
            nativeQuery = true)
    List<MedicamentoFitoterapico> searchByTerm(@Param("termo") String termo);

    default List<MedicamentoFitoterapico> searchByTerms(List<String> termos) {
        List<MedicamentoFitoterapico> results = new java.util.ArrayList<>();
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