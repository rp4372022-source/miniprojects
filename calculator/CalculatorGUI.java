package miniprojects.calculator;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class CalculatorGUI{

    EquationProcessor equationProcessor = new EquationProcessor();
    
    List<String> equation = new ArrayList<>(); //actual list of nums and operators 
    String lastTempNumber = "0";
    StringBuilder tempNumHolder = new StringBuilder(); //temporary holding number
    StringBuilder displayEqn = new StringBuilder(); //will show eqn on display

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
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
            "0","c","=","+",
            "7","8","9","-",
            "4","5","6","*",
            "1","2","3","/",
            "."
        };

        for(String btn : buttons){
            JButton button = new JButton(btn);
            button.setFont(new Font("Arial",Font.BOLD,20));
            button.addActionListener(e -> {
                if(button.getText().equals("=")){
                    equation.add(tempNumHolder.toString());
                    String result = equationProcessor.getResultOfEquation(equation);
                    displayEqn = new StringBuilder(result);
                    tempNumHolder = new StringBuilder(result);
                    equation.clear();
                } else if (button.getText().equals("c")){
                    tempNumHolder = new StringBuilder();
                    equation.clear();
                    displayEqn = new StringBuilder("0");
                } else {
                    if(displayEqn.equals(new StringBuilder("0"))){
                        // equation.set(0, button.getText());
                        tempNumHolder.append(button.getText());
                        displayEqn = new StringBuilder(tempNumHolder);
                    }   
                    else if(button.getText().equals("+")
                            || button.getText().equals("-")
                            || button.getText().equals("*")
                            || button.getText().equals("/")        
                    ){
                        equation.add(tempNumHolder.toString());
                        equation.add(button.getText());
                        tempNumHolder = new StringBuilder();
                        displayEqn.append(button.getText());
                    } else {
                        tempNumHolder.append(button.getText());
                        displayEqn.append(button.getText());
                    }
                }
                display.setText(displayEqn.toString());
            });
            buttonPanel.add(button);
        }
        frame.add(buttonPanel);
        frame.setVisible(true);
    }
}

