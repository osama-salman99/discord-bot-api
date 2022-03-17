package osmosis.message.result;

import lombok.AllArgsConstructor;
import osmosis.message.ProcessingMessage;

@AllArgsConstructor
public abstract class FilterResult {
    public final ProcessingMessage processingMessage;

    public abstract boolean isSuccessful();

    public ProcessingMessage getProcessingMessage() {
        return processingMessage;
    }
}
