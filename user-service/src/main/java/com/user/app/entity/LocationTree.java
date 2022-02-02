package com.user.app.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "location_tree")
public class LocationTree  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;


    private String treeType;
    private int treeCode;
    private String treeName;
    private int sortOrder;
    private int treeLevel;

    @OneToMany(mappedBy = "locationTree", cascade = CascadeType.ALL)
    private Set<Addresses> locations = new HashSet<>();

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Set<Addresses> getLocations() {
        return locations;
    }

    public void setLocations(Set<Addresses> locations) {
        this.locations = locations;
        for(Addresses a : locations) {
            a.setLocationTree(this);
        }
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


}
