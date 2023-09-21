package com.ahmetyildiran.simpleBanking.mapper;

import com.ahmetyildiran.simpleBanking.dto.TransactionDto;
import com.ahmetyildiran.simpleBanking.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {


    public static TransactionDto convertTransactionDto(Transaction transaction){
        TransactionDto dto = null;
        if (transaction != null){
            dto = new TransactionDto();
            dto.setType(transaction.getType());
            dto.setDate(transaction.getDate());
            dto.setAmount(transaction.getAmount());
            dto.setApprovalCode(transaction.getApprovalCode());
        }
        return dto;
    }


public static List<TransactionDto> convertDtoList(List<Transaction> entityList){

    List<TransactionDto> mappedList = new ArrayList<>();
    TransactionDto dto;
    if (entityList != null){
        for (Transaction entity : entityList){
            dto = convertTransactionDto(entity);
            mappedList.add(dto);
        }
    }
    return mappedList;

    }

}
