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
<title>Store Item Master Modify</title>

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
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
 type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<style type="text/css">
select{

padding: 0.175rem 1.75rem 0.375rem 0.75rem;
font-weight: 400;
color: #495057;
vertical-align: middle;
background: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 4 5'%3e%3cpath fill='%23343a40' d='M2 0L0 2h4zm0 5L0 3h4z'/%3e%3c/svg%3e") no-repeat right 0.75rem center/8px 10px;
    background-color: rgba(0, 0, 0, 0);
background-color: rgba(0, 0, 0, 0);
background-color: #fff;
border: 1px solid #ced4da;
border-radius: 0.25rem;
-webkit-appearance: none;
-moz-appearance: none;
appearance: none;
}
</style>

<script language="javaScript">

function validate1(){   


     
      var hisValidator = new HISValidator("StoreItemBean");
              
			
			//hisValidator.addValidation("strItemShortName", "req", "Drug Short Name is a Mandatory Field" );
            hisValidator.addValidation("strItemId", "dontselect=0","Please select an Item Name " );
            hisValidator.addValidation("strItemBrandId", "dontselect=0","Please select an Brand Name " );
            if(document.forms[0].storeLevel.value=='1') 
            { hisValidator.addValidation("strForeCast", "req", "ForeCast is a Mandatory Field" );
            hisValidator.addValidation("strForeCast", "numltet=100", "Forecast should be less than or equal to 100%" );
            }
            
            if(document.forms[0].storeLevel.value=='1') 
            { hisValidator.addValidation("strReservedQty", "req", "Reserved Qty is a Mandatory Field" );
            hisValidator.addValidation("strReservedQty", "numlt=100", "Reserved Qty should be less than 100%" );
            }
             hisValidator.addValidation("strToleranceLimit", "req", "Tolerance Limit is a Mandatory Field" );
            hisValidator.addValidation("strToleranceLimit", "numltet=100", "Tolerance Limit cannot be greater than 100%" );
           
            hisValidator.addValidation("strReorderQty", "req", "Reorder Level is a Mandatory Field" );
            hisValidator.addValidation("strReorderQty", "amount=9,2", "Reorder Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strMaxQty", "req", "Maximum Level is a Mandatory Field" );
            if(parseInt(document.forms[0].strMaxQty.value)<parseInt(document.forms[0].strReorderQty.value)){
             	alert("Maximum Level must be greater than Reorder Level");
             	return false;
             }
            hisValidator.addValidation("strMaxQty", "amount=9,2", "Maximum Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
           // hisValidator.addValidation("strLevelUnitId", "dontselect=0","Please select an Level unit " );
             
        //    hisValidator.addValidation("strReorderQty", "numltet=document.forms[0].strReservedQty.value", "Reorder Qty should be less than or equal to Reserved Qty" );
            
         	 hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			 var retVal = hisValidator.validate();  
			 hisValidator.clearAllValidations(); 
    
    	   if(retVal){
    	  
          				 document.forms[0].hmode.value = "UPDATE";
                        document.forms[0].submit();
            }else{
					return false;
				 }
    }

function BrandCombo()
{ 

	 var url;
	 var mode = 'BRANDNAME';   
	 url="StoreItemMstCNT.cnt?hmode=BRANDNAME&ItemId="+document.forms[0].strItemId.value+"&combo="+document.forms[0].strStoreId.value;
	  ajaxFunction(url,"1");
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
				objVal= document.getElementById("Brand");
				objVal.innerHTML = "<select class='comboNormal' name ='strItemBrandId' >" + res + "</select>";
				}
		 }
}

function firstOnLoad()
{

if(document.forms[0].IsIssuable.value == '1')
document.forms[0].strIssueableFlag.checked=true;

if(document.forms[0].IsReturnable.value == '1')
document.forms[0].strIsReturnable.checked=true;
}	
</script>

</head>
<body onLoad="firstOnLoad();">
<html:form name="StoreItemBean" action="/masters/StoreItemMstCNTNEW"
	type="mms.masters.controller.fb.StoreItemMstFB">
	<html:hidden name ="StoreItemBean" property="strGroupId"></html:hidden>
	<html:hidden name ="StoreItemBean" property="strSubGroupId"></html:hidden>
	<!--<html:hidden name ="StoreItemBean" property="strItemId"></html:hidden>
	<html:hidden name ="StoreItemBean" property="strItemBrandId"></html:hidden>-->
<CENTER>
	<div class="errMsg"><bean:write name="StoreItemBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="StoreItemBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="StoreItemBean"
		property="strMsg" /></div>
</CENTER>
<div class="viewport" id="nonPrintable">
			<div class="container-fluid">

			<div class="row justify-content-center">
					<div class="col-sm-12">
						<br>
						<div class="prescriptionTile">
					
							<div class="row rowFlex reFlex">
								<div class="legend2" id='nonPrintableLegend2'>
									<button type="button"
										class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
										onclick="cancel('LIST');">
										<i class="fas fa-ban iround" title="Cancel"></i>
									</button>
									
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
										<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Store Item Mapping Master<i class="fas fa-angle-double-right"></i>&nbsp; Modify	
									</p>
									
							</div>
							</div>
							
							<div class="row rowFlex reFlex">
		<div class="col-md-2">Store Name</div>
		<div class="col-md-2" style="color:blue;"><bean:write name="StoreItemBean"
				property="strStoreName" filter="false" /></div>
		<div class="col-md-2">Item Category</div>
		<div class="col-md-2" style="color:blue;"><bean:write name="StoreItemBean"
				property="strItemCategoryName" filter="false" /></div>
		<div class="col-md-2">Group Name</div>
		<div class="col-md-2" style="color:blue;"><bean:write name="StoreItemBean"
				property="strGroupName" filter="false" /></div>
	
	</div>
	
	<div class="row rowFlex reFlex">
		<div class="col-md-2">Sub Group Name</div>
		<div class="col-md-2" style="color:blue;"><bean:write name="StoreItemBean"
				property="strSubGroupName" filter="false" /></div>
		<div class="col-md-2">Generic Item Name</div>
		<div class="col-md-2" style="color:blue;"><bean:write name="StoreItemBean"
				property="strItemName" filter="false" /></div>
		<div class="col-md-2">Item Name</div>
		<div class="col-md-2" style="color:blue;"><bean:write name="StoreItemBean"
				property="strItemBrandName" filter="false" /></div>
	
	</div>
	
	<div class="row rowFlex reFlex">
		<div class="col-md-2"><font color="red">*</font>VED Category Unit</div>
		<div class="col-md-2"><html:select name="StoreItemBean" property="strVEDCategory" >
				<html:option value="1">V</html:option>
				<html:option value="2">E</html:option>
				<html:option value="3">D</html:option>
			</html:select>
				
				</div>
				<logic:equal name="StoreItemBean" property="strStoreLevel" value="1">
		<div class="col-md-2"><font color="red">*</font>Fore Cast (%)</div>
		<div class="col-md-2"><input type="text" class="form-control"
					name="strForeCast" maxlength="3" value="${StoreItemBean.strForeCast}"
					onkeypress="return validateData(event,5);"></div>
		</logic:equal>
	
	</div>
	
							
	

	<%-- <logic:equal name="StoreItemBean" property="strStoreLevel" value="1">
		<TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
				<td width="50%" class="LABEL"><font color="red">*</font>Fore
				Cast</td>
				<td width="50%" class="CONTROL"><input type="text" class="txtFldNormal"
					name="strForeCast" maxlength="3" value="${StoreItemBean.strForeCast}"
					onkeypress="return validateData(event,5);"><b> %</b></td>
			</tr>
		</TABLE>
	</logic:equal> --%>
	
	<div class="row rowFlex reFlex">
		<div class="col-md-2"><font color="red">*</font>Reserved Qty (%)</div>
		<div class="col-md-2"><input type="text" class="form-control"
					name="strReservedQty" maxlength="2" value="${StoreItemBean.strReservedQty}"
					onkeypress="return validateData(event,5);"></div>
		<div class="col-md-2"><font color="red">*</font>Tolerance Limit (%)</div>
		<div class="col-md-2"><input type="text" class="form-control"
					name="strToleranceLimit" maxlength="3" value="${StoreItemBean.strToleranceLimit}"
					onkeypress="return validateData(event,5);"></div>
		<div class="col-md-2"><font color="red">*</font>Reorder Level</div>
		<div class="col-md-2"><input type="text" class="form-control"
				name="strReorderQty" maxlength="10" value="${StoreItemBean.strReorderQty}"
				onkeypress="return validateData(event,7);"></div>
	
	
	
	</div>
	

	<div class="row rowFlex reFlex">
		<div class="col-md-2"><font color="red">*</font>Max Level</div>
		<div class="col-md-2"><input type="text" class="form-control"
				name="strMaxQty" maxlength="11" value="${StoreItemBean.strMaxQty}"
				onkeypress="return validateData(event,7);"></div>
		<div class="col-md-2"><font color="red">*</font>Max Indent Qty</div>
		<div class="col-md-2"><input type="text"
				name="strMaxIndentQty" maxlength="11" value="${StoreItemBean.strMaxIndentQty}" class="form-control"
				onkeypress="return validateData(event,7);"></div>
		
	</div>
		<div class="row rowFlex reFlex">
		<div class="col-md-2">Is Issueable</div>
		<div class="col-md-2"><input name="strIssueableFlag"
				type="checkbox" value="1"></div>
		<div class="col-md-2">Is Returnable</div>
		<div class="col-md-2"><input name="strIsReturnable"
				type="checkbox" value="1"></div>
		<div class="col-md-2">Record Status</div>
		<div class="col-md-2"><html:radio name="StoreItemBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="StoreItemBean" property="strIsValid" value="2">Inactive</html:radio></div>
		
	</div>
	 
		
	<div class="row rowFlex reFlex">
		<div class="col-md-2"><font color="red">*</font>Effective From</div>
		<div class="col-md-2"><bean:write name="StoreItemBean" property="strEffectiveFrom" /></div>
		<div class="col-md-2">Remarks if Any</div>
		<div class="col-md-6"><textarea name="strRemarks"
				cols="25" class="form-control" rows="2"><bean:write name="StoreItemBean" property="strRemarks"/></textarea></div>
		
	</div>
	<hr>
	<div class="row">
		<div class="col-md-12" align="right"><font size="2" color="red">*</font> Mandatory Fields</div>
	</div>

<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; " title="Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> 
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" 
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>-->
	
	<input type="hidden" name="hmode" />
	 <input type="hidden" name="chk" value="${StoreItemBean.strChk1 }">
	<input type="hidden" name="strStoreId"
		value="${StoreItemBean.combo[0]}">
		
	<input type="hidden" name="storeLevel"
		value="${StoreItemBean.strStoreLevel}"> 
		
	<input type="hidden" name="strStoreName"
		value="${StoreItemBean.strStoreName}">
		
	<input type="hidden" name="IsIssuable"
		value="${StoreItemBean.strIssueableFlag}">
		
	<input type="hidden" name="IsReturnable"
		value="${StoreItemBean.strIsReturnable}">
	
	<input type="hidden" name="comboValue"
		value="${StoreItemBean.strComboValue}">
		
		<input type="hidden" name="strItemShortName"	value="${StoreItemBean.strItemShortName}">
		
		<input type="hidden" name="strCategoryNo"
		value="${StoreItemBean.strCategoryNo}"> 
	<input type="hidden" name="strEffectiveFrom"
				value="${StoreItemBean.strEffectiveFrom}">
	<cmbPers:cmbPers />
	</div>
	</div>
	</div>
	</div>
	</div>
	
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>