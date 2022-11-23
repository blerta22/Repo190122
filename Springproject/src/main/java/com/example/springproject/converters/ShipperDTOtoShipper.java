package com.example.springproject.converters;

import com.example.springproject.dto.ShipperDTO;
import com.example.springproject.model.Shipper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ShipperDTOtoShipper implements Converter<ShipperDTO,Shipper> {

    @Override
    public Shipper convert(ShipperDTO source) {

     if(source!=null)  {
        Shipper shipper=new Shipper();
        if(source.getId()!=null){
            shipper.setId(source.getId());}
        shipper.setCompanyName(source.getCompanyName());
        shipper.setPhone(source.getPhone());
        return shipper;
     }
        return null;
    }
}
