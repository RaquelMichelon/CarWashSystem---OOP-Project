/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import exceptions.ExceptionLavacao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public class OrdemServico {
    
    private long numero;
    private double total;
    private Date agenda;
    private double desconto;
    
    private EStatus eStatus;
    
    private Veiculo veiculo;
    
    private List<ItemOS> itensOS;

    public OrdemServico() {
        
        this.itensOS = new ArrayList<>();
        
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda) {
        this.agenda = agenda;
    }

    public double getDesconto() {
        return desconto;
    }
    
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public EStatus geteStatus() {
        return eStatus;
    }

    public void seteStatus(EStatus eStatus) {
        this.eStatus = eStatus;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<ItemOS> getItensOS() {
        return itensOS;
    }

    public void setItensOS(List<ItemOS> itensOS) {
        this.itensOS = itensOS;
    }

    
    public double calcularServico()  {                   
            double totalServico = 0;
            for (ItemOS itemOS: itensOS) {

                totalServico += itemOS.getValorServico();
            }

            //REGRA DE NEGOCIO: DESCONTO DE 10% NO MES ANIVERSARIO DE PF
            if(this.veiculo.getCliente() instanceof PessoaFisica) {

                PessoaFisica pf = (PessoaFisica) this.veiculo.getCliente();           
                Date nascimento = pf.getDataNascimento();
                Calendar nasc = Calendar.getInstance();
                nasc.setTime(nascimento);
                int mesNascimento = nasc.get(Calendar.MONTH);

                Calendar dataOS = Calendar.getInstance();
                dataOS.setTime(this.agenda);
                int mesOS = dataOS.get(Calendar.MONTH);

                if (mesNascimento == mesOS) {
                double descontoAniversario = 10 / 100;
                this.desconto += descontoAniversario;            
                }          
            }        
            totalServico -= this.desconto;                
            this.total = totalServico;
            return totalServico;

    }
    
    public void add(ItemOS itemOs) {
        this.itensOS.add(itemOs);
        itemOs.setOrdemServico(this);
    }
    
    public void remove(ItemOS itemOs) {
        this.itensOS.remove(itemOs);
        itemOs.setOrdemServico(null);
    }
    
    
    
    

    public OrdemServico(long numero, Date agenda, double desconto, EStatus eStatus, Veiculo veiculo) {
        this.numero = numero;
        this.agenda = agenda;
        this.desconto = desconto;
        this.eStatus = eStatus;
        this.veiculo = veiculo;
        this.itensOS = new ArrayList<>();
    }

    //metodos para armazenamento e localizacao de dados em estruturas
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.numero ^ (this.numero >>> 32));
        return hash;
    }
    
    //comparar um obj com outro para verificar se está em uma lista

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrdemServico other = (OrdemServico) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "OrdemServico{" + "numero=" + numero + ", total=" + total + ", agenda=" + agenda + ", desconto=" + desconto + ", eStatus=" + eStatus + ", veiculo=" + veiculo + ", itensOS=" + itensOS + '}';
    }

    public String getDados() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t*** ORDEM DE SERVICO ***").append("\n\n");
        sb.append("Cliente: ").append(veiculo.getCliente().getId()).append(" - ").append(veiculo.getCliente().getNome()).append("\n\n");
        sb.append("Veículo: ").append(veiculo.getModelo().getDescricao()).append(" - ").append("Categoria: ").append(veiculo.getModelo().geteCategoria()).append(" - ").append("Placa: ").append(veiculo.getPlaca()).append("\n\n");
        sb.append("===========================================================").append("\n\n");
        sb.append("COD ").append(this.numero).append("       Data: ").append(this.agenda).append("\n\n");
        sb.append("===========================================================").append("\n\n");
        int n = 0;
        int pontosCompra = 0;
        for (ItemOS item: itensOS) {
            sb.append(++n).append("  ").append(item.getServico().getDescricao()).append("\t").
            append("\t\t R$").append(item.getValorServico()).append("\n\n");
            pontosCompra += Servico.getPontos();
            veiculo.getCliente().getPontuacao().adicionar(Servico.getPontos());
        }
        sb.append("Desc.\t\t\t\t\t\t R$").append(desconto).append("\n\n");
        sb.append("===========================================================").append("\n");
        sb.append("Total\t\t\t\t\t\t R$").append(total).append("\n");
        sb.append("===========================================================").append("\n");
        sb.append("\t    Total de Pontos do Cliente: ").append(veiculo.getCliente().getPontuacao().saldo()).append("\n");
        sb.append("\t    Total de Pontos da Compra: ").append(pontosCompra).append("\n");
        sb.append("\n\t\tObrigado pela preferência!!!\n");
        return sb.toString();
    }
    
    
}
