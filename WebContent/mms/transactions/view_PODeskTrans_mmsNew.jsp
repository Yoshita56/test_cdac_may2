<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>PO Desk</title>
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POViewJS.js"></script>

<style type="text/css">
	.prescriptionTile {
		margin: 20px;
		border-bottom: 1px solid #d7d7d7;
		padding-bottom: 10px;
		padding: 1% 2% 0.5% 2%;
		background-color: #fff;
		transition: 0.5s;
		box-shadow: 0.5px 0.5px 10px 2px #b0acac;
		border-radius: .35rem;
		color: #666;
		color: rgba(75, 75, 75, 0.9);
		color: rgb(21, 21, 21);
	}
	.legend2 {
		position: absolute;
		top: 0.5em;
		right: 44px;
		line-height: 1.2em;
	}
</style>

</head>
<body>
<html:form action="/transactions/PODeskViewTransBSCNT">
	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskViewTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskViewTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskViewTransBean" property="strMsg" /></div>
	</center>

<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset form="form1">
	  	<legend class="legendHeader" id='nonPrintableLegend'>Po Desk View</legend>	

  		<div class="legend2" id='nonPrintableLegend2'>
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px 13px;" onclick="cancelToDesk();">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
			</button>
		</div>
		
		<div class="row rowFlex reFlex">
		  <div class="col-sm-12">
		    <p class="subHeaders"><i class="fas fa-eye  iround"></i></button>
		    &nbsp;View PO</p>
		  </div>
	   </div>
	  
	  <div class="row">
			<div class="col-sm-2"><label>Store Name</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskViewTransBean" property="strStoreId"></html:hidden><bean:write name="PODeskViewTransBean" property="strStoreName" filter="false"></bean:write></div>
			<div class="col-sm-2"><label>PO No.</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskViewTransBean" property="strPONo"></html:hidden><bean:write name="PODeskViewTransBean" property="strPONo" filter="false"></bean:write></div>
			<div class="col-sm-2"><label>PO Date</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskViewTransBean" property="strPODate"></html:hidden><bean:write name="PODeskViewTransBean" property="strPODate" filter="false"></bean:write></div>
	  </div>
	  <div class="row">
		<div class="col-sm-2"><label>PO Type</label></div>
		<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskViewTransBean" property="strPOTypeId"></html:hidden><bean:write name="PODeskViewTransBean" property="strPOType" filter="false"></bean:write></div>
		<div class="col-sm-2"><label>Item Category</label></div>
		<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskViewTransBean" property="strItemCat"></html:hidden><bean:write name="PODeskViewTransBean" property="strItemCatName" filter="false"></bean:write></div>
		<div class="col-sm-2"><label>Supplier Name</label></div>
		<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskViewTransBean" property="strSupplierId"></html:hidden><bean:write name="PODeskViewTransBean" property="strSupplierName" filter="false"></bean:write></div>
	  </div>

	 <div id="divPORequestDetailsPlusID" style="display: none;" align="left">
	   <p class='subHeaders'><i class="fas fa-plus-circle" onclick="showDiv('divPORequestDetailsMinusID'),hideDiv('divPORequestDetailsPlusID'),showDiv('divPORequestDetails');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Request Details</p>
	 </div>
	 <div id="divPORequestDetailsMinusID" style="display: block;" align="left">
	   <p class='subHeaders'><i class="fas fa-minus-circle" onclick="hideDiv('divPORequestDetailsMinusID'),hideDiv('divPORequestDetails'),showDiv('divPORequestDetailsPlusID');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Request Details</p>
	 </div>
	
	
     <div id=divPORequestDetails><bean:write name="PODeskViewTransBean" property="strRequestDetails" filter="false"></bean:write></div>
        <div id="divPOItemPlusID" style="display: none;" align="left">
	  	<p class='subHeaders'><i class="fas fa-plus-circle" onclick="showDiv('divPOItemMinusID'),hideDiv('divPOItemPlusID'),showDiv('divPOItem');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Item Details</p>
	</div>
	<div id="divPOItemMinusID" style="display: block;" align="left">
	    <p class='subHeaders'><i class="fas fa-minus-circle" onclick="hideDiv('divPOItemMinusID'),hideDiv('divPOItem'),showDiv('divPOItemPlusID');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Item Details</p>
	</div>

	<div id="divPOItem">
		<bean:write name="PODeskViewTransBean" property="strItemDetails" filter="false"></bean:write>
	</div>

	<hr>
    <div class="row rowFlex reFlex">       
		<div class="col-sm-8"> </div>
		<div class="col-sm-4" align="right">  <i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory </div>				 
    </div>

	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/back_tab.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></td>
		</tr>
	</table>-->
		
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
	</div>
	</div>
	</fieldset>
</html:form>
<%-- <tag:autoIndex></tag:autoIndex>
 --%></body>
</html>