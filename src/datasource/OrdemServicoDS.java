/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasource;

import entity.ECategoria;
import entity.EStatus;
import entity.ItemOS;
import entity.OrdemServico;
import exceptions.DataSourceException;
import exceptions.ExceptionLavacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public class OrdemServicoDS {
    
    private static List<OrdemServico> listaOrdemServico = new ArrayList<OrdemServico>();

    public static void criarLista() throws DataSourceException, ExceptionLavacao {
        
        add(new OrdemServico(1111, new Date(), 5, EStatus.ABERTA, VeiculoDS.getPorPlaca("AAA-111")));
        add(new OrdemServico(2222, new Date(), 10, EStatus.FECHADA, VeiculoDS.getPorPlaca("EEE-555")));
        add(new OrdemServico(3333, new Date(), 15, EStatus.CANCELADA, VeiculoDS.getPorPlaca("CCC-333")));
        
               
        ItemOS item1 = new ItemOS("Primeiro ItemOS", ServicoDS.getPorId(1), OrdemServicoDS.getPorNumero(1111));
        item1.setValorServico(ServicoDS.getPorId(1).getValor());
        item1.getServico().seteCategoria(ECategoria.PEQUENO);
        getListaOrdemServico().get(0).add(item1);
        

        ItemOS item2 = new ItemOS("Segundo ItemOS", ServicoDS.getPorId(2), OrdemServicoDS.getPorNumero(1111));
        item2.setValorServico(ServicoDS.getPorId(2).getValor());
        item2.getServico().seteCategoria(ECategoria.GRANDE);
        OrdemServicoDS.getListaOrdemServico().get(0).add(item2);
        
        
        ItemOS item3 = new ItemOS("Terceiro ItemOS", ServicoDS.getPorId(3), OrdemServicoDS.getPorNumero(2222));
        item3.setValorServico(ServicoDS.getPorId(3).getValor());
        item3.getServico().seteCategoria(ECategoria.GRANDE);
        OrdemServicoDS.getListaOrdemServico().get(1).add(item3);
        
        ItemOS item4 = new ItemOS("Quarto ItemOS", ServicoDS.getPorId(4), OrdemServicoDS.getPorNumero(2222));
        item4.setValorServico(ServicoDS.getPorId(4).getValor());
        item4.getServico().seteCategoria(ECategoria.MEDIO);
        OrdemServicoDS.getListaOrdemServico().get(1).add(item4);
        
        ItemOS item5 = new ItemOS("Quinto ItemOS", ServicoDS.getPorId(5), OrdemServicoDS.getPorNumero(2222));
        item5.setValorServico(ServicoDS.getPorId(5).getValor());
        OrdemServicoDS.getListaOrdemServico().get(1).add(item5);
        
        ItemOS item6 = new ItemOS("Sexto ItemOS", ServicoDS.getPorId(6), OrdemServicoDS.getPorNumero(3333));
        item6.setValorServico(ServicoDS.getPorId(6).getValor());
        OrdemServicoDS.getListaOrdemServico().get(2).add(item6);
        
        ItemOS item7 = new ItemOS("Sétimo ItemOS", ServicoDS.getPorId(7), OrdemServicoDS.getPorNumero(3333));
        item7.setValorServico(ServicoDS.getPorId(7).getValor());
        OrdemServicoDS.getListaOrdemServico().get(2).add(item7);
        
        ItemOS item8 = new ItemOS("Oitavo ItemOS", ServicoDS.getPorId(8), OrdemServicoDS.getPorNumero(3333));
        item8.setValorServico(ServicoDS.getPorId(8).getValor());
        OrdemServicoDS.getListaOrdemServico().get(2).add(item8);
        
        
        getListaOrdemServico().get(0).calcularServico();
        getListaOrdemServico().get(1).calcularServico();
        getListaOrdemServico().get(2).calcularServico();

    }    

    public static List<OrdemServico> getListaOrdemServico() {
        return listaOrdemServico;
    }

    public static void setListaOrdemServico(List<OrdemServico> listaOrdemServico) {
        OrdemServicoDS.listaOrdemServico = listaOrdemServico;
    }

    public static void add(OrdemServico ordemServico) {
        listaOrdemServico.add(ordemServico);
    }
    
    public static void remove(OrdemServico ordemServico) {
        listaOrdemServico.remove(ordemServico);
    }
    
    
    public static OrdemServico getPorNumero(long numero) throws DataSourceException {
        for (OrdemServico ordemServico : listaOrdemServico) {
            if (ordemServico.getNumero() == numero) {
                return ordemServico;
            }
        }
        throw new DataSourceException("Ordem de serviço não encontrada!");
    }
    

}
