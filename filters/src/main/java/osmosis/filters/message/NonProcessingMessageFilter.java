package osmosis.filters.message;

import osmosis.commons.message.ProcessingMessage;

public abstract class NonProcessingMessageFilter extends ProcessingMessageFilter {

    @Override
    protected ProcessingMessage process(ProcessingMessage processingMessage) {
        return processingMessage;
    }
}
