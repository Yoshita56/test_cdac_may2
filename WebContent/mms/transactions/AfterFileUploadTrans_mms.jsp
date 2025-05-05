<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 05/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<title>File Uploaded</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/smoothness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/select2.min.css" rel="stylesheet" type="text/css">
 <style>
.custom-combobox {
	position: relative;
	display: inline-block;
}

.custom-combobox-toggle {
	position: absolute;
	top: 0;
	bottom: 0;
	margin-left: -1px;
	padding: 0;
	/* support: IE7 */ *
	height: 1.7em; *
	top: 0.1em;
}

.custom-combobox-input {
	margin: 0;
	padding: 0.3em;
}
</style>
<script language="JavaScript" src="../../hisglobal/js/jquery-1.11.1.js"></script> 
<script language="JavaScript" src="../../hisglobal/js/select2.min.js"></script>
<!-- <script language="JavaScript" src="../../hisglobal/js/jquery-1.10.1.min.js"></script> -->
<script language="JavaScript" src="../../hisglobal/js/jquery-ui.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/FileUploadTrans.js"></script>
<script src="../../hisglobal/js/jquery-1.10.1.min.js"></script>


</head>
<body class="background">

<%-- <html:form styleClass="formbg" action="/transactions/FileUploadTransCNT.cnt"  name="fileUploadBean"  type="mms.transactions.controller.fb.FileUploadTransFB" method="get" enctype="multipart/form-data">
 --%>
 <html:form name="challanProcessBean" action="/transactions/FileUploadTransCNT" type="mms.transactions.controller.fb.FileUploadTransFB" enctype="multipart/form-data" styleClass="formbgnew">
	<div class="errMsg" id="errMsg">
	     <bean:write name="fileUploadBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg">
	     <bean:write name="fileUploadBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg">
	     <bean:write name="fileUploadBean" property="strMsg" /></div>


   	 <table width='100%' align="center" border="0" cellspacing ="1px">
		<tr class="HEADER">
			<td colspan="4">Budget Allocation Details</td>
		</tr>
	</table>
	
    <table class="NEWTABLEWIDTH" align="center" border = "0" cellspacing="1px" >
	 		<tr>
				 <td width="25%" class="LABEL">Financial year :</td>
				<td width="25%" class="CONTROL">
						<bean:write name="fileUploadBean" property="strFinancialYearCombo" filter="false" />
						
				</td> 
				
				<td width="25%" class="LABEL">Quarter Period :</td>
				<td width="25%" class="CONTROL">
							<bean:write name="fileUploadBean" property="strQuarterPeriod" filter="false" />
							
				</td>
				
			</tr>

			<tr>
				<td width="25%" class="LABEL">Budget Class :</td>
				<td width="25%" class="CONTROL">Drug
				 		<%-- <bean:write name="fileUploadBean" property="strBudgetClassCmb" filter="false" /> --%>
				</td>
				
				<td width="25%" class="LABEL">Programme Name :</td>
				<td width="25%" class="CONTROL">
							<bean:write name="fileUploadBean" property="strProgrammeCmb" filter="false" />
							
				</td>
			</tr>

			<tr>
				<td width="25%" class="LABEL">Funding Source Name :</td>				   
				<td width="25%" class="CONTROL">					
							<bean:write name="fileUploadBean" property="strFundSourceCmb" filter="false" />
							
				</td>  
				
				<td width="25%" class="LABEL">District Name :</td>				   
				<td width="25%" class="CONTROL">				
							<bean:write name="fileUploadBean" property="strDistrictCmb" filter="false" />
							
				</td>  
				
			</tr>
			
			<tr>
				<td width="25%" class="LABEL">Store Type (Allocated To) :</td>
				<td width="25%" class="CONTROL">
							<bean:write name="fileUploadBean" property="strDWHSubTypeCmb" filter="false" />
							
				</td> 
				
				<td width="25%" class="LABEL">Allocated By :</td>
				<td width="25%" class="CONTROL">SHS
							<%-- <bean:write name="fileUploadBean" property="strAllocatedBy" filter="false" /> --%>
							
				</td> 
			</tr>
			
			<tr>
				<td width="25%" class="LABEL">Allocated Budget :</td>
				<td width="25%" class="CONTROL"><b><font color='red'>
							<%-- <bean:write name="fileUploadBean" property="strAllocatedBudget" filter="false" /> Rs.</font></b> --%>
							<bean:write name="fileUploadBean" property="strAllocatedRealizedBudget" filter="false" /> Rs.</font></b>
							
				</td> 
				
				<td width="25%" class="LABEL">Available Budget :</td>
				<td width="25%" class="CONTROL"><b><font color='red'>
							<%-- <bean:write name="fileUploadBean" property="strAvailableBudget" filter="false" /> Rs.</font></b> --%>
							<bean:write name="fileUploadBean" property="strAvailableRealizedBudget" filter="false" /> Rs. [ </font></b>
							<b><font color='red'>L.B : <bean:write name="fileUploadBean" property="strAvailableLocalBudget" filter="false" /> Rs. 
							 C.B : <bean:write name="fileUploadBean" property="strAvailableCentralBudget" filter="false" /> Rs. ]</font></b>
							<html:hidden name="fileUploadBean" property="strAvalHiddenBudget" />
							<html:hidden name="fileUploadBean" property="strAvailableLocalBudget" />
							<html:hidden name="fileUploadBean" property="strAvailableCentralBudget" />
				</td> 
			</tr>
			</table>
			<br/>
			
		 <table class="NEWTABLEWIDTH" align="center" border = "0" cellspacing="1px" >
			<tr>
				<td width="100%" class="CONTROL">
				<div id="hlpDivId">
						<bean:write name="fileUploadBean" property="htmlCode" filter="false"/>
						<%-- <html:hidden name="fileUploadBean" property="strHtmlCodeHidden" /> --%>
				</div>
				</td>
				
			</tr> 
	</table>
	
	<br/>
		<div class="control_button">
				<table align="center" class="TABLEWIDTH">
					<tbody>
						<tr id="saveId">
							<td align="center">
								<div>
									<a onclick="return saveBudget();" class="button"
										title="Click to Save Record" style="cursor: pointer;" href="#"><span
										class="save"> Save  </span></a>
									<a onClick="initPage1();" class="button"
										title="Click to Cancel Page" style="cursor: pointer;" href="#"><span
										class="cancel"> Cancel </span></a>
									
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		<html:hidden name="fileUploadBean" property="hmode" />
		<html:hidden name="fileUploadBean" property="strTotalLocalHiddenCost"/>
		<html:hidden name="fileUploadBean" property="strTotalCentralHiddenCost"/>
		<html:hidden name="fileUploadBean" property="strHiddenQuarterPeriod"/>
	    <input type="hidden" name="strDcsBudget" value="${fileUploadBean.strDcsBudget}"/>
</html:form>

</body>
</html>