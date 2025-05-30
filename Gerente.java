public class Gerente {
    private GerenciadorDePratos gerenciadorDePratos;
    private GerenciadorDeClientes gerenciadorDeClientes;

    public Gerente(GerenciadorDePratos gp, GerenciadorDeClientes gc) {
        this.gerenciadorDePratos = gp;
        this.gerenciadorDeClientes = gc;
    }

    // Métodos do gerente: só chamam os gerenciadores
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
