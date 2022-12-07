package nl.novi.backendspringboottechiteasyrelations.service;

import nl.novi.backendspringboottechiteasyrelations.dto.RemoteControllerDto;
import nl.novi.backendspringboottechiteasyrelations.dto.RemoteControllerInputDto;
import nl.novi.backendspringboottechiteasyrelations.exeption.RecordNotFoundException;
import nl.novi.backendspringboottechiteasyrelations.model.RemoteController;
import nl.novi.backendspringboottechiteasyrelations.repository.RemoteControllerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteService {

    private final RemoteControllerRepository repository;
    public RemoteService(RemoteControllerRepository repository){
        this.repository = repository;
    }

    public List<RemoteControllerDto> getAllRemoteControllers(){
        List<RemoteController> remoteControllers = repository.findAll();
        List<RemoteControllerDto> dtos = new ArrayList<>();
        for (RemoteController remoteController : remoteControllers){
            RemoteControllerDto dto = transferToDto(remoteController);
            dtos.add(dto);
        }
        return dtos;
    }

    public RemoteControllerDto getRemoteControllerById(Long id){
        Optional<RemoteController> remoteController = repository.findById(id);
        if (remoteController.isPresent()){
            RemoteController remoteController1 = remoteController.get();
            return transferToDto(remoteController1);
        } else {
            throw new RecordNotFoundException("remoteController is niet gevonden");
        }
    }

    public RemoteControllerDto createRemoteController(RemoteControllerInputDto inputDto){
        RemoteController rc = transferToRemoteController(inputDto);
        repository.save(rc);
        return transferToDto(rc);
    }

    public RemoteControllerDto updateRemoteController(Long id, RemoteControllerInputDto inputDto){
        Optional<RemoteController> remoteController = repository.findById(id);
        if (remoteController.isPresent()){
            RemoteController remoteController1 = remoteController.get();

            remoteController1.setId(inputDto.getId());
            remoteController1.setCompatibleWith(inputDto.getCompatibleWith());
            remoteController1.setBatteryType(inputDto.getBatteryType());
            remoteController1.setName(inputDto.getName());
            remoteController1.setBrand(inputDto.getBrand());
            remoteController1.setPrice(inputDto.getPrice());
            remoteController1.setOriginalStock(inputDto.getOriginalStock());

            RemoteController returnRemoteController = repository.save(remoteController1);

            return transferToDto(returnRemoteController);
        } else {
            throw new RecordNotFoundException("remoteController is niet gevonden");
        }
    }

    public void deleteRemoteController(@RequestBody Long id){
        repository.deleteById(id);
    }

    public RemoteControllerDto transferToDto(RemoteController remoteController){

        RemoteControllerDto dto = new RemoteControllerDto();

        dto.setId(remoteController.getId());
//        private String compatibleWith;
        dto.setCompatibleWith(remoteController.getCompatibleWith());
//        private String batteryType;
        dto.setBatteryType(remoteController.getBatteryType());
//        private String name;
        dto.setName(remoteController.getName());
//        private String brand;
        dto.setBrand(remoteController.getBrand());
//        private Double price;
        dto.setPrice(remoteController.getPrice());
//        private Integer originalStock;
        dto.setOriginalStock(remoteController.getOriginalStock());

        return dto;
    }

    public RemoteController transferToRemoteController(RemoteControllerInputDto dto){
        RemoteController remoteController = new RemoteController();

        remoteController.setId(dto.getId());
        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setName(dto.getName());
        remoteController.setBrand(dto.getBrand());
        remoteController.setPrice(dto.getPrice());
        remoteController.setOriginalStock(dto.getOriginalStock());

        return remoteController;
    }
}
