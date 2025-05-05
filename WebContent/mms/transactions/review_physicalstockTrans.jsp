<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">


	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../js/discrepancyGlobal.js"></script>
<script language="JavaScript" src="/AHIMS/hisglobal/utility/committeMemberRecommendation/js/committeMemberRecommendation.js"></script>
<script type="text/javascript">

</script>



</head>
<body>


<html:form name="physicalStockVerificationBean"
	action="/transactions/PhyStockVerificationTransCNT"
	type="mms.transactions.controller.fb.PhyStockVerificationTransFB" enctype="multipart/form-data">

    <div class="errMsg"     id="errMsg"><bean:write name="physicalStockVerificationBean" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="physicalStockVerificationBean" property="strWarningMsg"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="physicalStockVerificationBean" property="strNormalMsg"/></div>


<center>
<tag:tab tabLabel="Physical Stock Verification" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>


<jsp:include page="discrepancyReportglobal.jsp"></jsp:include>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   <tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
				<td width="25%" class="LABEL">
				Store Name
				</td>
				<td width="25%" class="CONTROL">
				    <bean:write name="physicalStockVerificationBean" property="strStoreName" filter="false"/>
	            </td>
	            <td width="25%" class="LABEL">
				Item Category
				</td>
				<td width="25%" class="CONTROL">
				  <bean:write name="physicalStockVerificationBean" property="strItemCategoryName" filter="false"/>  
			    </td>
		  </tr>
		<tr>
			<td width="25%" class="LABEL">
				Physical Stock No.
				</td>
				<td width="25%" class="CONTROL">
				    <bean:write name="physicalStockVerificationBean" property="strStockNo" filter="false"/>
	            </td>
	            <td width="25%" class="LABEL">
				Start Date
				</td>
				<td width="25%" class="CONTROL">
				  <bean:write name="physicalStockVerificationBean" property="strStartDate" filter="false"/></td>	
		 </tr>
		 <tr>
			<td width="25%" class="LABEL">
				Period
				</td>
				<td width="25%" class="CONTROL" colspan="3">
				    <bean:write name="physicalStockVerificationBean" property="strPeriod" filter="false"/>
	            </td>
	            
		 </tr>
	    
	    </table>
	    	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusAddNonDicrepancyId" align="left" style="display:block;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusAddNonDicrepancyId','minusAddNonDicrepancyId','groupComboId');" style="cursor: pointer; "/>
						Non-Discrepancy Report
					</div>
					<div id="minusAddNonDicrepancyId" style="display:none;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusAddNonDicrepancyId','minusAddNonDicrepancyId','groupComboId');" style="cursor: pointer; "/>
						Non-Discrepancy Report
					</div>
				</td>
		</tr>
	</table>
	<div id="groupComboId" style="display:none;" >
	    <bean:write name="physicalStockVerificationBean" property="strGroupComboDisp" filter="false"/>
	
	    <div id="paginationNonDisId"></div>
	     </div>
	    <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusAddDiscrepancyId" align="left" style="display:block;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusAddDiscrepancyId','minusAddDiscrepancyId','disReportId');" style="cursor: pointer; "/>
						Discrepancy Report
					</div>
					<div id="minusAddDiscrepancyId" style="display:none;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusAddDiscrepancyId','minusAddDiscrepancyId','disReportId');" style="cursor: pointer; "/>
						Discrepancy Report
					</div>
				</td>
		</tr>
	</table>
	
	
	   <div id="disReportId" style="display: none">
	    <bean:write name="physicalStockVerificationBean" property="strDisReport" filter="false"/>
	  </div>  
	  <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusAddApprovalDtl" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusAddApprovalDtl','minusAddApprovalDtl','billApprovalId');" style="cursor: pointer; "/>
						Approval Detail
					</div>
					<div id="minusAddApprovalDtl" style="display:block;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusAddApprovalDtl','minusAddApprovalDtl','billApprovalId');" style="cursor: pointer; "/>
						Approval Detail
					</div>
				</td>
		</tr>
	</table>
	
	  <div id="billApprovalId" style="display: block">
	  <bean:write name="physicalStockVerificationBean" property="strBillAproval" filter="false"/>
	  </div>
	  <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td colspan="4" class="TITLE">Committee Details</td>
		</tr>
		<tr>
		<td  class="LABEL" width="25%" >
					<font color="red">*</font>Committee Type  
		</td>
		<td class="CONTROL" width="25%">
			<select name="strCommitteeTypeId" class="comboNormal" onchange="getMemberDtl('COMMITEEMEMBERDTL');">
				<bean:write name="physicalStockVerificationBean" property="strCommitteeType" filter="false"/>
			</select>
		</td>
		<td  class="LABEL" width="25%" >
					Committee Member Dtl  
		</td>
		<td class="CONTROL" >
			<img src="../../hisglobal/images/plus.gif" 
									onClick="openDivPopu();" style="cursor: pointer; " title="Click Here To See Member Details"/>
		</td>
		</tr>
		</table>
		<jsp:include page="uploadFile.jsp"></jsp:include>
		 <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
		<td  class="LABEL" width="25%" >
					<font color="red">*</font>Final Remarks  
		</td>
			<td class="CONTROL" width="25%" colspan="3">
				<textarea name="strRemarks" cols="20" rows="3"></textarea>
			</td>
		</tr>
		</table>
	    <table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ></td>
  		</tr>
	     <tr> 
		<td align="center">
		<img src="../../hisglobal/images/btn-sv.png" onClick ="save();" style="cursor: pointer;" title="Click Here To Save the Data"/>
			<img src="../../hisglobal/images/btn-ccl.png" onClick ="controlToMainPage();" style="cursor: pointer;" title="Click Here To Move Control Back To Add Page"/>
	   </td>
	  </tr>
</table>
        
    <input type="hidden" name="hmode"/>
    <input type="hidden" name="strStockNo" value="${physicalStockVerificationBean.strStockNo }"/>
    <input type="hidden" name="strStoreId" value="${physicalStockVerificationBean.strStoreId }"/>
    <input type="hidden" name="strItemCategNo" value="${physicalStockVerificationBean.strItemCategNo }"/>
    
     <cmbPers:cmbPers />
    <div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="memberDtl" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="memberDtlInner" style="display:block;"></div>
</td>
</tr>
</table>
</div>
    
  </html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>