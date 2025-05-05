<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<title>Stock In Hand On Given Date</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
 <link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css"> 
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	

<!-- <link href="../../hisglobal/css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
 -->
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/stockonhandDateWise_mmsrpt.js"></script>

</head>
<body class="background" >
<div id="mask"></div>
<div id="dvLoading"></div>
<html:form action="/reports/StockSummaryDateWiseRptCNT" method="post" styleClass="formbg">

	<div class="errMsg" id="errMsg"><bean:write name="stockOnHandDateWiseRpt"
		property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="stockOnHandDateWiseRpt" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="stockOnHandDateWiseRpt" property="strWarningMsg" /></div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'>Stock In Hand On Given Date</td>
		</tr>
	</table>
	
	 
	<!-- 	<tr id="districtDrugWarehouseDivId" >
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>HQ</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strDistrictStoreId" class="comboMin"  onchange="getStoreTypeCmb();">
					<bean:write name="stockOnHandDateWiseRpt" property="strDistrictStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		
			</tr>			
		 -->	
		 <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">		 	
		<tr id="storeTypeTrId">
			<td   class="LABEL"><font color="red">*</font>Store Name</td>
			<td  class="CONTROL">
			<div id="storeTypeDivId">					
			<select name="strStoreTypeId" class="comboNormal" onchange="getItemCat();">
				<bean:write name="stockOnHandDateWiseRpt" property="strStoreTypeCombo" filter="false" />
			</select>
			</div>
			</td>
		</tr>				
		<tr>
			<td  class="LABEL"><font color="red">*</font>Item Category</td>
			<td  class="CONTROL">
			<div id="itemTypeDivId">					
			<select name="stritemCatNo" class="comboNormal" onchange="getItemName();">
				<bean:write name="stockOnHandDateWiseRpt" property="strItemCatCombo" filter="false" />
				<option value="-1">Select Value</option>
			</select>
			</div>
			</td>
		</tr>	
			  </table>	
<!--		<tr	id="drugWarehouseDivId">-->
<!--			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>-->
<!--			<td width="70%" colspan="3" class="CONTROL">-->
<!--			<div id="strSubStoreDivId" >-->
<!--				<select name="strStoreId" class="comboNormal" onchange="getItemCatCmb();">-->
<!--					<bean:write name="stockOnHandDateWiseRpt" property="strStoreValues" filter="false" />-->
<!--				</select>-->
<!--			</div>	-->
<!--			</td>-->
<!--		</tr>			-->
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	     <tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners' align="center">Item Name</td>
		  </tr>
		 </table>
			<table class='TABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px" height="30px">
			<tr class="LABEL">
				<td	style="font-family: Verdana; height: 15px; font-weight: bold; font-style: normal;"
					colspan="6" align="right" class="LABEL">
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
			<table class='NEWTABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px">
			<tr>
				<td width="58%" colspan="10" class="LABEL" al>Search Item Name</td>
				<td class="CONTROL" colspan="10">
				<div id="drugNameDivId" style="display: none;">
					<select id="strDrugName" name="strDrugName" class="comboNormal" >
						<bean:write name="stockOnHandDateWiseRpt" property="strDrugSearchCombo" filter="false" />
					</select>
				</div>							
				<input type="text" id="strSearchDrug" name="strSearchDrug" size="75%"/>
				<div id="DrugNameId" style="display: none;" ></div>	
				<div id="txtFromLeftMutltiSelectCombo" style="display:none; color:blue;font-weight:bold; text-align:left"></div>
				</td>			 
		   </tr>		   
		   </table>		
		   <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
	  			<td class="CONTROL" colspan="2" width="45%">  			 
					<div id="leftItemDivId" align="right">
						<select id="strLeftItemFilterIds" name="strLeftItemFilterIds" size="6" multiple style="width: 280px" onChange='showSelection(this);' >
							<bean:write name="stockOnHandDateWiseRpt" property="strLeftItemFilterList" filter="false"/>
						</select>
					</div>				
				</td>
				<td width="6%" class="CONTROL" colspan="2">			
					<center>
						<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftDrugTransfer();"></center>
					<center>
				<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" style="display: none;"
					align="middle" onClick="shiftAllToRight('strLeftItemFilterIds','strRightItemFilterIds',1);"/></center>
				<br/>
				<center>				
				<img src="../../hisglobal/images/backward.gif" width="30" height="21" style="display: none;"
					onClick="shiftAllToLeft('strLeftItemFilterIds','strRightItemFilterIds',1);"></center>
				<center>
					<img src="../../hisglobal/images/back3.gif" width="30" height="21" 
						onclick="transferToLeft();"/>
				</center>
				</td>			
				<td colspan="2" class="CONTROL">
					<div id="rightItemDivId" align="left">
						<select id="strRightItemFilterIds" name="strRightItemFilterIds" size="6" multiple style="width: 280px">
							<bean:write name="stockOnHandDateWiseRpt" property="strRightItemFilterList" filter="false"/>
						</select>
					</div>
				</td>		
			</tr>					
			</table>
		</div>
		<table class='TABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px">
		<!--  <tr>
			<td width="45%" colspan="2" class="LABEL">With Stock/Val</td>
			<td width="55%" colspan="2" class="CONTROL"><html:checkbox property="strStockValWiseChk"   name="stockOnHandDateWiseRpt"  onclick="vitalRpt(this,1);" title="Click Here To Supplier Wise Challan Detail(s)"  tabindex="1"></html:checkbox></td>
		  </tr> -->
		  </table>
		  
		 <table class='TABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px">
		 <tr>
			<td width="41%" class="LABEL" colspan="2"><font color="red">*</font>Date</td>
			<td width="59%" class="CONTROL" colspan="2"><dateTag:date name="strDate"
				value="${stockOnHandDateWiseRpt.strCurrentDate}" /></td>			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strReportFormat"  onchange="">
					<option value="html">Html</option>
					<option value="pdf">Pdf</option>
					<option value="xls">Excel</option>
				</select>
			</td>
			
		</tr> 
		<tr>
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strIsFooter" name="stockOnHandDateWiseRpt" value="1"></html:checkbox>
			</td>
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		
		
		 
		 
		  <tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'><font size="2" color="red">*</font>Mandatory Field(s)</td>
		  </tr>
				
			</table>		            	
		
		
		
	
	<div id="htmlRpt">
	<div class="control button">
	<table  class="" align="center" width="50%">
	<tr>
	<td align="center"><div>
				<br>
				<a href="#" class="button" onClick="return validate2();"><span class="generate">Generate</span></a>
				<a href="#" class="button" onClick="onClickClear();"><span class="clear">Clear</span></a>
				<a href="#" class="button" onClick="cancelPage();"><span class="cancel">Cancel</span></a>				 
				</div></td>
	</tr>	  
	</table>
	</div>
	</div>	
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strCurrentDate" value="${stockOnHandDateWiseRpt.strCurrentDate}" />
	<input type="hidden" name="strCurrentStock" value="${stockOnHandDateWiseRpt.strCurrentStock}" />
	<input type="hidden" name="strCircleName" value="${stockOnHandDateWiseRpt.strCircleName}"/>
	<input type="hidden" name="strDistrictName" value="${stockOnHandDateWiseRpt.strDistrictName}"/>
	<input type="hidden" name="strStoreName" value="${stockOnHandDateWiseRpt.strStoreName}"/>
	<input type="hidden" name="strStoreTypeName" value="${stockOnHandDateWiseRpt.strStoreTypeName}"/>
	<input type="hidden" name="strSubStoreName" value="${stockOnHandDateWiseRpt.strSubStoreName}"/>
	<input type="hidden" name="strUserLevel" value="${stockOnHandDateWiseRpt.strUserLevel}" />
	<input type="hidden" name="strIsDdwFlag" value="${stockOnHandDateWiseRpt.strIsDdwFlag}" />
	<input type="hidden" name="strItemBrandId" value="${stockOnHandDateWiseRpt.strItemBrandId}" />
	<input type="hidden" name="strDistrictName1" value="${stockOnHandDateWiseRpt.strDistrictName1}" />
	
	<input type="hidden" name="strItemId" value="0" />
	<input type="hidden" name="strStoreTypeNameList" />	
	<input type="hidden" name="strStockValWiseChkFlg" value="0" /> 
	<input type="hidden" name="strSearchIndex" value="$Id"/>
	 <input type="hidden" name="strAlphbet" value="$"/>
	
</html:form>
</body>
</html>
