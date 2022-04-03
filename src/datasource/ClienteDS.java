/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datasource;

import entity.Cliente;
import entity.PessoaFisica;
import entity.PessoaJuridica;
import entity.Pontuacao;
import exceptions.DataSourceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public class ClienteDS {
    
    private static List<Cliente> listaClientes = new ArrayList<Cliente>();
    
    public static void criarLista() {
        
        PessoaFisica pf1 = new PessoaFisica("111.111.111-11", new Date(), 11111, "Raquel Cliente Um PF", 
                "0481111-1111", "raquel@pfemail", new Date(), new Pontuacao(100));
        pf1.add(VeiculoDS.getListaVeiculos().get(0));
        pf1.add(VeiculoDS.getListaVeiculos().get(1));

        PessoaFisica pf2 = new PessoaFisica("222.222.22-22", new Date(), 22222, "Maria Cliente Dois PF", 
                "0482222-2222", "maria@pfemail", new Date(), new Pontuacao(200));
        pf2.add(VeiculoDS.getListaVeiculos().get(2));
        
        PessoaJuridica pj1 = new PessoaJuridica("3333.33.3.333", "ie333", 33333, "Carlos Cliente Tres PJ", 
                "0483333-3333", "carlos@pjemail", new Date(), new Pontuacao(300));
        pj1.add(VeiculoDS.getListaVeiculos().get(3));
        pj1.add(VeiculoDS.getListaVeiculos().get(4));
        

        add(pf1);
        add(pf2);
        add(pj1);

    }
   

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void setListaClientes(List<Cliente> listaClientes) {
        ClienteDS.listaClientes = listaClientes;
    }
    
    public static void add(Cliente cliente) {
        listaClientes.add(cliente);
    }
    
    public static void remove(Cliente cliente) {
        listaClientes.remove(cliente);
    }
    
    public static Cliente getPorId(int id) throws DataSourceException {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        throw new DataSourceException("Cliente não encontrado!");
    }
    
    public static List<Cliente> getPorNome(String nome) {    
        List<Cliente> clientes = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            if (cliente.getNome().contains(nome)) {
                clientes.add(cliente);
            }
        }
        return clientes; 
    }

    
}
