package nextstep.step4.inout.result;

import nextstep.ladder.input.Input;
import nextstep.step4.inout.domain.Ladder;
import nextstep.step4.inout.domain.LadderResult;
import nextstep.step4.inout.domain.Line;
import nextstep.step4.inout.domain.UserInputTexts;

import java.util.List;
import java.util.stream.Collectors;

public class Result {
    public static void printMakingLadderResult(final Ladder ladder) {
        printLadderUserInputTexts(ladder.userNames());
        printLadderBody(ladder.body());
        printLadderUserInputTexts(ladder.userResults());
    }

    private static void printLadderUserInputTexts(final UserInputTexts userInputTexts) {
        final List<String> texts = userInputTexts.getTexts();

        final String printUserNames = texts.stream()
                .map(str -> String.format("%5s", str))
                .collect(Collectors.joining(" "));

        System.out.println(printUserNames);
    }

    private static void printLadderBody(final List<Line> body) {
        final String printBody = body.stream()
                .map(Result::printLadderLine)
                .collect(Collectors.joining("\n"));

        System.out.println(printBody);
    }

    private static String printLadderLine(Line line) {
        final String prefix = " ".repeat(UserInputTexts.MAX_TEXT_LENGTH - 1) + "|";
        final String delimiter = "|";

        return line.getHasRungs().stream()
                .map(Result::generateLadderPointString)
                .collect(Collectors.joining(delimiter, prefix, delimiter));
    }

    private static String generateLadderPointString(final boolean bool) {
        if (bool) {
            return "-".repeat(UserInputTexts.MAX_TEXT_LENGTH);
        }

        return " ".repeat(UserInputTexts.MAX_TEXT_LENGTH);
    }

    public static void printLadderRunResult(final LadderResult ladderResult) {
        boolean stopFlag = false;

        while (!stopFlag) {
            final String userName = Input.inputPrintUserName();

            final String runResult = ladderResult.get(userName);
            System.out.println("\n실행 결과\n" + runResult);

            stopFlag = checkStopFlag(userName);
        }
    }

    private static boolean checkStopFlag(final String userName) {
        return "all".equals(userName);
    }
}
