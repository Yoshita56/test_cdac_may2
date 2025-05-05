<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>

<script language="JavaScript" src="../js/BreakageItemDtlTrans.js"></script>


<script type="text/javascript">
	function controlToMainPage()
	{
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
	}
</script>



</head>
<body>
<html:form action="/transactions/BreakageItemDtlTransCNT.cnt"  name="bkgItemDtlTransBean" type="mms.transactions.controller.fb.BreakageItemDtlTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="bkgItemDtlTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="bkgItemDtlTransBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="bkgItemDtlTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Breakage Item Transaction" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   <tr class="HEADER">
			<td colspan="2"></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="50%" class="CONTROL">
			 	<div id="storeComboID">
			     <select name="strStoreName" class="comboNormal"   onChange="getItemCategoryComboViewPage();">
                        <bean:write name="bkgItemDtlTransBean" property="strStoreName" filter="false"/>
                 </select>
                 </div>
                 <div id="storeComboNameID" style="display:none"></div>
          	</td>
		  </tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Item Category
			</td>
			<td width="50%" class="CONTROL">
			<div id="ItemCatgViewId" >
			     <select class='comboNormal' name='strItemCatgCombo'> 
		              <bean:write name="bkgItemDtlTransBean" property="strItemCatgCombo" filter="false"/><option value="0">Select Value</option>  
		         </select>
		          </div>  
		      <div id=itemCategViewNameID" style="display: none"></div>
          	</td>
		  </tr>
		  
		<tr>
			<td class="LABEL" width="50%" ><font color="red">*</font>From Date</td>
			<td class="CONTROL" width="50%" ><dateTag:date name="strFromDate" value="${bkgItemDtlTransBean.strCurrentDate}" /></td>
		</tr>
		<tr>
			<td class="LABEL" width="50%" ><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="50%" ><dateTag:date name="strToDate" value="${bkgItemDtlTransBean.strCurrentDate}" />   <a href="#" class="button" id="go" onclick="getViewItemDtl();"></a></td>
		</tr>
		
	    </table>
	    
	    <div id="breakageItemDtlId" style="display: none"></div>
	   <!-- 
	    <table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td colspan="2" ></td>
  		</tr>
	     <tr> 
		<td align="center">
			<img src="../../hisglobal/images/btn-ccl.png" onClick ="controlToMainPage();" style="cursor: pointer;" title="Click Here To Move Control Back To Add Page"/>
	   </td>
	  </tr>
</table>-->
<br>
        <div align="center" id="breakageItemDtlId">					 
					 	<a href="#" class="button"	onclick="controlToMainPage();"><span class="cancel">Cancel</span></a> 
		</div> 
    <input type="hidden" name="hmode"/>
    <input type="hidden" name="strCurrentDate" value="${bkgItemDtlTransBean.strCurrentDate}"/>
    
  </html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>