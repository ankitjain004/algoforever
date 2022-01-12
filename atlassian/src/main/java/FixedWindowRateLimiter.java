import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class FixedWindowRateLimiter implements RateLimiter {
    private static final int MAX_NUMBER_OF_REQUESTS = 2;
    private static FixedWindowRateLimiter fixedWindowRateLimiterInstance = null;
    private HashMap<String, UserStatus> userRequestStatusMap = new HashMap<>();

    private FixedWindowRateLimiter() {

    }

    public static FixedWindowRateLimiter getInstance() {
        if (fixedWindowRateLimiterInstance == null) {
            synchronized (FixedWindowRateLimiter.class) {
                if (fixedWindowRateLimiterInstance == null)
                    fixedWindowRateLimiterInstance = new FixedWindowRateLimiter();
            }
        }
        return fixedWindowRateLimiterInstance;
    }


    @Override
    public boolean rateLimit(String userId, LocalDateTime time) {
        LocalDateTime normalizedTimeInMinutes = time.truncatedTo(ChronoUnit.MINUTES);
        if (!userRequestStatusMap.containsKey(userId)) {
            UserStatus userStatus = new UserStatus(normalizedTimeInMinutes, 1);
            userRequestStatusMap.put(userId, userStatus);
            return true;
        } else {
            UserStatus userStatus = userRequestStatusMap.get(userId);
            if (normalizedTimeInMinutes.isEqual(userStatus.getLastWindowTime())) {
                int requestCount = userStatus.getCount();
                if (requestCount + 1 <= MAX_NUMBER_OF_REQUESTS) {
                    userStatus.setCount(requestCount + 1);
                    return true;
                } else {
                    return false;
                }
            } else {
                userStatus.setCount(1);
                ;
                userStatus.setLastWindowTime(normalizedTimeInMinutes);
                return true;
            }
        }
    }
}
