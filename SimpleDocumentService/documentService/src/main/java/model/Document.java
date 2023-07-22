package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public
class Document {
    private String name;
    private String content;
    private String owner;
    private List<String> readAccessList;
    private List<String> editAccessList;

    public Document(String name, String content, String owner) {
        this.name = name;
        this.content = content;
        this.owner = owner;
        this.readAccessList = new ArrayList<>();
        this.editAccessList = new ArrayList<>();
        this.readAccessList.add(owner); // Owner always has read access
        this.editAccessList.add(owner); // Owner always has edit access
    }
}