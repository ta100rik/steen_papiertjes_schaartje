package domain;

public interface Rules {
    Result decide(Move mine, Move theirs);
}
