package DAO;

import model.Passport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListPassportDao implements Dao<Passport>{

    List<Passport> listPassport = new ArrayList<>();

    public void save (Passport passport){
        listPassport.add(passport);
    }

    public List<Passport> getAll(){
        return listPassport;
    }

//    public Passport getById(int id){
//        for (int i = 0; i < listPassport.size(); i++) {
//            if(id == listPassport.get(i).getId()){
//                return listPassport.get(i);
//            }
//        }
//        return null;
//    }

    public Passport getById (int id){
        Optional <Passport> optional = listPassport.stream().filter(passport -> passport.getId() == id).findFirst();
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public void update(Passport oldPassport, Passport newPassport){
        oldPassport.setSeries(newPassport.getSeries());
        oldPassport.setNumber(newPassport.getNumber());
        oldPassport.setHolderName(newPassport.getHolderName());
        oldPassport.setYear(newPassport.getYear());
        oldPassport.setCountry(newPassport.getCountry());
        save(oldPassport);
    }

    public void remove(Passport deletedPassport){
        int id = deletedPassport.getId();
        listPassport.remove(id);
    }


}
