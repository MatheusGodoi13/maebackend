package Trabalho.BuscarRemedios.DTO;

import Trabalho.BuscarRemedios.model.Medicamento;
import Trabalho.BuscarRemedios.model.MedicamentoFitoterapico;

public class MedicamentoFitoDTO {
    private Long id_fitoterapico;
    private String nome_popular;
    private String nome_cientifico;
    private String indicacoes;
    private String contraindicacoes;
    private String parte_usada;
    private String modo_preparo;

    private Long id_medicamento;
    private String principio_ativo;
    private String forma_farmaceutica;
    private String concentracao;

    public MedicamentoFitoDTO(Long id_medicamento, String principio_ativo,
                              String forma_farmaceutica, String concentracao) {

        this.id_medicamento = id_medicamento;
        this.principio_ativo = principio_ativo;
        this. forma_farmaceutica = forma_farmaceutica;
        this. concentracao = concentracao;
    }

    public static MedicamentoFitoDTO fromMedicamento(Medicamento m) {
        return new MedicamentoFitoDTO(
                m.getId_medicamento(),m.getPrincipio_ativo(),m.getForma_farmaceutica(),m.getConcentracao()
        );
    }

    public MedicamentoFitoDTO(Long id_fitoterapico, String parte_usada, String nome_popular, String nome_cientifico,
                              String modo_preparo, String indicacoes, String contraindicacoes){

        this.id_fitoterapico = id_fitoterapico;
        this.nome_popular = nome_popular;
        this.nome_cientifico = nome_cientifico;
        this.indicacoes = indicacoes;
        this.contraindicacoes = contraindicacoes;
        this.parte_usada = parte_usada;
        this.modo_preparo = modo_preparo;

    }
    public static MedicamentoFitoDTO fromFitoterapico(MedicamentoFitoterapico m) {
        return new MedicamentoFitoDTO(
                m.getId_fitoterapico(),m.getNome_popular(),m.getNome_cientifico(),m.getIndicacoes(),m.getContraindicacoes()
                ,m.getParte_usada(),m.getModo_preparo()
        );
    }
}