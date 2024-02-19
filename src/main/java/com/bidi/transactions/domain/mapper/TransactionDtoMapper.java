package com.bidi.transactions.domain.mapper;

import com.bidi.transactions.domain.entity.TransactionDao;
import com.bidi.transactions.domain.model.RequestCreateTransaction;
import com.bidi.transactions.domain.model.ResponseTransaction;
import com.bidi.transactions.infrastructure.rest.dto.request.CreateTransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionDtoMapper {
    TransactionDtoMapper INSTANCE = Mappers.getMapper(TransactionDtoMapper.class);

    ResponseTransaction daoToResponseDto (TransactionDao transactionDao);
    RequestCreateTransaction requestInfrastructureToRequestDomain(CreateTransactionRequest request);
    CreateTransactionRequest requestDomainToRequestInfrastructure(RequestCreateTransaction request);
}
