package rateLimiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiter{
    private final int maxRequests;
    private final long windowDuration; // Duration of each time window in milliseconds
    private final AtomicInteger requestCount = new AtomicInteger(0);
    private long currentWindowStartTime;

    public FixedWindowRateLimiter(int maxRequests, long windowDuration, TimeUnit timeUnit) {
        this.maxRequests = maxRequests;
        this.windowDuration = timeUnit.toMillis(windowDuration);
        this.currentWindowStartTime = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - currentWindowStartTime > windowDuration) {
            requestCount.set(0);
            currentWindowStartTime = currentTime;
        }
        if (requestCount.get() < maxRequests) {
            requestCount.incrementAndGet();
            return true;
        }
        return false;
    }

}
