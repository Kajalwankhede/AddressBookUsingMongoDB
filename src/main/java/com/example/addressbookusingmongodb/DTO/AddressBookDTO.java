package com.example.addressbookusingmongodb.DTO;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class AddressBookDTO {
 private String id;
private String name;
 private String address;
 private String city;
private String state;
 private String zip;
private String phoneNumber;
private String email;

}
