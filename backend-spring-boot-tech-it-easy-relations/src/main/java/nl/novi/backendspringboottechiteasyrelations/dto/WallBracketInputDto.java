package nl.novi.backendspringboottechiteasyrelations.dto;

import javax.validation.constraints.NotNull;

public class WallBracketInputDto {

    private Long id;
    private String size;
    private Boolean ajustable;
    @NotNull(message = "name is required")
    private String name;
    private Double price;

    public WallBracketInputDto() {
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
}
