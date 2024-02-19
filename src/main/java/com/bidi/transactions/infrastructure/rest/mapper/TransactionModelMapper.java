package com.bidi.transactions.infrastructure.rest.mapper;

import com.bidi.transactions.domain.model.RequestCreateTransaction;
import com.bidi.transactions.domain.model.RequestGetTransactionByDate;
import com.bidi.transactions.domain.model.ResponseTransaction;
import com.bidi.transactions.infrastructure.rest.dto.request.CreateTransactionRequest;
import com.bidi.transactions.infrastructure.rest.dto.request.GetTransactionByDateRequest;
import com.bidi.transactions.infrastructure.rest.dto.response.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionModelMapper {
    TransactionModelMapper INSTANCE = Mappers.getMapper(TransactionModelMapper.class);

    RequestCreateTransaction requestInfrastructureToRequestDomain(CreateTransactionRequest createTransactionRequest);
    RequestGetTransactionByDate requestInfrastructureToRequestDomain(GetTransactionByDateRequest getTransactionByDateRequest);
    TransactionResponse responseDomainToInfrastructure(ResponseTransaction responseTransaction);
    List<TransactionResponse> responseDomainToInfrastructure(List<ResponseTransaction> responseTransaction);
}
