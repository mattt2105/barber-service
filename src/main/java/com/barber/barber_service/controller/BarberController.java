package com.barber.barber_service.controller;

import com.barber.barber_service.dto.BarberDTO;
import com.barber.barber_service.dto.ListBarberDTO;
import com.barber.barber_service.dto.UpdatePasswordDTO;
import com.barber.barber_service.model.Barber;
import com.barber.barber_service.repository.BarberRepository;
import com.barber.barber_service.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbers")
public class BarberController {

    @Autowired
    BarberService service;

    @PostMapping("/barber/create")
    public ResponseEntity<Barber> createCustomer (@RequestBody BarberDTO dto){
        return service.createCustomer(dto);
    }

    @PutMapping("/barber/update/{id}")
    public ResponseEntity<Barber> updateCustomer(
            @PathVariable Long id,
            @RequestBody BarberDTO dto){
        return service.updateBarber(id,dto);
    }

    @GetMapping("/barber/get/by/id/{id}")
    public ResponseEntity<BarberDTO> getDataById(@PathVariable Long id){
        return service.getDataById(id);
    }

    @GetMapping("/barber/get/by/email/{email}")
    public ResponseEntity<BarberDTO> getDataByEmail(@PathVariable String email){
        return service.getDataByEmail(email);
    }

    @PutMapping("/barber/update/password/{id}")
    public ResponseEntity<UpdatePasswordDTO> updateCustomerPassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordDTO dto){
        return service.updatePassword(id,dto);
    }

    @GetMapping("/barber/get/all/barber")
    public ResponseEntity<List<ListBarberDTO>> getAllBarber(){
        return service.getAllBarber();
    }

}
