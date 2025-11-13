package Trabalho.BuscarRemedios.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;

@Entity
@Table(name = "ficha_anamnese")
@Data
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nome",nullable = false)
    private String nome;

    @Column(name ="idade",nullable = false)
    private Integer idade;

    @Column(name = "dataconsulta")
    private LocalDate dataconsulta = LocalDate.now();

    @Column(name = "alergiasmedicamentos")
    private String alergiasmedicamentos;

    @Column(name = "doencascronicas")
    private String doencascronicas;

    @Column(name = "adicionais", length = 255)
    private String adicionais;

    @Column(name = "gestante")
    private String gestante;
    @Column(name = "usocontinuoremedios")
    private String usocontinuoremedios;
    @Column(name = "consomealcool")
    private String consomealcool;
    @Column(name = "fumante")
    private String fumante;
    @Column(name = "temasma")
    private String temasma;
    @Column(name = "temdiabetes")
    private String temdiabetes;

    @Column(name = "datacriacao",updatable = false)
    @CreationTimestamp
    private LocalDate datacriacao = LocalDate.now();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataconsulta() {
        return dataconsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataconsulta = dataConsulta;
    }

    public void setAdicionais(String adicionais){this.adicionais = adicionais;}

    public String getAdicionais(){
        return adicionais;
    }

    public String getAlergiasMedicamentos() {
        return alergiasmedicamentos;
    }

    public void setAlergiasMedicamentos(String alergiasMedicamentos) {
        this.alergiasmedicamentos = alergiasMedicamentos;
    }

    public String getDoencasCronicas() {
        return doencascronicas;
    }

    public void setDoencasCronicas(String doencasCronicas) {
        this.doencascronicas = doencasCronicas;
    }

    public String getGestante() {
        return gestante;
    }

    public String getUsoContinuoRemedios() {
        return usocontinuoremedios;
    }
    public void setConsomeAlcool(boolean ConsomeAlcool){
        this.consomealcool = consomealcool;
    }

    public void setGestante(String gestante) {
        gestante = gestante;
    }

    public void setUsoContinuoRemedios(String usoContinuoRemedios) {
        this.usocontinuoremedios = usoContinuoRemedios;
    }

    public void setConsomeAlcool(String consomeAlcool) {
        this.consomealcool = consomeAlcool;
    }

    public void setFumante(String fumante) {
        fumante = fumante;
    }

    public void setTemAsma(String temAsma) {
        this.temasma = temAsma;
    }

    public void setTemDiabetes(String temDiabetes) {
        this.temdiabetes = temDiabetes;
    }

    public String getConsomeAlcool() {
        return consomealcool;
    }

    public String getFumante() {
        return fumante;
    }

    public String getTemAsma() {
        return temasma;
    }

    public String getTemDiabetes() {
        return temdiabetes;
    }

    public LocalDate getDataCriacao() {
        return datacriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.datacriacao = dataCriacao;
    }
}