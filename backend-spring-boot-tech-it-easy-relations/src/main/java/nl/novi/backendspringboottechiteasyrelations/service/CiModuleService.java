package nl.novi.backendspringboottechiteasyrelations.service;

import nl.novi.backendspringboottechiteasyrelations.dto.CiModuleDto;
import nl.novi.backendspringboottechiteasyrelations.model.CiModule;
import nl.novi.backendspringboottechiteasyrelations.repository.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiModuleService {

    private final CiModuleRepository repository;
    public CiModuleService(CiModuleRepository repository){
        this.repository = repository;
    }

    public List<CiModuleDto> getAllCiModule(){
        List<CiModule> ciModuleList = repository.findAll();
        List<CiModuleDto> dtos = new ArrayList<>();

        for(CiModule ciModule : ciModuleList){
            CiModuleDto dto = transferToDto(ciModule);
            dtos.add(dto);
        }
        return dtos;
    }

    public CiModuleDto transferToDto(CiModule ciModule){
        CiModuleDto dto = new CiModuleDto();

        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setPrice(ciModule.getPrice());

        return dto;
    }
}
