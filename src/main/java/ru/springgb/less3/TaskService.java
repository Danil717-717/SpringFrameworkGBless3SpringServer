package ru.springgb.less3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    //тк БД еще не прошли будем использовать лист
    //наш лист с задачами
    private final List<Task> tasks = new ArrayList<>();

    //метод вывода всех тасок
    public List<Task> getAllTasks(){
        return tasks;
    }

    //метод получение таски по ID
    public Task getTask(UUID uuid){
        return tasks.stream().filter(task -> task.getId().equals(uuid)).findFirst().orElse(null);
    }

    //метод добавления таски
    public Task addTask(Task task){
        tasks.add(task);
        return task;
    }


    //удаление задачи
    public void deleteTask(UUID uuid){
        tasks.removeIf(task -> task.getId().equals(uuid));
    }


    //обновление задачи, те теперь по этому id
    //будет обновленная задача от клиента
    public  Task updateTask(UUID uuid,Task task){
        //находим по id таску которую нужно заменить
        Task taskStaraya=getTask(uuid);
        //если нашли
        if(taskStaraya != null){
            //меняем ее данные на данные с новой таски
            taskStaraya.setDescription(task.getDescription());
            taskStaraya.setName(task.getName());
            taskStaraya.setStatus(task.getStatus());
            taskStaraya.setCompletionTime(task.getCompletionTime());
        }
        return taskStaraya;
    }



}
