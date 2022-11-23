package com.example.springproject.converters;


import com.example.springproject.dto.ShipperDTO;
import com.example.springproject.model.Shipper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShipperToShipperDTO implements Converter<Shipper, ShipperDTO> {


    @Override
    public ShipperDTO convert(Shipper source) {
        if(source!=null){
           ShipperDTO shipperDTO=new ShipperDTO();
           shipperDTO.setId(source.getId());
           shipperDTO.setCompanyName(source.getCompanyName());
           shipperDTO.setPhone(source.getPhone());
           return shipperDTO;
        }
        return null;
    }
}
