package br.com.uniasselvi.to_do_list.controller;

import br.com.uniasselvi.to_do_list.model.TaskHistory;
import br.com.uniasselvi.to_do_list.repository.InterfaceTaskHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task-history")
public class TaskHistoryController {

    @Autowired
    private InterfaceTaskHistoryRepository taskHistoryRepository;

    @GetMapping
    public ResponseEntity<Iterable<TaskHistory>> getAllTaskHistories() {
        return new ResponseEntity<>(taskHistoryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskHistory> getTaskHistoryById(@PathVariable int id) {
        Optional<TaskHistory> taskHistory = taskHistoryRepository.findById(id);
        return taskHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskHistory>> getTaskHistoryByTaskId(@PathVariable int taskId) {
        List<TaskHistory> historyList = taskHistoryRepository.findByTaskId(taskId);
        return new ResponseEntity<>(historyList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskHistory> createTaskHistory(@RequestBody TaskHistory taskHistory) {
        TaskHistory savedTaskHistory = taskHistoryRepository.save(taskHistory);
        return new ResponseEntity<>(savedTaskHistory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskHistory> updateTaskHistory(@PathVariable int id, @RequestBody TaskHistory taskHistory) {
        if (!taskHistoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskHistory.setId(id);
        TaskHistory updatedTaskHistory = taskHistoryRepository.save(taskHistory);
        return ResponseEntity.ok(updatedTaskHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskHistory(@PathVariable int id) {
        if (!taskHistoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskHistoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
