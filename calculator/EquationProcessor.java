package miniprojects.calculator;

public class EquationProcessor {
    private String operation(StringBuilder eqn, int i){
        int num1 = Integer.parseInt(String.valueOf(eqn.charAt(i-1)));
        int num2 = Integer.parseInt(String.valueOf(eqn.charAt(i+1)));
        
        int res = switch(String.valueOf(eqn.charAt(i))){
            case "+" ->  num1 + num2;
            case "-" ->  num1 - num2;
            case "*" ->  num1 * num2;
            case "/" ->  num1 / num2;
            default -> 0;
        };
        return String.valueOf(res);
    }
    
    public int processEquation(String equation){
        if(equation.length() <= 2) 
            return Integer.parseInt(equation);

        StringBuilder eqn = new StringBuilder(equation);
        
        while(eqn.length() != 1){
            //Division
            for(int i=0; i<eqn.length(); i++){
                if(String.valueOf(eqn.charAt(i)).equals("/")){
                    // FIX 2 & 3: Atomic replacement and index alignment
                    eqn.replace(i-1, i+2, operation(eqn, i));
                    i--; 
                }
            }
            //Multiplication
            for(int i=0; i<eqn.length(); i++){
                if(String.valueOf(eqn.charAt(i)).equals("*")){
                    eqn.replace(i-1, i+2, operation(eqn, i));
                    i--;
                }
            }
            //Addition
            for(int i=0; i<eqn.length(); i++){
                if(String.valueOf(eqn.charAt(i)).equals("+")){
                    eqn.replace(i-1, i+2, operation(eqn, i));
                    i--;
                }
            }
            //Subtraction
            for(int i=0; i<eqn.length(); i++){
                if(String.valueOf(eqn.charAt(i)).equals("-")){
                    eqn.replace(i-1, i+2, operation(eqn, i));
                    i--;
                }
            }
        }
        return Integer.parseInt(eqn.toString());
    }
}
