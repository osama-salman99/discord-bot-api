package osmosis.message;

public abstract class NonProcessingMessageFilter extends MessageFilter {

    @Override
    protected ProcessingMessage process(ProcessingMessage processingMessage) {
        return processingMessage;
    }
}
