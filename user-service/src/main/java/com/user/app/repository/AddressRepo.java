package com.user.app.repository;

import com.user.app.entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Addresses,Integer> {

    //AddressInfoEntity findByLocationID(Long locationId);
  //  AddressInfoEntity findByIdAndLocationId(Long id, Long locationId);
}
