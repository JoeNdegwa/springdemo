package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("images")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoadImage {

    @Id
    private String id;
    private String name;
    private String type;
    private byte[] imageData;


    public LoadImage(String name, String type, byte[] imageData) {
        this.name = name;
        this.type = type;
        this.imageData = imageData;
    }


}
