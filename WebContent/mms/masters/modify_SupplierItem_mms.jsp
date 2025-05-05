<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset="utf-8">
<title>Supplier Item Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("SupplierItemBean");
              
			
         
            hisValidator.addValidation("strItemId", "dontselect=0","Please select an Item Name " );
            // hisValidator.addValidation("strItemBrandId", "dontselect=0","Please select an Brand Name " );
       
            hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
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
<body onLoad="document.forms[0].strItemId.focus();">
<html:form name="SupplierItemBean" action="/masters/SupplierItemMstCNT"
	type="mms.masters.controller.fb.SupplierItemMstFB">
<center>
	<div id="errMsg" class="errMsg"><bean:write name="SupplierItemBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="SupplierItemBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="SupplierItemBean"
		property="strMsg" /></div>


	<tag:tab tabLabel="Supplier Item Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="2">Supplier Item Master&gt;&gt; Modify</td>
		</tr>

		<tr>
			<td class="LABEL" width="50%">Supplier Name</td>
			<td width="50%" class="CONTROL"><bean:write name="SupplierItemBean"
				property="strSupplierName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="50%">Item Category</td>
			<td width="50%" class="CONTROL"><bean:write name="SupplierItemBean"
				property="strItemCategoryName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL">Group Name</td>
			<td width="50%" class="CONTROL"><bean:write name="SupplierItemBean"
				property="strGroupName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL">Sub Group Name</td>
			<td width="50%" class="CONTROL"><bean:write name="SupplierItemBean"
				property="strSubGroupName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL">Generic Item Name</td>
			<td width="50%" class="CONTROL"><bean:write name="SupplierItemBean"
				property="strItemName" filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL">Item Name</td>
			<td width="50%" class="CONTROL"><bean:write name="SupplierItemBean"
				property="strItemBrandName" filter="false" /></td>
		</tr>
	
			 <tr >
    <td class ="LABEL" width ="50%"><div align="right"><font color="red">*</font> Effective From</div></td>
    <td class ="CONTROL"><bean:write name="SupplierItemBean" property="strEffectiveFrom" /></td>
  </tr>
  
  
  
  
  <tr >
    <td width ="50%" class ="LABEL"valign="top">Remarks if Any </td>
    <td width ="50%" class ="CONTROL"><textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"><bean:write name="SupplierItemBean" property="strRemarks"/></textarea></td>
  </tr>
   <tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="SupplierItemBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="SupplierItemBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>
	<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

	</table>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick=" return validate1();" /> 
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" 
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="chk" value="${SupplierItemBean.strChk1 }">
<input type="hidden" name="strGroupId" value="${SupplierItemBean.strGroupId }">
<input type="hidden" name="strCategoryNo" value="${SupplierItemBean.strCategoryNo }">


<input type="hidden" name="strSupplierId"
		value="${SupplierItemBean.combo[0]}">
		
	<input type="hidden" name="strSupplierStatus"
		value="${SupplierItemBean.strSupplierStatus}"> 
		
	<input type="hidden" name="comboValue"
		value="${SupplierItemBean.strComboValue}">
	<input type="hidden" name="strEffectiveFrom" value ="${SupplierItemBean.strEffectiveFrom}"/>
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
