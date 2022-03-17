package osmosis.message.result;

import osmosis.message.ProcessingMessage;

public class SuccessfulFilterResult extends FilterResult {

    public SuccessfulFilterResult(ProcessingMessage processingMessage) {
        super(processingMessage);
    }

    @Override
    public boolean isSuccessful() {
        return true;
    }
}
