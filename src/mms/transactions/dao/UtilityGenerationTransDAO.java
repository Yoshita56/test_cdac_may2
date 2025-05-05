/**
 * 
 */
package mms.transactions.dao;

import java.util.Arrays;
import java.util.Set;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.SMSHttpsNICPostClient;

import javax.sql.rowset.WebRowSet;

// import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;


import billing.dao.PrimaryKeyDAO;
import mms.MmsConfigUtil;
import mms.transactions.vo.PODeskGenerateTransVO;
import mms.transactions.vo.RequestForLPPatientVO;
import mms.transactions.vo.UtilityGenerationTransVO;

/**
 * @author user
 *
 */
public class UtilityGenerationTransDAO {
	
	
	public static void getPatDtl(UtilityGenerationTransVO vo)
	{
		//String strProcName = "{call Pkg_Mms_View.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //13 variables
		String strProcName = "{call Pkg_Mms_View.Proc_patient_detail_UC(?,?,?,?,?,?,?)}";  //6 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
					
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			
			
			nProcIndex = daoObj.setProcedure(strProcName);
			//daoObj.setProcInValue(nProcIndex, "modval", "2");
			if(vo.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			else
				daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "admno",vo.getStrPuk(),3); //here previously ip no was used but after UAT CR no was required by client
			if(vo.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "utilno",vo.getStrCmbIndentNo(),4);
			else
				daoObj.setProcInValue(nProcIndex, "utilno", vo.getStrUtilNo(),4);
			daoObj.setProcInValue(nProcIndex, "storeid", vo.getStrStoreId(),5);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStockDetailsWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("UtilityGenerationTransDAO.stockDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/*Used To get the Account balance.*/
	public static void getPatientAccountBalance(UtilityGenerationTransVO vo) {

	
		String strProcName = "{call PKG_MMS_VIEW.proc_hstt_pat_account_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		int funcIndex;
		String BillingValue="0^0^0";
		WebRowSet ws = null;
		HisDAO daoObj = null;
		try {
			daoObj = new HisDAO("MMSModule", "LPIssueDeskTransDAO");


			funcIndex = daoObj.setFunction("{? = call bill_mst.get_pat_accountdetails_limit(?,?,?)}");

			daoObj.setFuncInValue(funcIndex, 2,vo.getStrHospitalCode());
			daoObj.setFuncInValue(funcIndex, 3,"2");
			daoObj.setFuncInValue(funcIndex, 4,(vo.getStrPuk()==null || vo.getStrPuk().equals(""))?"0":vo.getStrPuk());
			//daoObj.setFuncInValue(funcIndex, 5,_LPIssueDeskTransVO.getStrItemCategNo());
			daoObj.setFuncOutValue(funcIndex, 1);
			daoObj.executeFunction(funcIndex);
			BillingValue = daoObj.getFuncString(funcIndex); 
			//System.out.println("BillingValue"+BillingValue);
			vo.setStrBillingHiddenValue(BillingValue);
			
			
			
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "cr_no", (vo.getStrPuk()==null || vo.getStrPuk().equals(""))?"0":vo.getStrPuk(), 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				if (ws != null && ws.size() != 0) 
				{
					ws.next();
					vo.setStrPatAccountNo(ws.getString("acc_no"));
					vo.setStrBalanceAmount(ws.getString("Balance_Amt"));	
				}
			}
		} catch (Exception _err) {
			_err.printStackTrace();
			vo
					.setStrMsgString("LPIssueDeskTransDAO.getPatientAccountBalance() --> "
							+ _err.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getUtilityNo(UtilityGenerationTransVO vo)
	{
		//String strProcName = "{call Pkg_Mms_View.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //13 variables
		String strProcName = "{call Pkg_Mms_View.Proc_patient_utilityno(?,?,?,?,?)}";  //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
					
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			
			
			nProcIndex = daoObj.setProcedure(strProcName);
			//daoObj.setProcInValue(nProcIndex, "modval", "2");
			if(vo.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			else
				daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "admno",vo.getStrPuk(),3); //here previously ip no was used but after UAT CR no was required by client
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setUtilityNoWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("UtilityGenerationTransDAO.getUtilityNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void getIndentNo(UtilityGenerationTransVO vo)
	{
		//String strProcName = "{call Pkg_Mms_View.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //13 variables
		String strProcName = "{call Pkg_Mms_View.Proc_patient_indentno(?,?,?,?,?)}";  //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
					
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			
			
			nProcIndex = daoObj.setProcedure(strProcName);
			//daoObj.setProcInValue(nProcIndex, "modval", "2");
			if(vo.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			else
				daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "admno",vo.getStrPuk(),3); //here previously ip no was used but after UAT CR no was required by client
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setIndentNoWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("UtilityGenerationTransDAO.getUtilityNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	public static void save(UtilityGenerationTransVO vo)
	{
		//String strProcName = "{call Pkg_Mms_View.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //13 variables
		String strProcName = "{call Pkg_Mms_dml.dml_Utility_Generation_Save(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?)}";  //32+3 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		MmsConfigUtil mcu;
		String ucNo;
		String billtariff="",billrate="",billqty="";
		String item="";
		int i;
		double netpo=0.0;
		PODeskGenerateTransVO poVo;
		String[] hid=new String[vo.getStrItem().length];
		String[] reqno=new String[1];
		String[] storeid=new String[1];
		String[] supp=new String[vo.getStrSupplierId().length];
		String[] em=new String[1];
		try
		{
					
			daoObj=new HisDAO("Utility Generation","UtilityGenerationTransDAO"); 
			mcu=new MmsConfigUtil(vo.getStrHospitalCode());
			nProcIndex = daoObj.setProcedure(strProcName);
			poVo=new PODeskGenerateTransVO();
			
			for(i=0;i<vo.getStrItem().length;i++)
			{
					if(vo.getStrItemCategoryNo().equals("1"))
						daoObj.setProcInValue(nProcIndex, "modval", "1",1);
					else
						daoObj.setProcInValue(nProcIndex, "modval", "2",1);
					daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
					daoObj.setProcInValue(nProcIndex, "admno",vo.getStrIpNo(),3);
					daoObj.setProcInValue(nProcIndex, "puk",vo.getStrPuk(),4);
					daoObj.setProcInValue(nProcIndex, "indentno",vo.getStrIndentNo(),5);
					daoObj.setProcInValue(nProcIndex, "storeid",vo.getStrStoreId(),6);
					daoObj.setProcInValue(nProcIndex, "patname",vo.getStrPatName(),7);
					daoObj.setProcInValue(nProcIndex, "patcat",vo.getStrCat(),8);
					daoObj.setProcInValue(nProcIndex, "dept",vo.getStrDept(),9);
					daoObj.setProcInValue(nProcIndex, "ward",vo.getStrWard(),10);
					daoObj.setProcInValue(nProcIndex, "itemname",vo.getStrItem()[i],11);
					daoObj.setProcInValue(nProcIndex, "supp",vo.getStrSupplier()[i],12);
					daoObj.setProcInValue(nProcIndex, "rate",vo.getStrRate()[i],13);
					daoObj.setProcInValue(nProcIndex, "handling_chg",vo.getStrHandlingCharges(),14);
					daoObj.setProcInValue(nProcIndex, "surgerydate",vo.getStrSurgeryDate(),15);
					daoObj.setProcInValue(nProcIndex, "tax","0",16);//will use this field if asked by client in future
					daoObj.setProcInValue(nProcIndex, "diagnosis",vo.getStrDiag(),17);
					daoObj.setProcInValue(nProcIndex, "doctor",vo.getStrDoctor(),18);
					daoObj.setProcInValue(nProcIndex, "qty",vo.getStrQty()[i],19);
					daoObj.setProcInValue(nProcIndex, "itemId",vo.getStrItemId()[i].split("#")[0],20);
					daoObj.setProcInValue(nProcIndex, "wardcode",vo.getStrWardCode(),21);
					daoObj.setProcInValue(nProcIndex, "catcode",vo.getStrTreatmentCatCode(),22);
					daoObj.setProcInValue(nProcIndex, "suppid",vo.getStrSupplierId()[i],23);
					daoObj.setProcInValue(nProcIndex, "dcno",vo.getStrDCNo()[i],24);
					daoObj.setProcInValue(nProcIndex, "invoiceno",vo.getStrInvoiceNo()[i],25);
					daoObj.setProcInValue(nProcIndex, "invoicedate",vo.getStrInvoiceDate()[i],26);
					daoObj.setProcInValue(nProcIndex, "pono",vo.getStrPONo()[i],27);
					daoObj.setProcInValue(nProcIndex, "implantcharges",vo.getStrImpCharges(),28);
					daoObj.setProcInValue(nProcIndex, "surgerycharges",vo.getStrSurgeonCharges(),29);
					daoObj.setProcInValue(nProcIndex, "surgerydetails",vo.getStrSurgeonDetail(),30);
					daoObj.setProcInValue(nProcIndex, "genitemid", vo.getStrhidval()[i].replace("$", "@").split("@")[8].split("#")[1],31);
					daoObj.setProcInValue(nProcIndex, "batch", vo.getStrhidval()[i].replace("$", "@").split("@")[8].split("#")[0],32);
					daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId(),33);
					daoObj.setProcOutValue(nProcIndex, "ucno",1,34);
					daoObj.setProcOutValue(nProcIndex, "err",1,35); 
					daoObj.execute(nProcIndex,1);
					if(billtariff != null && billtariff != "")
						billtariff=billtariff + "^"+vo.getStrItemId()[i].split("#")[0];
						else
							billtariff = vo.getStrItemId()[i].split("#")[0];
					if(billrate != null && billrate != "")
						billrate=billrate + "^"+vo.getStrRate()[i];
						else
							billrate = vo.getStrRate()[i];
					if(billqty != null && billqty != "")
						billqty=billqty + "^"+vo.getStrQty()[i];
						else
							billqty = vo.getStrQty()[i];
					if(i==0)
						item=vo.getStrItem()[i];
					else
						item=item + ","+vo.getStrItem()[i];
					//"+ wb.getString(2) + "^"+ wb.getString(4) + "^"+ wb.getString(5) + "^"+ wb.getString(6) + "^"+ wb.getString(7) + "^"+ wb.getString(8) + "^"+ wb.getString(9) + "^"+ wb.getString(10) + "^"+ wb.getString(11) +"^"+ wb.getString(12) +"^"+ poDeskGenerateTransVO.getTmpPONO() +"^"+ wb.getString(13) + "' >");
					hid[i]=vo.getStrSupplierId()[i]+"^"+vo.getStrCtDate()+"^"+vo.getStrQty()[i]+"^"+Double.parseDouble(vo.getStrRate()[i])/Double.parseDouble(vo.getStrQty()[i]) +"^"+Double.parseDouble(vo.getStrRate()[i])/Double.parseDouble(vo.getStrQty()[i])+"^"+vo.getStrRate()[i]+"^"+vo.getStrItemId()[i].split("#")[1]+"^"+vo.getStrItemId()[i].split("#")[0]+"^"+"6301^0^0^0";
					netpo = netpo + Double.parseDouble(vo.getStrRate()[i]);
					reqno[0]=vo.getStrIndentNo();
					storeid[0]=vo.getStrStoreId();
					em[0]=vo.getStrDPhoneEmail();
					if(i==0)
						supp[i]=vo.getStrSupplierId()[i];
					else
						if(vo.getStrSupplierId()[i] != vo.getStrSupplierId()[i-1])
							supp[i]=vo.getStrSupplierId()[i];
							
			}
			//below 3 lines are for applying handling charges
			billtariff = billtariff +"^"+"99999999"; 
			billrate=billrate + "^"+vo.getStrHandlingCharges();
			billqty=billqty + "^"+"1";
			synchronized (daoObj) 
			{
				daoObj.fire();
			}
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) {
				ucNo=daoObj.getString(nProcIndex, "ucno");
				
				if(mcu.getStrBillingIntegration().equals("1"))
				{
					
					if(!vo.getStrItemCategoryNo().equals("1"))
					{
						String PROC_NAME = "{call Pkg_Bill_Dml.DML_ONLINE_BILL_CANCELLATION_IPD(?,?,?,?,?,?,?,?,?,?)}";
						int procIndex = daoObj.setProcedure(PROC_NAME);
						PrimaryKeyDAO keyDAO = new PrimaryKeyDAO();
			            String strCancelNo;
			            
							keyDAO.setStrKeyname("CANCELNO");
							keyDAO.setStrBlockkey("1");
							keyDAO.setStrHospCode(vo.getStrHospitalCode());
							keyDAO.select(daoObj);
							strCancelNo = keyDAO.getStrPrimrayKeyValue();
						/*	
							//System.out.println("in dao hoscode--"+vo.getStrHospitalCode()); 
							//System.out.println("in dao cancel no--"+strCancelNo);
							//System.out.println("in dao trans no--"+strTransNo); 
							//System.out.println("in dao receipt no--"+strReceiptNo); 
							//System.out.println("in dao cancelled  by--"+vo.getStrCancelledBy());
							//System.out.println("in dao cancel reason--"+vo.getStrCancelReason());
							//System.out.println("in dao seat id--"+vo.getStrSeatId());
							*/ 
							daoObj.setProcInValue(procIndex, "modeval", "1",1);
							daoObj.setProcInValue(procIndex, "hosp_code", vo.getStrHospitalCode(),2);
							daoObj.setProcInValue(procIndex, "cancelNo", strCancelNo,3);
							daoObj.setProcInValue(procIndex, "billNo", vo.getStrBillNo(),4);
							daoObj.setProcInValue(procIndex, "receiptNo", "1",5);
							daoObj.setProcInValue(procIndex, "empNo", vo.getStrSeatId(),6);
							daoObj.setProcInValue(procIndex, "cancelReason", "UC modified",7);
							daoObj.setProcInValue(procIndex, "seatId", vo.getStrSeatId(),8);
							daoObj.setProcInValue(procIndex, "ipAddr", "",9);
							daoObj.setProcOutValue(procIndex, "err", 1,10);

							daoObj.executeProcedureByPosition(procIndex);
							
					}

						int procIndex2;
						//System.out.println("billtariff:::::"+billtariff);
						String proc_name2 = "{call bill_interface.dml_online_billreq_drugs(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";
						procIndex2 = daoObj.setProcedure(proc_name2);
						daoObj.setProcInValue(procIndex2, "modval", "1", 1); // 1
						daoObj.setProcInValue(procIndex2, "gnum_dept_code", "0", 2);
						daoObj.setProcInValue(procIndex2, "sblnum_chargetype_id", "2", 3);
						daoObj.setProcInValue(procIndex2, "sblnum_service_id", "5", 4);
						daoObj.setProcInValue(procIndex2, "gstr_req_no", vo.getStrIndentNo(), 5);
						daoObj.setProcInValue(procIndex2, "gnum_treatment_cat", vo.getStrTreatmentCatCode(),6);
						daoObj.setProcInValue(procIndex2, "hrgnum_episode_code", "0", 7);
						daoObj.setProcInValue(procIndex2, "hrgnum_puk", vo.getStrPuk(), 8);
						daoObj.setProcInValue(procIndex2, "hblnum_pat_lfaccount_no", "0", 9);
						daoObj.setProcInValue(procIndex2, "gstr_tariff",billtariff, 10);
						daoObj.setProcInValue(procIndex2, "gstr_tariff_batch", "", 11);
						daoObj.setProcInValue(procIndex2, "gstr_tariff_rates", billrate , 12);
						daoObj.setProcInValue(procIndex2, "gstr_reqqty", billqty, 13);
						daoObj.setProcInValue(procIndex2, "hblstr_patient_name", "", 14);
						daoObj.setProcInValue(procIndex2, "hblstr_pat_address", "", 15);
						daoObj.setProcInValue(procIndex2, "hblstr_contact_no", "", 16);
						daoObj.setProcInValue(procIndex2, "age", "1", 17);
						daoObj.setProcInValue(procIndex2, "ageunit", "1", 18);
						daoObj.setProcInValue(procIndex2, "gender", "1", 19);
						daoObj.setProcInValue(procIndex2, "refdoctor", "1", 20);
						daoObj.setProcInValue(procIndex2, "refdoccontactno", "1", 21);
						daoObj.setProcInValue(procIndex2, "gnum_seatid", vo.getStrSeatId(), 22);
						daoObj.setProcInValue(procIndex2, "hosp_code",vo.getStrHospitalCode(), 23);
						daoObj.setProcInValue(procIndex2, "ward_code", vo.getStrWardCode(), 24);
						daoObj.setProcInValue(procIndex2, "admno", vo.getStrIpNo(), 25);
						daoObj.setProcInValue(procIndex2, "visitno", "", 26);
						daoObj.setProcOutValue(procIndex2, "err", 1, 27);
						daoObj.executeProcedureByPosition(procIndex2);
						
						strErr = daoObj.getString(procIndex2, "err");
						if (strErr == null)
							strErr = "";
						if (strErr.equals("")) {
							
							String proc_name3 = "{call pkg_mms_dml.dml_bill_no_update_UC(?,?,?,?,?,?,?)}";
							procIndex2 = daoObj.setProcedure(proc_name3);
							for(i=0;i<vo.getStrItem().length;i++)
							{ 
								
								//System.out.println("vo.getStrItemId()[i]:::::"+vo.getStrItemId()[i].split("#")[0]);
							daoObj.setProcInValue(procIndex2, "modval", "1", 1); // 1
							daoObj.setProcInValue(procIndex2, "hosp_code", vo.getStrHospitalCode(),2);
							daoObj.setProcInValue(procIndex2, "admno",vo.getStrIpNo(),3);
							daoObj.setProcInValue(procIndex2, "puk",vo.getStrPuk(),4);
							daoObj.setProcInValue(procIndex2, "indentno",vo.getStrIndentNo(),5);
							daoObj.setProcInValue(procIndex2, "itemId",vo.getStrItemId()[i].split("#")[0],6);
							daoObj.setProcOutValue(procIndex2, "err", 1, 7);
							daoObj.executeProcedureByPosition(procIndex2);
							}
						
							strErr = daoObj.getString(procIndex2, "err");
							
							
							if (strErr == null)
								strErr = "";
							if (strErr.equals("")) {
								
								poVo.setStrPOTypeId("91");//Utility PO
								poVo.setStrItemCat(vo.getStrItemId()[0].split("#")[0].substring(0,2));// Utility category
								poVo.setStrDLstSupplierId(supp);
								poVo.setStrHospitalCode(vo.getStrHospitalCode());
								poVo.setStrStoreId(vo.getStrStoreId());
								poVo.setStrDPurchaseSource("13");//13 is for RC supplier
								poVo.setStrDDeliveryLocation(vo.getStrStoreId());
								poVo.setStrDRemarks("Auto Generated PO for UC with UC No. as : "+ucNo);
								poVo.setStrSeatId(vo.getStrSeatId());
								poVo.setStrVerifiedBy("");
								poVo.setStrVerifiedDate("");
								poVo.setStrDPORefNo("");
								poVo.setStrDPORefDate(vo.getStrCtDate());
								poVo.setStrDRequestNo(reqno);
								poVo.setStrDRaisingStore(storeid);
								poVo.setStrHiddenValue(hid);
								poVo.setStrDTenderDate("");
								poVo.setStrDTenderNo("");
								poVo.setStrDQuotationDate("");
								poVo.setStrDQuotationNo("");
								poVo.setStrDOverAllTax("0");
								poVo.setStrDNetAmount(Double.toString(netpo));
								poVo.setStrDExpectedDeliveryDate(vo.getStrInvoiceDate());
								poVo.setStrDPhoneEmail(em);
								poVo.setStrGroupId("[0,0,0,0,0,0,0]");
								PODeskGenerateTransDAO.insert(poVo);
							}
							else {
								throw new Exception(strErr);
							}
					}
						else {
							throw new Exception(strErr);
						}
				}
			}
		else {
				throw new Exception(strErr);
			}
			if(!ucNo.equals(""))
				vo.setStrUTNo(ucNo);
			
			if(vo.getStrItemCategoryNo().equals("1"))
			{	
			//	SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
			//	String UCMsg = "Respected Sir/Madam,\n\nGreetings!! \n\n This is for your kind info. that Utility Certificate for Items : "+item+ " and UT No. :"+vo.getStrDept().substring(0,2)+""+vo.getStrUTNo()+" on "+vo.getStrSurgeryDate()+" has been generated. Kindly note that No change in invoice will be allowed after discharge of the patient\n\n\n\nPLEASE DO NOT REPLY TO THIS MAIL. THIS IS AN AUTO GENERATED MAIL AND REPLIES TO THIS EMAIL ID ARE NOT ATTENDED TO. FOR ANY QUERIES OR CLARIFICATIONS PLEASE CALL US AT THE CONTACT NUMBERS PROVIDED AT OUR WEBSITE nims.edu.in OR VISIT NIMS. ";
				// sms.sendEmail(vo.getStrDPhoneEmail().split("#")[1],"Utility Certificate Generated",UCMsg);
				
				/*SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
				for(int i=0;i<emailid.length;i++)
				{
					String email[]=emailid[i].replace("$", "#").split("#");
					if(email[0]!=null && !email[0].equals(""))
					{
						String msg="Respected Sir/Madam,\n\nGreetings!! This is a system generated email which is just a gentle reminder for Procurement Activity Meeting by NIMS.\nThis is for your kind information that the Procurement Activity Meeting is Scheduled on "+email[1]+" for "+email[2]+". Your presence is highly valuable.\n\nThanks & Regards,\nHIS Cell \nNIMS, Hyderabad \n\n\n\nThis is an auto-generated mail.Please do not reply!";
						sms.sendEmail(email[0],"Email for Procurement Activity",msg);
					}
				}*/
			}
			
		}
		catch(Exception e)
		{
			vo.setStrMsgString("UtilityGenerationTransDAO.save() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		
		
	}
	/**
	 * To get Drug Warehouse Combo  from the hstt_store_mst
	 *  
	 * @param voObj
	 */
	public static void getStoreList(UtilityGenerationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			if(voObj.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "modeval", "9",1);
			else
				daoObj.setProcInValue(nProcIndex, "modeval", "10",1);
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "storeid", "10",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id","0",5); 
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("getStoreList size :"+ws.size());
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("UtilityGenerationTransDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	/**
	 * To get Drug Warehouse Type Combo
	 *  
	 * @param voObj
	 */
	public static void getDwhTypeCombo(UtilityGenerationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_sstt_dwh_type_mst_cmb(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			                   
		        
		       
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "p_sstnum_is_district_dwh", "0",3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("getDwhTypeCombo size :"+ws.size());
//				voObj.setStrDrugWarehouseTypeWs(ws);
				
				voObj.setStrStoreTypeWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("UtilityGenerationTransDAO.getDwhTypeCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemCategoryName(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_itemcategory_user_list(?,?,?,?,?)}";
		String strProcName1 = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}"; //5+1=6
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			
		//	if(vo.getStrStoreId().equals("0")){
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
				daoObj.setProcInValue(nProcIndex, "seat_id", vo.getStrSeatId(),3);
				daoObj.setProcOutValue(nProcIndex, "err",1,4); 
				daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
				daoObj.executeProcedureByPosition(nProcIndex);
//			}
//			else {
//				nProcIndex = daoObj.setProcedure(strProcName1);
//				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);			
//				daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
//				daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
//				daoObj.setProcOutValue(nProcIndex, "err",1,5); 
//				daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
//				
//				daoObj.setProcInValue(nProcIndex, "reqType", "0",4); // Default set for reqType
//				
//				daoObj.executeProcedureByPosition(nProcIndex);
//			}
			
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemCategoryWS(ws);
				//System.out.println("itemCategoryName() size :"+ws.size());
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("UtilityGenerationTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Group Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void groupName(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_group_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			//System.out.println("item_category"+ vo.getStrItemCategoryNo());
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "item_category", vo.getStrItemCategoryNo(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "strPhyStockNo", "",4);
			daoObj.setProcInValue(nProcIndex, "strStoreId", "",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("WrsGroupName size :"+ws.size());
			if (strErr.equals("")) {
				vo.setGroupWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("UtilityGenerationTransDAO.groupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of SubGroup Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void subGroupName(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_store_subgroup_list(?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "GROUP_ID", vo.getStrGroupId(),2);
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setSubGroupWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("UtilityGenerationTransDAO.subGroupName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * for getting option value of Generic Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void genItemName(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_item_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),5);
			daoObj.setProcInValue(nProcIndex, "catCode", vo.getStrItemCategoryNo(),2);
			daoObj.setProcInValue(nProcIndex, "grpId", vo.getStrGroupId(),3);
			daoObj.setProcInValue(nProcIndex, "subgroup_id", vo.getStrSubGroupId(),4);
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setGenItemWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("UtilityGenerationTransDAO.genItemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void itemName(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_itembrand_list(?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			/////
			//System.out.println("************* itemName **************");
			//System.out.println("modeval"+ "7");
			//System.out.println("hosp_code"+ vo.getStrHospitalCode());
			//System.out.println("catCode"+ vo.getStrItemCategoryNo());
			//System.out.println("grpId"+ vo.getStrGroupId());
			//System.out.println("subGrpId"+ vo.getStrSubGroupId());
			//System.out.println("item_id "+ vo.getStrGenItemId());
			
			//System.out.println("setFlag"+ "0"); //Default Value.
			//////
			daoObj.setProcInValue(nProcIndex, "modeval", "7",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),7);
			if(vo.getStrItemCategoryNo().equals("1"))
				daoObj.setProcInValue(nProcIndex, "catCode", "10",2);
			else
				daoObj.setProcInValue(nProcIndex, "catCode", "11",2);
			daoObj.setProcInValue(nProcIndex, "grpId", vo.getStrGroupId(),4);
			daoObj.setProcInValue(nProcIndex, "subGrpId", vo.getStrSubGroupId(),5);
			daoObj.setProcInValue(nProcIndex, "item_id ", vo.getStrGenItemId(),3);
			
			daoObj.setProcInValue(nProcIndex, "setFlag", "0",6); //Default Value.
			
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println("itemWS size :"+ws.size());
			if (strErr.equals("")) {
				vo.setItemWS(ws);	
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("UtilityGenerationTransDAO.itemName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void batchNo(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchSerialno_list(?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			/*//System.out.println("Hosp Code==>"+vo.getStrHospitalCode());
			//System.out.println("Item Catg==>"+vo.getStrItemCategoryNo());
			//System.out.println("Item ID==>"+vo.getStrGenItemId());
			//System.out.println("Item Brand==>"+vo.getStrItemId());
			//System.out.println("StoreId==>"+vo.getStrStoreId());*/
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),5);
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo(),4);
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId(),2);
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemId()[0],3);
			daoObj.setProcInValue(nProcIndex, "strId", vo.getStrStoreId(),6);
			daoObj.setProcOutValue(nProcIndex, "err",1,7); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,8);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setBatchNoWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("UtilityGenerationTransDAO.batchNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Batch No on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void serialNo(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_batchSerialno_list(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "cat_no", vo.getStrItemCategoryNo());
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId());
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemId()[0]);
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setItemSlNoWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("UtilityGenerationTransDAO.serialNo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void stockDetails(UtilityGenerationTransVO vo)
	{
		//String strProcName = "{call Pkg_Mms_View.Proc_stock_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //13 variables
		String strProcName = "{call Pkg_Mms_View.Proc_stock_detail(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";  //14 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
					
			daoObj=new HisDAO("Item Location","UtilityGenerationTransDAO");
			
			////////////////////////////////////////////////////////////
			//System.out.println("modval"+ "1");
			//System.out.println("dwhType :::"+ vo.getStrStoreTypeId());
			//System.out.println("stock_status :::"+ vo.getStrStockStatusCode());
			//System.out.println("catCode :::"+ vo.getStrItemCategoryNo());
			//System.out.println("hosp_code :::"+ vo.getStrHospitalCode());
			//System.out.println("batch_no :::"+ vo.getStrBatchNo());
			//System.out.println("itemSlNo :::"+ vo.getStrItemSlNo());			
			//System.out.println("item_id :::"+ vo.getStrGenItemId());
			//System.out.println("itembrand_id :::"+ vo.getStrItemId());
			//System.out.println("store_id :::"+ vo.getStrStoreId());
			//System.out.println("dwhType :::"+ vo.getStrStoreTypeId());
			//////////////////////////////////////////////////////////////
			
			nProcIndex = daoObj.setProcedure(strProcName);
			//daoObj.setProcInValue(nProcIndex, "modval", "2");
			daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "stock_status", vo.getStrStockStatusCode(),7);
			daoObj.setProcInValue(nProcIndex, "catCode",(vo.getStrItemCategoryNo().equals("1")?"10":"11"),3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),8);
			daoObj.setProcInValue(nProcIndex, "batch_no", "",6);
			daoObj.setProcInValue(nProcIndex, "itemSlNo", "0",9);
			
			daoObj.setProcInValue(nProcIndex, "item_id", "0",4);
			daoObj.setProcInValue(nProcIndex, "itembrand_id", vo.getStrItemId()[0],5);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrStoreId(),2);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "reservedStockFlag", "0",10);
			daoObj.setProcInValue(nProcIndex, "blockedQtyFlag", "1",11);
			/* Setting Default Value End */
			daoObj.setProcInValue(nProcIndex, "dwhType", "0",12);
			
			
			daoObj.setProcOutValue(nProcIndex, "err",1,13); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,14);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStockDetailsWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("UtilityGenerationTransDAO.stockDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of Item Category Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void empStockDetails(UtilityGenerationTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_empstockdtl_list(?,?,?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("MMS","UtilityGenerationTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "reqtype", vo.getStrReqTypeId(),6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),7);
			daoObj.setProcInValue(nProcIndex, "batchno", vo.getStrBatchNo(),4);
			daoObj.setProcInValue(nProcIndex, "itemslno", "0",5);
			daoObj.setProcInValue(nProcIndex, "itemid", vo.getStrGenItemId(),2);
			daoObj.setProcInValue(nProcIndex, "itembrandid", vo.getStrItemId()[0],3);
			daoObj.setProcOutValue(nProcIndex, "err",1,8); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,9);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if (strErr.equals("")) 
			{
				vo.setEmplyeeStockDetailsWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("UtilityGenerationTransDAO.empStockDetails() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}

	
	/**
	 * for getting  Item Category Name on page from HSTT_STORE_CATEGORY_MST on basis of store id
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getItemCatDtls(UtilityGenerationTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_item_category_list(?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","UtilityGenerationTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "store_id", (voObj.getStrStoreId()==null || voObj.getStrStoreId().equals(""))?"0":voObj.getStrStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "reqType", "",4);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setItemCategoryWS(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("UtilityGenerationTransDAO.getItemCatDtls() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
}
