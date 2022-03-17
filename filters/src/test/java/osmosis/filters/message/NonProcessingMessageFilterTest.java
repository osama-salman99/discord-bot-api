package osmosis.filters.message;

import org.junit.jupiter.api.Test;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.result.FilterResult;
import osmosis.filters.message.helpers.MessageHelper;

import static org.junit.jupiter.api.Assertions.*;

class NonProcessingMessageFilterTest {
    @Test
    void givenApplicableWhenFilterThenReturnSuccessfulWithoutProcessing() {
        NonProcessingMessageFilter filter = createNonProcessingFilter(true);
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = filter.filter(processingMessage);
        assertTrue(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    @Test
    void givenInapplicableWhenFilterThenReturnSuccessfulWithoutProcessing() {
        NonProcessingMessageFilter filter = createNonProcessingFilter(false);
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = filter.filter(processingMessage);
        assertFalse(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    private NonProcessingMessageFilter createNonProcessingFilter(boolean applicable) {
        return new NonProcessingMessageFilter() {
            @Override
            protected boolean isApplicable(ProcessingMessage processingMessage) {
                return applicable;
            }
        };
    }

    private void assertSame(ProcessingMessage expected, ProcessingMessage actual) {
        assertEquals(expected.getMessageObject(), actual.getMessageObject());
        assertEquals(expected.getProcessedMessage(), actual.getProcessedMessage());
    }
}