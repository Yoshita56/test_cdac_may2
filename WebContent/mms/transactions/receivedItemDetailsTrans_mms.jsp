<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
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
<script language="JavaScript" src="../js/receivedItemDetails.js"></script>
<script language="JavaScript">



</script>

</head>
<body >
<html:form name="receiveFromThirdPartyTransBean" action="/transactions/ReceiveFromThirdPartyTransCNT" type="mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB">
	<div id="errMsg" class="errMsg"><bean:write name="receiveFromThirdPartyTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="receiveFromThirdPartyTransBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="receiveFromThirdPartyTransBean" property="strNormalMsg" /></div>
	
	<tag:tab tabLabel="Received From Third Party Details" selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>      
              
              
              
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	     <tr class="HEADER">
			<td colspan="3">Received From Third Party Details</td>
			
			
			 <td colspan="1" align="right" >
		     	<span>
		     		<html:checkbox property="strReceivedItemViewMode" name="receiveFromThirdPartyTransBean" value="3" onclick="changeViewMode(this);">View</html:checkbox>
		     		
		     	</span>
		     </td>	
			
		</tr>
		
		 <tr style="display: none;">
	   <td colspan="4" class="TITLE">
	   
	    <div align="right" > 
	        <input type="radio"  name="strReceivedItemApprovedMode" value="4" checked="checked" onClick="changeViewMode(this);"/>
			NEW <input type="radio" name="strReceivedItemStockUpdateMode" value="2" onClick="changeViewMode(this);"/>UPDATE STOCK
			<input type="radio" name="strReceivedItemViewMode" value="3"  onClick="changeViewMode(this);"/>VIEW
	    </div>
	    
	   </td>
	   </tr>
	    <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="25%" class="CONTROL">
			<select name="strStoreId" class='comboMax' onchange="reSetViewDetails(),getItemCategorys(this);">
					<bean:write name="receiveFromThirdPartyTransBean" property="strStoreNameCombo" filter="false" />
					</select></td>
			
			<td  width="25%" class="LABEL">
			<font color="red">*</font>Item Category
			</td>
			
			<td width="25%" class="CONTROL">
				<div id="itemCategoryDivId">
					<select name="strItemCategoryId" class='comboNormal'>
						<bean:write name="receiveFromThirdPartyTransBean" property="strItemCategoryCombo" filter="false" />
					</select>
				</div>
		   </td>		
	   </tr>
	   
	   </table>
	   
	   <div id="itemDetailsMode" style="display: block">
	   <table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	 	   
	   <tr>
			<td width="25%" colspan="2" class="LABEL">
			<font color="red">*</font>Third Party Name
			</td>
			<td width="25%" colspan="2" class="CONTROL">
			<select class="comboMax" name="strInstituteId">
			<bean:write name="receiveFromThirdPartyTransBean" property="strInstituteValues" filter="false"/>
			</select>
			</td>
				
	   </tr>
	   <tr>
	   <td width="50%" colspan="2" class="LABEL">
			Remarks
			</td>
			<td width="50%" colspan="2" class="CONTROL">
        		<textarea name="strRemarks" rows="2" cols="18"></textarea>
             </td>	
	   </tr>
	   <tr>
	   <td colspan="4" class="" align="center">
	   <!-- <img style="cursor: pointer; " title="Get Gifted Item Details" src="../../hisglobal/images/Go.png" onclick="return getInventoryDtls();"/> -->
	   <a href="#" class="button" id="go"	onclick="return getInventoryDtls();"></a> 
	   </td>
	   </tr>
	  </table>
	  </div> 
	 
	 <div id="giftedItemViewMode" style="display: none">
	 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	 
	 <tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate" value="${receiveFromThirdPartyTransBean.strCurrentDate}" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" ><dateTag:date name="strToDate" value="${receiveFromThirdPartyTransBean.strCurrentDate}" /></td>
			
			<td class=" " align="center">
			<!-- 	<img style="cursor: pointer; " title="Get Received Item Details" src="../../hisglobal/images/Go.png" onclick="return getReceivedViewDetails();"/> -->
				<a href="#" class="button" id="go"	onclick="return getReceivedViewDetails();"></a> 
			</td>
			
		</tr>      
	    
	   <tr style="display: none;">
			<td width="50%" class="LABEL" colspan="2">
			Gifted Details For Financial Year
			</td>
			<td width="25%" class="CONTROL" colspan="1"><div id="finYearDivId"></div>
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
	<!-- 
	<div id="viewCancelButtonDivId" style="display: none">
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;" title="Click to Return Main Screen" src="../../hisglobal/images/btn-ccl.png" onClick="cancelViewPage();" />
			</td>
		</tr>
	</table>	
	</div>
	-->
	<br>
	<div align="center" id="viewCancelButtonDivId">					 
					 	<a href="#" class="button" onclick="cancelViewPage();"><span class="cancel">Cancel</span></a>
					</div>
<input type="hidden" name="hmode"/>

<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strItemCategoryName" value=""/>
<input type="hidden" name="strItemCategoryCode" value=""/>
<input type="hidden" name="strInstituteName" value=""/>
<input type="hidden" name="strStatus" value=""/>
<input type="hidden"  name="strConfigIssueRate"  value="">
<input type="hidden" name="strCurrentDate" value="${receiveFromThirdPartyTransBean.strCurrentDate}" />

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>