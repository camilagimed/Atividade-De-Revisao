package service;

import model.Produto;

import java.util.*;
import java.util.stream.Collectors;

public class PedidoService {

   
    public List<String> nomesSemDuplicados(List<Produto> produtos) {
        return produtos.stream()
                .map(Produto::getDescricao)
                .distinct()
                .collect(Collectors.toList());
    }

    
    public Map<String, Double> nomePrecos(List<Produto> produtos) {
        return produtos.stream()
                .collect(Collectors.toMap(
                        Produto::getDescricao,
                        Produto::getPreco,
                        (p1, p2) -> p1 
                ));
    }

    
    public List<Produto> produtosMaisCarosQue(List<Produto> produtos, double valor) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() > valor)
                .collect(Collectors.toList());
    }

    public Produto maisCaro(List<Produto> produtos) {
        return produtos.stream()
                .max(Comparator.comparingDouble(Produto::getPreco))
                .orElse(null);
    }

    
    public Produto maisBarato(List<Produto> produtos) {
        return produtos.stream()
                .min(Comparator.comparingDouble(Produto::getPreco))
                .orElse(null);
    }

    public double somaPrecos(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }

   
    public double mediaPrecos(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average()
                .orElse(0.0);
    }

    
    public Map<String, List<Produto>> agruparPorCategoria(List<Produto> produtos) {
        return produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));
    }
}
