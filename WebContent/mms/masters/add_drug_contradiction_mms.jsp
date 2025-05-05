<%-- 
author 	: Niharika Srivastava
Date of Creation : 25-08-10
Process : Drug Contradiction Master
Module 	: MMS
TL 		: Mr. Ajay Kumar Gupta
Description : Add Page for Drug Contradiction Master  
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=utf-8>
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
             		
	         hisValidator.addValidation("strGroupId", "dontselect=0","Please select a Group Name " );
	      	 hisValidator.addValidation("strDrugId", "dontselect=0","Please select a Drug Name " );
          	 hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
             hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			 
			 var retVal = hisValidator.validate(); 
			   hisValidator.clearAllValidations();
    	
          	if(retVal){
        		 var count = selectListRecords("strRightItemIds");
        		 
        		 if(count==0)
        		 {
        		 alert("Please select an Drug which is not already added");
        		 return false;
        		 }
       			   document.forms[0].hmode.value = "SAVE";
                        document.forms[0].submit();
            }else{
	           return false;
			   }
    }
    	
    

function getLeftItemList()
{ 
	 var url;
	 url="DrugContradictionMstCNT.cnt?hmode=CONTRADRUGLIST&strGroupId="+document.forms[0].strGroupId.value+"&strDrugId="+document.forms[0].strDrugId.value;      
	 ajaxFunction(url,"1");
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

function getDrugNameCombo()
{

	 var url;
	 var strGroupID = document.forms[0].strGroupId.value;
	 url="DrugContradictionMstCNT.cnt?hmode=DRUGNAMECMB&strGroupId="+strGroupID; 
	 ajaxFunction(url,"2");
}
function getAjaxResponse(res,mode)
{
		var objVal;
	   if(mode=="1"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				var temp = res.split("@@");
				
				objVal= document.getElementById("LeftItemIds");
				objVal.innerHTML = "<select name='strLeftItemIds' size='8' multiple style='width: 280px' >" + temp[0] + "</select>";
				
				objVal= document.getElementById("RightItemIds");
				objVal.innerHTML = "<select name='strRightItemIds' size='8' multiple style='width: 280px' >" + temp[1] + "</select>";
			}
		 }
	  if(mode=="2"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("drug"); 
				objVal.innerHTML = "<select name ='strDrugId' onchange='getLeftItemList();'>" + res + "</select>";
				
				}
		 }
		}

function leftListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftItemIds");
	shiftToRight("strLeftItemIds","strRightItemIds",1);
}
function rightListTransfer()
{
	if(document.forms[0].strRightItemIds.value=="0")
	{
		alert("Already existing Data could not move from right to left.");
	}
	else{
	shiftToLeft('strLeftItemIds','strRightItemIds',1)
	}

}

function clearFunction(){
	document.forms[0].reset();
	document.getElementById("LeftItemIds").innerHTML =  "<select name='strLeftItemIds' size='8' multiple style='width: 280px' > </select>";
	document.getElementById("RightItemIds").innerHTML = "<select name='strRightItemIds' size='8' multiple style='width: 280px' > </select>";
	document.forms[0].strGroupId.focus();
}
</script>

</head>
<body onLoad="document.forms[0].strGroupId.focus();">
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
			<td colspan="4">Drug Contradiction Master&gt;&gt; Add</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%" colspan="2"><font color="red">*</font>Group
			Name</td>
			<td width="50%" colspan="2" class="CONTROL"><html:select
				name="DrugContradictionBean" property="strGroupId"
				onchange="getDrugNameCombo();">
				<bean:write name="DrugContradictionBean"
					property="strGroupNameCombo" filter="false" />
			</html:select></td>
		</tr>
		<tr>
			<td class="LABEL" width="50%" colspan="2"><font color="red">*</font>Drug
			Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="drug"><select name="strDrugId">
				<option value="0">Select Value</option>
			</select></div>
			</td>
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
			<!-- <div align="center"><input type="text" name="searchVal"
				class="txtFldNormal" /> <img style="cursor: pointer;"
				src="../../hisglobal/images/btn-search.png"
				onclick='return searchInList();' title="Search Item"></div> -->
				<div align="center" id=" ">
			<input type="text" name="searchVal" name="searchVal" class="txtFldNormal"  />					 
					 	<a href="#" class="button" onclick="return searchInList();"><span class="search">Search</span></a>
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
				width="35" height="31" onclick="rightListTransfer();" /></center>
			</td>

			<td colspan="3" class="CONTROL">
			<div id="RightItemIds" align="left"><select
				name="strRightItemIds" size="8" multiple style="width: 280px">
			</select></div>
			</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td class="LABEL" width="50%" colspan="2">
			<div align="right"><font color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${DrugContradictionBean.strCtDate}"></dateTag:date></td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL" valign="top">Remarks</td>
			<td width="50%" colspan="2" class="CONTROL"><textarea
				name="strRemarks" cols="25" rows="2"
				onkeypress="return validateData(event,9);"></textarea></td>
		</tr>

		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

	</table>

	<!-- <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				title="Save Record" src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png" title="Reset Content"
				onClick="clearFunction();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>-->
	<br>
<div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearFunction();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
