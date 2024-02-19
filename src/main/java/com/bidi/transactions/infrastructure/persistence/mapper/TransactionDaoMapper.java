package com.bidi.transactions.infrastructure.persistence.mapper;

import com.bidi.transactions.domain.entity.TransactionDao;
import com.bidi.transactions.infrastructure.persistence.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionDaoMapper {
    TransactionDaoMapper INSTANCE = Mappers.getMapper(TransactionDaoMapper.class);

    TransactionDao transactionToTransactionDao(Transaction transaction);
}
