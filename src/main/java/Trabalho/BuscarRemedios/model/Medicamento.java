package Trabalho.BuscarRemedios.model;

import jakarta.persistence.*;

@Entity
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private Long id_medicamento;
    @Column(name = "nome_comercial", nullable = false)
    private String nome_comercial;
    @Column(name = "principio_ativo", nullable = false)
    private String principio_ativo;
    @Column(name = "forma_farmaceutica", nullable = false)
    private String forma_farmaceutica;
    @Column(name = "concentracao", nullable = false)
    private String concentracao;

    public Long getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(Long id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNome_comercial() {return nome_comercial;}

    public void setNome_comercial(String nome_comercial) {
        this.nome_comercial = nome_comercial;
    }

    public String getPrincipio_ativo() {
        return principio_ativo;
    }

    public void setPrincipio_ativo(String principio_ativo) {
        this.principio_ativo = principio_ativo;
    }

    public String getForma_farmaceutica() {
        return forma_farmaceutica;
    }

    public void setForma_farmaceutica(String forma_farmaceutica) {
        this.forma_farmaceutica = forma_farmaceutica;
    }

    public String getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(String concentracao) {
        this.concentracao = concentracao;
    }
}