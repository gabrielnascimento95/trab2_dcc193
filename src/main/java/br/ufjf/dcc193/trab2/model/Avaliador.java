package br.ufjf.dcc193.trab2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Avaliador
 */
@Entity
public class Avaliador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "É preciso um nome!")
    private String nome;
    @NotBlank(message = "É preciso um e-mail!")
    @Email(message = "É preciso um e-mail válido!")
    private String email;
    @NotNull(message = "É preciso um código!")
    private int codigo;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Area> areas;

    /**
     *
     */
    public Avaliador() {
    }

    /**
     *
     * @param nome
     * @param email
     * @param codigo
     */
    public Avaliador(String nome, String email, int codigo) {
        this.nome = nome;
        this.email = email;
        this.codigo = codigo;
    }

    /**
     *
     * @param nome
     * @param email
     * @param codigo
     * @param areas
     */
    public Avaliador(String nome, String email, int codigo, List<Area> areas) {
        this.nome = nome;
        this.email = email;
        this.codigo = codigo;
        this.areas = areas;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     *
     * @param areas
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public void addArea(Area area){
        this.areas.add(area);
    }

    public void removeArea(Area area){
        this.areas.remove(area);
    }

    @Override
    public String toString() {
        return "Avaliador{" + "nome=" + nome + ", email=" + email + ", codigo=" + codigo + ", areas="
                + areas + '}';
    }
}