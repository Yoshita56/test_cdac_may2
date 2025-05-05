package hisglobal;

import hisglobal.exceptions.HisException;
import ipd.IpdBO;
import ipd.IpdVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;

public class AdmissionDetail implements Tag 
{
	PageContext pageContext;
	private String crNo = "0";
	private boolean address = false;
	private String admNo = "0";
		
	public boolean isAddress() {
		return address;
	}

	public void setAddress(boolean address) {
		this.address = address;
	}
	
	public String getCrNo() {
		return crNo;
	}
	
	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	public String getAdmNo() {
		return admNo;
	}

	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}
	
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	
	public int doStartTag() throws JspException {
		IpdVO voObj = null;
		WebRowSet ws = null;
		JspWriter jw = null;
		String temp[]=null;
		String strDis="";
		try {
			voObj = new IpdVO();
			jw = pageContext.getOut();
			ws = getAdmissionDtlsWs(voObj);
			if (ws!=null && ws.size()>0) {
				try {
					if (ws.next()) {
						String strAdmNo = ws.getString(1);
						String strAdmDateAndTime = ws.getString(2);
						String strWard = ws.getString(9);
						String strRoomOrBed =ws.getString(8);
						String tmp[]=strRoomOrBed.replace('/','#').split("#");
						String deptName=ws.getString(10);
						String unitName=ws.getString(11);
						String wardCode=ws.getString(3);
						String bedCode=ws.getString(4);
						String roomCode=ws.getString(5);
						String deptCode=ws.getString(6);
						String deptUnitCode=ws.getString(7);
						String admAdvNo=ws.getString(12);
						String consultantName=ws.getString(14);
						String strWardTypeCode=ws.getString(15); 
						String strBedTypeCode = ws.getString(16);
						String strRoomTypeCode = ws.getString(17);
						String bedallotdtme = ws.getString(19);
						if(deptName.split("&").length>1)
							deptName=deptName.replace("&", "and");
						if(unitName.split("&").length>1)
							unitName=unitName.replace("&", "and");
						if(strWard.split("&").length>1)
							strWard=strWard.replace("&", "and");
						if(tmp[0].split("&").length>1)
							tmp[0]=tmp[0].replace("&", "and");
						String strDtUtWrRmBd=deptName+"^"+unitName+"^"+strWard+"^"+tmp[0]+"^"+tmp[1];
						String strWrdBedCode=wardCode+"^"+bedCode;
						String strDeptUntRomCode=deptCode+"^"+deptUnitCode+"^"+roomCode;
						if(!(ws.getString(13).equals("0")))
						{
							strDis=ws.getString(13);
							temp=strDis.replace('^','#').split("#");
						}
						if(strAdmNo == null)  strAdmNo = "";
						if( strAdmDateAndTime == null) strAdmDateAndTime = "";
						if( strWard == null)  strWard = "";
						if( strRoomOrBed == null) strRoomOrBed = "";
						if( bedallotdtme == null) bedallotdtme = "";
						jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' >");
						jw.print("<input type='hidden' name='curDtUtWrRmBd' value='"+strDtUtWrRmBd+"'>");
						jw.print("<input type='hidden' name='curWrdBedCode' value='"+strWrdBedCode+"'>");
						jw.print("<input type='hidden' name='curDept_Unt_RomCode' value='"+strDeptUntRomCode+"'>");
						jw.print("<input type='hidden' name='curAdmAdvNo' value='"+admAdvNo+"'>");
						jw.print("<input type='hidden' name='curAdmNo' value='"+strAdmNo+"'>");
						jw.print("<input type='hidden' name='strWardTypeCode' value='"+strWardTypeCode+"'>");
						jw.print("<input type='hidden' name='strRoomTypeCode' value='"+strRoomTypeCode+"'>");
						jw.print("<input type='hidden' name='strBedTypeCode' value='"+strBedTypeCode+"'>");
						jw.print("<input type='hidden' name='strAdmDateAndTime' value='"+strAdmDateAndTime+"'>");
						jw.print("<input type='hidden' name='bedallotdtme' value='"+bedallotdtme+"'>");
						jw.print("<tr><td width='25%' class='LABEL'>Admission No.</td>");
						jw.print("<td  width='25%' class='CONTROL'> ");
						jw.print(strAdmNo);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Admission Date/Time</td>");
						jw.print("<td width='25%' class='CONTROL'><font color=\"blue\">");
						jw.print(strAdmDateAndTime);
						jw.print("</font></td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Ward</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(strWard);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Room/Bed</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(strRoomOrBed);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Department Name</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(deptName);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Unit Name</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print(unitName);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Consultant Name</td>");
						jw.print("<td width='75%' colspan='3' class='CONTROL'>");
						jw.print(consultantName);
						jw.print("</td></tr>");
						if(temp!=null)
						{
							jw.print("<tr><td width='25%' class='LABEL'>Discharge By</td>");
							jw.print("<td width='25%' class='CONTROL'>");
							jw.print(temp[0]);
							jw.print("</td>");
							jw.print("<td width='25%' class='LABEL'>Discharge Date</td>");
							jw.print("<td width='25%' class='CONTROL'>");
							jw.print(temp[1]);
							jw.print("</td></tr>");

						}
						jw.print("</table>");
					}

				} catch (Exception e) {
					new Exception(e.getMessage()); 
				}
			}
			else
			{
				//jw.print("<input type='hidden' name='strGlbErrMsgTLD' value='"+voObj.getStrMsgString()+"'");
				//jw.print("<table class='TABLEWIDTH' border='0' align='center' ><tr><td colspan='5' width='25%'  align='center'><font size='2' color='red' align='center'>No Details available</font></td></tr></table> ");	
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			voObj.setStrMsgString("Error while getting Admission detail");
			new HisException("IPD Transaction","Admission Detail Tag.doStartTag() -->",e.getMessage());
		}
		finally {
			try {
				//jw.print("<input type='hidden' name='strGlbErrMsgTLD' value='"+voObj.getStrMsgString()+"'>");
				ws.close();
			}catch(Exception e) {}
			ws = null;
			voObj = null;
		}
		return EVAL_BODY_INCLUDE;
	}

	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release() {
		// TODO Auto-generated method stub
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag tag) {
		// TODO Auto-generated method stub
	}

    public WebRowSet getAdmissionDtlsWs(IpdVO voObj)throws Exception
    {
		WebRowSet ws = null;
		IpdBO boObj = new IpdBO();
		voObj.setStrHospCode(pageContext.getSession().getAttribute("HOSPITAL_CODE").toString());
		if(!this.getCrNo().equals(""))
		{
		voObj.setStrValue1(this.getCrNo());
		voObj.setStrValue2(this.getAdmNo());
		boObj.getAdmissionDetails(voObj);
		}
		else{
			ws = null;
		}
		ws = voObj.getGblWs1();
		return ws;
    }

	
 }
