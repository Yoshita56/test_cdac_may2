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
<title>Employee Detail Master Modify Page</title>

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
			<td colspan="2">Employee Detail Master&gt;&gt;Modify</td>
		</tr>
	</table>
	
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="5"><font color="red">*</font>Personal Detail</td>
		
		</tr>
		<tr>
<!-- Employee Code -->	
	
			<td width="25%" class="LABEL"><font color="red">*</font>Employee Code</td>
			<td width="25%" class="CONTROL">
				<input type="text" name="strEmpCode" value="${employeeDetailMstBean.strEmpCode}" maxlength="14" onkeypress="return validateData(event,8);">
			</td>
			
<!-- Gender Code -->
			
			<td width="25%" class="LABEL"><font color="red">*</font>Gender</td>
			<td width="25%" class="CONTROL">
				
				<html:select name="employeeDetailMstBean" property="strGenderCode" styleClass="comboNormal" tabindex="1" onchange="getSalutationOnBasisOfGender();">
					<html:option value="1">Male</html:option>
					<html:option value="2">Female</html:option>							
					<html:option value="3">Other</html:option>							
				</html:select>	
			</td>
			
		</tr>

	</table>	
<!-- Employee Name-->
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td width="10%" class="LABEL"><font color="red">*</font>Employee Name</td>
			
			<td id="salutation_Id"	class="CONTROL" width="90%">
			
			<html:select property="strSalutationId" name="employeeDetailMstBean" styleClass="comboNormal" value="">
					<bean:write name="employeeDetailMstBean" property="strSalutationValues" filter="false" />
			</html:select>
				
			
				<input type="text" name="strFirstName" value="${employeeDetailMstBean.strFirstName}" maxlength="32" onkeypress="return validateData(event,4);">&nbsp;&nbsp;First			
				<input type="text" name="strMiddleName" value="${employeeDetailMstBean.strMiddleName}" maxlength="32" onkeypress="return validateData(event,4);">&nbsp;&nbsp;Middle 			
				<input type="text" name="strLastName" value="${employeeDetailMstBean.strLastName}" maxlength="32" onkeypress="return validateData(event,4);">&nbsp;&nbsp;Last Name
			</td>
			
		</tr>
	</table>
		
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
<!-- Father Name-->
			<td class="LABEL"><font color="red">*</font>Father Name</td>
			<td width="25%" class="CONTROL">
				<input type="text" name="strFatherName" value="${employeeDetailMstBean.strFatherName}" maxlength="100" onkeypress="return validateData(event,4);">
			</td>	
<!-- Mother Name-->			
			<td class="LABEL"><font color="red">*</font>Mother Name</td>
			<td width="25%" class="CONTROL">
				<input type="text" name="strMotherName" value="${employeeDetailMstBean.strMotherName}" maxlength="100" onkeypress="return validateData(event,4);">
			</td>
			
		</tr>
 
 

		<tr>
<!-- Spouse Name-->
			<td class="LABEL">Spouse Name</td>
			<td width="25%" class="CONTROL">
				<input type="text" name="strSpouseName" value="${employeeDetailMstBean.strSpouseName}" maxlength="100" onkeypress="return validateData(event,4);">
			</td>	
<!-- Birth Date-->			
			<td class="LABEL"><font color="red">*</font>Birth Date</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strBirthDate"	value="${employeeDetailMstBean.strBirthDate}"></dateTag:date>
			</td>
			
		</tr>


 		<tr>
<!-- Designation -->
			<td width="25%" class="LABEL"><font color="red">*</font>Designation</td>
			<td width="25%" class="CONTROL">
			
				<html:select property="strDesigId" name="employeeDetailMstBean" styleClass="comboNormal">
					<bean:write name="employeeDetailMstBean" property="strDesignationValues" filter="false" />
				</html:select>
				
					
			</td>	
<!-- Joining Date -->			
			<td width="25%" class="LABEL">Joining Date</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strJoiningDate"	value="${employeeDetailMstBean.strJoiningDate}"></dateTag:date>
			</td>
			
		</tr>
	</table>
	
	
	
<!--	Address Detail -->
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="5"><font color="red">*</font>Address Detail</td>
		</tr>
 
 
 
 
<!-- Permanent Address	& District Name	-->
		<tr>	
			<td width="25%" class="LABEL"><font color="red">*</font>Permanent Address</td>
			<td class="CONTROL">
				<textarea name="strPermanentAddress" rows="2"><bean:write name="employeeDetailMstBean" property="strPermanentAddress"/></textarea>
			</td>
			<td width="25%" colspan="1" class="LABEL">District Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			   <html:select  name="employeeDetailMstBean" property="strDistrictId" styleClass='comboMax'  >
					<bean:write name="employeeDetailMstBean" property="strDistrictNameCombo" filter="false" />
			   </html:select>				 
			</td>		
		</tr>
<!-- Local Address -->		
		<tr>	
			<td width="25%" class="LABEL"><font color="red">*</font>Local Address</td>
			<td class="CONTROL">
				<textarea id="localAddressTextAreaId" name="strLocalAddress" rows="2"><bean:write name="employeeDetailMstBean" property="strLocalAddress"/></textarea>
			</td>		
			<td width="25%" class="LABEL">Check if Local Address is same as Permanent Address</td>
			<td class="CONTROL">
				<input type="checkbox" name="strLocalAddressCheckbox" onclick="setLocalAddress();">
			</td>	
		</tr>
		
		
<!-- Phone No &  Mobile No -->		
		<tr>
			<td width="25%" class="LABEL">Phone No</td>
			<td class="CONTROL">
				<input type="text" name="strPhoneNo" value="${employeeDetailMstBean.strPhoneNo}" maxlength="35" onkeypress="return validateData(event,2);">
			</td>	
			<td width="25%" class="LABEL">Mobile No</td>
			<td class="CONTROL">
				<input type="text" name="strMobileNo" value="${employeeDetailMstBean.strMobileNo}" maxlength="35" onkeypress="return validateData(event,2);">			
			</td>
					
		</tr>
		
<!--	Fax No	-->
		<tr>
		<td width="25%" class="LABEL">Fax No</td>
			<td class="CONTROL">
				<input type="text" name="strFaxNo" value="${employeeDetailMstBean.strFaxNo}" maxlength="35" onkeypress="return validateData(event,2);">
			</td>	
			
			<td width="25%" class="LABEL">Email Id</td>
			<td width="25%" class="CONTROL">
				<input type="text" name="strEmailId"  value="${employeeDetailMstBean.strEmailId}" onkeypress="return validateData(event,1);">
			</td>
			
		</tr>
	</table>	

<!-- Entered Dependent Details	-->
		<table cellspacing="1px" class="TABLEWIDTH" align="center">
			<tr>
				<td class="TITLE" width="5%"  ><img alt="Show" src="../../hisglobal/images/plus.gif" style="cursor: pointer;" onclick="tableShow('enteredDependentDetailsTable',this);"></td>
				<td class="TITLE" width="95%" >Entered Dependent Details</td>
			</tr>
 
		</table>
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center" id="enteredDependentDetailsTable" style="display: none;">
			<tr>
				<bean:write name="employeeDetailMstBean" property="strEnteredDependentDetailsTable" filter="false"/>
					 
			</tr>	
		</table>


<!--	Dependent Details -->
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="5">Dependent Details</td>
		</tr>
	</table>
	
	<table cellspacing="1px" class="TABLEWIDTH" align="center" bgcolor='black'>
		
		<tr >
		<td width="23.75%" class="multiLabel"  bordercolor="black">
			S.No.
		</td>
		<td width="23.75%" class="multiLabel" bordercolor="black">
			Dependent Name
		</td>
		<td width="23.75%" class="multiLabel" bordercolor="black">
			Age(Year)
		</td>
		<td width="23.75%" class="multiLabel" bordercolor="black">
			Relationship
		</td>
		<td width="5%" class="multiLabel">
		
		<img  Src="../../hisglobal/images/plus.gif" style="cursor: pointer;"
						title="Add Dependent Detail's"
						OnClick="addRows(new Array('strDependentName','strAge','strRelationshipId'),new Array('t','t','s'),'1','1','R');generateSlNo();">
		
		</td>
		
		
		
	</tr>
	</table>	
	<div id="id1"></div>
	
	
	
	
	
<!--	Other Detail -->
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="TITLE" colspan="5">Other Detail</td>
		</tr>
			
		
<!-- Service Document No  &  Service Document Date  -->		
		<tr>
			<td width="25%" class="LABEL">Service Document No</td>
			<td class="CONTROL">
				<input type="text" name="strServiceDocNo" value="${employeeDetailMstBean.strServiceDocNo}" maxlength="25" onkeypress="return validateData(event,18);">
			</td>	
			<td width="25%" class="LABEL">Service Document Date</td>
			<td class="CONTROL">
				<dateTag:date name="strServiceDocDate"	value="${employeeDetailMstBean.strServiceDocDate}"></dateTag:date>
			</td>
		</tr>
		
<!-- Remarks		-->
		<tr>	
			<td width="25%" class="LABEL">Remarks</td>
			<td class="CONTROL">
				<textarea name="strRemarks" rows="2"><bean:write name="employeeDetailMstBean" property="strRemarks"/></textarea>
			</td>
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="LABEL"></td>
		</tr>
		
<!-- Record Status -->
		
			<tr>
				<td class="LABEL"><font color="red">*</font>Record Status</td>
	
				<td class="CONTROL" colspan="2">
					<html:radio name="employeeDetailMstBean" property="strIsValid" value="1">Active</html:radio>
	    			<html:radio name="employeeDetailMstBean" property="strIsValid" value="2">Inactive</html:radio>
				</td>
			</tr>
		
		<tr class="FOOTER">
			<td colspan="5"><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>	


	<table CLASS="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td align="center">
				<img src="../../hisglobal/images/btn-sv.png" style="cursor: pointer;" title="Save Record" onClick="validate1('Modify');" />
				<img src="../../hisglobal/images/btn-clr.png" style="cursor: pointer;" title="Reset Content" onClick="document.forms[0].reset(),clearMsg('MODIFY')" ;/> 
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor: pointer;" title="Cancel Process" onClick="cancel('LIST');" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
    <input type="hidden" name="strCurrentDate" value="${employeeDetailMstBean.strCurrentDate}" />
	<input type="hidden" name="chk" value="${employeeDetailMstBean.chk[0] }">
	

	<cmbPers:cmbPers />
</html:form>
<jsp:include page="dwh_employeeDetail_multirow_mst.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
