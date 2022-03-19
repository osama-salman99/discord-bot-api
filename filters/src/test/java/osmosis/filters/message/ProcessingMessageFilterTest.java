package osmosis.filters.message;

import org.junit.jupiter.api.Test;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.helpers.MessageHelper;
import osmosis.filters.message.result.FilterResult;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class ProcessingMessageFilterTest {

    @Test
    void givenNotApplicableFilterWhenFilterThenReturnNotSuccessfulResult() {
        ProcessingMessageFilter filter = createFilter(false, null);

        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        FilterResult result = filter.filter(processingMessage);
        assertFalse(result.isSuccessful());
        assertEquals(processingMessage.getMessageObject(), result.getProcessingMessage().getMessageObject());
        assertEquals(processingMessage.getProcessedMessage(), result.getProcessingMessage().getProcessedMessage());
    }

    @Test
    void givenApplicableFilterWithEmptyProcessWhenFilterThenReturnSuccessfulResultWithSameProcessingMessage() {
        ProcessingMessageFilter filter = createFilter(true, processingMessage -> processingMessage);

        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        FilterResult result = filter.filter(processingMessage);
        assertTrue(result.isSuccessful());
        assertEquals(processingMessage.getMessageObject(), result.getProcessingMessage().getMessageObject());
        assertEquals(processingMessage.getProcessedMessage(), result.getProcessingMessage().getProcessedMessage());
    }

    @Test
    void givenApplicableFilterWithRepeatingProcessWhenFilterThenReturnSuccessfulResultWithProcessedMessage() {
        ProcessingMessageFilter filter = createFilter(true, processingMessage -> new ProcessingMessage(processingMessage.getMessageObject(), processingMessage.getProcessedMessage().repeat(2)));

        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));
        FilterResult result = filter.filter(processingMessage);
        assertTrue(result.isSuccessful());
        assertEquals(processingMessage.getMessageObject(), result.getProcessingMessage().getMessageObject());
        assertEquals(processingMessage.getProcessedMessage().repeat(2), result.getProcessingMessage().getProcessedMessage());
    }

    private ProcessingMessageFilter createFilter(boolean applicable, Function<ProcessingMessage, ProcessingMessage> processor) {
        return new ProcessingMessageFilter() {
            @Override
            protected boolean isApplicable(ProcessingMessage processingMessage) {
                return applicable;
            }

            @Override
            protected ProcessingMessage process(ProcessingMessage processingMessage) {
                return processor.apply(processingMessage);
            }
        };
    }
}