package nl.novi.backendspringboottechiteasyrelations.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import nl.novi.backendspringboottechiteasyrelations.model.Television;

public class CiModuleDto {

    private Long id;
    private String name;
    private String type;
    private Double price;
    @JsonIncludeProperties("id")
    private Television television;

    public CiModuleDto() {
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

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}
