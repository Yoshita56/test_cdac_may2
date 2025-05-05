<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title>Update Stock Status </title>

<!-- CSS -->
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">

<!-- JS -->
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="JavaScript" src="../js/dwh_main_updateStockStatus_trans.js"></script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}
.container{
	max-width:1395px;
}
.table th, .table td {
	padding: 0.05rem;
}
.form-control {
	color: rgba(0, 0, 0, 1);
}
.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(0, 0, 0, 1);
}
.table .thead-dark {
	  	color: #000 !important;
	  	border: none !important;
	  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
		}
	.thead-dark th{
		background:none !important;
		border: none !important;	
		padding: 0.25rem;
		text-align:center;
	}

.prescriptionTile {
	margin: 1.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(0, 0, 0, 1);
}
.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}
.row {
	padding-bottom: 5px;
}

.legend2 {
	position: absolute;
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
}
.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
}
.btn-circle {
	width: 37px;
	height: 34px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 17px;
	color: white;
	float: right;
}
.iround {
	color: white;
	font-size: 16px;
}
.btn-outline-success {
	color: #28a745;
	border-color: #28a745;
	background-color: #28a745;
}
</style>

</head>
<body >
<html:form name="updateStockStatusTransFB" action="/transactions/UpdateStockStatusTransCNT" type="mms.transactions.controller.fb.UpdateStockStatusTransFB">
	
	<div id="errMsg"     class="errMsg"     style="font-size:16px;"><bean:write name="updateStockStatusTransFB" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:16px;"><bean:write name="updateStockStatusTransFB" property="strWarningMsg" /></div>
	<div id="normalMsg"  class="normalMsg"  style="font-size:16px;"><bean:write name="updateStockStatusTransFB" property="strNormalMsg" /></div>

	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		    <tr class="HEADER">
				<td colspan="3"></td>
				 <td colspan="1" align="right" >
			     	<span>
			     		<html:checkbox property="strViewMode" name="updateStockStatusTransFB" value="3" onclick="openViewPage();">View</html:checkbox>
			     	</span>
			     </td>	
			</tr>
		
		    <tr>
				<td width="25%" class="LABEL">
				<font color="red">*</font>Store Name
				</td>
				<td width="25%" class="CONTROL">
					<select name="strStoreId" class='comboMax' onchange="getItemCategory();">
							<bean:write name="updateStockStatusTransFB" property="strDrugWareHouseNameCmb" filter="false" />
					</select>
				</td>
				
				<td  width="25%" class="LABEL">
					<font color="red">*</font>Item Category
				</td>
				<td width="25%" class="CONTROL">
					<div id="itemCategoryDivId">
						<select name="strItemCategoryId" class='comboMax' onchange='getDrugCombo();'>
							<bean:write name="updateStockStatusTransFB" property="strItemCatgCmb" filter="false" />
						</select>
					</div>
				</td>		
		    </tr>
	   
		  	<tr>
				<td width="25%" colspan="1" class="LABEL">Group Name</td>
				<td width="25%" colspan="1" class="CONTROL">
				<div id="strGroupDivId" >
					<select name="strGroupId" class="comboMax" onchange="getDrugCombo();">
						<bean:write name="updateStockStatusTransFB" property="strGroupCombo" filter="false"/>
					</select>
				</div>				
				</td>
			
				<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Item/Drug Name</td>
				<td width="25%" colspan="1" class="CONTROL">
					<div id="strDrugDivId" >
						<select name="strDrugId" class="comboMax" >
							<option value="0">Select Value</option>
						</select>
					</div>
				</td>
			</tr>
		
			<tr>
				<td width="100%" colspan="4" class="CONTROL">
					<div id="s" align="center"><img style="cursor: pointer; " title="Get Details" src="../../hisglobal/images/Go.png" onclick="return getCurrentStockDetails();"/></div>
				</td>
			</tr>	
	 	</table>  --%>
	   
    <div class="container-fluid">
    		<div class="prescriptionTile" align="center">
    			<div class="row ">
						<div class="col-sm-6" style="text-align: initial;">
							<p class="subHeaders">

								<i class="fas fa-file-alt iround"
									style="font-size: 20px; color: #28a745" title=""></i>
								&nbsp; Update Stock Status
							</p>
						</div>
						
						<div class="col-sm-6" id="">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button" class="float-right btn btn-primary mt-1 btn-circle " title="View" onclick="openViewPage();">
									<i class="fas fa-eye iround" title="View"></i>
								</button>
								<button type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" title="Cancel" onClick="cancelFunc()" onkeypress="if(event.keyCode==13) cancelFunc()">
									<i class="fas fa-times fa-lg iround" title="Cancel"></i>
								</button>
								<button type="button" class="float-right btn btn-secondary btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear"name="clearImg" onclick="document.forms[0].reset(),clearMsg('INITVAL')" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
									<i class="fas fa-broom fa-lg iround" title="Clear"></i>
								</button>
								<button type="button" id="saveid" class="float-right btn btn-outline-success mt-1 btn-circle savebtn" tabindex='2' onclick="return validate1();" onkeypress="if(event.keyCode==13) validate1();">
									<i class="fa fa-download fa-beat iround" title="Save "></i>
								</button>
								
							</div>
						</div>
				</div>
					
				<div class="container">
					<div class="row">	
						<div class="col-sm-3">
							<label><font color="red">*</font>Store Name</label>
						</div>
						<div class="col-sm-3">
							<select name="strStoreId" class="browser-default custom-select" onchange="getItemCategory();">
									<bean:write name="updateStockStatusTransFB" property="strDrugWareHouseNameCmb" filter="false" />
							</select>
						</div>	
						
					   <div class="col-sm-3">
							<label><font color="red">*</font>Item Category</label>
					   </div>
							
						<div class="col-sm-3">
							<div id="itemCategoryDivId">	
									<select name="strItemCategoryId" class="browser-default custom-select" onchange='getDrugCombo();'>
										<bean:write name="updateStockStatusTransFB" property="strItemCatgCmb" filter="false" />
									</select>
							</div>
						</div>			
					</div>
					
					<div class="row">	
						<div class="col-sm-3">
							<label><font color="red">*</font>Group Name</label>
						</div>
						
						<div class="col-sm-3">
							<select name="strGroupId" class="browser-default custom-select" onchange="getDrugCombo();">
									<bean:write name="updateStockStatusTransFB" property="strGroupCombo" filter="false"/>
							</select>
						</div>	
						
						<div class="col-sm-3">
							<label><font color="red">*</font>Item/Drug Name</label>
						</div>
						<div class="col-sm-3">
							<div id="strDrugDivId" >
									<select name="strDrugId" class="browser-default custom-select" >
										<option value="0">Select Value</option>
									</select>
							</div>
						</div>
					</div>
					
					<div class="row my-4">
						<div class="col" align="center"> 
							<a class="btn btn-sm btn-success" href="#" title="Get Details" onclick="return getCurrentStockDetails();" onkeyup="goFuncOnEnter(event);" style="font-size:1rem;">
							GO 
							<i class="fas fa-angle-double-right"></i>
							</a>
						</div>
					</div>
				</div>
				
				<div id="strCurrentStockDtlDivId" ></div>	
	   	
	 	<hr>

             
		<div id="stockDtlsDivId" >
		 	<div class="row mt-2">
				<div class="col-sm-12" style="font-weight: 600; font-size:large; text-align : left">
					<p class="subHeaders">
						<i class="fas fa-file-alt iround"
							style="font-size: 20px; color: #28a745" title=""></i>
						&nbsp;New Stock Status Details
					</p>
				</div>
			</div>
		</div>
		
		<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		     <tr id="stockDtlsDivId" class="HEADER">
		     	<td colspan="4">New Stock Status Details</td>
			</tr>
			<tr>
				<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>New Stock Status</td>				
				<td  class="CONTROL" width="25%" colspan="1">
					<div id="stockStatusComboDivId">
						<select name="strNewStockStatus" class="comboNormal">
							<option value="0">Select Value</option>
						</select>
					</div>
				</td>
				
				<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Whether Update New Status In All DWH</td>
				<td class="CONTROL" width="25%" colspan="1" >				
					<input type="checkbox" name="strWhetherUpdateNewStatusInAllDWH"  onClick="chkBoxFunc(this);"  value="1" >				
				</td>
			</tr>
		</table>  -->
    
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<label><font color="red">*</font>New Stock Status</label>
				</div>
				<div class="col-sm-3">
					<div id="stockStatusComboDivId">
						<select name="strNewStockStatus" class="browser-default custom-select">
							<option value="0">Select Value</option>
						</select>
					</div>
				</div>	
				
				<div class="col-sm-3">
					<label><font color="red">*</font>Whether Update New Status In All DWH</label>
				</div>
				<div class="col-sm-3">
					<input type="checkbox" name="strWhetherUpdateNewStatusInAllDWH"  onClick="chkBoxFunc(this);"  value="1" readonly>				
				</div>	
			</div>
			
	  <!--<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		      <tr id="showQtyDiv" style="display:none;">
			   	 <td width="25%" colspan='1' class="LABEL">Qty</td>
		         <td width="25%" colspan='1' class="CONTROL">
		         	<input type="text" name="strQty" maxlength="9"  id="strQtyId"   readonly/>
		         </td>
		         <td width="75%" colspan='3' class="LABEL"></td>     
		   	</tr>
		  </table>  -->
	
	   		<div id="showQtyDiv" style="display:none;">
	   			<div class="row">
		   			<div class="col-sm-3">
						<label><font color="red">*</font>Qty</label>
					</div>
					
					<div class="col-sm-3">
						<input type="text" class="form-control" name="strQty" maxlength="9"  id="strQtyId" readonly>
					</div>
					<div class="col-sm-6"></div>
				</div>	
			</div>
			
			  <!--  <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
				<tr>
					<td class="LABEL" width="25%" colspan="1" ><font color="red">*</font>Approved By</td>
					
					<td class="CONTROL" width="25%" colspan="1" >
						<div id="approvedByComboDivId">
							<select name="strApprovedBy" class="comboNormal" onchange="checkValCombo();">
								<option value="0">Select Value</option>
							</select>
						</div>
					</td>		
				
					<td class="CONTROL" width="25%" id='labelId'>
		            	<div id='labelNameId'></div>
		  			 </td>
					
					 <td class="CONTROL" width="25%">
		            	<div id="nameOtherFld" style="display: none">
		            		<input type='text' name='strApprovedByOther' value='' onkeypress='return validateData(event,16);' maxlength='50'>
		            	</div>
		           </td>
				</tr>
				
				 <tr>
				    <td width="25%" class ="LABEL" valign="middle" colspan="1"><font color="red">*</font>Reason To Update Status</td>
				    <td width="25%" class ="CONTROL" colspan="1">
					    <textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea>
				    </td>
				    <td width="50%" class ="CONTROL" colspan="2">
			 	 </tr>
			</table> -->
    
		<div class="row">
			<div class="col-sm-3">
				<label><font color="red">*</font>Approved By</label>
			</div>
			<div id="approvedByComboDivId" class="col-sm-3">
				<select name="strApprovedBy" class="browser-default custom-select" onchange="checkValCombo();">
					<option value="0">Select Value</option>
				</select>
			</div>
	
			<div class="col-sm-3"  id="labelId">
		         <div id='labelNameId' ></div>
			</div>
			<div class="col-sm-3" id="nameOtherFld" style="display: none">
	        	<input type='text' class="form-control" name='strApprovedByOther' value='' onkeypress='return validateData(event,16);' maxlength='50'>
	        </div>
        </div>
        
      	<div class="row">
			<div class="col-sm-3">
				<label><font color="red">*</font>Reason To Update Status</label>
			</div>
			<div class="col-sm-9">
				<textarea class="form-control" name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea>
			</div>	
		</div>
		
		<div class="row" >
			<div id="mandaFieldsId" class="col-sm-12 text-right">
				<div> <font color='red'>*</font> Mandatory Fields </div>
			</div>
		</div>
	</div>
	
		 
<!--  <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	 </table> -->
	
	
<!-- 	<table  class="TABLEWIDTH" align="center">
		  <tr>
			<td align="center">
				  <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" onkeypress="if(event.keyCode==13) validate1();"/>
	              <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="document.forms[0].reset(),clearMsg('INITVAL')" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
	              <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage()" onkeypress="if(event.keyCode==13) cancelPage()" />              
			</td>
		 </tr>
		</table> -->	

				<input type="hidden" name="hmode"/>
				
				<input type="hidden" name="strStoreName" value=""/>
				<input type="hidden" name="strItemCategoryName" value=""/>
				<input type="hidden" name="strItemCategoryCode" value=""/>
				<input type="hidden" name="strCurrentDate" value="${updateStockStatusTransFB.strCurrentDate}" />
				<input type="hidden" name="strHiddenValues" value="0" />
				<input type="hidden" name="strIndex" value="" />
				<input type="hidden" name="strChkValue" value="0" />

		</div>
</div>

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>