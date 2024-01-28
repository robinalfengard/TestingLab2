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

    @Test
    @DisplayName("Roll an input a number larger than 10 should result in an IllegalArgumentException")
    void rollAnInputLargerThan10ShouldResultInAnIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> {
            game.roll(11);
        });
    }

    @Test
    @DisplayName("Roll a strike followed by 2 and 7 points should generate in a score of 28")
    void rollAStrikeFollowedBy2And7PointsShouldGenerateInAScoreOf28(){
        game.roll(10);
        game.roll(2);
        game.roll(7);
        assertThat(game.score()).isEqualTo(28);
    }

    @Test
    @DisplayName("Roll a spare followed by 2 and 7 points should generate in a score of 21")
    void rollASpareFollowedBy2And7PointsShouldGenerateInAScoreOf28(){
        game.roll(1);
        game.roll(9);
        game.roll(2);
        game.roll(7);
        assertThat(game.score()).isEqualTo(21);
    }

    @Test
    @DisplayName("Spare followed by Strike followed by Spare followed by 3 plus 4 should generate a score of 60")
    void spareFollowedByStrikeFollowedBySpareFollowedBy3Plus4ShouldGenerateAScoreOf60(){
        game.roll(1);
        game.roll(9);
        game.roll(10);
        game.roll(6);
        game.roll(4);
        game.roll(3);
        game.roll(4);
        assertThat(game.score()).isEqualTo(60);
    }

    @Test
    @DisplayName("Not scoring strike or spare in the last frame should only add the scored points")
    void notScoringStrikeOrSpareInTheLastFrameShouldOnlyAddTheScoredPoints(){
        rollNumberOfTimes(18, 2);
        game.roll(2);
        game.roll(3);
        game.roll(4);
        assertThat(game.score()).isEqualTo(41);
    }

    @Test
    @DisplayName("Scoring three strikes in the last frame should add 30  more points")
    void scoringThreeStrikesInTHeLastFrameShouldAdd30MorePoints(){
        rollNumberOfTimes(18, 2);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        assertThat(game.score()).isEqualTo(66);
    }

    @Test
    @DisplayName("Scoring a spare followed by a strike in the last frame should add 20 more points")
    void scoringASpareFollowedByAStrikeInTheLastFrameShouldAdd20MorePoints(){
        rollNumberOfTimes(18, 2);
        game.roll(2);
        game.roll(8);
        game.roll(10);
        assertThat(game.score()).isEqualTo(56);
    }

    @Test
    @DisplayName("Scoring a spare with a total of more than 10 points should return illegal argument exception")
    void scoringASpareWithATotalOfMoreThan10PointsShouldReturnIllegalArgumentException(){
        game.roll(3);
        assertThrows(IllegalArgumentException.class, () -> {
            game.roll(8);
        });
    }

    @Test
    @DisplayName("Scoring 12 strikes should generate in a total score of 300 ")
    void scoring12StrikesShouldGenerateInATotalScoreOf300(){
        rollNumberOfTimes(12, 10);
        assertThat(game.score()).isEqualTo(300);
    }

    private void rollNumberOfTimes(int numberOfRolls, int pinsKnockedDownPerRoll){
        for (int i = 0; i <numberOfRolls; i++) {
            game.roll(pinsKnockedDownPerRoll);
        }
    }

}