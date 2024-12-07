package com.jeffhb60.bugfreejourney.service;

import com.jeffhb60.bugfreejourney.dto.AddressDTO;
import com.jeffhb60.bugfreejourney.exceptions.CustomResourceNotFoundException;
import com.jeffhb60.bugfreejourney.model.Address;
import com.jeffhb60.bugfreejourney.model.User;
import com.jeffhb60.bugfreejourney.repositories.AddressRepository;
import com.jeffhb60.bugfreejourney.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {
        Address address = modelMapper.map(addressDTO, Address.class);

        List<Address> addressList = user.getAddresses();
        addressList.add(address);
        user.setAddresses(addressList);

        address.setUser(user);
        Address savedAddress = addressRepository.save(address);
        return null;
    }

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .toList();
    }

    @Override
    public AddressDTO getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Address", "addressId", addressId));
        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getUserAddresses(User user) {
        List<Address> addresses = user.getAddresses();
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .toList();

    }

    @Override
    public AddressDTO updateAddressById(Long addressId, AddressDTO addressDTO) {
        Address dbAddress = addressRepository.findById(addressId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Address", "addressId", addressId));

        if (!addressDTO.getStreet().isBlank()) {dbAddress.setStreet(addressDTO.getStreet());}
        if (!addressDTO.getBuildingName().isBlank()) {dbAddress.setBuildingName(addressDTO.getBuildingName());}
        if (!addressDTO.getCity().isBlank()) {dbAddress.setCity(addressDTO.getCity());}
        if (!addressDTO.getState().isBlank()) {dbAddress.setState(addressDTO.getState());}
        if (!addressDTO.getPostalCode().isBlank()) {dbAddress.setPostalCode(addressDTO.getPostalCode());}
        if (!addressDTO.getCountry().isBlank()) {dbAddress.setCountry(addressDTO.getCountry());}
        else {dbAddress.setCountry("United States of America ");}

        Address updatedAddress = addressRepository.save(dbAddress);

        User user = dbAddress.getUser();
        user.getAddresses().removeIf(address -> address.getAddressId().equals(updatedAddress.getAddressId()));
        user.getAddresses().add(updatedAddress);

        userRepository.save(user);
        return modelMapper.map(updatedAddress, AddressDTO.class);
    }

    @Override
    public String deleteAddress(Long addressId) {
        Address dbAddress = addressRepository.findById(addressId)
                .orElseThrow(() -> new CustomResourceNotFoundException("Address", "addressId", addressId));
        User user = dbAddress.getUser();
        user.getAddresses().removeIf(address -> address.getAddressId().equals(dbAddress.getAddressId()));
        userRepository.save(user);
        addressRepository.delete(dbAddress);
        return "Address Id: " + dbAddress.getAddressId() + " Deleted";
    }
}
