package com.user.app.dto;

import com.user.app.entity.LocationTree;


public class AddressInfoDto {

    private long addressInfoId;
    private String addressTypeCode;
    private String addressDetails;
    private LocationTree locationTree;

    public long getAddressInfoId() {
        return addressInfoId;
    }

    public void setAddressInfoId(long addressInfoId) {
        this.addressInfoId = addressInfoId;
    }

    public String getAddressTypeCode() {
        return addressTypeCode;
    }

    public void setAddressTypeCode(String addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public LocationTree getLocationTree() {
        return locationTree;
    }

    public void setLocationTree(LocationTree locationTree) {
        this.locationTree = locationTree;
    }
}
