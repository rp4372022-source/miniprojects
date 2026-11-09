package miniprojects.calculator;

import java.util.List;

public class EquationProcessor {
    public String getResultOfEquation(List<String> equation){
        if(equation == null) throw new NullPointerException("No equation found");
        while(equation.size() != 1){
            for(int i=0;i<equation.size();i++){
                if(equation.get(i).equals("/")){
                    double num1 = Double.parseDouble(equation.remove(i-1));//removed num1
                    equation.remove(i-1);//removed operator
                    double num2 = Double.parseDouble(equation.remove(i-1));//removed num2

                    equation.add(i-1, String.valueOf(num1/num2));
                    continue;
                } else if(equation.get(i).equals("*")){
                    double num1 = Double.parseDouble(equation.remove(i-1));//removed num1
                    equation.remove(i-1);//removed operator
                    double num2 = Double.parseDouble(equation.remove(i-1));//removed num2

                    equation.add(i-1, String.valueOf(num1*num2));
                    continue;
                } else if(equation.get(i).equals("+")){
                    double num1 = Double.parseDouble(equation.remove(i-1));//removed num1
                    equation.remove(i-1);//removed operator
                    double num2 = Double.parseDouble(equation.remove(i-1));//removed num2

                    equation.add(i-1, String.valueOf(num1+num2));
                    continue;
                } else if(equation.get(i).equals("-")){
                    double num1 = Double.parseDouble(equation.remove(i-1));//removed num1
                    equation.remove(i-1);//removed operator
                    double num2 = Double.parseDouble(equation.remove(i-1));//removed num2

                    equation.add(i-1, String.valueOf(num1-num2));
                    continue;
                } 
            }
        }
        
        return equation.get(0);
    }
}