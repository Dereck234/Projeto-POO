public class Main {
    public static void main(String[] args) {
        GerenciadorDePratos gp = new GerenciadorDePratos();
        GerenciadorDeClientes gc = new GerenciadorDeClientes();
        Gerente gerente = new Gerente(gp, gc);

        // Exemplo de uso
        gerente.cadastrarPrato(new Prato("Lasanha", "Massas", 25.0));
        gerente.cadastrarPrato(new Prato("Feijoada", "Tradicional", 30.0));

        gerente.cadastrarCliente(new Cliente("João", "99999-9999"));
        gerente.cadastrarCliente(new Cliente("Maria", "88888-8888"));

        System.out.println("Pratos:");
        for (Prato p : gp.listarPratos()) {
            System.out.println(p);
        }

        System.out.println("\nClientes:");
        for (Cliente c : gc.listarClientes()) {
            System.out.println(c);
        }

        // Modificar exemplo
        gerente.modificarPrato("Lasanha", new Prato("Lasanha de Frango", "Massas", 27.0));
        gerente.excluirCliente("Maria");

        System.out.println("\nApós alterações:");
        System.out.println("Pratos:");
        for (Prato p : gp.listarPratos()) {
            System.out.println(p);
        }

        System.out.println("\nClientes:");
        for (Cliente c : gc.listarClientes()) {
            System.out.println(c);
        }
    }
}
