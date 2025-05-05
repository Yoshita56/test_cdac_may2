package ipd;

import java.util.ResourceBundle;

public class qryHandler_transactionutil {

		static String utilQuery = "ipd.trans_utility_qry";		
				
		static ResourceBundle utilRes = null;
		
		
		public static String getQuery(String qryIndex) {

			String qry = "";
			
			if(utilRes == null) utilRes = ResourceBundle.getBundle(utilQuery);
			qry = utilRes.getString(qryIndex); 
			
					
			return qry;
		}
		
	}

