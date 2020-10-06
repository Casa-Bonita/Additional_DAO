package service;

import DAO.Dao;
import DAO.ListPassportDao;
import model.Passport;

import java.util.List;

public class PassportService {

    Dao<Passport> dao = new ListPassportDao();
    // Dao<Passport> dao = new JpaPassportDaO();

    public void save(Passport passport){
        dao.save(passport);
    }

    public List<Passport> getAll(){
        return dao.getAll();
    }

    public Passport getById(int id){
        return dao.getById(id);
    }

    public void update(Passport oldPassport, Passport newPassport){
        dao.update(oldPassport, newPassport);
    }

    public void remove(Passport deletedPassport){
        dao.remove(deletedPassport);
    }
}
