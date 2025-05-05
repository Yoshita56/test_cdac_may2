package billing;
import javax.sql.rowset.WebRowSet;

public class PrintVO 
{
	private static final long serialVersionUID = 02L;
	private String strMsgString = "";
	private String strMsgType = "0";
	
	private String strSeatId = "";
	private String strIpAddress = "";
	
	private String strBillNo = "0";
	private String strReceiptNo = "0";
	private String strReceiptType = "0";
	private String strChargeTypeID = "";
	private String strBServiceID = "";
	private String strHospCode ="";
	private String strAcctNo ="";
	private String strPrintFlag = "0";
	private int    strPrintLine = 0;
		
	private WebRowSet gblWs1 = null;
	private WebRowSet gblWs2 = null;
	private WebRowSet gblWs3 = null;//for estimation related details..
	
	private WebRowSet strOpdRefund = null;
	private WebRowSet strOpdRefund1 = null;
	
	private WebRowSet strIpdRefund = null;
	private WebRowSet strIpdRefund1 = null;
	
	private WebRowSet strOpdReconcil = null;
	private WebRowSet strOpdReconcil1 = null;
	
	private WebRowSet strIpdReconcil = null;
	private WebRowSet strIpdReconcil1 = null;
	
	private WebRowSet strIpdFinalSettle = null;
	private WebRowSet strIpdFinalSettle1 = null;
	
	private WebRowSet strAdvanceRefund = null;
	
	private WebRowSet strCounterAndUserName = null;
	
	private WebRowSet transpotationchrgs = null;
	private WebRowSet trasnpotationcolsolidatedws = null;
	private String strService="0";

	public WebRowSet getStrCounterAndUserName() {
		return strCounterAndUserName;
	}

	public void setStrCounterAndUserName(WebRowSet strCounterAndUserName) {
		this.strCounterAndUserName = strCounterAndUserName;
	}

	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrBillNo() {
		return strBillNo;
	}

	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}

	public String getStrReceiptNo() {
		return strReceiptNo;
	}

	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	public String getStrReceiptType() {
		return strReceiptType;
	}

	public void setStrReceiptType(String strReceiptType) {
		this.strReceiptType = strReceiptType;
	}

	public String getStrChargeTypeID() {
		return strChargeTypeID;
	}

	public void setStrChargeTypeID(String strChargeTypeID) {
		this.strChargeTypeID = strChargeTypeID;
	}

	public String getStrBServiceID() {
		return strBServiceID;
	}

	public void setStrBServiceID(String strBServiceID) {
		this.strBServiceID = strBServiceID;
	}

	public WebRowSet getGblWs1() {
		return gblWs1;
	}

	public void setGblWs1(WebRowSet gblWs1) {
		this.gblWs1 = gblWs1;
	}

	public String getStrHospCode() {
		return strHospCode;
	}

	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	public WebRowSet getGblWs2() {
		return gblWs2;
	}

	public void setGblWs2(WebRowSet gblWs2) {
		this.gblWs2 = gblWs2;
	}

	public String getStrAcctNo() {
		return strAcctNo;
	}

	public void setStrAcctNo(String strAcctNo) {
		this.strAcctNo = strAcctNo;
	}

	public int getStrPrintLine() {
		return strPrintLine;
	}

	public void setStrPrintLine(int strPrintLine) {
		this.strPrintLine = strPrintLine;
	}

	public WebRowSet getStrOpdRefund() {
		return strOpdRefund;
	}

	public void setStrOpdRefund(WebRowSet strOpdRefund) {
		this.strOpdRefund = strOpdRefund;
	}

	public WebRowSet getStrOpdRefund1() {
		return strOpdRefund1;
	}

	public void setStrOpdRefund1(WebRowSet strOpdRefund1) {
		this.strOpdRefund1 = strOpdRefund1;
	}

	public WebRowSet getStrIpdRefund() {
		return strIpdRefund;
	}

	public void setStrIpdRefund(WebRowSet strIpdRefund) {
		this.strIpdRefund = strIpdRefund;
	}

	public WebRowSet getStrIpdRefund1() {
		return strIpdRefund1;
	}

	public void setStrIpdRefund1(WebRowSet strIpdRefund1) {
		this.strIpdRefund1 = strIpdRefund1;
	}

	public WebRowSet getStrOpdReconcil() {
		return strOpdReconcil;
	}

	public void setStrOpdReconcil(WebRowSet strOpdReconcil) {
		this.strOpdReconcil = strOpdReconcil;
	}

	public WebRowSet getStrOpdReconcil1() {
		return strOpdReconcil1;
	}

	public void setStrOpdReconcil1(WebRowSet strOpdReconcil1) {
		this.strOpdReconcil1 = strOpdReconcil1;
	}

	public WebRowSet getStrIpdReconcil() {
		return strIpdReconcil;
	}

	public void setStrIpdReconcil(WebRowSet strIpdReconcil) {
		this.strIpdReconcil = strIpdReconcil;
	}

	public WebRowSet getStrIpdReconcil1() {
		return strIpdReconcil1;
	}

	public void setStrIpdReconcil1(WebRowSet strIpdReconcil1) {
		this.strIpdReconcil1 = strIpdReconcil1;
	}

	public WebRowSet getStrIpdFinalSettle() {
		return strIpdFinalSettle;
	}

	public void setStrIpdFinalSettle(WebRowSet strIpdFinalSettle) {
		this.strIpdFinalSettle = strIpdFinalSettle;
	}

	public WebRowSet getStrIpdFinalSettle1() {
		return strIpdFinalSettle1;
	}

	public void setStrIpdFinalSettle1(WebRowSet strIpdFinalSettle1) {
		this.strIpdFinalSettle1 = strIpdFinalSettle1;
	}

	public WebRowSet getStrAdvanceRefund() {
		return strAdvanceRefund;
	}

	public void setStrAdvanceRefund(WebRowSet strAdvanceRefund) {
		this.strAdvanceRefund = strAdvanceRefund;
	}

	public String getStrPrintFlag() {
		return strPrintFlag;
	}

	public void setStrPrintFlag(String strPrintFlag) {
		this.strPrintFlag = strPrintFlag;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrIpAddress() {
		return strIpAddress;
	}

	public void setStrIpAddress(String strIpAddress) {
		this.strIpAddress = strIpAddress;
	}

	public WebRowSet getGblWs3() {
		return gblWs3;
	}

	public void setGblWs3(WebRowSet gblWs3) {
		this.gblWs3 = gblWs3;
	}

	public WebRowSet getTranspotationchrgs() {
		return transpotationchrgs;
	}

	public void setTranspotationchrgs(WebRowSet transpotationchrgs) {
		this.transpotationchrgs = transpotationchrgs;
	}

	public WebRowSet getTrasnpotationcolsolidatedws() {
		return trasnpotationcolsolidatedws;
	}

	public void setTrasnpotationcolsolidatedws(WebRowSet trasnpotationcolsolidatedws) {
		this.trasnpotationcolsolidatedws = trasnpotationcolsolidatedws;
	}

	public String getStrService() {
		return strService;
	}

	public void setStrService(String strService) {
		this.strService = strService;
	}

	

}
