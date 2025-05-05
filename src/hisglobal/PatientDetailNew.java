package hisglobal;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import ipd.IpdBO;
import ipd.IpdConfigUtil;
import ipd.IpdVO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.json.simple.parser.JSONParser;


public class PatientDetailNew implements Tag 
{
	PageContext pageContext;
	private String crNo = "0";
	private boolean address = false;
	private boolean motherCrFlag = false;
	String tileBgColor="transparent";
	
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
	
	
	public boolean isMotherCrFlag() {
		return motherCrFlag;
	}
	public void setMotherCrFlag(boolean motherCrFlag) {
		this.motherCrFlag = motherCrFlag;
	}
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	public int doStartTag() throws JspException 
	{
		IpdVO voObj = null;
		WebRowSet ws = null;
		JspWriter jw = null;
		String isBPL="0";
		String isMLC="0";
		String isRefer="0";
		String isNewBorn="0";
		try 
		{
			voObj = new IpdVO();
			jw = pageContext.getOut();
			ws = getPatientDtlsWs(voObj);
			//System.out.println("ws.size :"+ws.size());
			if (ws!=null && ws.size()>0) 
			{
				try 
				{
					if (ws.next()) 
					{
						String strAgeAndSex = 			ws.getString(2);
						String strPatientName = 		ws.getString(3);
						String strFather = ws.getString(4);
						String strHusbandName=ws.getString(10);
						String strReligion =			ws.getString(5);
						String strCategoryName =		ws.getString(6);
						String strCategoryCode =		ws.getString(7);
						String strAddress =				ws.getString(8);
						String strMlcNo=ws.getString(9);
						String strMotherName=ws.getString(11);
						String strMotherPuk=ws.getString(12);
						String strEmailId=ws.getString(15);
						String strMobile=ws.getString(17);
						String strMotherDtl=strMotherName+"^"+strMotherPuk;
						String strRegDt=ws.getString(18);
						String strEmgContact=ws.getString(19);
						String strBornInHosp=ws.getString(20);
						String strHospName=ws.getString(21);
						String umidno=ws.getString(24);
						IpdConfigUtil ipdConfig = null;
						ipdConfig = new IpdConfigUtil(ws.getString(23));
						if(strHusbandName == null) strHusbandName = "";//"---";
						String strHiddenPatDtl=strPatientName+"^"+strFather+"/"+strHusbandName+"^"+strCategoryName+"^"+strAgeAndSex+"^"+strAddress+"^"+strHospName+"^"+umidno+"^"+strMobile;
						if(strAgeAndSex == null) strAgeAndSex = "";
						if(strPatientName == null) strPatientName = "";
						if(strFather == null) strFather = "";
						if(strHusbandName == null) strHusbandName = "";
						if(strReligion == null) strReligion = "";
						if(strCategoryName == null) strCategoryName = "";
						if(strCategoryCode == null) strCategoryCode = "";
						if(strAddress == null) strAddress = "";
						if(strMlcNo == null) strMlcNo = "";
						if(strMlcNo.equals("0")) strMlcNo = "";
						
						String fatherHusbandName="";//Show Either Father Name or Husband Name
						if(strFather == null || strFather.equals(""))
						{
							if(strHusbandName == null || strHusbandName.equals("")) 
								fatherHusbandName ="---";
							else
								fatherHusbandName=strHusbandName;
						}
						else
							fatherHusbandName=strFather;
						
						
						String gender=strAgeAndSex.replace("/", "#").split("#")[1].trim();
						String genderClass="<i class='fas fa-user' style='font-size: 26px;color: #6363ff;'></i>";
						
						
						
						if(gender.equals("M"))
							genderClass="<i class='fas fa-user' style='font-size: 26px;color: #6363ff;' title='Male'></i>";
						if(gender.equals("F"))
							genderClass="<i class='fa fa-female' style='font-size: 26px;color: #dd8d9b;' title='Female'></i>";
						if(gender.equals("O"))
							genderClass="<i class='fas fa-neuter' style='font-size: 26px;color: #6363ff;' title='Others'></i>";
						if(strMotherPuk!=null)
						{
							if(strMotherPuk.equals("") || strMotherPuk.equals(" ") || strMotherPuk.equals("0"))
								genderClass=genderClass;
							else
							{
								genderClass="<i class='fa fa-baby fa-lg'  title='New Born:Mother CR No.:"+strMotherPuk+"' style='cursor: pointer; cursor: hand'></i>";
								isNewBorn="1";
								fatherHusbandName=strMotherName;
							}
						}						
						
						
						/*if(ws.getObject("MotherPuk")!=null && !ws.getObject("MotherPuk").equals(""))		
						{
							isNewBorn="1";
							jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
							jw.print("<td  width='25%' class='CONTROL' title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");
							jw.print("<td width='25%' class='LABEL'>Mother Name</td>");
							jw.print("<td  width='25%' class='CONTROL' title='Mother CR No.:"+strMotherPuk+"' style='cursor: pointer; cursor: hand'> ");
							jw.print("<font color='blue'>"+strMotherName+"</font>");
							jw.print("</td>");
							
							fatherHusbandName=strMotherName;
						}
						else
						{*/
							/*jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
							jw.print("<td colspan='3' width='75%' class='CONTROL' title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");*/
							
							jw.print("<input type='hidden' name='strHiddenPatDtl' value='"+strHiddenPatDtl+"'><input type='hidden' name='strPatName' value='"+strPatientName+"'>");
							jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'>");
							/*jw.print("<table class='table'><thead><tr><th ></th><th></th><th></th><th></th></tr></thead>");
							jw.print("<tbody>");
							jw.print("<tr><td align='Right' class='LABEL'>Name</td>");
							jw.print("<td title='CR No:"+ws.getString(1)+"' style='cursor: pointer; cursor: hand'> ");
							jw.print(strPatientName);
							jw.print("</td>");
							jw.print("<td>");
							jw.print("</td>");
							jw.print("<td>");
							jw.print("</td>");*/
							jw.print("<div class='patTile'>");
							//jw.print("<nav class='navbar navbar-expand-sm  navbar-dark' style='padding: .1rem 1rem; border-radius: .1rem;  line-height: 2.1'>");
							
							//jw.print("<i class='fa fa-user'></i>&nbsp;&nbsp;&nbsp;&nbsp;");
							//jw.print("<div class='row'><div class='col-sm-4'><b>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;  •&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;&nbsp;&nbsp; AgeAndSex:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;• &nbsp;&nbsp;&nbsp;&nbsp;Father&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName);
							//jw.print("<div class='row'><div class='col-xs-2'><i class='fa fa-user'></i>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'><b>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>•&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>•&nbsp;&nbsp;&nbsp;&nbsp; AgeAndSex:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>• &nbsp;&nbsp;&nbsp;&nbsp;Father&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;</b></div><div class='col-xs-2'><b>•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName);    
							
							if((ws.getString(9).equals("0")))  //for MLC
							{
								//jw.print("<div class='row'><div class='col-xs-2'>"+genderClass+"</i>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-1'>•&nbsp;&nbsp;&nbsp;&nbsp; Age/Gender:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>• &nbsp;&nbsp;&nbsp;&nbsp;Father:&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName+"</div><div class='col-xs-1'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class='fas fa-flag text-danger'> MLC</i></div>");
								//jw.print("<div class='row'><div class='col-xs-2'>"+genderClass+"</i></div><div class='col-xs-2'>CR No:&nbsp;&nbsp;"+ws.getString(1)+"</div><div class='col-xs-2'>•Name:&nbsp;&nbsp;"+strPatientName+" </div><div class='col-xs-1'>•Age/Gender:&nbsp;&nbsp;"+strAgeAndSex+" </div><div class='col-xs-2'>•Father:&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+"</div><div class='col-xs-2'>•CategoryName:&nbsp;&nbsp;"+strCategoryName+"</div><div class='col-xs-1'><i class='fas fa-flag text-danger'> MLC</i></div>");
								jw.print("<div class='row justify-content-center tileHeader rownopadding'>");								
								
								if((ws.getString(22) == null ? "0" : ws.getString(22)).equals("1"))
									jw.print("<div class='col-xs-1'><img src='/HISRegistration/ImageRendererServlet?crNo="+ws.getString(1)+"&isImageStoredFTP=1' class='customIcons'></div>");
								else if(ipdConfig.getUmidFlag().equals("1"))
									jw.print("<div class='col-xs-1'><img src='/HISRegistration/ImageRendererServlet?crNo="+ws.getString(1)+"&isImageStoredFTP=2' class='customIcons'></div>");
								else if(IpdConfigUtil.PAT_PHOTO_MONGO.equals("1"))
									jw.print("<div class='col-xs-1'><img src='/HISRegistration/ImageRendererServlet?crNo="+ws.getString(1)+"&isImageStoredFTP=0' class='customIcons'></div>");
								else
									jw.print("<div class='col-xs-1'>"+genderClass+"</i></div>");
								jw.print("<div class='col-xs-2' title='Patient Name'>"+strPatientName+" </div>");
								jw.print("<div class='col-xs-4'><small title='Age/Gender/Category/Mobile No'>("+strAgeAndSex+"/"+strCategoryName+"/"+strMobile+")</small></div>");
								if(isMotherCrFlag())
									jw.print("<div class='col-xs-2'>Mother CR No.:"+ws.getString(1)+"</div>");
								else
									jw.print("<div class='col-xs-2'>CR No.:"+ws.getString(1)+"</div>");
								
								//jw.print("<div class='col-xs-2 ml-auto'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");								
								//jw.print("<div class='col-xs-1'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");
								if(ipdConfig.getUmidFlag().equals("1") && umidno != null && !umidno.equals(""))
								{
									jw.print("<div class='col-xs-2'>UMID No.:"+umidno+"</div>");
									jw.print("<div class='col-xs-1'><i class='fa fa-users' style='font-size: 26px;color:#4067c5; margin-left: 40px;' onclick='openDetailedPatInfo()' id='patInfo'></i></div>");
								}
								else
									jw.print("<div class='col-xs-2'><i class='fa fa-users' style='font-size: 26px;color:#4067c5; margin-left: 40px;' onclick='openDetailedPatInfo()' id='patInfo'></i></div>");								
							}
							else
							{
								//jw.print("<div class='row'><div class='col-xs-2'>"+genderClass+"</i>&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>CR No:&nbsp;&nbsp;"+ws.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;&nbsp;"+strPatientName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp; Age/Gender:&nbsp;&nbsp;"+strAgeAndSex+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>• &nbsp;&nbsp;&nbsp;&nbsp;Father&nbsp;&nbsp;"+ strFather+"/"+strHusbandName+" &nbsp;&nbsp;&nbsp;&nbsp;</div><div class='col-xs-2'>•&nbsp;&nbsp;&nbsp;&nbsp; CategoryName:&nbsp;&nbsp;"+strCategoryName+"</div>");
								jw.print("<div class='row justify-content-center tileHeader'>");								
								jw.print("<div class='col-xs-1'>"+genderClass+"</i></div>");
								if(ws.getString(22).equals("1"))//FTP
									jw.print("<div class='col-xs-1'><img src='/HISRegistration/ImageRendererServlet?crNo="+ws.getString(1)+"&isImageStoredFTP=1' class='customIcons'></div>");
								else if(ipdConfig.getUmidFlag().equals("1"))
									jw.print("<div class='col-xs-1'><img src='/HISRegistration/ImageRendererServlet?crNo="+ws.getString(1)+"&isImageStoredFTP=2' class='customIcons'></div>");
								else if(IpdConfigUtil.PAT_PHOTO_MONGO.equals("1"))
									jw.print("<div class='col-xs-1'><img src='/HISRegistration/ImageRendererServlet?crNo="+ws.getString(1)+"&isImageStoredFTP=0' class='customIcons'></div>");
								else
									jw.print("<div class='col-xs-1'></div>");
								
								jw.print("<div class='col-xs-2'>"+strPatientName+" </div>");
								jw.print("<div class='col-xs-4'><small>("+strAgeAndSex+"/"+strCategoryName+"/"+strMobile+")</small></div>");
								if(ipdConfig.getUmidFlag().equals("1") && umidno!=null && !umidno.equals(""))
								{
									if(isMotherCrFlag())
										jw.print("<div class='col-xs-2'>Mother CR No.:"+ws.getString(1)+"</div>");
									else
										jw.print("<div class='col-xs-2'>CR No.:"+ws.getString(1)+"</div>");
									jw.print("<div class='col-xs-2'> UMID No.:"+umidno+"</div>");
									
								}
								else
								{
									if(isMotherCrFlag())
										jw.print("<div class='col-xs-2'>Mother CR No.:"+ws.getString(1)+"</div>");
									else
										jw.print("<div class='col-xs-2'>CR No.:"+ws.getString(1)+"</div>");
								}
								//jw.print("<div class='col-xs-2 ml-auto'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");
								jw.print("<div class='col-xs-1'><i class='fas fa-flag text-danger' title='"+strMlcNo+"' style='cursor: pointer; cursor: hand'>MLC</i></div>");
								
								jw.print("<div class='col-xs-1'><i class='fa fa-users' title='Patient More Info' style='font-size: 26px;color:#4067c5; margin-left: 40px;' onclick='openDetailedPatInfo()' id='patInfo'></i></div>");								
							}
							//jw.print("<div class="row"><div class="col-sm-4"><label>House No.</label><input type="text" class="form-control form-control-sm" name="strHouseNo" value="" tabindex="2" maxlength="20"></div><div class="col-sm-4"><label><font color="red">*</font>Street/Mohallah</label><input type="text" class="form-control form-control-sm" name="strStreet" value="Fgfdg" tabindex="1" maxlength="60"></div><div class="col-sm-4"><label>Location</label><input type="text" class="form-control form-control-sm" name="strCityLocation" value="" tabindex="2" maxlength="60" onkeypress="return validateData(event,4);"></div></div>
							
							jw.print("</div>");
							//jw.print("</nav>");
							jw.print("</div>");
							
							
							
						/*
						 * jw.
						 * print("<div id='patSideListId' class='patSideList' style='display: none;'>");
						 * jw.print("<legend class='text-center totalPatHeader' style='color: #fff'>");
						 * jw.print("<i class='far fa-user-circle fa-lg'></i>");
						 * jw.print("&nbsp;&nbsp;&nbsp; Patient's Information </legend>");
						 * jw.print("<ul id='patOtherDtl'>");
						 * jw.print("<li style=' border: none;'>Registration Date:<label class='label'>"
						 * +strRegDt+"</label></li>"); jw.
						 * print("<li style=' border: none;'>Father / Spouse Name:<label class='label'>"
						 * +fatherHusbandName+"</label></li>");
						 * jw.print("<li style=' border: none;'>Address:<label class='label'>"
						 * +strAddress+"</label></li>");
						 * jw.print("<li style=' border: none;'>Emergency Contact:<label class='label'>"
						 * +strEmgContact+"</label></li>"); jw.
						 * print("<li style=' border: none;'>Borned in Hospital:<label class='label'>"
						 * +strBornInHosp+"</label></li>"); jw.print("</ul></div>");
						 */
							if(ipdConfig.getUmidFlag().equals("1"))
							{
								String ip=HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_IP");
								String port=HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_APPPORT");
								String srvcURL= "http://"+ip+":"+port+"/HISServices/service/Update/getUMIDJSON?crno="+ws.getString(1);
							
								String jsonUserlst = callWS(srvcURL);
								if(!jsonUserlst.contains("404") && !jsonUserlst.contains("Not Found") && !jsonUserlst.contains("Error"))
								{
									JSONArray object=new JSONArray(jsonUserlst);
									
									if(object.length()>0)
									{
										for (int i = 0; i < object.length(); i++) 
										{								
											JSONObject object2 =  object.getJSONObject(i);
											String gstr_json=object2.get("GSTR_JSON").toString();
											JSONObject 	object1=new JSONObject(gstr_json);
											String email_id = object1.get("email_id").toString();
											String age = object1.get("age").toString();
											String current_status = object1.get("current_status").toString();
											String validity= object1.get("validity").toString();
											String umid_no= object1.get("umid_no").toString();
											String name= object1.get("name").toString();
											String dept= object1.get("department").toString();
											String desig= object1.get("designation").toString();
											String ent= object1.get("level_of_entitilment").toString();
											String hndcp= object1.get("handicap_status").toString();
											String opd_eligibility= object1.get("opd_eligibility").toString();
											String ipd_eligibility= object1.get("ipd_eligibility").toString();
											String beneficiary_type= object1.get("beneficiary_type").toString();
											String custom_unit= object1.get("custom_unit").toString();
											String custom_unit_code= object1.get("custom_unit_code").toString();
											String custom_zone= object1.get("custom_zone").toString();
											String custom_zone_code= object1.get("custom_zone_code").toString();
											String pch_id= object1.get("pch_id").toString();
											String mobile_no= object1.get("mobile_no").toString();
											String pan_no= object1.get("pan_no").toString();
											String aadhaar_no= object1.get("aadhaar_no").toString();
											
											jw.print("<div id='patSideListId' class='patSideList' style='display: none;'>");
											jw.print("<legend class='text-center totalPatHeader' style='color: #fff'>");
											jw.print("<i class='far fa-user-circle fa-lg'></i>");
											jw.print("&nbsp;&nbsp;&nbsp; Patient's Information </legend>");
											jw.print("<ul id='patOtherDtl'>");
											jw.print("<li style=' border: none;'>Patient Name:<label class='label'>"+name+"</label></li>");
											jw.print("<li style=' border: none;'>Registration Date:<label class='label'>"+strRegDt+"</label></li>");
											jw.print("<li style=' border: none;'>Father/Spouse Name:<label class='label'>"+fatherHusbandName+"</label></li>");
											jw.print("<li style=' border: none;'>Address:<label class='label'>"+strAddress+"</label></li>");
											jw.print("<li style=' border: none;'>Emergency Contact:<label class='label'>"+strEmgContact+"</label></li>");
											jw.print("<li style=' border: none;'>Borned in Hospital:<label class='label'>"+strBornInHosp+"</label></li>");
											jw.print("<li style=' border: none;'>UMID:<label class='label'>"+umid_no+"</label></li>");
											jw.print("<li style=' border: none;'>PCH ID:<label class='label'>"+pch_id+"</label></li>");
											jw.print("<li style=' border: none;'>Mobile:<label class='label'>"+mobile_no+"</label></li>");
											jw.print("<li style=' border: none;'>PAN:<label class='label'>"+pan_no+"</label></li>");
											jw.print("<li style=' border: none;'>AADHAAR:<label class='label'>"+aadhaar_no+"</label></li>");
											jw.print("<li style=' border: none;'>Email Id:<label class='label'>"+email_id+"</label></li>");
											jw.print("<li style=' border: none;'>Validity:<label class='label'>"+validity+"</label></li>");
											jw.print("<li style=' border: none;'>Status:<label class='label'>"+current_status+"</label></li>");
											jw.print("<li style=' border: none;'>Department:<label class='label'>"+dept+"</label></li>");
											jw.print("<li style=' border: none;'>Designation:<label class='label'>"+desig+"</label></li>");
											jw.print("<li style=' border: none;'>Entitlement:<label class='label'>"+ent+"</label></li>");
											jw.print("<li style=' border: none;'>Handicapped:<label class='label'>"+hndcp+"</label></li>");
											jw.print("<li style=' border: none;'>OPD Eligibility:<label class='label'>"+opd_eligibility+"</label></li>");
											jw.print("<li style=' border: none;'>IPD Eligibilty:<label class='label'>"+ipd_eligibility+"</label></li>");
											jw.print("<li style=' border: none;'>Beneficiary:<label class='label'>"+beneficiary_type+"</label></li>");
											jw.print("<li style=' border: none;'>Unit:<label class='label'>"+custom_unit+"</label></li>");
											jw.print("<li style=' border: none;'>Zone:<label class='label'>"+custom_zone+"</label></li>");
											jw.print("<input type='hidden' name='custom_unit' value='"+custom_unit+"'>");
											jw.print("<input type='hidden' name='custom_unit_code' value='"+custom_unit_code+"'>");
											jw.print("<input type='hidden' name='custom_zone' value='"+custom_zone+"'>");
											jw.print("<input type='hidden' name='custom_zone_code' value='"+custom_zone_code+"'>");
											
											jw.print("</ul></div>");
										}
									}
									else
									{
										jw.print("<div id='patSideListId' class='patSideList' style='display: none;'>");
										jw.print("<legend class='text-center totalPatHeader' style='color: #fff'>");
										jw.print("<i class='far fa-user-circle fa-lg'></i>");
										jw.print("&nbsp;&nbsp;&nbsp; Patient's Information </legend>");
										jw.print("<ul id='patOtherDtl'>");
										jw.print("<li style=' border: none;'>Registration Date:<label class='label'>"+strRegDt+"</label></li>");
										jw.print("<li style=' border: none;'>Father/Spouse Name:<label class='label'>"+fatherHusbandName+"</label></li>");
										jw.print("<li style=' border: none;'>Address:<label class='label'>"+strAddress+"</label></li>");
										jw.print("<li style=' border: none;'>Emergency Contact:<label class='label'>"+strEmgContact+"</label></li>");
										jw.print("<li style=' border: none;'>Born in Hospital:<label class='label'>"+strBornInHosp+"</label></li>");
										jw.print("</ul></div>");
									}
								}
								else
								{
									jw.print("<div id='patSideListId' class='patSideList' style='display: none;'>");
									jw.print("<legend class='text-center totalPatHeader' style='color: #fff'>");
									jw.print("<i class='far fa-user-circle fa-lg'></i>");
									jw.print("&nbsp;&nbsp;&nbsp; Patient's Information </legend>");
									jw.print("<ul id='patOtherDtl'>");
									jw.print("<li style=' border: none;'>Registration Date:<label class='label'>"+strRegDt+"</label></li>");
									jw.print("<li style=' border: none;'>Father/Spouse Name:<label class='label'>"+fatherHusbandName+"</label></li>");
									jw.print("<li style=' border: none;'>Address:<label class='label'>"+strAddress+"</label></li>");
									jw.print("<li style=' border: none;'>Emergency Contact:<label class='label'>"+strEmgContact+"</label></li>");
									jw.print("<li style=' border: none;'>Born in Hospital:<label class='label'>"+strBornInHosp+"</label></li>");
									jw.print("</ul></div>");
								}							
							}
							else
							{
								jw.print("<div id='patSideListId' class='patSideList' style='display: none;'>");
								jw.print("<legend class='text-center totalPatHeader' style='color: #fff'>");
								jw.print("<i class='far fa-user-circle fa-lg'></i>");
								jw.print("&nbsp;&nbsp;&nbsp; Patient's Information </legend>");
								jw.print("<ul id='patOtherDtl'>");
								jw.print("<li style=' border: none;'>Registration Date:<label class='label'>"+strRegDt+"</label></li>");
								jw.print("<li style=' border: none;'>Father/Spouse Name:<label class='label'>"+fatherHusbandName+"</label></li>");
								jw.print("<li style=' border: none;'>Address:<label class='label'>"+strAddress+"</label></li>");
								jw.print("<li style=' border: none;'>Emergency Contact:<label class='label'>"+strEmgContact+"</label></li>");
								jw.print("<li style=' border: none;'>Borned in Hospital:<label class='label'>"+strBornInHosp+"</label></li>");
								jw.print("</ul></div>");
							}
							//String jsonUserlst = "{\"user_list\":[{\"mobile\":\"7698546344\",\"mail\":\"ldapuser1@aiims.in\",\"uid\":\"ldapuser1\",\"cn\":\"ldapuser1\"},{\"mobile\":\"7567894322\",\"mail\":\"ldapuser2@aiims.in\",\"uid\":\"ldapuser2\",\"cn\":\"ldapuser2\"},{\"mail\":\"ldapuser3@gmail.com\",\"mobile\":\"8976578932\",\"uid\":\"ldapuser3\",\"cn\":\"ldapuser3\"},{\"mail\":\"ldapuser4@gmail.com\",\"mobile\":\"9865456788\",\"uid\":\"ldapuser4\",\"cn\":\"ldapuser4\"}]}";
							
						/*
						 * JsonElement je = new Gson().fromJson(jsonUserlst, JsonElement.class);
						 * JsonObject jo = je.getAsJsonObject(); je = jo.get("user_list");
						 */
							
							 /*jw.print("<div class='container' style='line-height: 0.5;'>\n");
							 jw.print("<div class='row justify-content-center'>\n");
							 jw.print("<div class='col-md-12'>\n");
							 jw.print("<div class='card'>\n");
							 jw.print("<article class='card-body'>\n");
							 jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Name:</label>&nbsp;&nbsp;"+strPatientName+"");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							


							
						//}
						/*jw.print("</tr>");
						jw.print("<tr><td align='Right' class='LABEL'>Patient Category</td>");
						jw.print("<td>");
						jw.print(strCategoryName);
						jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'></td>");
						jw.print("<td align='Right'  class='LABEL'>Age/Gender</td>");
						jw.print("<td>");
						jw.print(strAgeAndSex);
						jw.print("</td></tr>");
						jw.print("<tr><td align='Right'  class='LABEL'>Father Name</td>");
						jw.print("<td>");
						jw.print(strFather);
						jw.print("</td>");
						jw.print("<td align='Right'  class='LABEL'>Spouse Name</td>");
						jw.print("<td>");
						jw.print(strHusbandName);
						jw.print("</td></tr>");*/
						
						 /*jw.print("<div class='form-row'>");
						 jw.print("<div class='col form-group'>");
						 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<input type='hidden' name='strCategoryCode' value='"+strCategoryCode+"'><label>Patient Category:</label>&nbsp;&nbsp;"+strCategoryName+"");
		                 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Age/Gender:</label>&nbsp;&nbsp;"+strAgeAndSex+"");
						 jw.print("</div>");
		                 jw.print("</div>");
		                 
		                 jw.print("<div class='form-row'>");
						 jw.print("<div class='col form-group'>");
						 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Father Name:</label>&nbsp;&nbsp;"+strFather+"");
		                 jw.print("</div>");
		                 jw.print("<div class='col form-group'>");
		                 jw.print("<label>Spouse Name:</label>&nbsp;&nbsp;"+strHusbandName+"");
						 jw.print("</div>");
		                 jw.print("</div>");*/
		                 
						
						
						
						if(!(ws.getString(13).equals("0")))  //for BPL
						{
							isBPL="1";
						/*	jw.print("<tr><td align='Right'><font color='red' weight='strong'>Is BPL</font></td>");
							jw.print("<td>Yes</td> ");	
							jw.print("<td align='Right'><font color='red' weight='strong'>BPL No.</font></td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(13)+"</font></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is BPL:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>BPL No:</label>nbsp;&nbsp&;"+ws.getString(13)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
			                 
						}
						else
						{
							/*jw.print("<tr><td align='Right' class='LABEL'>Is BPL</td>");
							jw.print("<td>No</td><td></td><td></td>");
							jw.print("</tr>");*/
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is BPL:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						
						if(!(ws.getString(9).equals("0")))  //for MLC
						{
							/*isMLC="1";
							jw.print("<tr><td align='Right'>Is MLC</td>");
							jw.print("<td>Yes</td> ");
							
							jw.print("<td align='Right'>MLC No.</td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(9)+"</font></td>");
							jw.print("</tr>");*/
							
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is MLC:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>MLC No:</label>nbsp;&nbsp&;"+ws.getString(9)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}else
						{
							/*jw.print("<tr><td align='Right' class='LABEL'>Is MLC</td>");
							jw.print("<td>No</td><td></td><td></td> ");
							jw.print("</tr>");*/
							
							 /*jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is MLC:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						
						if(!(ws.getString(14).equals("0")))  //for Refer
						{
							/*isRefer="1";
							jw.print("<tr><td align='Right' class='LABEL'>Is Refered</td>");
							jw.print("<td >Yes</td> ");
							
							jw.print("<td align='Right'>Refered No.</td>");
							jw.print("<td> ");
							jw.print("<font color='red'>"+ws.getString(14)+"</font></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is Refered:</label>&nbsp;&nbsp;Yes");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Refered No:</label>nbsp;&nbsp&;"+ws.getString(14)+"");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}else
						{/*
							jw.print("<tr><td align='Right' class='LABEL'>Is Refered</td>");
							jw.print("<td>No</td> <td></td> <td></td>");
							jw.print("</tr>");*/
							
							/* jw.print("<div class='form-row'>");
							 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
			                 jw.print("<label>Is Refered:</label>&nbsp;&nbsp;No");
			                 jw.print("</div>");
			                 jw.print("<div class='col form-group'>");
							 jw.print("</div>");
			                 jw.print("</div>");*/
							
						}
						if(isAddress())
						{
							/*jw.print("<tr>");
							jw.print("<td width='25%' class='LABEL'>Address</td>");
							jw.print("<td colspan='3' class='CONTROL'>");
							jw.print(strAddress);
							jw.print("</td></tr>");*/
						}
						jw.print("<input type='hidden' name='strIsBPL' value='"+isBPL+"'>");
						jw.print("<input type='hidden' name='strBPLNo' value='"+ws.getString(13)+"'>");
						jw.print("<input type='hidden' name='strIsMLC' value='"+isMLC+"'>");
						jw.print("<input type='hidden' name='strMLCNo' value='"+ws.getString(9)+"'>");
						jw.print("<input type='hidden' name='strIsRefer' value='"+isRefer+"'>");
						jw.print("<input type='hidden' name='strReferNo' value='"+ws.getString(14)+"'>");
						jw.print("<input type='hidden' name='strIsNewBorn' value='"+isNewBorn+"'>");
						jw.print("<input type='hidden' name='strMotherDtl' value='"+strMotherDtl+"'>");
						jw.print("<input type='hidden' name='strEmailId' value='"+strEmailId+"'>");
						jw.print("<input type='hidden' name='strpack' value='"+ws.getString(16)+"'>");
						
						//jw.print("</tbody>");

						//jw.print("</table>");
						
						
						 /*jw.print("</article>\n");*/
						/* jw.print("</div>\n");
						 jw.print("</div>\n");
						 jw.print("</div>\n");
						 jw.print("</div>\n");*/

					}
				} 
				catch (Exception e) 
				{
					new Exception(e.getMessage()); 
				}
			}
			else
			{
			}
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			voObj.setStrMsgString("Error while getting patient detail");
			new HisException("ADT","PatientDetail Tag.doStartTag() -->",e.getMessage());
		}
		finally 
		{
			try 
			{
				jw.print("<input type='hidden' name='strGlbErrMsgTLD' value='"+voObj.getStrMsgString()+"'>");
				ws.close();
			}
			catch(Exception e) {}
			ws = null;
			voObj = null;
		}
		return EVAL_BODY_INCLUDE;
	}

	public Tag getParent() {
		return null;
	}

	public void release() {
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag tag) {
	}

    public WebRowSet getPatientDtlsWs(IpdVO voObj)throws Exception{
		
		WebRowSet ws = null;
		IpdBO boObj = new IpdBO();
		if(!this.getCrNo().equals(""))
		{
			voObj.setStrValue1(this.getCrNo());
			boObj.getPatientDetails(voObj);
		}
		else
		{
			ws = null;
		}
		ws = voObj.getGblWs1();
		return ws;
}
public static String callWS(String srvcURL)
{		
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(srvcURL);
		Response response = target.request().get();
		
        if(response.getStatus() != 200)
        {
            System.err.println("Unable to connect to the server");
        }
        String output = response.readEntity(String.class);
		return output;
	}
}
