package osmosis.pipes.messages.result;

public class ProcessedPipeResult implements PipeResult {
    @Override
    public boolean isProcessed() {
        return true;
    }
}
