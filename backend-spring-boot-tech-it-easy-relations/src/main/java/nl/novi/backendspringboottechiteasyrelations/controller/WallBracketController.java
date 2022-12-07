package nl.novi.backendspringboottechiteasyrelations.controller;

import nl.novi.backendspringboottechiteasyrelations.dto.WallBracketDto;
import nl.novi.backendspringboottechiteasyrelations.service.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wall-bracket")
public class WallBracketController {

    private final WallBracketService service;
    public WallBracketController(WallBracketService service){
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets(){
        List<WallBracketDto> dtos = service.getAllWallBracket();
        return ResponseEntity.ok().body(dtos);
    }
}
