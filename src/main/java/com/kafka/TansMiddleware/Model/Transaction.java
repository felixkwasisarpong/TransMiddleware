package com.kafka.TansMiddleware.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getMti() {
        return mti;
    }

    public void setMti(int mti) {
        this.mti = mti;
    }

    public String getCardAccId() {
        return cardAccId;
    }

    public void setCardAccId(String cardAccId) {
        this.cardAccId = cardAccId;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getDateLocal() {
        return dateLocal;
    }

    public void setDateLocal(String dateLocal) {
        this.dateLocal = dateLocal;
    }

    public String getCardAccTermId() {
        return cardAccTermId;
    }

    public void setCardAccTermId(String cardAccTermId) {
        this.cardAccTermId = cardAccTermId;
    }

    public String getAcqInstId() {
        return acqInstId;
    }

    public void setAcqInstId(String acqInstId) {
        this.acqInstId = acqInstId;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getTimeLocal() {
        return timeLocal;
    }

    public void setTimeLocal(String timeLocal) {
        this.timeLocal = timeLocal;
    }

    public String getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getTransmissionDtime() {
        return transmissionDtime;
    }

    public void setTransmissionDtime(String transmissionDtime) {
        this.transmissionDtime = transmissionDtime;
    }

    public String getRetRefNum() {
        return retRefNum;
    }

    public void setRetRefNum(String retRefNum) {
        this.retRefNum = retRefNum;
    }

    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    @JsonProperty("MTI")
    private int mti;

    @JsonProperty("proCode")
    private String proCode;
    @JsonProperty("amount")
    private String amount;

    @JsonProperty("Transmission_dtime")
    private String transmissionDtime;

    @JsonProperty("Trace_number")
    private String traceNumber;

    @JsonProperty("time_local")
    private String timeLocal;
    @JsonProperty("date_local")
    private String dateLocal;
    @JsonProperty("pos_code")
    private String posCode;
    @JsonProperty("acq_inst_id")
    private String acqInstId;

    @JsonProperty("ret_ref_num")
    private String retRefNum;

    @JsonProperty("card_acc_term_id")
    private String cardAccTermId;

    @JsonProperty("card_acc_id")
    private String cardAccId;
    @JsonProperty("merch_name")
    private String merchName;

    @JsonProperty("currency")
    private String currency;











}
