package miniprojects.HelloWorldGUI;


import javax.swing.JFrame;
import javax.swing.JTextField;

public class HelloWorld{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setSize(300, 400);
        
        JTextField text = new JTextField("Hello World");

        frame.add(text);
        frame.setVisible(true);
    }
}