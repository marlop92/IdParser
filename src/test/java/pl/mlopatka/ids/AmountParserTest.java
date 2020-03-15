package pl.mlopatka.ids;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class AmountParserTest {

    private static AmountParser amountParser = new AmountParserImpl();

    @ParameterizedTest
    @MethodSource("supplyWithParams")
    public void shouldParseAmount(String input, List<Integer> expected) {
        //when
        List<Integer> actual = amountParser.parseAmount(input);

        //than
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
    }


    private static Stream<Arguments> supplyWithParams() {
        return Stream.of(
                Arguments.of("100, 101", List.of(100, 101)),
                Arguments.of("100, 101, 103", List.of(100, 101, 103)),
                Arguments.of("100, 101-102, 103", List.of(100, 101, 102, 103)),
                Arguments.of("?", List.of(0,1,2,3,4,5,6,7,8,9)),
                Arguments.of("1?", List.of(10,11,12,13,14,15,16,17,18,19)),
                Arguments.of("?0", List.of(0,10,20,30,40,50,60,70,80,90)),
                Arguments.of("1?1", List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191)),
                Arguments.of("25, 10?", List.of(25, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109)),
                Arguments.of("?01", List.of(1, 101, 201, 301, 401, 501, 601, 701, 801, 901))
        );
    }

}