package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) > 0 ? 1 : -1;
        int deltaY = (dest.y - source.y) > 0 ? 1 : -1;
        if (isDiagonal(source, dest)) {
            for (int index = 0; index < size; index++) {
            steps[index] = Cell.values()[8 * (source.x + 1 + deltaX * index) + (source.y + 1 + deltaY * index)];
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int deltaX = (dest.x - source.x) > 0 ? 1 : -1;
        int deltaY = (dest.y - source.y) > 0 ? 1 : -1;
        int size = Math.abs(dest.x - source.x);
        for (int index = 0; index < size; index++) {
            if (dest == Cell.values()[8 * (source.x + 1 + deltaX * index) + (source.y + 1 + deltaY * index)]) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
