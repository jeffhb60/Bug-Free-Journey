package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.AddressDTO;
import com.jeffhb60.bugfreejourney.model.User;
import jakarta.validation.Valid;

import java.util.List;

public interface AddressService {

    AddressDTO createAddress(AddressDTO addressDTO, User user);

    String deleteAddress(@Valid Long addressId);

    List<AddressDTO> getAddresses();

    AddressDTO getAddressById(Long addressId);

    List<AddressDTO> getUserAddresses(User user);

    @Valid
    AddressDTO updateAddressById(Long addressId, AddressDTO addressDTO);

}
