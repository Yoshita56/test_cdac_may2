/*
 	This file is used to load query resource file
*/

package billing; 
import java.util.ResourceBundle;

public class qryHandler_billing 
{
	static String mstQuery = "billing.billing_qry_mst";		
	static String trnQuery = "billing.billing_qry_trans";		
	static String rptQuery = "billing.billing_qry_rpt";		
	
	static ResourceBundle mstRes = null;
	static ResourceBundle trnRes = null;
	static ResourceBundle rptRes = null;
	
	/*
		index defined for master = 1
		index defined for transaction = 2
		index defined for report = 3
	*/
	
	public static String getQuery(int index,String qryIndex) {

		String qry = "";
		
		switch(index) {
			case 1:
				if(mstRes == null) mstRes = ResourceBundle.getBundle(mstQuery);
				qry = mstRes.getString(qryIndex); 
									
				break;
			case 2:
				if(trnRes == null) trnRes = ResourceBundle.getBundle(trnQuery);
				qry = trnRes.getString(qryIndex);
				
				break;
			case 3:
				if(rptRes == null) rptRes = ResourceBundle.getBundle(rptQuery);
				qry = rptRes.getString(qryIndex);
				
				break;		
		}
				
		return qry;
	}
	
}
