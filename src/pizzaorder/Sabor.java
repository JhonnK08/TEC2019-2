/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorder;

/**
 *
 * @author Jhonatan
 */
public class Sabor {
    private String nome;
    private String itens;
    private double preco;

    public Sabor(String nome, String itens, double preco) {
        this.nome = nome;
        this.itens = itens;
        this.preco = preco;
    }

    public Sabor() {
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return this.getNome() + " - "+ this.getPreco(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
