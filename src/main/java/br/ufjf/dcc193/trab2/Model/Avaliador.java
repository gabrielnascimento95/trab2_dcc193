package br.ufjf.dcc193.trab2.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Avaliador
 */
@Entity
public class Avaliador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String codigo;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Area> areas;


    public Avaliador(){

    }

    public Avaliador(String nome, String cod, String email){
        this.codigo = cod;
        this.nome = nome;
        this.email = email;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the areas
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param areas the areas to set
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}