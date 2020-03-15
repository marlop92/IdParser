package pl.mlopatka.ids.bound;

import java.util.List;

public class IdSingleBound implements IdBound {

    public static final String WRONG_BOUND_VALUE_MSG = "Value %s can't be lesser than 0";
    private int value;

    private IdSingleBound(int value) {
        this.value = value;
    }

    public static IdSingleBound createIdSingleBound(int value) {
        if(value < 0) {
            throw new RuntimeException(String.format(WRONG_BOUND_VALUE_MSG, value));
        }

        return new IdSingleBound(value);
    }

    @Override
    public List<Integer> getIds() {
        return List.of(value);
    }
}
