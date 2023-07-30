import com.wjq.test.Todo
import com.wjq.test.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl implements TodoService{
    @Autowired
    def todoRepository;

    @Override
    List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    Todo findById(Integer todoId) {
        return null
    }

    @Override
    Todo saveTodo(Todo todo) {
        return null
    }

    @Override
    Todo updateTodo(Todo todo) {
        return null
    }

    @Override
    Todo deleteTodo(Integer todoId) {
        return null
    }
}
