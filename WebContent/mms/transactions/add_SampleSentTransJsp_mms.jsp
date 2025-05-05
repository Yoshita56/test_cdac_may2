<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



<html>
<head>
<meta charset=UTF-8">
<title>Sample Sent Details[Lab]</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>	
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/sampleSentTrans.js"></script>
<script language="JavaScript">



</script>

</head>
<body>
<html:form name="sampleSentTransBean" action="/transactions/SampleSentTransCNT" type="mms.transactions.controller.fb.SampleSentTransFB">
	<div id="errMsg" class="errMsg"><bean:write name="sampleSentTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="sampleSentTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="sampleSentTransBean" property="strMsg" /></div>
	
	<tag:tab tabLabel="Sample Sent Details[Lab]" selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
              
              <table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
	   		   	
		<tr class="HEADER">

			<td colspan="3" style="width: 433px"></td>
			<td colspan="3" align="right">
			
			<div align="right">
	             <input type="checkbox" name="strReSendMode" value="1" onClick="changeViewMode1(this);"/>Re-Send
			     <input type="checkbox" name="strViewMode" value="2"  onClick="changeViewMode2(this);"/>View
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
			<font color="red">*</font>Drug Category
			</td>
			<td width="25%" class="CONTROL">
			<div id="itemCategoryDivId">
			<select name="strItemCategoryId" class='comboNormal'>
				<bean:write name="sampleSentTransBean" property="strItemCategoryCombo" filter="false" />
					</select></div></td>		
	   </tr>
	   
	   <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>Drug Name
			</td>
			<td width="25%" class="CONTROL">
			<div id="drugNameDivId">
			    <select name='strDrugBrandId' class='comboNormal'>
		 			                <option title='Select Value' value='0'>Select Value</option>
                </select>
					
			</div>		
					</td>
			
			
			<td  width="25%" class="LABEL">
			<font color="red">*</font>Batch No
			</td>
			<td width="25%" class="CONTROL">
			<div id="batchNoDivId">
			<select name='strBatchNo' class='comboNormal'>
		 			                <option title='Select Value' value='0'>Select Value</option>
                </select></div></td>		
	   </tr>
	   
	   
	   </table>
	    <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	   
	   <tr>
	   <td colspan="4" class="TITLE">
	    <div id="batchName" align="left">
	       Sample Details For Batch No : 
	    </div>
	   </td>
	   </tr>
	    <tr>
			<td width="25%" class="LABEL">Avl Qty.</td>
			<td width="25%" class="CONTROL"><div id="avQtyDivId"></div></td>
			
			<td  width="25%" class="LABEL">Supp. Name</td>
			<td width="25%" class="CONTROL"><div id="mfgNameDivId"></div></td>		
	   </tr>
	   
	   <tr>
			<td width="25%" class="LABEL">Mfg. Date</td>
			<td width="25%" class="CONTROL"><div id="mfgDateDivId"></div></td>
			
			<td  width="25%" class="LABEL">Expiry Date</td>
			<td width="25%" class="CONTROL"><div id="expDateDivId"></div></td>		
	   </tr>
	   
	   <tr>
			<td width="25%" class="LABEL">PO No. & PO Date</td>
			<td width="25%" class="CONTROL"><div id="poNoDateDivId"></div></td>
			
			<td  width="25%" class="LABEL">Supplier Name</td>
			<td width="25%" class="CONTROL"><div id="SupplierNameDivId"></div></td>		
	   </tr>
	   
	   </table>
	   
	
	
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	   
	   <tr>
	   <td colspan="4" class="TITLE">
	    <div align="left">
	       Send Detail(s)
	    </div>
	   </td>
	   </tr>
	    <tr>
			<td width="25%" class="LABEL"><font size="2" color="red">*</font>Issue Qty.</td>
			<td width="25%" class="CONTROL"><input type="text" class="txtFldNormal" name="strSampleIssueQty"  id="strSampleIssueQty"  onkeyup="calculateCostOnChange();" onkeypress="return validateData(event, 5);" maxlength="3"></td>
			
			<td  width="25%" class="LABEL"><font size="2" color="red">*</font>Unit Name</td>
			<td width="25%" class="CONTROL">
			<div id="unitDivId">
			    <select name='strSampleUnitId' id='strSampleUnitId' class='comboNormal'>
		 			                <option title='Select Value' value='0'>Select Value</option>
                </select>
             </div>   
			</td>		
	   </tr>
	   
	   <tr>
			<td width="25%" class="LABEL"><font size="2" color="red">*</font>Lab Name</td>
			<td width="25%" class="CONTROL">
			   <select name="strLabId" class='comboMax' onChange="setLabName();">
				<bean:write name="sampleSentTransBean" property="strLabNameCombo" filter="false" />
					</select>
			 
			</td>
			
			
			<td width="25%" class="LABEL"><font size="2" color="red">*</font>Secret Code No</td>
			<td width="25%" class="CONTROL"><input type="text" class="txtFldNormal" name="strSampleCodeNumber" value ="" maxlength="10" onkeypress="return validateData(event,17);"></td>	
	   </tr>
	  
	   <tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>Remarks(if any)
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
		<tr>
			<td align="center"><img style="cursor: pointer; "
				title="Click to Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="pageResetMethod();"> <img
				style="cursor: pointer; "
				title="Click to Return Main Menu"
				src="../../hisglobal/images/back_tab.png"
				onClick="cancel('LIST');" /></td>
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
<input type="hidden" name="strPageMode" value="ADD"/>

<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="sampleSenlLabelDivId" style="display:block;"></div>
           
       </td>
     </tr>
    </table>
</div>
</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>