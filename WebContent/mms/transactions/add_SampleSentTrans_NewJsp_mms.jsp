<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



<html>
<head>
<meta charset=UTF-8">
<title>Sending Samples From RMSC to Empanelled Labs</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
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
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>	
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/dwh_New_SampleSent_trans.js"></script>
<script language="JavaScript">


</script>

</head>
<body>
<html:form name="sampleSentTransBean" action="/transactions/SampleSentTransCNT" type="mms.transactions.controller.fb.SampleSentTransFB">
	<div id="errMsg" class="errMsg"><bean:write name="sampleSentTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="sampleSentTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="sampleSentTransBean" property="strMsg" /></div>
	
	<tag:tab tabLabel="Sending Samples From RMSC to Empanelled Labs" selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
              
              <table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
	   		   	
		<tr class="HEADER">

			<td colspan="3" style="width: 433px"></td>
			<td colspan="3" align="right">
			
			<div align="right">
	             <input type="checkbox" name="strReSendMode" value="1" onClick="changeViewMode1(this);"/> Re-Send
			     <input type="checkbox" name="strViewMode" value="2"  onClick="changeViewMode2(this);"/> View/Cancel
	          </div>
			</td>
			
		</tr>
				
	    </table>
              
              
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	     
	     <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>HQ Name
			</td>
			<td width="25%" class="CONTROL">
			<select name="strStoreId" class='comboMax' onchange="getItemCategorys(this);">
					<bean:write name="sampleSentTransBean" property="strStoreName" filter="false" />
					</select></td>
			
			<td  width="25%" class="LABEL">
			<font color="red">*</font>Category
			</td>
			<td width="25%" class="CONTROL">
			<div id="itemCategoryDivId">
			<select name="strItemCategoryId" class='comboNormal'>
				<bean:write name="sampleSentTransBean" property="strItemCategoryCombo" filter="false" />
					</select></div></td>		
	   </tr>    
	   <tr>
				<td width="25%" class="LABEL"><font size="2" color="red">*</font>Lab Name</td>
			<td width="25%" class="CONTROL">
			       <select name="strLabId" class='comboMax' onChange="setLabName();">
				        <bean:write name="sampleSentTransBean" property="strLabNameCombo" filter="false" />
					</select>			 
			</td>
				
				
				<td colspan="1" class="LABEL" width="25%">
						
				</td>
								
				<td width="25%" class="LABEL" width="15%" style="text-align:left;"><html:img src="../../hisglobal/images/Go.png" align="left" style="cursor:pointer" title="Click to see Sample Receive Details"   style="display:none;"/></td>
				
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
	  
		
			<table class="TABLEWIDTH" bgcolor='#CC9966' align="center" cellpadding="1px" cellspacing="1px">
	   		
				<tr>
					<td  class="multiRPTLabel" width="30%">Drug Name</td>
					<td  class="multiRPTLabel" width="15%">Batch</td>
					<td  class="multiRPTLabel" width="10%">Avl Qty</td>					
					<td  class="multiRPTLabel" width="10%">Expiry Date</td>									
					<td  class="multiRPTLabel" width="15%"><font size="2" color="red">*</font>Issue Qty</td>
					<td  class="multiRPTLabel" width="20%"><font size="2" color="red">*</font>Secret Code</td>
						
				</tr>
				
				</table>
				
	       <div id="id1"></div>
	    
	   <div id="newSampleSentDivId"></div>
	
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	   
	 
	    <tr class="FOOTER">
			 <td colspan="4"></td>
		</tr>
	   <tr>
			<td class="LABEL" colspan="2">Remarks(if any)
			</td>
			<td class="CONTROL" colspan="2">
			<textarea rows="2" cols="25" name="strRemarks" ></textarea>
			</td>
			</tr>
		
	   
	   </table>
	   <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
                
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center">
		<tr id="saveId">
		  <td align="center">
			<img style="cursor: pointer; " title="Click to Save Record" src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " title="Click to Clear Page" 	src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="pageResetMethod();">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" title="Click to Cancel" onClick="cancel1();" >
		  </td>
		</tr>
	</table>
	
	
<input type="hidden" name="hmode"/>

<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strItemCategoryName" value=""/>
<input type="hidden" name="strItemCategoryCode" value=""/>
<input type="hidden" name="strResendFlag" value="0"/>
<input type="hidden" name="strHiddenBatchDtl"  id="strHiddenBatchDtl" value="${sampleSentTransBean.strHiddenBatchDtl}"/>
<input type="hidden" name="strLabName" value=""/>
<input type="hidden" name="strItemBrandId" value=""/>

<input type="hidden" name="strLabSendNo" value="${sampleSentTransBean.strLabSendNo}"/>
<input type="hidden" name="strPCTRNo" value="${sampleSentTransBean.strPCTRNo}"/>
<input type="hidden" name="strPBatchNo" value="${sampleSentTransBean.strPBatchNo}"/>
<input type="hidden" name="strPManufDate" value="${sampleSentTransBean.strPManufDate}"/>
<input type="hidden" name="strPExpDate" value="${sampleSentTransBean.strPExpDate}"/>
<input type="hidden" name="strPManufBy" value="${sampleSentTransBean.strPManufBy}"/>
<input type="hidden" name="strDrugName" value="${sampleSentTransBean.strDrugName}"/>
<input type="hidden" name="strLabCode" value="${sampleSentTransBean.strLabCode}"/>
<input type="hidden" name="strReOrderFlgColor" value="${sampleSentTransBean.strReOrderFlgColor}"/>


<input type="hidden" name="strPageMode" value="ADD"/>

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
	<jsp:include page="dwh_sampleSent_trans_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>