package pl.mlopatka.ids.bound.parser;

public class IdBoundConfig {

    private static IdBoundParser NOT_SUPPORTED_BOUND_PARSER = new NotSupportedBound(null);
    private static IdBoundParser SEQUENTIAL_PARSER = new SequentialIdBoundParser(NOT_SUPPORTED_BOUND_PARSER);
    private static IdBoundParser INCREMENTAL_PARSER = new IncrementalIdBoundParser(SEQUENTIAL_PARSER);
    public static IdBoundParser ID_BOUND_PARSER = new SingleIdBoundParser(INCREMENTAL_PARSER);
}
