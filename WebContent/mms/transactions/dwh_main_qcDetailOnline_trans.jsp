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

<title>Qc Detail (Online)</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>


<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>


<script language="JavaScript" src="../js/mms.js"></script>



<script language="JavaScript" src="../js/dwh_main_qcDetailOnline_trans.js"></script>


</head>

<body  onLoad="printSampleSentLabel();">

<html:form action="/transactions/QcDetailOnlineTransCNT.cnt"  name="qcDetailOnlineTransFB" type="mms.transactions.controller.fb.QcDetailOnlineTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="qcDetailOnlineTransFB" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="qcDetailOnlineTransFB" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="qcDetailOnlineTransFB" property="strMsg"/></div>


<center>

<tag:tab tabLabel="QC Detail (Online)" selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>


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
				<td colspan="1" class='multiRPTLabel'>PO No.</td>
				<td colspan="1" class='multiRPTLabel'>PO Date</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiPOControl'>
				<div id='1'></div>
				</td>
				<td colspan="1" class='multiPOControl'>
				<div id='2'></div>
				</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiRPTLabel'>Exp. Date</td>
				<td colspan="1" class='multiRPTLabel'>Manuf.Date</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiPOControl'>
				<div id='3'></div>
				</td>
				<td colspan="1" class='multiPOControl'>
				<div id='4'></div>
				</td>
	
			</tr>
			<tr>
				<td colspan="2" class='multiRPTLabel'>Whether Re-Send</td>
				
	
			</tr>
			<tr>
				<td colspan="2" class='multiPOControl'>
				<div id='5'></div>
				</td>
				
	
			</tr>
		</table>
	</div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
		<tr class="HEADER">

		<td colspan="4"></td>
		<td align="right"><span>
			<html:checkbox name="qcDetailOnlineTransFB" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail"></html:checkbox></span>View
		</td>
		</tr>
				
	    </table>
	    
	    <table class="TABLEWIDTH" align="center" cellspacing="1px">
		

		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>HQ Name </td>
			<td width="25%" class="CONTROL">
			
			     <select name="strStoreName" class="comboMax"   onChange="getItemCategoryCombo();">
                        <bean:write name="qcDetailOnlineTransFB" property="strStoreName" filter="false"/>
                 </select>
            </td>
			<td width="25%" class="LABEL"><font color="red">*</font>Drug Category </td>

			<td width="25%" class="CONTROL">
			
			<div id="ItemCatg" >
			     <select class='comboNormal' name='strItemCatgCombo' onChange='getLabNameCombo();'> 
		              <bean:write name="qcDetailOnlineTransFB" property="strItemCatgCombo" filter="false"/>
		         </select>
		     </div>    
						
			  </td>
		    </tr>
		    <tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Lab Name </td>
			<td width="25%" class="CONTROL">
			
			
			<div id="labNameDivId">
			     <select class='comboMax' name='strLabId' onchange="setSampleSentDiv();"> 
		              <bean:write name="qcDetailOnlineTransFB" property="strLabName" filter="false"/><option value="0">Select Value</option>  
		         </select>
            </div>
            </td>
					
			<td class="multiControl" width="25%" colspan="1">
				
			</td>
			<td width="25%" class="CONTROL"><img style="cursor: pointer; " title="Get Details" src="../../hisglobal/images/Go.png" onclick="return getQcOnlineDetails();"/></td>
		</tr>
			
		
		</table>
	<div id="strSampleSentDtlSearchDivId" style="display:none;">	    
       <table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>
		<tr>			   
		<td class='TITLE' style='text-align:right;' >Searching Criteria :::: <select name='strSearchNameCmb' class='comboMax'>
		<option value='1'>Drug Name</option>
		<option value='2'>Batch Number</option>
		</select>
		<input type='text' class='txtFldMax' name='strSearchString' value ='' maxlength='100' onkeypress='if(event.keyCode==13) getSampleSent_With_Search();'>					
		</td>
		</tr>					
		</table>		 
       
      </div>
	 <div id="strSampleSentDtlDivId" ></div>	  
		
			
      
     <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" id="qcDetailsDivId">
     <tr class="HEADER">

		<td colspan="4">QC Details</td>
	</tr>	
	  <tr >
	  		 <td width="50%" class ="LABEL" valign="middle" >QC Status</td>
	  		 <td width="50%" class ="CONTROL" >
			    <html:radio name="qcDetailOnlineTransFB" property="strQcStatus" value="1" />Approved
			     <html:radio name="qcDetailOnlineTransFB" property="strQcStatus" value="2" />Rejected
			    
			    
		     </td>
		    
		     
		     
	  </tr>
	</table>
		
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"	cellspacing="1px">
	
	    <tr>
               	<td  width="25%" class="LABEL"><font size="2" color="red">*</font>CTR No.</td>
			    <td width="25%" class="CONTROL"><input type="text" class="txtFldNormal" name="strCTRNumber" value ="" maxlength="10" onkeypress="return validateData(event,8);"></td>	
				<td class="LABEL" width="25%"><font color="red">*</font>Received Date</td>
				<td class="CONTROL" width="25%"><dateTag:date name="strReceiveDate" value=""></dateTag:date>  </td>
		</tr>
	    <tr>
	            <td class="LABEL" width="25%"><font color="red">*</font>Report No</td>
				<td class="CONTROL" width="25%"> <input type="text" class="txtFldMax" name="strReportNumber" onkeypress="return validateData(event,16);" maxlength="50"></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Report Date</td>
				<td class="CONTROL" width="25%"><dateTag:date name="strReportDate" value=""></dateTag:date>  </td>
		</tr>
	
	  
	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"	cellspacing="1px">
 	  <tr >
 	   		<td width="25%" colspan="1" class ="LABEL" valign="middle" >Lab Incharge Name</td>
 	 		 <td width="25%" colspan="1" class ="CONTROL" >
			    <input type="text" name="strLabInchargeName">
		    </td>
 	  
		    <td width="25%" class ="LABEL" colspan="1"  >Remarks(Lab)</td>
		    <td width="25%" class ="CONTROL" colspan="1">
			    <textarea  name="strRemarksLab"  onkeypress="return validateData(event,9);"></textarea>
		    </td>
		      
 	 </tr>                
     </table>  
     
<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
    <tr>  
     <td width="5%" class="TITLE" align="center">
     <input type='hidden' name='button1' value="0">
     <img src="../../hisglobal/images/plus.gif"   id="plus1"  style="display:block;cursor:pointer" onClick="ftn11();">
     <img src="../../hisglobal/images/minus.gif"  id="minus1" style="display:none;cursor:pointer" onClick="ftn11();"></td>
     
    <td colspan="3" class="TITLE" align="left"><b>Reference Detail</b></td>   
  </tr>
 </table>
      
 <div id = "referenceDetailsDivId" style="display:none;">
  <table class="TABLEWIDTH" align="center" cellspacing ="1px">
  <tr>
      <td width="25%" class ="LABEL" colspan="1">File/Page No.</td>
       <td width="25%" colspan="1" class ="CONTROL" >
		   <input type="text" name="strFileNo" onkeypress="return validateData(event,9);" maxlength="35"> /
		   <input type="text" name="strPageNo" onkeypress="return validateData(event,5);" maxlength="5">
	   </td>
  </tr>
  
  <tr>
		<td width="25%" class ="LABEL" colspan="1">File Name</td>
		<td width="25%" colspan="1" class ="CONTROL" >
		   <input type="file" name="strFileName">
		 
	   </td>
  </tr>
  
  <tr>
  			<td width="25%" class ="LABEL" colspan="1"  >Remarks</td>
		    <td width="25%" class ="CONTROL" colspan="1">
			    <textarea  name="strRemarks"  ></textarea>
		    </td>
  </tr>
  
  
 </table>
 </div>
     
            
     <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>  
      
	<table  class="TABLEWIDTH" align="center">
	  <tr id="saveId">
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" />
			</td>
		</tr>
	</table>	
	
    
    <input type="hidden" name="hmode"/>
    
      <input type="hidden" name="strCurrentDate" value="${qcDetailOnlineTransFB.strCurrentDate}"/>
      <input type="hidden" name="strIsView" value="0"/>
      <input type="hidden" name="strTmpStoreNo" value="${qcDetailOnlineTransFB.strTmpStoreNo}"/>
      <input type="hidden" name="strTmpIssueNo" value="${qcDetailOnlineTransFB.strIssueNo}"/>
	  <input type="hidden" name="strTmpIndentNo" />
	  <input type="hidden" name="strTmpIndentDate" />
	  <input type="hidden" name="strIndentDate" value="${qcDetailOnlineTransFB.strIndentDate}"/>
	  <input type="hidden" name="strReOrderFlgColor" value="${qcDetailOnlineTransFB.strReOrderFlgColor}"/>
	  <input type="hidden" name="strDemandActivePrd" value="${qcDetailOnlineTransFB.strDemandActivePrd}"/>
	  <input type="hidden" name="strIsDemandActiveFlag" value="${qcDetailOnlineTransFB.strIsDemandActiveFlag}"/>	
	  <input type="hidden" name="strPrintValues" value="${qcDetailOnlineTransFB.strPrintValues}" />
	  <input type="hidden" name="strLabSendNumber" value="${qcDetailOnlineTransFB.strLabSendNumber}" />
	   <input type="hidden" name="strTmpPrintValues" />
      <input type="hidden" name="strTmpCtrNo" value="${qcDetailOnlineTransFB.strTmpCtrNo}" />
       <input type="hidden" name="strSampleSendDate"/>	  
	   <input type="hidden" name="strDemandTypeFlg" />
	   <input type="hidden" name="strTmpIssuingStoreId" />
	    <input type="hidden" name="strTmpRaisingStoreId" />
	    <input type="hidden" name="strCheckHiddenValues" />
	    <input type="hidden" name="strChkFlag" />
	 
      
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