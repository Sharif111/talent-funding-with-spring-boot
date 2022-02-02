package com.user.app.serviceImpl;

import com.user.app.dto.AddressInfoDto;
import com.user.app.entity.AddressInfoEntity;
import com.user.app.entity.LocationTreeEntity;
import com.user.app.repository.AddressRepo;
import com.user.app.service.AddressService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AddressInfoDto> getAddresses() {

       // List<AddressInfoEntity> addressInfoEntities = addressRepo.findAll();
        //System.out.println("addressInfoEntities.toString() = " + addressInfoEntities.toString());
     /*  for(AddressInfoEntity a :addressInfoEntities){
           LocationTreeEntity locationTree = a.getLocationTree();


       }
       */

        //Type listType = new TypeToken<List<AddressInfoDto>>(){}.getType();
        //return modelMapper.map(addressInfoEntities,listType);

        //return addressInfoEntities.stream().map(product ->
            //    entityToDto(product)).collect(Collectors.toList());


        //return modelMapper.map(AddressInfoDto.class,addressInfoEntities);
        return null;
    }

    @Override
    public AddressInfoDto save(AddressInfoDto addressInfoDto) {
        return null;
    }

    @Override
    public List<AddressInfoEntity> getAddresses2() {
        //return  addressRepo.findAll();
        return null;
    }


    public AddressInfoDto entityToDto(AddressInfoEntity addressInfoEntity){
        AddressInfoDto productDto = modelMapper.map(addressInfoEntity,AddressInfoDto.class);

//        ProductDto productDto = new ProductDto();
//        productDto.setProductId(product.getProductId());
//        productDto.setProductName(product.getProductName());
//        productDto.setProductDescription(product.getProductDescription());
//        productDto.setProductCreateDate(product.getProductCreateDate());
        return productDto;
    }


//    private AddressInfoDto convertToDto(AddressInfoEntity post) {
//        AddressInfoDto postDto = modelMapper.map(post, AddressInfoDto.class);
//        postDto.setSubmissionDate(post.getSubmissionDate(),
//                userService.getCurrentUser().getPreference().getTimezone());
//        return postDto;
//    }
//
//    @Override
//    public List<AddressInfoEntity> getAddresses() {
//        return addressRepo.findAll();
//    }
//
//    @Override
//    public AddressInfoEntity save(AddressInfoEntity addressInfoEntity) {
//        return addressRepo.save(addressInfoEntity);
//    }


}
