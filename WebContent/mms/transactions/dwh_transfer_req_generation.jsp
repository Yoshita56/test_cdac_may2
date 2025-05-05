 <%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>

<!--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>Drug Transfer Demand Generation</title>
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">

<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script> 

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_utilBS.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<script language="JavaScript" src="../js/drug_transfer_demand_generation.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>


<script type="text/javascript">


/***This function searches the drug name in the drug name combobox. 
	 Added by: santosh; CR:19OCT, point:18
	 ******start*****
	 */
	function getDrugNameSelected(itemId)
	{
		var flag = 0;
		var sel = document.forms[0].strItemBrandId;
		
		for (var i=0; i<sel.options.length; i++) {				
			if ( sel.options[i].value.split("^")[0] == itemId ) 
			{
				sel.selectedIndex = i;			
				flag = 1;
				break;
			}				
		}		
		if(flag == 0)
		{
			sel.selectedIndex=0;
			document.forms[0].strSearchDrug.value = "";
		}
		else
		{
			getUnitName();
		}	    
		 
	}
 
	 
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
			document.forms[0].strApprovedBy.value="";
			document.forms[0].strApprovalFlg.value='1';
			document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Name of the Approving Authority";
			document.forms[0].strApprovedBy.focus();
		
		}else if(document.forms[0].strApprovedById.value!="0" && document.forms[0].strApprovedById.value!="1"){
			
			document.getElementById("labelId").className="LABEL";
			
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			document.getElementById("labelNameId").innerHTML="";
			document.forms[0].strApprovedBy.value=recievedByName;
			if(!document.forms[0].strApprovedBy.readOnly)
			    {
				  document.forms[0].strApprovedBy.readOnly=true;
				  document.forms[0].strApprovedBy.tabIndex="-1";
				}  
			document.getElementsByName("strRemarks")[0].focus();
			document.forms[0].strApprovalFlg.value='0';
			
			
		}else{
			document.getElementById("labelId").className="CONTROL";
			document.getElementById("nameOtherFld").style.display="none";
			document.getElementById("labelNameId").innerHTML="";
			document.forms[0].strApprovalFlg.value='0';
		}
	}
	
	function htmlwriteapprovedby()
	{
	        var recievedByName=document.forms[0].strApprovedById[document.forms[0].strApprovedById.selectedIndex].text;
	        document.getElementById("labelId").className="LABEL";
			
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			document.getElementById("labelNameId").innerHTML="";
			document.forms[0].strApprovedBy.value=recievedByName;
			if(!document.forms[0].strApprovedBy.readOnly){
				 document.forms[0].strApprovedBy.readOnly=true;
				 document.forms[0].strApprovedBy.tabIndex="-1";
			} 
			document.forms[0].strApprovalFlg.value='0';
	}
	  
   
  
</script>


</head>

<body class="background" onload="htmlwriteapprovedby();ajaxItemBrandName();">
<html:form name="transferDemandReqTrans"
	action="/transactions/TransferDemandReqTransCNT"
	type="mms.transactions.controller.fb.TransferDemandReqTransFB" styleClass="formbg">

<%-- <input type='hidden' name='IMCS_TOKEN' value='<%=request.getSession().getAttribute("IMCS_TOKEN").toString().trim() %>'/> --%>

	<div class="errMsg"     id="errMsg"><bean:write    	    name="transferDemandReqTrans" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write	name="transferDemandReqTrans" property="strWarningMsg" /></div>
	<div class="normalMsg"  id="normalMsg"><bean:write   name="transferDemandReqTrans" property="strNormalMsg" /></div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Drug Transfer &gt;&gt; Demand &gt;&gt; Generation </td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL">
			     <bean:write	name="transferDemandReqTrans" property="strStoreName" filter="false" />
			</td>
			<td width="25%" class="LABEL">Request Date</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strReqDate"  value="${transferDemandReqTrans.strCtDate}"></dateTag:date>			     
			</td>

		</tr>
		
		<tr><td class="LABEL" width="25%"><font  color="red">*</font>Status</td>
			<td class="CONTROL" width="25%">
			    <select name="strReqStatus" class='comboNormal'>
			     <option value="1">Normal</option>
			     <option value="2">Urgent</option>
			    </select>
			</td></tr>	
	</table>
	
	<div class='line'>
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="0px">
			
			<tr>
			    <td colspan="4">
				    <div class='line' style="width:100%;margin-left:0;">
					    <table class="NEWTABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
							<tr>
								<td colspan="4" >Add Shortage Item Details</td>
							</tr>
				        </table>
			        </div>
			    </td>
		   </tr>
		</table>
	</div>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">		
		<tr>
			<td colspan="4" align="center">
				<table cellspacing="0" cellpadding="3" border="0" id="headerTableTrans" style="width:100%;table-layout:fixed;border-collapse:collapse;">
					<tr>
						<th style="width: 40%;" >Drug Name</th>
						<th style="width: 20%;" >Avl Qty</th>
						<th style="width: 20%;" >Demanded Qty</th>
						<th style="width: 20%;" >Action</th>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<div style="height: 100px; overflow: auto;">
					<table cellspacing="0" cellpadding="3" border="0" id="tbl-content" style="width:100%;table-layout:fixed;background:#fff;border-collapse:collapse;">

					</table>
				</div>
			</td>
		</tr>
	</table>		

	<div class='line'><table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		
		<tr>
		    <td colspan="4">
			    <div class='line' style="width:100%;margin-left:0;">
				    <table class="NEWTABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
						<tr>
							<td colspan="4" >New Shortage Item Details</td>
						</tr>
			        </table>
		        </div>
		    </td>
		</tr>
	</table></div>		

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">Group Name</td>
			<td class="CONTROL" width="25%">
			<select name="strGroupId" class='comboMax' onChange="getSubGrpAndGenericItem(this);">
				<bean:write name="transferDemandReqTrans" property="strGroupNameCombo" filter="false"></bean:write>
			</select>
			</td>
			<td class="LABEL" width="25%">Sub-Group Name</td>
			<td class="CONTROL" width="25%">
			<div id="SubGroupNameDiv">
				<select name="strSubGroupCode" class='comboMax' onchange="ajaxItemBrandName();">
					<bean:write name="transferDemandReqTrans" property="strSubGroupCombo" filter="false"></bean:write>
				</select>
			 </div>	
			</td>
		</tr>
		
		<tr style="display: none">
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Item Name</td>
			<td class="CONTROL" width="60%" colspan="2">
			<div id="ItemBrandId">
				<select id="strItemBrandId"	name="strItemBrandId" class='comboMax'	onChange='getUnitName();'>
					   <bean:write name="transferDemandReqTrans" property="strItemNameCombo" filter="false"></bean:write>
				</select>
			</div>	
		  </td>
		  
		  <td class="CONTROL" width="15%"></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Item Name</td>	 
			<td class="CONTROL" width="75%" colspan="3"><input type="text" id="strSearchDrug" name="strSearchDrug" size="90%"/>
			  
			</td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%" colspan="1">Selected Item Name</td>
			<td class="CONTROL" width="75%" colspan="3">
			<div id="DrugNameId" style="color:blue;font-weight:bold"></div>	
		  </td>
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font  color="red">*</font>Demanded Qty</td>
			<td class="CONTROL" width="25%">
			   <div style="float: left;">
			   		<input type="text" id="strDemandedQty" name="strDemandedQty" maxlength="8" class="txtFldMax" onkeypress="return validateData(event,5);" />
			   </div>
			   <div id="unitNameId" style="color:brown;font-weight:bold;float: left;margin-left: 5px;"></div>
			</td>
           	<td class="CONTROL" width="25%"><div id="avlaibleQtyId" style="color:brown;font-weight:bold"></div></td>			
		</tr>	
		<tr>
			<td class="CONTROL" colspan="4" style="text-align: center;">
			    <div style="margin-left:50%;"><a href="#" class="button" title="Click Here To Add Item" onClick="checkDuplicateRequest();"><span class="add">ADD</span></a></div>				
			</td>
		</tr>
		
		<logic:equal value="0" name="transferDemandReqTrans" property="strOnlineAppStatus">
		
		<tr>
		    <td colspan="4">
			    <div class='line' style="width:100%;margin-left:0;">
				    <table class="NEWTABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
						<tr>
							<td colspan="4" >Approval Details</td>
						</tr>
			        </table>
		        </div>
		    </td>
		</tr>
		
		
					
		<tr>		
           <td width ="25%%" class ="LABEL" valign="middle" ><font  color="red">*</font>Approved By</td>
           <td width ="25%" class ="CONTROL">
                <select name="strApprovedById" onchange="checkValCombo();" class="comboMax">
               	<bean:write name="transferDemandReqTrans" property="strApprovedByCombo" filter="false"/>
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
		 
		 <tr>           
			<td class="LABEL" width="25%"><font color="red">*</font>Approval Date</td>
			<td class="CONTROL" width="25%">
				<dateTag:date	name="strApprovedDate" value="${transferDemandReqTrans.strCtDate}"></dateTag:date>	 
			</td>			
		</tr>
			
		</logic:equal>
		
		<tr>
		    <td colspan="4">
			    <div class='line' style="width:100%;margin-left:0;">
				    <table class="NEWTABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
						<tr>
							<td colspan="4" >Other Details</td>
						</tr>
			        </table>
		        </div>
		    </td>
		</tr>
		
		<tr >			
		    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Remarks</td>
		    <td width ="50%" class ="CONTROL" colspan="2"><textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"></td>
		</tr>
	</table>
	
	
<div>		
<div class="legends"><font size="2" color="red">*</font>Mandatory Field(s)</div>  
<div class="control_button"><table  class="TABLEWIDTH" align="center">
	<tr>
	<td align="center"><div>
				<a href="#" class="button" title="Click to Save Record" onClick="validateSave();"><span class="save">SAVE</span></a>
				<a href="#" class="button" title="Click to Clear Page" onclick="ClearPage();">CLEAR</span></a>
				<a href="#" class="button" title="Click to Return On Desk"  onClick="cancel('LIST');">BACK</span></a>				 
				</div></td>
	</tr>	  
</table>
</div>	
</div>	

	
	<input type="hidden" name="strStoreId"	 value="${transferDemandReqTrans.combo[0]}" />
	<input type="hidden" name="strStoreName" value="${transferDemandReqTrans.strStoreName}" />
	<input type="hidden" name="strGroupName"	value="${transferDemandReqTrans.strGroupName}" />
	<input type="hidden" name="strCtDate"   	value="${transferDemandReqTrans.strCtDate}">
	<input type="hidden" name="strApprovalFlg"  value="0">
	<input type="hidden" name="strOnlineAppStatus"  value="${transferDemandReqTrans.strOnlineAppStatus}">
	<input type="hidden" name="strRegFlag" value="" />

	<input type="hidden" name="hmode" />

<input type="hidden" name="tempVar" value="0" />


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
</body>
</html>
