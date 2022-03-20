package osmosis.appliers.message.sending;

import lombok.AllArgsConstructor;
import osmosis.appliers.message.Applier;
import osmosis.commons.message.ProcessingMessage;

import java.util.function.Function;

@AllArgsConstructor
public class SendBackApplier implements Applier {
    private final Function<ProcessingMessage, String> processor;

    @Override
    public void apply(ProcessingMessage processingMessage) {
        String result = processor.apply(processingMessage);
        processingMessage.getMessageObject().getChannel().sendMessage(result);
    }
}
