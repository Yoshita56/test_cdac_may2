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
<title>Store Item mapping Master</title>

<!-- added 20 April 2020 -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
	
	<!-- end -->


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
     
      var hisValidator = new HISValidator("StoreItemBean");
              
			hisValidator.addValidation("strGroupId", "dontselect=0","Please select a Group Name " );
			
            // Commented By Amit 23 - Dec - 2010 hisValidator.addValidation("strItemShortName", "req", "Drug Short Name is a Mandatory Field" );
            
            // hisValidator.addValidation("strItemId", "dontselect=0","Please select an Generic Drug Name " );
            if(document.forms[0].strItemId.value!='0')
            { 
               hisValidator.addValidation("strItemBrandId", "dontselect=0","Please select an Item Name " );
            }            
            if(document.forms[0].storeLevel.value=='1') 
            { 
               hisValidator.addValidation("strForeCast", "req", "ForeCast is a Mandatory Field" );
               hisValidator.addValidation("strForeCast", "numltet=100", "Forecast should be less than or equal to 100%" );
            }
            
            if(document.forms[0].storeLevel.value=='1') 
            { hisValidator.addValidation("strReservedQty", "req", "Reserved Qty is a Mandatory Field" );
            hisValidator.addValidation("strReservedQty", "numlt=100", "Reserved Qty should be less than 100%" );
            }
            
            hisValidator.addValidation("strToleranceLimit", "req", "Tolerance Limit is a Mandatory Field" );
            hisValidator.addValidation("strToleranceLimit", "numltet=100", "Tolerance Limit cannot be greater than 100%" );
           
            
            hisValidator.addValidation("strReorderQty", "req", "Reorder Level is a Mandatory Field" );
            hisValidator.addValidation("strMaxQty", "req", "Maximum Level is a Mandatory Field" );
            if(parseInt(document.forms[0].strMaxQty.value)<parseInt(document.forms[0].strReorderQty.value)){
             	alert("Maximum Level must be greater than Reorder Level");
             	return false;
             }
             hisValidator.addValidation("strMaxQty", "amount=9,2", "Maximum Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strReorderQty", "amount=9,2", "Reorder Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
         //   hisValidator.addValidation("strLevelUnitId", "dontselect=0","Please select an Level unit " );
             
           //  hisValidator.addValidation("strReorderQty", "numltet=document.forms[0].strReservedQty.value", "Reorder Qty should be less than or equal to Reserved Qty" );
            
         	 hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			 var retVal = hisValidator.validate(); 
    	
    	
          if(retVal){
          				 document.forms[0].hmode.value = "SAVE";
                        document.forms[0].submit();
            }else{
					return false;
				 }
    }

function BrandCombo()
{ 
	 var url;
	 var mode = 'BRANDNAME';   
	 var itemid = document.forms[0].strItemId.value;
	 if(itemid!='0')
	 {
	       var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "<font color='red'>*</font>Item Name";
	 }
	 else
	 {
	   var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "ItemName";
	 }
	 var temp = itemid.split('^');
	 url="StoreItemMstCNTNEW.cnt?hmode=BRANDNAME&ItemId="+temp[0]+"&combo="+document.forms[0].strStoreId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value;    
	 
	 ajaxFunction(url,"1");
}
function SubGroupCombo()
{	
	 var url;
	 var mode = 'SUBGROUPNAME';   
	 url="StoreItemMstCNTNEW.cnt?hmode=SUBGROUPNAME&GroupId="+document.forms[0].strGroupId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value+"&StoreId="+document.forms[0].strStoreId.value;     
	 
	 ajaxFunction(url,"2");
}

function ItemNameCombo()
{

	 var url;
	 var mode = 'ITEMNAME';   
	 url="StoreItemMstCNTNEW.cnt?hmode=ITEMNAME&GroupId="+document.forms[0].strGroupId.value+
	 "&SubGroupId="+document.forms[0].strSubGroupId.value+"&StoreComboId="+document.forms[0].strStoreId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value;     
	 ajaxFunction(url,"3");
}


function UnitCombo()
{

	 var url;
	 var mode = 'UNITCOMBO';   
	 var strItemId = document.forms[0].strItemId.value;
	
	
	if(strItemId == 0){
		
		document.forms[0].strLevelUnitId.value = 0;
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = "/";
		
	}else{
		 url="StoreItemMstCNTNEW.cnt?hmode=UNITCOMBO&strItemId="+strItemId; 
		 ajaxFunction(url,"4");
	 }
}

function reSetDiv()
{
           var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "<font color='red'>*</font>Item Name";

}



function getAjaxResponse(res,mode)
{
		var objVal;
		var objVal2;
		
		if(mode=="5")
		{   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR")
        		 {
         			err.innerHTML = temp1[1];	
        		 }
				else
				{
				   objVal= document.getElementById("Brand");
				   objVal.innerHTML = "<select class='browser-default custom-select' name ='strItemBrandId' >" + res + "</select>";
							
				}
		 }
	   if(mode=="1"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("Brand");
				objVal.innerHTML = "<select class='browser-default custom-select' name ='strItemBrandId' >" + res + "</select>";
				
				UnitCombo();
				
				
				}
		 }
		  if(mode=="2")
		  {   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				var temp = res.split("#");	
				
				objVal= document.getElementById("SubGroupDivId"); 
				objVal.innerHTML = "<select class='browser-default custom-select' name ='strSubGroupId' onChange='ItemNameCombo();'>" + temp[0] + "</select>";
				
				objVal2= document.getElementById("ItemNameDivId");
				objVal2.innerHTML = "<select name ='strItemId' class='browser-default custom-select' onchange='BrandCombo();' >" + temp[1] + "</select>";
				
				   objVal3= document.getElementById("Brand");
				   objVal3.innerHTML = "<select class='browser-default custom-select' name ='strItemBrandId' >" + temp[2] + "</select>";
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
				objVal.innerHTML = "<select name ='strItemId' class='browser-default custom-select' onchange='BrandCombo();'>" + res + "</select>";
				}
		 }
		 if(mode=="4"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				
				var vals = res.split("^");
				
				if(vals.length > 0){
				
				document.forms[0].strLevelUnitId.value = vals[0];
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = vals[1];
				}else{
				
				document.forms[0].strLevelUnitId.value = 0;
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = "/";
				
				}
				
				}
		 }
}

</script>

</head>
<body onLoad="">
<html:form name="StoreItemBean" action="/masters/StoreItemMstCNTNEW"
	type="mms.masters.controller.fb.StoreItemMstFB">
	
	
	<div class="viewport" id="nonPrintable">
			<div class="container-fluid">

			<div class="row justify-content-center">
					<div class="col-sm-12">
						<br>
						<div class="prescriptionTile">
						<div class="row rowFlex reFlex">
						<div class="col-md-12" align="center">
								<div id="errMsg" class="errMsg"><bean:write name="StoreItemBean" property="strErr" /></div>
								<div class="warningMsg"><bean:write name="StoreItemBean" property="strWarning" /></div>
								<div id="normalMsg" class="normalMsg"><bean:write name="StoreItemBean" property="strMsg" /></div>	
						</div>
						</div>
							<div class="row rowFlex reFlex">
								<div class="legend2" id='nonPrintableLegend2'>
									<button type="button"
										class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
										onclick="cancel('LIST');">
										<i class="fas fa-ban iround" title="Cancel"></i>
									</button>
									<button type="button" class=" btn btn-secondary btn-circle"
										onclick="document.forms[0].reset();"
										style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
										<img src="/HIS/hisglobal/images/clear3.png" title="Clear"
											style="width: 23px; color: #fff;">
									</button>
									<!-- <button  type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" onclick="transferToViewPageNEW();">
											<i class="fas fa-eye iround"  title="View"></i>
									</button> -->
									<button type="button" id="savebutton"
										class="float-right btn btn-outline-success mt-1 btn-circle"
										tabindex='2' onclick=' return validate1();'
										name="patientAdmissionModiTransBean"
										style="background-color: #5cb85c;">
										<i class="fa fa-download iround" title="Save"></i>
									</button>
								</div>
							</div>



					<div class="row rowFlex reFlex">
								<div class="col-sm-5">
									<p class="subHeaders" style="margin-bottom: 0;">
										<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Store Item Mapping Master<i class="fas fa-angle-double-right"></i>&nbsp;Add		
									</p>
									
							</div>
							</div>
	

	<div class="row rowFlex reFlex">
		<div class='col-md-2 px-4'>Store Name</div>
		<div class='col-md-4' style='color:blue;'><bean:write name="StoreItemBean"
				property="strStoreName" filter="false" /></div>
		<div class='col-md-2'>Item Category</div>
		<div class='col-md-4' style='color:blue'><bean:write name="StoreItemBean"
				property="strItemCategoryName" filter="false" /></div>
		
	</div>

	<div class="row rowFlex reFlex">
		<div class='col-md-2 px-4'><font color="red">*</font>Group Name</div>
		<div class='col-md-4'><div id="GroupDivId"><select name="strGroupId" class="browser-default custom-select"   onchange="SubGroupCombo();">
                        <bean:write name="StoreItemBean" property="strGroupNameCombo"
					filter="false" />
                 </select></div>
		
		</div>
		<div class='col-md-2'>Sub Group Name</div>
		<div class='col-md-4'><div id="SubGroupDivId"><Select name="strSubGroupId" class='browser-default custom-select'>
				<option value="0">Select Value</option>
			</Select></div></div>
		
	</div>
		
	<div class="row rowFlex reFlex">
		<div class='col-md-2 px-4'>Generic Item Name</div>
		<div class='col-md-4'><div id="ItemNameDivId"><select class="browser-default custom-select"  name="strItemId"
				onchange="BrandCombo();">
				<option value="0">Select Value</option>
			</select></div></div>
		<div class='col-md-2'><div id='mandatory'>Item Name</div></div>
		<div class='col-md-4'><div id="Brand"><select name="strItemBrandId"
				class="browser-default custom-select">
				<option value="0">All Value</option>
			</select></div></div>
		
	</div>
	
	<div class="row rowFlex reFlex">
		<div class='col-md-2 px-4'><font color="red">*</font>VED Category Unit</div>
		<div class='col-md-2'><select name="strVEDCategory"
				class="browser-default custom-select">
				<option value="2">E</option>
				<option value="1">V</option>
				
				<option value="3">D</option>
			</select></div>
		
		
	</div>
	<br>


<div class="row rowFlex reFlex">
		<logic:equal name="StoreItemBean" property="strStoreLevel" value="1">
		<div class='col-md-2 px-4'><font color="red">*</font>Fore Cast (%)</div>
		<div class='col-md-2'><input type="text"
					class="form-control" name="strForeCast" maxlength="3" value="10"
					onkeypress="return validateData(event,5);"></div>
		</logic:equal>
	
		
		<div class='col-md-2'><font color="red">*</font>Reserved Qty (%)</div>
		<div class='col-md-2'><input type="text"
				class="form-control" name="strReservedQty" maxlength="2" value="2"
				onkeypress="return validateData(event,5);"></div>
	
		<div class='col-md-2'><font color="red">*</font>Tolerance Limit (%)</div>
		<div class='col-md-2'><input type="text"
				class="form-control" name="strToleranceLimit" maxlength="3" value="10"
				onkeypress="return validateData(event,5);"></div>
	</div>


	<br>
	

	<div class="row rowFlex reFlex">
		<div class="col-md-12 px-4"><p class="subHeaders"><i class="fas fa-layer-group"></i>&nbsp;Level Details</p></div>
		<div class='col-md-2 px-4'><font color="red">*</font>Reorder Level</div>
		<div class='col-md-2'><input type="text"
				name="strReorderQty" maxlength="10" value="10" class="form-control"
				onkeypress="return validateData(event,7);"></div>
		
		
		<div class='col-md-2'><font color="red">*</font>Max Level</div>
		<div class='col-md-2'><input type="text"
				name="strMaxQty" maxlength="11" value="1000" class="form-control"
				onkeypress="return validateData(event,7);"></div>
	
		<div class='col-md-2'><font color="red">*</font>Max Indent Qty</div>
		<div class='col-md-2'><input type="text"
				name="strMaxIndentQty" maxlength="11" value="1000" class="form-control"
				onkeypress="return validateData(event,7);"></div>
				
		<div class="col-md-2 px-4" style="display:none;"><font color="red">*</font>Level Unit</div>
		<div class="col-md-2" style="display:none;"><div id="UnitDivId">/</div>
			<input type="hidden" name="strLevelUnitId" value=""></div>
		
	</div>
	
	<br>
	<div class="row rowFlex reFlex">
		<div class='col-md-2 px-4'>Is Issueable</div>
		<div class='col-md-2' align="left"><input name="strIssueableFlag"
				type="checkbox" value="1" checked></div>
		
		
		<div class='col-md-2'>Is Returnable</div>
		<div class='col-md-2' align="left"><input name="strIsReturnable"
				type="checkbox" value="1"></div>
	
		<div class='col-md-2'><font color="red">*</font>Effective From</div>
		<div class='col-md-2'><input  name="strEffectiveFrom"
											class="form-control datepicker"
											value="${StoreItemBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
	</div>
	<div class="row">			
		<div class="col-md-2 px-4">Remarks if Any</div>
		<div class="col-md-10"><textarea name="strRemarks"
				cols="25" class="form-control" rows="2"></textarea></div>
	</div>
	

<div class="row">
	<div class="col-md-12" align="right"><font size="2" color="red">*</font> Mandatory
			Fields</div>
</div>
	

	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreId"
		value="${StoreItemBean.combo[0]}">

	<input type="hidden" name="strCategoryNo"
		value="${StoreItemBean.combo[1]}">

	<input type="hidden" name="storeLevel"
		value="${StoreItemBean.strStoreLevel}">

	<input type="hidden" name="comboValue"
		value="${StoreItemBean.strComboValue}">

	<cmbPers:cmbPers />
	</div>
	</div>
	</div>
	</div>
	</div>
	
</html:form>
<tag:autoIndex></tag:autoIndex>
<script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>
</body>
</html>