package SagaOrchestrator;

public class SagaOrchestratorExample {
    public static void main(String[] args) {
        // Create Saga orchestrator
        SagaOrchestrator orchestrator = new SagaOrchestrator();

        // Add Saga steps
        orchestrator.addStep(new SampleSagaStep("Step 1"));
        orchestrator.addStep(new SampleSagaStep("Step 2"));
        orchestrator.addStep(new SampleSagaStep("Step 3"));

        // Execute the Saga
        if (orchestrator.executeSaga()) {
            System.out.println("Saga executed successfully");
        } else {
            System.out.println("Saga execution failed");
        }
    }
}
