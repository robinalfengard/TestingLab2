package com.example;

import java.util.Arrays;

public class Game {
    private final int MAXIMUM_NUMBER_OF_ROUNDS = 21;
    private int[] rolls  = new int[MAXIMUM_NUMBER_OF_ROUNDS];
    int currentRoll = 0;

    int round = 0;

    void roll(int numberOfPinsKnockedDown){
        round++;
        if(numberOfPinsKnockedDown>10)
            throw new IllegalArgumentException("You can't struck down more than 10 pins");
        if(round == 2 && rolls[currentRoll-1] != 10 && numberOfPinsKnockedDown + rolls[currentRoll-1]>10)
            throw new IllegalArgumentException("You can't combine a spare with more than 10 pins");
        rolls[currentRoll] = numberOfPinsKnockedDown;
        currentRoll++;
        if(round == 2)
            round = 0;
    }

    int score(){
        int totalScore = 0;
        int indexOfRoll = 0;
        for(int i = 0; i<10; i++){
            if(rolls[indexOfRoll] == 10){
                // Strike
                totalScore += 10 + rolls[indexOfRoll + 1] + rolls[indexOfRoll + 2];
                indexOfRoll +=1;
            } else if (rolls[indexOfRoll] + rolls[indexOfRoll+1] == 10) {
                // Spare
                totalScore += 10 + rolls[indexOfRoll + 2];
                indexOfRoll += 2;
            } else {
                totalScore += rolls[indexOfRoll] + rolls[indexOfRoll +1];
                indexOfRoll += 2;
            }
        }
        return totalScore;
    }
}
