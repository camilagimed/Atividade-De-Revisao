package service;

import model.Produto;

import java.util.*;
import java.util.stream.Collectors;

public class PedidoService {

    // 1. nomes sem duplicidade
    public List<String> nomesSemDuplicados(List<Produto> produtos) {
        return produtos.stream()
                .map(Produto::getDescricao)
                .distinct()
                .collect(Collectors.toList());
    }

    // 2. nome + preço (Map)
    public Map<String, Double> nomePrecos(List<Produto> produtos) {
        return produtos.stream()
                .collect(Collectors.toMap(
                        Produto::getDescricao,
                        Produto::getPreco,
                        (p1, p2) -> p1 // resolve duplicados
                ));
    }

    // 3. produtos com preço maior que X
    public List<Produto> produtosMaisCarosQue(List<Produto> produtos, double valor) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() > valor)
                .collect(Collectors.toList());
    }

    // 4. produto mais caro
    public Produto maisCaro(List<Produto> produtos) {
        return produtos.stream()
                .max(Comparator.comparingDouble(Produto::getPreco))
                .orElse(null);
    }

    // 5. produto mais barato
    public Produto maisBarato(List<Produto> produtos) {
        return produtos.stream()
                .min(Comparator.comparingDouble(Produto::getPreco))
                .orElse(null);
    }

    // 6. soma dos preços
    public double somaPrecos(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }

    // 7. média dos preços
    public double mediaPrecos(List<Produto> produtos) {
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average()
                .orElse(0.0);
    }

    // 8. agrupar por categoria
    public Map<String, List<Produto>> agruparPorCategoria(List<Produto> produtos) {
        return produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));
    }
}