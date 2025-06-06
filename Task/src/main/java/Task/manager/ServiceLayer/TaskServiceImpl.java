package Task.manager.ServiceLayer;

import Task.manager.Entity.Status;
import Task.manager.Entity.Task;
import Task.manager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        // Set default status if not provided
        if (task.getStatus() == null) {
            task.setStatus(Status.PENDING);
        }
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task existing = getTaskById(id);
        existing.setDescription(updatedTask.getDescription());
        if (updatedTask.getStatus() != null) {
            existing.setStatus(updatedTask.getStatus());
        }
        return taskRepository.save(existing);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
