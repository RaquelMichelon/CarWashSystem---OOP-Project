/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasource;

import entity.ECategoria;
import entity.Servico;
import exceptions.DataSourceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public class ServicoDS {
    
    private static List<Servico> listaServicos = new ArrayList<Servico>();
    
    
    public static void criarLista() {
        add(new Servico(1, "Lavação Completa VLon", 50, ECategoria.GRANDE));        
        add(new Servico(2, "Lavação Completa VPdr", 40, ECategoria.PADRAO));        
        add(new Servico(3, "Lavação Completa Moto", 20, ECategoria.MOTO));
        add(new Servico(4, "Aspiração Veículo Pqn", 30, ECategoria.PEQUENO));
        add(new Servico(5, "Aspiração Veículo Méd", 35, ECategoria.MEDIO));
        add(new Servico(6, "Aspiração Veículo Grd", 45, ECategoria.GRANDE));        
        add(new Servico(7, "Lavação Ex. c/ Shampoo", 25, ECategoria.PADRAO));
        add(new Servico(8, "Cera Antiestática Pdr", 60, ECategoria.PADRAO));
        Servico.setPontos(10);
    }

    
    public static List<Servico> getListaServicos() {
        return listaServicos;
    }

    public static void setListaServicos(List<Servico> listaServicos) {
        ServicoDS.listaServicos = listaServicos;
    }
    
    public static void add(Servico servico) {
        listaServicos.add(servico);
    }
    
    public static void remove(Servico servico) {
        listaServicos.remove(servico);
    }
    
    
    public static Servico getPorId(int id) throws DataSourceException {
        for (Servico servico : listaServicos) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        throw new DataSourceException("Não foi encontrado um serviço com este id.");

    }
  
}