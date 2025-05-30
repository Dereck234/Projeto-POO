import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDePratos gp = new GerenciadorDePratos();
        GerenciadorDeClientes gc = new GerenciadorDeClientes();
        Gerente gerente = new Gerente(gp, gc);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Cadastrar prato");
                System.out.println("2. Modificar prato");
                System.out.println("3. Listar pratos");
                System.out.println("4. Cadastrar cliente");
                System.out.println("5. Excluir cliente");
                System.out.println("6. Listar clientes");
                System.out.println("7. Sair\n");
                System.out.print("Escolha uma opção: ");
                int opcao = lerInteiro(scanner);

                switch (opcao) {
                    case 1:
                        gerente.cadastrarPrato(lerPrato(scanner));
                        System.out.println("\nPrato cadastrado com sucesso!\n");
                        break;

                    case 2:
                        System.out.print("\nNome do prato a modificar: ");
                        String pratoAntigo = lerTexto(scanner);
                        gerente.modificarPrato(pratoAntigo, lerPrato(scanner));
                        System.out.println("\nPrato modificado com sucesso!\n");
                        break;

                    case 3:
                        listarItens("Pratos", gp.listarPratos());
                        break;

                    case 4:
                        gerente.cadastrarCliente(lerCliente(scanner));
                        System.out.println("\nCliente cadastrado com sucesso!\n");
                        break;

                    case 5:
                        System.out.print("\nNome do cliente a excluir: ");
                        String clienteExcluir = lerTexto(scanner);
                        gerente.excluirCliente(clienteExcluir);
                        System.out.println("\nCliente excluído com sucesso!\n");
                        break;

                    case 6:
                        listarItens("Clientes", gc.listarClientes());
                        break;

                    case 7:
                        System.out.println("\nSaindo...\n");
                        scanner.close();
                        return;

                    default:
                        System.out.println("\nOpção inválida! Por favor, escolha uma opção entre 1 e 7.\n");
                }
            } catch (Exception e) {
                System.out.println("\nOcorreu um erro: " + e.getMessage() + "\n");
                scanner.nextLine(); // Consumir entrada inválida
            }
        }
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("\nEntrada inválida! Por favor, insira um número.\n");
            scanner.nextLine(); // Consumir entrada inválida
        }
        int valor = scanner.nextInt();
        if (scanner.hasNextLine()) scanner.nextLine(); // Consumir nova linha para evitar problemas
        return valor;
    }

    private static double lerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("\nEntrada inválida! Por favor, insira um número.\n");
            scanner.nextLine(); // Consumir entrada inválida
        }
        double valor = scanner.nextDouble();
        if (scanner.hasNextLine()) scanner.nextLine(); // Consumir nova linha para evitar problemas
        return valor;
    }

    private static String lerTexto(Scanner scanner) {
        String texto;
        do {
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("\nÉ necessário inserir algo aqui.\n");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static Prato lerPrato(Scanner scanner) {
        System.out.print("\nNome do prato: ");
        String nome = lerTexto(scanner);
        System.out.print("\nCategoria do prato: ");
        String categoria = lerTexto(scanner);
        System.out.print("\nPreço do prato: ");
        double preco = lerDouble(scanner);
        return new Prato(nome, categoria, preco);
    }

    private static Cliente lerCliente(Scanner scanner) {
        System.out.print("\nNome do cliente: ");
        String nome = lerTexto(scanner);
        System.out.print("\nTelefone do cliente: ");
        String telefone = lerTexto(scanner);
        return new Cliente(nome, telefone);
    }

    private static <T> void listarItens(String titulo, Iterable<T> itens) {
        System.out.println("\n" + titulo + ":");
        if (!itens.iterator().hasNext()) {
            System.out.println("\nNenhum " + titulo.toLowerCase() + " cadastrado.\n");
        } else {
            for (T item : itens) {
                System.out.println(item);
            }
            System.out.println();
        }
    }
}
