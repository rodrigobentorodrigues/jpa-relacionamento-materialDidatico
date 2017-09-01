
package com.ifpb.jpa.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MaterialDidatico implements Serializable {
    
    @EmbeddedId
    private MaterialDidaticoPK chaveComposta;
    @Column(length = 155, nullable = false)
    private String titulo;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Lob
    private String descricao;
    @Column(length = 55)
    private String autor;
    private boolean publico;
//    @Column(columnDefinition = "NUMERIC PRECISION(6,2)")
    @Column(columnDefinition = "numeric(6,2)")
    private double tamanho;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private TipoMaterialDidatico tipo;
    
    public MaterialDidatico(){
        this.dataCadastro = new Date();
    }

    public MaterialDidatico(MaterialDidaticoPK chaveComposta, String titulo,
            String descricao, String autor, boolean publico,
            double tamanho, TipoMaterialDidatico tipo) {
        this();
        this.chaveComposta = chaveComposta;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
        this.publico = publico;
        this.tamanho = tamanho;
        this.tipo = tipo;
    }
    
    public enum TipoMaterialDidatico {
        APOSTILA,
        VIDEOAULA,
        APRESENTACAO
    }

    public TipoMaterialDidatico getTipo() {
        return tipo;
    }

    public void setTipo(TipoMaterialDidatico tipo) {
        this.tipo = tipo;
    }
    
    public MaterialDidaticoPK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(MaterialDidaticoPK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
}
