<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="combPer"%>

<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Adil Wasi
 * Version : 1.0
 * Date : 09-Jan-2012
 * Modify Date : 
*/
-->
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
<title>Sample Receiving At RMSC</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/patientListing.js"></script>
<script language="JavaScript" src="../js/dwh_main_sampleReceiveDetailProcess_trans.js"></script>
</head>
<body>
	<html:form action="/transactions/SampleReceiveDetailProcessTransCNT.cnt"  name="sampleReceiveDetailProcessTransFB" type="mms.transactions.controller.fb.SampleReceiveDetailProcessTransFB" method="post">
	    <div class="errMsg"     id="errMsg"><bean:write name="sampleReceiveDetailProcessTransFB" property="strErrMsg"/></div>
		<div class="warningMsg" id="warningMsg"><bean:write name="sampleReceiveDetailProcessTransFB" property="strWarningMsg"/></div>
		<div class="normalMsg"  id="normalMsg"><bean:write name="sampleReceiveDetailProcessTransFB" property="strNormalMsg"/></div>
	    
	   
	       <tag:tab tabLabel="Sample Receiving At RMSC" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
	
	    <div id="Staff" style="display:none">
	      <tag:tab tabLabel="Sample Receiving At RMSC" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
	    </div>
		
	  
		 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
				<tr class="HEADER"> 
					 <td width="85%" ></td>
			   
				     <td width="30" align="right" >
				     	<span>
				     		<html:checkbox property="strViewCheckBox" name="sampleReceiveDetailProcessTransFB" value="1" onclick="changeViewMode(this);">View</html:checkbox>
				     	</span>
				     </td>	    
			  </tr>
		  </table>
		  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
			<tr>
				<td colspan="1" class="LABEL" width="25%">
					<font color="red">*</font>HQ Name		
				</td>
				
				<td colspan="1" class="CONTROL" width="25%">
					<div id="drugWareHouseDivId">
					<html:select name="sampleReceiveDetailProcessTransFB" property="strDrugWareHouseId" styleClass="comboMax" onchange="itemCategoryCombo();"   >
					
                  <bean:write name="sampleReceiveDetailProcessTransFB" property="strDrugWareHouseNameCmb" filter="false"/>
					</html:select>
					</div>
				</td>
				
				
				<td colspan="1" class="LABEL" width="25%">
					<font color="red">*</font>Category		
				</td>
				<td colspan="1" class="CONTROL" width="25%">
					<div id="itemCategoryId">
					<html:select property="strItemCategoryNo" styleClass='comboNormal' onchange="drugWareHouseCombo();">
							<bean:write name="sampleReceiveDetailProcessTransFB" property="strItemCatNoCmb"filter="false" />
														
					</html:select></div>
				</td>
				
				
				
			</tr>
			<tr>
				<td colspan="1" class="LABEL" width="25%">
					<font color="red">*</font>DWH Name		
				</td>
				
				<td colspan="1" class="CONTROL" width="25%">
					<div id="sampleSentDWHId">
					      <html:select property="strSampleSentDWHId" styleClass='comboNormal' onchange='hideDrugDtlDiv();'>
							<bean:write name="sampleReceiveDetailProcessTransFB" property="strSampleSentDWHCombo"filter="false" />
														
					    </html:select>
					</div>
				</td>
				
				<td colspan="1" class="LABEL" width="25%">
					<font color="red">*</font>Drug Name		
				</td>
				<td colspan="1" class="CONTROL" width="25%">
					<div id="drugNameCmbDivId">
					     <html:select property="strItemBrandID" styleClass='comboNormal' onchange='batchNameCombo();'>
							<bean:write name="sampleReceiveDetailProcessTransFB" property="strItemBrandIDCombo"filter="false" />														
					    </html:select>
					</div>
				</td>				
			</tr>
			<tr>
				<td colspan="1" class="LABEL" width="25%">
					<font color="red">*</font>Batch No		
				</td>
				
				<td colspan="1" class="CONTROL" width="25%">
					<div id="batchDivId">
					     <select name="strBatchNo" class='comboNormal' >
								<option value="0">All</option>
					     </select>
					</div>
				</td>
				
				
				<td colspan="1" class="LABEL" width="25%">
						
				</td>
								
				<td width="25%" class="LABEL" width="15%" style="text-align:left;"><html:img src="../../hisglobal/images/Go.png" align="left" style="cursor:pointer" title="Click to see Sample Receive Details" onclick="getIssueDrugDetailsHlp();" /></td>
				
			</tr>
			</table>
			<!--  
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
			<tr>
				<td colspan="1" class="LABEL" width="40%" ></td>
				<td width="15%" class="LABEL" align="center"><html:img src="../../hisglobal/images/Go.png" style="cursor:pointer;align:center" title="Click to see Sample Receive Details" onclick="getIssueDrugDetailsHlp();" />	</td>
				<td colspan="1" class="LABEL" width="45%" ></td>
			</tr>
		</table>
	     -->
		<div id="sampleRecDtlsHlpDivId" style="display:block;"></div>
			
		<div id="showButtonID" style="display:block;"> 
			<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
				<tr class="FOOTER">
					 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
				</tr>
			</table>
			<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
				
				<tr id="saveId">
		
					<td align="center">
					<img style="cursor: pointer" src="../../hisglobal/images/btn-sv.png" title="Click to Save Record" onClick="validate1();" />
					<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" title="Click to Clear" onClick="pageResetMethod(1);" >
					<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" title="Click to Cancel" onClick="cancel();" >
					</td>
					
				</tr>
			</table>
	
		</div>
		
		<html:hidden name="sampleReceiveDetailProcessTransFB" property="strDrugWareHouseName"/>
		<input type="hidden" name="hmode"/>
  </html:form>
</body>
</html>