package service;

import model.Document;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class SimpleDocumentService {
    private Map<String, Document> documents;
    private Map<String, User> users;

    public SimpleDocumentService() {
        documents = new HashMap<>();
        users = new HashMap<>();
    }

    public String createUser(String username) {
        if (users.containsKey(username)) {
            return "User:"+username + " already exists.";
        }

        users.put(username, new User(username));
        return "User:" + username +" created successfully.";
    }

    public String createDocument(String username, String name, String content) {
        if (!users.containsKey(username)) {
            return "User:"+username+" not found. Please sign up or log in.";
        }

        if (documents.containsKey(name)) {
            return "Document:"+name+" with the same name already exists.";
        }

        Document document = new Document(name, content, username);
        documents.put(name, document);
        return "Document:"+document+" created successfully.";
    }

    public String readDocument(String username, String documentName) {
        if (!users.containsKey(username)) {
            return "User:"+username+" not found. Please sign up or log in.";
        }

        if (!documents.containsKey(documentName)) {
            return "Document:"+documentName+" not found.";
        }

        Document document = documents.get(documentName);
        if (!document.getReadAccessList().contains(username)) {
            return "You don't have read access to this document: "+documentName;
        }

        return document.getContent();
    }

    public String editDocument(String username, String documentName, String newContent) {
        if (!users.containsKey(username)) {
            return "User:"+username+" not found. Please sign up or log in.";
        }

        if (!documents.containsKey(documentName)) {
            return "Document:"+documentName+" not found.";
        }

        Document document = documents.get(documentName);
        if (!document.getEditAccessList().contains(username)) {
            return "You don't have edit access to this document: "+documentName;
        }

        document.setContent(newContent);
        return "Document:"+documentName+" edited successfully.";
    }

    public String grantAccess(String ownerUsername, String documentName, String targetUsername, boolean canRead, boolean canEdit) {
        if (!users.containsKey(ownerUsername) || !users.containsKey(targetUsername)) {
            return "Invalid users.";
        }

        if (!documents.containsKey(documentName)) {
            return "Document:"+documentName+" not found.";
        }

        Document document = documents.get(documentName);
        if (!document.getOwner().equals(ownerUsername)) {
            return "You don't have permission to grant access to this document: "+documentName;
        }

        if (canRead && !document.getReadAccessList().contains(targetUsername)) {
            document.getReadAccessList().add(targetUsername);
        }

        if (canEdit && !document.getEditAccessList().contains(targetUsername)) {
            document.getEditAccessList().add(targetUsername);
        }

        return "Access granted successfully.";
    }

    public String deleteDocument(String username, String documentName) {
        if (!users.containsKey(username)) {
            return "User not found. Please sign up or log in.";
        }

        if (!documents.containsKey(documentName)) {
            return "Document:"+documentName+" not found.";
        }

        Document document = documents.get(documentName);
        if (!document.getOwner().equals(username)) {
            return "You don't have permission to delete this document:"+documentName;
        }

        documents.remove(documentName);
        return "Document:"+documentName+" deleted successfully.";
    }
}