// Coordinator class to manage the two-phase commit protocol
class Coordinator {
    private List<Database> participants = new ArrayList<>();

    public void register(Database db) {
        participants.add(db);
    }

    public boolean commit() {
        try {
            // Phase 1: Ask all participants to prepare
            for (Database participant : participants) {
                participant.prepare();
            }

            // Phase 2: Commit if all participants prepared successfully
            for (Database participant : participants) {
                participant.commit();
            }
            return true;
        } catch (Exception e) {
            // Rollback if any error occurs
            rollback();
            return false;
        }
    }

    private void rollback() {
        for (Database participant : participants) {
            try {
                participant.rollback();
            } catch (Exception e) {
                // Log or handle rollback failure
            }
        }
    }
}