package osmosis.filters.message.result;

import osmosis.commons.message.ProcessingMessage;

public class FailedFilterResult extends FilterResult {

    public FailedFilterResult(ProcessingMessage processingMessage) {
        super(processingMessage);
    }

    @Override
    public boolean isSuccessful() {
        return false;
    }
}
