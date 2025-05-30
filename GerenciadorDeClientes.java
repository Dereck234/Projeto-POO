import java.util.ArrayList;

public class GerenciadorDeClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void modificarCliente(String nome, Cliente novoCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equalsIgnoreCase(nome)) {
                clientes.set(i, novoCliente);
                break;
            }
        }
    }

    public void excluirCliente(String nome) {
        clientes.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }
}
