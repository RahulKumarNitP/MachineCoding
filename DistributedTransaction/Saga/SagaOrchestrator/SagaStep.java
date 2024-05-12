package SagaOrchestrator;

// Interface for Saga steps
interface SagaStep {
    boolean execute();
    boolean compensate();
}