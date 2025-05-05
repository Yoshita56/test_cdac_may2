/**
 * 
 */
package mms.transactions.controller.hlp;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

/**
 * @author Anshul Jindal
 * 
 */
public class RateContractDtlTransHLP {
	
	public static String getItemDetails(WebRowSet wb)
			throws SQLException {
		StringBuffer br = new StringBuffer();
	//	RateContractDtlTransBO bo = null;
	//	RateContractDtlTransVO vo = null;
		String strBrandName = "";
		
		String strSupplierName = "";
		String strTenderNo = "";
		String strQuotationNo = "";
		String strContractDate = "";
		String strContractFromDate = "";
		String strContractToDate = "";
		String strGroupName = "";
		String strRemarks = "";
		
		
		int i = 0;

		try {
			
			//bo = new RateContractDtlTransBO();
			//vo = new RateContractDtlTransVO();

			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");

				while (wb.next()) {
					/*System.out.println("wb.getString"+wb.getString(1));
					System.out.println("wb.getString()"+wb.getString(2));
					System.out.println("wb.getString()"+wb.getString(3));
					System.out.println("wb.getString()"+wb.getString(4));
					System.out.println("wb.getString()"+wb.getString(5));
					System.out.println("wb.getString()"+wb.getString(6));
					System.out.println("wb.getString()"+wb.getString(7));
					System.out.println("wb.getString()"+wb.getString(8));
					System.out.println("wb.getString()"+wb.getString(9));
					System.out.println("wb.getString()"+wb.getString(10));
					System.out.println("wb.getString()"+wb.getString(11));
					System.out.println("wb.getString()"+wb.getString(12));*/
					
					
					strBrandName = wb.getString(9);
				//	System.out.println("strBrandName" + strBrandName);
					if (strBrandName == null) {
						strBrandName = "/";
					}

					/*vo.setStrSupplierName(wb.getString(1));
					vo.setStrTenderNo(wb.getString(2));
					vo.setStrQuotationNo(wb.getString(3));
					vo.setStrContractDate(wb.getString(4));
					vo.setStrContractFromDate(wb.getString(5));
					vo.setStrContractToDate(wb.getString(6));
					vo.setStrGroupName(wb.getString(7));
					vo.setStrRemarks(wb.getString(12));*/
					 strSupplierName = wb.getString(1);
					 strTenderNo = wb.getString(2);
					 strQuotationNo = wb.getString(3);
					 strContractDate = wb.getString(4);
					 strContractFromDate = wb.getString(5);
					 strContractToDate = wb.getString(6);
					 strGroupName = wb.getString(7);
					 strRemarks = wb.getString(12);
					

					br.append("<TR>");
					
					br.append("<TD WIDTH='25%' CLASS='multiControl' >"
							+ wb.getString(8) + "</TD>");
					br.append("<TD WIDTH='25%' CLASS='multiControl' > "
							+ strBrandName + "</TD>");
					br.append("<TD WIDTH='25%' CLASS='multiControl' >"
							+ wb.getString(10) + "</TD>");
					br.append("<TD WIDTH='25%' CLASS='multiControl' >"
							+ wb.getString(11) + "</TD>");
					
					br.append("</TR>");
					i++;
				}

				br.append("</table> ");
				
			} else {
				br
						.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='6'>"
						+ "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}
			br.append("^"+strSupplierName+"^"+strTenderNo+"^"+strQuotationNo+"^"+strContractDate+"^"+strContractFromDate+"^"+strContractToDate+"^"+strGroupName+"^"+strRemarks);
			

		} catch (Exception e) {
			/*if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("RateContractDtlTransHLP.getItemDetails() --> "
						+ vo.getStrMsgString());
			}*/

		}
	//	System.out.println(" br.toString()=" + br.toString());
		return br.toString();
	}

}
