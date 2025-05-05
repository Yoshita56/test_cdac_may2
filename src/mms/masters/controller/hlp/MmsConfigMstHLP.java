package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.masters.controller.fb.MmsConfigMstFB;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstHLP.
 */
public class MmsConfigMstHLP {

	/**
	 * Gets the penalty list.
	 * 
	 * @param formBean the form bean
	 * @param ws the ws
	 * 
	 * @return the penalty list
	 * 
	 * @throws Exception the exception
	 */
	public static String getPenaltyList(MmsConfigMstFB formBean, WebRowSet ws)
			throws Exception {

		StringBuffer sb = new StringBuffer("");
		String index = "1";
		String layerIndex = "1";
		int size = 0;
		int count = 0;

		try {

			if (ws != null && ws.size() > 0) {

				size = ws.size();

				while (ws.next()) {

					count = count + 1;

					layerIndex = index + "-" + count;

					String strFromDay = ws.getString(1);
					String strToDay = ws.getString(2);
					String strPenalty = ws.getString(3);

					if (size != count) {

						sb.append(" <div id='id" + layerIndex + "'> ");
						sb
								.append(" <table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>  ");
						sb.append(" <tbody><tr>  ");
						sb
								.append(" <td class='multiControl' width='30%'><input name='strFromDays' id='strFromDays"
										+ layerIndex
										+ "' value='"
										+ strFromDay
										+ "' type='hidden'><div id='strFromDaysDivId"
										+ layerIndex
										+ "'>"
										+ strFromDay
										+ "</div></td>  ");
						sb
								.append(" <td class='multiControl' width='30%'><input name='strToDays' id='strToDays"
										+ layerIndex
										+ "' class='txtFldMin' maxlength='3' disabled='disabled' value='"
										+ strToDay
										+ "' onkeypress='return validateData(event,5);' type='text'></td>  ");
						sb
								.append(" <td class='multiControl' width='30%'><input name='strPenalty' id='strPenalty"
										+ layerIndex
										+ "' class='txtFldMin' maxlength='5' disabled='disabled' value='"
										+ strPenalty
										+ "' onkeypress='return validateData(event,7);' type='text'></td>  ");
						sb.append(" </tr></tbody></table>  ");
						sb.append(" </div>  ");

					} else {

						sb.append(" <div id='id" + layerIndex + "'> ");
						sb
								.append(" <table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>  ");
						sb.append(" <tbody><tr>  ");
						sb
								.append(" <td class='multiControl' width='30%'><input name='strFromDays' id='strFromDays"
										+ layerIndex
										+ "' value='"
										+ strFromDay
										+ "' type='hidden'><div id='strFromDaysDivId"
										+ layerIndex
										+ "'>"
										+ strFromDay
										+ "</div></td>  ");
						sb
								.append(" <td class='multiControl' width='30%'><input name='strToDays' id='strToDays"
										+ layerIndex
										+ "' class='txtFldMin' maxlength='3' value='"
										+ strToDay
										+ "' onkeypress='return validateData(event,5);' type='text'></td>  ");
						sb
								.append(" <td class='multiControl' width='30%'><input name='strPenalty' id='strPenalty"
										+ layerIndex
										+ "' class='txtFldMin' maxlength='5' value='"
										+ strPenalty
										+ "' onkeypress='return validateData(event,7);' type='text'></td>  ");
						sb.append(" </tr></tbody></table>  ");
						sb.append(" </div>  ");

					}

				}
				////System.out.println("countHLP:::::::"+count);
				formBean.setStrMultiRowIndex(String.valueOf(count));

			}

		} catch (Exception e) {

			throw e;
		}

		return sb.toString();

	}
	
	
	/*
	 * To get penaltyList for New BS page added by Swapnil
	 */
	
	public static String getPenaltyList_BS(MmsConfigMstFB formBean, WebRowSet ws)
			throws Exception {

		StringBuffer sb = new StringBuffer("");
		String index = "1";
		String layerIndex = "1";
		int size = 0;
		int count = 0;

		try {

			if (ws != null && ws.size() > 0) {

				size = ws.size();

				while (ws.next()) {

					count = count + 1;

					layerIndex = index + "-" + count;

					String strFromDay = ws.getString(1);
					String strToDay = ws.getString(2);
					String strPenalty = ws.getString(3);

					if (size != count) {

						
						
						sb.append("<tr>  ");
						sb
								.append(" <td width=\"30%\"><input name='strFromDays' id='strFromDays"
										+ layerIndex
										+ "' value='"
										+ strFromDay
										+ "' type='hidden'><div id='strFromDaysDivId"
										+ layerIndex
										+ "'>"
										+ strFromDay
										+ "</div></td>  ");
						sb
								.append(" <td width=\"30%\"><input name='strToDays' id='strToDays"
										+ layerIndex
										+ "' class='form-control' maxlength='3' disabled='disabled' value='"
										+ strToDay
										+ "' onkeypress='return validateData(event,5);' type='text'></td>  ");
						sb
								.append(" <td width=\"30%\"><input name='strPenalty' id='strPenalty"
										+ layerIndex
										+ "' class='form-control' maxlength='5' disabled='disabled' value='"
										+ strPenalty
										+ "' onkeypress='return validateData(event,7);' type='text'></td>  ");
						sb
						.append(" <td></td>  ");
						sb.append(" </tr>");
						

					} else {

						
						
						sb.append("<tr>  ");
						sb
								.append(" <td width=\"30%\"><input name='strFromDays' id='strFromDays"
										+ layerIndex
										+ "' value='"
										+ strFromDay
										+ "' type='hidden'><div id='strFromDaysDivId"
										+ layerIndex
										+ "'>"
										+ strFromDay
										+ "</div></td>  ");
						sb
								.append(" <td width=\"30%\"><input name='strToDays' id='strToDays"
										+ layerIndex
										+ "' class='form-control' maxlength='3' value='"
										+ strToDay
										+ "' onkeypress='return validateData(event,5);' type='text'></td>  ");
						sb
								.append(" <td width=\"30%\"><input name='strPenalty' id='strPenalty"
										+ layerIndex
										+ "' class='form-control' maxlength='5' value='"
										+ strPenalty
										+ "' onkeypress='return validateData(event,7);' type='text'></td>  ");
						sb
								.append(" <td></td>  ");
						sb.append(" </tr>  ");
						

					}

				}
				////System.out.println("countHLP:::::::"+count);
				formBean.setStrMultiRowIndex(String.valueOf(count));

			}

		} catch (Exception e) {

			throw e;
		}

		return sb.toString();

	}

}



