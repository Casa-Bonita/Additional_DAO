package service;

import DAO.Dao;
import DAO.JpaClientDao;
import DAO.ListClientDao;
import model.Client;

import java.util.List;

public class ClientService {

    Dao<Client> dao = new ListClientDao();
    //JpaClientDao jcd = new JpaClientDao();

    public void save (Client client){
        dao.save(client);
    }

    public List<Client> getAll(){
        return dao.getAll();
    }

    public Client getById(int id){
        return dao.getById(id);
    }

    public void update(Client oldClient, Client newClient){
        dao.update(oldClient, newClient);
    }

    public void remove(Client deletedClient){
        dao.remove(deletedClient);
    }
}
