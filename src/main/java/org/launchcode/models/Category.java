package org.launchcode.models;

//import com.sun.istack.internal.NotNull;
import javax.validation.constraints.NotNull;

//import org.springframework.data.annotation.Id;
import javax.persistence.*;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
*/
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @OneToMany
    //tells Hibernate to use category_id column of  cheese table to determine which cheese belong to a given category.
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();


    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
