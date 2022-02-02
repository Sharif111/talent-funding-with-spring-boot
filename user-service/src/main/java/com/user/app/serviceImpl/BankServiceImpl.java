package com.user.app.serviceImpl;

import com.user.app.entity.BankEntity;
import com.user.app.entity.DonarEntity;
import com.user.app.exception.ResourceNotFoundException;
import com.user.app.model.BankDto;
import com.user.app.repository.BankRepo;
import com.user.app.repository.DonarRepo;
import com.user.app.service.BankService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {
    public BankServiceImpl(BankRepo bankRepo,DonarRepo donarRepo)
    {
        this.bankRepo = bankRepo;
        this.donarRepo=donarRepo;
    }

    private BankRepo bankRepo;
    private DonarRepo donarRepo;


    @Override
    public BankDto createBank(long donarId, BankDto bankDto) {
        BankEntity bankEntity=mapToEntity(bankDto);

        // retrieve donar entity by id
        DonarEntity donarEntity = donarRepo.findById(donarId).orElseThrow(
                () -> new ResourceNotFoundException("DonarEntity", "id", donarId));

        // set donar to comment entity
        bankEntity.setDonarEntity(donarEntity);

        // bank entity to DB
        BankEntity newBankEntity =  bankRepo.save(bankEntity);

        return mapToDTO(newBankEntity);

    }

    // convert Entity into DTO
    private BankDto mapToDTO(BankEntity bankEntity){
        BankDto bankDto = new BankDto();
        bankDto.setBankId(bankEntity.getBankId());
        bankDto.setBankName(bankEntity.getBankName());
        bankDto.setBranchName(bankEntity.getBranchName());
        bankDto.setBranchCode(bankEntity.getBranchCode());
        bankDto.setAccountNo(bankEntity.getAccountNo());
        bankDto.setAccountTitle(bankEntity.getAccountTitle());
        bankDto.setAccountType(bankEntity.getAccountType());
        return bankDto;
    }



    // convert DTO to entity
    private BankEntity mapToEntity(BankDto bankDto){
        BankEntity bankEntity = new BankEntity();
        bankEntity.setBankName(bankDto.getBankName());
        bankEntity.setBranchName(bankDto.getBranchName());
        bankEntity.setBranchCode(bankDto.getBranchCode());
        bankEntity.setAccountNo(bankDto.getAccountNo());
        bankEntity.setAccountTitle(bankDto.getAccountTitle());
        bankEntity.setAccountType(bankDto.getAccountType());

        return bankEntity;
    }


    @Override
    public List<BankDto> getAllBanks() {
        List<BankEntity> banks = bankRepo.findAll();
        return banks.stream().map(bankEntity -> mapToDTO(bankEntity)).collect(Collectors.toList());
    }


    @Override
    public BankDto getBankById(long id) {
        BankEntity bankEntity = bankRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("BankEntity", "id", id));
        return mapToDTO(bankEntity);
    }

    @Override
    public BankDto updateBank(BankDto bankDto, long id) {
        // get bank by id from the database
        BankEntity bankEntity = bankRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("BankEntity", "id", id));

        bankEntity.setBankName(bankDto.getBankName());
        bankEntity.setBranchName(bankDto.getBranchName());
        bankEntity.setBranchCode(bankDto.getBranchCode());
        bankEntity.setAccountNo(bankDto.getAccountNo());
        bankEntity.setAccountTitle(bankDto.getAccountTitle());
        bankEntity.setAccountType(bankDto.getAccountType());

        BankEntity updatedBank = bankRepo.save(bankEntity);
        return mapToDTO(updatedBank);
    }

    @Override
    public void deleteBankById(long id) {
        // get bank by id from the database
        BankEntity bankEntity = bankRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("BankEntity", "id", id));
        bankRepo.delete(bankEntity);
    }
}
