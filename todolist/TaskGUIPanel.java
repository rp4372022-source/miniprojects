package miniprojects.todolist;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Font;

public class TaskGUIPanel {
    private TaskService taskService = new TaskService();

    public void loadGUI() {
        JFrame frame = new JFrame("To-do list app");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);

        DefaultListModel<String> taskModel = new DefaultListModel<>();
        List<String> fetchedTasksList = taskService.getTasks();
        for(String name : fetchedTasksList){taskModel.addElement(name);}
        JList<String> taskList = new JList<>(taskModel);
        
        // buttons
        JButton addTaskBtn = new JButton("Create Task");
        addTaskBtn.setFont(new Font("Arial",Font.BOLD,20));
        addTaskBtn.addActionListener(e -> {
            JDialog dialog = new JDialog(frame, "Create New Task",true);
            dialog.setSize(400,250);
            dialog.setLayout(new BorderLayout(10, 10));

            JPanel formPanel = new JPanel(new GridLayout(2,5,5,5));

            formPanel.add(new JLabel("Task name and description"));
            JTextField namefield = new JTextField();
            formPanel.add(namefield);

            JButton cancelBtn = new JButton("cancle");
            cancelBtn.addActionListener(e1 -> { dialog.dispose();} );
            JButton addBtn = new JButton("Add");
            addBtn.addActionListener(e2 -> {
                taskService.addTask(namefield.getText());
                dialog.dispose();
            });

            formPanel.add(namefield);
            formPanel.add(addBtn);
            formPanel.add(cancelBtn);

            dialog.add(formPanel);
            dialog.setVisible(true);

            taskModel.clear();
            for(String name : taskService.getTasks()){ taskModel.addElement(name);}
        });
        JButton deleteTaskBtn = new JButton("Delete Task");
        deleteTaskBtn.setFont(new Font("Arial",Font.BOLD,20));
        deleteTaskBtn.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if(index != -1){
                taskService.deleteTask(taskList.getSelectedValue());
                taskModel.clear();
                for(String name : taskService.getTasks()){ taskModel.addElement(name);}
            } else 
                javax.swing.JOptionPane.showMessageDialog(frame, "Select a task first");
        });
        JButton editTask = new JButton("Edit Task");
        editTask.setFont(new Font("Arial",Font.BOLD,20));
        editTask.addActionListener(e -> {
            JDialog dialog = new JDialog(frame, "Update Selected Task",true);
            dialog.setSize(400,250);
            dialog.setLayout(new BorderLayout(10, 10));

            JPanel formPanel = new JPanel(new GridLayout(3,1,5,5));

            formPanel.add(new JLabel("Task name and description"));
            JTextField namefield = new JTextField(taskList.getSelectedValue()); 
            String nameSFeString = taskList.getSelectedValue();
            JButton cancelBtn = new JButton("cancel");
            cancelBtn.addActionListener(e1 -> { dialog.dispose();} );
            JButton editBtn = new JButton("Edit");
            editBtn.addActionListener(e2 -> {
                taskService.deleteTask(nameSFeString);
                taskService.addTask(namefield.getText());
                dialog.dispose();
            });

            formPanel.add(namefield);
            formPanel.add(editBtn);
            formPanel.add(cancelBtn);

            dialog.add(formPanel);
            dialog.setVisible(true);

            taskModel.clear();
            for(String name : taskService.getTasks()){ taskModel.addElement(name);}
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(addTaskBtn);
        btnPanel.add(deleteTaskBtn);
        btnPanel.add(editTask);
        btnPanel.setLayout(new GridLayout(1, 4, 5, 5));

        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
