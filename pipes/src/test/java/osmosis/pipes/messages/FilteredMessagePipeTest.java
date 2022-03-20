package osmosis.pipes.messages;

import org.junit.jupiter.api.Test;
import osmosis.appliers.message.MessageApplier;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.result.FailedFilterResult;
import osmosis.filters.message.result.SuccessfulFilterResult;
import osmosis.pipes.messages.helpers.MessageHelper;
import osmosis.pipes.messages.result.PipeResult;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class FilteredMessagePipeTest {
    @Test
    void givenUnsuccessfulFilterWhenProcessThenNotApply() {
        MessageApplier applier = mock(MessageApplier.class);
        FilteredMessagePipe filteredMessagePipe = FilteredMessagePipeBuilder.builder()
                .addFilter(FailedFilterResult::new)
                .setApplier(applier)
                .build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        PipeResult result = filteredMessagePipe.process(processingMessage);

        assertFalse(result.isProcessed());
        verify(applier, times(0)).apply(processingMessage);
    }

    @Test
    void givenSuccessfulFiltersWhenProcessThenApply() {
        MessageApplier applier = mock(MessageApplier.class);
        FilteredMessagePipe filteredMessagePipe = FilteredMessagePipeBuilder.builder()
                .addFilter(SuccessfulFilterResult::new)
                .addFilter(SuccessfulFilterResult::new)
                .setApplier(applier)
                .build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        PipeResult result = filteredMessagePipe.process(processingMessage);

        assertTrue(result.isProcessed());
        verify(applier, times(1)).apply(processingMessage);
    }

    @Test
    void givenMixedFiltersWhenProcessThenNotApply() {
        MessageApplier applier = mock(MessageApplier.class);
        FilteredMessagePipe filteredMessagePipe = FilteredMessagePipeBuilder.builder()
                .addFilter(SuccessfulFilterResult::new)
                .addFilter(SuccessfulFilterResult::new)
                .addFilter(FailedFilterResult::new)
                .setApplier(applier)
                .build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        PipeResult result = filteredMessagePipe.process(processingMessage);

        assertFalse(result.isProcessed());
        verify(applier, times(0)).apply(processingMessage);
    }
}