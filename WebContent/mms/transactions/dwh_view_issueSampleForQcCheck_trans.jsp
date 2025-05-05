<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Sample For Qc Check</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
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
<script language="JavaScript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script> 

<script language="JavaScript" src="../js/dwh_main_issueSampleForQcCheck_trans.js"></script>
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

<script type="text/javascript">
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
	}
</script>



</head>
<body>
<html:form action="/transactions/IssueSampleForQcCheckTransCNT.cnt"  name="issueSampleForQcCheckTransFB" type="mms.transactions.controller.fb.IssueSampleForQcCheckTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="issueSampleForQcCheckTransFB" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="issueSampleForQcCheckTransFB" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="issueSampleForQcCheckTransFB" property="strMsg"/></div>


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
			<tr>
				<td colspan="2" class='multiLabel'>Whether Re-Issued</td>
				
	
			</tr>
			<tr>
				<td colspan="2" class='multiControl'>
				<div id='5'></div>
				</td>
				
	
			</tr>
		</table>
	</div>





<tag:tab tabLabel="Sending Sample To RMSC For QC Check " selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	</tag:tab>

     <table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="20%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="20%" class="CONTROL">
			
			     <select name="strStoreName" tabindex="1" class="comboMax"   onChange="getItemCategoryCombo();">
                        <bean:write name="issueSampleForQcCheckTransFB" property="strStoreName" filter="false"/>
                 </select>
            </td>
			<td width="20%" class="LABEL"><font color="red">*</font>Category:</td>

			<td width="20%" class="CONTROL">
			
			<div id="ItemCatg" >
			     <select class='comboNormal' name='strItemCatgCombo' tabindex="1"> 
		              <bean:write name="issueSampleForQcCheckTransFB" property="strItemCatgCombo" filter="false"/><option value="0">Select Value</option>  
		         </select>
		     </div>    
						
			  </td>
		
		    </tr>
		    <tr>
		    	   		
			 <td class="LABEL" width="20%"><font color="red">*</font>From Date</td>
			<td class="CONTROL" width="20%">
				<dateTag:date name="strFromDate" value="${issueSampleForQcCheckTransFB.strFromDate}" ></dateTag:date> </td>
				
				
			<td class="LABEL" width="20%"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="20%"><dateTag:date name="strToDate" value="${issueSampleForQcCheckTransFB.strToDate}" ></dateTag:date></td>
				
	     </tr>	     
       
		<tr>		
		    <td width="25%" class="LABEL">Status</td>
			<td width="25%" class="CONTROL">
				<select name='strSearchNameType' class='comboMax' onChange="hideDataDiv();">
						<option value='1'>All</option>
						<option value='2'>Pending Report</option>
			    </select>
			 </td>	
			<td class="LABEL" width="20%"></td>
		    <td class="multiLabel" width="20%" align="left"><img align="left" src="../../hisglobal/images/Go.png"  onClick="getViewItemDtl();" style="cursor: pointer; "/></td>
		</tr>
	</table>
	    
	    <div id="breakageItemDtlId" style="display: none"></div>
	    
	    <table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ></td>
  		</tr>
	     <tr> 
		<td align="center">
		    <img src="../../hisglobal/images/btn-ccl.png"  onClick ="cancelSampleForQCCheck();" style="cursor: pointer;" title="Click Here To Move Control Back To Add Page" >
		    <img style="cursor:pointer;cursor:pointer"  title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="clearViewPage();">			
			<img style="cursor: pointer" src="../../hisglobal/images/back_tab.png" onClick ="controlToMainPage();" />
	   </td>
	  </tr>
</table>
        
    <input type="hidden" name="hmode"/>
    <input type="hidden" name="strIsView" value="1"/>
     <input type="hidden" name="strRemarks" value=""/>
    
    
    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="issueDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
    
  </html:form>
 

</body>
</html>