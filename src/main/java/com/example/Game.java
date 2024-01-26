package com.example;

public class Game {
    int score = 0;


    void roll(int numberOfPinsKnockedDown){
        if(numberOfPinsKnockedDown>10)
            throw new IllegalArgumentException("You can't struck down more than 10 pins");
        score += numberOfPinsKnockedDown;
    };
    int score(){
        return score;
    }
}
