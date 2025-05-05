<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Technical Comparative Statement Approval</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/rate_contract_trans.js"></script>

<script language="Javascript" src="../js/searchItems_util.js"></script>

<script language="javaScript">

function getTenderDetails(obj){
if(obj.checked){
display_popup_menu(obj,'popup','300','');
}else{
hide_popup_menu('popup');
}
 
}
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}
</script>

</head>
<body >
<form>
<center>
	
<tag:tab tabLabel="EMD ForFeit Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		
		<tr>
		<td class="LABEL" width="25%" colspan="2" >Tender/Quotation No.</td>
				<td width="25%" colspan="1" class="CONTROL" >
				<select name="strEnquiryMode">
					<option value="0">PGI/2010/Drugs/001</option>
					
				</select>
			
			</td>
		<td width="50%" colspan="1" class="CONTROL">
				<div id="goDivId"><img style=" cursor: pointer"
					src="../../hisglobal/images/Go.png" title='Click Here For PO Details' align="top"
					onclick="onNewGo();"></div>
			</td>
		</tr>
</table>

<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusAddTenderId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusAddTenderId','minusAddTenderId','tenderDetailsId');" style="cursor: pointer; "/>
						Tender/Quotation Details
					</div>
					<div id="minusAddTenderId" style="display:block;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusAddTenderId','minusAddTenderId','tenderDetailsId');" style="cursor: pointer; "/>
								Tender/Quotation Details
					</div>
				</td>
		</tr>
	</table>

	<div id='tenderDetailsId'>
		<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td class="LABEL" colspan="1">
				Enquiry Mode
			</td>
			<td class="CONTROL" colspan="3">
				<select name="strEnquiryMode">
					<option value="0">Tender</option>
					</select>
			</td>
			
			
		</tr>
		
		<tr>
			<td class="LABEL" colspan="1">
				Tender/Quotation No.
			</td>
			<td class="CONTROL" colspan="1">
				<select name="strEnquiryMode">
					<option value="0">PGI/2010/DRUGS/001</option>
					</select>
			</td>
			<td class="LABEL" colspan="1">
				Title
			</td>
			<td class="CONTROL" colspan="1">
				<select name="strEnquiryMode">
					<option value="0">Tender for Equipment</option>
					</select>
			</td>
			
			
			
		</tr>
		
		<tr>
			<td class="LABEL" colspan="1">
				Cost
			</td>
			<td class="CONTROL" colspan="1">
				5000.00</td>
			<td class="LABEL" colspan="1">
				Contract Type
			</td>
			<td class="CONTROL" colspan="1">
				<select name="strEnquiryMode">
					<option value="0">Supplies</option>
					</select>
			</td>
			
			
			
		</tr>
			
			
		</table>
		</div>
		
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusAddSpecificationEntryId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusAddSpecificationEntryId','minusAddSpecificationEntryId','specificationEntryDetailsId');" style="cursor: pointer; "/>
						ForFeit Details
					</div>
					<div id="minusAddSpecificationEntryId" style="display:block;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusAddSpecificationEntryId','minusAddSpecificationEntryId','specificationEntryDetailsId');" style="cursor: pointer; "/>
								ForFeit Details
					</div>
				</td>
		</tr>
	</table>
		<div id='specificationEntryDetailsId'>
		<table class="TABLEWIDTH"  align="center" cellspacing="1px">
		
		<tr>
			<td colspan="2" class="LABEL">Supplier Name</td>
			<td width="50%" colspan="2"  class="CONTROL">
				<select name="strEnquiryMode">
					<option value="0">PQR</option>
					</select>
			
			</td>
			
		</tr>
		
		<tr>
			
			<td colspan="1" class="LABEL">EMD/PBG No.</td>
			<td colspan="1" class="CONTROL" >EMD/PGI/001</td>
			<td colspan="1" class="LABEL">Date of ForFeit</td>
			<td colspan="1" class="CONTROL" >
				<date:date name="strEffectiveFrom" value="26-Nov-2009"></date:date>
			
			</td>
			
		</tr>
		
		<tr>
			
			<td colspan="1" class="LABEL">ForFeit Mode</td>
			<td colspan="1" class="CONTROL" >
				<select name="strEnquiryMode">
					<option value="0">Cash</option>
					</select>
			
			</td>
			<td colspan="1" class="LABEL">ForFeit Amt.</td>
			<td colspan="1" class="CONTROL" >
				<input type="text" class="txtFldMax">
			
			</td>
			
		</tr>
		<tr>
			<td colspan="2" class="LABEL">ForFeit Valid Upto</td>
			<td colspan="2" class="CONTROL" >
				<date:date name="strEffectiveFrom" value="26-Nov-2009"></date:date>
			
			</td>
		
			
		</tr>
		
			
		</table>
		</div>	
		
		
	<table border="0" class="TABLEWIDTH" align="center">
		
		
			<tr>
			<td class="LABEL" colspan="2">
				Remarks
			</td>
					<td colspan="2" class="CONTROL"><textarea rows="2"
				cols="20" name="strRemarks">Test Data</textarea></td>	
			
			</tr>
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
			<tr>
			
			<td align="center" colspan="4">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" title="Accept"/> 
				<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png"
				onClick=" return validate1();" title="Accept"/> 
				<img style="cursor: pointer; " title="Click Here Go Back To Main Desk" 
				src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			</td>
						
		</tr>
	</table>

</form>
</body>
</html>