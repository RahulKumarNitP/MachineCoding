package SagaChoreography;

public class SagaChoreographyExample {
    public static void main(String[] args) {
        // Create sample services
        Service serviceA = new SampleService("Service A");
        Service serviceB = new SampleService("Service B");
        Service serviceC = new SampleService("Service C");

        // Simulate a Saga choreography
        try {
            // Perform actions
            serviceA.performAction();
            serviceB.performAction();
            serviceC.performAction();
        } catch (Exception e) {
            // If any action fails, compensate all previous actions
            serviceC.compensateAction();
            serviceB.compensateAction();
            serviceA.compensateAction();
            System.out.println("Saga choreography failed");
            return;
        }

        // If all actions succeed, the Saga choreography is completed
        System.out.println("Saga choreography completed successfully");
    }
}
