package SagaOrchestrator;

// Sample implementation of a Saga step
class SampleSagaStep implements SagaStep {
    private String name;
    private boolean successful;

    public SampleSagaStep(String name) {
        this.name = name;
        this.successful = false;
    }

    @Override
    public boolean execute() {
        System.out.println("Executing step: " + name);
        // Simulate successful execution
        this.successful = true;
        return true;
    }

    @Override
    public boolean compensate() {
        if (successful) {
            System.out.println("Compensating step: " + name);
            // Implement compensating logic to revert changes made in execute()
            return true;
        }
        return false;
    }
}