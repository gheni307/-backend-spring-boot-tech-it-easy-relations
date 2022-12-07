package nl.novi.backendspringboottechiteasyrelations.controller;

import nl.novi.backendspringboottechiteasyrelations.dto.CiModuleDto;
import nl.novi.backendspringboottechiteasyrelations.service.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ci-module")
public class CiModuleController {

    private final CiModuleService service;
    public CiModuleController(CiModuleService service){
        this.service = service;
    }

    public ResponseEntity<List<CiModuleDto>> getAllCiModules(){
        List<CiModuleDto> dtos = service.getAllCiModule();
        return ResponseEntity.ok().body(dtos);
    }
}
