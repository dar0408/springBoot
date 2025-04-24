package com.bridgelabz.addressBook.repository;

import com.bridgelabz.addressBook.modle.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepo extends JpaRepository<AddressBookModel,Integer> {

}
