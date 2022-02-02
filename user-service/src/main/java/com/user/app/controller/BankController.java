package com.user.app.controller;

import com.user.app.model.BankDto;
import com.user.app.service.BankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    final BankService bankService;

    // create bank rest api
    @PostMapping("/banks/{donarId}/donars")
    public ResponseEntity<BankDto>createBank(@PathVariable(value = "donarId") long donarId,
                                              @RequestBody BankDto bankDto){
        return new ResponseEntity<>(bankService.createBank(donarId,bankDto), HttpStatus.CREATED);
    }

    // get all banks rest api
    @GetMapping
    public List<BankDto> getAllBanks(){
        return bankService.getAllBanks();
    }

    // get bank by id
    @GetMapping("/{id}")
    public ResponseEntity<BankDto> getBankById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(bankService.getBankById(id));
    }

    // update bank by id rest api
    @PutMapping("/{id}")
    public ResponseEntity<BankDto> updateBank(@RequestBody BankDto bankDto, @PathVariable(name = "id") long id){
        BankDto bankEntityResponse = bankService.updateBank(bankDto, id);
        return new ResponseEntity<>(bankEntityResponse, HttpStatus.OK);
    }

    // delete bank by id rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBankEntity(@PathVariable(name = "id") long id){
        bankService.deleteBankById(id);
        return new ResponseEntity<>("Bank entity deleted successfully.", HttpStatus.OK);
    }



}
