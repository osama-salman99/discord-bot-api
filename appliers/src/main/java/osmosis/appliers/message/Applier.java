package osmosis.appliers.message;

import osmosis.commons.message.ProcessingMessage;

public interface Applier {
    void apply(ProcessingMessage processingMessage);
}
