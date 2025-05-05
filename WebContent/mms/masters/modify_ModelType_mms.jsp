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
<title>Item Type Master Modify Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language ="javaScript">
	function validate1(){   
       var hisValidator = new HISValidator("ModelTypeBean");
         //hisValidator.addValidation("strItemTypeName", "req", "Item Type Name is a Mandatory Field" );
         //hisValidator.addValidation("strShortName", "req", "Short Name is a Mandatory Field" );
         // hisValidator.addValidation("strEffectiveFrom", "dtgtet=${ModelTypeBean.strCtDate}" , "Effective From Date should be Greater than or Equal to Current Date");
		 //hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
     	  var retVal = hisValidator.validate(); 
          if(retVal)
          {
                 	   document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
          }else{
             return false;
          }
    }
</script>

</head>
<!-- onload="document.forms[0].strGroupName.focus();" -->
<body>
<html:form name="ModelTypeBean" action="/masters/ModelTypeMstCNT" type="mms.masters.controller.fb.ModelTypeMstFB">
  
<div class="errMsg"><bean:write name="ModelTypeBean" property="strErr"/></div>
<div class="warningMsg"><bean:write name="ModelTypeBean" property="strWarning"/></div>
<div id="normalMsg" class="normalMsg"><bean:write name="ModelTypeBean" property="strMsg"/></div>
	
<%-- <tag:tab tabLabel="Model Type Master" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab> --%>
			
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">Model Type Master&gt;&gt;Modify</td>
  </tr>  
          
  <tr>
    <td class="LABEL">Item Category Name</td>
    <td width="50%" class ="CONTROL">
    	<bean:write name="ModelTypeBean" property="strItemCategoryName" filter="false"/>
    </td>
  </tr>
                
   <tr>
    <td class="LABEL"><font color="red">*</font>Group Name</td>
    <td width="50%" class ="CONTROL">
    	<select name="strGroupNameId" class="comboNormal" >
			<bean:write name="ModelTypeBean" property="strGroupCmb" filter="false"/>
		</select>
    </td>
  </tr>
   
   <tr>
    <td class="LABEL"><font color="red">*</font>Item Name</td>
    <td width="50%" class ="CONTROL">
		<select name="strItemNameId" class="comboNormal" >
			<bean:write name="ModelTypeBean" property="strItemCmb" filter="false"/>
		</select>
    </td>
   </tr>
   
   <tr>
    <td class="LABEL"><font color="red">*</font>Model No</td>
    <td width="50%" class ="CONTROL">
   		<input type="text" name="strModelNo" class="txtFldNormal" value ="" maxlength="10" onkeypress="return validateData(event,9);"> 
   	</td>
  </tr>
   
   <tr>
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
	   <html:radio name="ModelTypeBean" property="strIsValid" value="1">Active</html:radio>
	   <html:radio name="ModelTypeBean" property="strIsValid" value="2">Inactive</html:radio>
   	</td>
   </tr>
     
    <tr class="FOOTER"> 
    <td colspan="2" ><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>																														
	
    <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td align="right">
			<!-- <img style="cursor: pointer; " title="Save Record" 
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" /> -->
			<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
			</td>
			<td align="left">
			<!-- <img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png"  title="Cancel Process" onClick="cancel('LIST');" > -->
				
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>

	  <%--   <input type="hidden" name="chk" value="${ModelTypeBean.strChk1 }">
	    <input type="hidden" name="comboValue" value="${ModelTypeBean.strItemCategoryName}">
	   	<input type="hidden" name="hmode">
	 	<input type="hidden" name="strEffectiveFrom" value ="${ModelTypeBean.strEffectiveFrom}" /> --%>
	 <cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>	
			
			