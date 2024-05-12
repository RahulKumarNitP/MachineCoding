package SagaChoreography;

// Interface for service actions
interface Service {
    void performAction();
    void compensateAction();
}