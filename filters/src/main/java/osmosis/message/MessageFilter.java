package osmosis.message;

import osmosis.message.result.FailedFilterResult;
import osmosis.message.result.FilterResult;
import osmosis.message.result.SuccessfulFilterResult;

public abstract class MessageFilter {

    public FilterResult filter(ProcessingMessage processingMessage) {
        if (isApplicable(processingMessage)) {
            return new SuccessfulFilterResult(process(processingMessage));
        }
        return new FailedFilterResult(processingMessage);
    }

    protected abstract boolean isApplicable(ProcessingMessage processingMessage);

    protected abstract ProcessingMessage process(ProcessingMessage processingMessage);
}
