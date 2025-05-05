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
<title>Process Letter Type Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Item Sets Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language ="javaScript">

  
     
function validate1()
{	
	    var hisValidator = new HISValidator("sparepartBean");	
 	    hisValidator.addValidation("strEffectiveFrom ", "date","Effective From is a mandatory field");     
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
         
	    var retVal = hisValidator.validate(); 
	 	hisValidator.clearAllValidations();	    
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

<body >
<html:form action="/masters/SparePartsMstCNT.cnt"  name="sparepartBean" type="mms.masters.controller.fb.SparePartsMstFB" method="post">

    <div class="errMsg" id="errMsg" ><bean:write name="sparepartBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="sparepartBean" property="strWarning"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="sparepartBean" property="strMsg"/></div>
<tag:tab tabLabel="Spare Parts"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">   
	   <tr class="HEADER">
			<td colspan="2">Spare Parts&gt;&gt;Modify</td>
		</tr>
		<tr>
			<td colspan="1" width="50%" class="LABEL">Item Category Name</td>
			<td colspan="1" width="50%" class="CONTROL">
			<bean:write name="sparepartBean" property="strItemCatgName" filter="false"/>
		</tr>
		
		<tr>
			<td colspan="1" width="50%" class="LABEL">
			Item Name
			</td>
			<td colspan="1" width="50%" class="CONTROL">
  			<bean:write name="sparepartBean" property="strItemName" filter="false"/>
   			</td>
		</tr>
		
		<tr>
			<td colspan="1" width="50%" class="LABEL">
			Spare Part Category Name
			</td>
			<td colspan="1" width="50%" class="CONTROL">
  			<bean:write name="sparepartBean" property="strSparePartCategoryName" filter="false"/>
   			</td>
		</tr>
		<tr>
			<td colspan="1" width="50%" class="LABEL">
			Spare Part Item Name
			</td>
			<td colspan="1" width="50%" class="CONTROL">
  			<bean:write name="sparepartBean" property="strSparePartItemName" filter="false"/>
   			</td>
		</tr>
		<tr>
					<td width="50%" class="LABEL">
					<font color="red">*</font>Effective From</td>
					<td class ="CONTROL"><date:date name="strEffectiveFrom" value="${sparepartBean.strEffectiveFrom}"></date:date></td>
				</tr> 
				<tr>
					<td width="50%" class="LABEL">Remarks</td>
					<td width="50%" class="CONTROL">
			  		<div align="left">
        				<textarea name="strRemarks" rows="2"><bean:write name="sparepartBean" property="strRemarks"/></textarea>
    	 			</div></td>
			  </tr>
			  <tr >
           <td width ="45%" class ="LABEL">Record Status</td>
           <td width ="45%" class ="CONTROL" >
           <html:radio name="sparepartBean" property="strIsValid" value="1">Active</html:radio>
           <html:radio name="sparepartBean" property="strIsValid" value="2">Inactive</html:radio></td>
    	</tr>
		</table>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center">
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" /> 
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="strItemCatgNo" value="${sparepartBean.combo[0]}"/>
	<input type="hidden" name="strItemCatgName" value="${sparepartBean.strItemCatgName}"/>
	<input type="hidden" name="strItemId" value="${sparepartBean.combo[1]}"/>
	<input type="hidden" name="strItemName" value="${sparepartBean.strItemName}"/>
	<input type="hidden" name="strCtDate" value="${sparepartBean.strCtDate}"/>
	<input type="hidden" name="comboValue" value="${sparepartBean.strComboValues}"/>
	<input type="hidden" name="chk" value="${sparepartBean.strChk1}"/>
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>