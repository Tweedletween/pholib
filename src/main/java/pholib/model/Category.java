package pholib.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by melina on 3/28/17.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String colorCode;

    @OneToMany(mappedBy = "category")
    private List<Pho> phos = new ArrayList<>();

    public Category() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public List<Pho> getPhos() {
        return phos;
    }
}
