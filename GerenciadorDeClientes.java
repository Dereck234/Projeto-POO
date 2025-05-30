import java.util.ArrayList;

public class GerenciadorDeClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        if (clientes.stream().anyMatch(c -> c.getNome().equalsIgnoreCase(cliente.getNome()))) {
            System.out.println("Erro: Já existe um cliente com este nome.");
            return;
        }
        clientes.add(cliente);
    }

    public void modificarCliente(String nome, Cliente novoCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equalsIgnoreCase(nome)) {
                clientes.set(i, novoCliente);
                return;
            }
        }
        System.out.println("Erro: Cliente não encontrado.");
    }

    public void excluirCliente(String nome) {
        if (!clientes.removeIf(c -> c.getNome().equalsIgnoreCase(nome))) {
            System.out.println("Erro: Cliente não encontrado.");
        }
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }
}
