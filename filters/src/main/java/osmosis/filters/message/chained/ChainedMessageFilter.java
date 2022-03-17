package osmosis.filters.message.chained;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import osmosis.filters.message.MessageFilter;
import osmosis.filters.message.NonProcessingMessageFilter;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.result.FailedFilterResult;
import osmosis.filters.message.result.FilterResult;
import osmosis.filters.message.result.SuccessfulFilterResult;

import java.util.Collection;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ChainedMessageFilter extends NonProcessingMessageFilter {
    private final Collection<MessageFilter> filters;

    @Override
    public FilterResult filter(ProcessingMessage processingMessage) {
        ProcessingMessage tempProcessingMessage = processingMessage;
        for (MessageFilter filter : filters) {
            FilterResult result = filter.filter(tempProcessingMessage);
            if (result.isSuccessful()) {
                tempProcessingMessage = result.getProcessingMessage();
            } else {
                return new FailedFilterResult(processingMessage);
            }
        }
        return new SuccessfulFilterResult(tempProcessingMessage);
    }

    @Override
    protected boolean isApplicable(ProcessingMessage processingMessage) {
        throw new UnsupportedOperationException();
    }
}
