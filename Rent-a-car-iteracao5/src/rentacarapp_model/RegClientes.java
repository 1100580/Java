package rentacarapp_model;

import Hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RegClientes {

    private List<Cliente> clientes = new ArrayList<Cliente>() {
    };
    Scanner in = new Scanner(System.in);

    public RegClientes() {
        loadAllClientesFromDb();
        printList();
    }

    public void loadAllClientesFromDb() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = (Transaction) session.beginTransaction();
        Query query = (Query) session.createQuery("from rentacarapp_model.Cliente cliente "
                + "order by cliente.ida asc");
        List listCliente = query.list();

        for (Iterator iterator = listCliente.iterator(); iterator.hasNext();) {
            Cliente c = (Cliente) iterator.next();
            clientes.add(c);
        }
        
        try {
            tx.commit();
        } catch (Exception ex) {
            Logger.getLogger(RegClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.close();
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
        System.out.println(clientes.get(index).toString());
    }

    public Cliente getIndex(int index) {
        return clientes.get(index);
    }

    private void printList() {
        System.out.println("PRINTING Clientes: \n");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }
}
