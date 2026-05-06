package model;

import exceptions.PrecoInvalidoException;

public class Produto {
    private String descricao;
    private double preco;
    private String categoria;

    public Produto(String descricao, double preco, String categoria) {
        if (preco <= 0) {
            throw new PrecoInvalidoException("Preço deve ser maior que zero!");
        }
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    // GETTERS E SETTERS
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new PrecoInvalidoException("Preço deve ser maior que zero!");
        }
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // toString (somente nome e preço)
    @Override
    public String toString() {
        return "Produto: " + descricao + " | Preço: " + preco;
    }
}