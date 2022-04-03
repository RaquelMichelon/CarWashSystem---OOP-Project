/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package entity;

/**
 *
 * @author raqueldarellimichelon
 */
public enum EStatus {
    
    ABERTA("aberta"),
    FECHADA("fechada"),
    CANCELADA("cancelada");
    
    private final String descricao;
    
    EStatus(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
