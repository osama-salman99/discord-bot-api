package osmosis.pipes.messages.terminating.chain;

import org.junit.jupiter.api.Test;
import osmosis.commons.message.ProcessingMessage;
import osmosis.pipes.messages.MessagePipe;
import osmosis.pipes.messages.helpers.MessageHelper;
import osmosis.pipes.messages.result.ProcessedPipeResult;
import osmosis.pipes.messages.result.UnprocessedPipeResult;
import osmosis.pipes.messages.terminating.NonTerminatingPipe;
import osmosis.pipes.messages.terminating.TerminablePipe;
import osmosis.pipes.messages.terminating.TerminatingPipe;

import java.util.List;

import static org.mockito.Mockito.*;

class TerminablePipeChainTest {
    @Test
    void givenTerminatingUnprocessedPipesWhenProcessThenNotTerminate() {
        List<TerminablePipe> pipes = List.of(
                spy(createTerminablePipe(false, true)),
                spy(createTerminablePipe(false, true)),
                spy(createTerminablePipe(false, true))
        );
        TerminablePipeChainBuilder builder = new TerminablePipeChainBuilder();
        pipes.forEach(builder::addPipe);
        TerminablePipeChain pipeChain = builder.build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        pipeChain.process(processingMessage);

        pipes.forEach(pipe -> verify(pipe, times(1)).process(processingMessage));
    }

    @Test
    void givenTerminatingProcessedPipeWhenProcessThenTerminate() {
        TerminablePipe processedTerminating = spy(createTerminablePipe(true, true));
        TerminablePipe unprocessedTerminating1 = spy(createTerminablePipe(false, true));
        TerminablePipe unprocessedTerminating2 = spy(createTerminablePipe(false, true));
        TerminablePipeChain pipeChain = new TerminablePipeChainBuilder()
                .addPipe(processedTerminating)
                .addPipe(unprocessedTerminating1)
                .addPipe(unprocessedTerminating2)
                .build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        pipeChain.process(processingMessage);

        verify(processedTerminating, times(1)).process(processingMessage);
        verify(unprocessedTerminating1, times(0)).process(processingMessage);
        verify(unprocessedTerminating2, times(0)).process(processingMessage);
    }

    @Test
    void givenNonTerminatingProcessedPipesWhenProcessThenNotTerminate() {
        List<TerminablePipe> pipes = List.of(
                spy(createTerminablePipe(true, false)),
                spy(createTerminablePipe(true, false)),
                spy(createTerminablePipe(true, false))
        );
        TerminablePipeChainBuilder builder = new TerminablePipeChainBuilder();
        pipes.forEach(builder::addPipe);
        TerminablePipeChain pipeChain = builder.build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        pipeChain.process(processingMessage);

        pipes.forEach(pipe -> verify(pipe, times(1)).process(processingMessage));
    }

    @Test
    void givenNonTerminatingUnprocessedPipesWhenProcessThenNotTerminate() {
        List<TerminablePipe> pipes = List.of(
                spy(createTerminablePipe(false, false)),
                spy(createTerminablePipe(false, false)),
                spy(createTerminablePipe(false, false))
        );
        TerminablePipeChainBuilder builder = new TerminablePipeChainBuilder();
        pipes.forEach(builder::addPipe);
        TerminablePipeChain pipeChain = builder.build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        pipeChain.process(processingMessage);

        pipes.forEach(pipe -> verify(pipe, times(1)).process(processingMessage));
    }

    public TerminablePipe createTerminablePipe(boolean processed, boolean terminating) {
        MessagePipe messagePipe;
        if (processed) {
            messagePipe = processingMessage -> new ProcessedPipeResult();
        } else {
            messagePipe = processingMessage -> new UnprocessedPipeResult();
        }
        if (terminating) {
            return new TerminatingPipe(messagePipe);
        } else {
            return new NonTerminatingPipe(messagePipe);
        }
    }
}