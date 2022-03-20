package osmosis.appliers.message;

import osmosis.commons.message.ProcessingMessage;

public interface MessageApplier {
    void apply(ProcessingMessage processingMessage);
}
