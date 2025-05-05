<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>Location Wise Stock In Hand</title>

<style type="text/css">
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

<!-- CSS -->
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<!-- JS -->
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!-- EXT JS --> 
<script language="Javascript" src="../js/locationStockonhand_mmsrpt.js"></script>

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script>
	function onLoadCancelCheck() {
	
	var seatId= '<%=(String) request.getSession().getAttribute("SEATID")%>';
	if(seatId== "null")
	{
		document.getElementById('cancelBtn').style.display='none';
	}	
 }
</script>

</head>

<body class="background" onload="getStoreTypeDisplay();onLoadCancelCheck();">
<div id="mask"></div>
<div id="dvLoading"></div>
<html:form action="/reports/LocationWiseStockSummaryRptCNT" method="post" styleClass="formbg">

	<div class="errMsg" id="errMsg"><bean:write name="locationStockOnHandRpt" property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="locationStockOnHandRpt" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="locationStockOnHandRpt" property="strWarningMsg" /></div>

	<div class="container-fluid">
		<div class="prescriptionTile">
			<fieldset>
			<legend class='legendHeader' id='' style='font-size: 16px;font-weight: bold;'><i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Location Wise Stock In Hand</legend>
			<div class="container">

				<div class="row ">
					<div class="legend2" id='nonPrintableLegend2'>
							<!-- style="border-radius:50%; padding:12px" -->
						<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-icon printbstn" style="border-radius:50%; padding:12px 11px;" onClick="cancelPage();">	
							<div class="popupToast" style="color: #fff;">
								<i class="fas fa-times fa-lg" title="Cancel"></i>
							</div>
						</button>	
						<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon clearbtn" style="background-color: royalblue; border-radius:50%; padding:12px 7px;" onClick="onClickClear();">	
							<div class="popupToast" style="color:#fff;">
								<i class="fas fa-broom fa-lg" title="Clear"></i>
							</div>
						</button>	
						<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success mt-1 btn-icon savebtn" style="border-radius:50%; padding:12px 12px;" tabindex='2' onClick="return validateVital();"  data-toggle="" data-target="#previewModal" >
							<div class="popupToast" style="color: #fff;">
								<i class="fas fa-download" title="Generate"></i>
							</div>
						</button>
		  			</div>  
				</div>	
					
				<hr>	
				
				<div class="row my-2"  >
					<!-- <div id="districtDrugWarehouseDivId"> -->
					<div class="col-sm-1" ><label>Store Name<font color="red">*</font></label></div>
					<div class="col-sm-3" id="strStoreDivId">
						<select name="strDistrictStoreId"  id="strDistrictStoreId" class="custom-select" onchange="getStoreTypeCmb();">
							<bean:write name="locationStockOnHandRpt" property="strDistrictStoreValues" filter="false"/>
						</select>
					</div>
					<!-- </div> -->
											
					<div class="col-sm-1 "><label>Category<font color="red">*</font></label></div>
					<div class="col-sm-3">
						<select name="strCatgId"  id="strCatgId" class="custom-select" onchange="getLeftComboItems('$');">
							<bean:write name="locationStockOnHandRpt" property="strCatgCombo" filter="false"/>
						</select>	
					</div> 
					
					<div class="col-sm-1 "><label>Stock Status<font color="red">*</font></label></div>
					<div class="col-sm-3">	
						<select name="strStatusId" id="strStatusId" class="custom-select" onchange="" >
							<!-- <option title="All" selected="selected" value="0">All</option> -->
							<option title="Active" value="10">Active(Ready For Issue)</option>
						</select>
					</div>
				</div>
				
				<hr>
			
				<div class="row my-2" id="itemMultiSelectId">
	
					<div class="legendHeader col-sm-3"  style='font-size: 16px;font-weight: bold;'>Item name</div>
					
					<div class="legendHeader col-sm-9">
						<table class='TABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px" height="30px">
							<tr>
								<td	style="font-family: Verdana; height: 15px; font-weight: bold; font-style: normal;"
								colspan="3" align="center">
								<div id="divAtoZ" >
									<a href='#' id="$Id" class="class4" onclick="getLeftComboItems('$');" style="color:red"><b>(0-9)</b></a>&nbsp;
									<a href='#' id="AId" class="class4" onclick="getLeftComboItems('A');"><b>A</b></a>&nbsp; 
									<a href='#' id="BId" class="class4" onclick="getLeftComboItems('B');"><b>B</b></a>&nbsp; 
									<a href='#' id="CId" class="class4" onclick="getLeftComboItems('C');"><b>C</b></a>&nbsp; 
									<a href='#' id="DId" class="class4" onclick="getLeftComboItems('D');"><b>D</b></a>&nbsp;
									<a href='#' id="EId" class="class4" onclick="getLeftComboItems('E');"><b>E</b></a>&nbsp; 
									<a href='#' id="FId" class="class4" onclick="getLeftComboItems('F');"><b>F</b></a>&nbsp; 
									<a href='#' id="GId" class="class4" onclick="getLeftComboItems('G');"><b>G</b></a>&nbsp;
									<a href='#' id="HId" class="class4" onclick="getLeftComboItems('H');"><b>H</b></a>&nbsp; 
									<a href='#' id="IId" class="class4" onclick="getLeftComboItems('I');"><b>I</b></a>&nbsp; 
									<a href='#' id="JId" class="class4" onclick="getLeftComboItems('J');"><b>J</b></a>&nbsp; 
									<a href='#' id="KId" class="class4" onclick="getLeftComboItems('K');"><b>K</b></a>&nbsp;
									<a href='#' id="LId" class="class4" onclick="getLeftComboItems('L');"><b>L</b></a>&nbsp; 
									<a href='#' id="MId" class="class4" onclick="getLeftComboItems('M');"><b>M</b></a>&nbsp; 
									<a href='#' id="NId" class="class4" onclick="getLeftComboItems('N');"><b>N</b></a>&nbsp;
									<a href='#' id="OId" class="class4" onclick="getLeftComboItems('O');"><b>O</b></a>&nbsp; 
									<a href='#' id="PId" class="class4" onclick="getLeftComboItems('P');"><b>P</b></a>&nbsp; 
									<a href='#' id="QId" class="class4" onclick="getLeftComboItems('Q');"><b>Q</b></a>&nbsp; 
									<a href='#' id="RId" class="class4" onclick="getLeftComboItems('R');"><b>R</b></a>&nbsp;
									<a href='#' id="SId" class="class4" onclick="getLeftComboItems('S');"><b>S</b></a>&nbsp; 
									<a href='#' id="TId" class="class4" onclick="getLeftComboItems('T');"><b>T</b></a>&nbsp; 
									<a href='#' id="UId" class="class4" onclick="getLeftComboItems('U');"><b>U</b></a>&nbsp;
									<a href='#' id="VId" class="class4" onclick="getLeftComboItems('V');"><b>V</b></a>&nbsp; 
									<a href='#' id="WId" class="class4" onclick="getLeftComboItems('W');"><b>W</b></a>&nbsp; 
									<a href='#' id="XId" class="class4" onclick="getLeftComboItems('X');"><b>X</b></a>&nbsp; 
									<a href='#' id="YId" class="class4" onclick="getLeftComboItems('Y');"><b>Y</b></a>&nbsp;
									<a href='#' id="ZId" class="class4" onclick="getLeftComboItems('Z');"><b>Z</b></a>&nbsp; 
									<a href='#' id="@Id" class="class4" onclick="getLeftComboItems('@');"><b>All</b></a>&nbsp;  
								</div>
							</td>
							</tr>
						</table>
					</div>
				</div>
				
				<div class="row my-2" >
					<div class="legendHeader col-sm-3"  style='font-size: 16px;font-weight: bold;'> Search Item name</div>
					
					<div class="col-sm-9">
						<div id="drugNameDivId" style="display: none;">
							<select id="strDrugName" name="strDrugName" class="custom-select" >
								<bean:write name="locationStockOnHandRpt" property="strDrugSearchCombo" filter="false" />
							</select>
						</div>	
												
						<input type="text" class="form-control" id="strSearchDrug" name="strSearchDrug"/>
						
						<div id="DrugNameId" style="display: none;" ></div>	
						<div id="txtFromLeftMutltiSelectCombo" style="display:none; color:blue;font-weight:bold; text-align:left"></div>
					</div>
					
				</div>
				
				<div class="row table-responsive">
				   <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
						<tr>
				  			<td class="CONTROL" colspan="2">  			 
								<div id="leftItemDivId" align="right">
									<select id="strLeftItemFilterIds" name="strLeftItemFilterIds" size="6" multiple style="width: 280px" onChange='showSelection(this);' >
										<bean:write name="locationStockOnHandRpt" property="strLeftItemFilterList" filter="false"/>
									</select>
								</div>				
							</td>
							
							<td width="6%" class="CONTROL" colspan="2">			
								<center>
									<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftDrugTransfer();">
								</center>
								<center>
									<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" style="display: none;"
									align="middle" onClick="shiftAllToRight('strLeftItemFilterIds','strRightItemFilterIds',1);"/>
								</center>
							<br/>
								<center>				
									<img src="../../hisglobal/images/backward.gif" width="30" height="21" style="display: none;"
									onClick="shiftAllToLeft('strLeftItemFilterIds','strRightItemFilterIds',1);">
								</center>
								<center>
									<img src="../../hisglobal/images/back3.gif" width="30" height="21" 
									onclick="transferToLeft();"/>
								</center>
							</td>			
							
							<td colspan="2" class="CONTROL">
								<div id="rightItemDivId" align="left">
									<select id="strRightItemFilterIds" name="strRightItemFilterIds" size="6" multiple style="width: 280px">
										<bean:write name="locationStockOnHandRpt" property="strRightItemFilterList" filter="false"/>
									</select>
								</div>
							</td>		
						</tr>					
					</table>
				</div>
	
				<div class="row my-2">
						<div class="col-sm-2"><label>Batch No. Wise<font color="red">*</font></label></div>
						<div class="col-sm-10 p-2">
							<html:checkbox property="strBatchWiseChk"   name="locationStockOnHandRpt"  onclick="vitalRpt(this,1);" title="Click Here To Supplier Wise Challan Detail(s)"  tabindex="1"></html:checkbox>
						</div>	
				</div>
				
				<hr>
				
				<div id="htmlRpt"> 	</div>
				<div class="row text-right">
			    	<div class="col">
			    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
			    	</div>
				</div>
				<div class="control_button"></div>     	
			
				<input type="hidden" name="hmode" />
				<input type="hidden" name="strCurrentDate" value="${locationStockOnHandRpt.strCurrentDate}" />
				<input type="hidden" name="strCurrentStock" value="${locationStockOnHandRpt.strCurrentStock}" />	
				<input type="hidden" name="strStoreName" value="${locationStockOnHandRpt.strStoreName}"/>	
				<input type="hidden" name="strUserLevel" value="${locationStockOnHandRpt.strUserLevel}" />	
				<input type="hidden" name="strItemBrandId" value="${locationStockOnHandRpt.strItemBrandId}" />
				<input type="hidden" name="strItemId" value="0" />
				<input type="hidden" name="strStoreTypeNameList" />	
				<input type="hidden" name="strBatchWiseChkFlg" value="0" /> 
				<input type="hidden" name="strSubStoreStockChkFlg" value="0"/>
			    <input type="hidden" name="strAlphbet" value="$"/>	
				<input type="hidden" name="strSearchIndex" value="$Id"/>
			    <input type="hidden" name="strDrugClassName" value=""/>
			    <input type="hidden" name="strProgrammeName" value=""/>
			    <input type="hidden" name="strStockStatusName" value=""/>
			    
			</div>
			</fieldset>
		</div>
	</div>
    
</html:form>
</body>
</html>