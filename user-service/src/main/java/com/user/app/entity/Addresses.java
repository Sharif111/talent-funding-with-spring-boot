package com.user.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "AddressInfo")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addreesInfoId;

    private String addressTypeCode;
    private String addressDetails;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locationId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocationTree locationTree;

    public int getAddreesInfoId() {
        return addreesInfoId;
    }

    public void setAddreesInfoId(int addreesInfoId) {
        this.addreesInfoId = addreesInfoId;
    }



    public LocationTree getLocationTree() {
        return locationTree;
    }

    public void setLocationTree(LocationTree locationTree) {
        this.locationTree = locationTree;
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
}
