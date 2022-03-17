package osmosis.filters.message.chained;

import org.junit.jupiter.api.Test;
import osmosis.filters.message.MessageFilter;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.helpers.MessageHelper;
import osmosis.filters.message.result.FilterResult;

import static org.junit.jupiter.api.Assertions.*;

class ChainedMessageFilterTest {
    @Test
    void givenEmptyWhenFilterThenReturnSuccessful() {
        ChainedMessageFilter filter = new ChainedMessageFilterBuilder().build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = filter.filter(processingMessage);
        assertTrue(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    @Test
    void givenAllInapplicableWhenFilterThenReturnUnsuccessful() {
        ChainedMessageFilter filter = new ChainedMessageFilterBuilder()
                .addFilter(createInapplicableFilter())
                .addFilter(createInapplicableFilter())
                .build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = filter.filter(processingMessage);
        assertFalse(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    @Test
    void givenOneInapplicableWhenFilterThenReturnUnsuccessful() {
        ChainedMessageFilter filter = new ChainedMessageFilterBuilder()
                .addFilter(createInapplicableFilter())
                .addFilter(createDuplicateMessageFilter())
                .build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = filter.filter(processingMessage);
        assertFalse(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    @Test
    void givenAllApplicableWhenFilterThenReturnSuccessful() {
        ChainedMessageFilter filter = new ChainedMessageFilterBuilder()
                .addFilter(createDuplicateMessageFilter())
                .addFilter(createDuplicateMessageFilter())
                .build();
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = filter.filter(processingMessage);
        assertTrue(result.isSuccessful());
        assertEquals(processingMessage.getMessageObject(), result.getProcessingMessage().getMessageObject());
        assertEquals(processingMessage.getProcessedMessage().repeat(4), result.getProcessingMessage().getProcessedMessage());
    }

    private MessageFilter createDuplicateMessageFilter() {
        return new MessageFilter() {
            @Override
            protected boolean isApplicable(ProcessingMessage processingMessage) {
                return true;
            }

            @Override
            protected ProcessingMessage process(ProcessingMessage processingMessage) {
                return new ProcessingMessage(processingMessage.getMessageObject(), processingMessage.getProcessedMessage().repeat(2));
            }
        };
    }

    private MessageFilter createInapplicableFilter() {
        return new MessageFilter() {
            @Override
            protected boolean isApplicable(ProcessingMessage processingMessage) {
                return false;
            }

            @Override
            protected ProcessingMessage process(ProcessingMessage processingMessage) {
                return null;
            }
        };
    }

    private void assertSame(ProcessingMessage expected, ProcessingMessage actual) {
        assertEquals(expected.getMessageObject(), actual.getMessageObject());
        assertEquals(expected.getProcessedMessage(), actual.getProcessedMessage());
    }
}