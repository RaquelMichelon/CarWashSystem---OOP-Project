/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author raqueldarellimichelon
 */
public class Modelo {
    
    private int id;
    private String descricao;
    
    private Marca marca;
    private ECategoria eCategoria = ECategoria.PADRAO;

    public Modelo() {
    }

    public Modelo(String descricao, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
    }

    public ECategoria geteCategoria() {
        return eCategoria;
    }

    public void seteCategoria(ECategoria eCategoria) {
        this.eCategoria = eCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
    //CONTRUTORES E MÉTODOS PARA FACILITAR A MANIPULAÇÃO DO MOCK DE DADOS
    
    public Modelo(int id, String descricao, Marca marca, ECategoria eCategoria) {
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.eCategoria = eCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modelo other = (Modelo) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Modelo{id=").append(id);
        sb.append(", descricao=").append(descricao);
        sb.append(", marca=").append(marca);
        sb.append(", eCategoria=").append(eCategoria);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
