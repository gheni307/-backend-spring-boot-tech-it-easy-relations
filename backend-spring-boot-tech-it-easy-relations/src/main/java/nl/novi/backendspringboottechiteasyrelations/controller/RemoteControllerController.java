package nl.novi.backendspringboottechiteasyrelations.controller;

import nl.novi.backendspringboottechiteasyrelations.dto.RemoteControllerDto;
import nl.novi.backendspringboottechiteasyrelations.dto.RemoteControllerInputDto;
import nl.novi.backendspringboottechiteasyrelations.model.RemoteController;
import nl.novi.backendspringboottechiteasyrelations.service.RemoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("remote-controller")
public class RemoteControllerController {

    private final RemoteService service;
    public RemoteControllerController(RemoteService service){
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<RemoteControllerDto>> getAllRemoteController(){
        List<RemoteControllerDto> dtos = service.getAllRemoteControllers();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> getRemoteControllerById(@PathVariable Long id){
        RemoteControllerDto dto = service.getRemoteControllerById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("")
    public ResponseEntity<RemoteControllerDto> createRemoteController(@RequestBody RemoteControllerInputDto inputDto){
        RemoteControllerDto dto = service.createRemoteController(inputDto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerDto> updateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerInputDto inputDto){
        RemoteControllerDto dto = service.updateRemoteController(id, inputDto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRemoteController(@PathVariable Long id){
        service.deleteRemoteController(id);
        return ResponseEntity.ok().build();
    }
}
