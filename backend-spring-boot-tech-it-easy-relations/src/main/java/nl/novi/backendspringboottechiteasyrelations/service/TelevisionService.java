package nl.novi.backendspringboottechiteasyrelations.service;

import nl.novi.backendspringboottechiteasyrelations.dto.TelevisionDto;
import nl.novi.backendspringboottechiteasyrelations.dto.TelevisionInputDto;
import nl.novi.backendspringboottechiteasyrelations.exeption.RecordNotFoundException;
import nl.novi.backendspringboottechiteasyrelations.model.Television;
import nl.novi.backendspringboottechiteasyrelations.repository.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repository;
    public TelevisionService(TelevisionRepository r){
        this.repository = r;
    }

    public List<TelevisionDto> getAllTelevisions(){
        List<Television> tvList = repository.findAll();
        List<TelevisionDto> tvDtoList = new ArrayList<>();
        for (Television tv : tvList) {
            TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    public List<TelevisionDto> getAllTelevisionsByBrand(String brand){
        List<Television> tvList = repository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for (Television tv : tvList) {
            TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    public TelevisionDto getTelevisionById(Long id){
        Optional<Television> televisionOptional = repository.findById(id);
        if (televisionOptional.isPresent()){
            Television tv = televisionOptional.get();
            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }

    public TelevisionDto createTelevision(TelevisionInputDto dto){
        Television tv = transferToTelevision(dto);
        repository.save(tv);
        return transferToDto(tv);
    }

    public void deleteTelevision(@RequestBody Long id){
        repository.deleteById(id);
    }

    public TelevisionDto updateTelevision(Long id, TelevisionInputDto dto){
        Optional<Television> televisionOptional = repository.findById(id);
        if (televisionOptional.isPresent()){
            Television television1 = televisionOptional.get();

            television1.setId(dto.getId());
            television1.setType(dto.getType());
            television1.setBrand(dto.getBrand());
            television1.setPrice(dto.getPrice());
            television1.setAvailableSize(dto.getAvailableSize());
            television1.setRefreshRate(dto.getRefreshRate());
            television1.setScreenType(dto.getScreenType());
            television1.setScreenQuality(dto.getScreenQuality());
            television1.setSmartTv(dto.getSmartTv());
            television1.setWifi(dto.getWifi());
            television1.setVoiceControl(dto.getVoiceControl());
            television1.setHdr(dto.getHdr());
            television1.setBluetooth(dto.getBluetooth());
            television1.setAmbiLight(dto.getAmbiLight());
            television1.setOriginalStock(dto.getOriginalStock());
            television1.setSold(dto.getSold());
            Television returnTelevision = repository.save(television1);

            return transferToDto(returnTelevision);

        } else {
            throw new RecordNotFoundException("geen televisie gevonden");
        }
    }

    public TelevisionDto transferToDto(Television television){
        TelevisionDto dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());
        if (television.getRemoteController() != null){
            dto.setRemoteController(television.getRemoteController());
        }

        if (television.getWallBracket() != null){
            dto.setWallBracket(television.getWallBracket());
        }

        if (television.getCiModules() != null){
            dto.setCiModules(television.getCiModules());
        }

        return dto;
    }

    public Television transferToTelevision(TelevisionInputDto dto){
        Television television = new Television();

        television.setId(dto.getId());
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }

}
