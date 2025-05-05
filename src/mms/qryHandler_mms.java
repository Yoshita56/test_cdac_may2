/*
 	This file is used to load query resource file
 */

package mms;

import java.util.ResourceBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class qryHandler_mms.
 */
public class qryHandler_mms {
	
	/** The mst query. */
	static String mstQuery = "mms.mms_qry_mst";
	
	/** The trn query. */
	static String trnQuery = "mms.mms_qry_trans";
	
	/** The rpt query. */
	static String rptQuery = "mms.mms_qry_rpt";
	
	/** The web service query. */
	static String webServiceQuery = "in.cdac.mhealth.query";

	/** The mst res. */
	static ResourceBundle mstRes = null;
	
	/** The trn res. */
	static ResourceBundle trnRes = null;
	
	/** The rpt res. */
	static ResourceBundle rptRes = null;
	/** The Web Service res. */
	static ResourceBundle webserviceRes = null;
	
	public static ResourceBundle res = null;

	/*
	 * index defined for master = 1 index defined for transaction = 2 index
	 * defined for report = 3
	 */

	/**
	 * Gets the query.
	 * 
	 * @param index the index
	 * @param qryIndex the qry index
	 * 
	 * @return the query
	 */
	public static String getQuery(int index, String qryIndex) {

		String qry = "";

		switch (index) {
		case 1:
			if (mstRes == null)
				mstRes = ResourceBundle.getBundle(mstQuery);
			qry = mstRes.getString(qryIndex);

			break;
		case 2:
			if (trnRes == null)
				trnRes = ResourceBundle.getBundle(trnQuery);
			qry = trnRes.getString(qryIndex);

			break;
		case 3:
			if (rptRes == null)
				rptRes = ResourceBundle.getBundle(rptQuery);
			qry = rptRes.getString(qryIndex);

			break;
			
		case 4:
			if (webserviceRes == null)
				webserviceRes = ResourceBundle.getBundle(webServiceQuery);
			qry = webserviceRes.getString(qryIndex);

			break;
		}

		return qry;
	}

}
