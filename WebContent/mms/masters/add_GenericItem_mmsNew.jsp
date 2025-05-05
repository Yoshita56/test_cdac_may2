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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>



<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">		

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>
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
   		url="GenericItemMstBSCNT.cnt?hmode=GETINVENTORYUNITCOMBO&ConsumableFlag="+document.forms[0].strConsumableType.value;
   		
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
		var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
		
		for (var i = 0; i < document.forms[0].strItemName.value.length; i++) {
		    if (iChars.indexOf(document.forms[0].strItemName.value.charAt(i)) != -1) {
		    alert ("Item Name has special character(s). \nThese are not allowed.\n");
		    return false;
		        }
		    }
		
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
//         hisValidator.addValidation("strStockMaintain", "dontselect=0","Please Select Inventory Unit");
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
<style type="text/css">
/* .legendNew {
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: -2.9em;
}
 */
  .prescriptionTile {
		margin: 20px;
		border-bottom: 1px solid #d7d7d7;
		padding-bottom: 10px;
		padding: 1% 2% 0.5% 2%;
		background-color: #fff;
		transition: 0.5s;
		box-shadow: 0.5px 0.5px 10px 2px #b0acac;
		border-radius: .35rem;
		color: #666;
		color: rgba(75, 75, 75, 0.9);
		color: rgb(21, 21, 21);
	}
	.legend2 {
	   position: absolute;
	   top: 0.5em;
	   right: 44px;
	   line-height: 1.2em;
	}
</style>
</head>
<body onload="document.forms[0].strItemName.focus();view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');view1('purchasePlusId','purchaseMinusId','purchaseId');">
<html:form action="/masters/GenericItemMstBSCNT" name="genericitemBean" type="mms.masters.controller.fb.GenericItemMstFB">
<div class="container-fluid">
	<div class="prescriptionTile">	

	<div class="errMsg" id="errMsgId"><bean:write name="genericitemBean" property="strErrMssgstring"/></div>
	<div class="warningMsg" id="warningMsgId"><bean:write name="genericitemBean" property="strWarnMssgstring"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="genericitemBean" property="strNormMssgstring"/></div>
	<%-- <tag:tab tabLabel="Generic Item Master"

                        selectedTab="FIRST" align="center" width="TABLEWIDTH" onlyTabIndexing="1">

                  </tag:tab> --%>
<div class="row" >
		 <div class="legend2" id="nonPrintableLegend2">
				<button type="button" class="float-right btn btn-danger cancelbtn my-1" style="border-radius:50%; padding:10px 12px;" onclick="cancel1('LIST');">
					<i class="fas fa-times" title="Cancel"></i>
				</button>
				<button type="button" class="float-right btn btn-secondary my-1" onclick="document.forms[0].reset();" style="border-radius:50%; background: royalblue;padding:10px 9px;">
					<i class="fas fa-broom" title="Clear"></i>
					<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 22px; color: #fff;"> -->
				</button>
				<button type="button" id="submitId" class="float-right btn btn-success my-1" tabindex="2" onclick="return validate();" style="border-radius:50%; padding:10px 12px; background-color: #5cb85c;">
					<i class="fas fa-save iround" title="save"></i>
				</button> 	
		 </div>	
</div>   


   <div class="row">
				<div class="col-sm-9" align="left">
							<p class="subHeaders" style="margin-bottom: 0;">
								<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Generic Item Master&nbsp;&nbsp;<i class="fas fa-angle-double-right"></i>&nbsp;Add
							</p>
				       </div>
							
						</div>
<hr>						
<div class="row">
<div class="col-sm-2">
<label> Category:</label>
</div>
<div class="col-sm-2" style="color: gray;">
<html:hidden name="genericitemBean" property="strCatValues" />
				<bean:write name="genericitemBean" property="strCatValues" filter="false"/>
				
</div>
<div class="col-sm-2">
<label>Group Name:</label>
</div>
<div class="col-sm-6" style="color: gray;">
<html:hidden name="genericitemBean" property="strGroupNameValue" />
				<bean:write name="genericitemBean" property="strGroupNameValue" filter="false"/>
</div>
</div>


<div class="row">
<div class="col-sm-2">
<label>Sub Group Name:</label>
</div>
<div class="col-sm-2" style="font-weight: 498;">
<html:hidden name="genericitemBean" property="strSubGroupNameValue" />
				<bean:write name="genericitemBean" property="strSubGroupNameValue" filter="false"/>
</div>
<div class="col-sm-2">
<label><font color="red">*</font>Generic Item Name</label>
</div>
<div class="col-sm-2">
<input type="text" name="strItemName" maxlength="100" class="form-control" onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');"/>
</div>
<div class="col-sm-2">
<label>Consumable Type</label>
</div>
<div class="col-sm-2">
<html:select property="strConsumableType" name="genericitemBean" onchange="callConsumableSlNo();" style="display: block;
    width: 100%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;">
			
					<html:option value="1"> Consumable</html:option>
					<html:option value="0"> Non-Consumable</html:option>	
				
				</html:select>
</div>
</div>



<div class="row">
	<div class="col-sm-3" id="purchasePlusId" align="left" style="display:block;"> 
	<button type="button" class="btn btn-info collapsed" onClick="view1('purchasePlusId','purchaseMinusId','purchaseId');" 
	style="cursor: pointer; background-color:#49B2F3;border-color:#49B2F3;" data-toggle="collapse" data-target="#purchaseId" aria-expanded="false">
	         <i class="fas fa-plus"></i>&nbsp;Purchase/Inventory
	 </button>
     </div>
     <div class="col-sm-3" id="purchaseMinusId" style="display:none;" align="left"> 
     <button type="button" class="btn btn-info collapsed" onClick="view2('purchasePlusId','purchaseMinusId','purchaseId');" 
     style="cursor: pointer; background-color:#49B2F3;border-color:#49B2F3;" data-toggle="collapse" data-target="#purchaseId" aria-expanded="false">
	         <i class="fas fa-minus"></i>&nbsp;Purchase/Inventory
	 </button>
     </div>
    <div class="col-sm-9"></div>
    </div>



<div id="purchaseId" class="collapse">
<div class="row">
	<div class="col-sm-3">
	<label>Purchase Lead Time</label>
	</div>
	<div class="col-sm-3">
	<input type="text" name="strPurchaseLeadTime" maxlength="3" value="${genericitemBean.strPurchaseLeadTime}" class="form-control" onkeypress="return validateData(event,5);"/>
	
	</div>
	<div class="col-sm-3">
	<label>Time Format</label>
	</div>
	<div class="col-sm-3">
	<html:select property="strTimeFormat" style="display: block;
    width: 100%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;">
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
				</html:select>
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-3">
	<label><font color="red">*</font>Inventory Unit</label>
	</div>
	<div class="col-sm-3">
	<select name="strStockMaintain" class="form-control">
					<bean:write name="genericitemBean" property="strStockMaintainedValues" filter="false"/>
					
				</select>
	</div>
	<div class="col-sm-3">
	<label>Shelf Life</label>
	</div>
	<div class="col-sm-3">
	<input type="text" name="strShelfLife" maxlength="3"  value="${genericitemBean.strShelfLife}" class="form-control" onkeypress="return validateData(event,5);"/>
	
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-3">
	<label>Time Format</label>
	</div>
	<div class="col-sm-3">
	<html:select property="strShelfTimeFormat" style="display: block;
    width: 100%;
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
    -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;">
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
					<html:option value="3">Year</html:option>
				</html:select>
	</div>
	<div class="col-sm-3">Remark</div>
	<div class="col-sm-3">
		<textarea rows="2" cols="20" name="strRemarks" class="form-control" style="height:38px;"></textarea>
	</div>
	</div>
</div>
<hr>
   <div class="row rowFlex reFlex">
							<div class="col-sm-9"></div>
							<div class="col-sm-3" align="right">
								<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>&nbsp;Fields Mandatory
							</div>
						</div>
	

	<table class="table" align="center" cellspacing="1px" style="display:none;">   
	<tr class="thead">
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
		<%-- <tr>
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
			</tr> --%>
			
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
	<table class="table" align="center" cellspacing="1px" cellpadding="1px" style="display:none;">
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
		<table class="table">	
			<tr>
				<td scope="col" style="font-weight:350 !important ;font-size: 16px !important;">Whether Assets</td>
				<td scope="col" style="font-weight:350 !important ;font-size: 16px !important;">
					<html:checkbox property="strAssetsReq" name="genericitemBean" value="1"></html:checkbox>
				</td>
			</tr>
			<tr>
				<td scope="col" style="font-weight:350 !important ;font-size: 16px !important;">Depreciation Cost<font color="red">*</font></td>
				<td scope="col" style="font-weight:350 !important ;font-size: 16px !important;">
					<input type="text"  class="form-control" placeholder="%" name="strDepreciationcost" onkeypress="return validateData(event,7);" maxlength="6">
				</td>
			</tr>
		</table>
	</div>
	
	<table class="table" align="center" cellspacing="1px" style="display: none;">		
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
	<table class="table" align="center" cellspacing="1px" cellpadding="0px" style="display: none;">
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
	<table class="table" align="center" cellspacing="1px" cellpadding="0px" style="display:none;">		
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
	<table class="table" align="center" cellspacing="1px" cellpadding="0px" style="display:none;">
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
		
	<table cellspacing="1px" class="table" align="center" style="display:none;">
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
	<table cellspacing="1px" class="table" align="center" style="display:none;">
		<tr class="FOOTER">
		<td colspan="4" width="25%"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table  class="table" align="center" cellspacing="1px" style="display:none;">
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
	</div>
	</div>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>