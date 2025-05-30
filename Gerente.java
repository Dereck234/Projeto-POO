import java.util.ArrayList;
import java.util.List;

// Classe Prato
class Prato {
    private String nome;
    private double preco;

    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

// Classe Cliente
class Cliente {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}

// Classe GerenciadorDePratos.
class GerenciadorDePratos {
    private List<Prato> pratos = new ArrayList<>();

    public void cadastrarPrato(Prato prato) {
        pratos.add(prato);
        System.out.println("Prato cadastrado: " + prato.getNome());
    }

    public void modificarPrato(String nome, Prato novoPrato) {
        for (int i = 0; i < pratos.size(); i++) {
            if (pratos.get(i).getNome().equals(nome)) {
                pratos.set(i, novoPrato);
                System.out.println("Prato modificado: " + nome + " -> " + novoPrato.getNome());
                return;
            }
        }
        System.out.println("Prato não encontrado.");
    }

    public void excluirPrato(String nome) {
        pratos.removeIf(prato -> prato.getNome().equals(nome));
        System.out.println("Prato excluído: " + nome);
    }
}

// Classe GerenciadorDeClientes
class GerenciadorDeClientes {
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado: " + cliente.getNome());
    }

    public void modificarCliente(String nome, Cliente novoCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(nome)) {
                clientes.set(i, novoCliente);
                System.out.println("Cliente modificado: " + nome + " -> " + novoCliente.getNome());
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public void excluirCliente(String nome) {
        clientes.removeIf(cliente -> cliente.getNome().equals(nome));
        System.out.println("Cliente excluído: " + nome);
    }
}

// Classe Gerente
class Gerente {
    private GerenciadorDePratos gerenciadorDePratos;
    private GerenciadorDeClientes gerenciadorDeClientes;

    public Gerente(GerenciadorDePratos gp, GerenciadorDeClientes gc) {
        this.gerenciadorDePratos = gp;
        this.gerenciadorDeClientes = gc;
    }

    public void cadastrarPrato(Prato prato) {
        gerenciadorDePratos.cadastrarPrato(prato);
    }

    public void modificarPrato(String nome, Prato novoPrato) {
        gerenciadorDePratos.modificarPrato(nome, novoPrato);
    }

    public void excluirPrato(String nome) {
        gerenciadorDePratos.excluirPrato(nome);
    }

    public void cadastrarCliente(Cliente cliente) {
        gerenciadorDeClientes.cadastrarCliente(cliente);
    }

    public void modificarCliente(String nome, Cliente novoCliente) {
        gerenciadorDeClientes.modificarCliente(nome, novoCliente);
    }

    public void excluirCliente(String nome) {
        gerenciadorDeClientes.excluirCliente(nome);
    }
}

// Classe principal pra execução do código
public class Main {
    public static void main(String[] args) {
        GerenciadorDePratos gerenciadorDePratos = new GerenciadorDePratos();
        GerenciadorDeClientes gerenciadorDeClientes = new GerenciadorDeClientes();
        Gerente gerente = new Gerente(gerenciadorDePratos, gerenciadorDeClientes);

        // Criando pratos
        Prato prato1 = new Prato("Feijoada", 25.90);
        Prato prato2 = new Prato("Moqueca", 29.90);

        // Criando clientes
        Cliente cliente1 = new Cliente("João", "1234-5678");
        Cliente cliente2 = new Cliente("Maria", "8765-4321");

        // Cadastrando pratos e clientes
        gerente.cadastrarPrato(prato1);
        gerente.cadastrarPrato(prato2);
        gerente.cadastrarCliente(cliente1);
        gerente.cadastrarCliente(cliente2);

        // Modificar prato
        gerente.modificarPrato("Feijoada", new Prato("Feijoada Especial", 30.00));

        // Excluir cliente
        gerente.excluirCliente("Maria");
    }
}