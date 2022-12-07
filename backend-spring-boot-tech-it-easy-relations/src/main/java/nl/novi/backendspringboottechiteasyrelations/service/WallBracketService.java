package nl.novi.backendspringboottechiteasyrelations.service;

import nl.novi.backendspringboottechiteasyrelations.dto.WallBracketDto;
import nl.novi.backendspringboottechiteasyrelations.model.WallBracket;
import nl.novi.backendspringboottechiteasyrelations.repository.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository repository;
    public WallBracketService(WallBracketRepository repository){
        this.repository = repository;
    }

    public List<WallBracketDto> getAllWallBracket(){
        List<WallBracket> list = repository.findAll();
        List<WallBracketDto> dtoList = new ArrayList<>();

        for (WallBracket wallBracket : list){
            WallBracketDto dto = transferToDto(wallBracket);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public WallBracketDto transferToDto(WallBracket wallBracket){
        WallBracketDto dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAjustable(wallBracket.getAjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());

        return dto;
    }
}
