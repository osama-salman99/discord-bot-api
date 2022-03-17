package osmosis.filters.message;

import osmosis.commons.message.ProcessingMessage;

public abstract class NonProcessingMessageFilter extends MessageFilter {

    @Override
    protected ProcessingMessage process(ProcessingMessage processingMessage) {
        return processingMessage;
    }
}
