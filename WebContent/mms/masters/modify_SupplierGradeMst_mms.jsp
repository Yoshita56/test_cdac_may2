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
<title>Supplier Grade Master</title>
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
     
            var hisValidator = new HISValidator("SupplierGradeMstBean");
            hisValidator.addValidation("strGradeName", "req", "Supplier Grade Name is a Mandatory Field" );
            hisValidator.addValidation("strGradeName", "maxlen=50", "Supplier Grade Name should have less than or equal to 50 Characters" );
            hisValidator.addValidation("strGradeCriteria", "maxlen=250", "Supplier Grade Criteria should have less than or equal to 250 Characters" );
       		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		    // hisValidator.addValidation("strEffectiveFrom", "dtgtet=${SupplierGradeMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
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
<body onLoad="document.forms[0].strGradeName.focus()">
<html:form name="SupplierGradeMstBean" action="/masters/SupplierGradeMstCNT" type="mms.masters.controller.fb.SupplierGradeMstFB">
 	<center>
 	<div class="errMsg"><bean:write name="SupplierGradeMstBean" property="strErrorMsg"/></div>
	<div class="normalMsg"><bean:write name="SupplierGradeMstBean" property="strMsg"/></div>
	<div class="warningMsg"><bean:write name="SupplierGradeMstBean" property="strWarning"/></div>
	

	<tag:tab tabLabel="Supplier Grade Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
               </tag:tab>
	</center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Supplier Grade Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Supplier Grade Name
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class='txtFldBig' name="strGradeName" value ="${SupplierGradeMstBean.strGradeName}" maxlength="50" onkeypress="return validateData(event,4);">
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Grade Criteria
			</td>
			<td width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strGradeCriteria" rows="2"><bean:write name="SupplierGradeMstBean" property="strGradeCriteria"/></textarea>
              </div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			Remarks
			</td>
			<td width="50%" class="CONTROL">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"><bean:write name="SupplierGradeMstBean" property="strRemarks"/></textarea>
              </div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Effective From
			</td>
			<td class ="CONTROL"><bean:write name="SupplierGradeMstBean" property="strEffectiveFrom"></bean:write></td>
		</tr>
		<tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="SupplierGradeMstBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="SupplierGradeMstBean" property="strIsValid" value="2">Inactive</html:radio>
    
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
	<input type="hidden" name="chk" value="${SupplierGradeMstBean.strChk }">
<input type="hidden" name="hmode"/>
<input type="hidden" name="strEffectiveFrom" value ="${SupplierGradeMstBean.strEffectiveFrom}">
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>