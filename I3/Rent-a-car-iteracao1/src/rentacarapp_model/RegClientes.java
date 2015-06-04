package rentacarapp_model;

import java.util.List;
import java.util.Scanner;

public class RegClientes {

    private List<Cliente> clientes;
    Scanner in = new Scanner(System.in);

    public RegClientes() {
    }

    public void criaCliente(int id, int telefone, String nome, String rua, int numero) {
        Cliente c = new Cliente(id, telefone, nome, rua, numero);
        addCliente(c);
    }

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void alterarID(int id) {
        
    }

    public int procurarID(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void printIndex(int index) {
        clientes.get(index).toString();
    }

    public Cliente getIndex(int index) {
        return clientes.get(index);
    }
}
