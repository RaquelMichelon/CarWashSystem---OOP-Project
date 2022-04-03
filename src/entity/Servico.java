/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


/**
 *
 * @author raqueldarellimichelon
 */
public class Servico {
    
    private int id;
    private String descricao;
    private double valor;
    
    private static int pontos;
    
    private ECategoria eCategoria = ECategoria.PADRAO;
    
    public Servico() {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ECategoria geteCategoria() {
        return eCategoria;
    }

    public void seteCategoria(ECategoria eCategoria) {
        this.eCategoria = eCategoria;
    }


    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Servico.pontos = pontos;
    }
    
    
    //para falicitar o mock de dados
    public Servico(int id, String descricao, double valor, ECategoria eCategoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.eCategoria = eCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Servico other = (Servico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Servico{id=").append(id);
        sb.append(", descricao=").append(descricao);
        sb.append(", valor=").append(valor);
        sb.append(", eCategoria=").append(eCategoria);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
}
