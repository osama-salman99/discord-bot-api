package osmosis.filters.message.regex;

import lombok.AllArgsConstructor;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.ProcessingMessageFilter;

@AllArgsConstructor
public abstract class RegexFilter extends ProcessingMessageFilter {
    private final String regex;

    @Override
    protected boolean isApplicable(ProcessingMessage processingMessage) {
        return processingMessage.getProcessedMessage().matches(regex);
    }
}
