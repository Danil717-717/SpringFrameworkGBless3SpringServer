package ru.springgb.less3;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //по запросу "/task" получим этот метод
    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    //получение таски при указании в запросе id
    @GetMapping("/{id}")
    //указываем,что переменная из запроса(имена совпадают)
    public Task getByTask(@PathVariable UUID id){
        return taskService.getTask(id);
    }

    //добавление таски
    @PostMapping
    // принимаем данные из тела запроса @RequestBody
    public Task addById(@RequestBody Task task){
        return taskService.addTask(task);
    }


    @PutMapping("/{id}")
    public  Task getById(@PathVariable UUID id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        taskService.deleteTask(id);
    }
}
