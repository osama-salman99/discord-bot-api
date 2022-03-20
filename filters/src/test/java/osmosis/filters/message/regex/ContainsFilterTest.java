package osmosis.filters.message.regex;

import org.junit.jupiter.api.Test;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.helpers.MessageHelper;
import osmosis.filters.message.result.FilterResult;

import static org.junit.jupiter.api.Assertions.*;

class ContainsFilterTest {
    @Test
    void givenInvalidContentWhenFilterThenReturnUnsuccessfulResult() {
        ContainsFilter containsFilter = new ContainsFilter("hi");
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("no"));
        FilterResult result = containsFilter.filter(processingMessage);

        assertFalse(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    @Test
    void givenValidContentWhenFilterThenReturnSuccessfulResult() {
        ContainsFilter containsFilter = new ContainsFilter("hi");
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("wi-hi-bi"));
        FilterResult result = containsFilter.filter(processingMessage);

        assertTrue(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    private void assertSame(ProcessingMessage expected, ProcessingMessage actual) {
        assertEquals(expected.getMessageObject(), actual.getMessageObject());
        assertEquals(expected.getProcessedMessage(), actual.getProcessedMessage());
    }
}