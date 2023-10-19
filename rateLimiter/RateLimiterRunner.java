package rateLimiter;

import java.util.concurrent.TimeUnit;

public class RateLimiterRunner {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(2, 2, TimeUnit.MICROSECONDS);

        for (int i = 0; i < 15; i++) {
            if (fixedWindowRateLimiter.allowRequest()) {
                System.out.println("Request " + i + " allowed.");
            } else {
                System.out.println("Request " + i + " blocked due to rate limiting.");
            }
            Thread.sleep(2000);
        }
    }
}
