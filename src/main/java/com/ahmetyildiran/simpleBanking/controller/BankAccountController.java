package com.ahmetyildiran.simpleBanking.controller;

import com.ahmetyildiran.simpleBanking.dto.BankAccountDto;
import com.ahmetyildiran.simpleBanking.dto.BankAccountSaveRequest;
import com.ahmetyildiran.simpleBanking.general.*;
import com.ahmetyildiran.simpleBanking.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/v1")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

       @PostMapping
        public ResponseEntity<BankAccountSaveRequest> save(@RequestBody BankAccountSaveRequest bankAccountSaveRequest){
            bankAccountService.createBankAccount(bankAccountSaveRequest);
            return ResponseEntity.ok(bankAccountSaveRequest);
        }

        @GetMapping("/{accountNumber}")
        public ResponseEntity<BankAccountDto> getAccountInfo(@PathVariable String accountNumber){

            BankAccountDto bankAccountDto = bankAccountService.getAccountInfo(accountNumber);
            return ResponseEntity.ok(bankAccountDto);
        }


        @PostMapping("/credit/{accountNumber}")
        public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestParam double amount) {
            TransactionAbs transaction = new CreditTransaction(amount);
           TransactionStatus status = bankAccountService.processTransaction(accountNumber,amount,transaction);
            return  ResponseEntity.ok(status);
        }



        @PostMapping("/debit/{accountNumber}")
        public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestParam double amount) {

            TransactionAbs transaction = new DebitTransaction(amount);
            TransactionStatus status = bankAccountService.processTransaction(accountNumber,amount,transaction);
            return  ResponseEntity.ok(status);
        }

        @PostMapping("/billPayment/{accountNumber}")
        public ResponseEntity<TransactionStatus> billPaymentTransaction(@PathVariable String accountNumber,@RequestParam double amount,@RequestParam String billName ){
            TransactionAbs transaction = new BillPaymentTransaction(amount, billName);
            TransactionStatus status = bankAccountService.processTransaction(accountNumber,amount,transaction);
            return  ResponseEntity.ok(status);
        }


}
