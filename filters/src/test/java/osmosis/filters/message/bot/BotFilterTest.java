package osmosis.filters.message.bot;

import org.junit.jupiter.api.Test;
import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.helpers.MessageHelper;
import osmosis.filters.message.result.FilterResult;

import static org.junit.jupiter.api.Assertions.*;

class BotFilterTest {

    @Test
    void givenBotAuthorWhenFilterThenReturnSuccessfulResultAndMessageUnprocessed() {
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content", true));
        BotFilter botFilter = new BotFilter();

        FilterResult result = botFilter.filter(processingMessage);

        ProcessingMessage resultProcessingMessage = result.getProcessingMessage();
        assertTrue(result.isSuccessful());
        assertEquals(processingMessage.getMessageObject(), resultProcessingMessage.getMessageObject());
        assertEquals(processingMessage.getProcessedMessage(), resultProcessingMessage.getProcessedMessage());
    }

    @Test
    void givenUserAuthorWhenFilterThenReturnUnsuccessfulResultAndMessageUnprocessed() {
        ProcessingMessage processingMessage = new ProcessingMessage(MessageHelper.createMessage("content", false));
        BotFilter botFilter = new BotFilter();

        FilterResult result = botFilter.filter(processingMessage);

        ProcessingMessage resultProcessingMessage = result.getProcessingMessage();
        assertFalse(result.isSuccessful());
        assertEquals(processingMessage.getMessageObject(), resultProcessingMessage.getMessageObject());
        assertEquals(processingMessage.getProcessedMessage(), resultProcessingMessage.getProcessedMessage());
    }
}