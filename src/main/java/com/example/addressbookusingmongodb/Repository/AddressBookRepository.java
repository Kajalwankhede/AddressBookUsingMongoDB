package com.example.addressbookusingmongodb.Repository;

import com.example.addressbookusingmongodb.Model.AddressBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressBookRepository extends MongoRepository<AddressBook,String> {
    List<AddressBook> getPersonByName(String name);
    List<AddressBook> getPersonDataByCity(String city);
    List<AddressBook> getPersonDataByState(String state);
}