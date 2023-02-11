package com.example.addressbookusingmongodb.Service;
import com.example.addressbookusingmongodb.DTO.AddressBookDTO;
import com.example.addressbookusingmongodb.Model.AddressBook;
import java.util.List;
public interface IAddressBookService {
    AddressBook createPersonContact(AddressBookDTO addressBookDTO);
    List<AddressBook> getAllPersonRecords();
    AddressBook getPersonRecordById(String id);
    AddressBook updatePersonRecordById(String id, AddressBookDTO addressBookDTO);
    void deletePersonRecordById(String id);
    public List<AddressBook> getPersonRecordByName(String name);
    public List<AddressBook> getPersonRecordByCity(String city);
    public List<AddressBook> getPersonRecordByState(String state);

}
