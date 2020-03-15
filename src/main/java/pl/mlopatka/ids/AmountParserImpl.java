package pl.mlopatka.ids;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static pl.mlopatka.ids.bound.parser.IdBoundConfig.*;

public class AmountParserImpl implements AmountParser {

    private static final String IDS_DELIMITER = ",";

    @Override
    public List<Integer> parseAmount(String inputAmount) {
        String[] rawIds = inputAmount.replace(" ", "").split(IDS_DELIMITER);
        return Arrays.stream(rawIds)
                .map(ID_BOUND_PARSER::parseBound)
                .flatMap(idBound -> idBound.getIds().stream())
                .collect(Collectors.toList());
    }

}
