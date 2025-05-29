import java.util.List;


public class Main {
    public static void main(String[] args) {
        Cardapio cardapio = new Cardapio();
        GerenteRestaurante gerente = new GerenteRestaurante(cardapio);

        // Gerente cadastra pratos
        cardapio.addPrato(new Prato("Salada Caesar", Category.APPETIZER, 12.50));
        cardapio.addPrato(new Prato("Picanha Grelhada", Category.MAIN_COURSE, 45.00));
        cardapio.addPrato(new Prato("Cheesecake", Category.DESSERT, 18.00));

        // Gerente cadastra clientes
        gerente.addCliente(new Cliente("Joao Silva", "(85) 99999-0000"));
        gerente.addCliente(new Cliente("Maria Santos", "(85) 98888-1111"));

        // Garcom registra pedido
        Pedido p1 = gerente.createPedido(1);
        p1.addPrato(cardapio.listAll().get(0));
        p1.addPrato(cardapio.listAll().get(1));

        // Garcom altera status
        gerente.updateStatusPedido(p1.getId(), StatusPedido.PREPARING);

        // Cliente consulta cardapio
        List<Prato> entradas = cardapio.filterByCategory(Category.APPETIZER);
        System.out.println("Appetizers: " + entradas);

        // Cliente consulta status do pedido
        System.out.println("Status do pedido " + p1.getId() + ": " + p1.getStatus());

        // Gerente consulta pedidos por status
        List<Pedido> prep = gerente.filterPedidosByStatus(StatusPedido.PREPARING);
        System.out.println("Pedidos em preparo: " + prep);
    }
}