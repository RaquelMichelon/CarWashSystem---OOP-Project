/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.text.SimpleDateFormat;

/**
 *
 * @author raqueldarellimichelon
 */
public class Relatorio {
    
    //DECLAREI IMPRIMIR COMO ESTÁTICO, POIS ELE NAO SE MODIFICA
    public static String imprimir(Cliente cliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n ** Dados Gerais ** \n");
        sb.append("\n ID ========================> ").append(cliente.getId());
        sb.append("\n Nome ======================> ").append(cliente.getNome());
        sb.append("\n Celular ===================> ").append(cliente.getCelular());
        sb.append("\n Email =====================> ").append(cliente.getEmail());
        sb.append("\n Cadastrado no sistema em: => ").append(sdf.format(cliente.getDataCadastro()));

        if (cliente instanceof PessoaFisica) {
            sb.append("\n CPF =======================> ").append(((PessoaFisica)cliente).getCpf());
            sb.append("\n Data de Nascimento ========> ").append(sdf.format(((PessoaFisica)cliente).getDataNascimento()));
        } else {    
            sb.append("\n CNPJ =======================> ").append(((PessoaJuridica)cliente).getCnpj());
            sb.append("\n Insc. Estadual Número ======> ").append(((PessoaJuridica)cliente).getInscricaoEstadual());
        }
        sb.append("\n\n ** Veículos do Cliente ** \n");
        if (cliente.getVeiculos() != null && !cliente.getVeiculos().isEmpty()) {
            for (Veiculo v : cliente.getVeiculos()) {
                sb.append("\n [ Veículo ").append(cliente.getVeiculos().indexOf(v) + 1);
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
        sb.append("\n\n ** PONTUAÇÃO NO PROGRAMA FIDELIDADE ** \n");
        sb.append("\n Quantidade de pontos ===============> ").append(cliente.getPontuacao().saldo());
        return sb.toString();
    }
    
}
