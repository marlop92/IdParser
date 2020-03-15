package pl.mlopatka.ids.bound.parser;

import pl.mlopatka.ids.bound.IdBound;
import pl.mlopatka.ids.bound.SequentialIdBound;

public class SequentialIdBoundParser extends IdBoundParser {

    public static final String SEQUENTIAL_DELIMITER = "?";

    public SequentialIdBoundParser(IdBoundParser nextParser) {
        super(nextParser);
    }

    @Override
    protected IdBound parseBoundInternal(String rawBound) {
        int boundStart = Integer.valueOf(rawBound.replace(SEQUENTIAL_DELIMITER, "0"));
        int boundEnd = Integer.valueOf(rawBound.replace(SEQUENTIAL_DELIMITER, "9"));
        int sequencePosition = Math.abs(rawBound.length() - rawBound.indexOf(SEQUENTIAL_DELIMITER)) - 1;

        return SequentialIdBound.createIdBound(boundStart, boundEnd, sequencePosition);
    }

    @Override
    protected boolean isPassedParseCondition(String rawBound) {
        return rawBound.contains(SEQUENTIAL_DELIMITER);
    }
}
