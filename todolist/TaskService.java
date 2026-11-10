package miniprojects.todolist;

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
    public void deleteTask(int index){
        if(index < 0)
            throw new IllegalArgumentException("Index cannot be negative");
        taskRepo.deleteTask(index);
    }
    public List<Task> getTasks(){
        return taskRepo.getTasks();
    }
}
