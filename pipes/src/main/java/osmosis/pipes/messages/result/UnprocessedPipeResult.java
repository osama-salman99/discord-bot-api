package osmosis.pipes.messages.result;

public class UnprocessedPipeResult implements PipeResult {
    @Override
    public boolean isProcessed() {
        return false;
    }
}
