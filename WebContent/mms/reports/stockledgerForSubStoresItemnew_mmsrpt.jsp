 <%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!--
 * Developer : Vivek Agarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
-->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>Stock Ledger Items</title>
<!-- CSS -->
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	


<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .multiRPTControl1 {
			    background-color: #D8D8D8;
			    color: #000000;
			    font-family: Verdana,Arial,Helvetica,sans-serif;
			    font-size: 10px;
			    font-style: normal;
			    font-weight: normal;
			    height: 12px;
			    text-align: center;
			}
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
			
			
</style>

<!-- JS -->
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!-- EXT JS -->
<script language="Javascript" src="../../mms/js/stockledgerForSubStoresItemNew_mmsrpt.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js"></script>
<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js""></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<script type="text/javascript">

/**
 * 
 */
function printItemDetailedStockLedgerReport(obj)
{	  
    	  //alert(obj.value);
         
         /* Value Pass in Web Row Set
		  1.	TRANS_DATE
		  2.	PARTICULARS	
		  
		  3.	ACTIVE_ISSUE	
		  4.	INACTIVE_ISSUE	
		  5.	QUARTINE_ISSUE
		  	
		  6.	ACTIVE_REC	
		  7.	INACTIVE_REC	
		  8.	QUARTINE_REC
		  	
		  9.	STR_NAME	
		  10.	ITEM_NAME	
		  11.	HSTSTR_BATCH_SL_NO

          	 */    	  	 
	 	
	    	
	   
	   var previousParameters = document.getElementsByName("strHiddenParameter")[0].value;
	   
	   
	   var storeId 		= 	previousParameters.split("^")[0];  	
	   var itemBrandId  = 	previousParameters.split("^")[1]; 
	   var batchNo 		=	previousParameters.split("^")[4];
	   var fromDate		=	previousParameters.split("^")[2];
	   var toDate		=	previousParameters.split("^")[3];
	   var storeName	=	previousParameters.split("^")[6]; 
	   
	   var op_balance	=	previousParameters.split("^")[5];
	   var batchFlg     = 	previousParameters.split("^")[8];
	 	 var mode="printDetailedStockLedgerReport";
		var url="StockLedgerForSubStoresRptItemNewCNT.cnt?hmode="+mode+
			"&storeId="+storeId+
			"&itembrandId="+itemBrandId+
			"&batchNo="+batchNo+
			"&fromDate="+fromDate+
			"&toDate="+toDate+
			"&storeName="+storeName+			
			"&openingBalanceActive="+op_balance.split("#")[0]+
			"&openingBalanceInActive="+op_balance.split("#")[1]+
			"&openingBalanceQuarantine="+op_balance.split("#")[2]+
			"&batchFlg="+batchFlg;								
	
	//window.close(); 
	
	window.open(url, "popupWindow",	"width=1000,height=600,top=250,left=100,scrollbars=yes");
	
}

</script>

</head>

<body onload="onLoadPage();hideMenuFrame();" class="background">
<html:form action="/reports/StockLedgerForSubStoresRptItemNewCNT" method="post" styleClass="formbg">
	
<div class="errMsg" id="errMsg"><bean:write name="stockLedgerForSubStoresRptItemNew" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="stockLedgerForSubStoresRptItemNew" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="stockLedgerForSubStoresRptItemNew" property="strWarningMsg"/></div>
	
	
	<div class="container-fluid">
		<div class="prescriptionTile">
			<fieldset>
			<legend class='legendHeader' id='itemManageMinusId' style='font-size: 16px;font-weight: bold;'><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Stock Ledger</legend>
					<div class="container" >
				<!-- <div id="itemManagePlusId" align="left" style="display: none;"> Stock Ledger
					<div id="storeDtlsDivId"></div>
				</div>
				
				<div id="itemManageMinusId" style="display: block;" align="left"> Stock Ledger</div>
	 -->
	 			<hr>
				<div class="row my-2" id="itemManageDtlId1">
					<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
					<div class="col-sm-2" id="storeDivId">
						<select name="strStoreId" id="storeDivId1" class='custom-select ' onchange="getItemCatCmb();"> 
							<bean:write name="stockLedgerForSubStoresRptItemNew" property="strStoreValues" filter="false" />
						</select>
						<div id="storeNameDivId" style="display: none;"></div>
					</div>
			
					<div class="col-sm-2"><label>Category<font color="red">*</font></label></div>
					<div class="col-sm-2" id="catDivId">
						<select name="strItemCatId"  class="custom-select " onchange='getGroupName();'>
							<bean:write name="stockLedgerForSubStoresRptItemNew" property="strCatCombo"	filter="false" />
							<option value="0">Select Value</option>
						</select>					
					</div>
	
					<div class="col-sm-2"><label>Group Name<font color="red">*</font></label></div>
					<div class="col-sm-2" id="groupDivId">
					<select name="strGroupId"  id="strGroupId1" class="custom-select " onchange='getDrugName();'>
						<bean:write name="stockLedgerForSubStoresRptItemNew" property="strGroupCombo"	filter="false" />
						<option value="0">Select Value</option>
					</select>					
					</div>		
					
					<div id="DrugNameId" style="display:none; color:blue;font-weight:bold"></div>
				</div>
				
				<hr>
	
				<div id="itemManageDtlId2" style="display: block">	
					<div class="legendHeader"  style='font-size: 16px;font-weight: bold; align:left;'>Item name</div>
					
					<div class='table-responsive'> 
						<table class="TABLEWIDTH" align="center"  cellpadding="1px" cellspacing="1px">	
						<tr>
							<td class="LABEL" width="25%" colspan="1"></td>
				 			
				 			<td class="CONTROL" colspan="1" width="25%">  			 
								<div id="LeftItemIds" align="left">
									<select id="strLeftItemIds" name="strLeftItemIds" size="10" multiple style="width: 560px" onChange='showSelection(this);' >
										<bean:write name="stockLedgerForSubStoresRptItemNew" property="strLeftItemList" filter="false"/>
									</select>
								</div>				
							</td>
							
							<td width="10%" class="CONTROL" colspan="1" align="left">			
							<div style='display:inline;'>
									<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftListTransfer();">
								<center>
							<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" style="display: none;"
								align="middle" onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);"/></center>
							<br/>
									
							<img src="../../hisglobal/images/backward.gif" width="30" height="21" style="display: none;"
								onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);">
						
								<img src="../../hisglobal/images/back3.gif" width="30" height="21" 
									onclick="transferToLeft();"/>
							</div>
							</td>			
							
							<td class="CONTROL" colspan="3">
							<div id="RightItemIds" align="left" style='display:inline;'>
									<select id="strRightItemIds" name="strRightItemIds" size="10" multiple style="width: 560px">
										<bean:write name="stockLedgerForSubStoresRptItemNew" property="strRightItemList" filter="false"/>
									</select>
								</div>
							</td>		
						</tr>		
						</table>
					</div>
					
					<div class='table'> 
						<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
						<tr>	
							<td class="LABEL" width="25%"></td>
							<td class="CONTROL"  width="75%"><div id="txtFromLeftMutltiSelectCombo" style="display:none;  color:blue;font-weight:bold "></div></td>
						</tr>
						</table>
					</div>
					
					<div class="legendHeader"  style='font-size: 16px;font-weight: bold; align:left;'>Other Detail(s)</div>
					
					<div class="row my-2">
						<div class="col-sm-2"><label>Batch No. Wise<font color="red">*</font></label></div>
						<div class="col-sm-4 p-2">
							<html:checkbox property="strWhetherBatchWise" name="stockLedgerForSubStoresRptItemNew" value="1" >
							</html:checkbox>
						</div>
					
						<div class="col-sm-2"><label>Till Date(Entry)<font color="red">*</font></label></div>
						<div class="col-sm-4">
							<input name="strToDate" id="datepicker" class="form-control datepicker" value="${stockLedgerForSubStoresRptItemNew.strCurrentDate}" />	
							
						</div>
					</div>
					<div class="row my-2">
						<div class="col-sm-2"><label>Value Wise<font color="red">*</font></label></div>
						<div class="col-sm-4 p-2">
							<html:checkbox property="strValueWise" name="stockLedgerForSubStoresRptItemNew" value="1" >
							</html:checkbox>
						</div>
					
						<div class="col-sm-2"></div>
						<div class="col-sm-4"></div>
					</div>
					
					<div class="row my-2" id='generateId' align="center" >
			             <div class="col" id='id'>
			                 <button type="button" class="btn btn-success mt-1 btn-circle detailsbtn" title="Generate" onClick="return validate();"> 
		                         <div id="go-btn" class="popupToast" style="color: #fff;">
		                             <span class="popuptextToast" >Generate </span><i class="fas fa-angle-double-down"></i>
		                         </div>
			                 </button>
			             </div>
        			</div>
        			<hr>
				<div class="row" align="left"><i>Opening balance as on 1st April of Current Financial Year or Stock Ledger Initiation Date whichever is  later</i></div>
				</div> <!-- Ending <div id=itemManageDtlId2 -->
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${stockLedgerForSubStoresRptItemNew.strCurrentDate}"/>
<input type="hidden" name="strStoreName" value="${stockLedgerForSubStoresRptItemNew.strStoreName}" />
<input type="hidden" name="strItemBrandId" value="0" />
<input type="hidden" name="selPageIndex" value="1"/>
<input type="hidden" name="strJobInitialDate" value="${stockLedgerForSubStoresRptItemNew.strJobInitialDate}"/>
			</div>
			</fieldset>
		</div>
	</div>
	
	<div class="container-fluid">
		<div id="showButtonID" class="prescriptionTile" style="display:none;">
			<div id="stockLedgerDetailDivId" class='table-responsive my-2' style="display:block;"></div>
		
			<div class="container">
				<br>
				<!-- <div class="control_button"> -->
					<div class="row " style="display: flex; justify-content:center">
							<button type="button" title="Print" id="printButton" class="btn btn-primary mt-1 btn-icon printbtn mx-1" onClick="openViewPage();">	
									<div class="popupToast" style="color: #fff;">
										<i class="fas fa-print " title="Print"></i>
										<span class="popuptextToast">Print</span>
									</div>
							</button>	
						
							<button type="button" title="Clear" class="btn btn-secondary mt-1 btn-icon clearbtn mx-1"  onClick="clearPage();">	
								<div class="popupToast" style="color: #fff;">
									<i class="fas fa-broom" title="Clear"></i>
									<span class="popuptextToast">Clear</span>
								</div>
							</button>	
					</div>
					<br>	
					<hr>
					<div class="row" align="left"><i>Opening balance as on 1st April of Current Financial Year or Stock Ledger Initiation Date whichever is  later</i></div>	
			  <!--  </div> -->
		   </div>			
		</div>
	</div>	
	
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
