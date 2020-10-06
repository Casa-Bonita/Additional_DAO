package DAO;

import model.Client;
import model.Passport;

import java.util.ArrayList;
import java.util.List;

public class JpaPassportDao implements Dao<Passport> {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA_Properties_Additional_DAO");
    EntityManager em = entityManagerFactory.createEntityManager();

    List<Passport> listPassport = new ArrayList<>();

    public void save (Passport passport){
        em.getTransaction().begin();
        em.merge(passport);
        em.getTransaction().commit();
    }

    public List<Passport> getAll(){
        listPassport = em.createQuery("from Passport").getResultList();
        return listPassport;
    }

    public Passport getById(int id){
        em.getTransaction().begin();
        Passport passport = (Passport) em.find(Passport.class, id);
        return passport;
    }

    public void update(Passport oldPassport, Passport newPassport){
        oldPassport.setSeries(newPassport.getSeries());
        oldPassport.setNumber(newPassport.getNumber());
        oldPassport.setHolderName(newPassport.getHolderName());
        oldPassport.setYear(newPassport.getYear());
        oldPassport.setCountry(newPassport.getCountry());

        try{
            em.merge(oldPassport);
            em.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void remove(Passport passport){
        try{
            em.remove(passport);
            em.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex);
            ex.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
