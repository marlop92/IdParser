package pl.mlopatka.ids.bound;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialIdBound implements IdBound {

    private static final String INVALID_BOUNDARIES_MSG = "Start of bound (%s) has to be lesser than bound end (%s)";
    private static final String INVALID_SEQUENCE_POSITION_MSG = "Sequence position (%s) can't be lesser than 0";

    private int boundStart;
    private int boundEnd;
    private int sequencePosition;

    private SequentialIdBound(int boundStart, int boundEnd, int sequencePosition) {
        this.boundStart = boundStart;
        this.boundEnd = boundEnd;
        this.sequencePosition = sequencePosition;
    }

    public static SequentialIdBound createIdBound(int boundStart, int boundEnd, int incrementatorPosition) {
        if(boundEnd < boundStart) {
            throw new RuntimeException(String.format(INVALID_BOUNDARIES_MSG, boundStart, boundEnd));
        }

        if(incrementatorPosition < 0) {
            throw new RuntimeException(String.format(INVALID_SEQUENCE_POSITION_MSG, incrementatorPosition));
        }

        return new SequentialIdBound(boundStart, boundEnd, incrementatorPosition);
    }

    @Override
    public List<Integer> getIds() {
        int incrementationVal = (int) Math.pow((double) 10, (double) sequencePosition) ;
        return IntStream.iterate(boundStart, val -> val + incrementationVal)
                .takeWhile(val -> val <= boundEnd)
                .boxed()
                .collect(Collectors.toList());
    }
}
