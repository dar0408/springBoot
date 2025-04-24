package com.bridgelabz.addressBook.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressBookDTO {
    private Integer id;
    public String name;
    public String address;
}
