package osmosis.appliers.message.sending;

import java.util.function.Supplier;

public class SuppliedSendBackApplier extends SendBackApplier {

    public SuppliedSendBackApplier(Supplier<String> sendBackMessageSupplier) {
        super(processingMessage -> sendBackMessageSupplier.get());
    }
}
