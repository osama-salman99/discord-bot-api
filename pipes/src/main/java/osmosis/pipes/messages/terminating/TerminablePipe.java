package osmosis.pipes.messages.terminating;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import osmosis.commons.message.ProcessingMessage;
import osmosis.pipes.messages.MessagePipe;
import osmosis.pipes.messages.result.PipeResult;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class TerminablePipe implements MessagePipe {
    private final MessagePipe messagePipe;

    @Override
    public PipeResult process(ProcessingMessage processingMessage) {
        return messagePipe.process(processingMessage);
    }

    public abstract boolean isTerminating();
}
