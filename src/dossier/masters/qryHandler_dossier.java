package dossier.masters;

import java.util.ResourceBundle;

public class qryHandler_dossier {
	
	
	/** The dossier query. */
	static String dossierQuery = "dossier.masters.dossier_qry_mst";
	
	
	/** The dossier res. */
	static ResourceBundle dossierRes = null;
	
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
			if (dossierRes == null)
				dossierRes = ResourceBundle.getBundle(dossierQuery);
			qry = dossierRes.getString(qryIndex);
	
			break;
		}
	
		return qry;
	}

}
