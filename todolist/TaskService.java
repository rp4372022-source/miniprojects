package miniprojects.todolist;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private TaskRepo taskRepo = new TaskRepo();

    public void addTask(String taskName){
        if(taskName == null)
            throw new NullPointerException("Input cannot be empty");
        taskRepo.addTask(taskName);    
    }
    public Task getTask(int index){
        if(index < 0)
            throw new IllegalArgumentException("Index cannot be negative");
        return taskRepo.getTask(index);
    }
    public void setTask(int index, Task task){
        if(index < 0)
            throw new IllegalArgumentException("Index cannot be negative");
        if (task == null)
            throw new NullPointerException("Task cannot be null");
        taskRepo.setTask(index, task);
    }
    // public void deleteTask(int index){
    //     if(index < 0)
    //         throw new IllegalArgumentException("Index cannot be negative");
    //     taskRepo.deleteTask(index);
    // }
    public void deleteTask(String task_name){
        if(task_name.equals(null))
            throw new IllegalArgumentException("Name cannot be negative");
        taskRepo.deleteTask(task_name);
    }
    public List<String> getTasks(){
        List<String> taskNames = new ArrayList<>();
        for(Task task:taskRepo.getTasks()){
            taskNames.add(task.toString());
        }
        return taskNames;
    }
}
