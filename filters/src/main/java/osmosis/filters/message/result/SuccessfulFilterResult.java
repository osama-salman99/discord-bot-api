package osmosis.filters.message.result;

import osmosis.commons.message.ProcessingMessage;

public class SuccessfulFilterResult extends FilterResult {

    public SuccessfulFilterResult(ProcessingMessage processingMessage) {
        super(processingMessage);
    }

    @Override
    public boolean isSuccessful() {
        return true;
    }
}
