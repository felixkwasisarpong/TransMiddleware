package com.kafka.TansMiddleware.Service;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface TransactionService {
  void save(String user) throws Exception;
}
