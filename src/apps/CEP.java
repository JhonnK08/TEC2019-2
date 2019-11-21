/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

/**
 *
 * @author Jhonatan
 */
public class CEP {
    private String UF;
    private String cidade;
    private String rua;
    private String codigo;

    public CEP() {
    }

    public CEP(String UF, String cidade, String rua, String codigo) {
        this.UF = UF;
        this.cidade = cidade;
        this.rua = rua;
        this.codigo = codigo;
    }
    
    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
