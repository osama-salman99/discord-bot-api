package osmosis.filters.message.regex;

import osmosis.commons.message.ProcessingMessage;

public class ContainsFilter extends RegexFilter {

    public ContainsFilter(String regex) {
        super(".*" + regex + ".*");
    }

    @Override
    protected ProcessingMessage process(ProcessingMessage processingMessage) {
        return processingMessage;
    }
}
