package Trabalho.BuscarRemedios.Repository;

import Trabalho.BuscarRemedios.model.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {
}