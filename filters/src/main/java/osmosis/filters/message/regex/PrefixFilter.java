package osmosis.filters.message.regex;

import osmosis.commons.message.ProcessingMessage;

public class PrefixFilter extends RegexFilter {
    private final String prefix;

    public PrefixFilter(String prefix) {
        super(prefix + ".*");
        this.prefix = prefix;
    }

    @Override
    protected ProcessingMessage process(ProcessingMessage processingMessage) {
        String processedMessage = processingMessage.getProcessedMessage().replaceFirst(prefix, "");
        return new ProcessingMessage(processingMessage.getMessageObject(), processedMessage);
    }
}
