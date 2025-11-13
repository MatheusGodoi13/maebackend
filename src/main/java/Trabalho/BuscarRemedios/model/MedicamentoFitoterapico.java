package Trabalho.BuscarRemedios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"MedicamentoFitoterapico\"", schema = "dbo")
public class MedicamentoFitoterapico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_fitoterapico")
    private Long id_fitoterapico;
    @Column(name = "nome_popular", nullable = false)
    private String nome_popular;
    @Column(name = "nome_cientifico", nullable = false)
    private String nome_cientifico;
    @Column(name = "indicacoes", nullable = false)
    private String indicacoes;
    @Column(name = "contraindicacoes", nullable = false)
    private String contraindicacoes;
    @Column(name = "parte_usada", nullable = false)
    private String parte_usada;
    @Column(name = "modo_preparo", nullable = false)
    private String modo_preparo;

    public Long getId_fitoterapico() {
        return id_fitoterapico;
    }

    public void setId_fitoterapico(Long id_fitoterapico) {
        this.id_fitoterapico = id_fitoterapico;
    }

    public String getNome_popular() {
        return nome_popular;
    }

    public void setNome_popular(String nome_popular) {
        this.nome_popular = nome_popular;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public String getContraindicacoes() {
        return contraindicacoes;
    }

    public void setContraindicacoes(String contraindicacoes) {
        this.contraindicacoes = contraindicacoes;
    }

    public String getNome_cientifico() {
        return nome_cientifico;
    }

    public void setNome_cientifico(String nome_cientifico) {
        this.nome_cientifico = nome_cientifico;
    }

    public String getParte_usada() {
        return parte_usada;
    }

    public void setParte_usada(String parte_usada) {
        this.parte_usada = parte_usada;
    }

    public String getModo_preparo() {
        return modo_preparo;
    }

    public void setModo_preparo(String modo_preparo) {
        this.modo_preparo = modo_preparo;
    }
}
