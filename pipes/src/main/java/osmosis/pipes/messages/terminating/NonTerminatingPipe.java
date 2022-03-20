package osmosis.pipes.messages.terminating;

import osmosis.pipes.messages.MessagePipe;

public class NonTerminatingPipe extends TerminablePipe {

    public NonTerminatingPipe(MessagePipe messagePipe) {
        super(messagePipe);
    }

    @Override
    public boolean isTerminating() {
        return false;
    }
}
