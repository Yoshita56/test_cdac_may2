<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



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
<title>Quality Check Control</title>
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

<script language="JavaScript" src="../js/qualityCheckControlTrans_mms.js">




</script>
</head>
<body onload="ViewHideandBlock();">
<html:form action="/transactions/QualityCheckControlTransCNT.cnt" name="qualityCheckControlBean" type="mms.transactions.controller.fb.QualityCheckControlTransFB" method="post" >
	<center><div class="errMsg" id="errMsg"><bean:write name="qualityCheckControlBean" property="strErrorMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="qualityCheckControlBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="qualityCheckControlBean" property="strNoramalMsg" /></div>
		
		<div class='popup' id='drugDtlId' style="display: none">
		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr class="HEADER">
				<td colspan='3'>Details</td>
	
				<th align='right'><img style='cursor: pointer; '
					src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
					onClick="hideDrugDetails('drugDtlId');"></th>
			</tr>
		</table>


		<table width='400' border="0" cellspacing="1" cellpadding="1">
	
			<tr>
				<td colspan="1" class='multiLabel'>PO No.</td>
				<td colspan="1" class='multiLabel'>PO Date</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiControl'>
				<div id='1'></div>
				</td>
				<td colspan="1" class='multiControl'>
				<div id='2'></div>
				</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiLabel'>Exp. Date</td>
				<td colspan="1" class='multiLabel'>Manuf.Date</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiControl'>
				<div id='3'></div>
				</td>
				<td colspan="1" class='multiControl'>
				<div id='4'></div>
				</td>
	
			</tr>

		</table>
	</div>
		
		
	<tag:tab tabLabel="Quality Check Control" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab></center>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
		<td colspan="4"></td>
	</tr>
	<tr class="TITLE" >
		<td align="right" colspan="4"><input name="strView" type="checkbox"
				value="1" onclick="diplayView();">View</td>
	</tr>
	
	
		
	<tr> 
	<td colspan="2" class="LABEL">
			<font color="red">*</font>Store Name		
		</td>
		<td colspan="2" class="CONTROL">
			<div id="StoreDivId" style="display: block;"><select name="strStoreId" class='comboMax' onchange="itemCategory();">
					<bean:write name="qualityCheckControlBean" property="strStoreCmb"filter="false" />
			</select></div>
			<div align="left" id="StoreNameDivId" style="display:none;" >
               			 <bean:write name="qualityCheckControlBean" property="strHidStoreName" filter="false"/>
                </div>
		</td>
		</tr>
		
		
		<tr>
         <td class="LABEL" colspan="2"><font color="red">*</font>Item Category</td>
         <td class="CONTROL" colspan="1">
         
                 <div align="left" id="ItemCatNameId" style="display:block;" >
                  <select name="strItemCategoryNo" class="comboNormal"  >
                        <bean:write name="qualityCheckControlBean" property="strItemCatNoCmb" filter="false"/>
                        <option value="0">Select Value</option>
                 </select>
                 </div>
                <div align="left" id="ItemCatNamedivId" style="display:none;" >
               			 <bean:write name="qualityCheckControlBean" property="strItemCategoryName" filter="false"/>
                </div>
         </td>   
        
       
           <td  class="CONTROL" colspan="1" nowrap> 
            <div align="left" id="imageDivId" style="display:block;" >
            <input type="image" style="cursor:pointer;cursor:pointer" title="Quality Detail" align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" onclick="return goFuncView();" >
           </div>
	     </td>
	    
	</tr>
		 <tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strFromDate" value="${qualityCheckControlBean.strCurrentDate}" /></td>
			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strToDate" value="${qualityCheckControlBean.strCurrentDate}" /></td>
		</tr>
		
	</table>
	
	<div id="qualityDivId" style="display: none;">
	  <bean:write name="qualityCheckControlBean" property="strQualityViewDetails" filter="false"/>
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
	
		<tr>
			<td colspan="4" align="center">
                       
             <img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearViewPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="clearView();" >
            
            </td>
            
		</tr>
	</table>
	
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="hideItemCatId" value="${qualityCheckControlBean.hideItemCatId}"/>
	<input type="hidden" name="displayFlag" value="${qualityCheckControlBean.displayFlag}"/>
	<input type="hidden" name="strItemCategoryName" value="${qualityCheckControlBean.strItemCategoryName}"/>
	<input type="hidden" name="strHidStoreName" value="${qualityCheckControlBean.strHidStoreName}"/>
</html:form>
	<tag:autoIndex></tag:autoIndex>  
</body>
</html>