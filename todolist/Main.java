package miniprojects.todolist;

public class Main {
    public static void main(String[] args) {
        // TaskService taskService = new TaskService();
        // taskService.addTask("Revise java");
        // taskService.addTask("1 Leetcode problem");

        // taskService.setTask(1, new Task("2 Leetcode problems"));

        // System.out.println(taskService.getTasks());

        TaskGUIPanel panel = new TaskGUIPanel();
        panel.loadGUI();

        // taskService.deleteTask("oki");
    }
}
