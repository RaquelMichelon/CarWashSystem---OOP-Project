/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raqueldarellimichelon
 */
public class PessoaFisica extends Cliente {
    
    private String cpf;
    private Date dataNascimento;

    public PessoaFisica() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String getDados() {        
        StringBuilder sb = new StringBuilder();
        sb.append("\n ** Dados Pessoais ** \n");
        sb.append("\n Nome ======================> ").append(this.getNome());
        sb.append("\n Celular ===================> ").append(this.getCelular());
        sb.append("\n Email =====================> ").append(this.getEmail());
        sb.append("\n\n ** Veículos do Cliente ** \n");
        if (this.getVeiculos() != null) {
            for (Veiculo v : this.getVeiculos()) {
                sb.append("\n\n [ Veículo ").append(this.getVeiculos().indexOf(v) + 1);
                sb.append(" ]");
                sb.append("\n Placa ======================> ").append(v.getPlaca());
                sb.append("\n Modelo =====================> ").append(v.getModelo().getDescricao());
                sb.append("\n Marca ======================> ").append(v.getModelo().getMarca().getNome());
                sb.append("\n Categoria ==================> ").append(v.getModelo().geteCategoria().getDescricao());
                sb.append("\n Cor ========================> ").append(v.getCor().getNome());
            }
        } else {
            sb.append("Não há veículos registrados para este cliente!");
        }
        return sb.toString(); 

    }
   

    @Override
    public String getDados(String observacao) {
        StringBuilder sb = new StringBuilder();
        
        //para formatar a data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        sb.append("\n\n ** Dados Pessoais ** \n");
        sb.append("\n Observação ======================> ").append(observacao);
        sb.append("\n Nome ======================> ").append(this.getNome());
        sb.append("\n ID ========================> ").append(this.getId());
        sb.append("\n CPF =======================> ").append(cpf);
        sb.append("\n Data de Nascimento ========> ").append(sdf.format(dataNascimento));
        sb.append("\n Celular ===================> ").append(this.getCelular());
        sb.append("\n Email =====================> ").append(this.getEmail());
        sb.append("\n Cadastrado no sistema em: => ").append(sdf.format(this.getDataCadastro()));
        sb.append("\n\n ** Veículos do Cliente ** \n");
        if (this.getVeiculos() != null && !this.getVeiculos().isEmpty()) {
            for (Veiculo v : this.getVeiculos()) {
                sb.append("\n [ Veículo ").append(this.getVeiculos().indexOf(v) + 1);
                sb.append(" ]");
                sb.append("\n Placa ======================> ").append(v.getPlaca());
                sb.append("\n Modelo =====================> ").append(v.getModelo().getDescricao());
                sb.append("\n Marca ======================> ").append(v.getModelo().getMarca().getNome());
                sb.append("\n Categoria ==================> ").append(v.getModelo().geteCategoria().getDescricao());
                sb.append("\n Cor ========================> ").append(v.getCor().getNome());
                sb.append("\n Observacoes ================> ").append(v.getObservacoes());
            }
        } else {
            sb.append("Não há veículos registrados para este cliente!");
        }
        return sb.toString();
    }
    
        
    //CRIACAO DE CONSTRUTOR PARA FACILITAR A LIDA COM MOCK DE DADOS
    public PessoaFisica(String cpf, Date dataNascimento, int id, String nome, String celular, String email, Date dataCadastro, List<Veiculo> veiculos, Pontuacao pontuacao) {
        //super para usar o construtor pronto da classe abstrata Cliente
        super(id, nome, celular, email, dataCadastro, veiculos, pontuacao);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    public PessoaFisica(String cpf, Date dataNascimento, int id, String nome, String celular, String email, Date dataCadastro, Pontuacao pontuacao) {
        //super para usar o construtor pronto da classe abstrata Cliente
        super(id, nome, celular, email, dataCadastro, pontuacao);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
}
