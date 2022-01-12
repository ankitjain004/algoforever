import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RollingWindowRateLimiterTest {

    @Test
    public void rateLimiter()
    {
        RollingWindowRateLimiter rollingWindowRateLimiter = RollingWindowRateLimiter.getInstance();
        LocalDateTime now = LocalDateTime.now();
        Assertions.assertTrue(rollingWindowRateLimiter.rateLimit("user1", now));
        Assertions.assertTrue(rollingWindowRateLimiter.rateLimit("user1", now.plusSeconds(70)));
        Assertions.assertTrue(rollingWindowRateLimiter.rateLimit("user1", now.plusSeconds(80)));
        Assertions.assertFalse(rollingWindowRateLimiter.rateLimit("user1", now.plusSeconds(80)));


    }
}
