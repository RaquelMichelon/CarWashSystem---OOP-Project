package datasource;

import entity.ECategoria;
import entity.Modelo;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raqueldarellimichelon
 */
public class ModeloDS {
    
    private static List<Modelo> listaModelos = new ArrayList<>();
    
    public static void criarLista() {
        listaModelos.add(new Modelo(1, "C4", MarcaDS.getListaMarcas().get(0), ECategoria.MEDIO));
        listaModelos.add(new Modelo(2, "Toro", MarcaDS.getListaMarcas().get(4), ECategoria.GRANDE));
        listaModelos.add(new Modelo(3, "Onix", MarcaDS.getListaMarcas().get(2), ECategoria.MEDIO));
        listaModelos.add(new Modelo(4, "Focus", MarcaDS.getListaMarcas().get(1), ECategoria.PADRAO));
        listaModelos.add(new Modelo(5, "Fox", MarcaDS.getListaMarcas().get(1), ECategoria.PEQUENO));
    }
    

    public static List<Modelo> getListaModelos() {
        return listaModelos;
    }

    public static void setListaModelos(List<Modelo> listaModelos) {
        ModeloDS.listaModelos = listaModelos;
    }

    
}
