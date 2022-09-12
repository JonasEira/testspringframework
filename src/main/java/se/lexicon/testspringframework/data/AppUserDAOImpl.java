package se.lexicon.testspringframework.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.testspringframework.model.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class AppUserDAOImpl implements AppUserDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public AppUser findById(int id) {
        AppUser appUsr = entityManager.find(AppUser.class, id);
        return appUsr;
    }

    @Override
    @Transactional
    public AppUser save(AppUser user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public void delete(AppUser user) {
        entityManager.remove(user);
    }
}
