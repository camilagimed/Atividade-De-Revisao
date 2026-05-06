import model.Produto;
import model.Pedido;
import service.PedidoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pedido pedido = new Pedido();

        
        pedido.adicionarProduto(new Produto("Arroz", 20.0, "Alimento"));
        pedido.adicionarProduto(new Produto("Feijão", 10.0, "Alimento"));
        pedido.adicionarProduto(new Produto("Notebook", 3000.0, "Eletronico"));
        pedido.adicionarProduto(new Produto("Mouse", 50.0, "Eletronico"));
        pedido.adicionarProduto(new Produto("Arroz", 25.0, "Alimento")); // duplicado

        PedidoService service = new PedidoService();

        List<Produto> produtos = pedido.getProdutos();

        System.out.println("TODOS OS PRODUTOS");
        produtos.forEach(System.out::println);

        System.out.println(" NOMES SEM DUPLICIDADE ");
        System.out.println(service.nomesSemDuplicados(produtos));

        System.out.println("NOME E PREÇO");
        System.out.println(service.nomePrecos(produtos));

        System.out.println(" PRODUTOS > 50 ");
        System.out.println(service.produtosMaisCarosQue(produtos, 50));

        System.out.println(" PRODUTO MAIS CARO");
        System.out.println(service.maisCaro(produtos));

        System.out.println("PRODUTO MAIS BARATO");
        System.out.println(service.maisBarato(produtos));

        System.out.println("SOMA DOS PREÇOS");
        System.out.println(service.somaPrecos(produtos));

        System.out.println("MÉDIA DOS PREÇOS");
        System.out.println(service.mediaPrecos(produtos));

        System.out.println(" AGRUPADOS POR CATEGORIA");
        System.out.println(service.agruparPorCategoria(produtos));
    }
}
