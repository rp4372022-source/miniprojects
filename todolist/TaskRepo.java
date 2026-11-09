package miniprojects.todolist;

import java.sql.*;

public class TaskRepo {
    // CRUD
    public void addTask(String taskName){
        try (Connection connection = JDBCutil.getConnection()) {
            String sql = "INSERT INTO tasks (task_name) VALUE (?);";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,taskName);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Task getTask(int index){
        try(Connection connetion = JDBCutil.getConnection()){

            String sql = "SELECT task_name FROM tasks WHERE task_id = (?);";
            try(
                PreparedStatement preparedStatement = connetion.prepareStatement(sql)
            ){
                preparedStatement.setInt(1, index-1);
                ResultSet rs = preparedStatement.executeQuery();

                if(rs != null){
                    return new Task(rs.getString(1));
                }
                return null;
            }
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public void setTask(int index, Task task){
        try(Connection connetion = JDBCutil.getConnection()){
            String sql = "UPDATE tasks SET task_name = (?) WHERE task_id = (?);";
            try(
                PreparedStatement preparedStatement = connetion.prepareStatement(sql)
            ){
                preparedStatement.setString(1, task.getTaskName());
                preparedStatement.setInt(2, index-1);
                
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
    public void deleteTask(int index){
        try (Connection connection = JDBCutil.getConnection()){
            String sql = "DELETE FROM tasks WHERE id = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,index);

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}