package mms.transactions.controller.hlp;

import java.sql.SQLException;
import javax.sql.rowset.WebRowSet;
import mms.transactions.vo.SupplierReturnReqTransVO;
/**
 * Developer : Deepak Tiwari 
 * Version   : 1.0 
 * Date      : 23/Jan/2009
 * Module    : MMS
 * Unit      : Supplier Return Request Details
 */

public class SupplierReturnReqTransHLP {

	public static String getPONoSearchListDetails(SupplierReturnReqTransVO vo)
			throws SQLException {
		StringBuffer br = new StringBuffer();
		int i = 0;
        WebRowSet wb=null; 
		try {
			wb=vo.getStrPODetailsWs();
			//System.out.println("wsSizePopUp->"+wb.size());
			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD WIDTH='5%' CLASS='multiLabel' colspan='1'></TD>");
				br.append("<TD WIDTH='25%' CLASS='multiLabel' colspan='1'>PO No.</TD>");
				br.append("<TD WIDTH='20%' CLASS='multiLabel' colspan='1'>PO Date</TD>");
				br.append("<TD WIDTH='25%' CLASS='multiLabel' colspan='1'>PO Type</TD>");
				br.append("<TD WIDTH='25%' CLASS='multiLabel' colspan='1'>Supplier Name</TD>");
				br.append("<TR>");
				while (wb.next()) {
					String strPOSearchDtlChkVal=wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(5);
					br.append("<TR>");
					br.append("<TD WIDTH='5%'  CLASS='multiControl' colspan='1'><input type='radio' name ='strPOSearchDtlChk' id='strItemDetailsChk"+i+"' value='"+strPOSearchDtlChkVal+"' onClick='poNoSel(this);'/> </TD>");
					br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='1'>"+ wb.getString(1) + "</TD>");
					br.append("<TD WIDTH='20%' CLASS='multiControl' colspan='1'>"+ wb.getString(2) + "</TD>");
					br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='1'>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='1'>"+ wb.getString(6) + "</TD>");
					br.append("</TR>");
					i++;
				}
				br.append("</table>");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD WIDTH='100%' CLASS='multiControl' colspan='5'>"
						+ "<font color='red' size='2'>No Record Found</font></TD>");
				br.append("</TR>");
				br.append("</table>");
			}

		} catch (Exception e) {

		}

		return br.toString();
	}

}
