<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=utf-8>
<title>Committee Type Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">

function validate1(){   
     
            var hisValidator = new HISValidator("CommitteeTypeMstBean");
            hisValidator.addValidation("strCommitteeTypeName", "req", "Committee Type Name is a Mandatory Field" );
            hisValidator.addValidation("strCommitteeTypeName", "maxlen=100", "Committee Type Name should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strCommitteePurpose", "req", "Committee Type Purpose is a Mandatory Field" );
            hisValidator.addValidation("strCommitteePurpose", "maxlen=250", "Committee Type Purpose should have less than or equal to 250 Characters" );
       		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		    //hisValidator.addValidation("strEffectiveFrom", "dtgtet=${CommitteeTypeMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
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
<body onLoad="document.forms[0].strCommitteeTypeName.focus()">
<html:form name="CommitteeTypeMstBean" action="/masters/CommitteeTypeMstCNT" type="mms.masters.controller.fb.CommitteeTypeMstFB">
 	
 	<div class="errMsg"><bean:write name="CommitteeTypeMstBean" property="strErrorMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="CommitteeTypeMstBean" property="strMsg"/></div>
	<div class="warningMsg"><bean:write name="CommitteeTypeMstBean" property="strWarning"/></div>
	

	<tag:tab tabLabel="Committee Type Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>
	

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Committee Type Master&gt;&gt; Add</td>
		</tr>
		
	
		
		
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Committee Type Name
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class='txtFldBig' name="strCommitteeTypeName" value ="" maxlength="100" onkeypress="return validateData(event,18);">
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Committee Type Purpose
			</td>
			<td width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strCommitteePurpose" rows="2"></textarea>
              </div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			Remarks
			</td>
			<td width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"></textarea>
              </div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Effective From
			</td>
			<td class ="CONTROL"><date:date name="strEffectiveFrom" value="${CommitteeTypeMstBean.strCtDate}"></date:date></td>
		</tr>
		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center"cellpadding="1px"
         cellspacing="1px">
		<tr>
			
			<td align="center">
			<br>
			<!-- <img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/> -->
			<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
			<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
			<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			
			</td>
		</tr>
	</table>
	
	<input type="hidden" name="comboValue" value="${CommitteeTypeMstBean.strComboValue}"/>
<input type="hidden" name="strCtDate" value="${CommitteeTypeMstBean.strCtDate}"/>
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>