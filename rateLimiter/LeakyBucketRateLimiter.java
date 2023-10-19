package rateLimiter;

public class LeakyBucketRateLimiter implements RateLimiter{
    private final int capacity;
    private final double leakRate; // Requests per second
    private int water;
    private long lastLeakTime;

    public LeakyBucketRateLimiter(int capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.water = 0;
        this.lastLeakTime = System.nanoTime();
    }
    @Override
    public synchronized boolean allowRequest() {
        leakWater();
        if (water < capacity) {
            water += 1;
            return true;
        }
        return false;
    }
    private void leakWater() {
        long currentTime = System.nanoTime();
        double elapsedTime = (currentTime - lastLeakTime) / 1e9; // Convert to seconds
        int leakedWater = (int) (elapsedTime * leakRate);
        water = Math.max(0, water - leakedWater);
        lastLeakTime = currentTime;
    }
}
