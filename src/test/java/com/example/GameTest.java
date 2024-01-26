package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();
    @Test
    @DisplayName("Roll down 2 pins should generate a score of 2")
    void rollDown2PinsShouldGenerateAScoreOf2(){
        game.roll(2);
        assertThat(game.score()).isEqualTo(2);
    }

    @Test
    @DisplayName("Roll down 2 pins and later roll down 4 pins should generate a score of 6")
    void rollDown2PinsAndLaterRollDown4PinsShouldGenerateAScoreOf6(){
        game.roll(2);
        game.roll(4);
        assertThat(game.score()).isEqualTo(6);
    }

}