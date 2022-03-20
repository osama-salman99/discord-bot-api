package osmosis.appliers.message.forwarding;

import lombok.AllArgsConstructor;
import osmosis.appliers.message.MessageApplier;
import osmosis.commons.message.ProcessingMessage;

import java.util.function.Consumer;

@AllArgsConstructor
public class ForwardMessageApplier implements MessageApplier {
    private final Consumer<String> stringConsumer;

    @Override
    public void apply(ProcessingMessage processingMessage) {
        stringConsumer.accept(processingMessage.getProcessedMessage());
    }
}
