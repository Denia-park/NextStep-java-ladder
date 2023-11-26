package nextstep.step4.responsibility.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder implements GameRunnable {
    private final UserData userData;
    private final List<Row> rows;

    public Ladder(final UserData userData, final int height) {
        this.userData = userData;

        final int size = userData.size();
        this.rows = buildRows(height, size);
    }

    public Ladder(final UserData userData, final List<Row> rows) {
        this.userData = userData;
        this.rows = rows;
    }

    private List<Row> buildRows(final int height, final int size) {
        final List<Row> tempRows = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            tempRows.add(Row.buildRow(size));
        }

        return tempRows;
    }

    @Override
    public GameResultProvider run() {
        Map<String, String> result = new LinkedHashMap<>();

        for (int userIdx = 0; userIdx < userNamesSize(); userIdx++) {
            final int arrivalIdx = move(userIdx);

            result.put(userNames().get(userIdx), userResults().get(arrivalIdx));
        }

        return new LadderResult(result);
    }

    private int userNamesSize() {
        return this.userData.size();
    }

    private int move(final int userIdx) {
        int arrivalIdx = userIdx;

        for (final Row row : this.rows) {
            final IndexHorizontalMover mover = row.get(arrivalIdx);

            arrivalIdx = mover.moveHorizontal(arrivalIdx);
        }

        return arrivalIdx;
    }

    public UserInputProvider userNames() {
        return this.userData.getUserNames();
    }

    public UserInputProvider userResults() {
        return this.userData.getUserResults();
    }

    public List<Row> indexHorizontalMovers() {
        return this.rows;
    }
}
