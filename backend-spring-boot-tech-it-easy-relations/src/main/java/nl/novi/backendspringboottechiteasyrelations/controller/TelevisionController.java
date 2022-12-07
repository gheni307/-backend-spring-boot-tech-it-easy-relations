package nl.novi.backendspringboottechiteasyrelations.controller;

import nl.novi.backendspringboottechiteasyrelations.dto.TelevisionDto;
import nl.novi.backendspringboottechiteasyrelations.dto.TelevisionInputDto;
import nl.novi.backendspringboottechiteasyrelations.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service){
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) Optional<String> brand){
        List<TelevisionDto> dtos;
        if (brand.isEmpty()){
            dtos = service.getAllTelevisions();
        } else {
            dtos = service.getAllTelevisionsByBrand(brand.get());
        }

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id){
        TelevisionDto televisionDto = service.getTelevisionById(id);

        return ResponseEntity.ok().body(televisionDto);
    }

    @PostMapping("")
    public ResponseEntity<TelevisionDto> createTelevision(@RequestBody TelevisionInputDto televisionInputDto){
        TelevisionDto dto = service.createTelevision(televisionInputDto);

        return ResponseEntity.created(null).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto televisionInputDto){
        TelevisionDto dto = service.updateTelevision(id, televisionInputDto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id){
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }


}








