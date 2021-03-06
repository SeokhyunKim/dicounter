package dicounter.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dicounter.overlaynet.node.NodeAddress;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = AggregateTriggersRequest.AggregateTriggersRequestBuilder.class)
public class AggregateTriggersRequest implements DicounterMessage {

    private final UUID countingTaskId;
    private final UUID id;
    private final int roundNo;
    private final NodeAddress aggregatingLeaderAddress;

    @JsonIgnore
    @Override
    public DicounterMessageType getType() {
        return DicounterMessageType.AGGREGATE_TRIGGERS_REQUEST;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class AggregateTriggersRequestBuilder {
    }
}
