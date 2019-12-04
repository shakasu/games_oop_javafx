package ru.job4j.figure;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.RookWhite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {
    @Test
    public void moveTrue() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        assertThat(logic.move(Cell.C1, Cell.H6), is(true));
    }

    @Test
    public void moveFalse() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C2);
        logic.add(bishopBlack);
        assertThat(logic.move(Cell.C1, Cell.G6), is(false));
    }
}
