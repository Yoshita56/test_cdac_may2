<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<%-- 
/**
 * @author Vivek Aggarwal
 * Date of Creation : 7-June-2011
 * Date of Modification :  10-June-2011 
 * Version : 
 * Module  : DWH
 */
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Detail Master View Page</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script language="Javascript" src="../../mms/js/dwh_employeeDetail_mst.js"></script>
</head>



<body>
<html:form name="employeeDetailMstBean" action="/masters/EmployeeDetailMstCNT" type="mms.masters.controller.fb.EmployeeDetailMstFB">

	<div id="strErrMsg" class="errMsg"><bean:write name="employeeDetailMstBean" property="strErrMsg" /></div>
	<div class="warningMsg"><bean:write name="employeeDetailMstBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="employeeDetailMstBean" property="strNormalMsg" /></div>

	<tag:tab tabLabel="Employee Detail Master" selectedTab="FIRST" align="center" width="TABLEWIDTH" onlyTabIndexing="1">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Employee Detail Master&gt;&gt;View</td>
		</tr>
	</table>
	
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="5">Personal Detail</td>
		
		</tr>
		<tr>
<!-- Employee Code -->	
	
			<td width="25%" class="LABEL">Employee Code</td>
			<td width="25%" class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strEmpCode" />
			</td>
			
<!-- Gender Code -->
			
			<td width="25%" class="LABEL">Gender</td>
			<td width="25%" class="CONTROL">
				
				<bean:write name="employeeDetailMstBean" property="strGenderCode" />
				
			</td>
			
		</tr>

	</table>	
<!-- Employee Name-->
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td width="10%" class="LABEL">Employee Name</td>
			
			<td id="salutation_Id"	class="CONTROL" width="90%">
			<bean:write name="employeeDetailMstBean" property="strSalutationId" />
			<bean:write name="employeeDetailMstBean" property="strFirstName" />
			<bean:write name="employeeDetailMstBean" property="strMiddleName" />
			<bean:write name="employeeDetailMstBean" property="strLastName" />
			
			
			</td>
			
		</tr>
	</table>
		
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
<!-- Father Name-->
			<td class="LABEL">Father Name</td>
			<td width="25%" class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strFatherName" />
			</td>	
<!-- Mother Name-->			
			<td class="LABEL">Mother Name</td>
			<td width="25%" class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strMotherName" />
			</td>
			
		</tr>
 
 

		<tr>
<!-- Spouse Name-->
			<td class="LABEL">Spouse Name</td>
			<td width="25%" class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strSpouseName" />
			</td>	
<!-- Birth Date-->			
			<td class="LABEL">Birth Date</td>
			<td width="25%" class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strBirthDate" />
			</td>
			
		</tr>


 		<tr>
<!-- Designation -->
			<td width="25%" class="LABEL">Designation</td>
			<td width="25%" class="CONTROL">
					<bean:write name="employeeDetailMstBean" property="strDesignationValues" filter="false" />
			</td>	
<!-- Joining Date -->			
			<td width="25%" class="LABEL">Joining Date</td>
			<td width="25%" class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strJoiningDate" />
			</td>
			
		</tr>
	</table>
	
	
	
<!--	Address Detail -->
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="5">Address Detail</td>
		</tr>
 
 
 
 
<!-- Permanent Address		-->
		<tr>	
			<td width="25%" class="LABEL">Permanent Address</td>
			<td class="CONTROL">
				
				<textarea name="strPermanentAddress" disabled="disabled" rows="2"><bean:write name="employeeDetailMstBean" property="strPermanentAddress"/></textarea>
			</td>
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="LABEL"></td>			
		</tr>
<!-- Local Address -->		
		<tr>	
			<td width="25%" class="LABEL">Local Address</td>
			<td class="CONTROL">
				<textarea id="localAddressTextAreaId" name="strLocalAddress" disabled="disabled" rows="2"><bean:write name="employeeDetailMstBean" property="strLocalAddress"/></textarea>
			</td>		
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="LABEL"></td>
		</tr>
		
		
<!-- Phone No &  Mobile No -->		
		<tr>
			<td width="25%" class="LABEL">Phone No</td>
			<td class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strPhoneNo"/>
			</td>	
			<td width="25%" class="LABEL">Mobile No</td>
			<td class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strMobileNo"/>
			</td>
					
		</tr>
		
<!--	Fax No	-->
		<tr>
		<td width="25%" class="LABEL">Fax No</td>
			<td class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strFaxNo"/>
			</td>	
			
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="LABEL"></td>
			
		</tr>
	</table>	

<!-- Dependent Details	-->
		<table cellspacing="1px" class="TABLEWIDTH" align="center">
			<tr>
				<td class="TITLE"  >Dependent Details</td>
			</tr>
 
		</table>
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center" id="enteredDependentDetailsTable">
			<tr>
				<bean:write name="employeeDetailMstBean" property="strEnteredDependentDetailsTable" filter="false"/>
			</tr>	
		</table>


	
	
	
	
	
<!--	Other Detail -->
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="5">Other Details</td>
		</tr>
			
		
<!-- Service Document No  &  Service Document Date  -->		
		<tr>
			<td width="25%" class="LABEL">Service Document No</td>
			<td class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strServiceDocNo"/>
			</td>	
			<td width="25%" class="LABEL">Service Document Date</td>
			<td class="CONTROL">
				<bean:write name="employeeDetailMstBean" property="strServiceDocDate"/>
			</td>
		</tr>
		
<!-- Remarks		-->
		<tr>	
			<td width="25%" class="LABEL">Remarks</td>
			<td class="CONTROL">
				<textarea name="strRemarks" disabled="disabled" rows="2"><bean:write name="employeeDetailMstBean" property="strRemarks"/></textarea>
			</td>
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="LABEL"></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="5"><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>	


	<table CLASS="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td align="center">
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor: pointer;" title="Cancel Process" onClick="window.close();"  />
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
    <input type="hidden" name="strCurrentDate" value="${employeeDetailMstBean.strCurrentDate}" />
	<input type="hidden" name="chk" value="${employeeDetailMstBean.chk[0] }">
	

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
