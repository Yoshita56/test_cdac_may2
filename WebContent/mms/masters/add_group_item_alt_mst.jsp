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
<title>Group Drug Alteration Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1()
{     
      var hisValidator = new HISValidator("groupItemAltMstBean");
              
			hisValidator.addValidation("strItemCat", "dontselect=0","Please Select Drug Category");
			hisValidator.addValidation("strExGroupId", "dontselect=0","Please Select Existing Group");
			hisValidator.addValidation("strRpGroupId", "dontselect=0","Please Select Replaced Group");
			hisValidator.addValidation("strRpSubGroupId", "dontselect=0","Please Select Replaced Sub Group");
			hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
	   	 	hisValidator.addValidation("strRemarks", "req", "Please Enter Remarks" );
	   	 	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			var retVal = hisValidator.validate();
          	if(retVal)
          	{
          		 var count = selectListRecords("strRightItemIds");
          		 var count1 = selectListRecords("strRightNewItemIds");
        		 if(count==0 && count1==0)
        		 {
        		 	alert("Please Select Items in Right List");
        		 	return false;
        		 }        		 
        		 document.forms[0].hmode.value = "SAVE";
                 document.forms[0].submit();            	 
			}
			else
            {
				return false;
			}
}
function getAjaxResponse(res,mode)
{
		var objVal;
		var objVal2;
		objVal= document.getElementById("SubGroupDivId");
		objVal.innerHTML ="<select name ='strRpSubGroupId' class='comboNormal'>"+
						  "<option value='-1'>No Change</option><option value='-2'>No Sub Group</option></select>";
	    if(mode=='1')
	    {   
				objVal= document.getElementById("LeftItemIds");
				objVal.innerHTML = "<select name='strLeftItemIds' size='6' multiple style='width: 280px'></select>";
				objVal= document.getElementById("LeftNewItemIds");				
				objVal.innerHTML = "<select name='strLeftNewItemIds' size='6' multiple style='width: 280px'></select>";
				objVal= document.getElementById("RightItemIds");
				objVal.innerHTML = "<select name='strRightItemIds' size='6' multiple style='width: 280px'></select>";
				objVal= document.getElementById("RightNewItemIds");
				objVal.innerHTML = "<select name='strRightNewItemIds' size='6' multiple style='width: 280px'></select>";				
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
	       		if(temp1[0] == "ERROR")
	       		{
         			err.innerHTML = temp1[1];
        		}
				else
				{
					objVal= document.getElementById("exGrp");
					objVal.innerHTML = "<select name='strExGroupId' class='comboNormal' onchange='getNextCombo(2,this)'>"+res+"</select>";				
					objVal= document.getElementById("rpGrp");
					objVal.innerHTML = "<select name='strRpGroupId' onchange='getNextCombo(3,this)' class='comboNormal'>"+res+"</select>";
				}
		}
		if(mode=='2')
		{   
				objVal= document.getElementById("LeftItemIds");
				objVal.innerHTML = "<select name='strLeftItemIds' size='6' multiple style='width: 280px'></select>";
				objVal= document.getElementById("LeftNewItemIds");				
				objVal.innerHTML = "<select name='strLeftNewItemIds' size='6' multiple style='width: 280px'></select>";
				objVal= document.getElementById("RightItemIds");
				objVal.innerHTML = "<select name='strRightItemIds' size='6' multiple style='width: 280px'></select>";
				objVal= document.getElementById("RightNewItemIds");
				objVal.innerHTML = "<select name='strRightNewItemIds' size='6' multiple style='width: 280px'></select>";
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
        		if(temp1[0] == "ERROR")
        		{
         			err.innerHTML = temp1[1];	
        		}
				else
				{
					objVal= document.getElementById("LeftItemIds");
					objVal.innerHTML = "<select name='strLeftItemIds' size='6' multiple style='width: 280px' >"+res.split('^')[0]+"</select>";
					objVal= document.getElementById("LeftNewItemIds");				
					objVal.innerHTML = "<select name='strLeftNewItemIds' size='6' multiple style='width: 280px' >"+res.split('^')[1]+"</select>";
				}
		 }
		 if(mode=='3')
		 {   
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
        		if(temp1[0] == "ERROR")
        		{
         			err.innerHTML = temp1[1];	
        		}
				else
				{
					var temp = res.split("#");	
					objVal= document.getElementById("SubGroupDivId"); 
					objVal.innerHTML = "<select name ='strRpSubGroupId' class='comboNormal'>"+res+"</select>";
				}
		 }
		 if(mode=='4')
		 {   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			    if(temp1[0] == "ERROR")
        		{
         			err.innerHTML = temp1[1];	
        		}
				else
				{					
					objVal= document.getElementById("LeftItemIds");
					objVal.innerHTML = "<select name='strLeftItemIds' size='6' multiple style='width: 280px'>"+res.split('^')[0]+"</select>";
					objVal= document.getElementById("LeftNewItemIds");				
					objVal.innerHTML = "<select name='strLeftNewItemIds' size='6' multiple style='width: 280px'>"+res.split('^')[1]+"</select>";
				}
		 }
}
function getNextCombo(flag,obj)
{
	var url;
	var mode = '';   
	
	if(flag == '1')//Get Existing Group
	{
		 url="GroupItemAltMstCNT.cnt?hmode=EXISTGROUP&strItemCat="+obj.value; 
		 ajaxFunction(url,"1");
	}
	if(flag == '2')//Get Replaced Group
	{
		 url="GroupItemAltMstCNT.cnt?hmode=EXISTINGITEMS&strExGroupId="+obj.value; 
		 ajaxFunction(url,"2");
	}
	if(flag == '3')//Get Replaced Sub Group
	{
		 url="GroupItemAltMstCNT.cnt?hmode=REPLACESUBGROUP&strRpGroupId="+obj.value; 
		 ajaxFunction(url,"3");
	}
	if(flag == '4')//Get Existing Items
	{
		 url="GroupItemAltMstCNT.cnt?hmode=EXISTINGITEMS&strExGroupId="+document.forms[0].strExGroupId.value; 
		 ajaxFunction(url,"4");
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
function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftItemIds");
	shiftToRight("strLeftItemIds","strRightItemIds",1);
}
function LeftNewListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftNewItemIds");
	shiftToRight("strLeftNewItemIds","strRightNewItemIds",1);
}
	
</script>
</head>
<body>
<html:form name="groupItemAltMstBean" action="/masters/GroupItemAltMstCNT" 
type="mms.masters.controller.fb.GroupItemAltMstFB">
	<center>
	<div id="errMsg" class="errMsg"><bean:write name="groupItemAltMstBean" property="strErr" /></div>
	<div class="warningMsg"><bean:write name="groupItemAltMstBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="groupItemAltMstBean" property="strMsg" /></div>
	<tag:tab tabLabel="Group Drug Alteration Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Group Drug Alteration Master</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Drug Category</td>
			<td width="25%" class="CONTROL" colspan="1">
			<select name="strItemCat" onchange="getNextCombo(1,this)" class="comboNormal">
			<bean:write name="groupItemAltMstBean" property="strItemCatCombo" filter="false" /></select></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Existing Group</td>
			<td width="25%" class="CONTROL"><div id="exGrp">
			<select name="strExGroupId" onchange="getNextCombo(2,this)" class="comboNormal">
			<option value='0'>Select Value</option>
			</select>
			</div></td>
		</tr>
		<tr>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Replaced Group</td>
			<td width="25%" class="CONTROL">
			<div id="rpGrp">
			<select name="strRpGroupId" onchange="getNextCombo(3,this)" class="comboNormal">
				<option value='0'>Select Value</option>
			</select></div></td>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Replaced Sub Group</td>
			<td width="25%" class="CONTROL" colspan="1">
			<div id="SubGroupDivId">
			<select name="strRpSubGroupId" class="comboNormal">
				<option value="-1" selected="selected">No Change</option>
				<option value="-2">No Sub Group</option>
				<bean:write name="groupItemAltMstBean" property="strRpSubGroupNameCombo" filter="false" />
			</select></div>
			</td>
		</tr>		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
		<td colspan="8"  class="TITLE" ><font color="red">*</font>Existing Drug</td>
		</tr>
		<tr>
  			<td class="CONTROL" colspan="2">  			 
			<div id="LeftItemIds" align="right">
			<select name="strLeftItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strLeftItemList" filter="false"/>
			</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftListTransfer();"></center>
			<center>
			<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" 
				align="middle" onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);"/></center>
			<br/>
			<center>				
			<img src="../../hisglobal/images/backward.gif" width="30" height="21" 
				onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);"></center>
			<center><img src="../../hisglobal/images/back3.gif" width="30" height="21" 
				onclick="shiftToLeft('strLeftItemIds','strRightItemIds',1);"/></center>
			</td>			
			<td colspan="3" class="CONTROL">
			<div id="RightItemIds" align="left">
			<select name="strRightItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strRightItemList" filter="false"/>
			</select></div>
			</td>		
		</tr>
		<tr>
		<td colspan="8" class="TITLE">New Drug</td>
		</tr>
		<tr>
  			<td class="CONTROL" colspan="2">  			 
			<div id="LeftNewItemIds" align="right">
			<select name="strLeftNewItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strLeftNewItemList" filter="false"/>
			</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftNewListTransfer();"></center>
			<center>
			<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" 
				align="middle" onClick="shiftAllToRight('strLeftNewItemIds','strRightNewItemIds',1);"/></center>
			<br/>
			<center>				
			<img src="../../hisglobal/images/backward.gif" width="30" height="21" 
				onClick="shiftAllToLeft('strLeftNewItemIds','strRightNewItemIds',1);"></center>
			<center><img src="../../hisglobal/images/back3.gif" width="30" height="21" 
				onclick="shiftToLeft('strLeftNewItemIds','strRightNewItemIds',1);"/></center>
			</td>			
			<td colspan="3" class="CONTROL">
			<div id="RightNewItemIds" align="left">
			<select name="strRightNewItemIds" size="6" multiple style="width: 280px">
				<bean:write name="groupItemAltMstBean" property="strRightNewItemList" filter="false"/>
			</select></div>
			</td>		
		</tr>
		</table>
		<TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font color="red">*</font>Effective From</div>
			</td>
			<td class="CONTROL">
			<dateTag:date name="strEffectiveFrom" value="${groupItemAltMstBean.strCtDate}"></dateTag:date></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL" valign="top"><font color="red">*</font>Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks" cols="25" rows="2"></textarea></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font>Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td align="center">
			<!-- <img style="cursor: pointer; "
				title="Save Record" src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" />
			<img style="cursor: pointer; " title="Reset Content"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" />
			<img style="cursor: pointer; " title="Cancel Process" 
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('CANCEL');" />
				 -->
				
				<br>					 
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('CANCEL');"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />	
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>