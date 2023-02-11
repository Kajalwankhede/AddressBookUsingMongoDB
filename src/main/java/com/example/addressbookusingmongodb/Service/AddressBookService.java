package com.example.addressbookusingmongodb.Service;
import com.example.addressbookusingmongodb.DTO.AddressBookDTO;
import com.example.addressbookusingmongodb.Exception.AddressBookException;
import com.example.addressbookusingmongodb.Model.AddressBook;
import com.example.addressbookusingmongodb.Repository.AddressBookRepository;
import com.example.addressbookusingmongodb.Util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    TokenUtil tokenUtil;

    private List<AddressBook> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBook> getAllPersonRecords() {

        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook createPersonContact(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(addressBookDTO);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @Override
    public AddressBook getPersonRecordById(String id) {
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Person with id" + id + "doesnt exist!!"));

    }

    @Override
    public AddressBook updatePersonRecordById(String id, AddressBookDTO addressBookDTO) {
        AddressBook addressBookData = this.getPersonRecordById(id);
        addressBookData.updatePersonData(addressBookDTO);
        return addressBookRepository.save(addressBookData);

    }

    @Override
    public void deletePersonRecordById(String id) {
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        if (addressBook.isPresent()) {
            addressBookRepository.deleteById(id);
        } else {
            throw new AddressBookException("Sorry! Cannot find user id: " + id);
        }
    }

    @Override
    public List<AddressBook> getPersonRecordByName(String name) {
        List<AddressBook> getByName = addressBookRepository.getPersonByName(name);
        if (getByName.isEmpty()) {
            throw new ArithmeticException("Sorry! Can not find user name: " + name);
        } else {
            return addressBookRepository.getPersonByName(name);
        }
    }

    @Override
    public List<AddressBook> getPersonRecordByCity(String city) {
        return addressBookRepository.getPersonDataByCity(city);
    }

    @Override
    public List<AddressBook> getPersonRecordByState(String state) {
        return addressBookRepository.getPersonDataByState(state);
    }



}
