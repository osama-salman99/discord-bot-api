package osmosis.pipes.messages.terminating;

import osmosis.pipes.messages.MessagePipe;

public class TerminatingPipe extends TerminablePipe {

    public TerminatingPipe(MessagePipe messagePipe) {
        super(messagePipe);
    }

    @Override
    public boolean isTerminating() {
        return true;
    }
}
