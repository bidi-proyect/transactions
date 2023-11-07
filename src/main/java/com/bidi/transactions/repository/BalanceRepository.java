package com.bidi.transactions.repository;

import com.bidi.transactions.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    Balance findBalanceByPhoneNumber(String phoneNumber);

    Balance findBalanceByIdUser(String IdUser);
}
