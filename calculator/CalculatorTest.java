package miniprojects.calculator;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class CalculatorTest{
    EquationProcessor equationProcessor = new EquationProcessor();
    final StringBuilder defaultEqn = new StringBuilder("0");
    StringBuilder equation = defaultEqn;

    public void loadGUI(){
        JFrame frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,400);

        JTextField display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "0","c","=","+",
            "7","8","9","-",
            "4","5","6","*",
            "1","2","3","/",
        };

        for(String btn : buttons){
            JButton button = new JButton(btn);
            button.setFont(new Font("Arial",Font.BOLD,20));
            button.addActionListener(e -> {
                if(button.getText().equals("=") && !equation.equals(defaultEqn)){
                    display.setText(String.valueOf(equationProcessor.processEquation(equation.toString())));
                    equation = defaultEqn;
                } else if (button.getText().equals("c")){
                    equation = defaultEqn;
                    display.setText(defaultEqn.toString());
                } else {
                    if(equation.equals(defaultEqn)){
                        equation = new StringBuilder(button.getText());
                    }
                    else {
                        equation.append(button.getText());
                    }
                    display.setText(equation.toString());
                }
            });
            buttonPanel.add(button);
        }

        frame.add(buttonPanel);
        frame.setVisible(true);


    }
}

