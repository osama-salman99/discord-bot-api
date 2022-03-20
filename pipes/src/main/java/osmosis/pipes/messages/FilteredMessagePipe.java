package osmosis.pipes.messages;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import osmosis.appliers.message.MessageApplier;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.MessageFilter;
import osmosis.pipes.messages.result.PipeResult;
import osmosis.pipes.messages.result.ProcessedPipeResult;
import osmosis.pipes.messages.result.UnprocessedPipeResult;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FilteredMessagePipe implements MessagePipe {
    private final MessageFilter messageFilter;
    private final MessageApplier messageApplier;

    public PipeResult process(ProcessingMessage processingMessage) {
        if (!messageFilter.filter(processingMessage).isSuccessful()) {
            return new UnprocessedPipeResult();
        }
        messageApplier.apply(processingMessage);
        return new ProcessedPipeResult();
    }
}
