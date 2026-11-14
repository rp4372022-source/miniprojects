package miniprojects.calculator;

import java.math.BigDecimal;
import java.util.List;

public class EquationProcessor {
    private List<String> tempEquationProcessor(List<String> equation, int i){
        BigDecimal num1 = new BigDecimal(equation.remove(i-1));// num1
        String operator = equation.remove(i-1);// operator
        BigDecimal num2 = new BigDecimal(equation.remove(i-1));// num2
        
        BigDecimal result = switch (operator) {
            case "+" -> num1.add(num2);
            case "-" -> num1.subtract(num2);
            case "*" -> num1.multiply(num2);
            case "/" -> num1.divide(num2);
            default -> BigDecimal.ZERO;
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