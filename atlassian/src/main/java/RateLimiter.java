import java.time.LocalDateTime;

public interface RateLimiter {
    boolean rateLimit(String userId, LocalDateTime time);
}
