package domain;

import domain.rules.RockPaperScissors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RockPaperScissorsTest {
    @Test
    @DisplayName("Rock crushes scissors")
    public void rockCrushesScissors() {
        Rules game = new RockPaperScissors();
        Result result = game.decide(Move.ROCK, Move.SCISSORS);
        assertEquals(Result.WIN, result);
    }

    @Test
    @DisplayName("Scissors cuts Paper")
    public void scissorsCutsPaper() {
        Rules game = new RockPaperScissors();
        Result result = game.decide(Move.SCISSORS, Move.PAPER);
        assertEquals(Result.WIN, result);
    }

    @Test
    @DisplayName("Paper covers Rock")
    public void paperCoversRock() {
        Rules game = new RockPaperScissors();
        Result result = game.decide(Move.PAPER, Move.ROCK);
        assertEquals(Result.WIN, result);
    }

    private static Stream<Arguments> provideMovesAndResults() {
        return Stream.of(
                Arguments.of(Move.ROCK, Move.SCISSORS, Result.WIN),
                Arguments.of(Move.PAPER, Move.ROCK, Result.WIN),
                Arguments.of(Move.SCISSORS, Move.PAPER, Result.WIN),

                Arguments.of(Move.ROCK, Move.ROCK, Result.DRAW),
                Arguments.of(Move.PAPER, Move.PAPER, Result.DRAW),
                Arguments.of(Move.SCISSORS, Move.SCISSORS, Result.DRAW),

                Arguments.of(Move.SCISSORS, Move.ROCK, Result.LOSE),
                Arguments.of(Move.ROCK, Move.PAPER, Result.LOSE),
                Arguments.of(Move.PAPER, Move.SCISSORS, Result.LOSE)

        );
    }
    @ParameterizedTest
    @MethodSource("provideMovesAndResults")
    void verifyPlayerBattlesAndResults(Move mine, Move theirs, Result expectedResult) {
        Rules rules = new RockPaperScissors();
        Player player1 = new Player("Jan");
        Player player2 = new Player("Henk");
        player1.pick(mine);
        player2.pick(theirs);
        Result result = player1.battle(player2, rules);
        assertEquals(player1.getName(), "Jan");
        assertEquals(expectedResult, result);
    }
}
