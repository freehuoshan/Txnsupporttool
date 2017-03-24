package query.service.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class DataModel {

    private String invoiceId;
    private String paymentType;
    private String transactionType;
    private Double transactionAmount;
    private Date transactionReceivedDate;
    private String batchType;
    private Boolean isBatchClosed;
    private Date batchCloseDate;
    private String dispositionStatus;
    private Boolean mlinkProcessed;
    private String mlinkResponseCode;
    private Date transactionDate;
    private Boolean pendRTCTable;
    private Boolean loadArchiveTable;
    private Boolean loadIHUBAUTHTable;
    private Boolean loadIHUBTXNTable;
    private Boolean clearingFile;
    private Boolean settlementFile;
    private Boolean rejectFile;
    private Boolean isPriced;

    public DataModel() {

    }

    public DataModel(String invoiceId, String paymentType, String transactionType, Double transactionAmount,
                     Date transactionReceivedDate, String batchType, Boolean isBatchClosed, Date batchCloseDate,
                     String dispositionStatus, Boolean mlinkProcessed, String mlinkResponseCode, Date transactionDate,
                     Boolean pendRTCTable, Boolean loadArchiveTable, Boolean loadIHUBAUTHTable, Boolean loadIHUBTXNTable,
                     Boolean clearingFile, Boolean settlementFile, Boolean rejectFile, Boolean isPriced) {
        super();
        this.invoiceId = invoiceId;
        this.paymentType = paymentType;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionReceivedDate = transactionReceivedDate;
        this.batchType = batchType;
        this.isBatchClosed = isBatchClosed;
        this.batchCloseDate = batchCloseDate;
        this.dispositionStatus = dispositionStatus;
        this.mlinkProcessed = mlinkProcessed;
        this.mlinkResponseCode = mlinkResponseCode;
        this.transactionDate = transactionDate;
        this.pendRTCTable = pendRTCTable;
        this.loadArchiveTable = loadArchiveTable;
        this.loadIHUBAUTHTable = loadIHUBAUTHTable;
        this.loadIHUBTXNTable = loadIHUBTXNTable;
        this.clearingFile = clearingFile;
        this.settlementFile = settlementFile;
        this.rejectFile = rejectFile;
        this.isPriced = isPriced;
    }

    @JsonProperty("invoiceId")
    public String getinvoiceId() {
        return invoiceId;
    }

    public void setinvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @JsonProperty("paymentType")
    public String getpaymentType() {
        return paymentType;
    }

    public void setpaymenType(String paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("transactionType")
    public String gettransactionType() {
        return transactionType;
    }

    public void settransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @JsonProperty("transactionAmount")
    public Double gettransactionAmount() {
        return transactionAmount;
    }

    public void settransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @JsonProperty("transactionReceivedDate")
    public Date gettransactionReceivedDate() {
        return transactionReceivedDate;
    }

    public void settransactionReceivedDate(Date transactionReceivedDate) {
        this.transactionReceivedDate = transactionReceivedDate;
    }

    @JsonProperty("batchType")
    public String getbatchType() {
        return batchType;
    }

    public void setbatchType(String batchType) {
        this.batchType = batchType;
    }

    @JsonProperty("isBatchClosed")
    public Boolean getisBatchClosed() {
        return isBatchClosed;
    }

    public void setisBatClosed(Boolean isBatchClosed) {
        this.isBatchClosed = isBatchClosed;
    }

    @JsonProperty("batchCloseDate")
    public Date getbatchCloseDate() {
        return batchCloseDate;
    }

    public void setbatchCloseDate(Date batchCloseDate) {
        this.batchCloseDate = batchCloseDate;
    }

    @JsonProperty("dispositionStatus")
    public String getdispositionStatus() {
        return dispositionStatus;
    }

    public void setdispositionStatus(String dispositionStatus) {
        this.dispositionStatus = dispositionStatus;
    }

    @JsonProperty("mlinkProcessed")
    public Boolean getmlinkProcessed() {
        return mlinkProcessed;
    }

    public void setmlinkProcessed(Boolean mlinkProcessed) {
        this.mlinkProcessed = mlinkProcessed;
    }

    @JsonProperty("mlinkResponseCode")
    public String getmlinkResponseCode() {
        return mlinkResponseCode;
    }

    public void setmlinkResponseCode(String mlinkResponseCode) {
        this.mlinkResponseCode = mlinkResponseCode;
    }

    @JsonProperty("transactionDate")
    public Date gettransactionDate() {
        return transactionDate;
    }

    public void settransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @JsonProperty("pendRTCTable")
    public Boolean getpendRTCTable() {
        return pendRTCTable;
    }

    public void setpendRTCTable(Boolean pendRTCTable) {
        this.pendRTCTable = pendRTCTable;
    }

    @JsonProperty("loadArchiveTable")
    public Boolean getloadArchiveTable() {
        return loadArchiveTable;
    }

    public void setloadArchiveTable(Boolean loadArchiveTable) {
        this.loadArchiveTable = loadArchiveTable;
    }

    @JsonProperty("loadIhubAuthTable")
    public Boolean getloadIHUBAUTHTable() {
        return loadIHUBAUTHTable;
    }

    public void setloadIHUBAUTHTable(Boolean loadIHUBAUTHTable) {
        this.loadIHUBAUTHTable = loadIHUBAUTHTable;
    }

    @JsonProperty("loadIhubTxnTable")
    public Boolean getloadIHUBTXNTable() {
        return loadIHUBTXNTable;
    }

    public void setloadIHUBTXNTable(Boolean loadIHUBTXNTable) {
        this.loadIHUBTXNTable = loadIHUBTXNTable;
    }

    @JsonProperty("clearingFile")
    public Boolean getclearingFile() {
        return clearingFile;
    }

    public void setclearingFile(Boolean clearingFile) {
        this.clearingFile = clearingFile;
    }

    @JsonProperty("settlementFile")
    public Boolean getsettlementFile() {
        return settlementFile;
    }

    public void setsettlementFile(Boolean settlementFile) {
        this.settlementFile = settlementFile;
    }

    @JsonProperty("rejectFile")
    public Boolean getrejectFile() {
        return rejectFile;
    }

    public void setrejectFile(Boolean rejectFile) {
        this.rejectFile = rejectFile;
    }

    @JsonProperty("isPriced")
    public Boolean getisPriced() {
        return isPriced;
    }

    public void setisPriced(Boolean isPriced) {
        this.isPriced = isPriced;
    }

    @Override
    public String toString() {
        return "DataModel [invoiceId=" + invoiceId + ", paymentType=" + paymentType + ", transactionType="
                + transactionType + ", transactionAmount=" + transactionAmount + ", transactionReceivedDate="
                + transactionReceivedDate + ", batchType=" + batchType + ", isBatchClosed=" + isBatchClosed
                + ", batchCloseDate=" + batchCloseDate + ", dispositionStatus=" + dispositionStatus
                + ", mlinkProcessed=" + mlinkProcessed + ", mlinkResponseCode=" + mlinkResponseCode
                + ", transactionDate=" + transactionDate + ", pendRTCTable=" + pendRTCTable + ", loadArchiveTable="
                + loadArchiveTable + ", loadIHUBAUTHTable=" + loadIHUBAUTHTable + ", loadIHUBTXNTable="
                + loadIHUBTXNTable + ", clearingFile=" + clearingFile + ", settlementFile=" + settlementFile
                + ", rejectFile=" + rejectFile + ", isPriced=" + isPriced + "]";
    }
}
