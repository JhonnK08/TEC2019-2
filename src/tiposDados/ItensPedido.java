package tiposDados;

import javafx.scene.control.Alert;
import javafx.scene.layout.Region;

/**
 *
 * @author Jhonatan
 */
public class ItensPedido {
    private String tamanho;
    private String espessura;
    private String sabor;
    private double valor;

    public ItensPedido() {
    }

    public ItensPedido(String tamanho, String espessura, String sabor, double valor) {
        this.tamanho = tamanho;
        this.espessura = espessura;
        this.sabor = sabor;
        this.valor = valor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getEspessura() {
        return espessura;
    }

    public void setEspessura(String espessura) {
        this.espessura = espessura;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void calcularValor(String tamanho, String espessura, double valor){
        int porcent = 0;
        double valorAntigo = valor;
        
        if (espessura == "Fina") {
            porcent = porcent + 30;
        }
        else if (espessura == "Grossa") {
            porcent = porcent + 10;
        }
        
        if(tamanho == "Pequeno") {
            porcent = porcent + 30;
        }
        else if (tamanho == "Médio") {
            porcent = porcent + 20;
        }
        else if (tamanho == "Grande") {
            porcent = porcent + 10;
            
        }
        valor = valor -((porcent*valor)/100);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setTitle("Valor atualizado");
        alert.setHeaderText(null);
        alert.setContentText("Valor calculado com sucesso!\n\n" + "Valor antigo: " + valorAntigo + "\n"
                + "Desconto + " + porcent + "%\n"
                + "Valor atualizado: " + valor);
        alert.showAndWait();
    }
    
}
