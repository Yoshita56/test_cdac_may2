<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
<meta charset=UTF-8">
<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            </style>

<title>Insert Title Here</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/OfflineIssueDetails_util.js"></script> 
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script> 
<script language="JavaScript" src="../js/mms.js"></script>



<script language="JavaScript" src="../js/dwh_main_issueSampleForQcCheck_trans.js"></script>


</head>

<body   onload="getReport();">

<html:form action="/transactions/IssueSampleForQcCheckTransCNT.cnt"  name="issueSampleForQcCheckTransFB" type="mms.transactions.controller.fb.IssueSampleForQcCheckTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="issueSampleForQcCheckTransFB" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="issueSampleForQcCheckTransFB" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="issueSampleForQcCheckTransFB" property="strMsg"/></div>


<center>

<tag:tab tabLabel="Sending Sample To RMSC For QC Check " selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>




	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
		<tr class="HEADER">

		<td colspan="4"></td>
		<td align="right"><span>
			<html:checkbox name="issueSampleForQcCheckTransFB" property="strReIssueChk" onclick="setReIssueValue();" title="Click Here To Re-Issue Drug"></html:checkbox>Re-Issue
			<html:checkbox name="issueSampleForQcCheckTransFB" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail"></html:checkbox></span>View/Cancel
		</td>
		</tr>
				
	    </table>
	    
	    <table class="TABLEWIDTH" align="center" cellspacing="1px">
		

		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" class="CONTROL">
			
			     <select name="strStoreName" class="comboMax"   onChange="getItemCategoryCombo();">
                        <bean:write name="issueSampleForQcCheckTransFB" property="strStoreName" filter="false"/>
                 </select>
            </td>
			<td width="25%" class="LABEL"><font color="red">*</font>Item Category </td>

			<td width="25%" class="CONTROL">
			
			<div id="ItemCatg" >
			     <select class='comboNormal' name='strItemCatgCombo' onchange='getHQNameStoreCombo();'> 
		              <bean:write name="issueSampleForQcCheckTransFB" property="strItemCatgCombo" filter="false"/>  
		         </select>
		     </div>    
						
			  </td>
		    </tr>
		    <tr>
			<td width="25%" class="LABEL"><font color="red">*</font>HQ Name </td>
			<td width="25%" class="CONTROL">
			
			
			<div id="IndentingStore">
			     <select class='comboMax' name='strIndentingStoreID'> 
		              <bean:write name="issueSampleForQcCheckTransFB" property="strIndentingStoreID" filter="false"/><option value="0">Select Value</option>  
		         </select>
            </div>
            </td>
					
			 <td class="LABEL"  width="25%"><font color="red">*</font>Issue Date</td>
			<td class="CONTROL" width="25%">
			
       			<dateTag:date name="strIssueDate"  value=""></dateTag:date>
       				      			
			</td>
			
		</tr>
			
		
		</table>
		    
        <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
        <tr class="TITLE">
			<td colspan="6"><div align="right" >
			<img   style="cursor: pointer;height: 20px" title='Click Here To Search Items' height="20" align="middle" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" onclick='getItemSelectPopup();'>
			</div>
			 </td>
		</tr>
        
          
	   </table> 
	  
		
			<table class="TABLEWIDTH" bgcolor="#CC9966" align="center" cellpadding="1px" cellspacing="1px">
	   		
				<tr>
					<td  class="multiRPTLabel" width="25%">Item/Drug Name</td>
					<td  class="multiRPTLabel" width="18%">Batch/SlNo</td>
					<td  class="multiRPTLabel" width="10%">Avl Qty.</td>					
					<td  class="multiRPTLabel" width="12%"><font color='red'>*</font>Issue Qty.</td>
					<td  class="multiRPTLabel" width="15%"><font color='red'>*</font>Unit</td>
						
				</tr>
				
				
				
				</table>
				
	       <div id="id1"></div>
      
     <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
         <tr class="FOOTER">
			 <td colspan="4"></td>
		</tr>
 	  <tr >
		    <td width="25%" class ="LABEL" valign="middle" colspan="1">Remarks</td>
		    <td width="25%" class ="CONTROL" colspan="1">
			    <textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea>
		    </td>
		      <td width="50%" class ="CONTROL" colspan="2">
 	 </tr>                
                
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>  
      
	<table  class="TABLEWIDTH" align="center">
	  <tr id="saveId">
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validateNewDemand();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" />
			</td>
		</tr>
	</table>	
	
    
    <input type="hidden" name="hmode"/>
    
      <input type="hidden" name="strCurrentDate" value="${issueSampleForQcCheckTransFB.strCurrentDate}"/>
      <input type="hidden" name="strIsView" value="0"/>
      <input type="hidden" name="strTmpStoreNo" value="${issueSampleForQcCheckTransFB.strTmpStoreNo}"/>
      <input type="hidden" name="strTmpIssueNo" value="${issueSampleForQcCheckTransFB.strIssueNo}"/>
	  <input type="hidden" name="strTmpIndentNo" />
	  <input type="hidden" name="strTmpIndentDate" />
	  <input type="hidden" name="strIndentDate" value="${issueSampleForQcCheckTransFB.strIndentDate}"/>
	  <input type="hidden" name="strReOrderFlgColor" value="${issueSampleForQcCheckTransFB.strReOrderFlgColor}"/>
	  <input type="hidden" name="strDemandActivePrd" value="${issueSampleForQcCheckTransFB.strDemandActivePrd}"/>
	  <input type="hidden" name="strIsDemandActiveFlag" value="${issueSampleForQcCheckTransFB.strIsDemandActiveFlag}"/>
	  
	  
	  
	   <input type="hidden" name="strDemandTypeFlg" />
	   <input type="hidden" name="strTmpIssuingStoreId" />
	    <input type="hidden" name="strTmpRaisingStoreId" />
	    
	     <input type="hidden" name="strReIssueFlag"  value="${issueSampleForQcCheckTransFB.strReIssueFlag}" />
	     <input type="hidden" name="strReIssueFlagChk"  value="0" />
	 
    
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
          <div id="searchItemsDtlsDivId" style="display:block;"></div>
          
        
       </td>
     </tr>
    </table>
   </div>   
             
</html:form>

<jsp:include page="dwh_issueSampleForQcCheck_trans_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>