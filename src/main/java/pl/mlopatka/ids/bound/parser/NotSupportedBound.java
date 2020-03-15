package pl.mlopatka.ids.bound.parser;

import pl.mlopatka.ids.bound.IdBound;

public class NotSupportedBound extends IdBoundParser{

    public NotSupportedBound(IdBoundParser nextParser) {
        super(nextParser);
    }

    @Override
    protected IdBound parseBoundInternal(String rawBound) {
        throw new RuntimeException("Bound not found");
    }

    @Override
    protected boolean isPassedParseCondition(String rawBound) {
        return true;
    }
}
