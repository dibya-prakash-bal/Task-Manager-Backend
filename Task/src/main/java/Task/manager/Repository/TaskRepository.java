package Task.manager.Repository;

import Task.manager.Entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
