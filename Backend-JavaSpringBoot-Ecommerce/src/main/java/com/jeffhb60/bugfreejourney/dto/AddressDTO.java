package com.jeffhb60.bugfreejourney.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AddressDTO {
    private Long addressId;
    private String street;
    private String buildingName;
    private String city;
    private String state;
    private String country;
    private String postalCode;

}
