package DAO;

import model.Client;

import java.util.ArrayList;
import java.util.List;

public class JpaClientDao implements Dao<Client>{

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_Properties_Additional_DAO");
    EntityManager em = entityManagerFactory.createEntityManager();

    List<Client> listClient = new ArrayList<>();

    public void save(Client client){
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    public List<Client> getAll(){
        listClient = em.createQuery("from Client").getResultList();
        return listClient;
    }

    public Client getById(int id){
        em.getTransaction().begin();
        Client client = (Client) em.find(Client.class, id);
        return client;
    }

    public void update (Client oldClient, Client newClient){
        oldClient.setName(newClient.getName());
        oldClient.setContractNumber(newClient.getContractNumber());
        oldClient.setBalance(newClient.getBalance());

        try{
            em.merge(oldClient);
            em.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remove(Client client){
        try{
            em.remove(client);
            em.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

}
