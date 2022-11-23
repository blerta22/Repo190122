package com.example.springproject.restController;

import com.example.springproject.dto.ShipperDTO;
import com.example.springproject.services.ShipperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipper")
public class ShipperController {
    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping({"","/"})
    public List<ShipperDTO> findAll(){
       return shipperService.findAll();

    }



    @GetMapping("/{id}")
    public ShipperDTO findShipperById(@PathVariable String id)
    {
      return  shipperService.findShipperById(id);

    }

    @PostMapping
    public void saveOrUpdateShipper(@RequestBody ShipperDTO shipperDTO){
        shipperService.saveOrUpdateShippeer(shipperDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteShipperById(@PathVariable String id){

    shipperService.deleteShipperById(id);


    }




}
