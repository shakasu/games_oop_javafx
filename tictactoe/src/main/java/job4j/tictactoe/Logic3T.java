package job4j.tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {
        return List.of(0, 1, 2)
                .stream()
                .anyMatch(i -> (this.fillBy(Figure3T::hasMarkX, 0, i, 1, 0) ||
                        this.fillBy(Figure3T::hasMarkX, i, 0, 0, 1))) ||
                this.fillBy(Figure3T::hasMarkX, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkX, this.table.length - 1 , 0, -1, 1);
    }

    public boolean isWinnerO() {
        return List.of(0, 1, 2)
                .stream()
                .anyMatch(i -> (this.fillBy(Figure3T::hasMarkO, 0, i, 1, 0) ||
                        this.fillBy(Figure3T::hasMarkO, i, 0, 0, 1))) ||
                this.fillBy(Figure3T::hasMarkO, 0,0, 1, 1) ||
                this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    public boolean hasGap() {
        return Arrays.stream(this.table)
                .flatMap(Arrays::stream)
                .anyMatch(figure -> (figure.hasMarkO() == figure.hasMarkX()));
    }
}
