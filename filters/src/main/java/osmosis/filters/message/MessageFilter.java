package osmosis.filters.message;

import osmosis.commons.message.ProcessingMessage;
import osmosis.filters.message.result.FilterResult;

public interface MessageFilter {
    FilterResult filter(ProcessingMessage processingMessage);
}
