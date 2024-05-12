import java.util.ArrayList;
import java.util.List;

public class TwoPhaseCommitExample {
    public static void main(String[] args) {
        // Create databases
        SampleDatabase db1 = new SampleDatabase();
        SampleDatabase db2 = new SampleDatabase();

        // Register databases with the coordinator
        Coordinator coordinator = new Coordinator();
        coordinator.register(db1);
        coordinator.register(db2);

        // Simulate a transaction
        db1.addData("Data1");
        db2.addData("Data2");

        // Perform two-phase commit
        if (coordinator.commit()) {
            System.out.println("Transaction committed successfully");
        } else {
            System.out.println("Transaction failed, rolling back");
        }
    }
}
