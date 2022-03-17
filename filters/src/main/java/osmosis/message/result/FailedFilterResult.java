package osmosis.message.result;

import osmosis.message.ProcessingMessage;

public class FailedFilterResult extends FilterResult {

    public FailedFilterResult(ProcessingMessage processingMessage) {
        super(processingMessage);
    }

    @Override
    public boolean isSuccessful() {
        return false;
    }
}
