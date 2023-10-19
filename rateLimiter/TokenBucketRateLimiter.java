package rateLimiter;

public class TokenBucketRateLimiter implements RateLimiter {
    private final int capacity;
    private final double refillRate; // Tokens per second
    private double tokens;
    private long lastRefillTime;

    public TokenBucketRateLimiter(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }
    @Override
    public synchronized boolean allowRequest() {
        refillTokens();
        if (tokens >= 1) {
            tokens -= 1;
            return true;
        }
        return false;
    }
    private void refillTokens() {
        long currentTime = System.nanoTime();
        double elapsedTime = (currentTime - lastRefillTime) / 1e9; // Convert to seconds
        tokens = Math.min(capacity, tokens + elapsedTime * refillRate);
        lastRefillTime = currentTime;
    }
}
