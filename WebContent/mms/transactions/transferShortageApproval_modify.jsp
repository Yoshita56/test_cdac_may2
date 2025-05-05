<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<script type="text/javascript">

/**
	  This function is used to set condition during change of name of reciever.
**/
function checkValCombo()
{
	var recievedByName=document.forms[0].strApprovedById[document.forms[0].strApprovedById.selectedIndex].text;
	if(document.forms[0].strApprovedById[document.forms[0].strApprovedById.selectedIndex].text=='Other' )
	{
		
		document.getElementById("labelId").className="LABEL";
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		if(document.forms[0].strApprovedBy.readOnly)
			document.forms[0].strApprovedBy.readOnly=false;
		document.forms[0].strApprovedBy.value= document.forms[0].strApprovedByView.value ;
		document.forms[0].strApprovalFlg.value='1';
		document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Name of the Approval Person";
		//document.forms[0].strApprovedBy.focus();
	
	}else if(document.forms[0].strApprovedById.value!="0" && document.forms[0].strApprovedById.value!="1"){
		
		document.getElementById("labelId").className="LABEL";
		
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		document.getElementById("labelNameId").innerHTML="Name of the Receiver";
		document.forms[0].strApprovedBy.value=recievedByName;
		if(!document.forms[0].strApprovedBy.readOnly)
			document.forms[0].strApprovedBy.readOnly=true;
		document.getElementsByName("strRemarks")[0].focus();
		document.forms[0].strApprovalFlg.value='0';
		
		
	}else{
		document.getElementById("labelId").className="CONTROL";
		document.getElementById("nameOtherFld").style.display="none";
		document.getElementById("labelNameId").innerHTML="";
		document.forms[0].strApprovalFlg.value='0';
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drug Transfer Demand Generation</title>
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" 	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" 	type="text/css">
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">


<script language="JavaScript" src="../../hisglobal/js/jquery-3.3.1.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>
<script language="JavaScript" src="../js/transferShortageApproval.js"></script>

<script type="text/javascript">
$(function(){
	
	var obj = document.getElementById("strApprovedById");
	var str = document.forms[0].strApprovedByView.value;
	for(var i=0;i<obj.options.length;i++)
	{		
		if(obj.options[i].text.toUpperCase() == str.toUpperCase())
		{
			document.forms[0].strApprovedById.selectedIndex = i;
			break;
		}
		else
		{
			if(obj.options[i].value == "1")
			{
				document.forms[0].strApprovedById.selectedIndex = i ;
				break;
			}
												
		}						
	}
	
	checkValCombo();
});

</script>
</head>

<body class="background">
<html:form name="transferShortageApprovalTransBean"
	action="/transactions/TransferShortageApprovalTransCNT"
	type="mms.transactions.controller.fb.TransferShortageApprovalTransFB" styleClass="formbg">
<input type='hidden' name='IMCS_TOKEN' value='<%=request.getSession().getAttribute("IMCS_TOKEN").toString().trim() %>'/>	


	<div class="errMsg"     id="errMsg"><bean:write    	    name="transferShortageApprovalTransBean" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write	name="transferShortageApprovalTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg"  id="normalMsg"><bean:write   name="transferShortageApprovalTransBean" property="strNormalMsg" /></div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Drug Transfer &gt;&gt; Demand Generation &gt;&gt; Modify</td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL">
			     <bean:write	name="transferShortageApprovalTransBean" property="strStoreNameView" filter="false" />
			</td>
			<td width="25%" class="LABEL">Request Date</td>
			<td width="25%" class="CONTROL">
			     <bean:write	name="transferShortageApprovalTransBean" property="strRequestDateView" filter="false" />
			</td>

		</tr>
	
		<tr>
			<td class="LABEL">Group Name</td>

			<td class="CONTROL" width="25%">
			<bean:write	name="transferShortageApprovalTransBean" property="strGroupNameView" filter="false" />
			</td>


			<td class="LABEL">Sub Group Name</td>

			<td class="CONTROL" width="25%">
			     <bean:write	name="transferShortageApprovalTransBean" property="strGroupNameView" filter="false" />
			</td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Drug/Item Name</td>
			<td class="CONTROL" width="75%" colspan="3">
			      <bean:write	name="transferShortageApprovalTransBean" property="strItemNameView" filter="false" />
		  </td>
		</tr>		
		<tr>
			<td class="LABEL" width="25%"><font  color="red">*</font>Demand Qty.</td>

			<td class="CONTROL" width="25%">
			   <input type="text"	id="strDemandedQty" name="strDemandedQty" maxlength="8" value="${transferShortageApprovalTransBean.strReqQtyView}"  class="txtFldMax"  onkeypress="return validateData(event,5);" />
              	<bean:write	name="transferShortageApprovalTransBean" property="strUnitNameView" filter="false" /></td>
			<td class="LABEL" width="25%">Previous Approved By</td>
			<td class="CONTROL" width="25%">
			          <bean:write	name="transferShortageApprovalTransBean" property="strApprovedByView" filter="false" />
			</td>
		</tr>	
		
		<tr>
			
           
			<td class="LABEL" width="25%">Previous Approved Date</td>
			<td class="CONTROL" width="25%">				
						<bean:write	name="transferShortageApprovalTransBean" property="strApprovedDateView" filter="false" />
			</td>
			<td class="LABEL" width="25%">Previous Status</td>
                    
			<td class="CONTROL" width="25%">
			     <bean:write	name="transferShortageApprovalTransBean" property="strApprovedStatusView" filter="false" />
			</td>
			</tr>		
		<tr>
			
           
			<td class="LABEL" width="25%"><font color="red">*</font>Modify Approved Date</td>
			<td class="CONTROL" width="25%">
						
					<dateTag:date	name="strApprovedDate" value="${transferShortageApprovalTransBean.strCtDate}"></dateTag:date>	 
			</td>
			<td class="LABEL" width="25%"><font  color="red">*</font>Modify Status</td>

			<td class="CONTROL" width="25%">
			    <select name="strReqStatus" class='comboNormal'>
			     <option value="1">Normal</option>
			     <option value="2">Urgent</option>
			    </select>
			</td>
			</tr>			
		<tr>
		
           <td width ="25%%" class ="LABEL" valign="middle" ><font  color="red">*</font>Approved By</td>
           <td width ="25%" class ="CONTROL">
    
            <select id="strApprovedById" name="strApprovedById" onchange="checkValCombo();" class="comboMax">
               	<bean:write name="transferShortageApprovalTransBean" property="strApprovedByCombo" filter="false"/>
               </select>
               
            </td>
            <td class="CONTROL" width="25%" id='labelId'>
            	<div id='labelNameId'></div>
		   </td>
		    <td class="CONTROL" width="25%">
		            	<div id="nameOtherFld" style="display: none">
		            		<input type='text' name='strApprovedBy' value='' onkeypress='return validateData(event,16);' maxlength='45'>
		            	</div>
		            </td>
		 </tr>
		<tr >
		    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Remarks</td>
		    <td width ="50%" class ="CONTROL" colspan="2">
		    	<textarea  name="strRemarks" cols="25" rows="2" 
		        onkeypress="return validateData(event,9);"><bean:write	name="transferShortageApprovalTransBean" 
		        property="strRemarks" filter="false" /></textarea>
		     </td>
		  </tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"></td>
		</tr>
	</table>
	
<div>		
<div class="legends"><font size="2" color="red">*</font> Mandatory Fields</div>  
<div class="control_button"><table  class="TABLEWIDTH" align="center">
	<tr>
	<td align="center"><div>
				<a href="#" class="button" title="Click to Save Record" onClick="validateUpdate();"><span class="save">Save</span></a>
				<a href="#" class="button" title="Click to Clear Page" onclick="ClearPage();"><span class="clear">Clear</span></a>
				<a href="#" class="button" title="Click to Return On Desk"  onClick="cancel('LIST');"><span class="back">Back</span></a>				 
				</div></td>
	</tr>	  
</table>
</div>	
</div>	
	

	<input type="hidden" name="strStoreId"	    value="${transferShortageApprovalTransBean.combo[0]}" />
	<input type="hidden" name="strTmpStoreId"	    value="${transferShortageApprovalTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName"    value="${transferShortageApprovalTransBean.strStoreName}" />
	<input type="hidden" name="strReqDate"      value="${transferShortageApprovalTransBean.strReqDate}" />
    <input type="hidden" name="strGroupName"	value="${transferShortageApprovalTransBean.strGroupName}" />	
	<input type="hidden" name="strModifyChk"  	value="${transferShortageApprovalTransBean.strChk}">
	<input type="hidden" name="strCtDate"   	value="${transferShortageApprovalTransBean.strCtDate}">
	<input type="hidden" name="strApprovalFlg"  value="0">
	<input type="hidden" name="strRegFlag" value="" />
	<input type="hidden" name="strApprovedByView" value="${transferShortageApprovalTransBean.strApprovedByView}" />
	<input type="hidden" name="hmode" />




	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="otherDtlspopUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="itemsOtherDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>



	<cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>
