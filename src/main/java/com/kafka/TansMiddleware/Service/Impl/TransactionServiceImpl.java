package com.kafka.TansMiddleware.Service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.TansMiddleware.Model.Transaction;
import com.kafka.TansMiddleware.Repository.TransactionRepository;
import com.kafka.TansMiddleware.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void save(String trans) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.err.println(trans);
            JsonNode jsonNode = objectMapper.readTree(trans);
            // Set fields from JSON string or parse JSON string and set fields accordingly
            Transaction transaction = new Transaction();

            transaction.setMti(jsonNode.get("MTI").asInt());
            transaction.setAmount(jsonNode.get("amount").asText());
            transaction.setCardAccId(jsonNode.get("card_acc_id").asText());
            transaction.setProCode(jsonNode.get("proCode").asText());
            transaction.setDateLocal(jsonNode.get("date_local").asText());
            transaction.setCardAccTermId(jsonNode.get("card_acc_term_id").asText());
            transaction.setAcqInstId(jsonNode.get("acq_inst_id").asText());
            transaction.setPosCode(jsonNode.get("pos_code").asText());
            transaction.setTimeLocal(jsonNode.get("time_local").asText());
            transaction.setTraceNumber(jsonNode.get("Trace_number").asText());
            transaction.setTransmissionDtime(jsonNode.get("Transmission_dtime").asText());
            transaction.setRetRefNum(jsonNode.get("ret_ref_num").asText());
            transaction.setMerchName(jsonNode.get("merch_name").asText());
            transaction.setCurrency(jsonNode.get("currency").asText());

            // Save entity
            transactionRepository.save(transaction);
        } catch (JsonProcessingException | DataAccessException e) {
            throw e; // Re-throw the caught exception
        } catch (Exception e) {
            throw new Exception("An error occurred while saving transaction data", e);
        }
    }
}
