package SagaChoreography;

import java.util.concurrent.ThreadLocalRandom;

// Sample service implementation
class SampleService implements Service {
    private String name;

    public SampleService(String name) {
        this.name = name;
    }

    @Override
    public void performAction() {
        System.out.println(name + ": Performing action...");
        // Simulate successful action
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ": Action completed successfully");
    }

    @Override
    public void compensateAction() {
        System.out.println(name + ": Compensating action...");
        // Simulate compensating action
        System.out.println(name + ": Compensation completed");
    }
}