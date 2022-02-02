package com.user.app.serviceImpl;

import com.user.app.dto.LocationTreeDto;
import com.user.app.entity.AddressInfoEntity;
import com.user.app.entity.Addresses;
import com.user.app.entity.LocationTree;
import com.user.app.entity.LocationTreeEntity;
import com.user.app.repository.LocationRepo;
import com.user.app.responseModel.CommonResposeModel;
import com.user.app.service.LocationTreeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LocationTreeServiceImpl implements LocationTreeService {



    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LocationRepo locationRepo;

    @Override
    public CommonResposeModel save(LocationTreeDto locationTreeDto) {
        //LocationTree savedLibrary = locationRepo.save(library);
        CommonResposeModel commonResposeModel = new CommonResposeModel();
        LocationTree locationTree = new LocationTree();
/*

        locationTree.setTreeType(locationTreeDto.getTreeType());
        locationTree.setTreeCode(locationTreeDto.getTreeCode());
        locationTree.setTreeName(locationTreeDto.getTreeName());
        locationTree.setSortOrder(locationTreeDto.getSortOrder());
        locationTree.setTreeLevel(locationTreeDto.getTreeLevel());
        locationTree.setLocations(locationTreeDto.getAddressInfos());
*/

        LocationTree locationTreeEntity = locationRepo.save(modelMapper.map(locationTreeDto, LocationTree.class));

       if(locationTreeEntity.getLocationId()>0){
            commonResposeModel.setResposeCode("1");
          commonResposeModel.setResposeMessage("Data Save Successfull");
        }

        return commonResposeModel;
    }


    @Override
    public List<LocationTreeDto> getLocationTrees() {
        return null;
    }

//    @Override
//    public LocationTreeEntity save(LocationTreeEntity locationTreeEntity) {
//        return locationRepo.save(locationTreeEntity);
//    }
//
//    @Override
//    public List<LocationTreeEntity> getLocationTrees() {
//        return locationRepo.findAll();
//    }
}
