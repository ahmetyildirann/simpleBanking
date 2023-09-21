package com.ahmetyildiran.simpleBanking.service;

import com.ahmetyildiran.simpleBanking.dto.BankAccountDto;
import com.ahmetyildiran.simpleBanking.dto.BankAccountSaveRequest;
import com.ahmetyildiran.simpleBanking.general.TransactionAbs;
import com.ahmetyildiran.simpleBanking.general.TransactionStatus;
import com.ahmetyildiran.simpleBanking.mapper.BankAccountMapper;
import com.ahmetyildiran.simpleBanking.model.BankAccount;
import com.ahmetyildiran.simpleBanking.model.Transaction;
import com.ahmetyildiran.simpleBanking.repository.BankAccountRepository;
import com.ahmetyildiran.simpleBanking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankAccountService {


    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    public BankAccountSaveRequest createBankAccount(BankAccountSaveRequest bankAccountSaveRequest) {
        log.info("BankAccountService::createBankAccount|BankAccountSaveRequest : "+bankAccountSaveRequest);
        BankAccount bankAccount = BankAccountMapper.convertRequestToBankAccount(bankAccountSaveRequest);
        if (Objects.isNull(bankAccount)){
            log.info("user can not created.");
        }
        bankAccountRepository.save(bankAccount);

        return bankAccountSaveRequest;


    }

    public BankAccountDto getAccountInfo(String accountNumber) {
        log.info("BankAccountService::getAccountInfo|accountNumber : "+accountNumber);
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        if (!optionalBankAccount.isPresent()) {
            log.info("BankAccountService::getAccountInfo|account : Hesap bulunamadı: " + accountNumber);
            throw new IllegalStateException("Hesap bulunamadı: " + accountNumber);
        }
        BankAccount bankAccount = optionalBankAccount.get();
        BankAccountDto bankAccountDto = BankAccountMapper.convertBankAccountDto(bankAccount);
        return bankAccountDto;

    }

    public TransactionStatus processTransaction(String accountNumber, double amount, TransactionAbs transaction) {
        log.info("BankAccountService::processTransaction|accountNumber : "+accountNumber);
        log.info("BankAccountService::processTransaction|amount : "+amount);
        log.info("BankAccountService::processTransaction|transaction : "+transaction);
        Optional<BankAccount> optionalAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        if (optionalAccount.isPresent()) {
            BankAccount account = optionalAccount.get();
            transaction.execute(account);
            bankAccountRepository.save(account);

            TransactionStatus status = new TransactionStatus("OK", UUID.randomUUID().toString());

            transaction(transaction.getTransactionType(), amount, account, status.getApprovalCode());


            return status;
        } else {
            log.info("BankAccountService::processTransaction|Hesap bulunamadı : "+accountNumber);
            throw new IllegalStateException("Hesap bulunamadı: " + accountNumber);
        }
    }

    private void transaction(String transactionType, double amount, BankAccount account, String approvalCode) {
        log.info("BankAccountService::TransactionSave|transactionType : "+transactionType);
        log.info("BankAccountService::TransactionSave|amount : "+amount);
        log.info("BankAccountService::TransactionSave|account : "+account);
        log.info("BankAccountService::TransactionSave|approvalCode : "+approvalCode);
        Transaction transaction = new Transaction();
        transaction.setType(transactionType);
        transaction.setDate(new Date());
        transaction.setAmount(amount);
        transaction.setBankAccount(account);
        transaction.setApprovalCode(approvalCode);
        transactionRepository.save(transaction);
    }




}