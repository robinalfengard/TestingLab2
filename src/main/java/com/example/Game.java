package com.example;

public class Game {
    int score = 0;


    void roll(int numberOfPinsKnockedDown){
        score += numberOfPinsKnockedDown;
    };
    int score(){
        return score;
    }
}
