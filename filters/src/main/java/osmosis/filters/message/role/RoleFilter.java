package osmosis.filters.message.role;

import lombok.AllArgsConstructor;
import org.javacord.api.entity.message.Message;
import osmosis.commons.message.ProcessingMessage;
import osmosis.commons.message.exceptions.MessageWithEmptyServerException;
import osmosis.commons.message.exceptions.MessageWithEmptyUserAuthorException;
import osmosis.filters.message.NonProcessingMessageFilter;

@AllArgsConstructor
public class RoleFilter extends NonProcessingMessageFilter {
    private final String roleName;

    @Override
    protected boolean isApplicable(ProcessingMessage processingMessage) {
        Message message = processingMessage.getMessageObject();
        return message.getUserAuthor().orElseThrow(MessageWithEmptyUserAuthorException::new)
                .getRoles(message.getServer().orElseThrow(MessageWithEmptyServerException::new))
                .stream().anyMatch(role -> role.getName().equals(roleName));
    }
}
