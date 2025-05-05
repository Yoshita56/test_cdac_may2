package hisglobal.masterutil;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import hisglobal.utility.SecurityUtil;


public class GenericHLP 
{
	int no_of_column = 0;
	int no_of_combo = 0;

	int page_per_block = 0;
	int rec_per_page = 0;

	String combo[] = null;
	String cmb[] = null;

 public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
 public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";

  public static  String now(String frmt)
  {
      HisUtil util=null;
      String a="";
  util=new HisUtil("transaction","SupplierReturnReqTransDATA");
  try{
   a= util.getASDate(frmt);
  }
  catch(Exception e){

  }
  /*Calendar cal = Calendar.getInstance();
  SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
  return sdf.format(cal.getTime());*/
  return a;
}


	public String generateData(GenericVO vo, String[] columnHdr, int pagePerBlock, List<String> viewHdr,
			String masterName, String[] searchField, int recPerPage, String[] comboHdr, String[] comboQry,
			String[] CmbData, String[] ordrBy, String clr) {

		StringBuilder br = new StringBuilder(1000);
		//StringBuilder mainQuery = new StringBuilder(500);
		String mode = vo.getHmode();
		//String searchColumn = vo.getSearchColumn();
		String prevNext = vo.getPrevNext();
		//String search = vo.getSearch();
		//String orderby = vo.getOrderby();
		String comboQuery[] = null;
		String combo_data = "";
		//String divisionId = "";

		//by rahul for user defined combo
		String[] userComboList = null;
		String[] userComboValue = null;

		int rowsetSize = 0;
		int nextpage_no = 0;
		int actual_page_block = 0;

		//int minrow = Integer.parseInt(vo.getRowNum());
		int minrow = Integer.parseInt(vo.getMinrow());
		int max_rownum = Integer.parseInt(vo.getMax_rownum());

		int blockNo = Integer.parseInt(vo.getBlockNo());
		int total_page = 0;
		int i = 0;

		if(masterName==null || masterName.equals(""))
			masterName="Master";

		String[] tempArr=masterName.split("#");


		HisDAO dao = null;
		WebRowSet rowset = null;
		//HisUtil util = null;

		no_of_column   = columnHdr.length;
		page_per_block = pagePerBlock;
		rec_per_page   = recPerPage;

		if (comboHdr == null)
			no_of_combo = 0;
		else
			no_of_combo = comboHdr.length/2; // changed on 10th july by rahul, to add user defined functionality.
											//.....changes are- divison by 2

		combo = vo.getCombo();

		try {
			if (mode.equals("DELETE")){
				//divisionId = vo.getDivisionId();
				nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
			} else {
				if(prevNext.equals("1") || prevNext.equals("2")) {
					nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
				}
				else {
					blockNo = 1;
					nextpage_no = 1;
				}
				/*
				if (mode.equals("DEFAULT") || mode.equals("null")
						|| mode == null || mode.equals(""))
				{
					blockNo = 1;
					nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
					//System.out.println("point = 1");
				}
				else {
					if(prevNext.equals("1") || prevNext.equals("2")) {
						nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
						//System.out.println("point = 2");
					}
				}
				*/
			}

			rowset = vo.getLstWs();
			rowsetSize = rowset.size();
			total_page = (rowsetSize % rec_per_page == 0) ? (rowsetSize / rec_per_page)	: ((rowsetSize / rec_per_page) + 1);
			br.append(rec_per_page + "####" + no_of_combo + "####"+ actual_page_block + "####" + total_page + "####");

			int b = 1;
			//br.append("<DIV  ALIGN='RIGHT' ID='m^"+ b+ "' STYLE='DISPLAY:BLOCK;position:relative' TITLE='Click to View More Data'  >"
			//				+ "<TD CLASS='MASTERNAME'><DIV ALIGN='LEFT'><b>"+ masterObj.getMasterName()+ ">></b></DIV></TD> </div><DIV align='right'>");

			br.append("<DIV  ALIGN='RIGHT' ID='m^"+ b+ "' STYLE='DISPLAY:BLOCK;position:relative' TITLE='Click to View More Data'  >"
					+ "<TD CLASS='MASTERNAME'><DIV ALIGN='LEFT'><b>"+ tempArr[0]+ " >></b></DIV></TD></div><DIV>");
			// TO ADD HEADER NOTE & PAGINATION IN SAME ROW BY RAHUL ON 27 AUG,07
			br.append("<TABLE BORDER='0' CELLSPACING='1px' CELLPADDING='1px' WIDTH='100%'><TR><TD CLASS='TDHEADER'><TABLE WIDTH='100%' CELLSPACING='1px' CELLPADDING='1px'>");
			br.append("<TD WIDTH='100%'><DIV ALIGN='RIGHT'><FONT COLOR='white'>");
			/*
			 * getTotalBlock method
			 *
			 */
			br.append(getTotalBlock(nextpage_no, total_page, max_rownum,minrow, blockNo, clr, vo));

			br.append("</FONT></DIV></TD></TABLE></TD></TR></TABLE>");
			comboQuery = comboQry;
			String combo_header[] = comboHdr;
			i = 1;
			// CSS CHANGED FROM TDFONTCOMBO TO TDCOMBOHEADER BY RAHUL ON 27 AUG,07
			br.append("<TABLE WIDTH=100% BORDER='0' CELLSPACING='1px' CELLPADDING='1px'><TR>"+ "<TD  CLASS='TDCOMBOHEADER' COLSPAN='" + (no_of_column + 1)+ "' ALIGN=RIGHT>");

		//	util = new HisUtil("Master Template", "MstUtil");
			for (int p = 0; p < no_of_combo; p++, i++) {
				if (i % 3 == 0)
					br.append("</TR><TR><TD  CLASS='TDCOMBOHEADER' COLSPAN='"	+ (no_of_column + 1) + "' ALIGN=RIGHT>");	// CSS CHANGED FROM TDFONTCOMBO TO TDCOMBOHEADER BY RAHUL ON 27 AUG,07

				if(combo_header[2*p].equals("1"))// changed on 10th july by Rahul, to give user defined functionality...changes are-- this if-else condition
	            {
					userComboList = comboQuery[p].split("#");
	            	combo_data="";	// code changed on 19-sep-07 by Rahul. Problem- each combo had values from previous combo too. Status- solved.
	            					// earlier combo_data was not equal to empty list ("").
	    			for(int k=0;k<userComboList.length;k++)
	    			{
	    				userComboValue = userComboList[k].replace('^','#').split("#");
	    				if(combo != null && combo[p].equals(userComboValue[0]))
	    					combo_data +="<OPTION SELECTED VALUE='"+userComboValue[0]+"'>"+userComboValue[1]+"</OPTION>\n";
	    				else
	    					combo_data +="<OPTION VALUE='"+userComboValue[0]+"'>"+userComboValue[1]+"</OPTION>\n";
	    			}
	            }
	            else
	            {
	            	//System.out.println("CmbData: "+CmbData[p]);
	            	combo_data = CmbData[p];
	            }
				// changed on 10th july by Rahul,for user defined functionality.. changes are--combo_header[2*p+1] instead of combo_header[p]
				br.append("<B>"	+ combo_header[2*p+1]+ "&nbsp;</B><SELECT NAME='combo' TITLE='Select Combo' CLASS='CB1' onChange=fetchRecordsCombo("
								+ p + ")>" + combo_data + "</SELECT>&nbsp;&nbsp;&nbsp;");

			}

			br.append("</TD></TR></TABLE><TABLE WIDTH='100%' BORDER='0' CELLPADDING='1' CELLSPACING='2'> <TR >");
			br.append(getColoumnHeaderString(columnHdr, ordrBy, vo));

			if (rowsetSize <= 0) {
				br.append("<TABLE  WIDTH='100%' ALIGN='CENTER' CELLPADDING='1' CELLSPACING='1'>"+ "<TR class='ROWFONT'><TD width='10%' COLSPAN='"
								+ (columnHdr.length + 1)+ "'><b>No Record Found</b></TD></TR></TABLE>");
			}

			br.append(getQueryData(rowset,(100 / columnHdr.length), minrow, vo,masterName));
			br.append(getSearchRowString(vo, pagePerBlock, viewHdr, masterName, searchField, total_page, columnHdr));

		}
		catch (Exception e) {
			vo.setStrMsgString("GenericHLP.GenericData -->"+e.getMessage());
			vo.setStrMsgType("1");
        } finally {
         //   util = null;
            comboQuery = null;
            combo_data = null;
            if (rowset != null) {
                try {

                    rowset.close();
                    rowset = null;
                } catch (Exception e) {
                	vo.setStrMsgString("GenericHLP.GenericData -->"+e.getMessage());
        			vo.setStrMsgType("1");
                }
            }
            if (dao != null) {
                try {
                    dao.free();
                    dao = null;
                } catch (Exception e) {
                	vo.setStrMsgString("GenericHLP.GenericData -->"+e.getMessage());
        			vo.setStrMsgType("1");
                }
            }
        }
		return br.toString();
	}
	
	public String generateDataTable(GenericVO vo, String[] columnHdr, int pagePerBlock, List<String> viewHdr,
			String masterName, String[] searchField, int recPerPage, String[] comboHdr, String[] comboQry,
			String[] CmbData, String[] ordrBy, String clr) {
		
		clr = "white";  //reset new-prev color
		StringBuilder br = new StringBuilder(1000);
		//StringBuilder mainQuery = new StringBuilder(500);
		String mode = vo.getHmode();
		//String searchColumn = vo.getSearchColumn();
		String prevNext = vo.getPrevNext();
		//String search = vo.getSearch();
		//String orderby = vo.getOrderby();
		String comboQuery[] = null;
		String combo_data = "";
		//String divisionId = "";

		//by rahul for user defined combo
		String[] userComboList = null;
		String[] userComboValue = null;

		int rowsetSize = 0;
		int nextpage_no = 0;
		int actual_page_block = 0;

		//int minrow = Integer.parseInt(vo.getRowNum());
		int minrow = Integer.parseInt(vo.getMinrow());
		int max_rownum = Integer.parseInt(vo.getMax_rownum());

		int blockNo = Integer.parseInt(vo.getBlockNo());
		int total_page = 0;
		int i = 0;

		if(masterName==null || masterName.equals(""))
			masterName="Master";

		String[] tempArr=masterName.split("#");


		HisDAO dao = null;
		WebRowSet rowset = null;
		//HisUtil util = null;

		no_of_column   = columnHdr.length;
		page_per_block = pagePerBlock;
		rec_per_page   = recPerPage;

		if (comboHdr == null)
			no_of_combo = 0;
		else
			no_of_combo = comboHdr.length/2; // changed on 10th july by rahul, to add user defined functionality.
											//.....changes are- divison by 2

		combo = vo.getCombo();

		try {
			if (mode.equals("DELETE")){
				//divisionId = vo.getDivisionId();
				nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
			} else {
				if(prevNext.equals("1") || prevNext.equals("2")) {
					nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
				}
				else {
					blockNo = 1;
					nextpage_no = 1;
				}
				/*
				if (mode.equals("DEFAULT") || mode.equals("null")
						|| mode == null || mode.equals(""))
				{
					blockNo = 1;
					nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
					//System.out.println("point = 1");
				}
				else {
					if(prevNext.equals("1") || prevNext.equals("2")) {
						nextpage_no = (((blockNo * page_per_block) - page_per_block) + 1);
						//System.out.println("point = 2");
					}
				}
				*/
			}

			rowset = vo.getLstWs();
			rowsetSize = rowset.size();
			total_page = (rowsetSize % rec_per_page == 0) ? (rowsetSize / rec_per_page)	: ((rowsetSize / rec_per_page) + 1);
			br.append(rec_per_page + "####" + no_of_combo + "####"+ actual_page_block + "####" + total_page + "####");

			int b = 1;
			//br.append("<DIV  ALIGN='RIGHT' ID='m^"+ b+ "' STYLE='DISPLAY:BLOCK;position:relative' TITLE='Click to View More Data'  >"
			//				+ "<TD CLASS='MASTERNAME'><DIV ALIGN='LEFT'><b>"+ masterObj.getMasterName()+ ">></b></DIV></TD> </div><DIV align='right'>");

			br.append("<DIV  ALIGN='RIGHT' ID='m^"+ b+ "' STYLE='DISPLAY:BLOCK;position:relative;background: #efefef;padding: 10px;' TITLE='Click to View More Data'  >"
					+ "<TD CLASS='MASTERNAME'><DIV ALIGN='LEFT'><b style='text-transform: uppercase;'>"+ tempArr[0]+ "</b></DIV></TD></div><DIV>");
			
			comboQuery = comboQry;
			String combo_header[] = comboHdr;
			i = 1;
			// CSS CHANGED FROM TDFONTCOMBO TO TDCOMBOHEADER BY RAHUL ON 27 AUG,07
			br.append("<TABLE WIDTH=100% BORDER='0' CELLSPACING='1px' CELLPADDING='1px'><TR>"+ "<TD  CLASS='TDCOMBOHEADER form-inline' COLSPAN='" + (no_of_column + 1)+ "' ALIGN=RIGHT>");

		//	util = new HisUtil("Master Template", "MstUtil");
			for (int p = 0; p < no_of_combo; p++, i++) {
				/*if (i % 3 == 0)
					br.append("</TR><TR><TD  CLASS='TDCOMBOHEADER form-inline' COLSPAN='"	+ (no_of_column + 1) + "' ALIGN=RIGHT>");*/	// CSS CHANGED FROM TDFONTCOMBO TO TDCOMBOHEADER BY RAHUL ON 27 AUG,07

				if(combo_header[2*p].equals("1"))// changed on 10th july by Rahul, to give user defined functionality...changes are-- this if-else condition
	            {
					userComboList = comboQuery[p].split("#");
	            	combo_data="";	// code changed on 19-sep-07 by Rahul. Problem- each combo had values from previous combo too. Status- solved.
	            					// earlier combo_data was not equal to empty list ("").
	    			for(int k=0;k<userComboList.length;k++)
	    			{
	    				userComboValue = userComboList[k].replace('^','#').split("#");
	    				if(combo != null && combo[p].equals(userComboValue[0]))
	    					combo_data +="<OPTION SELECTED VALUE='"+userComboValue[0]+"'>"+userComboValue[1]+"</OPTION>\n";
	    				else
	    					combo_data +="<OPTION VALUE='"+userComboValue[0]+"'>"+userComboValue[1]+"</OPTION>\n";
	    			}
	            }
	            else
	            {
	            	//System.out.println("CmbData: "+CmbData[p]);
	            	combo_data = CmbData[p];
	            }
				// changed on 10th july by Rahul,for user defined functionality.. changes are--combo_header[2*p+1] instead of combo_header[p]
				br.append("<B>"	+ combo_header[2*p+1]+ "&nbsp;</B><SELECT NAME='combo' TITLE='Select Combo' CLASS='CB1 form-control input-sm' onChange=fetchRecordsCombo("
								+ p + ")>" + combo_data + "</SELECT>&nbsp;&nbsp;&nbsp;");

			}

			br.append("</TD></TR></TABLE><br><TABLE id='mainDataTableId' class='table table-hover table-condensed' WIDTH='100%' BORDER='0'> <thead style='background-color: #337ab7;color: white;'> <TR >");
			br.append(getColoumnHeaderStringDtTbl(columnHdr, ordrBy, vo));

			if (rowsetSize <= 0) {
				/*br.append("<TABLE id='mainDataTableId'  WIDTH='100%' ALIGN='CENTER' CELLPADDING='1' CELLSPACING='1'>"+ "<TR class='ROWFONT'><TD width='10%' COLSPAN='"
						+ (columnHdr.length + 1)+ "'><b>No Record Found</b></TD></TR></TABLE>");*/ 
			}

			br.append(getQueryDataTable(rowset,(100 / columnHdr.length), minrow, vo,masterName));
			
			// TO ADD HEADER NOTE & PAGINATION IN SAME ROW BY RAHUL ON 27 AUG,07
			br.append("<TABLE BORDER='0' CELLSPACING='1px' CELLPADDING='1px' WIDTH='100%'><TR><TD CLASS='TDHEADER'><TABLE WIDTH='100%' CELLSPACING='1px' CELLPADDING='1px'>");
			br.append("<TD WIDTH='100%'><DIV ALIGN='RIGHT'><FONT class='nextPrevTag'>");  // COLOR='white' 
			br.append(getTotalBlockDtTbl(nextpage_no, total_page, max_rownum,minrow, blockNo, clr, vo)); 
			br.append("</FONT></DIV></TD></TABLE></TD></TR></TABLE>");
			
			br.append(getSearchRowString(vo, pagePerBlock, viewHdr, masterName, searchField, total_page, columnHdr));
			 

		}
		catch (Exception e) {
			vo.setStrMsgString("GenericHLP.GenericData -->"+e.getMessage());
			vo.setStrMsgType("1");
        } finally {
         //   util = null;
            comboQuery = null;
            combo_data = null;
            if (rowset != null) {
                try {

                    rowset.close();
                    rowset = null;
                } catch (Exception e) {
                	vo.setStrMsgString("GenericHLP.GenericData -->"+e.getMessage());
        			vo.setStrMsgType("1");
                }
            }
            if (dao != null) {
                try {
                    dao.free();
                    dao = null;
                } catch (Exception e) {
                	vo.setStrMsgString("GenericHLP.GenericData -->"+e.getMessage());
        			vo.setStrMsgType("1");
                }
            }
        }
		return br.toString();
	}

	/*
	 * getTotalBlock() function return the total block and next and previous
	 * values at list page with link
	 *
	 */

public String getTotalBlock(int nextpage_no, int total_page,int max_rownum, int minrow, int blockNo, String colorNextPrev, GenericVO vo)
{
		char temp1 = 'a';
		int t = 1;
		int temp = 1;
		int actual_page_block = getActualBlock(total_page);
		StringBuilder data = new StringBuilder(300);
		try
		{
			if (blockNo != 1)	
				data.append("<A STYLE='CURSOR:POINTER' onClick=fetchRecords('m^"+ (blockNo - 1) + "^0'," + (minrow)+ ",'2')><B><FONT COLOR='" + colorNextPrev+ "'>Previous</FONT></B></A> ");
			
			for (int k = 1; k <= total_page; k++)
			{
				if (actual_page_block > 1)
				{
					if (t > page_per_block)
					{
						data.append("<A  STYLE='CURSOR:POINTER' onClick=fetchRecords('m^"+ (++blockNo)+ "^"+ k+ "','"+ (max_rownum - 1)+ "','1')><B><FONT COLOR='"+ colorNextPrev+ "'>Next</FONT></B></A> ");
						data.append("</TR></TD></DIV>");
					}
					else
					{
						data.append("<A ID='bb" + temp1 + "" + k+ "' STYLE='CURSOR:POINTER'  onClick=changeDiv('"+ temp1 + "" + k + "')><B><U>" + nextpage_no+ "</U></B></A> ");	
						nextpage_no++;
						temp++;
						t++;
					}
				}
				else
				{
					data.append("<A ID='bb" + temp1 + "" + k+ "' STYLE='CURSOR:POINTER'  onClick=changeDiv('"+ temp1 + "" + k + "')><B><U> " + nextpage_no+ "</U></B></A> ");
					temp++;
					nextpage_no++;
				}
			}
		} 
		catch(Exception e)
		{
			vo.setStrMsgString("GenericHLP.getTotalBlock -->"+e.getMessage());
			vo.setStrMsgType("1");
		}

		return data.toString();
	}

	public String getTotalBlockDtTbl(int nextpage_no, int total_page,int max_rownum, int minrow, int blockNo, String colorNextPrev, GenericVO vo)
	{
		char temp1 = 'a';
		int t = 1;
		int temp = 1;
		int actual_page_block = getActualBlock(total_page);
		StringBuilder data = new StringBuilder(300);
		try
		{
			if (blockNo != 1)	
				data.append("<A class='btn btn-sm btn-primary prevPageBtn' style='margin:5px 5px;' onClick=fetchRecords('m^"+ (blockNo - 1) + "^0'," + (minrow)+ ",'2')><B><FONT COLOR='" + colorNextPrev+ "'><span class='glyphicon glyphicon-chevron-left'></span> Older</FONT></B></A> ");
			
			//data.append("<font style='font-size:13px'> Section "+blockNo+" </font> ");
			
			for (int k = 1; k <= total_page; k++)
			{
				if (actual_page_block > 1)
				{
					if (t > page_per_block)
					{
						data.append("<A class='btn btn-sm btn-primary nextPageBtn' style='margin:5px 5px;' onClick=fetchRecords('m^"+ (++blockNo)+ "^"+ k+ "','"+ (max_rownum - 1)+ "','1')><B><FONT COLOR='"+ colorNextPrev+ "'>Latest <span class='glyphicon glyphicon-chevron-right'></span></FONT></B></A> ");
						data.append("</TR></TD></DIV>");
					}
					else
					{
						//data.append("<A ID='bb" + temp1 + "" + k+ "' STYLE='CURSOR:POINTER'  onClick=changeDiv('"+ temp1 + "" + k + "')><B><U>" + nextpage_no+ "</U></B></A> ");	
						nextpage_no++;
						temp++;
						t++;
					}
				}
				else
				{
					//data.append("<A ID='bb" + temp1 + "" + k+ "' STYLE='CURSOR:POINTER'  onClick=changeDiv('"+ temp1 + "" + k + "')><B><U> " + nextpage_no+ "</U></B></A> ");
					temp++;
					nextpage_no++;
				}
			}
		} 
		catch(Exception e)
		{
			vo.setStrMsgString("GenericHLP.getTotalBlock -->"+e.getMessage());
			vo.setStrMsgType("1");
		}

		return data.toString();
	}
	/*
		 * getColoumnHeaderString(MasterInterface masterObj) function make a
		 * string of column header and also assign order by value to column and
		 * return a string
		 */

	public String getColoumnHeaderString(String[] columnHdr,
			String[] orderby, GenericVO vo) {

		StringBuilder data = new StringBuilder(300);
		String coulmn_header[] = columnHdr;

		int coulmn_header_length = coulmn_header.length;
		int size_percent = 100 / coulmn_header_length;
		String order_by_Array[] = orderby;

		int order_length = order_by_Array.length;
		int flag = 0;
		int orderHead = 0;

		ResourceBundle utilRes = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");

		String strDragDrop ="";
		try{
			strDragDrop = utilRes.getString("DRAGDROPINMASTERREQUIRED");
		}catch(Exception _e){
			strDragDrop = "0";
		}


		try{
			if(strDragDrop.equals("1"))
				data.append("<TD CLASS='TDFONTHEAD'>#</TD>");
			data.append("<TD CLASS='TDFONTHEAD'><INPUT TYPE='CHECKBOX' NAME='chkmain' onkeypress='return keypress(event);' onclick='isCheckedFirst();'></TD>");

			for (int columnHead = 0; columnHead < coulmn_header_length; columnHead++) {
				flag = 0;
				for (orderHead = 0; orderHead < order_length; orderHead = orderHead + 2) {
					if ((Integer.parseInt(order_by_Array[orderHead]) - 1) == columnHead) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {

					if(SecurityUtil.decrypt(vo.getOrderby()).equals(order_by_Array[orderHead + 1]+ " ASC")) {

						data.append("<TD CLASS=TDFONTHEAD WIDTH='"
								+ size_percent	+ "%'><B>"+ coulmn_header[columnHead]+ "</B><img style='CURSOR:POINTER' " +
										" src='../../hisglobal/images/arrdouble-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
										+ SecurityUtil.encrypt(order_by_Array[orderHead + 1]+" ASC")+"\");'>"
								+ " <img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
								+ SecurityUtil.encrypt(order_by_Array[orderHead + 1] + " DESC")+"\");'></div>");

					}
					else {

						if (SecurityUtil.decrypt(vo.getOrderby()).equals(order_by_Array[orderHead + 1]+ " DESC"))  {

							data.append("<TD CLASS=TDFONTHEAD WIDTH='"
									+ size_percent	+ "%'><B>"+ coulmn_header[columnHead]+ "</B><img style='CURSOR:POINTER' " +
											"src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
											+ SecurityUtil.encrypt(order_by_Array[orderHead + 1]+ " ASC")+"\");'>"
									+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arrdouble-down.png' width='12px' " +
											"TITLE='Descending Order' onClick='sortData(\""
											+ SecurityUtil.encrypt(order_by_Array[orderHead + 1] + " DESC")+"\");'></div>");

						}
						else {
							data.append("<TD CLASS=TDFONTHEAD WIDTH='"
									+ size_percent	+ "%'><B>"+ coulmn_header[columnHead]+ "</B><img style='CURSOR:POINTER'" +
											"src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
											+ SecurityUtil.encrypt(order_by_Array[orderHead + 1]+ " ASC")+"\");'>"
									+ " <img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
									+ SecurityUtil.encrypt(order_by_Array[orderHead + 1] + " DESC")+"\");'></div>");
						}
					}
			}
			else {
				data.append("<TD CLASS=TDFONTHEAD WIDTH='" + size_percent+ "%'><B>" + coulmn_header[columnHead] + "</B>	</TD>");
			}

		}

			data.append("</TR></TABLE><TABLE WIDTH='100%' CELLSPACING='0px' CELLPADDING='0px'><TR><TD CLASS='TDFONT'>");
		} catch(Exception e){
			vo.setStrMsgString("GenericHLP.getColoumnHeaderString -->"+e.getMessage());
			vo.setStrMsgType("1");
		}
        order_by_Array=null;
        coulmn_header=null;

		return data.toString();

	}

	public String getColoumnHeaderStringDtTbl(String[] columnHdr,
			String[] orderby, GenericVO vo) {

		StringBuilder data = new StringBuilder(300);
		String coulmn_header[] = columnHdr;

		int coulmn_header_length = coulmn_header.length;
		int size_percent = 100 / coulmn_header_length;
		String order_by_Array[] = orderby;

		int order_length = order_by_Array.length;
		int flag = 0;
		int orderHead = 0;

		ResourceBundle utilRes = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");

		String strDragDrop ="";
		try{
			strDragDrop = utilRes.getString("DRAGDROPINMASTERREQUIRED");
		}catch(Exception _e){
			strDragDrop = "0";
		}


		try{
			if(strDragDrop.equals("1"))
				data.append("<Th CLASS='no-sort TDFONTHEAD'>#</Th>");
			data.append("<Th CLASS='no-sort TDFONTHEAD'></Th>"); //<INPUT TYPE='CHECKBOX' NAME='chkmain' onkeypress='return keypress(event);' onclick='isCheckedFirst();'>

			for (int columnHead = 0; columnHead < coulmn_header_length; columnHead++) {
				flag = 0;
				for (orderHead = 0; orderHead < order_length; orderHead = orderHead + 2) {
					if ((Integer.parseInt(order_by_Array[orderHead]) - 1) == columnHead) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {

						if(vo.getOrderby().equals(order_by_Array[orderHead + 1]+ " ASC")) {

							data.append("<Th><B>"+ coulmn_header[columnHead]+ "</B>"
									/*+"<img style='CURSOR:POINTER' " +
											" src='../../hisglobal/images/arrdouble-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
									+ order_by_Array[orderHead + 1]+ " ASC\");'>"*/
									/*+ " <img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
									+ order_by_Array[orderHead + 1] + " DESC\");'>"*/
									);

						}
						else {

							if (vo.getOrderby().equals(order_by_Array[orderHead + 1]+ " DESC")) {

								data.append("<Th><B>"+ coulmn_header[columnHead]+ "</B>"
										/*+"<img style='CURSOR:POINTER' " +
												"src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1]+ " ASC\");'>"
										+ "<img style='CURSOR:POINTER' src='../../hisglobal/images/arrdouble-down.png' width='12px' " +
												"TITLE='Descending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1] + " DESC\");'>"*/
										);

							}
							else {
								data.append("<Th><B>"+ coulmn_header[columnHead]+ "</B>"
										/*+"<img style='CURSOR:POINTER'" +
												"src='../../hisglobal/images/arr-up.png' width='12px' TITLE='Ascending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1]+ " ASC\");'>"
										+ " <img style='CURSOR:POINTER' src='../../hisglobal/images/arr-dwn.png' width='12px' TITLE='Descending Order' onClick='sortData(\""
										+ order_by_Array[orderHead + 1] + " DESC\");'>"*/
										);
							}
						}
				}
				else {
					data.append("<Th><B>" + coulmn_header[columnHead] + "</B>	</Th>"); // WIDTH='" + size_percent+ "%'
				}

			}

			data.append("<th class='no-sort'></th></TR></thead><tbody>"); //</TABLE><TABLE id='mainDataTableId' WIDTH='100%' CELLSPACING='0px' CELLPADDING='0px'><TR><TD CLASS='TDFONT'>
		} catch(Exception e){
			vo.setStrMsgString("GenericHLP.getColoumnHeaderString -->"+e.getMessage());
			vo.setStrMsgType("1");
		}
        order_by_Array=null;
        coulmn_header=null;

		return data.toString();

	}
	
	/*
	 * getQueryData(WebRowSet rowset, int size_percent, int minRow) function
	 * makes the data row for list page
	 *
	 */

	public String getQueryData(WebRowSet rowset, int size_percent, int minRow, GenericVO vo,String masterName) {
		int k = 1;
		StringBuilder dataBuffer = new StringBuilder(300);
		int j = 1;
		int temp = 0;
		String tempStr = "";
		String[] tempArray;
		String[] tempArray1;
		String rowClassName = "class = 'ROWFONT'";
		String[] tempArr=masterName.split("#");
		String[] rowStatus=null;
		if(tempArr.length>=2 && tempArr[1]!=null && !tempArr[1].equals(""))
		{

			rowStatus=tempArr[1].replace("^","#").split("#");

		}

		try{
			while (rowset.next()) {

				tempStr = String.valueOf(rowset.getString(1));



				String tempStr1 = tempStr.replace('^', '#');



				tempArray1 = tempStr1.split("#");


				if(!tempStr1.endsWith("#"))	// changed on 13th july..problem was-- if last value is null then it can not be split..

					tempArray = tempArray1;

				else
				{
				//	System.out.println("Insde else");
					tempArray = new String[tempArray1.length+1];
					for(int i=0; i<tempArray1.length; i++)
						tempArray[i] = tempArray1[i];

					tempArray[tempArray1.length] = "";

				}

					if (temp % rec_per_page == 0)
					{
						String idvalue = "a" + j;
						j++;
	
						if (idvalue.equals("a1"))
							dataBuffer.append("<DIV ID='"+ idvalue	+ "' STYLE='DISPLAY:BLOCK;position:relative'><TABLE width='100%' bgcolor='white'>");
	
						else
							dataBuffer.append("<DIV ID='"+ idvalue+ "' STYLE='DISPLAY:NONE;position:relative'><TABLE width='100%' bgcolor='white'>");
	
	//					System.out.println("Data-->"+dataBuffer.toString());
					}
				if(rowStatus!=null && rowStatus.length%4==0)
				{
						if (tempArray[Integer.parseInt(rowStatus[0])-1].equalsIgnoreCase(rowStatus[1])) 
						{
							rowClassName = "class = 'rowfontmatch' bgcolor = '"+ rowStatus[3] + "'";		
							dataBuffer.append("<TR ID='tr" + k	+ "' "+rowClassName+">");
						}
						else
						{
							rowClassName = "class = 'ROWFONT'";													
							dataBuffer.append("<TR ID='tr" + k	+ "' "+rowClassName+" " +" onMouseOver=\"changeColor(this," + k + ",0,1);\" onMouseOut=\"changeColor(this," + k + ",1);\" >");
						}
				}
				else
				{
					rowClassName = "class = 'ROWFONT'";
					dataBuffer.append("<TR ID='tr" + k	+ "' "+rowClassName+" " +" onMouseOver=\"changeColor(this," + k + ",0);\" onMouseOut=\"changeColor(this," + k + ",1);\" >");
				}

				//dataBuffer.append("<TR ID='tr" + k	+ "' onMouseOver=\"alert('ram');\" onMouseOut='changeColor(this," + k + ",1);' >");
				ResourceBundle utilRes = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");

				String strDragDrop ="";
				try{
					strDragDrop = utilRes.getString("DRAGDROPINMASTERREQUIRED");
				}catch(Exception _e){
					strDragDrop = "0";
				}
				if(strDragDrop.equals("1"))
					dataBuffer.append("<TD><img class='drag' title='Drag this Tag to Required Process' style='cursor: pointer;' " +
							" name='"+tempArray[0]+"' src='../../hisglobal/images/Drag_Row_1.gif'></TD>");
				dataBuffer.append("<TD><INPUT TYPE='CHECKBOX' onkeypress='return keypress(event)' VALUE='"	+ tempArray[0] + "$" + (k) + "' NAME='chk'></TD>");
				k++;

				for (int m = 0; m < no_of_column; m++)
				{
					dataBuffer.append("<TD  WIDTH='" + size_percent + "%'>&nbsp;"+ tempArray[m + 1] + "</TD>");
				}
				dataBuffer.append("<TD><img style='cursor: pointer;' name='"+tempArray[0]+ "$" + (k-1) + "' onClick='deleteRecordsOnRow(\"DELETE\",this);' src='../../hisglobal/images/trash.png'></TD>");
				dataBuffer.append("</tr>");

				if (temp % rec_per_page == rec_per_page - 1)	// LOWER HEADER ROW IS SHIFTED TO getSearchRowString FUNCTION FROM HERE BY RAHUL ON 27 AUG,07
					dataBuffer.append("</TABLE></DIV>");
				temp++;
			}

			if ((temp - 1) % rec_per_page != rec_per_page - 1)
				dataBuffer.append("</TABLE></DIV>");
	      }
		catch(Exception e)
	    {
	    	vo.setStrMsgString("GenericHLP.getQueryData -->"+e.getMessage());
			vo.setStrMsgType("1");
	    }
	    finally{
	        tempArray=null;
	        tempStr=null;
	        if(rowset !=null)
	        {
	           try{
	               rowset.close();
	           }
	           catch(Exception e)
	           {
	        	   vo.setStrMsgString("GenericHLP.getQueryData -->"+e.getMessage());
	   			   vo.setStrMsgType("1");
	           }
	        }
	    }

		return dataBuffer.toString();
	}

	
	public String getQueryDataTable(WebRowSet rowset, int size_percent, int minRow, GenericVO vo,String masterName) {
	int k = 1;
	StringBuilder dataBuffer = new StringBuilder(300);
	int j = 1;
	int temp = 0;
	String tempStr = "";
	String[] tempArray;
	String[] tempArray1;
	String rowClassName = "class = 'ROWFONT'";
	String[] tempArr=masterName.split("#");
	String[] rowStatus=null;
	if(tempArr.length>=2 && tempArr[1]!=null && !tempArr[1].equals(""))
	{

		rowStatus=tempArr[1].replace("^","#").split("#");

	}

	try{
		while (rowset.next()) {

			tempStr = String.valueOf(rowset.getString(1));



			String tempStr1 = tempStr.replace('^', '#');



			tempArray1 = tempStr1.split("#");


			if(!tempStr1.endsWith("#"))	// changed on 13th july..problem was-- if last value is null then it can not be split..

				tempArray = tempArray1;

			else
			{
			//	System.out.println("Insde else");
				tempArray = new String[tempArray1.length+1];
				for(int i=0; i<tempArray1.length; i++)
					tempArray[i] = tempArray1[i];

				tempArray[tempArray1.length] = "";

			}

				if (temp % rec_per_page == 0)
				{
					String idvalue = "a" + j;
					j++;

					/*if (idvalue.equals("a1"))
						dataBuffer.append("<DIV ID='"+ idvalue	+ "' STYLE='DISPLAY:BLOCK;position:relative'><TABLE width='100%' bgcolor='white'>");

					else
						dataBuffer.append("<DIV ID='"+ idvalue+ "' STYLE='DISPLAY:BLOCK;position:relative'><TABLE width='100%' bgcolor='white'>");*/


//					System.out.println("Data-->"+dataBuffer.toString());
				}
			if(rowStatus!=null && rowStatus.length%4==0)
			{
					if (tempArray[Integer.parseInt(rowStatus[0])-1].equalsIgnoreCase(rowStatus[1])) 
					{
						rowClassName = "class = 'rowfontmatch' bgcolor = '"+ rowStatus[3] + "'";		
						dataBuffer.append("<TR ID='tr" + k	+ "' "+rowClassName+">");
					}
					else
					{
						rowClassName = "class = 'ROWFONT'";													
						dataBuffer.append("<TR ID='tr" + k	+ "' "+rowClassName+" " +" onMouseOver=\"changeColor(this," + k + ",0,1);\" onMouseOut=\"changeColor(this," + k + ",1);\" >");
					}
			}
			else
			{
				rowClassName = "class = 'ROWFONT'";
				dataBuffer.append("<TR ID='tr" + k	+ "' "+rowClassName+" " +" onMouseOver=\"changeColor(this," + k + ",0);\" onMouseOut=\"changeColor(this," + k + ",1);\" >");
			}

			//dataBuffer.append("<TR ID='tr" + k	+ "' onMouseOver=\"alert('ram');\" onMouseOut='changeColor(this," + k + ",1);' >");
			ResourceBundle utilRes = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");

			String strDragDrop ="";
			try{
				strDragDrop = utilRes.getString("DRAGDROPINMASTERREQUIRED");
			}catch(Exception _e){
				strDragDrop = "0";
			}
			if(strDragDrop.equals("1"))
				dataBuffer.append("<TD><img class='drag' title='Drag this Tag to Required Process' style='cursor: pointer;' " +
						" name='"+tempArray[0]+"' src='../../hisglobal/images/Drag_Row_1.gif'></TD>");
			dataBuffer.append("<TD><INPUT TYPE='CHECKBOX' onkeypress='return keypress(event)' VALUE='"	+ tempArray[0] + "$" + (k) + "' NAME='chk'></TD>");
			k++;

			for (int m = 0; m < no_of_column; m++)
			{
				dataBuffer.append("<TD>&nbsp;"+ tempArray[m + 1] + "</TD>");
			}
			dataBuffer.append("<TD><img style='cursor: pointer;' name='"+tempArray[0]+ "$" + (k-1) + "' onClick='deleteRecordsOnRow(\"DELETE\",this);' src='../../hisglobal/images/trash.png'></TD>");
			dataBuffer.append("</tr>");

			if (temp % rec_per_page == rec_per_page - 1)	// LOWER HEADER ROW IS SHIFTED TO getSearchRowString FUNCTION FROM HERE BY RAHUL ON 27 AUG,07
				//dataBuffer.append("</TABLE></DIV>");
			temp++;
		}

		if ((temp - 1) % rec_per_page != rec_per_page - 1)
			dataBuffer.append("</thead></TABLE></DIV>");
      }
	catch(Exception e)
    {
    	vo.setStrMsgString("GenericHLP.getQueryData -->"+e.getMessage());
		vo.setStrMsgType("1");
    }
    finally{
        tempArray=null;
        tempStr=null;
        if(rowset !=null)
        {
           try{
               rowset.close();
           }
           catch(Exception e)
           {
        	   vo.setStrMsgString("GenericHLP.getQueryData -->"+e.getMessage());
   			   vo.setStrMsgType("1");
           }
        }
    }

	return dataBuffer.toString();
}
	/*
	 *
	 * getSearchRowString() method make search row and search combo box
	 *
	 *
	 */

	public String getSearchRowString(GenericVO vo,int pagePerBlock, List<String> viewHdr,
			String masterName, String[] searchFld, int total_page, String[] colmnHdr) {

		StringBuilder br = new StringBuilder(200);
		String search_cmb[] = searchFld;
		String coulmn_header[] = colmnHdr;
		String selectSearchValue = "";

		String search = vo.getSearch().replace("$", "%");
		String searchColumn = vo.getSearchColumn();
		search_cmb = searchFld;

		int viewSize = 0;

		try{

			if(viewHdr != null) {
				viewSize = viewHdr.size();
			}
			if (search != null && !search.equals("null") && !search.equals(""))
				selectSearchValue = search;

			// br.append("</TABLE></DIV>");

			br.append("####<TABLE WIDTH='100%' BORDER='0' cellspacing='0' cellpadding='0' ><TR>"	+
					"<TD CLASS='TDSEARCH' style= 'vertical-align:top;'> <DIV ALIGN='RIGHT'> Search By&nbsp;&nbsp;&nbsp;</DIV> </TD>");
			br.append("<TD CLASS='TDSEARCH' width='122px' style= 'vertical-align:top;'><DIV ALIGN='left'> "	+ "<SELECT  name='searchColumn' " +
					"CLASS='CB1' >");
			//	 NEW CSS CLASS TDSEARCH HAS BEEN USED INSTEAD OF PREVIOUS ONE TO ADD NEW COLOR TO THE ROW BY RAHUL ON 27 AUG,07

			for (int i = 0; i < search_cmb.length; i += 2) {
				if (search_cmb[i + 1].equals(searchColumn)) {
					br.append("<OPTION SELECTED VALUE=\"" + SecurityUtil.encrypt(search_cmb[i + 1]) + "\">"	+ coulmn_header[(Integer.parseInt(search_cmb[i]) - 1)]
							+ "</OPTION>");
				}
				else
					br.append("<OPTION VALUE=\"" + SecurityUtil.encrypt(search_cmb[i + 1]) + "\">"	+ coulmn_header[(Integer.parseInt(search_cmb[i]) - 1)]
							+ "</OPTION>");
			}

			br.append("</select></DIV></TD>");
			br.append("<TD CLASS='TDSEARCH' WIDTH='152px' style= 'vertical-align:top;'><DIV ALIGN='left'>"+
					"<input type='text'  name='search' value='"	+ selectSearchValue + "' onkeyup='validateSearchField(this);' onchange='validateSearchField(this);' onKeyPress='if(event.keyCode==13) return searchpage();' class='TEXTBOX1'></DIV></td>");
			br.append("<TD CLASS='TDSEARCH' WIDTH='85px' style= 'vertical-align:top;'><DIV ALIGN='left'> &nbsp;&nbsp;<IMG SRC='../../hisglobal/images/search_icon1.gif' " +
					"alt='Click To Search Records' onClick='searchpage();' style='position: absolute' tabindex='0' onKeyPress='if(event.keyCode==13) searchpage();'></DIV></TD>");

			String[] temp=masterName.split("#");
			String[] rowStatus=null;
			if(temp.length>=2)
			{
				if(temp[1]!=null && !temp[1].equals(""))
				rowStatus=temp[1].replace("^","#").split("#");
				if(rowStatus.length%4==0)
				{
					br.append("<TR><TD CLASS='TDHEADER' COLSPAN='4'><div align='right'>[<FONT COLOR='" + rowStatus[3] + "'>"+ rowStatus[2] + "</FONT>]</div></TD></TR></TABLE>");
				}
				else
					br.append("<TR><TD CLASS='TDHEADER' COLSPAN='4'>&nbsp;</TD></TR></TABLE>");	// LOWER HEADER ROW IS ADDED HERE BY RAHUL ON 27 AUG,07
			}
			else
				br.append("<TR><TD CLASS='TDHEADER' COLSPAN='4'>&nbsp;</TD></TR></TABLE>");	// LOWER HEADER ROW IS ADDED HERE BY RAHUL ON 27 AUG,07

	        //br.append("<TR><TD WIDTH='100%' CLASS='TDHEADER' COLSPAN='10'>&nbsp;</TD></TR></TABLE>");	// LOWER HEADER ROW IS ADDED HERE BY RAHUL ON 27 AUG,07
	        br.append("<INPUT TYPE='HIDDEN' NAME='minrow' VALUE='" + Integer.parseInt(vo.getMinrow()) + "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='max_rownum' VALUE='" + Integer.parseInt(vo.getMax_rownum())+ "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='page_par_block' VALUE='"+ pagePerBlock + "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='orderby' VALUE='" + SecurityUtil.encrypt(vo.getOrderby())		+ "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='view_row_length' VALUE='"	+ ((viewSize) / 2) + "'>");
			br.append("<INPUT TYPE='HIDDEN' NAME='masterName' VALUE='"	+ masterName + "'>");
	        br.append("<INPUT TYPE='HIDDEN' NAME='blockNo' VALUE='" + Integer.parseInt(vo.getBlockNo())	+ "'>");
		} 
		catch(Exception e)
		{
			vo.setStrMsgString("GenericHLP.getSearchRowString -->"+e.getMessage());
			vo.setStrMsgType("1");
		}
        search_cmb=null;
        searchColumn=null;
        return br.toString();

	}


	/*
	 * getActualBlock(int total_page) function returns actual numbers of block
	 * to be made and it will return actual block
	 *
	 */

	public int getActualBlock(int total_page) {
		int actual_page_block = 0;
		actual_page_block = total_page / page_per_block;
		if (total_page % page_per_block != 0)
			actual_page_block++;
		return actual_page_block;
	}

	/*
	 * deleteRecords(String query, String chk) methods is called when delete
	 * button is clicked on list page
	*/

	// deleteRecords function is changed on 17-Aug-2007 to make function compatible with multiple query execution.
	//chk = extra information could be appended with & symbol
	public String deleteRecords(GenericVO vo) {

	     String status = "Successfully deleted !!";
	    try{
		    	if(vo.getStrMsgType().equals("0")){
		    		status = "<b><font color='#004573'> " + vo.getStrMsgString()
				      + "  Record(s) Deleted Successfully.</font></b>";
		    	} else {
		    		status = "<b><font color='red'>Error While deleting " + vo.getStrMsgString() + " Record(s)</font> </b>";
		    	}
		   }
		   catch (Exception e) {
			    status = "<b><font color='red'>Error While deleting " + vo.getStrMsgString() + " Record(s)</font> </b>";
			    vo.setStrMsgString("GenericHLP.deleteRecords --> "+e.getMessage());
				vo.setStrMsgType("1");
		    }
		   return status;
	  }



	public String getReportInterface(GenericVO vo, String[] colmnHeader,String strRecordPerPage) 
	{
		StringBuilder reportQuerydata = new StringBuilder(1000);
		try 
		{
			reportQuerydata.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
			reportQuerydata.append("<tr class='HEADER'><td width='100%' colspan='5'>Master Report Interface</td></tr>");
			reportQuerydata.append("<tr class='multiLabel'><td width='34%'>Columns");
			reportQuerydata.append("</td><td width='14%'>Group by with");
			reportQuerydata.append("</td><td width='14%'>Required Column</td>");
			reportQuerydata.append("<td width='14%'>Order By</td>");
			reportQuerydata.append("<td width='14%'>Align With</td></tr>");
			for(int nTmpI=0; nTmpI<colmnHeader.length; nTmpI++)
			{
				reportQuerydata.append("<tr><td width='34%' class='LABEL'>");
				reportQuerydata.append(colmnHeader[nTmpI]);
				reportQuerydata.append("</td><td width='14%' class='CONTROL'>");
				reportQuerydata.append("<input tabindex='1' onkeypress='return keypress(event);' onclick='checkGroupBy(this)' type=checkbox value='");
				reportQuerydata.append(nTmpI+1);
				reportQuerydata.append("' name=strGroupByForReport");
				//if(nTmpI==0)
					//reportQuerydata.append(" checked=true ");
				reportQuerydata.append("></td><td width='14%' class='CONTROL'>");
				reportQuerydata.append("<input tabindex='1' onkeypress='return keypress(event);' onclick='checkRequiredCol(this)' checked='true' type=checkbox value='");
				reportQuerydata.append(nTmpI+1);
				reportQuerydata.append("' name=strColsRequiredForReport>");
				reportQuerydata.append("</td><td width='14%' class='CONTROL'>");
				reportQuerydata.append("<input tabindex='1' onkeypress='return keypress(event);' onclick='checkRequiredCol1(this)' type=checkbox value='");
				reportQuerydata.append(nTmpI+1);
				reportQuerydata.append("' name=strOrderByCols");
				//if(nTmpI==0)
					//reportQuerydata.append(" checked=true ");
				reportQuerydata.append("></td>");
				reportQuerydata.append("</td><td width='14%' class='CONTROL'>");
				reportQuerydata.append("<select tabindex='1' name=strAlignWith>");
				reportQuerydata.append("<option value='left'>Left</option>");
				reportQuerydata.append("<option value='Right'>Right</option>");
				reportQuerydata.append("<option value='center'>Center</option>");
				reportQuerydata.append("</select></td></tr>");
			}
			reportQuerydata.append("</table>");
			reportQuerydata.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
			reportQuerydata.append("<tr class='TITLE1'><td width='100%' colspan=2><div align=left>Report Configuration</div></td></tr>");
			reportQuerydata.append("<tr><td width='50%' class='LABEL'>Show All Data</td>");
			reportQuerydata.append("<td width='50%' class='CONTROL1'><input tabindex='1' onkeypress='return keypress(event);' onclick='showAllData(this)' type=checkbox name=strShowAllData></TD></TR> ");
			reportQuerydata.append("<TR><td width='50%' class='LABEL'>No. of Records per Page</td>");
			reportQuerydata.append("<td width='50%' class='CONTROL1'><input tabindex='1'  maxlength='5' onkeypress='return keypressValidate(event);' type='text' name='strNoOfRecordsPerPage' value='"+strRecordPerPage+"'></td></tr>");
			reportQuerydata.append("<TR><td width='50%' class='LABEL'>Border Required</td>");
			reportQuerydata.append("<td width='50%' class='CONTROL1'><input tabindex='1' onkeypress='return keypress(event);' type=checkbox name=strBorderRequired>");
			reportQuerydata.append("</td></tr>");
			reportQuerydata.append("</table>");

			reportQuerydata.append("<div id='concatenationId' style='display: none;'><table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
			reportQuerydata.append("<TR><td width='50%' class='LABEL'>Concatenation Required</td>");
			reportQuerydata.append("<td width='50%' class='CONTROL1'><input tabindex='1' onkeypress='return keypress(event);' type=checkbox name=strConcate>");
			reportQuerydata.append("</td></tr>");
			reportQuerydata.append("</table></div>");

			reportQuerydata.append("<div id='groupByPatternId' style='display: none;'><table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
			reportQuerydata.append("<TR><td width='50%' class='LABEL'>Group by in Single Line</td>");
			reportQuerydata.append("<td width='50%' class='CONTROL1'><input tabindex='1' onkeypress='return keypress(event);' type=checkbox name=strGroupByPattern>");
			reportQuerydata.append("</td></tr>");
			reportQuerydata.append("</table></div>");
			//reportQuerydata.append("<tr><td width='50%' class='LABEL'>Print Type of Report</td>");
			//reportQuerydata.append("<td width='50%' class='CONTROL1'>
			//<input tabindex='1' type=radio value=0 checked name=strPDFOrHTML> HTML");
			//reportQuerydata.append("&nbsp;&nbsp; <input tabindex='1' type=radio value=1 name=strPDFOrHTML> PDF");
			//reportQuerydata.append("</td></tr>");

			reportQuerydata.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
			reportQuerydata.append("<tr class='FOOTER'> <td colspan='2'>&nbsp</td></tr>");
			reportQuerydata.append("<tr><td colspan=2 width=100% align=center>"+
					"<img onkeypress='onPressingEnter(this,event)' tabindex='1' style='cursor: pointer;' src='../../hisglobal/images/btn-generate.png' onclick='generateReport();'>"+
					"<img onkeypress='onPressingEnter(this,event)' tabindex='1' style='cursor: pointer;' src='../../hisglobal/images/back_tab.png' onclick='submitPage(\"CANCEL\");'></td></tr>");

			reportQuerydata.append("</table>");
		}
		catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("GenericHLP.getReports --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
		return reportQuerydata.toString();
	}


	/*
	 * getReports() method is used to generate the reports and this methods is
	 * also used when click on next or previous link on report page
	 *
	 */

	public String getReports(GenericVO vo,String[] comboHeader, int record_per_page, int page_per_block, String[] colmnHeader,String strShowAllData, String[] strColsWidth,String[] _strGroupByCols ) 
	{
		StringBuilder reportQuerydata = new StringBuilder(1000);
		String comboTextValue = vo.getComboValue();
		WebRowSet webRs = null;
		HisDAO dao = null;
		int blockNo = Integer.parseInt(vo.getBlockNo());
		String date=now(DATE_FORMAT_NOWwt);
		
		try 
		{
				if(vo.getStrNoOfRecordPerPages()!=null && !vo.getStrNoOfRecordPerPages().trim().equals(""))
				{
					record_per_page=Integer.parseInt(vo.getStrNoOfRecordPerPages());
					page_per_block=1;
				}
			int minrow = (blockNo * (record_per_page * page_per_block))	- (record_per_page * page_per_block);
			if(strShowAllData.equals("1") && (vo.getStrRepeat()==null || !vo.getStrRepeat().equals("yes")))
				minrow=0;
		//	int maxRow = (blockNo* (record_per_page * page_per_block) + 1);
			dao = new HisDAO("MasterTemplate", "GenericHLP");
			webRs = vo.getLstWs();
			int prev=0;
			int next=0;
			int length_min=0;
			int size=0;
			if(vo.getStrRepeat()==null || !vo.getStrRepeat().equals("yes"))
			{
				reportQuerydata.append("<TABLE ALIGN='CENTER' WIDTH=100%><TR> ");

				String temp[] = comboTextValue.split("@");
				no_of_combo = comboHeader.length/2;
				reportQuerydata.append("<TR><TD COLSPAN='");
				reportQuerydata.append((colmnHeader.length + 1) + "'><div align=right class='style_16'><I>Report Generation Date & TIme:&nbsp;"+date+"</I></div></TD>");
				reportQuerydata.append("</TR>");
				for (int k = 1, i = 0; i < no_of_combo; i++, k++) 
				{
					if (k % 3 == 0)
						reportQuerydata.append("<TR>");

					reportQuerydata.append("<TD WIDTH='20%'><div class='style_16'>" + comboHeader[2*i+1]+ ":</div></TD><TD class='style_19'> " + temp[i] + "</TD> ");
				}
				reportQuerydata.append("</TR><TR><TD class='style_19' COLSPAN='"+ (colmnHeader.length + 1) + "' ALIGN='RIGHT'>");
				prev = blockNo;
				
				if (blockNo > 1)
					reportQuerydata.append("<A  STYLE='CURSOR:POINTER' tabIndex=1 " +"onClick=fetchNextPrev('"+ (--prev)+ "')><B><font color='"+ MasterInterface.nextprevcolorReports+ "'>Previous</FONT></B></A>");

				reportQuerydata.append("&nbsp;&nbsp;" + blockNo + "&nbsp;&nbsp;");
				next = blockNo;
				
				if(strShowAllData.equals("1"))
					record_per_page=webRs.size();
				length_min = (record_per_page * page_per_block);

				if (webRs.size() > length_min)
					reportQuerydata.append("<a style='cursor:pointer' tabIndex=1 onClick=fetchNextPrev('"+ (++next)+ "')><b><font color='"+ MasterInterface.nextprevcolorReports+ "'>Next</font></b></a>");

				size = 90 / (colmnHeader.length);
				
				if(strColsWidth==null)
				{
					strColsWidth=new String[colmnHeader.length];
					for(int nTmpI=0;nTmpI<strColsWidth.length; nTmpI++)
						strColsWidth[nTmpI]=size+"";
				}
				reportQuerydata.append("</TD></TR></TABLE>");
			}
			reportQuerydata.append("<TABLE ALIGN='CENTER' id='reportTableId' width='100%'  " +"style='border-collapse: collapse; empty-cells: show; width: 100%;'");
			
			if(vo.getStrBorderRequired()!=null && vo.getStrBorderRequired().equals("true"))
				reportQuerydata.append(" border='1' rules='cols' ");
			reportQuerydata.append(">");
			
			if(vo.getStrRepeat()==null || !vo.getStrRepeat().equals("yes"))
			{
				reportQuerydata.append("<TR class='style_14' valign='top'><TD align=center WIDTH='5%'  " +" style='border: 1px solid rgb(0, 0, 0); font-weight: normal;' class='style_15'>" +"<div class='style_16'>S.No.</div></TD> ");
			}
			//Commented To Show All Data Irrespective of Groups in Master Reports
			//String[] strGroupByCols=vo.getStrReportGroupBy();
			String[] strGroupByCols=null;
			String[] strTmpData=null;
			if(strGroupByCols!=null)
				strTmpData=new String[strGroupByCols.length];
			String strTmpBlankSpace="&nbsp;";

			boolean fPathClearGo=true;
			
			if(vo.getStrRepeat()==null || !vo.getStrRepeat().equals("yes"))
			{
				for (int i = 0; i < colmnHeader.length; i++) 
				{
					fPathClearGo=true;
					for(int nTmpI=0;strGroupByCols!=null && nTmpI<strGroupByCols.length; nTmpI++)
					{
						int nTmpJ=Integer.parseInt(strGroupByCols[nTmpI]);
						if(nTmpJ==i+1)
							fPathClearGo=false;
					}
					for(int nTmpI=0;vo.getStrColNotRequired()!=null && nTmpI<vo.getStrColNotRequired().length; nTmpI++)
					{
						int nTmpJ=Integer.parseInt(vo.getStrColNotRequired()[nTmpI]);
						if(nTmpJ==i+1)
							fPathClearGo=false;
					}
					if(fPathClearGo)
					{
						reportQuerydata.append("<TD align=center WIDTH=" + strColsWidth[i] + "%   " +" style='border: 1px solid rgb(0, 0, 0); font-weight: normal;' class='style_15'>" +" <div class='style_16'>"+ colmnHeader[i] + "</div></TD> ");
					}
				}
				reportQuerydata.append("</TR>");
			}
			String strPrevDivId ="";
			int length_loop = 1;
			int nNewSlNo=0;
			String strConcat = "";
			String width = "";
			String align = "";
			
			if(vo.getStrLastRowNo()!=null && !vo.getStrLastRowNo().equals(""))
				nNewSlNo = Integer.parseInt(vo.getStrLastRowNo());
			
			if(vo.getStrRepeat()!=null && vo.getStrRepeat().equals("yes"))
			{
				prev = Integer.parseInt(vo.getStrSessionSaveParam().split("#")[0]);
				next = Integer.parseInt(vo.getStrSessionSaveParam().split("#")[1]);
				length_min = Integer.parseInt(vo.getStrSessionSaveParam().split("#")[2]);
				size= Integer.parseInt(vo.getStrSessionSaveParam().split("#")[3]);
				length_loop = Integer.parseInt(vo.getStrSessionSaveParam().split("#")[4]);
				minrow = Integer.parseInt(vo.getStrSessionSaveParam().split("#")[5]);
				strPrevDivId = vo.getStrSessionSaveParam().split("#")[6];
				
				if(vo.getStrConcatString().equals("1"))
				{
					strConcat = vo.getStrSlNo().split("#")[3];
					width = vo.getStrSlNo().split("#")[2];
					align = vo.getStrSlNo().split("#")[1];
				}

				strColsWidth = vo.getStrSessionColWidth();
				strTmpData = vo.getStrTmpData();
				if(vo.getStrConcatString().equals("1"))
					nNewSlNo = Integer.parseInt(vo.getStrSlNo().split("#")[0]);
			}
			int init_length_loop = 1;
			while (webRs.next()) 
			{
				String tempStr = webRs.getString(1);
				String tempStr1 = tempStr.replace('^', '#');
				String tempArray[] = tempStr1.split("#");

				if (length_loop <= (length_min)) 
				{
					for(int nTmpI=0;strGroupByCols!=null && nTmpI<strGroupByCols.length; nTmpI++)
					{
						boolean fPrint=true;
						
						if(nTmpI>1)
							strTmpBlankSpace+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						
						if(nTmpI==0)
							strTmpBlankSpace="&nbsp;";
						
						int nTmpJ=Integer.parseInt(strGroupByCols[nTmpI]);
						
						if(strTmpData[nTmpI]==null || !strTmpData[nTmpI].equals(tempArray[nTmpJ]))
						{
							for(int nTmpK=nTmpI+1;strGroupByCols!=null && nTmpK<strGroupByCols.length; nTmpK++)
								strTmpData[nTmpK]=null;

							if(!strConcat.equals("") && fPrint && vo.getStrConcatString().equals("1"))
							{
								reportQuerydata.append("<TR class='style_x'> <TD valign='top' align=center   class='style_19' WIDTH='5%' >&nbsp; "+ (++nNewSlNo) + ".</TD>");
								reportQuerydata.append("<TD class='style_19' valign='top' ALIGN='"+align+"'  WIDTH="+ width + "% >&nbsp; " + strConcat + " </TD></tr>");
								fPrint = false;
								strConcat="";
							}
							if(vo.getStrGroupByPatern().equals("false"))
							{
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD class='style_17' valign='top' colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' ALIGN='LEFT'>&nbsp; ");
								reportQuerydata.append(strTmpBlankSpace);
								reportQuerydata.append(colmnHeader[nTmpJ-1]);
								reportQuerydata.append(": ");
								reportQuerydata.append(tempArray[nTmpJ ]);
								reportQuerydata.append(" </TD></tr>");
							}
							else if(vo.getStrGroupByPatern().equals("true"))
							{
								String strPrintGroupCol="";
								String strPrintGroupData="";
								
								for(int nTmpL=0; nTmpL<strGroupByCols.length; nTmpL++)
								{
									if(strPrintGroupCol.equals(""))
										strPrintGroupCol=colmnHeader[Integer.parseInt(strGroupByCols[nTmpL])-1];
									else
										strPrintGroupCol+="/ "+colmnHeader[Integer.parseInt(strGroupByCols[nTmpL])-1];

									if(strPrintGroupData.equals(""))
										strPrintGroupData=tempArray[Integer.parseInt(strGroupByCols[nTmpL])];
									else
										strPrintGroupData+="/ "+tempArray[Integer.parseInt(strGroupByCols[nTmpL])];
									strTmpData[nTmpL]=tempArray[Integer.parseInt(strGroupByCols[nTmpL])];
								}
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD class='style_17' valign='top' colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' ALIGN='LEFT'>&nbsp; ");
								reportQuerydata.append(strPrintGroupCol);
								reportQuerydata.append(": <u>");
								reportQuerydata.append(strPrintGroupData);
								reportQuerydata.append("</u> </TD></tr>");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								reportQuerydata.append("<tr><TD colspan='");
								reportQuerydata.append((colmnHeader.length+1));
								reportQuerydata.append("' valign='top' ALIGN='CENTER'></TD></tr> ");
								break;
							}
							strTmpData[nTmpI]=tempArray[nTmpJ];
						}
						if(nTmpI==0)
							strTmpBlankSpace="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					}
					if(vo.getStrConcatString().equals("0"))
						reportQuerydata.append("<TR class='style_x'> <TD valign='top' align=center   class='style_19' WIDTH='5%' >&nbsp; "+ (++minrow) + ".</TD>");
					else
						++minrow;

					for (int i = 0; i < colmnHeader.length; i++) 
					{
						fPathClearGo=true;
						for(int nTmpI=0;strGroupByCols!=null && nTmpI<strGroupByCols.length; nTmpI++)
						{
							int nTmpJ=Integer.parseInt(strGroupByCols[nTmpI]);
							if(nTmpJ==i+1)
								fPathClearGo=false;
						}
						for(int nTmpI=0;vo.getStrColNotRequired()!=null && nTmpI<vo.getStrColNotRequired().length; nTmpI++)
						{
							int nTmpJ=Integer.parseInt(vo.getStrColNotRequired()[nTmpI]);
							if(nTmpJ==i+1)
								fPathClearGo=false;
						}
						if(fPathClearGo && vo.getStrConcatString().equals("0"))
						{
							String strAlign="left";
							if(vo.getStrAlignWith()!=null)
								strAlign=vo.getStrAlignWith()[i];
							if(tempArray.length>(i + 1))
								reportQuerydata.append("<TD class='style_19' valign='top' ALIGN='"+strAlign+"'  WIDTH="+ strColsWidth[i] + "% >&nbsp; " + tempArray[i + 1] + " </TD>");
							else
								reportQuerydata.append("<TD class='style_19' valign='top' ALIGN='"+strAlign+"'  WIDTH="+ strColsWidth[i] + "% >&nbsp;</TD>");
						} 
						else if(fPathClearGo && vo.getStrConcatString().equals("1"))
						{
							if(tempArray.length>(i + 1))
							{
								if(strConcat.equals(""))
								strConcat=tempArray[i + 1];
								else
								strConcat+=", "+tempArray[i + 1];
							}
							else
							{
								if(strConcat.equals(""))
								strConcat="";
								else
								strConcat+=", ";
							}	
							width=strColsWidth[i];
							if(vo.getStrAlignWith()!=null)
								align=vo.getStrAlignWith()[i];
						}						
					}

					if(minrow==webRs.size() && vo.getStrShowAllData().equals("1"))
						if(vo.getStrConcatString().equals("1"))
						{
							reportQuerydata.append("<TR class='style_x'> <TD valign='top' align=center   class='style_19' WIDTH='5%' >&nbsp; "+ (++nNewSlNo) + ".</TD>");
							reportQuerydata.append("<TD class='style_19' valign='top' ALIGN='"+align+"'  WIDTH="+ width + "% >&nbsp; " + strConcat + " </TD></tr>");
						}
					if(minrow%record_per_page==0 && minrow!=0 && vo.getStrShowAllData().equals("0")
							||(record_per_page+1>webRs.size() && minrow%record_per_page==webRs.size()))

						if(vo.getStrConcatString().equals("1"))
						{
							reportQuerydata.append("<TR class='style_x'> <TD valign='top' align=center   class='style_19' WIDTH='5%' >&nbsp; "+ (++nNewSlNo) + ".</TD>");
							reportQuerydata.append("<TD class='style_19' valign='top' ALIGN='"+align+"'  WIDTH="+ width + "% >&nbsp; " + strConcat + " </TD></tr>");
						}

					if(vo.getStrConcatString().equals("1") && (minrow+1)%record_per_page==webRs.size()%record_per_page)
						vo.setStrLastRowNo(""+(nNewSlNo+1));

					if(vo.getStrConcatString().equals("0"))
						reportQuerydata.append("</tr>");
				}
				length_loop++;
				init_length_loop++;
				if(init_length_loop==1001)
				{
					vo.setStrSessionSaveParam(""+prev+"#"+next+"#"+length_min+"#"+size+"#"+length_loop+"#"+minrow);
					vo.setStrSessionColWidth(strColsWidth);
					vo.setStrTmpData(strTmpData);
					vo.setStrSlNo(nNewSlNo+"#"+align+"#"+width+"#"+strConcat);
					break;
				}
			}
			if(minrow+1000==webRs.size())
			{
				reportQuerydata.append("<tr class='style_20' valign='top' align='center'><TD colspan='");
				reportQuerydata.append((colmnHeader.length+1));
				reportQuerydata.append("'  style='border-top: 1px solid rgb(0, 0, 0);'></TD></tr> ");
			}
			vo.setStrSessionSaveParam(vo.getStrSessionSaveParam()+"#repordata"+minrow);
			reportQuerydata.append("</table><div id='repordata");
			reportQuerydata.append(minrow);
			reportQuerydata.append("'></div>");
			if(minrow==webRs.size())
			{
				reportQuerydata.append("####");
				if(strPrevDivId.equals(""))
					strPrevDivId="reportdata";
				reportQuerydata.append(strPrevDivId);
				reportQuerydata.append("####LAST");
			}
			else if(strShowAllData.equals("1"))
			{
				reportQuerydata.append("####");
				if(strPrevDivId.equals(""))
					strPrevDivId="reportdata";
				reportQuerydata.append(strPrevDivId);
			}
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("GenericHLP.getReports --> "+e.getMessage());
			vo.setStrMsgType("1");
		}
		finally 
		{
			colmnHeader = null;
			comboHeader = null;
			if (webRs != null) 
			{
				try 
				{
					webRs = null;
				}
				catch (Exception e) 
				{
					vo.setStrMsgString("GenericHLP.getReports --> "+e.getMessage());
					vo.setStrMsgType("1");
				}
			}
			if (dao != null)
				try 
				{
					dao.free();
					dao = null;
				}
				catch (Exception e) 
				{
					vo.setStrMsgString("GenericHLP.getReports --> "+e.getMessage());
					vo.setStrMsgType("1");
				}
		}

		return reportQuerydata.toString();
	}

	public String getNextPrevRows(GenericVO vo,	String mstName, String nextprevcolor) 
	{
		StringBuilder viewBuffer = new StringBuilder(500);
		String temp = vo.getChk();
		String temp_chk[] = temp.replace('$', '#').split("#");
		int rowNum = Integer.parseInt(temp_chk[1]);
		int prev = rowNum;
		int next = rowNum;
		String masterName="";
		String master="";
		if(mstName==null)
			masterName="Master";
		else
			masterName=mstName;
		if(masterName.split("#").length>=2)
			master=masterName.split("#")[0];
		else
			master=masterName;
		try
		{
			viewBuffer.append("<TABLE ALIGN='CENTER' WIDTH='98%' border=0 cellspacing='0' cellpadding='0' >");
			viewBuffer.append("<TR><TD CLASS='VIEWTOPHEADER'>"+ master+ "</TD><TD CLASS='VIEWTOPHEADER' COLSPAN='3' ALIGN='RIGHT'>" +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			viewBuffer.append("<a style='cursor:pointer' onClick=fetchViewPrevious('"+ (--prev) + "')><B><font color='"+ nextprevcolor+ "'>Previous</font></B></A>");
			viewBuffer.append("<font color='"+ nextprevcolor	+ "'>&nbsp;&nbsp; || &nbsp;&nbsp;</font>");
			viewBuffer.append("<a  style='cursor:pointer' onClick=fetchViewNext('"+ (next) + "')><B> <font color='"+ nextprevcolor	+ "'>Next </font></B></A></TD></TR></TABLE>");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("GenericHLP.getNextPrevRows -->"+e.getMessage());
			vo.setStrMsgType("1");
		}
		return viewBuffer.toString();
	}
	public String getNextPrevRowsBS(GenericVO vo,	String mstName, String nextprevcolor) 
	{
		StringBuilder viewBuffer = new StringBuilder(500);
		String temp = vo.getChk();
		String temp_chk[] = temp.replace('$', '#').split("#");
		int rowNum = Integer.parseInt(temp_chk[1]);
		int prev = rowNum;
		int next = rowNum;
		String masterName="";
		String master="";
		if(mstName==null)
			masterName="Master";
		else
			masterName=mstName;
		if(masterName.split("#").length>=2)
			master=masterName.split("#")[0];
		else
			master=masterName;
		try
		{
			viewBuffer.append("<div class='row'><div class='col-sm-6 '><label>"+ master+ "</label></div><div class='col-sm-6' align='right'>");
			viewBuffer.append("<button type='button' class='btn btn-onfo' onClick=fetchViewPrevious('"+ (--prev) + "')>Previous</button>");
			viewBuffer.append("&nbsp;&nbsp; || &nbsp;&nbsp;");
			viewBuffer.append("<button type='button' class='btn btn-onfo' onClick=fetchViewNext('"+ (next) + "')>Next </button></div></div><br>");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("GenericHLP.getNextPrevRows -->"+e.getMessage());
			vo.setStrMsgType("1");
		}
		return viewBuffer.toString();
	}


    // this method will make a view for view page

	public String getViewRows(GenericVO vo,	List<String> hdr) {

        StringBuilder viewBuffer = new StringBuilder(500);
        ResultSetMetaData rsmeteData=null;
		List<String> list = new ArrayList<String>(10);
		String fieldName = "";
		List<String> vwHdr = new ArrayList<String>(20);
		List<String> AL_List = new ArrayList<String>(10);
		int columnCount = 0;
		vwHdr = hdr;
		try{
		rsmeteData = vo.getLstWs().getMetaData();
		columnCount  = rsmeteData.getColumnCount();
		while (vo.getLstWs().next())
			for (int i = 1; i <= columnCount; i++) {
				list.add(vo.getLstWs().getString(i));
			}
		AL_List = list;
		String p = "";
		viewBuffer.append("<TABLE ALIGN='CENTER' WIDTH='98%' >");
		if (vwHdr.size() < 0) {
			viewBuffer.append("***********Error Occured During Viewing Record**************");
			return viewBuffer.toString();
		}

		else {
			for (int i = 0, j = 0; i < vwHdr.size(); j++, i += 2) {
				fieldName = "txt1" + j;
				p = (String) vwHdr.get(i + 1);
				viewBuffer.append("<TR><TD  CLASS='TDFONTVIEW'>"
						+ vwHdr.get(i)
						+ " </TD><TD  CLASS='TDFONT'  ALIGN='LEFT' >"
						+ getControl((String) AL_List.get(j), fieldName, p	.charAt(0)) + "</TD></TR>");

			}
		}
		viewBuffer.append("<TR><TD CLASS='VIEWTOPHEADER' COLSPAN='3' ALIGN='CENTER'></TD></TR>");
		viewBuffer.append("<TR><TD  COLSPAN='3' ALIGN='CENTER'>");
		viewBuffer.append("<IMG STYLE='CURSOR:POINTER' SRC='../../../hisglobal/images/btn-ccl.png'  " +
				" tabindex='1' onClick='window.opener.closePopUp_master();'");
		viewBuffer.append("</TD></TR></TABLE>");
		} catch(Exception e){
			vo.setStrMsgString("GenericDAO.getViewRows -->"+e.getMessage());
			vo.setStrMsgType("1");
		} finally{
			vwHdr = null;
			AL_List = null;
		}
		return viewBuffer.toString();
	}
	public String getViewRowsBS(GenericVO vo,	List<String> hdr) {

        StringBuilder viewBuffer = new StringBuilder(500);
        ResultSetMetaData rsmeteData=null;
		List<String> list = new ArrayList<String>(10);
		String fieldName = "";
		List<String> vwHdr = new ArrayList<String>(20);
		List<String> AL_List = new ArrayList<String>(10);
		int columnCount = 0;
		vwHdr = hdr;
		try{
		rsmeteData = vo.getLstWs().getMetaData();
		columnCount  = rsmeteData.getColumnCount();
		while (vo.getLstWs().next())
			for (int i = 1; i <= columnCount; i++) {
				list.add(vo.getLstWs().getString(i));
			}
		AL_List = list;
		String p = "";
		if (vwHdr.size() < 0) {
			viewBuffer.append("***********Error Occured During Viewing Record**************");
			return viewBuffer.toString();
		}

		else {
			for (int i = 0, j = 0; i < vwHdr.size(); j++, i += 2) {
				fieldName = "txt1" + j;
				p = (String) vwHdr.get(i + 1);
				viewBuffer.append("<div class='row'><div  class='col-sm-6' align='right'><label>"
						+ vwHdr.get(i)
						+ " &nbsp;&nbsp;</label></div><div  class='col-sm-6' align='left' >"
						+ getControl((String) AL_List.get(j), fieldName, p	.charAt(0)) + "</div></div>");

			}
		}
		/*viewBuffer.append("<TR><TD  COLSPAN='3' ALIGN='CENTER'>");
		viewBuffer.append("<IMG STYLE='CURSOR:POINTER' SRC='../../../hisglobal/images/btn-ccl.png'  " +
				" tabindex='1' onClick='window.opener.closePopUp_master();'");
		viewBuffer.append("</TD></TR></TABLE>");*/
		} catch(Exception e){
			vo.setStrMsgString("GenericDAO.getViewRows -->"+e.getMessage());
			vo.setStrMsgType("1");
		} finally{
			vwHdr = null;
			AL_List = null;
		}
		return viewBuffer.toString();
	}
    //
	public String getControl(String fieldVal, String fieldName, char ch) {

		StringBuilder viewBuffer = new StringBuilder(500);

		switch (ch) {
		case 'D': // Option

			//viewBuffer.append("<INPUT NAME='" + fieldName
			//		+ "' TYPE='text' VALUE='" + fieldVal + "' READONLY>\n");

			viewBuffer.append(fieldVal);

			break;

		case 'T': // TextArea
			viewBuffer.append("<TEXTAREA NAME='" + fieldName
					+ "' ROWS='2' WIDTH='80' CLASS='TEXTAREA' READONLY>\n");
			viewBuffer.append(fieldVal + "\n");
			viewBuffer.append("</TEXTAREA>\n");


			break;

		case 'C': // CheckBox
			if (fieldVal.equals("1"))
				viewBuffer.append("<INPUT NAME='" + fieldName
						+ "' TYPE='CHECKBOX' CHECKED DISABLED TABINDEX='1'>\n");
			else
				viewBuffer.append("<INPUT NAME='" + fieldName
						+ "' TYPE='checkbox' DISABLED TABINDEX='1'>\n");

			break;

		case 'O': // Option
			viewBuffer.append("<INPUT NAME='RADIOBUTTON " + fieldVal
					+ "' TYPE='radio' DISABLED>\n");
			break;
		default: // TextBox
			//viewBuffer.append("<INPUT NAME='" + fieldName
			//		+ "' TYPE='text' VALUE='" + fieldVal + "' READONLY>\n");

				viewBuffer.append(fieldVal);

			break;
		}
		return viewBuffer.toString();

	}
}
