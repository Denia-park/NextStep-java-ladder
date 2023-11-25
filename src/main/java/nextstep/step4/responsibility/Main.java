package nextstep.step4.responsibility;

import nextstep.step4.responsibility.domain.GameResultProvider;
import nextstep.step4.responsibility.domain.Ladder;
import nextstep.step4.responsibility.domain.UserData;
import nextstep.step4.responsibility.input.ConsoleInputHandler;
import nextstep.step4.responsibility.input.InputHandler;
import nextstep.step4.responsibility.output.ConsoleOutputHandler;

public class Main {
    public static void main(String[] args) {
        final InputHandler inputHandler = new ConsoleInputHandler();
        final UserData userData = inputHandler.inputUserData();
        final int height = inputHandler.inputLadderHeight();

        final Ladder ladder = new Ladder(userData, height);
        final GameResultProvider gameResult = ladder.run();

        final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler(ladder);
        consoleOutputHandler.outputMakingLadderResult();
        consoleOutputHandler.outputGameResult(gameResult);
    }
}
