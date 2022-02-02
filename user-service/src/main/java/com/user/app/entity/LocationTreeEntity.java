package com.user.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name = "location_tree")
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Getter
//@Setter
public class LocationTreeEntity{
/*
    @Id

    @SequenceGenerator(
            name = "locationId",
            sequenceName = "locationId",
            allocationSize = 1,
            initialValue = 200
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "locationId"
    )
    private long locationId;
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private String treeType;
    private int treeCode;
    private String treeName;
    private int sortOrder;
    private int treeLevel;

  //  @JsonIgnore
  //@ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "locationTree",orphanRemoval = true)
    private Set<AddressInfoEntity> addressInfos = new HashSet<>();


    //@OneToMany(mappedBy = "locationTree", cascade = CascadeType.ALL, orphanRemoval = true) 

   // private Set<AddressInfoEntity> addressInfos = new HashSet<>();


    //@OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "fk_addressInfoId",referencedColumnName = "locationId")
    // private List<AddressInfoEntity> addressInfos;

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public int getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(int treeCode) {
        this.treeCode = treeCode;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getTreeLevel() {
        return treeLevel;
    }

    public void setTreeLevel(int treeLevel) {
        this.treeLevel = treeLevel;
    }

    public Set<AddressInfoEntity> getAddressInfos() {
        return addressInfos;
    }

    public void setAddressInfos(Set<AddressInfoEntity> addressInfos) {
        this.addressInfos = addressInfos;

        for(AddressInfoEntity a: addressInfos){
            a.setLocationTree(this);
        }
    }

    */
}
