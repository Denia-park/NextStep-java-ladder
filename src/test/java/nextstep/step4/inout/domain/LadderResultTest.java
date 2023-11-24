package nextstep.step4.inout.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    private static Map<String, String> results;

    @BeforeAll
    static void beforeAll() {
        results = new LinkedHashMap<>();

        results.put("pobi", "5000");
        results.put("honux", "꽝");
        results.put("crong", "3000");
        results.put("jk", "꽝");
    }

    @Test
    @DisplayName("사다리 결과를 입력으로, LadderResult를 생성한다.")
    void testLadderResultCreation() {
        //given, when
        LadderResult ladderResult = new LadderResult(results);

        //then
        assertThat(ladderResult).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("ladderResultGetProvider")
    @DisplayName("get() 메서드의 입력으로 결과를 보고 싶은 이름을 입력하면, 결과를 반환한다.")
    void testGet(final String name, final String expectedResult) {
        //given
        final LadderResult ladderResult = new LadderResult(results);

        //when
        final String result = ladderResult.get(name);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> ladderResultGetProvider() {
        return Stream.of(
                Arguments.of("pobi", "5000"),
                Arguments.of("honux", "꽝"),
                Arguments.of("crong", "3000"),
                Arguments.of("jk", "꽝")
        );
    }

    @Test
    @DisplayName("get() 메서드의 입력으로 존재하지 않는 이름을 넣으면, '존재하지 않는 이름입니다.'를 반환한다.")
    void testGetWithNonExistentName() {
        //given
        final LadderResult ladderResult = new LadderResult(results);

        //when
        final String result = ladderResult.get("noData");

        //then
        assertThat(result).isEqualTo("존재하지 않는 이름입니다.");
    }

    @Test
    @DisplayName("get() 메서드의 입력으로 'all'을 넣으면, 모든 결과를 반환한다.")
    void testGetWithAll() {
        //given
        final LadderResult ladderResult = new LadderResult(results);

        //when
        final String result = ladderResult.get("all");

        //then
        assertThat(result).isEqualTo(
                "pobi : 5000\n" +
                        "honux : 꽝\n" +
                        "crong : 3000\n" +
                        "jk : 꽝"
        );
    }
}
