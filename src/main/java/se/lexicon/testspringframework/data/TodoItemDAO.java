package se.lexicon.testspringframework.data;

import se.lexicon.testspringframework.model.TodoItem;

import java.util.Optional;
import java.util.UUID;

public interface TodoItemDAO {
    Optional<TodoItem> findById(UUID uuid);
    TodoItem save(TodoItem todo);
    TodoItem update(TodoItem todoItem);
    void delete(TodoItem todo);

}
