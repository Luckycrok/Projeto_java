package projeto.src.main.java.com.mycompany.projeto;

import java.util.List;
import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) {
        ControleDeEstoque controleDeEstoque = new ControleDeEstoque();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Digite o número da opção desejada:");
                System.out.println("1 - Adicionar produto");
                System.out.println("2 - Remover produto");
                System.out.println("3 - Listar produtos");
                System.out.println("4 - Sair");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o nome do produto:");
                        String nome = scanner.next();
                        System.out.println("Digite a descrição do produto:");
                        String descricao = scanner.next();
                        System.out.println("Digite a quantidade do produto:");
                        int quantidade = scanner.nextInt();
                        System.out.println("Digite o preço do produto:");
                        double preco = scanner.nextDouble();

                        Produto produto1 = new Produto(nome, descricao, quantidade, preco);
                        controleDeEstoque.adicionarProduto(produto1);
                        break;

                    case 2:
                        System.out.println("Digite o nome do produto que deseja remover:");
                        String nomeProdutoRemover = scanner.next();
                        controleDeEstoque.removerProduto(nomeProdutoRemover);
                        break;

                    case 3:
                        List<Produto> produtos = controleDeEstoque.listarProdutos();
                        for (Produto produto : produtos) {
                            System.out.println(produto);
                        }
                        break;

                    case 4:
                        System.out.println("Saindo...");
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            }
        }
    }
}