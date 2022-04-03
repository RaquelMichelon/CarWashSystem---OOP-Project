/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


import java.util.Objects;

/**
 *
 * @author raqueldarellimichelon
 */
public class ItemOS {
    
    private double valorServico;
    private String observacoes;
    
    private Servico servico;
    private OrdemServico ordemServico;
    

    public double getValorServico() {
        return valorServico;
    }
    
    public void setValorServico(double valorServico) {
        
        this.valorServico = valorServico;

        //REGRA DE NEGOCIO: O VALOR PARA CADA ITEM PODE SER CONFORME A CATEGORIA DO VEICULO
        
        String categoriaVeiculo = this.ordemServico.getVeiculo().getModelo().geteCategoria().getDescricao();
        
        if (categoriaVeiculo.equalsIgnoreCase("pequeno")) {
            this.valorServico -= 5;
        } else if (categoriaVeiculo.equalsIgnoreCase("medio")) {
            this.valorServico += 5;
        } else if (categoriaVeiculo.equalsIgnoreCase("grande")) {
            this.valorServico += 10;
        } else if (categoriaVeiculo.equalsIgnoreCase("moto")) {
            this.valorServico -= 10;
        }
       

        //REGRA DE NEGOCIO: O VALOR DE UM ITEMOS PODE VARIAR CASO SEJA CEDIDO ALGUM TIPO DE DESCONTO PARA CLIENTE CORPORATIVO
        //para PessoaJuridica conceder desconto de 20% por servico
        
        if(this.ordemServico.getVeiculo().getCliente() instanceof PessoaJuridica) {
            
            double descontoPJ = 20 / 100;
            this.ordemServico.setDesconto(descontoPJ);
            this.valorServico -= this.ordemServico.getDesconto();           
        }
  
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }
    
    //PARA FACILITAR O MOCK
    public ItemOS(String observacoes, Servico servico, OrdemServico ordemServico) {
        this.observacoes = observacoes;
        this.servico = servico;
        this.ordemServico = ordemServico;
    }

    public ItemOS() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valorServico) ^ (Double.doubleToLongBits(this.valorServico) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.servico);
        hash = 59 * hash + Objects.hashCode(this.ordemServico);
        return hash;
    }

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
        final ItemOS other = (ItemOS) obj;
        if (Double.doubleToLongBits(this.valorServico) != Double.doubleToLongBits(other.valorServico)) {
            return false;
        }
        if (!Objects.equals(this.servico, other.servico)) {
            return false;
        }
        if (!Objects.equals(this.ordemServico, other.ordemServico)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ItemOS{valorServico=").append(valorServico);
        sb.append(", observacoes=").append(observacoes);
        sb.append(", servico=").append(servico);
        sb.append(", ordemServico=").append(ordemServico);
        sb.append('}');
        return sb.toString();
    }
    
    

    
}
