package com.jeffhb60.bugfreejourney.controller;

import com.jeffhb60.bugfreejourney.dto.AddressDTO;
import com.jeffhb60.bugfreejourney.model.User;
import com.jeffhb60.bugfreejourney.repositories.AddressRepository;
import com.jeffhb60.bugfreejourney.service.AddressService;
import com.jeffhb60.bugfreejourney.util.AuthUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;
    private final AuthUtil authUtil;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddressForCurrentUser(@Valid @RequestBody AddressDTO addressDTO) {
        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO, user);
        return new ResponseEntity<AddressDTO>(savedAddressDTO, HttpStatus.CREATED);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAddresses() {
        List<AddressDTO> addressList = addressService.getAddresses();
        return new ResponseEntity<List<AddressDTO>>(addressList, HttpStatus.OK);
    }

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@Valid @PathVariable Long addressId) {
        AddressDTO addressDTO = addressService.getAddressById(addressId);
        return new ResponseEntity<AddressDTO>(addressDTO, HttpStatus.OK);
    }

    @GetMapping("/users/addresses")
    public ResponseEntity<List<AddressDTO>> getAddressesByLoggedInUser() {
        User user = authUtil.loggedInUser();
        List<AddressDTO> addressList = addressService.getUserAddresses(user);
        return new ResponseEntity<List<AddressDTO>>(addressList, HttpStatus.OK);
    }

    @PutMapping("/addresses/{addressId}")
    public ResponseEntity<AddressDTO> updateAddressById(@Valid @RequestBody AddressDTO addressDTO, @PathVariable Long addressId) {
        AddressDTO updatedAddress = addressService.updateAddressById(addressId, addressDTO);
        return new ResponseEntity<AddressDTO>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<String> deleteAddress(@Valid @PathVariable Long addressId) {
        String status = addressService.deleteAddress(addressId);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

}
