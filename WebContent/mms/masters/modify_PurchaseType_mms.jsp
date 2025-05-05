<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<html>
<head>
<meta charset="utf-8">
<title>Purchase Type Master Modify Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">
function validate1(){   
     
      var hisValidator = new HISValidator("PurchaseTypeBean");
 
 
 			hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" );  
 			hisValidator.addValidation("strPurchaseTypeName", "req", "Purchase Type Name is a Mandatory Field");
            hisValidator.addValidation("strPurchaseTypeLimit", "req", "Purchase Type Limit is a Mandatory Field");      
       		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
        
            var retVal = hisValidator.validate(); 

          if(retVal)
          {
                 	   document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
           }
           else
           {
             return false;
           }
    }

</script>


</head>

<body onLoad="document.forms[0].strPurchaseTypeName.focus()">
<html:form name="PurchaseTypeBean" action="/masters/PurchaseTypeMstCNT" type="mms.masters.controller.fb.PurchaseTypeMstFB">
 	<center>
 	<div class="errMsg"><bean:write name="PurchaseTypeBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="PurchaseTypeBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="PurchaseTypeBean" property="strMsg"/></div>
<tag:tab tabLabel="Purchase Type Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">Purchase Type Master&gt;&gt;Modify</td>
  </tr>        
    <tr>
			<td class="LABEL">Store Type Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="PurchaseTypeBean" property="strStoreTypeName" filter="false" />

			</td>

		</tr>      
   <tr >
    <td class="LABEL"><font color="red">*</font>Purchase Type Name</td>
    <td width="50%" class ="CONTROL"><input type="text" name="strPurchaseTypeName" class='txtFldMax' value ="${PurchaseTypeBean.strPurchaseTypeName}"  onkeypress="return validateData(event,9);"> </td>
   </tr>

  <tr >
    <td class="LABEL"><font color="red">*</font>Purchase Type Limit</td>
    <td width="50%" class ="CONTROL"><input type="text" class='txtFldNormal' name="strPurchaseTypeLimit" value ="${PurchaseTypeBean.strPurchaseTypeLimit}" maxlength="8" onkeypress="return validateData(event,5);"> </td>
  </tr>
   
  <tr >
    <td class ="LABEL" width ="50%"><font color="red">*</font>Effective From</td>
    <td class ="CONTROL"><dateTag:date name="strEffectiveFrom" value ="${PurchaseTypeBean.strEffectiveFrom}"></dateTag:date></td>
  </tr>
    
    <tr>
      <td class="LABEL"><div align="right">Remarks </div></td>
      <td class="CONTROL">
	  <div align="left">
        <textarea name="strRemarks" rows="2"><bean:write name="PurchaseTypeBean" property="strRemarks"/></textarea>
      </div></td>
    </tr>
    
    
    <tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="PurchaseTypeBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="PurchaseTypeBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>
    <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>																														
<table border="0" class="TABLEWIDTH" align="center" > 
		<tr>

			<td align="right">
			<img style="cursor: pointer; " title="Save Record" 
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
			
			</td>
			<td align="left">
			<img style="cursor: pointer; " title="Cancel Process"  src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" >

			</td>
		</tr>
	</table>

	<input type="hidden" name="chk" value="${PurchaseTypeBean.strChk1}">
	   <input type="hidden"
		name="comboValue" value="${PurchaseTypeBean.strStoreTypeName}">
	   	<input type="hidden" name="hmode">
	 
	 <cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			