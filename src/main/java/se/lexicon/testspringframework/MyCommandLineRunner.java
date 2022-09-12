package se.lexicon.testspringframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import se.lexicon.testspringframework.data.AppUserDAO;
import se.lexicon.testspringframework.data.TodoItemDAO;
import se.lexicon.testspringframework.model.Address;
import se.lexicon.testspringframework.model.AppUser;
import se.lexicon.testspringframework.model.TodoItem;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserDAO appUsrDao;
    @Autowired
    TodoItemDAO todoDao;

    @Override
    public void run(String... args) throws Exception {
        AppUser tmp = new AppUser(0, "Test Testsson",
                "test",
                "testsson",
                LocalDate.of(1982,07,18),
                true,
                "Testpass");
        Address addr = new Address("Test", "Test", "Testcity");
        tmp.addAdress(addr);

        appUsrDao.save(tmp);


        AppUser usr = appUsrDao.findById(1);

        System.out.println("usr = " + usr);

        TodoItem todo = new TodoItem("Todo","Something todo", LocalDateTime.now());
        todoDao.save(todo);
    }
}
