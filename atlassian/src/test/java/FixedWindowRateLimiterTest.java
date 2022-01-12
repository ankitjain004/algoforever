import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FixedWindowRateLimiterTest {

    @Test
    public void rateLimiter()
    {
        FixedWindowRateLimiter fixedWindowRateLimiter = FixedWindowRateLimiter.getInstance();
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        Assertions.assertTrue(fixedWindowRateLimiter.rateLimit("user1", now));
        Assertions.assertTrue(fixedWindowRateLimiter.rateLimit("user1", now.plusSeconds(70)));
        Assertions.assertTrue(fixedWindowRateLimiter.rateLimit("user1", now.plusSeconds(80)));
        Assertions.assertFalse(fixedWindowRateLimiter.rateLimit("user1", now.plusSeconds(80)));
    }
}
