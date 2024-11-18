package org.example.eventpublish.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personal {

    @Id
    private String id;

    private String name;
    private String surname;
    private String state;
    private int age;
    private String email;

    private List<Products> products;


}
