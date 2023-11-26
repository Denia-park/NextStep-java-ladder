package nextstep.step4.responsibility.domain;

import nextstep.step4.responsibility.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final List<IndexHorizontalMover> row;

    public Row(final List<IndexHorizontalMover> row) {
        this.row = row;
    }

    public IndexHorizontalMover get(final int index) {
        return this.row.get(index);
    }

    public int size() {
        return this.row.size();
    }

    public static Row buildRow(final int size) {
        final List<Mover> tempMovers = new ArrayList<>();

        final int firstIdx = 0;
        final int lastIdx = size - 1;

        tempMovers.add(Mover.first(RandomGenerator.nextBoolean()));

        for (int idx = firstIdx + 1; idx < lastIdx; idx++) {
            tempMovers.add(tempMovers.get(idx - 1).next(RandomGenerator.nextBoolean()));
        }

        tempMovers.add(tempMovers.get(lastIdx - 1).last());

        final List<IndexHorizontalMover> indexHorizontalMovers = new ArrayList<>(tempMovers);
        return new Row(indexHorizontalMovers);
    }
}
