package osmosis.filters.message.bot;

import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.NonProcessingMessageFilter;

public class BotFilter extends NonProcessingMessageFilter {

    @Override
    protected boolean isApplicable(ProcessingMessage processingMessage) {
        return processingMessage.getMessageObject().getAuthor().isBotUser();
    }
}
