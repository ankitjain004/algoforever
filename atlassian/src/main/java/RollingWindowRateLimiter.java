import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RollingWindowRateLimiter implements RateLimiter {
    private static final int MAX_NUMBER_OF_REQUESTS = 2;
    private HashMap<String, Queue<LocalDateTime>> userRequestMap = new HashMap<>();
    private static RollingWindowRateLimiter instance = null;

    private RollingWindowRateLimiter() {

    }

    public static RollingWindowRateLimiter getInstance() {
        if (instance == null)
            synchronized (RollingWindowRateLimiter.class) {
                if (instance == null) {
                    instance = new RollingWindowRateLimiter();
                }
            }
        return instance;
    }

    @Override
    public boolean rateLimit(String userId, LocalDateTime time) {
        if (!userRequestMap.containsKey(userId)) {
            Queue<LocalDateTime> queue = new LinkedList<>();
            queue.offer(time);
            userRequestMap.put(userId, queue);
            return true;
        } else {
            Queue<LocalDateTime> queue = userRequestMap.get(userId);
            while (!queue.isEmpty() && queue.peek().isBefore(time.minusMinutes(1))) {
                queue.poll();
            }
            if (queue.size() + 1 > MAX_NUMBER_OF_REQUESTS) {
                return false;
            } else {
                queue.offer(time);
                return true;
            }

        }
    }
}
