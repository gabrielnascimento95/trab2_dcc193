package br.ufjf.dcc193.trab2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.FetchType;

/**
 * Trabalho
 */
@Entity
@Table(name = "trabalho")
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "É preciso um título!")
    private String titulo;
    @NotBlank(message = "É preciso uma descrição!")
    private String descricao;
    @NotBlank(message = "É preciso uma url!")
    private String url;    
    @OneToOne(fetch = FetchType.EAGER)
    private Area areaConhecimento;

    /**
     *
     */
    public Trabalho() {
    }

    /**
     *
     * @param titulo
     * @param descricao
     * @param url
     * @param areaConhecimento
     */
    public Trabalho(String titulo, String descricao, String url, Area areaConhecimento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
        this.areaConhecimento = areaConhecimento;
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
    public String getTitulo() {
        return titulo;
    }

    /**
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public Area getAreaConhecimento() {
        return areaConhecimento;
    }

    /**
     *
     * @param areaConhecimento
     */
    public void setAreaConhecimento(Area areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    @Override
    public String toString() {
        return "Trabalho{" + "titulo=" + titulo + ", descricao=" + descricao + ", url=" + url + ", areaConhecimento="
                + areaConhecimento + '}';
    }
}