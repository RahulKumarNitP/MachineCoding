import service.SimpleDocumentService;

public class SimpleDocumentAppRunner {
    public static void main(String[] args) {
        SimpleDocumentService documentService = new SimpleDocumentService();

        // Creating users
        System.out.println(documentService.createUser("alice")); //User created successfully.
        System.out.println(documentService.createUser("bob")); //User created successfully.

        // Creating documents
        System.out.println(documentService.createDocument("alice", "document1", "This is document 1.")); // Document created successfully.
        System.out.println(documentService.createDocument("bob", "document2", "This is document 2.")); // Document created successfully.

        // Reading documents
        System.out.println(documentService.readDocument("alice", "document1")); // This is document 1.
        System.out.println(documentService.readDocument("bob", "document2")); // This is document 2.
        System.out.println(documentService.readDocument("bob", "document1")); // You don't have read access to this document.

        // Editing documents
        System.out.println(documentService.editDocument("alice", "document1", "Updated content.")); // Document edited successfully.
        System.out.println(documentService.editDocument("bob", "document2", "New content.")); // Document edited successfully.
        System.out.println(documentService.editDocument("bob", "document1", "Try to edit.")); // You don't have edit access to this document.

        // Granting access
        System.out.println(documentService.grantAccess("alice", "document1", "bob", true, true)); // Access granted successfully.
        System.out.println(documentService.editDocument("bob", "document1", "Now I can edit.")); // Document edited successfully.

        // Deleting documents
        System.out.println(documentService.deleteDocument("alice", "document1")); // Document deleted successfully.
        System.out.println(documentService.deleteDocument("bob", "document2")); // You don't have permission to delete this document.
    }
}