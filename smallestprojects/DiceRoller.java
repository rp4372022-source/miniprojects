package miniprojects.smallestprojects;

import java.util.Random;
class Dice{
    private static Random random = new Random();
    int rollDice(){
        return random.nextInt(1,7);
    }
}
public class DiceRoller {
    public static void main(String[] args) {
        Dice dice = new Dice();
        dice.rollDice();
    }
}
