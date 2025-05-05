<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=utf-8>
<title>Indent Authorization Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language ="javaScript">

function showDetails(divId){
            document.getElementById(divId).style.display="block";                     
            document.getElementById('minus'+divId).style.display="block";
            document.getElementById('plus'+divId).style.display="none";
}

function hideDetails(divId){
			document.getElementById(divId).style.display="none";
            document.getElementById('minus'+divId).style.display="none";
            document.getElementById('plus'+divId).style.display="block";
}


function validate1(){   
     
            var hisValidator = new HISValidator("indentAuthorizationBean");
            hisValidator.addValidation("strEmpId", "dontselect=0", "Please select a value from Employee Name" );
            hisValidator.addValidation("strLevel", "dontselect=0", "Please select a value from Level" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective From is a mandatory field");
		   	hisValidator.addValidation("strEffectiveFrom", "dtgtet=${indentAuthorizationBean.strCtDate}" , "Effective From should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate(); 

 if(retVal){
 	retVal = checkMultirow('strEmpId','Do not Select Same Employee Name');
 	 }
          if(retVal){
                       document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}




</script>
</head>
<body onload="addRows(new Array('strEmpId','strLevel')
						,new Array('s','s'),'1','1','I');">
<html:form name="indentAuthorizationBean" action="/masters/IndentAuthorizationMstCNT" type="mms.masters.controller.fb.IndentAuthorizationMstFB">
 	
 	<div id="errMsg" class="errMsg"><bean:write name="indentAuthorizationBean" property="strErr"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="indentAuthorizationBean" property="strMsg"/></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="indentAuthorizationBean" property="strWarning"/></div>
	

	<table class="TABLEWIDTH" align="center" cellpadding="0"
         cellspacing="0">
         <tr>
               <td width="100%"><tag:tab tabLabel="Indent Authorization Master" selectedTab="FIRST" align="center" width="100%">
               </tag:tab></td>
         </tr>
    </table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="8">Indent Authorization Master&gt;&gt; Add</td>
		</tr>
		
		<tr>
			<td colspan="4" width="50%" class="LABEL">Drug Warehouse Name</td>
			<td colspan="4" width="50%" class="CONTROL">
			<bean:write name="indentAuthorizationBean" property="strStoreName" filter="false"/>
		</tr>
		
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			Drug Category Name
			</td>
			<td colspan="4" width="50%" class="CONTROL">
  			<bean:write name="indentAuthorizationBean" property="strItemCategoryName" filter="false"/>
   			</td>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			Authorization For
			</td>
			<td colspan="4" width="50%" class="CONTROL">
  			<bean:write name="indentAuthorizationBean" property="strAuthorizationForName" filter="false"/>
   			</td>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">
			Type
			</td>
			<td colspan="4" width="50%" class="CONTROL">
  			<bean:write name="indentAuthorizationBean" property="strType" filter="false"/>
   			</td>
		</tr>
		</table>
			
				
				<div id="addedDataId" style="display: block;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">  
				<tr>
					<td class="TITLE" width="5%">

					<div id="plusaddedDataDivId" style="display: block;" ><img
						src="../../hisglobal/images/plus.gif" name="plusonLine"
						align="middle"
						onclick="showDetails('addedDataDivId');" /></div>

					<div id="minusaddedDataDivId" style="display:none;"><img
						src="../../hisglobal/images/minus.gif" name="minusonLine"
						onclick="hideDetails('addedDataDivId');"></div>

					</td>
				

					<td colspan="7" width="95%" class="TITLE">Previous Data</td>
				</tr>
				</table>
				</div>
				
				<div id="addedDataDivId" style="display:none;">
				<bean:write name="indentAuthorizationBean" property="strAddedData" filter="false"/></div>
				
				<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
     		<tr> 
    	  	 <td  class="TITLE" width="95%">Next</td> 
    	  	 <td  class="TITLE" width="5%"><div id="plusId">
             <img name="plus" src="../../hisglobal/images/plus.gif" 
             onClick="addRows(new Array('strEmpId','strLevel')
						,new Array('s','s'),'1','1','R');"></div>
			<img name="minus" src="../../hisglobal/images/minus.gif"
			 onClick="deleteLastRow('1','1');">
								
       		 </td>
  			</tr>
 		 </table>
        	<div id="id1"></div>
        <table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
         
        	<tr>
					<td colspan="4" width="50%" class="LABEL">
					<font color="red">*</font>Effective From</td>
					<td colspan="4" class ="CONTROL"><date:date name="strEffectiveFrom" value="${indentAuthorizationBean.strCtDate}"></date:date></td>
				</tr> 
				<tr>
					<td colspan="4" width="50%" class="LABEL">Remarks</td>
					<td colspan="4" width="50%" class="CONTROL">
			  		<div align="left">
        				<textarea name="strRemarks" rows="2"></textarea>
    	 			</div></td>
			  </tr>
		
		<tr class="FOOTER">
			 <td colspan="8"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>			
				
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Reset Content" onClick="document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>
	

<input type="hidden" name="hmode"/>
	<input type="hidden" name="comboValue" value="${indentAuthorizationBean.strComboValue}"/>
<input type="hidden" name="indexId"/>
<cmbPers:cmbPers/>
</html:form>
<jsp:include page="indentAuthorization_Multirow_mms_mst.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>		
</body>
</html>