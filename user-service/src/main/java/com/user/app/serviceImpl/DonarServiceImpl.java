package com.user.app.serviceImpl;



import com.user.app.entity.DonarEntity;
import com.user.app.model.DonarDto;
import com.user.app.repository.DonarRepo;
import com.user.app.service.DonarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonarServiceImpl implements DonarService {
    public DonarServiceImpl(DonarRepo donarRepo) {
        this.donarRepo = donarRepo;
    }

    @Override
    public DonarDto createDonar(DonarDto donarDto) {


        // convert DTO to entity
        DonarEntity donarEntity = mapToEntity(donarDto);
        DonarEntity newDonarEntity = donarRepo.save(donarEntity);


        // convert entity to DTO
        DonarDto donarResponse = mapToDTO(newDonarEntity);
        return donarResponse;
    }

    private DonarRepo donarRepo;

    // convert Entity into DTO
    private DonarDto mapToDTO(DonarEntity donarEntity){
        DonarDto donarDto = new DonarDto();
        donarDto.setDonarId(donarEntity.getDonarId());
        donarDto.setDonarName(donarEntity.getDonarName());
        donarDto.setDonarType(donarEntity.getDonarType());
        donarDto.setDonarMail(donarEntity.getDonarMail());
        donarDto.setDonarPhoneNo(donarEntity.getDonarPhoneNo());
        donarDto.setDonarProfession(donarEntity.getDonarProfession());
        donarDto.setDonarDesignation(donarEntity.getDonarDesignation());
        donarDto.setOrganizationName(donarEntity.getOrganizationName());
        donarDto.setOrganizationType(donarEntity.getOrganizationType());
        donarDto.setOrganizationEstablishDate(donarEntity.getOrganizationEstablishDate());
        donarDto.setOrganizationEmail(donarEntity.getOrganizationEmail());
        donarDto.setOrganizationPhoneNo(donarEntity.getOrganizationPhoneNo());
        donarDto.setOrganizationMdName(donarEntity.getOrganizationMdName());
        donarDto.setOrganizationMdPhoneNo(donarEntity.getOrganizationMdPhoneNo());
        donarDto.setOrganizationMdEmail(donarEntity.getOrganizationMdEmail());
        return donarDto;
    }



    // convert DTO to entity
    private DonarEntity mapToEntity(DonarDto donarDto){
        DonarEntity donarEntity = new DonarEntity();
        donarEntity.setDonarName(donarDto.getDonarName());
        donarEntity.setDonarType(donarDto.getDonarType());
        donarEntity.setDonarMail(donarDto.getDonarMail());
        donarEntity.setDonarPhoneNo(donarDto.getDonarPhoneNo());
        donarEntity.setDonarProfession(donarDto.getDonarProfession());
        donarEntity.setDonarDesignation(donarDto.getDonarDesignation());
        donarEntity.setOrganizationName(donarDto.getOrganizationName());
        donarEntity.setOrganizationType(donarDto.getOrganizationType());
        donarEntity.setOrganizationEstablishDate(donarDto.getOrganizationEstablishDate());
        donarDto.setOrganizationMdName(donarDto.getOrganizationMdName());
        donarDto.setOrganizationMdPhoneNo(donarDto.getOrganizationMdPhoneNo());
        donarEntity.setOrganizationEmail(donarDto.getOrganizationMdEmail());
        return donarEntity;
    }

    @Override
    public List<DonarDto> getAllDonars() {
        return null;
    }

    @Override
    public DonarDto getDonarById(long id) {
        return null;
    }

    @Override
    public DonarDto updateDonar(DonarDto donarDto, long id) {
        return null;
    }

    @Override
    public void deleteDonarById(long id) {

    }
}
