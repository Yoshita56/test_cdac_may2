<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>QC Details[View]</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
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

<script language="JavaScript" src="../js/dwh_main_qcDetailOnline_trans.js"></script>


<script type="text/javascript">
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
	}
</script>



</head>
<body>
<html:form action="/transactions/QcDetailOnlineTransCNT.cnt"  name="qcDetailOnlineTransFB" type="mms.transactions.controller.fb.QcDetailOnlineTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="qcDetailOnlineTransFB" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="qcDetailOnlineTransFB" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="qcDetailOnlineTransFB" property="strMsg"/></div>


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
				<td colspan="2" class='multiLabel'>Whether Re-Send</td>
				
	
			</tr>
			<tr>
				<td colspan="2" class='multiControl'>
				<div id='5'></div>
				</td>
				
	
			</tr>
		</table>
	</div>





<tag:tab tabLabel="QC Detail View" selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	</tag:tab>

     <table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="5"></td>
		</tr>

		<tr>
			<td width="20%" class="LABEL"><font color="red">*</font>HQ Name</td>
			<td width="20%" class="CONTROL">
			
			     <select name="strStoreName" tabindex="1" class="comboMax"   onChange="getItemCategoryCombo();">
                        <bean:write name="qcDetailOnlineTransFB" property="strStoreName" filter="false"/>
                 </select>
            </td>
			<td width="20%" class="LABEL"><font color="red">*</font>Drug Category:</td>

			<td width="20%" class="CONTROL">
			
			<div id="ItemCatg" >
			     <select class='comboNormal' name='strItemCatgCombo' tabindex="1"> 
		              <bean:write name="qcDetailOnlineTransFB" property="strItemCatgCombo" filter="false"/>  
		         </select>
		     </div>    
						
			  </td>
			   <td class="multiLabel" width="20%"></td>
		    </tr>
		    <tr>
		    <td width="25%" class="LABEL">Lab Name</td>
		    <td width="25%" class="CONTROL">
			<div id="labNameDivId">
			     <select class='comboMax' name='strLabId' > 
		               <bean:write name="qcDetailOnlineTransFB" property="strLabName" filter="false"/><option value="0">All</option>		                
		         </select>
            </div>
            </td>
		    <td width="25%" class="CONTROL"></td>
		    <td width="25%" class="CONTROL"></td>
		     <td width="25%" class="CONTROL"></td>
		    
		    </tr>

		   <tr>
			<td class="LABEL" width="20%">From Date</td>
			<td class="CONTROL" width="20%">
				<dateTag:date name="strFromDate" value="${qcDetailOnlineTransFB.strFromDate}" ></dateTag:date> </td>
			<td class="LABEL" width="20%">To Date</td>
			<td class="CONTROL" width="20%">
				<dateTag:date name="strToDate" value="${qcDetailOnlineTransFB.strToDate}" ></dateTag:date> </td>
		    <td class="multiLabel" width="20%">
		    	<img src="../../hisglobal/images/Go.png" tabindex="1" onClick="getViewItemDtl();" style="cursor: pointer; "/></td>
		</tr>
	</table>
	    
	    <div id="strSampleSentDtlDivId" style="display: none"></div>
	    <div id="strSampleSentDtlSearchDivId" style="display:none;"></div>
	    
	    <table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ></td>
  		</tr>
	     <tr> 
		<td align="center">
		    <img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="printSampleSentLabelView();" />
		    <img style="cursor:pointer;cursor:pointer" tabindex="1" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="clearViewPage();">
			<img src="../../hisglobal/images/btn-ccl.png" tabindex="1" onClick ="controlToMainPage();" style="cursor: pointer;" title="Click Here To Move Control Back To Add Page"/>
	   </td>
	  </tr>
</table>
        
    <input type="hidden" name="hmode"/>
    <input type="hidden" name="strIsView" value="1"/>
    
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
 

</body>
</html>