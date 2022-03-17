package osmosis.filters.message.regex;

import lombok.AllArgsConstructor;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.MessageFilter;

@AllArgsConstructor
public abstract class RegexFilter extends MessageFilter {
    private final String regex;

    @Override
    protected boolean isApplicable(ProcessingMessage processingMessage) {
        return processingMessage.getProcessedMessage().matches(regex);
    }
}
