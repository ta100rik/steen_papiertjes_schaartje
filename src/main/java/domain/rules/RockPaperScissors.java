package domain.rules;

import domain.Move;
import domain.Result;
import domain.Rules;

import static domain.Move.*;

public class RockPaperScissors implements Rules {
    @Override
    public Result decide(Move mine, Move theirs) {
        if(mine.equals(theirs)){
            return Result.DRAW;
        } else {
            switch (mine){
                case ROCK:
                    if(theirs == PAPER){
                        return Result.LOSE;
                    }
                    break;
                case PAPER:
                    if(theirs == SCISSORS){
                        return Result.LOSE;
                    }
                    break;
                case SCISSORS:
                    if(theirs == ROCK){
                        return Result.LOSE;
                    }
                    break;
            }
            return Result.WIN;
        }
    }
}
