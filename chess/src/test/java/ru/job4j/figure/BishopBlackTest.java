package ru.job4j.figure;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;

public class BishopBlackTest {

    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D3);
        assertThat(bishopBlack.copy(Cell.B6).position(), sameInstance(Cell.B6));
    }

    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D3);
        assertThat(bishopBlack.position(), sameInstance(Cell.D3));
    }

    @Test
    public void wayTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.C1, Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void isDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void isDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.G6), is(false));
    }
}

