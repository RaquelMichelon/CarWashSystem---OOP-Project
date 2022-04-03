/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasource;

import entity.Veiculo;
import exceptions.DataSourceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public class VeiculoDS {
    
    private static List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();

    public static void criarLista() {
        
        add(new Veiculo(1, "AAA-111", "Veículo com porta arranhada", ModeloDS.getListaModelos().get(0), 
                CorDS.getListaCores().get(0)));
        add(new Veiculo(2, "BBB-222", "Veículo impecável", ModeloDS.getListaModelos().get(1), 
                CorDS.getListaCores().get(1)));
        add(new Veiculo(3, "CCC-333", "Veículo longo", ModeloDS.getListaModelos().get(2), 
                CorDS.getListaCores().get(2)));
        add(new Veiculo(4, "DDD-444", "Veículo com couro rasgado", ModeloDS.getListaModelos().get(3), 
                CorDS.getListaCores().get(0)));
        add(new Veiculo(5, "EEE-555", "Veículo novo", ModeloDS.getListaModelos().get(4), 
                CorDS.getListaCores().get(3)));

    }

    public static List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public static void setListaVeiculos(List<Veiculo> listaVeiculos) {
        VeiculoDS.listaVeiculos = listaVeiculos;
    }

    public static void add(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }
    
    public static void remove(Veiculo veiculo) {
        listaVeiculos.remove(veiculo);
    }

    public static Veiculo getPorPlaca(String placa) throws DataSourceException {
        for (Veiculo veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        throw new DataSourceException("Não foi encontrado veículo para a placa informada!");
    }
    
}
