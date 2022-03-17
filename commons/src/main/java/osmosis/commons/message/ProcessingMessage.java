package osmosis.commons.message;

import lombok.AllArgsConstructor;
import org.javacord.api.entity.message.Message;

@AllArgsConstructor
public class ProcessingMessage {
    private final Message messageObject;
    private final String processedMessage;

    public ProcessingMessage(Message message) {
        this.messageObject = message;
        this.processedMessage = message.getContent();
    }

    public Message getMessageObject() {
        return messageObject;
    }

    public String getProcessedMessage() {
        return processedMessage;
    }
}
