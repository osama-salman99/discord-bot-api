package osmosis.filters.message.regex;

import org.junit.jupiter.api.Test;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.result.FilterResult;
import osmosis.filters.message.helpers.MessageHelper;

import static org.junit.jupiter.api.Assertions.*;

class RegexFilterTest {
    @Test
    void givenInapplicableMessageWhenFilterThenReturnUnsuccessful() {
        String regex = "f";
        RegexFilter regexFilter = createRegexFilter(regex);
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = regexFilter.filter(processingMessage);
        assertFalse(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    @Test
    void givenApplicableMessageWhenFilterThenReturnSuccessful() {
        String regex = ".*";
        RegexFilter regexFilter = createRegexFilter(regex);
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = regexFilter.filter(processingMessage);
        assertTrue(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    private RegexFilter createRegexFilter(String regex) {
        return new RegexFilter(regex) {
            @Override
            protected ProcessingMessage process(ProcessingMessage processingMessage) {
                return processingMessage;
            }
        };
    }

    private void assertSame(ProcessingMessage expected, ProcessingMessage actual) {
        assertEquals(expected.getMessageObject(), actual.getMessageObject());
        assertEquals(expected.getProcessedMessage(), actual.getProcessedMessage());
    }
}