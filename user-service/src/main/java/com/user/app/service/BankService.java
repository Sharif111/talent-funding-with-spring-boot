package com.user.app.service;

import com.user.app.model.BankDto;

import java.util.List;

public interface BankService {
    BankDto createBank(long donarId, BankDto bankDto);

    List<BankDto> getAllBanks();

    BankDto getBankById(long id);

    BankDto updateBank(BankDto bankDto, long id);

    void deleteBankById(long id);
}
