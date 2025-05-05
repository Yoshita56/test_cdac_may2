package mms;

import hisglobal.utility.HisUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class HLPMms.
 */
public class HLPMms {

	/**
	 * Gets the search item init view.
	 * 
	 * @param strFromStoreId the str from store id
	 * @param strToStoreId the str to store id
	 * @param strStoreTypeId the str store type id
	 * @param strHospitalCode the str hospital code
	 * 
	 * @return the search item init view
	 * 
	 * @throws Exception the exception
	 */
	public static String getSearchItemInitView(String strFromStoreId,
			String strToStoreId, String strStoreTypeId, String strHospitalCode)
			throws Exception {

		if (strToStoreId.equals("") || strToStoreId == null) {
			throw new Exception("To Store Id Cannot be Blank");
		}

		if (strStoreTypeId.equals("") || strStoreTypeId == null) {
			throw new Exception("Store Type Id Cannot be Blank");
		}

		if (strHospitalCode.equals("") || strHospitalCode == null) {
			throw new Exception("Hospital Code Cannot be Blank");
		}

		StringBuffer sb = new StringBuffer("");

		VOMms vo = null;
		BOMms bo = null;
		HisUtil util = null;

		try {

			vo = new VOMms(strHospitalCode);
			bo = new BOMms();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStoreTypeId(strStoreTypeId);

			bo.getStoreGroupList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception("HLPMms.getSearchItemInitView()-->"
						+ vo.getStrMsgString());
			}

			util = new HisUtil("MMS Global HLP",
					"HLPMms.getSearchItemInitView()");

			String strVal = util.getOptionValue(vo.getGroupWs(), "0",
					"0^Select Value", false);

			sb.append("");
			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td width='50%' class='LABEL'>");
			sb.append("<font color='red'>*</font>Group Name ");
			sb.append("</td> ");
			sb.append("<td width='50%' class='CONTROL'> ");
			sb
					.append("<select class='comboNormal' name='strGroupIdForItemSearch'>  ");
			sb.append(strVal);
			sb.append("</select> &nbsp; ");
			sb
					.append("<img style='cursor: pointer; ' src='../../hisglobal/images/btn-search.png' onClick='searchItems(\""
							+ strFromStoreId
							+ "\", \""
							+ strToStoreId
							+ "\" , \"" + strStoreTypeId + "\");' /> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

		} catch (Exception e) {

			throw e;
		} finally {

			vo = null;
			bo = null;
			util = null;
		}

		return sb.toString();
	}

}
