package miniprojects.calculator;

import java.util.List;

public class EquationProcessor {
    private List<String> tempEquationProcessor(List<String> equation, int i){
        double num1 = Double.parseDouble(equation.remove(i-1));//removed num1
        String operator = equation.remove(i-1);//removed operator
        double num2 = Double.parseDouble(equation.remove(i-1));//removed num2
        
        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };

        equation.add(i-1, String.valueOf(result));
        return equation;
    }
    public String getResultOfEquation(List<String> equation){
        if(equation == null) throw new NullPointerException("No equation found");
        while(equation.size() != 1){
            for(int i=0;i<equation.size();i++){
                if(equation.get(i).equals("/")){
                    equation = tempEquationProcessor(equation, i);
                    continue;
                } else if(equation.get(i).equals("*")){
                    equation = tempEquationProcessor(equation, i);
                    continue;
                } else if(equation.get(i).equals("+")){
                    equation = tempEquationProcessor(equation, i);
                    continue;
                } else if(equation.get(i).equals("-")){
                    equation = tempEquationProcessor(equation, i);
                    continue;
                } 
            }
        }
        
        return equation.get(0);
    }
}