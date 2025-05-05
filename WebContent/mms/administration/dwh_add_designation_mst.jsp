<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Designation Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">

function validate1(){   
     
            var hisValidator = new HISValidator("designationMst");
            hisValidator.addValidation("strDesignationName", "req", "Designation Name is a Mandatory Field" );
            hisValidator.addValidation("strDesignationName", "maxlen=25", "Designation Name should have less than or equal to 25 Characters" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		    hisValidator.addValidation("strEffectiveFrom", "dtgtet=${designationMst.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate(); 

           if(retVal){
                 	   document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
           }else{
            return false;
          }
}


</script>
</head>
<body onLoad="document.forms[0].strDesignationName.focus()">
<html:form name="designationMst" action="/masters/DesignationMstCNT" type="mms.masters.controller.fb.DesignationMstFB">
 	<center>
 	<div class="errMsg"><bean:write name="designationMst" property="strErrorMsg"/></div>
	<div class="normalMsg"><bean:write name="designationMst" property="strMsg"/></div>
	<div class="warningMsg"><bean:write name="designationMst" property="strWarning"/></div>
	

	<tag:tab tabLabel="Designation Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
               </tag:tab>
	</center>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Designation Master&gt;&gt; Add</td>
		</tr>
						
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Designation Name
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class='txtFldBig' name="strDesignationName" value ="" maxlength="25" onkeypress="return validateData(event,4);">
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			Remarks
			</td>
			<td width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2" maxlength="100" ></textarea>
              </div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Effective From
			</td>
			<td class ="CONTROL"><date:date name="strEffectiveFrom" value="${designationMst.strCtDate}"></date:date></td>
		</tr>
		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>
		
<input type="hidden" name="strCtDate" value="${designationMst.strCtDate}"/>
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>