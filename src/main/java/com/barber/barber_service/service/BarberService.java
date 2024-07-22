package com.barber.barber_service.service;

import com.barber.barber_service.dto.BarberDTO;
import com.barber.barber_service.dto.ListBarberDTO;
import com.barber.barber_service.dto.UpdatePasswordDTO;
import com.barber.barber_service.model.Barber;
import com.barber.barber_service.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarberService {

    @Autowired
    BarberRepository repository;

    public ResponseEntity<Barber> createCustomer (BarberDTO dto){
        if (repository.findByEmail(dto.getEmail()).isPresent()){
            return new ResponseEntity("Email already exist", HttpStatus.BAD_REQUEST);
        }
        Barber newBarber = new Barber();

        newBarber.setName(dto.getName());
        newBarber.setEmail(dto.getEmail());
        newBarber.setPassword(dto.getPassword());
        newBarber.setPhone(dto.getPhone());
        newBarber.setLocation(dto.getLocation());
        newBarber.setBio(dto.getBio());

        repository.save(newBarber);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

    public ResponseEntity<Barber> updateBarber (Long id, BarberDTO dto){
        Optional<Barber> existingData = repository.findById(id);

        if (existingData.isPresent()){
            Barber updateData = existingData.get();

            updateData.setName(dto.getName());
            updateData.setEmail(dto.getEmail());
            updateData.setPassword(dto.getPassword());
            updateData.setPhone(dto.getPhone());
            updateData.setLocation(dto.getLocation());
            updateData.setBio(dto.getBio());

            repository.save(updateData);

            return new ResponseEntity(dto, HttpStatus.OK);
        }else{
            return new ResponseEntity("account doesnt exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<BarberDTO> getDataById (Long id){
        Optional<Barber> existingData = repository.findById(id);

        if (existingData.isPresent()){
            BarberDTO dto = new BarberDTO();
            Barber data = existingData.get();

            dto.setName(data.getName());
            dto.setEmail(data.getEmail());
            dto.setPassword(data.getPassword());
            dto.setPhone(data.getPhone());
            dto.setLocation(data.getLocation());
            dto.setBio(data.getBio());
            dto.setRating(data.getRating());

            return new ResponseEntity(dto, HttpStatus.OK);
        }else{
            return new ResponseEntity("account doesnt exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<BarberDTO> getDataByEmail (String email){
        Optional<Barber> existingData = repository.findByEmail(email);

        if (existingData.isPresent()){
            BarberDTO dto = new BarberDTO();
            Barber data = existingData.get();

            dto.setName(data.getName());
            dto.setEmail(data.getEmail());
            dto.setPassword(data.getPassword());
            dto.setPhone(data.getPhone());
            dto.setLocation(data.getLocation());
            dto.setBio(data.getBio());
            dto.setRating(data.getRating());

            return new ResponseEntity(dto, HttpStatus.OK);
        }else{
            return new ResponseEntity("account doesnt exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<UpdatePasswordDTO> updatePassword (Long id, UpdatePasswordDTO dto){
        Optional<Barber> existingData = repository.findById(id);

        if (existingData.isPresent()){
            Barber data = existingData.get();

            if (dto.getOldPassword().equals(data.getPassword())){
                data.setPassword(dto.getNewPassword());

                repository.save(data);

                return new ResponseEntity("Password updated", HttpStatus.OK);
            }else {
                return new ResponseEntity("Password doesnt match", HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity("account doesnt exist", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<ListBarberDTO>> getAllBarber(){
        List<Barber> datas = repository.findAll();
        if (datas != null && !datas.isEmpty()){
            List<ListBarberDTO> dto = datas.stream()
                    .map(barber -> new ListBarberDTO(
                            barber.getName(),
                            barber.getPhone(),
                            barber.getLocation(),
                            barber.getBio()
                    ))
                    .collect(Collectors.toList());

            return new ResponseEntity(dto, HttpStatus.OK);
        }else {
            return new ResponseEntity(new ArrayList<>(), HttpStatus.OK);
        }
    }
}
