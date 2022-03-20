package osmosis.pipes.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import osmosis.appliers.message.MessageApplier;
import osmosis.filters.message.MessageFilter;
import osmosis.filters.message.chained.ChainedMessageFilter;
import osmosis.filters.message.chained.ChainedMessageFilterBuilder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilteredMessagePipeBuilder {
    public static FiltersBuilder builder() {
        return new ActualMessagePipeBuilder();
    }

    public interface FiltersBuilder {
        FiltersBuilder addFilter(MessageFilter messageFilter);

        PipeBuilder setApplier(MessageApplier messageApplier);
    }

    public interface PipeBuilder {
        FilteredMessagePipe build();
    }

    public static class ActualMessagePipeBuilder implements FiltersBuilder, PipeBuilder {
        private final ChainedMessageFilterBuilder filterBuilder;
        private MessageApplier messageApplier;

        public ActualMessagePipeBuilder() {
            this.filterBuilder = new ChainedMessageFilterBuilder();
        }

        @Override
        public FiltersBuilder addFilter(MessageFilter messageFilter) {
            filterBuilder.addFilter(messageFilter);
            return this;
        }

        @Override
        public PipeBuilder setApplier(MessageApplier messageApplier) {
            this.messageApplier = messageApplier;
            return this;
        }

        @Override
        public FilteredMessagePipe build() {
            ChainedMessageFilter filters = filterBuilder.build();
            return new FilteredMessagePipe(filters, messageApplier);
        }
    }
}
