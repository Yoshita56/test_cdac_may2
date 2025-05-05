package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import java.util.ArrayList;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ImportRecordsTransVO;

public class ImportRecordsTransDAO {

	/**
	 * gets template list from Table : HSTT_UTIL_TEMPLATE_DTL whose template type is 1 (import)
	 * @param vo
	 */
	public static void getTemplateList(ImportRecordsTransVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(2,
					"select.importRecordTrans.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrTemplateType());

			ws = dao.executeQry(nQueryIndex);

			vo.setWsTemplateList(ws);

		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("ImportRecordsTransDAO.getTemplateList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			ws = null;
		}
	}

	/**
	 * gets template details from table HSTT_UTIL_TEMPLATE_DTL whose template type is 1
	 * @param vo
	 */
	public static void getTemplateDetails(ImportRecordsTransVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet ws = null;
		try {
			dao = new HisDAO("MMS", "ImportExportTemplateMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(2,
					"select.importRecordTrans.1");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrTemplateId());

			ws = dao.executeQry(nQueryIndex);

			vo.setWsTemplateDetails(ws);

		} catch (Exception e) {

			vo
					.setStrMsgString("ImportRecordsTransDAO.getTemplateDetails() --> "
							+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			dao = null;
			ws = null;
		}
	}

	/**
	 * imports data.
	 * @param vo
	 */
	public static void importData(ImportRecordsTransVO vo) {
		String strProcName = "";
		HisDAO dao = null;

		final int INSERT_RANGE = 100;
		
		ArrayList<String[]> strExcelContent = null;

		String[] strExcelRows = null;

		int insertCount = 0;
		int count = 0;
		int totalInsertCount = 0;
		int nProcIndex = 0;
		int start = 1;
	  	
		boolean headerFlag = true;
		
		String strMessage = "";
		
		try {

			strExcelContent = vo.getStrExcelContents();

			strProcName = vo.getStrCallProcedure();

			dao = new HisDAO("MMS",
					"transactions.ImportRecordsTransDAO.importData()");

			for (int i = 0; i < strExcelContent.size(); i++) {
				
				if(headerFlag == true){
					
					headerFlag = false;
					
				}else{
									
				count = count + 1;
				
				strExcelRows = strExcelContent.get(i);

				nProcIndex = dao.setProcedure(strProcName);

			//	//System.out.println("");
				
				if (vo.getStrParamName() != null
						&& vo.getStrParamName().length > 0) {
					
					int totalCell = 0;
					
					for (int j = 0; j <vo.getStrParamName().length; j++) {
						
						if (!(vo.getStrXlsColumnIndex()[j].equals("0") || vo.getStrXlsColumnIndex()[j].length() == 0 )) {
							
							totalCell = totalCell + 1;
							
						}
						
					}
									
					
					for (int j = 0; j <= vo.getStrParamName().length; j++) {

						if(j == vo.getStrParamName().length){
							
							
							dao.setProcInValue(nProcIndex,
									"COUNTER", String.valueOf(count));
							
							dao.setProcInValue(nProcIndex,
									"IMPEXPTYPE", vo.getStrTemplateType());
							
							dao.setProcInValue(nProcIndex,
									"TEMPNAME", vo.getStrTemplateName());
							dao.setProcInValue(nProcIndex,
									"IPADDR", vo.getStrIpAddress());
							
							dao.setProcInValue(nProcIndex,
									"SEATID", vo.getStrSeatId());
							dao.setProcInValue(nProcIndex,
									"HOSP_CODE", vo.getStrHospitalCode());
							
							
							dao.setProcOutValue(nProcIndex,
									"ERR", 1);
							
							
						//	System.out.print("\tErr=>");
							
						}else{
						
						if (vo.getStrXlsColumnIndex()[j].equals("0") || vo.getStrXlsColumnIndex()[j].length() == 0 ) {

							dao.setProcInValue(nProcIndex,
									vo.getStrParamName()[j], vo
											.getStrConstantValue()[j]);

							//System.out.print("\t "+vo.getStrParamName()[j]+"=>"+vo.getStrConstantValue()[j]);
							
						} else {

					//		//System.out.println( "j " +  j);
							
						//	//System.out.println( " vo.getStrXlsColumnIndex()[j] " +  vo.getStrXlsColumnIndex()[j] );
							
							////System.out.println( "Integer.getInteger(vo.getStrXlsColumnIndex()[j]) - 1 " + (Integer.getInteger(vo.getStrXlsColumnIndex()[j]) - 1));
							
						/*	//System.out.println("Excel Row 1: "+ strExcelRows[1] );
							//System.out.println("Excel Row 2 : "+ strExcelRows[2] );
							//System.out.println("Excel Row 3: "+ strExcelRows[3] );*/
							

							//int val =   Integer.valueOf(vo.getStrXlsColumnIndex()[j].trim()) ;
							//int val =    Integer.valueOf(vo.getStrXlsColumnIndex()[j].trim()) -1;

							
														
							dao.setProcInValue(nProcIndex,
									vo.getStrParamName()[j],
									strExcelRows[j]);
							
						//	//System.out.println("\t column index : "+vo.getStrXlsColumnIndex()[j].trim()+" Param Name :  "+vo.getStrParamName()[j]+"=> act index: "+val+"  Value: "+strExcelRows[val]);
							
							
						}

					}

					}
					
					dao.execute(nProcIndex, 1);
					insertCount = insertCount + 1;
					
				}

				
				if(((insertCount % INSERT_RANGE) == 0) || (i == (strExcelContent.size() - 1) ) ){
				
					synchronized (dao) {

						dao.fire();
						
						totalInsertCount = totalInsertCount + insertCount;
						
						vo.setStrInsertRowCount(String.valueOf(totalInsertCount));
												
						strMessage = strMessage + "Record(s) "+start+" to "+count+" Imported Successfully <br>";	
						
						insertCount = 0;
						
						start = 1 + count;
						
					}
				}
					
			}
			}

			vo.setStrMsgErrString(strMessage);
				
			
		} catch (Exception e) {

			e.printStackTrace();
			
			String[] errMsg = e.getMessage().replace(":", "#").split("#");
			strMessage = strMessage + "@@" +"Record(s) "+(totalInsertCount + 1)+" to "+count+" have not been Imported due to ' "+errMsg[errMsg.length - 1]+" '";
		  	
			vo.setStrMsgErrString(strMessage);
			
		//	vo.setStrMsgString("DrugProfileDAO.setBrandedItemData() --> "+ e.getMessage());
		//	vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		 
		}
	}

}
