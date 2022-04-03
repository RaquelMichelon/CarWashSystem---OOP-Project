/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import exceptions.ExceptionLavacao;

/**
 *
 * @author raqueldarellimichelon
 */
public class Pontuacao {
    
    private int quantidade;
   
    public int adicionar(int qtd) {
        return this.quantidade += qtd;
    }
    
    public int subtrair(int qtd) throws ExceptionLavacao {
        
        if (saldo() >= qtd) {
            this.quantidade -= qtd;
        } else {
            throw new ExceptionLavacao("O número de pontos a reduzir é maior que o saldo atual do cliente!");
        }
        return this.quantidade;
    }
    
    public int saldo() {
        return this.quantidade;
    }
    
    
    //CONTRUTORES E MÉTODOS PARA FACILITAR A MANIPULAÇÃO DO MOCK DE DADOS

    public Pontuacao(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pontuacao() {
    }
    
    

}
