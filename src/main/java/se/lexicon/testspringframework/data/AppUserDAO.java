package se.lexicon.testspringframework.data;

import se.lexicon.testspringframework.model.AppUser;

public interface AppUserDAO {
    AppUser findById(int id);
    AppUser save(AppUser user);
    void delete(AppUser user);
}
