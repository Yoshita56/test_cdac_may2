<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=utf-8>
<title>Authority Hierarchy</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
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

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/AuthorityHierDtlNew.js"></script>

<script type="text/javascript">

	var ie = document.all;
	var nn6 = document.getElementById && !document.all;

	function view1(id1, id2, id3) {
		if (document.forms[0].strStoreName.value == "0")
			alert("Please select Drug Warehouse Name from Combo!!!");
		else if (document.forms[0].strItemCatCmb.value == "0")
			alert("Please select Drug Category from Combo!!!");
		else if (document.forms[0].strReqTypeCmb.value == "0")
			alert("Please select Request Type from Combo!!!");
		else {
			document.getElementById(id1).style.display = "none";
			document.getElementById(id2).style.display = "block";
			document.getElementById(id3).style.display = "block";
			if (document.forms[0].hlevTypAjax.value == "0") {
				document.forms[0].hlevTypAjax.value = "1";
				//alert("storeId->"+document.forms[0].strStoreName.value);
				var itemCatId = document.forms[0].strItemCatCmb.value;
				var reqTypId = document.forms[0].strReqTypeCmb.value;
				var myArr = new Array();
				myArr = (document.forms[0].strStoreName.value).split("^");
				var mode = "HIERARCHY_DTL";
				var url = "AuthorityHierDtlBSCNT.cnt?hmode=" + mode + "&storeId="
						+ myArr[0] + "&itemCatNo=" + itemCatId + "&reqTypeId="
						+ reqTypId;
				ajaxFunction(url, "1");
			}
		}
	}

	function view2(id1, id2, id3) {
		document.getElementById(id1).style.display = "block";
		document.getElementById(id2).style.display = "none";
		document.getElementById(id3).style.display = "none";
	}

	function chkSel(e, obj, index) {
		var chkName = obj.name;
		var chkIndex = index;
		var chkObj = document.getElementsByName(chkName);
		var textObj = document.getElementsByName(chkName + "text");
		var htextObj = document.getElementsByName("h" + chkName + "text");
		var chklen = textObj.length;
		var myArr = new Array();
		myArr = chkName.split("_");
		var leveltype = myArr[1];
		var max = "0";
		var hLevelTypeObj = document.getElementsByName("hLevelType");
		var currhVal;

		//Setting values for hLevelTypeObj::if all txtObj.value are blank assign 0 else assign max of all values

		for ( var i = 0; i < textObj.length; i++) {
			if (textObj[i].value != "") {
				if (parseInt(textObj[i].value) > parseInt(max)) {
					max = textObj[i].value;
				}
			}
		}
		//alert("max->"+max);
		hLevelTypeObj[leveltype - 1].value = max;//setting to maximum value

		if (obj.checked) {
			textObj[chkIndex].disabled = false;
			if (hLevelTypeObj[leveltype - 1].value == "0") {
				textObj[chkIndex].value = "1";
				htextObj[chkIndex].value = "1";
				hLevelTypeObj[leveltype - 1].value = "1";
				textObj[chkIndex].focus();
				textObj[chkIndex].select();
				textObj[chkIndex].title = "This is auto-suggest value of Level.You can change without breaking sequence!!";
			} else {
				textObj[chkIndex].value = parseInt(hLevelTypeObj[leveltype - 1].value) + 1;
				htextObj[chkIndex].value = textObj[chkIndex].value;
				textObj[chkIndex].focus();
				textObj[chkIndex].select();
				textObj[chkIndex].title = "This is auto-suggest value of Level.You can change without breaking sequence!!";
				for ( var i = 1; i <= chklen; i++) {
					var s = "0";
					for ( var j = 0; j < chklen; j++) {
						if (textObj[j].value == i
								&& textObj[j].disabled == false)
							s = "1";
					}
					currhVal = i;
					if (s == "0") {
						currhVal = i;
						break;
					}
				}
				hLevelTypeObj[leveltype - 1].value = parseInt(currhVal) - 1;
			}
		} else {
			var tmp;
			if (textObj[chkIndex].value == "")
				tmp = htextObj[chkIndex].value;
			else
				tmp = textObj[chkIndex].value;
			if (tmp == "1") {
				textObj[chkIndex].readOnly = false;
			}
			textObj[chkIndex].value = "";
			htextObj[chkIndex].value = textObj[chkIndex].value;
			textObj[chkIndex].disabled = true;

			hLevelTypeObj[leveltype - 1].value = parseInt(tmp) - 1;

			for ( var i = parseInt(tmp) + 1; i <= chklen; i++) {
				var temp = "0";
				for ( var j = 0; j < chklen; j++) {
					if (textObj[j].value == i && textObj[j].disabled == false) {
						chkObj[j].checked = false;
						textObj[j].value = "";
						htextObj[j].value = textObj[j].value;
						textObj[j].disabled = true;
						temp = "1";
					}
				}
			}
		}
	}

	function levelEdit(textObj, txtIndex, leveltype) {
		var textObjName = textObj.name;
		var myArr = new Array();
		var hLevelTypeObj = document.getElementsByName("hLevelType");
		var htextObj = document.getElementsByName("h" + textObjName);
		var txtObj = document.getElementsByName(textObjName);
		var textlen = txtObj.length;
		var s = "1";
		textObj.title = "Type your Level here!!";

		if (textObj.value != "") {

			if ((parseInt(textObj.value) > parseInt(txtObj.length))
					|| (parseInt(textObj.value) < 1))
				s = "0"; //level value cannot be greater than length allowed
			if (s != "0") //s flag checks for the validity of the sequence
			{
				var status = "1"; //this flag keeps track of individual possible level values presence while entering
				var statusArr = new Array();//this array is used to record the status of occurence of possible level values
				for ( var count = 1; count <= txtObj.length; count++) {
					status = "0";
					for ( var x = 0; x < txtObj.length; x++) {
						if (parseInt(txtObj[x].value) == parseInt(count)) {
							status = "1";
						}
					}
					statusArr[count - 1] = status;
				}
				for ( var x = 0; (x < statusArr.length - 1) && (s != "0"); x++) {
					if ((statusArr[x] == "0") && (statusArr[x + 1] == "1")) {
						s = "0";//concept::there cannot be 1 after 0 for valid sequence.
						//eg->011:Not Allowed ; 101:Not Allowed ; 11000:Allowed ; 1100001:Not Allowed
					}
				}
			}

			if (s == "0") {
				alert("This Level assignment Invalid!!!");
				textObj.value = htextObj[txtIndex].value;
			} else {
				htextObj[txtIndex].value = textObj.value;
			}
		}
	}
	function displayReceivingEnd() {
		
		var eleApprovalFlag = document.getElementById("strApprovalFlag");
		var eleReceivingLevelDiv = document.getElementById("receivingLevelDivId");
		
		
		/*
		ApprovalFlag 	= 0 for no approval
						= 1 Both Raising and Receiving End Approval
						= 2 Only Raising Level. No receiving level.
		*/
		if(eleApprovalFlag.value=="2"){
			
			eleReceivingLevelDiv.style.display="none";
		} else {
			eleReceivingLevelDiv.style.display="block";
		}
	}
</script>

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

/* .legendNew {
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: -3.9em;
} */
</style>

<style type="text/css">
.legendvs{
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: 0.6em;
}
</style>

</head>
<body>

<html:form action="/masters/AuthorityHierDtlBSCNT.cnt" name="authHierTransBean" type="mms.masters.controller.fb.AuthorityHierDtlFB" method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="authHierTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="authHierTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="authHierTransBean" property="strMsg" /></div>

	<center style="display:none;">
		<tag:tab tabLabel="Authority Hierarchy"
			selectedTab="FIRST" align="center" width="TABLEWIDTH">
		</tag:tab>
	</center>
	<br>
	
	<div class="container-fluid">
			<div class="prescriptionTile">
				<div class="row">
					<!-- <div class="col-sm-6" align="left">
						<p class="subHeaders" style="margin-bottom: 0;">
							<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Authority Hierarchy		
						</p>
			        </div> -->
			        
					<div class='legendHeader col-6' >
					<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Approving Authority&nbsp;&nbsp;
					</div>
			        
					<div class="col-6" align="right">
					<label>Date:&nbsp;</label>
					<bean:write name="authHierTransBean" property="strCtDate" filter="false" />
					</div>
				</div>
				
				<div class="row">
					<div class="legend2" id="nonPrintableLegend2">
						<button type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" style="border-radius:50%; padding:12px 12px;" onclick="cancelFunc();">
							<i class="fas fa-times fa-lg iround" title="Cancel"></i>
						</button>
						
						<button type="button" class=" btn btn-secondary btn-circle" onclick="initPage();" style="background-color: #2196f3 !important; border-radius:50%; padding:12px 7px; background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
							<i class="fas fa-broom fa-lg" title="Clear"></i>
							<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
						</button>
						
						<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle" tabindex="2" onclick="return validate1();" style="border-radius:50%; padding:12px 10px; background-color: #5cb85c;">
							<i class="fas fa-save fa-lg iround" title="save"></i>
						</button>
					</div>
				</div>
										
				<hr>	
				
			<div class="container">			
				<div class="row" style="margin: 1% 2%">
					<div class="col-sm-2">
						<label>Store Name<font color="red">*</font></label>
					</div>
					<div class="col-sm-2">
						<select name="strStoreName" class="form-control" onChange="storeCmbChng(this);">
							<bean:write name="authHierTransBean" property="strStoreName" filter="false" />
						</select>
					</div>
					
					<div class="col-sm-2">
						<label>Item Category<font color="red">*</font></label>
					</div>
					<div class="col-sm-2" id="itemCmbDIV">
						<select name="strItemCatCmb" class="form-control">
							<option value="0">Select Value</option>
						</select>
					</div>
					
					<div class="col-sm-2">
						<label>Request Type<font color="red">*</font></label>
					</div>
					<div class="col-sm-2" id="reqTypeCmbDIV">
						<select name="strReqTypeCmb" class="form-control">
							<option value="0">Select Value</option>
						</select>
					</div>
				</div>
				
			<hr>

		<div class="row"></div>
			<nav>
				<div class="nav nav-tabs" id="nav-tab" role="tablist">
					<a class="nav-item nav-link active" id="nav-home-tab"
						data-toggle="tab" href="#nav-home" role="tab"
						aria-controls="nav-home" aria-selected="true"
						style="padding: 0.5rem 0.1rem;">
						<button type="button" class="btn btn-info btn-sm collapsed"
							align="left" style="display: block;"
							onClick="view1('raisingPlusId','raisingMinusId','raisingId');">
							Raising End Level</button>

					</a> 
					
					<a class="nav-item nav-link" id="nav-profile-tab"
						data-toggle="tab" href="#nav-profile" role="tab"
						aria-controls="nav-profile" aria-selected="false"
						style="padding: 0.5rem 0.1rem;">


						<button type="button" class="btn btn-info btn-sm collapsed"
							align="left" style="display: block;"
							onClick="view1('adminLevel1PlusId','adminLevel1MinusId','adminLevel1Id');">
							Administrative level(Raising End)
						</button>

					</a> 
					
					<a class="nav-item nav-link" id="nav-contact-tab"
						data-toggle="tab" href="#nav-contact" role="tab"
						aria-controls="nav-contact" aria-selected="false"
						style="padding: 0.5rem 0.1rem;">

						<button type="button" class="btn btn-info btn-sm collapsed"
							align="left"
							onClick="view1('receivingPlusId','receivingMinusId','receivingId');"
							style="display: block;">Receiving End Level
						</button>
					</a> 
					
					<a class="nav-item nav-link" id="nav-about-tab" data-toggle="tab"
						href="#nav-about" role="tab" aria-controls="nav-about"
						aria-selected="false" style="padding: 0.5rem 0.1rem;">

						<button type="button" class="btn btn-info btn-sm collapsed"
							align="left"
							onClick="view1('adminLevel2PlusId','adminLevel2MinusId','adminLevel2Id');"
							style="display: block;">Administrative level(Receiving
							End)
						</button>
					</a>
				</div>
			</nav>
			
				<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
					<div class="tab-pane fade show active" id="nav-home"
						role="tabpanel" aria-labelledby="nav-home-tab">
						<div id="raisingId"></div>
					</div>
					<div class="tab-pane fade" id="nav-profile" role="tabpanel"
						aria-labelledby="nav-profile-tab">
						<div id="adminLevel1Id"></div>
					</div>
					<div class="tab-pane fade" id="nav-contact" role="tabpanel"
						aria-labelledby="nav-contact-tab">
						<div id="receivingId"></div>
					</div>
					<div class="tab-pane fade" id="nav-about" role="tabpanel"
						aria-labelledby="nav-about-tab">
						<div id="adminLevel2Id"></div>
					</div>
				</div>


				<div class="row " style="margin: 1% 2%">
					<div class="col-sm-2">
						<label><font color="red">*</font>Remarks</label>
					</div>
					<div class="col-sm-10">
						<textarea name="strRemarks" cols="20" class="form-control" rows="2" id="strRemarks" onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*');"></textarea>
					</div>
				</div>
			</div>
				
				<hr>
				<div class="row text-right">
			    	<div class="col">
			    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
			    	</div>
				</div>

	<%-- <table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Authority Hierarchy &gt;&gt;Details</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store
			Name</td>
			<td width="25%" colspan="1" class="CONTROL"><select
				name="strStoreName" class="comboNormal"
				onChange="storeCmbChng(this);">
				<bean:write name="authHierTransBean" property="strStoreName"
					filter="false" />
			</select></td>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Item
			Category</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="itemCmbDIV"><select name="strItemCatCmb"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Request
			Type</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="reqTypeCmbDIV"><select name="strReqTypeCmb">
				<option value="0">Select Value</option>
			</select></div>
			</td>
			<td width="25%" colspan="1" class="LABEL">Date</td>
			<td width="25%" colspan="1" class="CONTROL"><font color="blue"><bean:write
				name="authHierTransBean" property="strCtDate" filter="false" /></font></td>
		</tr>
		<tr>
			<td colspan="6" bgcolor="black" height="1"></td>
		</tr>

	</table> --%>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" style="display:none;">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="raisingPlusId" align="left" style="display: block;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="view1('raisingPlusId','raisingMinusId','raisingId');"
				style="cursor: pointer;" /> Raising End Level</div>
			<div id="raisingMinusId" style="display: none;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onClick="view2('raisingPlusId','raisingMinusId','raisingId');"
				style="cursor: pointer;" /> Raising End Level</div>
			</td>
		</tr>
	</table>
	
	<div id="raisingId" style="display: none"></div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px" style="display:none;">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="adminLevel1PlusId" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="view1('adminLevel1PlusId','adminLevel1MinusId','adminLevel1Id');"
				style="cursor: pointer;" /> Administrative level(Raising End)</div>
			<div id="adminLevel1MinusId" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="view2('adminLevel1PlusId','adminLevel1MinusId','adminLevel1Id');"
				style="cursor: pointer;" /> Administrative level(Raising End)</div>
			</td>
		</tr>
	</table>
	
	<div id="adminLevel1Id" style="display: none"></div>

	<div id="receivingLevelDivId">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px" style="display:none;">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="receivingPlusId" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="view1('receivingPlusId','receivingMinusId','receivingId');"
				style="cursor: pointer;" /> Receiving End Level</div>
			<div id="receivingMinusId" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="view2('receivingPlusId','receivingMinusId','receivingId');"
				style="cursor: pointer;" /> Receiving End Level</div>
			</td>
		</tr>
	</table>
	<div id="receivingId" style="display: none"></div>
	
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px" style="display:none;">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="adminLevel2PlusId" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="view1('adminLevel2PlusId','adminLevel2MinusId','adminLevel2Id');"
				style="cursor: pointer;" /> Administrative level(Receiving End)</div>
			<div id="adminLevel2MinusId" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="view2('adminLevel2PlusId','adminLevel2MinusId','adminLevel2Id');"
				style="cursor: pointer;" /> Administrative level(Receiving End)</div>
			</td>
		</tr>
	</table>
	<div id="adminLevel2Id" style="display: none"></div>
	
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1" style="display:none;">
		<tr>
			<td colspan="6" bgcolor="black"></td>
		</tr>
		<!-- <tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Remarks</td>
			<td class="CONTROL"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks" onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*');"></textarea></td>
		</tr> -->
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font>Mandatory
			Fields</td>
		</tr>
	</table>

	<!-- <table class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img style="cursor: pointer; cursor: pointer"
				title="Click to Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; cursor: pointer" title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="initPage();"> <img style="cursor: pointer;"
				title="Click to Return Main Menu"
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancelFunc();" /></td>
		</tr>
	</table>-->
				<br>
				<div align="center" id=" " style="display:none;">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div> 
				
				<input type="hidden" name="hmode" />
				<input type="hidden" name="strUpdateAuthNo" value="${authHierTransBean.strUpdateAuthNo}" />
				<input type="hidden" name="hlevTypAjax" value="0" />
				<input type="hidden" name="storePersist" value="0" />
				<input type="hidden" name="prevChkTxtname" value="" />
				<input type="hidden" name="prevChkIndx" value="100" />
				<input type="hidden" name="strLevelTypeMaxval" value="0^0^0^0" />
				<input type="hidden" name="strApprovalFlag" id="strApprovalFlag" value="${authHierTransBean.strApprovalFlag}" />
</div>

</div>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>