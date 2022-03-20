package osmosis.pipes.messages.terminating.chain;

import osmosis.pipes.messages.terminating.TerminablePipe;

import java.util.Collection;
import java.util.LinkedList;

public class TerminablePipeChainBuilder {
    private final Collection<TerminablePipe> pipes;

    public TerminablePipeChainBuilder() {
        this.pipes = new LinkedList<>();
    }

    public TerminablePipeChainBuilder addPipe(TerminablePipe pipe) {
        this.pipes.add(pipe);
        return this;
    }

    public TerminablePipeChain build() {
        return new TerminablePipeChain(pipes);
    }
}
