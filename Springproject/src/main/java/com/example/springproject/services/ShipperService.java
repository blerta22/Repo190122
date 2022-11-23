package com.example.springproject.services;

import com.example.springproject.converters.ShipperDTOtoShipper;
import com.example.springproject.converters.ShipperToShipperDTO;
import com.example.springproject.dto.ShipperDTO;
import com.example.springproject.exceptions.NotFoundException;
import com.example.springproject.repositories.ShipperRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipperService {
    private final ShipperDTOtoShipper shipperDTOtoShipper;
    private final ShipperToShipperDTO shipperToShipperDTO;
    private final ShipperRepository shipperRepository;

    public ShipperService(ShipperDTOtoShipper shipperDTOtoShipper, ShipperToShipperDTO shipperToShipperDTO, ShipperRepository shipperRepository) {
        this.shipperDTOtoShipper = shipperDTOtoShipper;
        this.shipperToShipperDTO = shipperToShipperDTO;
        this.shipperRepository = shipperRepository;
    }

    public List<ShipperDTO> findAll() {
       return  shipperRepository.findAll().stream().map(shipper -> shipperToShipperDTO.convert(shipper)).collect(Collectors.toList());

    }


    public ShipperDTO findShipperById(String id) {
        Long parseId;
        try {
            parseId = Long.parseLong(id);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Shipper id: \"" + id + "\" can't be parsed!");
        }
        return shipperToShipperDTO.convert(shipperRepository.findById(parseId).orElseThrow(()->new NotFoundException("Record with id: " + id + " not found!")));
    }


    public void saveOrUpdateShippeer(ShipperDTO shipperDTO) {
        shipperRepository.save(shipperDTOtoShipper.convert(shipperDTO));
    }


    public void deleteShipperById(String id) {
        try {
            Long parseId = Long.parseLong(id);
            shipperRepository.deleteById(parseId);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Shipper id: \"" + id + "\" can't be parsed!");
        }catch (EmptyResultDataAccessException e){
            throw new NotFoundException("Record with id: " + id + " not found!");
        }

    }
}
