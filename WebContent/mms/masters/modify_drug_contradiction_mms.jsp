<%-- 
author 				: Niharika Srivastava
Date of Creation 	: 25-08-10
Process 			: Drug Contradiction Master
Module 				: MMS
TL 					: Mr. Ajay Kumar Gupta
Description			: Modify Page for Drug Contradiction Master   
 --%>
 
 
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
<title>Drug Contradiction Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("DrugContradictionBean");
              
			
         
            hisValidator.addValidation("strItemId", "dontselect=0","Please select an Drug Name " );
            hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			var retVal = hisValidator.validate(); 
    	
    	
          if(retVal){
          			var count = selectListRecords("strRightItemIds");
        			 if(count==0)
        			 {
        			 alert("Please select an Drug From Left List");
        			 return false;
        			 }
          				 document.forms[0].hmode.value = "UPDATE";
                         document.forms[0].submit();
                	}else{
					return false;
					 }
   			 }
   			 
function searchInList()
{ 

	var valObj = document.forms[0].searchVal;

	if(valObj.value.length == 0 ){
	
		alert("Please Enter a Value to Search from List");
		valObj.focus();
		return false;
	}
	
	searchInListBox("strLeftItemIds",document.forms[0].searchVal.value);  
}

function leftListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftItemIds");
	shiftToRight("strLeftItemIds","strRightItemIds",1);
}
	
</script>

</head>
<body>
<html:form name="DrugContradictionBean"
	action="/masters/DrugContradictionMstCNT"
	type="mms.masters.controller.fb.DrugContradictionMstFB">
	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="DrugContradictionBean" property="strErr" /></div>
	<div class="warningMsg"><bean:write name="DrugContradictionBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="DrugContradictionBean" property="strMsg" /></div>


	<tag:tab tabLabel="Drug Contradiction Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="HEADER">
			<td colspan="2">Drug Contradiction Master &gt;&gt; Modify</td>
		</tr>

		<tr>
			<td class="LABEL">Drug Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="DrugContradictionBean" property="strDrugName" filter="false" /></td>

		</tr>
		<tr>
			<td colspan="4" class="TITLE"><font color="red">* </font>Contradicted
			Drugs</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td colspan="1" class="LABEL">
			<!--<div align="center"><input type="text" name="searchVal"
				class="txtFldNormal" /> <img style="cursor: pointer;"
				src="../../hisglobal/images/btn-search.png"
				onclick='return searchInList();' title="Search Item"></div>-->
				
			<div align="center" id="saveId">
			<input type="text" name="searchVal" class="txtFldNormal" />					 
					 	<a href="#" class="button" onclick="return searchInList()"><span class="search">Search</span></a>
				</div>
			</td>
			<td colspan="6" class="LABEL"></td>
		</tr>
		<tr>
			<td class="CONTROL" colspan="2">

			<div id="LeftItemIds" align="right"><select
				name="strLeftItemIds" size="8" multiple style="width: 280px">
				<bean:write name="DrugContradictionBean" property="strLeftItemList"
					filter="false" />
			</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">

			<center><img src="../../hisglobal/images/forward3.gif"
				width="35" height="31" onclick="leftListTransfer();"></center>

			<center><img src="../../hisglobal/images/back3.gif"
				width="35" height="31"
				onclick="shiftToLeft('strLeftItemIds','strRightItemIds',1);" /></center>
			</td>

			<td colspan="3" class="CONTROL">
			<div id="RightItemIds" align="left"><select
				name="strRightItemIds" size="8" multiple style="width: 280px">
				<bean:write name="DrugContradictionBean" property="strRightItemList"
					filter="false" />
			</select></div>
			</td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="LABEL" width="50%">
			<div align="right">Effective From</div>
			</td>
			<td class="CONTROL"><bean:write name="DrugContradictionBean" property="strEffectiveFrom" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2" onkeypress="return validateData(event,9);"><bean:write
				name="DrugContradictionBean" property="strRemarks" /></textarea></td>
		</tr>
		<tr>
			<td width="45%" class="LABEL">Record Status</td>
			<td width="45%" class="CONTROL"><html:radio
				name="DrugContradictionBean" property="strIsValid" value="1">Active</html:radio>
			<html:radio name="DrugContradictionBean" property="strIsValid"
				value="2">Inactive</html:radio></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

	</table>

<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="chk"
		value="${DrugContradictionBean.strChk1 }">
	<input type="hidden" name="strEffectiveFrom"
				value="${DrugContradictionBean.strEffectiveFrom}">
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
