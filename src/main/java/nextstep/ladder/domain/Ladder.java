package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Ladder {
    private final UserNames userNames;
    private final List<Line> ladderLines;

    public Ladder(final UserInput userInput, final IntFunction<Boolean> lineBuilderStrategy) {
        this.userNames = userInput.userNames();

        this.ladderLines = initLadderLines(userInput, lineBuilderStrategy);
    }

    private List<Line> initLadderLines(final UserInput userInput, final IntFunction<Boolean> lineBuilderStrategy) {
        List<Line> tempLadderLines = new ArrayList<>();

        final int width = userInput.userNamesSize() - 1;
        final int height = userInput.height();

        for (int i = 0; i < height; i++) {
            tempLadderLines.add(new Line(width, lineBuilderStrategy));
        }

        return tempLadderLines;
    }

    public UserNames userNames() {
        return this.userNames;
    }

    @Override
    public String toString() {
        return this.ladderLinesToString();
    }

    private String ladderLinesToString() {
        return ladderLines.stream()
                .map(ladderLine -> ladderLine.toString() + "\n")
                .collect(Collectors.joining());
    }
}
