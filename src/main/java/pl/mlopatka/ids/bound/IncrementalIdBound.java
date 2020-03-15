package pl.mlopatka.ids.bound;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IncrementalIdBound implements IdBound {

    public static final String WRONG_BOUNDARIES_MSG = "End point of bound (%s) can't be lesser than its beginning (%s)";
    private int boundStart;
    private int boundEnd;

    private IncrementalIdBound(int boundStart, int boundEnd) {
        this.boundStart = boundStart;
        this.boundEnd = boundEnd;
    }

    public static IncrementalIdBound createIdBound(int boundStart, int boundEnd) {
        if(boundEnd < boundStart) {
            throw new RuntimeException(String.format(WRONG_BOUNDARIES_MSG, boundEnd, boundStart));
        }

        return new IncrementalIdBound(boundStart, boundEnd);
    }

    public List<Integer> getIds() {
        return IntStream.rangeClosed(boundStart, boundEnd).boxed().collect(Collectors.toList());
    }
}
