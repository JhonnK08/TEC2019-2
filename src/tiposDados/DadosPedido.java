package tiposDados;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jhonatan
 */
public class DadosPedido {
    private Date dataPedido;
    private String nomeCliente;
    private String endereco;
    private String telefone;
    private ArrayList<ItensPedido> itens;

    public DadosPedido() {
    }

    public DadosPedido(Date dataPedido, String nomeCliente, String endereco, String telefone, ArrayList<ItensPedido> itens) {
        this.dataPedido = dataPedido;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.telefone = telefone;
        this.itens = itens;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<ItensPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItensPedido> itens) {
        this.itens = itens;
    }
    
    
}
