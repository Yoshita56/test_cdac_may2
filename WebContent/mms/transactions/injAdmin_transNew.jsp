<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<html>
<head>
<meta charset="UTF-8">
<title>Template Design</title>
<!-- JS -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!-- EXT JS -->
<script language="Javascript" src="../js/InjAdminTrans.js"></script>

<script language="Javascript" src="../js/ValidationCommonn.js"></script>

<style>

a {
	  color: #5d5d5d;
	}



.btn:hover {
  color: #f7f7f7;
  text-decoration: none;
}
.menu .accordion-heading {  position: relative; }
.menu .accordion-heading .edit {
    position: absolute;
    top: 8px;
    right: 30px; 
}
.menu .area { border-left: 4px solid #d91717; }
.menu .equipamento { border-left: 4px solid #65c465; }
.menu .ponto { border-left: 4px solid #98b3fa; }
.menu .collapse.in { overflow: visible; }


.accordion{margin-bottom:20px;}
.accordion-group{margin-bottom:2px;border:1px solid #e5e5e5;-webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px;}
.accordion-heading{border-bottom:0;}
.accordion-heading .accordion-toggle{display:block;padding:8px 15px;}
.accordion-toggle{cursor:pointer;}
.accordion-inner{padding:9px 15px;border-top:1px solid #e5e5e5;}


table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 8px;
}

/*
 marquee {
    color: red;
    font-size: 16px;
    font-weight: bold;
  }
  */
  
  .marquee {
            color: red;
            width: 100%;
            overflow: hidden;
            white-space: nowrap;
            box-sizing: border-box;
            animation: marquee 40s linear infinite;
        }

        @keyframes marquee {
            from {
                transform: translateX(100%);
            }
            to {
                transform: translateX(-100%);
            }
        }

        #timer {
            font-weight: bold;
        }
        

  .container-flex {
    display: flex;
    flex-wrap: wrap;
  }
  .bordered {
    border: 1px solid #ccc;
    padding: 10px;
    border-radius: 5px;
    margin-bottom: 15px;
    flex: 1;
    display: flex;
    flex-direction: column;
  }
  .form-table {
    width: 100%;
    border-collapse: collapse;
    flex-grow: 1;
  }
  .form-table th, .form-table td {
    padding: 5px;
    vertical-align: middle;
  }
  .form-table th {
    text-align: right;
    width: 40%;
  }
  .form-control {
    width: 100%;
    box-sizing: border-box;
  }
  .form-table th label, .form-table td label {
    margin: 0;
  }

 </style>

</head>

<body onload="checkMsg();" >

<html:form name="injAdminTransBean" action="/transactions/InjAdministrationTransCNT" type="mms.transactions.controller.fb.InjAdministrationTransFB">
	<fieldset>
			<legend class='legendHeader' id='nonPrintableLegend'>Administration</legend>

			<div class="legend2" id='nonPrintableLegend2'>
				<button id="cancelButton" type="button"
					class="btn btn-outline-danger mt-1 btn-circle cancelbtn"
					onclick="cancelFunc();" title="Cancel">
					<div>
						<i class="fa fa-times iround" title="Cancel"></i>
					</div>
				</button>

				<button name="injAdminTransBean" type="button"
					class="btn btn-primary mt-1 btn-circle" property="strViewChk"
					onclick="toViewPage();" title="Click Here To View Previous Issue">
					<div>
						<i class="fas fa-eye iround"
							title="Click Here To View Previous Issue"></i>
					</div>
				</button>
			</div>

			<div id="errID" class="alert alert-danger alert-dismissible fade show" style="display:none;"><bean:write name="injAdminTransBean" property="strErrMsg" /></div>
			<div id="wrnID" class="alert alert-warning alert-dismissible fade show" style="display:none;"><bean:write name="injAdminTransBean" property="strWarningMsg" /></div>
			<div id="normalMsg" class="alert alert-success alert-dismissible fade show" style="display:none;"><bean:write name="injAdminTransBean" property="strNormalMsg" /></div>


			<div id="LFWise" style="display: none">
				<input type="text" name="strLFNo" value="${injAdminTransBean.strLFNo}"
					js=" onkeypress='return initGoFunc(event);'" /> 
				<input type="image"
					style="cursor: pointer; cursor: pointer; margin-top: 3px;"
					title="Issue Process" align="top"
					src="../../hisglobal/images/Go.png" name="go" value="Go"
					onclick="return getPatientAccStatus();"
					onkeyup="goFuncOnEnter(event);">
				<!-- <a href="#" class="buttonGo" id="go" onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);"></a> -->
			</div>

			<div class="container-fluid">
				<div class="prescriptionTile">

					<!-- <div class="container-fluid">
				<div class="prescriptionTile"> -->
    <div class="col-sm-12 my-2">        
					<div class="row rowFlex reFlex">
						<div class="col-sm-1" align="right">
								<label>Store Name</label>
						</div>
						<div class="col-sm-3">							
							<select name="strStoreId" onchange=" " class="browser-default custom-select">
								<bean:write name="injAdminTransBean" property="strStoreValues" filter="false" />
							</select>
						</div>																	
						
						<div class="col-sm-2" align="center">
							<label>Search Type</label>
						</div>
						<div class="col-sm-3">		
							<input type="radio" name="strRadioOne" value="2" onclick="radioChecked(this);"  checked> Date 				
			     	  	    <input class="mx-1" type="radio" name="strRadioOne" value="1" onclick="radioChecked(this);"> PIN Wise
			     	 
						</div>
													
						<div class="col-sm-3" align="left">
							<span class="fa fa-search" style="cursor: pointer; display: none;" id="searhPatientImageId" title="Click here for Patient Search" name="searchPatient" onclick="showPatientListingWindow('4',document.forms[0].strCrNo,'setSelectedCrNo');"></span>
								<a href="#" class="btn btn-sm btn-success" onclick="getPatientAccStatus();" id='goBtnId' onkeyup="goFuncOnEnter(event);" style="font-size: 1rem;">
								GO&nbsp;<i class="fas fa-angle-double-right"></i>
								</a>
						</div>	
	</div>
   </div>
  <!-- </div>
  </div> -->
  
					  <%-- <div class="container" id="typeId1" style="">
					  	<div class="col-sm-2">
								<label>PIN</label>
						</div>
					    <div class="col-sm-6">
					      <!-- <div id="patientCrEdId"> -->
					      		<input  name="strCrNo" class="form-control" value="${injAdminTransBean.strCrNo}" >
								<crNo:crNo value ="${injAdminTransBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
						  <!-- </div> -->
					    </div>
					 </div> --%>
					 <div class="col-sm-12" id="typeId1" style="display:none;" >
					 <div class="row rowFlex "  >
					 		<div class="col-sm-1" align="right">
								<font id="mandCRId" color="red">*</font><label>PIN.</label>
							</div>
							<div class="col-sm-3">
								<div id="patientCrEdId">
									<crNo:crNo value ="${injAdminTransBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
								</div>
							</div>
 					</div>
 					</div>
 					<div class="col-sm-12" id="typeId2" >
					  <div class="row rowFlex reFlex">
							<div class="col-sm-1" align="right">
								<label>Date</label>
							</div>
							<div class="col-sm-3">
									<input  name="strRecommendDate" class="form-control datepicker" value="${injAdminTransBean.strCtDate}" style="color: rgba(113, 111, 111, 0.87);">
							</div>
							<div class="col-sm-1" align="right">
								<label>Status</label>
							</div>
							<div class="col-sm-3">
									<select class="form-control" id="strStatus" name="strStatus">
					                    <option  value="0">ALL</option>
									    <option  value="P">Pending</option>
									    <option  value="A">Administered</option>
								    </select>
							</div>
							<!-- <div class="col-sm-1" align="right">
								<label>Type</label>
							</div>
							<div class="col-sm-3">
									<select name="strAdministrationType" onchange="   " class="browser-default custom-select">
										<option value="0">All</option>
										<option value="10">Whole</option>
										<option value="11">Partial</option>
									</select>
							</div> -->
					    <!-- <div class="col-sm-12"> -->
					      <%-- <table>
					        <tr>
					          <td><label for="PreOperative">Date:</label></td>
					          <td>
					            <input  name="strRecommendDate" class="form-control datepicker" value="${injAdminTransBean.strCtDate}" style="color: rgba(113, 111, 111, 0.87);">
					          </td>
							  <td><label for="PreOperative">Status</label></td>
					          <td>
					                <select class="form-control" id="strStatus" name="strStatus">
					                    <option  value="0">ALL</option>
									    <option  value="P">Pending</option>
									    <option  value="A">Administered</option>
								    </select>
					          </td>
					          
							  <td><label for="PreOperative">Type</label></td>
					          <td>
					                <select class="form-control" id="strTypeId" name="strTypeId">				    
									    <bean:write name="injAdminTransBean" property="strItemTypeCmb" filter="false" />
								    </select>
					          </td>
					        </tr>
					        
					      </table> --%>
					    <!-- </div> -->
					 </div>
					 </div>
					<hr>
					<div class="row rowFlex reFlex text-right">
						<div class="col-sm-12">
							<font color="red">*</font>Fields Mandatory
						</div>
					</div>
				
				</div>
			</div>

		    <input type="hidden" name="hmode" />
			<input type="hidden" name="storeName" 				value="${injAdminTransBean.storeName}" />	
			<input type="hidden" name="crNo" 				value="${injAdminTransBean.strCrNo}" />
			<input type="hidden" name="strId" 					value="${injAdminTransBean.strId}" />		
			<input type="hidden" name="strMode"   				value="${injAdminTransBean.strMode}">
			<input type="hidden" name="strPath" 				value="${injAdminTransBean.strPath}" />
			<input type="hidden" name="printReq" 				value="${injAdminTransBean.printReq}" />
			<input type="hidden" name="checkFlg" 				value="2" />

			<div id="blanket" style="display: none;"></div>

			<div class="popUpDiv" id="popUpDiv" style="display: none;">
				<table bgcolor="white">
					<tr>
						<td>
							<div id="issueDtlsDivId" style="display: block;"></div>
						</td>
					</tr>
				</table>
			</div>

			<div class="popUpDiv" id="popUpDiv1" style="display: none;">
				<table bgcolor="white">
					<tr>
						<td>
							<div id="transferDtlsDivId" style="display: block;"></div>
						</td>
					</tr>
				</table>
			</div>

			<div class="modal" id="printModal">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-body" id="printableSlip">
							<logic:equal name="injAdminTransBean" property="isOpenPopUp" value="1">
								<logic:present name="injAdminTransBean" property="strPrintBill">
									<jsp:include
										page="/mms/transactions/billing_receipt_printing_popupNew.jsp"></jsp:include>
								</logic:present>
							</logic:equal>
						</div>
					</div>
				</div>
			</div>

			<div class='modal' id='searchPopupModalID'>
				<div class='modal-dialog modal-lg'
					style='max-width: 90vw; max-height: 65vh;'>
					<div class='modal-content'>
						<div class='modal-header' style='height: 11vh;'>
							<h3 class='modal-title text-left'>Patient Search</h3>
							<button type='button' class='close' data-dismiss='modal'
								style='margin-top: -36px;'>×</button>
						</div>
						<div class='modal-body' style='width: 90vw; height: 65vh;'>
							<iframe src='' style='width: 100%; height: 100%; border: none;'></iframe>
						</div>
					</div>
				</div>
			</div>

		</fieldset>
</html:form>
<script type="text/javascript">
		$('.datepicker').each(function() {
			$(this).datepicker({
				modal : true,
				header : true,
				footer : true,
				format : 'dd-mmm-yyyy'
			});
		});
		var today = new Date();
		var arr = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec" ];
		var mmm = arr[today.getMonth()];
		var hrs = today.getHours();
		var dd = today.getDate() + "-" + mmm + "-" + today.getFullYear();
		$('.datepicker').val(dd);
	</script>


</body>
</html>