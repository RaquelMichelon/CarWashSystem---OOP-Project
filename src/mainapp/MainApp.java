/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainapp;

import datasource.MarcaDS;
import datasource.ClienteDS;
import datasource.CorDS;
import datasource.ModeloDS;
import datasource.OrdemServicoDS;
import datasource.ServicoDS;
import datasource.VeiculoDS;
import exceptions.DataSourceException;
import exceptions.ExceptionLavacao;

/**
 *
 * @author raqueldarellimichelon
 */
public class MainApp {

    /**
     * @param args the command line arguments
     * @throws exceptions.DataSourceException
     * @throws exceptions.ExceptionLavacao
     */
    public static void main(String[] args) throws DataSourceException, ExceptionLavacao {
        
        MarcaDS.criarLista();
        ModeloDS.criarLista();
        CorDS.criarLista();
        VeiculoDS.criarLista();
        ClienteDS.criarLista();
        ServicoDS.criarLista();
        OrdemServicoDS.criarLista();
               
        System.out.println(OrdemServicoDS.getListaOrdemServico().get(0).getDados());

    }
  
}
