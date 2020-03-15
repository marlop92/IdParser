package pl.mlopatka.ids.bound.parser;

import pl.mlopatka.ids.bound.IdBound;
import pl.mlopatka.ids.bound.IncrementalIdBound;

public class IncrementalIdBoundParser extends IdBoundParser {

    public static final String INCREMENTAL_BOUND_DELIMITER = "-";

    public IncrementalIdBoundParser(IdBoundParser nextParser) {
        super(nextParser);
    }

    @Override
    protected IdBound parseBoundInternal(String rawBound) {
        String[] boundParts = rawBound.split(INCREMENTAL_BOUND_DELIMITER);
        return IncrementalIdBound.createIdBound(Integer.valueOf(boundParts[0]), Integer.valueOf(boundParts[1]));
    }

    @Override
    protected boolean isPassedParseCondition(String rawBound) {
        return rawBound.matches("[0-9]+" + INCREMENTAL_BOUND_DELIMITER + "[0-9]+");
    }
}
