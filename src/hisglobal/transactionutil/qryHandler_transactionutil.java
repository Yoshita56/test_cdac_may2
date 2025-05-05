package hisglobal.transactionutil;

import java.util.ResourceBundle;

public class qryHandler_transactionutil {

		static String utilQuery = "hisglobal.transactionutil.trans_utility_qry";		
				
		static ResourceBundle utilRes = null;
		
		
		public static String getQuery(String qryIndex) {

			String qry = "";
			
			if(utilRes == null) utilRes = ResourceBundle.getBundle(utilQuery);
			qry = utilRes.getString(qryIndex); 
			
					
			return qry;
		}
		
	}

