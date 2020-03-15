package pl.mlopatka.ids.bound.parser;

import pl.mlopatka.ids.bound.IdBound;
import pl.mlopatka.ids.bound.IdSingleBound;

public class SingleIdBoundParser extends IdBoundParser {

    public SingleIdBoundParser(IdBoundParser nextParser) {
        super(nextParser);
    }

    @Override
    protected IdBound parseBoundInternal(String rawBound) {
        int parsedVal = Integer.valueOf(rawBound);
        return IdSingleBound.createIdSingleBound(parsedVal);
    }

    @Override
    protected boolean isPassedParseCondition(String rawBound) {
        return rawBound.matches("[0-9]+");
    }
}
