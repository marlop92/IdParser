package pl.mlopatka.ids.bound.parser;

import pl.mlopatka.ids.bound.IdBound;

public abstract class IdBoundParser {

    private IdBoundParser nextParser;

    public IdBoundParser(IdBoundParser nextParser) {
        this.nextParser = nextParser;
    }

    protected abstract IdBound parseBoundInternal(String rawBound);
    protected abstract boolean isPassedParseCondition(String rawBound);

    public IdBound parseBound(String rawBound) {
        if(isPassedParseCondition(rawBound)) {
            return parseBoundInternal(rawBound);
        }

        return nextParser.parseBound(rawBound);
    }
}
