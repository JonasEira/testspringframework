package se.lexicon.testspringframework.data;

import org.springframework.stereotype.Repository;
import se.lexicon.testspringframework.model.TodoItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TodoItemDAOImpl implements TodoItemDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Optional<TodoItem> findById(UUID uuid) {
        TodoItem tmp = entityManager.find(TodoItem.class, uuid);
        Optional<TodoItem> result = Optional.of(tmp);
        return result;
    }
    @Transactional
    @Override
    public TodoItem save(TodoItem todo) {
        entityManager.persist(todo);
        return todo;
    }

    @Transactional
    @Override
    public TodoItem update(TodoItem todoItem) {
        entityManager.merge(todoItem);
        return todoItem;
    }

    @Transactional
    @Override
    public void delete(TodoItem todo) {
        entityManager.remove(todo);
    }
}
