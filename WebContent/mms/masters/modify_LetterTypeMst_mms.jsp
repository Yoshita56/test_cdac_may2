<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset="utf-8">
<title>Letter Type Master</title>
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
     
            var hisValidator = new HISValidator("LetterTypeMstBean");
            hisValidator.addValidation("strLetterTypeName", "req", "Letter Type Name is a Mandatory Field" );
            hisValidator.addValidation("strLetterTypeName", "maxlen=100", "Letter Type Name should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		    // hisValidator.addValidation("strEffectiveFrom", "dtgtet=${LetterTypeMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate(); 
            if(retVal){
                 	   document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
            }else{
               return false;
             }
}


</script>
</head>
<body onLoad="document.forms[0].strLetterTypeName.focus()">
<html:form name="LetterTypeMstBean" action="/masters/LetterTypeMstCNT" type="mms.masters.controller.fb.LetterTypeMstFB">
 	
 	<div class="errMsg"><bean:write name="LetterTypeMstBean" property="strErrorMsg"/></div>
	<div class="normalMsg"><bean:write name="LetterTypeMstBean" property="strMsg"/></div>
	<div class="warningMsg"><bean:write name="LetterTypeMstBean" property="strWarning"/></div>
	

	<tag:tab tabLabel="Letter Type Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
               </tag:tab>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Letter Type Master&gt;&gt; Add</td>
		</tr>
		
		<tr>
			<td width="50%" class="LABEL">Store Type Name</td>
			<td width="50%" class="CONTROL">
			<bean:write name="LetterTypeMstBean" property="strStoreTypeName" filter="false"/>
		</tr>
		
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Letter Type Name
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class='txtFldBig' name="strLetterTypeName" value ="${LetterTypeMstBean.strLetterTypeName}" maxlength="100" onkeypress="return validateData(event,4);">
			</td>
		</tr>
		
		<tr>
			<td width="50%" class="LABEL">
			Remarks
			</td>
			<td width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"><bean:write name="LetterTypeMstBean" property="strRemarks"/></textarea>
              </div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Effective From
			</td>
			<td class ="CONTROL">
			<bean:write name="LetterTypeMstBean" property="strEffectiveFrom" /></td>
		</tr>
		<tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="LetterTypeMstBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="LetterTypeMstBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
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
			
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>
	
	<input type="hidden" name="strStoreTypeId" value="${LetterTypeMstBean.combo[0]}"/>
	<input type="hidden" name="strStoreTypeName" value="${LetterTypeMstBean.strStoreTypeName}"/>
	<input type="hidden" name="chk" value="${LetterTypeMstBean.strChk }">
	<input type="hidden" name="strEffectiveFrom" value ="${LetterTypeMstBean.strEffectiveFrom}">
	<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>