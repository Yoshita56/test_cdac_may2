<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Insert Title Here</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
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
<script language="JavaScript" src="../js/OffLineIssueItemDtl.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script> 

<script type="text/javascript">
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
	}
</script>



</head>
<body>
<html:form action="/transactions/OfflineIssueIndentTransCNT.cnt"  name="offlineIssueIndentBean" type="mms.transactions.controller.fb.OfflineIssueIndentTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="offlineIssueIndentBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="offlineIssueIndentBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="offlineIssueIndentBean" property="strMsg"/></div>

<center>

<tag:tab tabLabel="Issue Register(Off-Line) View" selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>

     <table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="5"></td>
		</tr>

		<tr>
			<td width="20%" class="LABEL"><font color="red">*</font>Store Name:</td>
			<td width="20%" class="CONTROL">
			
			     <select name="strStoreName" class="comboMax"   onChange="getItemCategoryCombo();">
                        <bean:write name="offlineIssueIndentBean" property="strStoreName" filter="false"/>
                 </select>
            </td>
			<td width="20%" class="LABEL"><font color="red">*</font>Item Category:</td>

			<td width="20%" class="CONTROL">
			
			<div id="ItemCatg" >
			     <select class='comboNormal' name='strItemCatgCombo'> 
		              <bean:write name="offlineIssueIndentBean" property="strItemCatgCombo" filter="false"/>
		         </select>
		     </div>    
						
			  </td>
			   <td class="multiLabel" width="20%"></td>
		    </tr>
		    <tr>
</table>
		    
	    <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 
		<tr>
			<td class="LABEL" width="20%">From Date</td>
			<td class="CONTROL" width="20%"><dateTag:date name="strFromDate" value="${offlineIssueIndentBean.strFromDate}" ></dateTag:date> </td>
			<td class="LABEL" width="20%">To Date</td>
			<td class="CONTROL" width="20%"><dateTag:date name="strToDate" value="${offlineIssueIndentBean.strToDate}" ></dateTag:date> </td>
		    <td class="multiLabel" width="20%">	
		   <!--  <img src="../../hisglobal/images/Go.png" onClick="getViewItemDtl();" style="cursor: pointer; "/> -->
		    <a href="#" class="button" id="go" onclick="getViewItemDtl();"></a>
			</td>
		</tr>
	</table>
	    <!-- 
	    <div id="breakageItemDtlId" style="display: none"></div>
	    
	    <table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ></td>
  		</tr>
	     <tr> 
		<td align="center">
			<img src="../../hisglobal/images/btn-ccl.png" onClick ="controlToMainPage();" style="cursor: pointer;" title="Click Here To Move Control Back To Add Page"/>
	   </td>
	  </tr>
</table> -->
<br>
        <div align="center" id="breakageItemDtlId">					 
					 	
					</div> 
					<div align='center'><a href="#" class="button"	onclick="controlToMainPage();"><span class="cancel">Cancel</span></a> </div>
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
    
  </html:form>
  
</body>
</html>