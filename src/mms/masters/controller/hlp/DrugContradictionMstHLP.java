package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

/**
 * @author Niharika Srivastava
 * Date Of Creation : Aug 27, 2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Drug Contradiction Master
 * Description : HLP for Drug Contradiction Master 
 * Last Modified By :-- 
 * Last Modification Date :--
 */

public class DrugContradictionMstHLP {
	
	public static String getStrContDrugNameView(WebRowSet wb) {
		
		StringBuffer br = new StringBuffer();
		try {
			if (wb != null) 
			{
				br.append(" <table align='center'>");
				while(wb.next())
				{
					br.append("<tr>");
					br.append(" <td width = '50%' class='multiControl' colspan='4'> ");
					br.append(wb.getString(1));
					br.append(" </td> ");
					br.append("</tr>");
				}
			br.append("</table>");
			}
		}
		 catch (Exception e) {
			 
			 e.printStackTrace();
		 }
		 return br.toString();
	}

}
