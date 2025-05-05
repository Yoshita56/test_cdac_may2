package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.masters.vo.AuthorityHierDtlVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorityHierDtlHLP.
 */
public class AuthorityHierDtlHLP {

	/*
	 * To dispaly heirdetails in new BS page added by swapnil
	 */
	
	public static String heirdetails_BS(AuthorityHierDtlVO vo, String strPrevRec) {

		StringBuffer br = new StringBuffer("");
		String levelType = "";
		String prevRecTemp[] = null;
		String recValTemp[] = null;
		WebRowSet wb = null;
		try {
			wb = vo.getStrHierDtlWS();

			prevRecTemp = strPrevRec.replace("@@", "#").split("#");
			levelType = vo.getStrLevelType();
			if (wb.size() != 0) {
				br.append("<table class='table' >");				
				br.append("<thead>");
				br.append("<tr>");				
				br.append("<th></th>");
				br.append("<th>User-Name</th>");
				br.append("<th>Level Assigned</th>");				
				br.append("</tr>");
				br.append("</thead>"); 
				br.append("<tbody>");
				
				for (int i = 0; wb.next(); i++) {
					String chkAppVal = wb.getString(1);
					String strUsrName = wb.getString(3);
					boolean checked = false;
					String levVal = "";

					// checking for previous record existence
					for (int x = 0; x < prevRecTemp.length
							&& !strPrevRec.equals("0"); x++) {
						recValTemp = prevRecTemp[x].replace('^', '#')
								.split("#");
						if (chkAppVal.equals(recValTemp[0])) {
							checked = true;
							levVal = recValTemp[1];
							vo.setStrUpdateAuthNo(recValTemp[2]);
						}
					}

					if (strUsrName == null || strUsrName.equals("null"))
						strUsrName = "";

					br.append("<tr>");
					br.append("<td>");
					br.append("<input type='checkbox' name='chk_" ).append( levelType
							).append( "' value='" ).append( chkAppVal
							).append( "' onClick='chkSel(event,this," ).append( i ).append( ");' ");
					if (checked == true)
						br.append("checked></td>");
					else
						br.append("></td>");
					br.append("<td>"
							).append( strUsrName ).append( "</td>");

					if (checked == true) {
						br
								.append("<td><input name='chk_"
										).append( levelType
										).append( "text' type='text' value='"
										).append( levVal
										).append( "' class='form-control' maxlength='2' onKeyUp='levelEdit(this,"
										).append( i ).append( "," ).append( levelType ).append( ");'></td>");
						br.append("<input type='hidden' name='hchk_"
								).append( levelType ).append( "text' value='" ).append( levVal ).append( "'>");
					} else {
						br
								.append("<td ><input name='chk_"
										).append( levelType
										).append( "text' type='text' class='form-control' maxlength='2' onKeyUp='levelEdit(this,"
										).append( i
										).append( ","
										).append( levelType
										).append( ");' disabled></td>");
						br.append("<input type='hidden' name='hchk_"
								).append( levelType ).append( "text' value='0'>");
					}
					br.append("</tr>");
				}
				br
						.append("<input type='hidden' name='hLevelType' value='0' />");
				br.append("</tbody>");
				br.append("</table>");
				wb.beforeFirst();
			} else {
				br
						.append("<table class='table' align='center'  border='0'>");
				br.append("<tr>");
				br
						.append("<td colspan='5' >"
								).append( "<DIV class='errMsg' align='center'> No Record Found For ::"
								).append( vo.getStrTemp() ).append( " Level </div>" ).append( "</TD>");
				br.append("</tr>");
				br
						.append("<input type='hidden' name='hLevelType' value='0' />");
				br.append("</table>");
			}
		} catch (Exception e) {

			vo.setStrMsgString("AuthorityHierDtlHLP.heirdetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return br.toString();
	}
	
	
	/**
	 * Heirdetails.
	 * 
	 * @param vo the vo
	 * @param strPrevRec the str prev rec
	 * 
	 * @return the string
	 */
	public static String heirdetails(AuthorityHierDtlVO vo, String strPrevRec) {

		StringBuffer br = new StringBuffer("");
		String levelType = "";
		String prevRecTemp[] = null;
		String recValTemp[] = null;
		WebRowSet wb = null;
		try {
			wb = vo.getStrHierDtlWS();

			prevRecTemp = strPrevRec.replace("@@", "#").split("#");
			levelType = vo.getStrLevelType();
			if (wb.size() != 0) {
				br
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='10%' class='multiLabel'></td>");
				br.append("<td width='50%' class='multiLabel'>User-Name</td>");
				br.append("<td width='40%' class='multiLabel'>Level Assigned</td>");

				for (int i = 0; wb.next(); i++) {
					String chkAppVal = wb.getString(1);
					String strUsrName = wb.getString(3);
					boolean checked = false;
					String levVal = "";

					// checking for previous record existence
					for (int x = 0; x < prevRecTemp.length
							&& !strPrevRec.equals("0"); x++) {
						recValTemp = prevRecTemp[x].replace('^', '#')
								.split("#");
						if (chkAppVal.equals(recValTemp[0])) {
							checked = true;
							levVal = recValTemp[1];
							vo.setStrUpdateAuthNo(recValTemp[2]);
						}
					}

					if (strUsrName == null || strUsrName.equals("null"))
						strUsrName = "";

					br.append("<tr>");
					br.append("<td width='10%' class='multiControl'>");
					br.append("<input type='checkbox' name='chk_" ).append( levelType
							).append( "' value='" ).append( chkAppVal
							).append( "' onClick='chkSel(event,this," ).append( i ).append( ");' ");
					if (checked == true)
						br.append("checked></td>");
					else
						br.append("></td>");
					br.append("<td width='50%' class='multiControl'>"
							).append( strUsrName ).append( "</td>");

					if (checked == true) {
						br
								.append("<td width='40%' class='multiControl'><input name='chk_"
										).append( levelType
										).append( "text' type='text' value='"
										).append( levVal
										).append( "' class='txtFldMin' maxlength='2' onKeyUp='levelEdit(this,"
										).append( i ).append( "," ).append( levelType ).append( ");'></td>");
						br.append("<input type='hidden' name='hchk_"
								).append( levelType ).append( "text' value='" ).append( levVal ).append( "'>");
					} else {
						br
								.append("<td width='40%' class='multiControl'><input name='chk_"
										).append( levelType
										).append( "text' type='text' class='txtFldMin' maxlength='2' onKeyUp='levelEdit(this,"
										).append( i
										).append( ","
										).append( levelType
										).append( ");' disabled></td>");
						br.append("<input type='hidden' name='hchk_"
								).append( levelType ).append( "text' value='0'>");
					}
					br.append("</tr>");
				}
				br
						.append("<input type='hidden' name='hLevelType' value='0' />");
				br.append("</table>");
				wb.beforeFirst();
			} else {
				br
						.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				br.append("<tr>");
				br
						.append("<td colspan='5'  CLASS='multiControl' >"
								).append( "<DIV class='errMsg' align='center'> No Record Found For ::"
								).append( vo.getStrTemp() ).append( " Level </div>" ).append( "</TD>");
				br.append("</tr>");
				br
						.append("<input type='hidden' name='hLevelType' value='0' />");
				br.append("</table>");
			}
		} catch (Exception e) {

			vo.setStrMsgString("AuthorityHierDtlHLP.heirdetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return br.toString();
	}
}
