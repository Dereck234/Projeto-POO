import java.util.ArrayList;

public class GerenciadorDePratos {
    private ArrayList<Prato> pratos = new ArrayList<>();

    public void cadastrarPrato(Prato prato) {
        if (pratos.stream().anyMatch(p -> p.getNome().equalsIgnoreCase(prato.getNome()))) {
            System.out.println("Erro: Já existe um prato com este nome.");
            return;
        }
        pratos.add(prato);
    }

    public void modificarPrato(String nome, Prato novoPrato) {
        for (int i = 0; i < pratos.size(); i++) {
            if (pratos.get(i).getNome().equalsIgnoreCase(nome)) {
                pratos.set(i, novoPrato);
                return;
            }
        }
        System.out.println("Erro: Prato não encontrado.");
    }

    public void excluirPrato(String nome) {
        if (!pratos.removeIf(p -> p.getNome().equalsIgnoreCase(nome))) {
            System.out.println("Erro: Prato não encontrado.");
        }
    }

    public ArrayList<Prato> listarPratos() {
        return pratos;
    }
}
