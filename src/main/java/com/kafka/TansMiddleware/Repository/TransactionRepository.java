package com.kafka.TansMiddleware.Repository;

import com.kafka.TansMiddleware.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByretRefNum(String retRefNum);

}
