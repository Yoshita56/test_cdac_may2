<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset="utf-8">
<title>Authorization Master</title>
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
     
        var hisValidator = new HISValidator("authorizationBean");
        hisValidator.addValidation("strCostForm","req","Cost From is a Mandatory Field");
        hisValidator.addValidation("strCost","numgt=document.forms[0].strCostForm.value","Cost To should be greater than Cost From");
        hisValidator.addValidation("strEffectiveFrom","req","Effective Date is a mandatory field");
	 //    hisValidator.addValidation("strEffectiveFrom", "dtgtet=${authorizationBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");         
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
<body>
<html:form name="authorizationBean" action="/masters/AuthorizationMstCNT" type="mms.masters.controller.fb.AuthorizationMstFB">
	<div class="errMsg"><bean:write name="authorizationBean" property="strErr" /></div>
	<div class="warningMsg"><bean:write name="authorizationBean" property="strWarning" /></div>
	<div class="normalMsg"><bean:write name="authorizationBean" property="strMsg" /></div>

	<tag:tab tabLabel="Modify Authorization"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
               </tag:tab>
			

	<table class="TABLEWIDTH" border="0" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Authorization Master&gt;&gt;Modify</td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Store Type Name</td>
			<td width="50%" class="CONTROL">
				<bean:write name="authorizationBean" property="strStoreTypeCombo"
					filter="false" />
			</td>
		</tr>
		<tr>
		<td class="LABEL"><font color="red">*</font>User Name</td>
			<td width="50%" class="CONTROL">
			<bean:write name="authorizationBean" property="strUserName"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Authorization Type</td>
			<td width="50%" class="CONTROL"><bean:write name="authorizationBean" property="strAuthorizationType"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Authorization Level</td>
			<td width="50%" class="CONTROL"><bean:write name="authorizationBean" property="strAuthorizationLevel"/>
			</td>
		</tr>
		
		<tr>
			<td class="LABEL"><font color="red">*</font>Cost Form</td>
			<td class="CONTROL"><input type="text" name="strCostForm" class="txtFldBig" 
			value="${authorizationBean.strCostForm}" maxlength="14" 
			onkeypress="return validateData(event,7);"></td>
		</tr>
		
		<tr>
			<td class="LABEL">Cost To</td>
			<td class="CONTROL"><input type="text" name="strCost" class="txtFldBig" 
			value="${authorizationBean.strCost}" maxlength="14" 
			onkeypress="return validateData(event,7);"></td>
		</tr>
		
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Effective From
			</td>
			<td class ="CONTROL">
			<date:date name="strEffectiveFrom" value ="${authorizationBean.strEffectiveFrom}"></date:date></td>
		</tr>
		<tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="authorizationBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="authorizationBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" title="Save Record"/> 
			
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" title="Cancel Process"/>
			
			</td>
		</tr>
	</table>
	<input type="hidden" name="strStoreTypeId" value="${authorizationBean.combo[0]}"/>
	<input type="hidden" name="comboValue" value="${authorizationBean.strStoreTypeCombo}"/>
	<input type="hidden" name="chk" value="${authorizationBean.strChk }">
	
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>