package SagaOrchestrator;

import java.util.ArrayList;
import java.util.List;

class SagaOrchestrator {
    private List<SagaStep> steps = new ArrayList<>();

    public void addStep(SagaStep step) {
        steps.add(step);
    }

    public boolean executeSaga() {
        // Execute all steps
        for (SagaStep step : steps) {
            if (!step.execute()) {
                // Step failed, compensate and return false
                compensateFailedSteps(steps.indexOf(step));
                return false;
            }
        }
        return true;
    }

    private void compensateFailedSteps(int index) {
        // Compensate all steps executed before the failed step
        for (int i = index - 1; i >= 0; i--) {
            steps.get(i).compensate();
        }
    }
}