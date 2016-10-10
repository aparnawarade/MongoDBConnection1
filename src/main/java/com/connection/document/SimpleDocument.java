package com.connection.document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Document(collection="simpleDocument")
public class SimpleDocument {
    @Id
    String id;
    String name;
  
    public SimpleDocument(String id, String name){
        this.name = name;
        this.id = id;
    }
  
    @Override
    public String toString() {
        return String.format("[id = %s, name = %s]", id, name);
    }
} 