package nl.novi.backendspringboottechiteasyrelations.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ci_module")
public class CiModule {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private Double price;

    @ManyToOne
    private Television television;

    public CiModule() {
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
