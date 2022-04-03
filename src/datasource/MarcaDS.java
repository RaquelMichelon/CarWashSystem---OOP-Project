package datasource;


import entity.Marca;
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
public class MarcaDS {
    
    private static List<Marca> listaMarcas = new ArrayList<>();
    
    
    public static void criarLista() {
        listaMarcas.add(new Marca(1, "Citroen"));
        listaMarcas.add(new Marca(2, "Ford"));
        listaMarcas.add(new Marca(3, "Chevrolet"));
        listaMarcas.add(new Marca(4, "Kya"));
        listaMarcas.add(new Marca(5, "Fiat"));
    }

    public static List<Marca> getListaMarcas() {
        return listaMarcas;
    }

    public static void setListaMarcas(List<Marca> listaMarcas) {
        MarcaDS.listaMarcas = listaMarcas;
    }
    
    
    
    
    
}
