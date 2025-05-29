import java.util.List;

public class Main 
{
    public static void main(String[] args) 
    {
        // Inicialização do gerente do restaurante.
        GerenteRestaurante gerente = new GerenteRestaurante();

        // --- Gerente cadastra pratos ---
        gerente.cadastrarPrato("Salada Caesar", Category.APPETIZER, 12.50);
        gerente.cadastrarPrato("Picanha Grelhada", Category.MAIN_COURSE, 45.00);
        gerente.cadastrarPrato("Cheesecake", Category.DESSERT, 18.00);

        // --- Gerente cadastra clientes ---
        gerente.cadastrarCliente("Joao Silva", "(85) 99999-0000");
        gerente.cadastrarCliente("Maria Santos", "(85) 98888-1111");

        // --- Garçom registra pedido ---
        try 
        {
            int clienteIdJoao = gerente.getClienteIdByName("Joao Silva"); // Método fictício
            if (clienteIdJoao != -1) 
            {
                int pedidoId = gerente.criarPedido(clienteIdJoao);
                gerente.adicionarPratoAoPedido(pedidoId, "Salada Caesar");
                gerente.adicionarPratoAoPedido(pedidoId, "Picanha Grelhada");

                // --- Garçom altera status ---
                gerente.atualizarStatusPedido(pedidoId, StatusPedido.PREPARING);

                // --- Cliente consulta cardápio ---
                List<Prato> entradas = gerente.consultarPratosPorCategoria(Category.APPETIZER);
                System.out.println("--- Aperitivos ---");
                entradas.forEach(prato -> System.out.println(prato.getName() + " - R$" + String.format("%.2f", prato.getPrice())));

                // --- Cliente consulta status do pedido ---
                StatusPedido statusAtual = gerente.consultarStatusPedido(pedidoId);
                System.out.println("\n--- Status do pedido " + pedidoId + ": " + statusAtual + " ---");

                // --- Gerente consulta pedidos por status ---
                List<Pedido> pedidosEmPreparo = gerente.consultarPedidosPorStatus(StatusPedido.PREPARING);
                System.out.println("\n--- Pedidos em preparo ---");
                pedidosEmPreparo.forEach(pedido -> System.out.println("Pedido ID: " + pedido.getId() + ", Status: " + pedido.getStatus()));
            } 

            else 
            {
                System.out.println("Cliente 'Joao Silva' não encontrado.");
            }

        } 
        
        catch (IllegalArgumentException e) 
        {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}