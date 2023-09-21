package com.ahmetyildiran.simpleBanking.mapper;

import com.ahmetyildiran.simpleBanking.dto.BankAccountDto;
import com.ahmetyildiran.simpleBanking.dto.BankAccountSaveRequest;
import com.ahmetyildiran.simpleBanking.model.BankAccount;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccountMapper {

    public static BankAccount convertBankAccount(BankAccountDto bankAccountDto) {
        BankAccount entity = null;
        if (bankAccountDto != null) {
            entity = new BankAccount();
            entity.setId(bankAccountDto.getId());
            entity.setOwner(bankAccountDto.getOwner());
            entity.setAccountNumber(bankAccountDto.getAccountNumber());
            entity.setBalance(bankAccountDto.getBalance());

        }

        return entity;
    }


    public static BankAccount convertRequestToBankAccount(BankAccountSaveRequest bankAccountSaveRequest) {
        BankAccount entity = null;
        if (bankAccountSaveRequest != null) {
            entity = new BankAccount();
            entity.setOwner(bankAccountSaveRequest.getOwner());
            entity.setAccountNumber(bankAccountSaveRequest.getAccountNumber());
            entity.setBalance(0.0);
            entity.setCreateDate(new Date());

        }
        return entity;
    }

    public static BankAccountDto convertBankAccountDto(BankAccount bankAccount) {
        BankAccountDto dto = null;
        if (bankAccount != null) {
            dto = new BankAccountDto();
            dto.setId(bankAccount.getId());
            dto.setOwner(bankAccount.getOwner());
            dto.setAccountNumber(bankAccount.getAccountNumber());
            dto.setBalance(bankAccount.getBalance());
            dto.setCreateDate(bankAccount.getCreateDate());
            dto.setTransactionDtoList(TransactionMapper.convertDtoList(bankAccount.getTransactions()));
        }
        return dto;

    }

    public static List<BankAccount> convertEntityList(List<BankAccountDto> dtoList){
        List<BankAccount> mappedList = new ArrayList<>();
        BankAccount entity;
        if (dtoList != null){
            for (BankAccountDto dto : dtoList){
                entity = convertBankAccount(dto);
                mappedList.add(entity);
            }
        }
        return mappedList;
    }


    public static List<BankAccountDto> convertDtoList(List<BankAccount> entityList){
        List<BankAccountDto> mappedList = new ArrayList<>();
        BankAccountDto dto;
        if (entityList != null){
            for (BankAccount entity : entityList){
                dto = convertBankAccountDto(entity);
                mappedList.add(dto);
            }
        }
        return mappedList;
    }

}