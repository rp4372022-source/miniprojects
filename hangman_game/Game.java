package miniprojects.hangman_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game{
    private static final int PLAYER_GUESSING_LIMIT = 10; 
    private static final List<String> words = List.of("axe","banana","apple","mobile");
    
    private static List<Character> avaibleLetters = new ArrayList<>(List.of(
        'a','b','c','d','e','f','g','h','i','j','k','l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y','z'
    ));

    private final Scanner sc = new Scanner(System.in);

    public void play(){
        Random random = new Random();

        int index = random.nextInt(words.size());
        String machineGuessedWord = words.get(index);

        StringBuilder reveleadWord = new StringBuilder();
        int ptr = 0;

        int currentGameGuessLimit = PLAYER_GUESSING_LIMIT;
        while(ptr < machineGuessedWord.length()) {
            reveleadWord.append("_");
            ptr++;
        }
        System.out.println("Guess the word");
        while(true){
            System.out.println("Guesses remaining : "+currentGameGuessLimit);
            for(char letter:avaibleLetters){
                System.out.print(letter+" ");
            }
            System.out.println();
            System.out.println("Word -> "+reveleadWord);
            String playerWord = sc.nextLine();
            
            if(playerWord.equals(machineGuessedWord)){
                System.out.println("You win");
                break;
            }
            
            if(playerWord.length() > machineGuessedWord.length()){
                System.out.println("Word with invalid length");
            }
            
            StringBuilder newReveledWord = new StringBuilder();
            for(int i=0;i<playerWord.length();i++){
                if(playerWord.toLowerCase().charAt(i) == machineGuessedWord.charAt(i)){
                    String s = String.valueOf(machineGuessedWord.charAt(i));
                    newReveledWord.append(s);
                } else {
                    newReveledWord.append("_");
                }
            }
            reveleadWord = newReveledWord;
            currentGameGuessLimit -= 1;
            if(currentGameGuessLimit == 0){
                System.out.println("Limit over");
                System.out.println("Word : "+machineGuessedWord);
                break;
            }
        }
    }
}