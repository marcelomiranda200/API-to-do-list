package com.uniasselvi.to_do_list_API.service;

import com.uniasselvi.to_do_list_API.repository.InterfaceTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private InterfaceTaskRepository taskRepository;

    public List<br.com.uniasselvi.to_do_list.model.Task> findAllByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    // Métodos para criar, atualizar e deletar tarefas
}

