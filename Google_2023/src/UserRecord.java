import java.util.Objects;

public record UserRecord(
        String name,
        String id,
        Integer userId
) {
    public UserRecord {
        Objects.requireNonNull(userId);
        Objects.requireNonNull(id);
    }
}
