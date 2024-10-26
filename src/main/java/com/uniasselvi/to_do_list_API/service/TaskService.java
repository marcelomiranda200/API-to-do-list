package com.uniasselvi.to_do_list_API.service;

import com.uniasselvi.to_do_list_API.model.Task; // Corrigido
import com.uniasselvi.to_do_list_API.repository.InterfaceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private InterfaceTaskRepository taskRepository;

    public List<Task> findAllByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
