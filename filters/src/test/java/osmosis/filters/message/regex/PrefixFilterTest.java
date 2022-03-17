package osmosis.filters.message.regex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.result.FilterResult;
import osmosis.filters.message.helpers.MessageHelper;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PrefixFilterTest {
    private static Stream<Arguments> successfulPrefixesArguments() {
        return Stream.of(
                Arguments.of("con", "content", "tent"),
                Arguments.of("##", "##play", "play"),
                Arguments.of("\\d+", "123hi", "hi")
        );
    }

    @Test
    void givenInapplicableMessageWhenFilterThenReturnUnsuccessful() {
        String prefix = "f";
        PrefixFilter prefixFilter = new PrefixFilter(prefix);
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content"));

        FilterResult result = prefixFilter.filter(processingMessage);
        assertFalse(result.isSuccessful());
        assertSame(processingMessage, result.getProcessingMessage());
    }

    @ParameterizedTest
    @MethodSource("successfulPrefixesArguments")
    void givenApplicableMessageWhenFilterThenReturnSuccessful(String prefix, String message, String afterProcessing) {
        PrefixFilter prefixFilter = new PrefixFilter(prefix);
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage(message));

        FilterResult result = prefixFilter.filter(processingMessage);
        assertTrue(result.isSuccessful());
        ProcessingMessage resultProcessingMessage = result.getProcessingMessage();
        assertEquals(processingMessage.getMessageObject(), resultProcessingMessage.getMessageObject());
        assertEquals(afterProcessing, resultProcessingMessage.getProcessedMessage());
    }

    private void assertSame(ProcessingMessage expected, ProcessingMessage actual) {
        assertEquals(expected.getMessageObject(), actual.getMessageObject());
        assertEquals(expected.getProcessedMessage(), actual.getProcessedMessage());
    }
}