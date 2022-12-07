package nl.novi.backendspringboottechiteasyrelations.dto;

import javax.validation.constraints.NotNull;

public class CiModuleInputDto {

    private Long id;
    @NotNull(message = "name is required")
    private String name;
    private String type;
    private Double price;

    public CiModuleInputDto() {
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
