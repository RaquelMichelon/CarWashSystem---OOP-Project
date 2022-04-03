/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import exceptions.ExceptionLavacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public abstract class Cliente implements ICliente {
    
    private int id;
    private String nome;
    private String celular;
    private String email;
    private Date dataCadastro;
    
    private List<Veiculo> veiculos;
    
    private Pontuacao pontuacao;


    public Cliente() {        
        this.pontuacao = new Pontuacao();
    }

    public void add(Veiculo veiculo) {
        if (this.veiculos == null) {
            this.veiculos = new ArrayList<>();
        }
        veiculos.add(veiculo);
        veiculo.setCliente(this);
    }
    
    public void remove(Veiculo veiculo) throws ExceptionLavacao {
        
        if(veiculos.contains(veiculo)) {
            veiculos.remove(veiculo);
            veiculo.setCliente(null);
        } else {           
            throw new ExceptionLavacao("Esse veículo não foi cadastrado para esse cliente!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }
    
        
    //CONTRUTORES E MÉTODOS PARA FACILITAR A MANIPULAÇÃO DO MOCK DE DADOS
    
    public Cliente(int id, String nome, String celular, String email, Date dataCadastro, List<Veiculo> veiculos, Pontuacao pontuacao) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.veiculos = veiculos;
        this.pontuacao = pontuacao;
    }
    
    public Cliente(int id, String nome, String celular, String email, Date dataCadastro, Pontuacao pontuacao) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
//        this.veiculos = veiculos;
        this.pontuacao = pontuacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{id=").append(id);
        sb.append(", nome=").append(nome);
        sb.append(", celular=").append(celular);
        sb.append(", email=").append(email);
        sb.append(", dataCadastro=").append(dataCadastro);
        sb.append(", pontuacao=").append(pontuacao.saldo());
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    

}
