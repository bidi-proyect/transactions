package com.bidi.transactions.infrastructure.persistence.repository;

import com.bidi.transactions.infrastructure.persistence.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionByPhoneProducer(String phoneProducer);
    @Query("SELECT t FROM Transaction t WHERE t.transactionDate BETWEEN :initDate AND :finalDate AND t.userId = :userId")
    List<Transaction> monthlyTransactions(@Param("initDate") Date initDate, @Param("finalDate") Date finalDate, @Param("userId") String userId);

}
