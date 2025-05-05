<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



<html>
<head>
<meta charset=UTF-8">
<title>Gifted Item Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/giftedItemDetails.js"></script>
<script language="JavaScript">



</script>

</head>
<body >
<html:form name="giftedItemDetailsTransBean" action="/transactions/GiftedItemDetailsTransCNT" type="mms.transactions.controller.fb.GiftedItemDetailsTransFB">
	<div id="errMsg" class="errMsg"><bean:write name="giftedItemDetailsTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="giftedItemDetailsTransBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="giftedItemDetailsTransBean" property="strNormalMsg" /></div>
	
	<tag:tab tabLabel="Donated Item Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
	<table class="TABLEWIDTH" align="center"   cellpadding="1px"  cellspacing="1px">   
				   
	   <tr class="HEADER">

			<td colspan="4"></td>
			<td align="right"><span>
			<html:checkbox name="giftedItemDetailsTransBean" property="strGiftedItemViewMode" onclick="changeViewMode(this);" title="Click Here To View"></html:checkbox></span>View</td>
		</tr>
	   </table>
	   
	   <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	   
	    <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="25%" class="CONTROL">
			<select name="strStoreId" class='comboMax' onchange="reSetViewDetails(),getItemCategorys(this);">
					<bean:write name="giftedItemDetailsTransBean" property="strStoreNameCombo" filter="false" />
					</select></td>
			
			<td  width="25%" class="LABEL">
			<font color="red">*</font>Item Category
			</td>
			<td width="25%" class="CONTROL">
			<div id="itemCategoryDivId">
			<select name="strItemCategoryId" class='comboNormal'>
			<bean:write name="giftedItemDetailsTransBean" property="strItemCategoryCombo" filter="false" />				
					</select></div></td>		
	   </tr>
	   
	   </table>
	  
	  <div id="itemDetailsMode" style="display: block">
	  <table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	 	   
	   <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>Gifted By
			</td>
			<td width="25%" class="CONTROL">
			<input type="text" class='txtFldMax' name="strGiftedBy" 
			value ="" maxlength="100" onkeypress="return validateData(event,4);">
			</td>
			
			<td width="25%" class="LABEL">
			<font color="red">*</font>Address
			</td>
			<td width="25%" class="CONTROL">
        		<textarea name="strAddress" rows="2" cols="18"></textarea>
             </td>		
	   </tr>
	   <tr>
	   <td width="50%" colspan="2" class="LABEL">Remarks</td>
			<td width="50%" colspan="2" class="CONTROL">
        		<textarea name="strRemarks" rows="2" cols="18"></textarea>
             </td>	
	   </tr>
	   <tr>
	   <td colspan="4" class=" " align="center">
	    <!-- -<img style="cursor: pointer; " title="Get Gifted Item Details" src="../../hisglobal/images/Go.png" onclick="return getInventoryDtls();"/> --> 
	   <a href="#" class="button" id="go" onclick="return getInventoryDtls();"></a>
	   </td>
	   </tr>
	  </table>
	  </div> 
	 
	 <div id="giftedItemViewMode" style="display: none">
	 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
         
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate" value="${giftedItemDetailsTransBean.strCurrentDate}" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" ><dateTag:date name="strToDate" value="${giftedItemDetailsTransBean.strCurrentDate}" /></td>
			
			<td class="multiControl" width="25%" colspan="1">
			<!-- <img style="cursor: pointer; " title="Get Gifted Item Details" src="../../hisglobal/images/Go.png" onclick="return getGiftedViewDetails();"/> -->
			<a href="#" class="button" id="go" onclick="return getGiftedViewDetails();"></a>
			</td>
			
		</tr>         
         
	   <tr >
			<td style="display: none;" width="50%" class="LABEL" colspan="2">Gifted Details For Financial Year</td>
			<td style="display: none;" width="25%" class="CONTROL" colspan="1"><div id="finYearDivId"></div>
			</td>
						
	   </tr>
	  </table>
	  
	  	<div id="giftedViewDetailsDivId" style="display: none">
	   
	  	</div>
	  
	 </div>
		 
		 <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
                
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	
	<div id="viewCancelButtonDivId" style="display: none">
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	               <!--  <img style="cursor:pointer;" title="Click to Return Main Screen" src="../../hisglobal/images/btn-ccl.png" onClick="cancelViewPage();" /> -->
	                <a href="#" class="button" onclick="cancelViewPage();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>	
	</div>
<input type="hidden" name="hmode"/>

<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strItemCategoryName" value=""/>
<input type="hidden" name="strCurrentDate" value="${giftedItemDetailsTransBean.strCurrentDate}" />

</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>
