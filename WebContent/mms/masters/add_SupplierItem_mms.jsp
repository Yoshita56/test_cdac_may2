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
<meta charset=utf-8>
<title>Supplier Drug Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("SupplierItemBean");
              
			
	         hisValidator.addValidation("strGroupId", "dontselect=0","Please select a Group Name " );
	      
          hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			 var retVal = hisValidator.validate(); 
			   hisValidator.clearAllValidations();
    	
          if(retVal){
        		 var count = selectListRecords("strRightItemIds");
        		 if(count==0)
        		 {alert("Please select an Drug which is not already added");
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
	 var mode = 'ITEMLIST';   
	 url="SupplierItemMstCNT.cnt?hmode=ITEMLIST&GroupId="+document.forms[0].strGroupId.value+"&SupplierId="+document.forms[0].strSupplierId.value;      
	 
	 ajaxFunction(url,"1");
}


function searchInList()
{ 

	var valObj = document.forms[0].searchVal;

/*
	if(valObj.value.length == 0 ){
	
		alert("Please Enter a Value to Search from List");
		valObj.focus();
		return false;
	}
*/	
	searchInListBox("strLeftItemIds",document.forms[0].searchVal.value);  
}
/*
function BrandCombo()
{ 

	 var url;
	 var mode = 'BRANDNAME';   
	 url="SupplierItemMstCNT.cnt?hmode=BRANDNAME&ItemId="+document.forms[0].strItemId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value;     
	 
	 ajaxFunction(url,"1");
}
	

function SubGroupCombo()
{
	
	 var url;
	 var mode = 'SUBGROUPNAME';   
	 url="SupplierItemMstCNT.cnt?hmode=SUBGROUPNAME&GroupId="+document.forms[0].strGroupId.value;    
	 
	 ajaxFunction(url,"2");
}
function ItemNameCombo()
{
	
	 var url;
	 var mode = 'ITEMNAME';   
	 url="SupplierItemMstCNT.cnt?hmode=ITEMNAME&GroupId="+document.forms[0].strGroupId.value+
	 "&SubGroupId="+document.forms[0].strSubGroupId.value+"&SupplierComboId="+document.forms[0].strSupplierId.value +"&CategoryNo="+document.forms[0].strCategoryNo.value;      
	 ajaxFunction(url,"3");
}

function UnitCombo()
{

	 var url;
	 var mode = 'UNITNAME';   
	 var strItemId = document.forms[0].strItemId.value;
	
	 url="SupplierItemMstCNT.cnt?hmode=UNITNAME&strGenItemId="+strItemId; 
	 ajaxFunction(url,"4");
}*/
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
				objVal.innerHTML = "<select name='strLeftItemIds' size='8' 	multiple style='width: 280px' >" + temp[0] + "</select>";
				
				/*
				This is commented by Aritra on 28Dec 2010
				Reason: Change Request From Ajay Sir.(Master SL No 10) 
						In Add page, there should be provision to map the items
						of different group with a supplier at a time. 
				*/
				/*
				objVal= document.getElementById("RightItemIds");
				objVal.innerHTML = "<select name='strRightItemIds' size='8' 	multiple style='width: 280px' >" + temp[1] + "</select>";
				*/
				removeOptions();
				}
		 }
	/*	  if(mode=="2"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("SubGroupDivId"); 
				objVal.innerHTML = "<select name ='strSubGroupId' onChange='ItemNameCombo();'>" + res + "</select>";
				ItemNameCombo();
				}
		 }
		 if(mode=="3"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("ItemNameDivId"); 
				objVal.innerHTML = "<select name ='strItemId' onchange='BrandCombo();'>" + res + "</select>";
				}
		 }
		 if(mode=="4"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
	        		if(temp1[0] == "ERROR"){
	         			err.innerHTML = temp1[1];	
	        			 }
					else{
					objVal= document.getElementById("UnitDivId"); 
					objVal.innerHTML = "<select name ='strRateUnitId' >" + res + "</select>";
					}
				 }*/
}

function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftItemIds");
	shiftToRight("strLeftItemIds","strRightItemIds",1);
}

/*
 * This function populates the already added item list, i.e., the right hand pannel.
 */
function getRightItemList() {
	alert("getRightItemList()");
}

/*
 * This will remove options from left item list which are allready selected();
 */
function removeOptions(){
	//alert("removeOptions()");
	var select_leftElement=document.getElementsByName('strLeftItemIds')[0];
	var select_rightElement=document.getElementsByName('strRightItemIds')[0];
	
	var array_option_leftElement=select_leftElement.options;
	var array_option_rightElement=select_rightElement.options;
	
	//alert(arr_leftElement.length);
	var array_option_removableOptions=new Array();
	var count=0;
	for(i=0;i<array_option_rightElement.length;++i) {
		
		//alert("Checking for(left):"+array_option_rightElement[i].text);
		for(j=0;j<array_option_leftElement.length;++j) {
			if(array_option_leftElement[j].value == array_option_rightElement[i].value) {
				//select_leftElement.remove(array_option_leftElement[i].index);
				array_option_removableOptions[count]=array_option_leftElement[j];
				count=count+1;
				break;
			}
			//alert("not match with"+);
		}
	}
	for(i=0;i<array_option_removableOptions.length;++i) {
		select_leftElement.remove(array_option_removableOptions[i].index);
	}
}
</script>

</head>
<body onLoad="document.forms[0].strGroupId.focus();">
<html:form name="SupplierItemBean" action="/masters/SupplierItemMstCNT"
	type="mms.masters.controller.fb.SupplierItemMstFB">
	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="SupplierItemBean" property="strErr" /></div>
	<div class="warningMsg"><bean:write name="SupplierItemBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="SupplierItemBean" property="strMsg" /></div>


	<tag:tab tabLabel="Supplier Drug Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4">Supplier Drug Master&gt;&gt; Add</td>
		</tr>

		<tr>
			<td class="LABEL" width="50%" colspan="2">Supplier Name</td>
			<td width="50%" colspan="2" class="CONTROL"><bean:write
				name="SupplierItemBean" property="strSupplierName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="50%" colspan="2">Drug Category</td>
			<td width="50%" colspan="2" class="CONTROL"><bean:write
				name="SupplierItemBean" property="strItemCategoryName"
				filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="50%" colspan="2"><font color="red">*</font>Group
			Name</td>
			<td width="50%" colspan="2" class="CONTROL"><html:select
				name="SupplierItemBean" property="strGroupId"
				onchange="getLeftItemList();">
				<bean:write name="SupplierItemBean" property="strGroupNameCombo"
					filter="false" />
			</html:select></td>
		</tr>
	

		<tr>
		<td colspan="4"  class="TITLE" ><font color="red">* </font>Item Names</td>
		</tr>
		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
		<td colspan="1"  class="LABEL" ><div align="center"><input type="text" name="searchVal" class="txtFldNormal" onkeyup="return searchInList();" /> 
		<img style="cursor: pointer;" src="../../hisglobal/images/btn-search.png" onclick='return searchInList();' title="Search Item"> 
		</div></td>
		<td colspan="6"  class="LABEL" >
		
		</td>
		</tr>
 			 <tr>
  			 <td class="CONTROL" colspan="2">
  			 
			<div id="LeftItemIds" align="right">
			<select name="strLeftItemIds" size="8" 
				multiple style="width: 280px">
				<bean:write name="SupplierItemBean" property="strLeftItemList" filter="false"/>
				</select></div>
			</td>
			<td width="6%" class="CONTROL" colspan="2">
			
			<center>
			<img src="../../hisglobal/images/forward3.gif" width="35"
				height="31" 
				onclick ="LeftListTransfer();"></center>
				
				<center><img src="../../hisglobal/images/forwardward.gif" width="35" height="31" 
				align="middle" onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);"/></center>
				<br/>
				<center>
				
				<img src="../../hisglobal/images/backward.gif" width="35"
				height="31" 
				onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);">
				</center>
				
				<center><img src="../../hisglobal/images/back3.gif" width="35" 
				height="31" 
				onclick="shiftToLeft('strLeftItemIds','strRightItemIds',1);"/></center>
			</td>
			
			<td colspan="3" class="CONTROL" >
			<div id="RightItemIds" align="left"><select name="strRightItemIds" size="8" 
			multiple style="width: 280px"><bean:write name="SupplierItemBean" property="strRightItemList" filter="false"/>
			</select></div>
			</td>		
			</tr> 
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	
		<tr>
			<td class="LABEL" width="50%" colspan="2">
			<div align="right"><font color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${SupplierItemBean.strCtDate}"></dateTag:date></td>
		</tr>




		<tr>
			<td width="50%" colspan="2" class="LABEL" valign="top">Remarks if Any</td>
			<td width="50%" colspan="2" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
		</tr>

		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

	</table>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				title="Save Record" src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png" title="Reset Content"
				onClick="document.forms[0].reset(),document.forms[0].strItemId.focus();" />
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strSupplierId"
		value="${SupplierItemBean.combo[1]}">

	<input type="hidden" name="strCategoryNo"
		value="${SupplierItemBean.combo[0]}">


	<input type="hidden" name="strSupplierStatus"
		value="${SupplierItemBean.strSupplierStatus}">

	<input type="hidden" name="comboValue"
		value="${SupplierItemBean.strComboValue}">

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
