package osmosis.pipes.messages;

import osmosis.commons.message.ProcessingMessage;
import osmosis.pipes.messages.result.PipeResult;

public interface MessagePipe {
    PipeResult process(ProcessingMessage processingMessage);
}
