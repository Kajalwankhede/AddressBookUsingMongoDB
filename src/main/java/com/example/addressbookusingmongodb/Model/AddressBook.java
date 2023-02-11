package com.example.addressbookusingmongodb.Model;

import com.example.addressbookusingmongodb.DTO.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@Document(collection ="personDetails")
public class AddressBook {
 @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String city;
    @NonNull
    private String state;
    @NonNull
    private String zip;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String email;
    public AddressBook(AddressBook addressBook) {}
    public AddressBook( AddressBookDTO addressBookDTO) {
        this.updatePersonData(addressBookDTO);
    }
    public void updatePersonData(AddressBookDTO addressBookDTO) {
        this.name = addressBookDTO.getName();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.zip = addressBookDTO.getZip();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.email = addressBookDTO.getEmail();
    }
}
