package osmosis.filters.message.chained;

import osmosis.filters.message.MessageFilter;

import java.util.ArrayList;
import java.util.Collection;

public class ChainedMessageFilterBuilder {
    private final Collection<MessageFilter> filters;

    public ChainedMessageFilterBuilder() {
        this.filters = new ArrayList<>();
    }

    public ChainedMessageFilterBuilder addFilter(MessageFilter messageFilter) {
        filters.add(messageFilter);
        return this;
    }

    public ChainedMessageFilter build() {
        return new ChainedMessageFilter(filters);
    }
}
