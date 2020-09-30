package DAO;

import model.Client;
import java.util.*;

public class ListClientDao implements Dao<Client>{

    List<Client> listClient = new ArrayList<>();

    public void save(Client client){
        listClient.add(client);
    }

    public List<Client> getAll(){
        return listClient;
    }

//    public Client getById(int id){
//        for (int i = 0; i < listClient.size(); i++) {
//            if(id == listClient.get(i).getId()){
//                return listClient.get(i);
//            }
//        }
//        return null;
//    }

    public Client getById(int id){
        Optional <Client> opt = listClient.stream().filter(client -> client.getId() == id).findFirst();
        if(opt.isPresent()){
            return opt.get();
        }
        return null;
    }

    public void update (Client oldClient, Client newClient){
        Client client = getById(oldClient.getId());
        client.setName(oldClient.getName());
        client.setContractNumber(oldClient.getContractNumber());
        client.setBalance(oldClient.getBalance());
        save(client);
    }

    public void remove(Client deletedClient){
        int id = deletedClient.getId();
        listClient.remove(id);
    }
}
