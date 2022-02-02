package com.user.app.service;

import com.user.app.dto.AddressInfoDto;
import com.user.app.entity.AddressInfoEntity;

import java.util.List;

public interface AddressService {

    List<AddressInfoDto> getAddresses();
    AddressInfoDto save( AddressInfoDto addressInfoDto);

    List<AddressInfoEntity> getAddresses2();
}
