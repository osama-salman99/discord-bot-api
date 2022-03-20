package osmosis.pipes.messages.terminating.chain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import osmosis.commons.message.ProcessingMessage;
import osmosis.pipes.messages.terminating.TerminablePipe;

import java.util.Collection;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class TerminablePipeChain {
    private final Collection<TerminablePipe> pipes;

    public void process(ProcessingMessage processingMessage) {
        for (TerminablePipe pipe : pipes) {
            if (pipe.process(processingMessage).isProcessed() && pipe.isTerminating()) {
                return;
            }
        }
    }
}
