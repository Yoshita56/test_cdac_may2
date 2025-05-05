<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<html> 
<head>
<meta charset=UTF-8">
<title>Physical Stock Verification</title>
 <!-- <link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">-->
  <link href="/HBIMS/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="/HBIMS/hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="/HBIMS/hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="/HBIMS/hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="/HBIMS/hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<!--   <link href="../../hisglobal/css/bootstrap.min.css" rel="stylesheet" type="text/css">--> 



<style type="">
.circle{
    -webkit-border-radius:8px;
    -moz-border-radius:8px;
    border-radius:8px;
    border:1px solid #faad07;
    width:15px;
    height:15px;
    background-color:green;
}
.circle1{
    -webkit-border-radius:8px;
    -moz-border-radius:8px;
    border-radius:8px;
    border:1px solid #faad07;
    width:15px;
    height:15px;
    background-color:yellow;
}
</style>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script type="text/javascript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script type="text/javascript" src="../../hisglobal/js/commonFunctions.js"></script>	
<script type="text/javascript" src="/HBIMS/mms/js/master.js"></script>
<script type="text/javascript" src="../../hisglobal/js/tab.js"></script>
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script type="text/javascript" src="../../hisglobal/js/validation.js"></script>
<script type="text/javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript" src="../../hisglobal/js/popup.js"></script>
<script type="text/javascript" src="../../hisglobal/js/newpopup.js"></script>
<script type="text/javascript" src="../../hisglobal/js/multirow.js"></script>
<script type="text/javascript" src="../../hisglobal/js/innerxhtml.js"></script>
<script type="text/javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script type="text/javascript" src="../js/NewPhysicalStockDtl.js"></script>

</head>

<body class="background" onload="costReq();">
<!-- for page loding start-->
	<div id="mask" style="display:none;"></div>
	<div id="dvLoading" style="display:none;"></div>
<!-- for page loding end-->	
<html:form name="physicalNewStockTransBean"
	action="/transactions/PhysicalNewStockVerfTransCNT"
	type="mms.transactions.controller.fb.PhysicalNewStockVerfTransFB" styleClass="formbg">

    <div class="errMsg"     id="errMsg"><bean:write name="physicalNewStockTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="physicalNewStockTransBean" property="strWarning"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="physicalNewStockTransBean" property="strMsgSaved"/></div>
	
     <table class="TABLEWIDTH" align="center" cellspacing="1px"> 	   		   	
		<tr class="HEADER">
			<td colspan="4">Physical stock verification</td>
		</tr>				
	 </table>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
			
		<tr>
			<td width="25%" class="LABEL"><font size="2" color="red">*</font>Store Name</td>
			<td width="25%" class="CONTROL">
			
			  <div id="storeCmbDivIdOne">
			     <select name="strStoreName" class="comboMax"  tabindex="1" onChange="getPhyDetails(1);getCatName();">
                        <bean:write name="physicalNewStockTransBean" property="strStoreName" filter="false"/>
                 </select>
              </div>
              <div id="storeCmbDivIdTwo" style="display:none;">
              </div> 	
			</td>
			
			<td width="25%" class="LABEL"><font size="2" color="red">*</font>Category Name</td>
			<td width="25%" class="CONTROL">
			
			  <div id="catCmbDivIdOne">
			     <select name="strCategorycode" class="comboMax"  tabindex="1" >
			       <bean:write name="physicalNewStockTransBean" property="strCatName" filter="false"/>
                 </select>
                
			
			</tr>
			<tr id='fin' style='display:none'>
              <div id="storeCmbDivIdTwo" style="display:none;">
              </div> 	
			</td>

			<td width="25%" class="LABEL">Current Financial Year</td>
			<td width="25%" class="CONTROL">	
		     <div id="fyId" ></div>
		    </td>

		
		<td  width="25%" class="LABEL">Last Verified Date</td>
			<td width="25%"  class="CONTROL">
			   <div id="lastVerifyDateId" ></div>
			</td>
		
		
		
		
	</tr>
		<tr>
		 <td  colspan="4" class="LABEL"><div align="center"><img style="cursor: pointer;text-align:center;"  title="Get Item Challan Details" src="../../hisglobal/images/Go.png" onclick="getVerifiedItemHLP();"/></div></td>
		
		</tr>
		
	 </table>
     <div id="phyRequestDtls" style="display:none;">
         <bean:write name="physicalNewStockTransBean"  property="strPhyStockRequestDtls" filter="false" />
     </div> 
     
     <div id="phyStockVerifiedItemDtls" style="display:none;">
         <bean:write name="physicalNewStockTransBean"  property="strPhyStockVerifiedItemDtls" filter="false" />
     </div> 	    
	 <br>
	<div id="multiRowHeader" style="display:none;">	
	 
	 <!--  <div id="withImage">
		  <div class="line" id="withImage">
				<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
					cellpadding="1px">
					<tr>
						<td><div id="issueDisp"><img src="../../hisglobal/images/plus.gif" id='imgStockDetails' style="cursor: pointer;" 	onclick='showOrHideStockDetails(this)' title='Hide'> New Batch Detail </div></td>
					</tr>
				</table>
				
			</div>
	 </div> -->
	 
	  <div id="withImage">
	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	 <tr>
	    <td width="100%" class="LABEL"></td>
		</tr> 
	<tr class="FOOTER">
				 <td colspan="4" align="left"><div id="issueDisp"><img src="../../hisglobal/images/plus.gif" id='imgStockDetails' style="cursor: pointer;" 	onclick='showOrHideStockDetails(this)' title='Hide'> New Batch Detail </div></td>
			</tr>
	</table>	
	 </div>
	 
	 <div id="withOutImage" style="display:none;">
		 <div class=" " >
			<!-- <table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
				cellpadding="1px">
				<tr>
					<td><div id="issueDisp"> New Batch Detail </div></td>
					
				</tr>
			</table> -->
			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	 		<tr>
	    		<td width="100%" class="LABEL"></td>
				</tr> 
				<tr class="HEADER">
				 <td colspan="4"><div id="issueDisp"> New Batch Detail </div></td></td>
			</tr>
	</table>	
			
		</div>
	 </div>	
	 
		
		    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
			
			<tr>
			
			<td width="20%" class="multiPOLabelNew"  bordercolor="black">
			Drug Name
			</td>
			<!-- <td width="18%" class="multiPOLabelNew"  bordercolor="black">
			Programme Name
			</td> -->
			<td width="10%" class="multiPOLabelNew" bordercolor="black">
				Batch No.
			</td>
			<td width="10%" class="multiPOLabelNew" bordercolor="black">
				Stock Status
			</td>
			<td width="8%" class="multiPOLabelNew" bordercolor="black">
				Expiry Date
			</td>
			<td width="10%" class="multiPOLabelNew" bordercolor="black">
				Counted Qty.
			</td>
			<td width="10%" class="multiPOLabelNew" bordercolor="black">
				Rate/Unit
			</td>
			<td width="10%" class="multiPOLabelNew" bordercolor="black">
				Remarks
			</td>
			<td width="4%" class="multiPOLabelNew" bordercolor="black">
				#
			</td>
			
		</tr>
		</table>
		    
		    <div id="id1"></div>
		   <br> 
		    <div id="newBatchDetails" >
	         
	        </div>
	 
       <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 		  
	     <tr> 
	        <td width="20%" class="LABEL"> Remarks(if any) </td>
	        <td class="CONTROL" colspan="3">
	        <textarea name="strRemarks" cols="30" rows="2" id="strRemarks" tabindex="1"></textarea> </td>
	    </tr>
	</table>
	</div>   
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	 <tr>
	    <td width="100%" class="LABEL"></td>
		</tr> 
	<tr class="FOOTER">
				 <td colspan="4"></td>
			</tr>
	</table>	
		  
	<div id="viewBtn" >
	      <div class="control_button">
			    <table class="TABLEWIDTH" align="center">
					<tr id="saveId">
						<td align="center">
						<div>
						<br>							 							
							<a href="#" class="button"  onclick="initPage();"><span class="clear">Clear</span></a> 
							<a href="#" class="button"	onClick="window.parent.closeTab();"><span class="cancel">Cancel</span></a>
							
						</div>
						</td>
					</tr>
				</table>				
			</div>
	</div>		
	<div id="modifyBtn" style="display:none;">
			<div class="control_button">
			    <table class="TABLEWIDTH" align="center">
					<tr id="saveId">
						<td align="center">
						<div>
							<br>
							<a href="#" class="button"	onClick="return validateModify(1);"><span class="draftsave">Draft</span></a> 
							<a href="#" class="button"  onClick="return validateModify(2);"><span class="save">Final Save</span></a> 
							<a href="#" class="button"  onclick="initPage();"><span class="clear">Clear</span></a> 
							<a href="#" class="button"	onClick="window.parent.closeTab();"><span class="cancel">Cancel</span></a>
							
						</div>
						</td>
					</tr>
				</table>				
			</div>
	</div>
	<div id="verifyBtn" style="display:none;">
			<div class="control_button">
			    <table class="TABLEWIDTH" align="center">
					<tr id="saveId">
						<td align="center">
						<div>
						<br>
							<a href="#" class="button"	onClick="return validateVerify(1);"><span class="draft">Draft</span></a> 
							<a href="#" class="button"  onClick="return validateVerify(2);"><span class="save">Final Save</span></a> 
							<a href="#" class="button"  onclick="initPage();"><span class="clear">Clear</span></a> 
							<a href="#" class="button"	onClick="window.parent.closeTab();"><span class="cancel">Cancel</span></a>
							
						</div>
						</td>
					</tr>
				</table>				
			</div>
	</div>
	<div id="saveBtn" style="display:none;">
			<div class="control_button">
			    <table class="TABLEWIDTH" align="center">
					<tr id="saveId">
						<td align="center">
						<div>
						<br>							
							<a href="#" class="button"  onClick="return validateRequest(1);"><span class="save">Save</span></a> 
							<a href="#" class="button"  onclick="initPage();"><span class="clear">Clear</span></a> 
							<a href="#" class="button"	onClick="window.parent.closeTab();"><span class="cancel">Cancel</span></a>
							
						</div>
						</td>
					</tr>
				</table>				
			</div>
	</div>
	
	<div class="legends" style="width:95%;">
			
			<ul>		
		        <li><font size="2" color="red">*</font> Mandatory Field(s),No Issue Receive Process will be Activated till stock verification completed</li>					
<!--				<li><span class="glyphicon glyphicon-edit"></span> Modify  , <span class="glyphicon glyphicon-remove"></span> Cancel , <span class="glyphicon glyphicon-floppy-disk"></span> Stock Updation , <span class="glyphicon glyphicon-eye-open"></span> View , <span class="glyphicon glyphicon-ban-circle"></span> Activity not Allowed</li>		-->
				<li style="float:none;"><div class="bg-info" style="float:left;margin-right:5px;">Draft Request</div></li>				
				<li style="float:none;"><div class="bg-danger" style="float:left;margin-right:5px;">Negative Tolerance Limit or Negative Variance Qty</div></li>
			</ul>
			
	    </div>	  
      <input type="hidden" name="hmode"/>  
      <input type="hidden" name="firstClickFlg" value="0"/>            
      <input type="hidden" name="strPhyDetails" value="${physicalNewStockTransBean.strPhyDetails}" />   
      <input type="hidden" name="strDraftFlg" value="0"/>
      <input type="hidden" name="strModifyFlg" value="0"/>
      <input type="hidden" name="strRequestDtls" value="0"/>
      <input type="hidden" name="strStockUpdateFlg" value="0"/>
      <input type="hidden" name="strVerifiedPageFlg" value="1"/>
      <input type="hidden" name="strCancelFlg" value="0"/>
      <input type="hidden" name="strStoreNameText" value="-"/>
      <input type="hidden" name="strCurrentDate"  value="${physicalNewStockTransBean.strCurrentDate}" />
      
      <input type="hidden" name="strHtmlCode" value="" />
      
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         <div id="searchItemsDtlsDivId" style="display:block;"></div>
         <div id="issueDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
    
    
</html:form>
<jsp:include page="newPhysical_multirow_mmstrans.jsp"></jsp:include>

</body>
</html>