/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasource;

import entity.Cor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public class CorDS {
    
    private static List<Cor> listaCores = new ArrayList<Cor>();
    
    public static void criarLista() {
        listaCores.add(new Cor(1, "Branco"));
        listaCores.add(new Cor(2, "Preto"));
        listaCores.add(new Cor(3, "Prata"));
        listaCores.add(new Cor(4, "Vermelho"));
    }

    public static List<Cor> getListaCores() {
        return listaCores;
    }

    public static void setListaCores(List<Cor> listaCores) {
        CorDS.listaCores = listaCores;
    }

    
}
