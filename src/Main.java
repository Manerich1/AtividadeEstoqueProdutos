import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String[] nomeprodutos = new String[10];
        double[][] dados = new double[10][3];

        String resposta;
        int contadorProdutos = 0;
        int resID;

        System.out.println("### Bem-vindo ao sistema de estoque da empresa SystemNewTech ###");

        while (true) { // Menu
            System.out.println("""

                        Escolha uma opção abaixo:

                    1 - Cadastrar Produtos
                    2 - Listar Produtos
                    3 - Editar Produto
                    4 - Remover Produto
                    5 - Buscar Produto pelo ID
                    6 - Sair
                    """);

            int escolha = ler.nextInt();

            switch (escolha) {
                case 1: // Cadastrar Produto
                    System.out.println("\n--- Cadastrando Produtos ---");

                    while (true) {
                        ler.nextLine();
                        if (contadorProdutos >= 10) {
                            System.out.println("Limite máximo de cadastro de produtos atingido!");
                            break;
                        }

                        System.out.print("Nome do Produto: ");
                        String nome = ler.nextLine();
                        System.out.print("Quantidade: ");
                        double quantidade = ler.nextDouble();
                        System.out.print("Valor únitario: ");
                        double valorUni = ler.nextDouble();

                        for (int i = 0; i < nomeprodutos.length; i++) { // Procura um lugar vázio no vetor e coloca as informações no vetor (nomeprodutos) e na matriz (dados)
                            if (nomeprodutos[i] == null) {
                                nomeprodutos[i] = nome;
                                dados[i][0] = i + 1; // ID
                                dados[i][1] = quantidade;
                                dados[i][2] = valorUni;
                                System.out.println("\nProduto cadastrado com sucesso");
                                System.out.println("ID do produto = " + dados[i][0]);
                                contadorProdutos++;
                                break;
                            }
                        }

                        System.out.print("Deseja cadastrar outro produto? (S/N): ");
                        resposta = ler.next();

                        if (!resposta.equalsIgnoreCase("S")) {
                            break;
                        } else {
                            System.out.println();
                        }
                    }
                    break;
                case 2: // Listar Produtos
                    System.out.println("--- Listando Produtos ---");

                    int quantProdutos = 0;
                    double quantTotal = 0;
                    double valorTotal = 0;

                    for (int i = 0; i < nomeprodutos.length; i++) {
                        if (nomeprodutos[i] != null) {
                            System.out.println("Produto: " + nomeprodutos[i]);
                            System.out.println("Valor Unitário: " + dados[i][2]);
                            System.out.println("Quantidade: " + dados[i][1]);
                            System.out.println("Valor Total: " + (dados[i][2] * dados[i][1]) + "\n");

                            quantProdutos++;
                            quantTotal += dados[i][1];
                            valorTotal += dados[i][2] * dados[i][1];
                        }
                        if (contadorProdutos == i) {
                            break;
                        }
                    }

                    System.out.println("Quantidade de produtos cadastrados: " + quantProdutos);
                    System.out.println("Quantidade total de produtos: " + quantTotal);
                    System.out.println("Valor total em estoque: " + valorTotal);

                    break;
                case 3: // Editar Produto
                    System.out.println("--- Editando um Produto ---");

                    int escolhaCampo;

                    ler.nextLine();
                    System.out.print("Digite o ID do produto a ser editado: ");
                    resID = ler.nextInt();

                    for (int i = 0; i < nomeprodutos.length; i++) {
                        if (dados[i][0] == resID && resID != 0) {
                            ler.nextLine();

                            System.out.println("\nProduto: " + nomeprodutos[i]);
                            System.out.println("Valor Unitário: " + dados[i][2]);
                            System.out.println("Quantidade: " + dados[i][1]);
                            System.out.println("Valor Total: " + (dados[i][2] * dados[i][1]) + "\n");

                            System.out.println("""
                                    Qual campo desaja editar?
                                    
                                    1 - Nome
                                    2 - Valor Unitário
                                    3 - Quantidade
                                    """);
                            escolhaCampo = ler.nextInt();

                            switch (escolhaCampo) {
                                case 1:
                                    ler.nextLine();
                                    System.out.print("Digite o novo nome: ");
                                    nomeprodutos[i] = ler.nextLine();
                                    break;
                                case 2:
                                    System.out.print("Digite o novo valor unitário: ");
                                    dados[i][2] = ler.nextDouble();
                                    break;
                                case 3:
                                    System.out.print("Digite a nova quantidade: ");
                                    dados[i][1] = ler.nextDouble();
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                            }
                            break;
                        }
                        if (contadorProdutos == i) {
                            System.out.println("\nEste ID não existe no sistema");
                            break;
                        }
                    }

                    break;
                case 4: // Remover Produto
                    System.out.println("--- Removendo um Produto ---");

                    ler.nextLine();
                    System.out.print("Digite o ID do produto a ser removido: ");
                    resID = ler.nextInt();

                    for (int i = 0; i < nomeprodutos.length; i++) {
                        if (dados[i][0] == resID && resID != 0) {
                            ler.nextLine();

                            System.out.println("\nProduto: " + nomeprodutos[i]);
                            System.out.println("Valor Unitário: " + dados[i][2]);
                            System.out.println("Quantidade: " + dados[i][1]);
                            System.out.println("Valor Total: " + (dados[i][2] * dados[i][1]) + "\n");

                            System.out.print("Deseja remover o produto com ID " + dados[i][0] + "? (S/N): ");
                            resposta = ler.nextLine();

                            if (!resposta.equalsIgnoreCase("S")) {
                                System.out.println("O produto de ID " + dados[i][0] + " continua no sistema");
                            } else {
                                nomeprodutos[i] = null;
                                dados[i][0] = 0;
                                dados[i][1] = 0;
                                dados[i][2] = 0;

                                System.out.println("O produto de ID " + resID + " foi removido do sistema");
                                contadorProdutos--;
                            }
                            break;
                        }
                        if (contadorProdutos == i) {
                            System.out.println("\nEste ID não existe no sistema");
                            break;
                        }
                    }

                    break;
                case 5: // Buscar Produto pelo ID
                    System.out.println("--- Buscar Produto pelo ID ---");

                    ler.nextLine();
                    System.out.print("Digite o ID do produto a ser editado: ");
                    resID = ler.nextInt();

                    for (int i = 0; i < nomeprodutos.length; i++) {
                        if (dados[i][0] == resID && resID != 0) {
                            System.out.println("\nProduto: " + nomeprodutos[i]);
                            System.out.println("Valor Unitário: " + dados[i][2]);
                            System.out.println("Quantidade: " + dados[i][1]);
                            System.out.println("Valor Total: " + (dados[i][2] * dados[i][1]));
                            break;
                        }
                        if (contadorProdutos == i) {
                            System.out.println("\nEste ID não existe no sistema");
                            break;
                        }
                    }
                    break;
                case 6: // Sair
                    System.out.println("\nDesligando o Sistema");
                    ler.close();
                    return;
                default:
                    System.out.println("Digite um número válido!");
            }
        }
    }
}