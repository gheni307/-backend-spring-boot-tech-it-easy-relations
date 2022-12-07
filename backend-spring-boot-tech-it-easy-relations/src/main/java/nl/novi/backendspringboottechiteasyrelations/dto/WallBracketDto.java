package nl.novi.backendspringboottechiteasyrelations.dto;

import nl.novi.backendspringboottechiteasyrelations.model.Television;

import java.util.List;

public class WallBracketDto {

    private Long id;
    private String size;
    private Boolean ajustable;
    private String name;
    private Double price;
    private List<Television> television;

    public WallBracketDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAjustable() {
        return ajustable;
    }

    public void setAjustable(Boolean ajustable) {
        this.ajustable = ajustable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Television> getTelevision() {
        return television;
    }

    public void setTelevision(List<Television> television) {
        this.television = television;
    }
}
