package model;

import java.util.List;



import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}