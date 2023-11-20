package nextstep.ladder.domain;

public class LadderHeight {
    private final int height;

    public LadderHeight(final int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("최대 사다리 높이는 1 이상이어야 합니다.");
        }

        this.height = height;
    }

    public int height() {
        return height;
    }
}
