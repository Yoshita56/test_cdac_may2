<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>



<html>
<head>
<meta charset=utf-8>
<title>Generic Item Master Add Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">		

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script>

<script type="text/javascript">
	var flag=false;
	 function view1(id1,id2,id3)
	{
		document.getElementById(id1).style.display="none";
		document.getElementById(id2).style.display="block";
		document.getElementById(id3).style.display="block";
	}
	function view2(id1,id2,id3)
	{
		document.getElementById(id1).style.display="block";
		document.getElementById(id2).style.display="none";
		document.getElementById(id3).style.display="none";
	} 
	function setBatchExpiry()
	{
		document.forms[0].strBatchNo.checked=true;
		(document.forms[0].strExpiryDate.checked)=true;
	}
	
	function setBatchNo()
	{
		if(document.forms[0].strBatchNo.checked)
		{
			document.forms[0].strBatchNo.value="1";
		}
		else
		{
			document.forms[0].strBatchNo.value="0";
		}
	}
	function setExpiryDate()
	{
		if(document.forms[0].strExpiryDate.checked)
		{
			document.forms[0].strExpiryDate.value="1";
		}
		else
		{
			document.forms[0].strExpiryDate.value="0";
		}
	}
	function setSlNo()
	{
			if(document.forms[0].strSerialNo.checked==true && document.forms[0].strConsumableType.value=='1')
		{
			alert("Sl. No. cannot be selected for consumable Items"); 
			document.forms[0].strSerialNo.checked = false;
		}
		
		if(document.forms[0].strSerialNo.checked)
		{
			document.forms[0].strSerialNo.value="1";
		}
		else
		{
			document.forms[0].strSerialNo.value="0";
		}
		
		
	}
	// used to populate inventory unit cmb based on selected consumable type 
	// and set sl. no
	function callInventoryUnit()
	{
	 
		var url;
   		url="GenericItemMstCNT.cnt?hmode=GETINVENTORYUNITCOMBO&ConsumableFlag="+document.forms[0].strConsumableType.value;
   		
		ajaxFunction(url,"1");
	
	
		
		
	}
	function callConsumableSlNo()
	{
		if(document.forms[0].strSerialNo.checked==true && document.forms[0].strConsumableType.value=='1')
		{
			alert("Sl. No. cannot be selected for consumable Items"); 
			document.forms[0].strSerialNo.checked = false;
		}
		if(document.getElementsByName("strConsumableType")[0].value=="0"){
			document.getElementById("auctionParmId").style.display="block";
		}else{
			document.getElementById("auctionParmId").style.display="none";
			document.getElementsByName("strDepreciationcost")[0].value="";
	     	document.getElementsByName("strAssetsReq")[0].checked=false;
		}
		
		callInventoryUnit();
	}
	
	
	function validate()
	{
		 var hisValidator = new HISValidator("genericitemBean");
	     hisValidator.addValidation("strItemName", "req", "Item Name is a Mandatory Field" );
	     
	     /*
	    	Change Request from Ajay Sir.
	    	Generic Item Code should not be mandatory.
	    */ 
	     /*
	      	if(document.forms[0].strCPACode != null){
        	
        	   hisValidator.addValidation("strCPACode", "req","Item Code is a Mandatory Field");
			        	   
        	}
	      */
	     
	     if(document.getElementsByName("strConsumableType")[0].value=="0"){
	     	 hisValidator.addValidation("strDepreciationcost", "req", "Depreciation Cost is a Mandatory Field" );
	     	 hisValidator.addValidation("strDepreciationcost", "numltet=100","Depreciation Cost should be less than or equal to 100%.");
	     	
	     }else{
	     	document.getElementsByName("strDepreciationcost")[0].value="0";
	     	document.getElementsByName("strAssetsReq")[0].checked=false;
	     	
	     }
	     
        //hisValidator.addValidation("strPurchaseLeadTime", "req", "Purchase Lead Time is a Mandatory Field" );
        hisValidator.addValidation("strStockMaintain", "dontselect=0","Please Select Inventory Unit");
        hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
        var retVal = hisValidator.validate();
        hisValidator.clearAllValidations();
        
    	 if(retVal ) 
		    {
		    
    		//Commented by vikrant after discussion with priyesh sir 
    		/*if(document.forms[0].strBatchNo.checked==false && document.forms[0].strSerialNo.checked==false)
		    {
		    	alert("Please Select Batch No. OR Serial No.");
		    	retVal=false;
		    }
		     if(document.forms[0].strBatchNo.checked==true && document.forms[0].strSerialNo.checked==true)
		    {
		    	alert("Please Select Only One Batch No. OR Serial No.");
		    	retVal=false;
		    }*/
		    
		    }
       
            if(retVal ) 
		    {
		   		document.forms[0].hmode.value="INSERT";
		   		document.forms[0].submit();
		    }
	}
	
	
	function openDiv(obj)
	{
		
		//document.getElementById("id1").style.display="block";
		if(flag==false)
		{
			var str='idSubdtl'+obj;
			document.getElementById(str).style.display="block";
			flag=true;
		}
		else
		{
			var str='idSubdtl'+obj;
			document.getElementById(str).style.display="none";
			flag=false;
		}
	}
	
	
	function deleteParamValues(){
		if(document.getElementById("itemParameterDtlDivId").innerHTML!="")
			if(confirm("Are You Sure to Delete Parameters Values!")){
					document.getElementById("modifyParamShow").style.display="none";
					document.getElementById("itemParameterDtlDivId").innerHTML="";
					document.forms[0].strParam.checked=false;
			}
	}
	
		function checkForPopup(parObj, these,catNo){
	
		if(document.forms[0].strCatNo.value !="0" ){
		
			if(these.checked==false && catNo=="#" && document.getElementById("itemParameterDtlDivId").innerHTML==""){
			
				if(confirm("Are You Sure to Delete Parameters Values!")){
				
					document.getElementById("modifyParamShow").style.display="none";
					document.getElementById("itemParameterDtlDivId").innerHTML="";
					
				}else{
					these.checked=true;
				}
					
					
			}else if(catNo=="#"){
				document.getElementById("modifyParamShow").style.display="block";
			} else{
				
				showPopup(parObj , '1' , document.forms[0].strCatNo.value , '');
			}
				
		}else{
			alert("Please Select Item Category Before");
			these.checked=false;
		}
		
	}
	
	function cancel1(){
	document.forms[0].hmode.value="LIST";
	document.forms[0].submit();
	}
	
	
function getAjaxResponse(res,mode)
{
 
		var objVal;
	  
		  if(mode=="1"){   
	
				var err = document.getElementById("errMsgId");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("inventoryUnitDiv");  
				objVal.innerHTML = "<select name='strStockMaintain' class='comboNormal'>" + res + "</select>"; 
				deleteParamValues();  
				}
		 }
}
</script>
</head>
<body onload="document.forms[0].strItemName.focus();view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');view1('purchasePlusId','purchaseMinusId','purchaseId');">
<html:form action="/masters/GenericItemMstCNT" name="genericitemBean" type="mms.masters.controller.fb.GenericItemMstFB">
	

	<center>
	<div class="errMsg" id="errMsgId"><bean:write name="genericitemBean" property="strErrMssgstring"/></div>
	<div class="warningMsg" id="warningMsgId"><bean:write name="genericitemBean" property="strWarnMssgstring"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="genericitemBean" property="strNormMssgstring"/></div>
	<tag:tab tabLabel="Generic Item Master"

                        selectedTab="FIRST" align="center" width="TABLEWIDTH" onlyTabIndexing="1">

                  </tag:tab>


	</center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	<tr class="HEADER">
		<td colspan="4" width="25%">Generic Item Master&gt;&gt; Add</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">
			 Category
			</td>
			<td width="25%" class="CONTROL">
				<html:hidden name="genericitemBean" property="strCatValues" />
				<bean:write name="genericitemBean" property="strCatValues" filter="false"/>
				
			</td>
			<td width="25%" class="LABEL">
			Group Name
			</td>
			<td class="CONTROL">
			<html:hidden name="genericitemBean" property="strGroupNameValue" />
				<bean:write name="genericitemBean" property="strGroupNameValue" filter="false"/>
			</td>
			
		</tr>
		<tr>
		<td width="25%" class="LABEL">
				Sub Group Name
			</td>
			<td width="25%" class="CONTROL">
			<html:hidden name="genericitemBean" property="strSubGroupNameValue" />
				<bean:write name="genericitemBean" property="strSubGroupNameValue" filter="false"/>
			</td>
		
			
			<td width="25%" class="LABEL">
			<font color="red">*</font>Generic Item Name
			</td>
			<td width="75%" colspan="1" class="CONTROL">
				<input type="text" name="strItemName" maxlength="100" class="txtFldMax" onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');"/>
			</td>
			</tr>
			
			</table>
			
			
		<%--
			Change Request from Ajay Sir.
			Reason: Item code should not be mandatory.
			 --%>
		<%-- 	
		<logic:equal value="1" name="genericitemBean" property="strIsItemCodeRequired" >		
			
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
		 
		<td width="25%"   class="LABEL"><font color="red">*</font>Item Code</td>
			<td width="25%" class="CONTROL"  ><input type="text"
				name="strCPACode" maxlength="6" class="txtFldNormal"
				onkeypress="return validateData(event,9);" value="" /></td>
		
			<td class="LABEL"   width="25%">
			Consumable Type
			</td>
			<td class="CONTROL"  >
				<html:select property="strConsumableType" name="genericitemBean" onchange="callConsumableSlNo();" >
			
					<html:option value="1"> Consumable</html:option>
					<html:option value="0"> Non-Consumable</html:option>	
				
				</html:select>
			</td>
		</tr>
	
		</table>

		</logic:equal>	
		
	
	<logic:equal value="0" name="genericitemBean" property="strIsItemCodeRequired" >		
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
		 
			<td class="LABEL"   width="25%">
			Consumable Type
			</td>
			<td class="CONTROL"  colspan="3" >
				<html:select property="strConsumableType" name="genericitemBean" onchange="callConsumableSlNo();" >
			
					<html:option value="1"> Consumable</html:option>
					<html:option value="0"> Non-Consumable</html:option>	
				
				</html:select>
			</td>
		</tr>
	
	</table>
	</logic:equal>
	--%>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
		 
		 <td class="LABEL"   width="25%">
			Consumable Type
			</td>
			<td class="CONTROL"  >
				<html:select property="strConsumableType" name="genericitemBean" onchange="callConsumableSlNo();" >
			
					<html:option value="1"> Consumable</html:option>
					<html:option value="0"> Non-Consumable</html:option>	
				
				</html:select>
			</td>
			
		<!--
		
		commnted by vikrant changes made same as Drug Master after discussion with Priyesh sir
		
		  	<td width="25%"   class="LABEL" style="" >Item Code</td>
			<td width="25%" class="CONTROL"  ><input type="text"
				name="strCPACode" maxlength="6" class="txtFldNormal"
				onkeypress="return validateData(event,9);" value="0" />
		</td>
		-->
	
     	  <td width="25%"   class="LABEL"></td>
		  <td width="25%" class="CONTROL"></td>
			
		</tr>
	
		</table>
	<div id='auctionParmId' style='display: none;'>
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">	
			<tr>
			<td width="25%" class="LABEL">Whether Assets</td>
			<td width="75%" class="CONTROL">
			<html:checkbox property="strAssetsReq" name="genericitemBean" value="1"></html:checkbox>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font> Depreciation Cost</td>
			<td width="75%" class="CONTROL">
			<input type="text" name="strDepreciationcost" onkeypress="return validateData(event,7);" maxlength="6" class="txtFldNormal">&nbsp;%
			</td>
		</tr>
		</table>
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" style="display: none;">		
				<tr>
				  <td  colspan="4" class="TITLE" width="25%">
				  <div id="itemManagePlusId" align="left" style="display:block;">
					<img src="../../hisglobal/images/plus.gif"	onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer; "/>
						Item Managed By
				  </div>
				  <div id="itemManageMinusId" style="display:none;" align="left">
					<img src="../../hisglobal/images/minus.gif"	onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer; "/>
					   Item Managed By
				  </div>
				  </td>
				</tr>
	</table>
	<div id="itemManageDtlId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px" style="display: none;">
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Batch No.
			</td>
			<td class="CONTROL" colspan="" width="25%">
				<html:checkbox property="strBatchNo"  onclick="setBatchNo();" name="genericitemBean"></html:checkbox>
				
			</td>
			<td class="LABEL" width="25%">
				Expiry Date
			</td>
			<td class="CONTROL" width="25%">
			<html:checkbox property="strExpiryDate"  onclick="setExpiryDate();" name="genericitemBean"></html:checkbox>
				
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Serial No. Required
			</td>
			<td class="CONTROL" colspan="3" >
				<html:checkbox property="strSerialNo" value="1" name="genericitemBean" onclick="setSlNo();"></html:checkbox>
				
			</td>
			
		</tr>
		
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Whether Item Has Specific Parameter
			</td>
			<td class="CONTROL" colspan="1" width="25%">
				<html:checkbox property="strParam" value="1" name="genericitemBean" onclick="checkForPopup(this,document.forms[0].strParam,'#')"></html:checkbox>
				
			</td>
			<td class="CONTROL" colspan="2" width="50%">
			<div id="modifyParamShow" style="display:none">
			<!-- <img src="../../hisglobal/images/add_parameter.png" onclick="checkForPopup(this,document.forms[0].strParam,document.forms[0].strCatNo.value)" style="cursor: pointer; "> -->
			<a href="#" class="button" id="" onclick='checkForPopup(this,document.forms[0].strParam,document.forms[0].strCatNo.value)'><span class="add">Add</span></a>
			</div>				
			</td>
		</tr>
	</table>
	
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">		
				<tr>
				  <td  colspan="4" class="TITLE" width="25%">
				<div id="purchasePlusId" align="left" style="display:block;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('purchasePlusId','purchaseMinusId','purchaseId');" style="cursor: pointer; "/>
						Purchase/Inventory
					</div>
					<div id="purchaseMinusId" style="display:none;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('purchasePlusId','purchaseMinusId','purchaseId');" style="cursor: pointer; "/>
								Purchase/Inventory
					</div>
					</td>
				</tr>
	</table>
	<div id="purchaseId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="0px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Purchase Lead Time
			</td>
			<td class="CONTROL" colspan="" width="25%">
				<input type="text" name="strPurchaseLeadTime" maxlength="3" value="${genericitemBean.strPurchaseLeadTime}" class="txtFldMin" onkeypress="return validateData(event,5);"/>
			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
				<html:select property="strTimeFormat">
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
				</html:select>
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				<font color="red">*</font>Inventory Unit
			</td>
			<td class="CONTROL" colspan="" width="25%"><div id="inventoryUnitDiv">
			<select name="strStockMaintain">
					<bean:write name="genericitemBean" property="strStockMaintainedValues" filter="false"/>
					
				</select></div>
				
			</td>
			<td class="LABEL" colspan="3" width="25%">
				
			</td>
			</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Shelf Life
			</td>
			<td class="CONTROL" colspan="" width="25%">
				<input type="text" name="strShelfLife" maxlength="3"  value="${genericitemBean.strShelfLife}" class="txtFldMin" onkeypress="return validateData(event,5);"/>
			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
				<html:select property="strShelfTimeFormat">
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
					<html:option value="3">Year</html:option>
				</html:select>
			</td>
		</tr>
		
	</table>
	</div>
	
	
		
<table cellspacing="1px" class="TABLEWIDTH" align="center">
	<tr>
		<td class="LABEL" width="25%"> 
			Remarks
		</td>
		<td class="CONTROL"  width="25%" colspan="">
				<textarea rows="2" cols="20" name="strRemarks"></textarea>
			</td>
			<td class="LABEL" width="25%"  style="display:none;"> 
			<font color="red"></font>Effective From
		</td>
		<td class="CONTROL"  width="25%" colspan="" style="display:none;">
				<dateTag:date name="strEffectiveFrom" value="${genericitemBean.strCurrentDate}"></dateTag:date>
			</td>
		</tr>
	</table>
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr class="FOOTER">
		<td colspan="4" width="25%"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table  class="TABLEWIDTH" align="center" cellspacing="1px">
	
		<tr>

			<td align="center" colspan="2" width="25%">
			<!-- <img src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick="validate();" style="cursor: pointer; "/>
			<img src="../../hisglobal/images/btn-clr.png" title="Clear Content"
				onClick="document.forms[0].reset();" style="cursor: pointer; "/>
				<img src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick ="cancel1('LIST');" style="cursor: pointer; ">
				 -->
				 <br>					 
				<a href="#" class="button" id="" onclick=' return validate();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel1('LIST');"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" value="${genericitemBean.strCurrentDate}" name="strCurrentDate"/>
<input type="hidden" value="${genericitemBean.strCatNo}" name="strCatNo"/>
<input type="hidden" value="${genericitemBean.strGroupId}" name="strGroupId"/>
<input type="hidden" value="${genericitemBean.strSubGroupId}" name="strSubGroupId"/>

<input type="hidden" value="${genericitemBean.strIsItemCodeRequired}" name="strIsItemCodeRequired"/>
 
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDivId" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemParameterDtlDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>
<cmbPers:cmbPers/>  
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>