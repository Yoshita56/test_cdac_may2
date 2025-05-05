<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>IPD Issue</title>
	<link rel="stylesheet" href="/HBIMS/mms/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="/HBIMS/mms/fontawesome/css/fontawesome.min.css">
    <link rel="stylesheet" href="/HBIMS/mms/bootstrap/css/bootstrap.min.css">
    <script src="../../hisglobal/jquery/3.6.0.min.js"></script>
    
    <script src="/HBIMS/mms/hotkeys/hotkeys.min.js"></script>  
    <link rel="stylesheet" href="/HBIMS/mms/SweetAlertNew/sweetalert.min.css">
    <link rel="stylesheet" href="/HBIMS/mms/SweetAlertNew/sweetalert.min.css.map">
    <script src="/HBIMS/mms/SweetAlertNew/sweetalert.min.js"></script>
	<link rel="stylesheet" href="/HBIMS/mms/flexdatalist/jquery.flexdatalist.min.css">
 	<script src="/HBIMS/mms/flexdatalist/jquery.flexdatalist.min.js"></script>     
 	<script src="/HBIMS/mms/js/new_add_LpIssueDtlTrans.js"></script>     
    <style>
    	body{
    		background-color: #e6e6e6;
    	}
    	body .container-fluid{
    		margin-top: 10px;
    		background-color: #fff;
    		box-shadow: 0 0 12px 1px #aaa;
    	}
    	.ipdIssueDeskEntryFrmTbl tfoot tr td{
    		color: #39398f;  /* #5959f5; #8989ff; */
    		font-size:16px !important;
    	}
    	.ipdIssueDeskEntryFrmTbl tfoot tr td small:first-child{
			font-weight:bold;
    	}
    	.ipdIssueDeskEntryFrmTbl tbody tr td .form-control{
    		height:28px;
    	}
    	.form-control{
    		color: #1c1c86 !important;
    	} 
    </style>
</head>
<body>
<html:form action="/transactions/LPIssueDeskTransCNT"  name="lpIssueDeskTransBean" type="mms.transactions.controller.fb.LPIssueDeskTransFB" method="post"> 
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 text-center" style="font-size:16px;">
				<b>
					<div class="errMsg text-danger"  id="errMsg"><bean:write name="lpIssueDeskTransBean" property="strErr"/></div>
					<div class="warningMsg text-warning" id="warningMsg"><bean:write name="lpIssueDeskTransBean" property="strWarning"/></div>
					<div class="normalMsg text-success" id="normalMsg"><bean:write name="lpIssueDeskTransBean" property="strMsg"/></div>
				</b> 
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12"> 
				<h4 class="text-info">IPD ISSUE & BS REQUEST PROCESS</h4>
			</div>
		</div>
		<br>
		<div class="row form-inline text-uppercase">
			<div class="col-sm-6">
				<div class="form-group">
					<label for="storeName">Store Name:</label>
					<font><bean:write name="lpIssueDeskTransBean" property="strStoreName"/></font>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group pull-right">
					<label>LPO COMPILATION REQUEST TO:</label>
					<font><bean:write name="lpIssueDeskTransBean" property="strStoreName"/></font>
				</div>
			</div>
			<!-- Hidden -->
			<div style="display:none" class="col-sm-6">
				<div class="form-group pull-right">
					<label style="display:none" for="lpStoreName">LP Request Place To:</label>
					<select style="display:none" class="form-control" name="lpStoreName" id="lpStoreName">
						<option value="0"><bean:write name="lpIssueDeskTransBean" property="strRaisingStoreName" /></option> 
					</select>
				</div>
			</div> 
		</div>
		<div class="clearfix"></div>
		<br>
		<div class="row">
			<div class="col-sm-12 text-right">
				<p>Date: <em><script>document.write(new Date().toDateString());</script></em></p>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table class="table table-striped table-hover table-condensed ipdIssueDeskEntryFrmTbl">
						<thead>
							<tr>
								<th>CRN</th>
								<th>Dept-Ward</th>
								<!-- <th>Indent No</th> -->
								<!-- <th>Diagnosis</th> -->
								<th>Medicine</th>
								<th>Batch No.</th>
								<th>Issue Qty.</th>
								<th>LP Qty.</th>
								<th>Rate/Unit</th>
								<th colspan="2">Cost</th>
							</tr>
						</thead>
						<tbody> 
							<tr>
								<td><input type="text" class="form-control" id="crNoId" name="crNo" placeholder="CRN" style="min-width: 146px" minlength="15" maxlength="15" onkeyup="return validateCrNo(this);" onkeypress="return isNumber(event)" value="10911" ></td>
								<td><input type="text" class="form-control" name="ward" placeholder="Dept-Ward" value="${lpIssueDeskTransBean.strDeptName}" style="min-width: 180px;"  readonly="true"></td>
								<td style="display:none;"><input type="text" class="form-control" name="indentNo" placeholder="Indent No" onfocus="updateFooter(this);" value="<%="abc101" %>"></td>
								<!-- <td><input type="text" class="form-control" name="diagnosis" placeholder="Diagnosis" autocomplete="off"></td> -->
								<td style="min-width: 250px;">
									<input type="text" class="form-control" name="medicine" placeholder="Medicine" onfocus="updateFooter(this);" autocomplete="off">
								</td>
								<td>
									<!-- <input type="text" class="form-control" list="drugBatchList" name="batchNo" placeholder="BatchNo" onfocus="updateFooter(this);" onblur="setRate(this)" autocomplete="off"> -->
									<select class="form-control" name="batchNo" onchange="updateFooter(this); setRate(this);" > 
									</select>
								</td>
								<td><input type="text" class="form-control" name="issueQty" placeholder="IssueQty" onkeypress="return isNumber(event)" onkeyup="return validateIssueQty(this);" style="max-width: 100px" value="0" onkeypress="return isNumberQtyCst(this,event)"></td>
								<td> 
									<input type="text" class="form-control" name="lpQty" placeholder="lP Qty" onkeypress="return isNumber(event)" value="0" style="max-width: 100px" onkeypress="return isNumberQtyCst(this,event)">
								</td>
								<td>
									<input type="text" class="form-control" name="ratePerUnit" placeholder="Rate" style="max-width: 100px" readonly="true"> <!-- onkeypress="return isNumberQtyCst(this,event)"  -->
								</td>
								<td>
									<input type="text" class="form-control" name="cost" placeholder="cost" style="max-width: 100px" value="0.00" onkeypress="return isNumber(event)" readonly="true">
								</td>
								<td>
									<button type="button" class="btn btn-xs btn-info ipdIssueEntryAddBtn" onclick="addNewEntryRow(this)"><i class="fa fa-plus"></i></button> 
								</td> 
									<input type="hidden" name="strNewItemId">
									<input type="hidden" name="strNewBrandId">
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td><small>Name: </small><small class="patientName"></small></td>
								<td><small>Adm No. </small><small class="admNo"></small></td>
								<!-- <td></td> -->
								<td><small>Batch Drug Avl: </small><small class="drugTypeAvl"></small></td> 
								<!-- <td><small>Exp Date: </small><small class="expDate"></small></td>
								<td><small>Rate/Unit: </small><small class="ratePerUnit"></small></td> -->
								<td colspan="3"></td>
								<td colspan="2"><small>A/C Bal: </small><small class="patAcBal"></small></td>
							</tr>
						</tfoot>
					</table>
				</div>
				<p style="color: #9f187c;text-transform: uppercase;/*! text-weight: bold; */font-weight: bold;"><small>Item Count: </small><small class="drugItemCount">1</small></p>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-sm-12">
				<div class="form-group">
					<label class="control-label col-sm-3 text-right">Received By :</label>
					<div class="col-sm-9">
						<input class="form-control" id="strReceivedby" name="strReceivedby" value="Ward Nursing Staff">
					</div>
				</div> 
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="form-group">
					<label class="control-label col-sm-3 text-right">Remarks :</label>
					<div class="col-sm-9">
						<textarea class="form-control" id="remarks" name="remarks"></textarea>
					</div>
				</div> 
			</div>
		</div> 				
		<div class="clearfix" style="margin: 10px 0px;"></div>
		<div class="row">
			<div class="col-sm-9 col-sm-offset-3">
				<div class="col-sm-6 text-center">
					<button class="btn btn-sm btn-danger" type="button" onclick="cancelToDesk();">Cancel</button>
				</div>
				<div class="col-sm-0 text-center">
					<button class="btn btn-sm btn-info" type="button" style="display:none" onclick="getIssueVoucher();">Preview</button> <!-- saveIssueVouchers('0'); -->
				</div>
				<div class="col-sm-6 text-center">
					<button class="btn btn-sm btn-success issueSaveBtn" type="button" onclick="return validateSave(this);">Save & Print Issue Vouchers</button>
				</div>
			</div>
		</div> 
		<div class="clearfix" style="margin: 10px 0px;"></div>
		<div class="row">
			<div class="col-sm-12">
				<div class="well well-lg">
					<h4>Info. & Legends</h4>
					<ul>
						<li>Issue Qty disabled for the items for which tariff is not available</li>
						<li>Shortcut Keys : Press Ctrl+a to add row, Ctrl+s to save record.</li> 
					</ul>
				</div>
			</div>
		</div>
		<div id="issueDtlsDivId"></div>
		<div id="returndivId"></div>
		<div id="popUpDiv"></div>
	</div>
	<datalist id="crNoDataLst">
		<option id="331011700508635#Patient Name1#adm 101#private1#a11001#fever" value="331011700508635"></option>
		<option id="331011700508631#Patient Name2#adm 102#private1#a11002#fever" value="331011700508631"></option>
		<option id="331011700508632#Patient Name3#adm 103#private1#a11003#fever" value="331011700508632"></option>
		<option id="331011700508634#Patient Name4#adm 104#private1#a11004#fever" value="331011700508634"></option>
		<option id="331011700508636#Patient Name5#adm 105#private1#a11005#fever" value="331011700508636"></option>
	</datalist>
	<datalist id="drugBatchList"> 
	</datalist>
<!-- 	<datalist id="medicineDataList">
		<option id="1001#PARACETAMOL" value="PARACETAMOL"></option>
		<option id="1002#DROXYL" value="DROXYL"></option> 
	</datalist>	 
	<datalist id="diagnosisDataList"> 
		<option id="B87.2#Ocular myiasis" value="Oculus myasis"></option> 
	</datalist>	  -->
	
	<!-- Trigger the modal with a button -->
	<!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button> -->
	
	<!-- Modal -->
	<div id="voucherPrintModal" class="modal fade" role="dialog">
	  <div class="modal-dialog modal-lg"> 
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Issue Voucher</h4>
	      </div>
	      <div class="modal-body">
	       	<iframe id="printModalIframeId" style="border:0px;width:100%;height:75vh;"></iframe>
	      </div> 
	    </div>
	
	  </div>
	</div>
	

	
 
		<script> 
		 $(document).ready(function(){
      	  try{ 
					/* $('input[name=diagnosis]').flexdatalist({
					     minLength: 1,
					     focusFirstResult: true,
					     maxShownResults: 50,
					     searchIn: 'diagnosisName', 
					   	 data: 'http://10.226.21.120:8088/HISDRDESK/services/restful/DrDesk/diagnosisList'
					 });  */
					 
					 $.ajax({
						 url: "/HBIMS/services/restful/DrugList/drugList?storeId=${lpIssueDeskTransBean.strStoreId}",
						 async: true,
						 success: function(result){
							 result.sort(function(a, b){
								    return b.drugQuan - a.drugQuan;
								});
							 console.log(JSON.stringify(result));
							 $('input[name=medicine]').flexdatalist({
							     minLength: 1,
							     focusFirstResult: true,
							     maxShownResults: 50,
							     searchIn: 'drugName', 
							     /* visibleProperties: ["drugName","drugCpaCode","drugTypeName"],   */
							   	 data: result
							 });  
							
							$('input[name=medicine].flexdatalist').on('select:flexdatalist', function(event, set, options) {
								$(this).attr('drugId',set.drugId+'#'+(set.drugQuan==""?"0":set.drugQuan));   
								$(this).attr('batchRate',set.batchesAndRates=="@"?"":set.batchesAndRates);    
								$(this).attr('brandId',set.brandId);   
								$(this).closest('tr').find('input[name=ratePerUnit]').val(set.batchesAndRates.split('@')[1].split(',')[0]);   
								$(this).closest('tr').find('input[name=strNewItemId]').val(set.drugId);   
								$(this).closest('tr').find('input[name=strNewBrandId]').val(set.brandId);    
								$(this).closest('tr').find('select[name=batchNo]').empty();
								for(var i=0;i<set.batchesAndRates.split('@')[0].split(',').length;i++)
								{
									//$('#drugBatchList').append('<option id="'+set.batchesAndRates.split('@')[1].split(',')[i]+'" value="'+set.batchesAndRates.split('@')[0].split(',')[i]+'"></option>');
									$(this).closest('tr').find('select[name=batchNo]').append('<option id="'+set.batchesAndRates.split('@')[1].split(',')[i]+'@'+set.batchesAndRates.split('@')[2].split(',')[i]+'" value="'+set.batchesAndRates.split('@')[0].split(',')[i]+'">'+set.batchesAndRates.split('@')[0].split(',')[i]+'</option>');
								}
								$('tfoot .drugTypeAvl').text(set.batchesAndRates.split('@')[2].split(',')[0]);  
							});
						 }
					 });
					
                 }
                 catch(err){
                      console.log('err.message:>>>'+err.message);
                 }  
           }); 
        </script>
		<input type="hidden" name="issueDtlJson">
		<input type="hidden" name="toPrintFlg">
		
		<input type="hidden" name="record_per_page">
		<input type="hidden" name="counter" value='0'>
		<input type="hidden" name="no_of_combo" value='null'>
		<input type="hidden" name="actual_page_block">
		<input type="hidden" name="nextBlock">
		<input type="hidden" name="prevBlock">
		<input type="hidden" name="divisionId" >
		<input type="hidden" name="divid"> 
		<input type="hidden" name="checkCount">
		<input type="hidden" name="flag" value='1'>
		<input type="hidden" name="comboValue">
		<input type="hidden" name="chkValue" value="">
		<input type="hidden" name="chkLength" value="0">
		<input type="hidden" name="totalpage">
		<input type="hidden" name="cnt_page" value='/transactions/LPIssueDeskTransCNT'>
		<input type="hidden" name="search" >
		<input type="hidden" name="searchColumn">
		<input type="hidden" name="rowNum" >
		<input type="hidden" name="prevNext"> 
		<input type="hidden" name="strVisibilityMode" value='0'>	
		
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strRequestTypeId" value="${lpIssueDeskTransBean.strRequestTypeId}"/>
	    <input type="hidden" name="strStoreId" value="${lpIssueDeskTransBean.strStoreId}"/>
	    <input type="hidden" name="strRequestDate" value="${lpIssueDeskTransBean.strRequestDate}"/>
	    <input type="hidden" name="strCrNo" value="${lpIssueDeskTransBean.strCrNo}"/>
	    <input type="hidden" name="strEmpNo" value="${lpIssueDeskTransBean.strEmpNo}"/>
	    <input type="hidden" name="strLpRequestNo" value="${lpIssueDeskTransBean.strLpRequestNo}"/>
	    <input type="hidden" name="strItemCategNo" value="${lpIssueDeskTransBean.strItemCategNo}"/>
	    <input type="hidden" name="strRaisingReqTypeId" value="${lpIssueDeskTransBean.strRaisingReqTypeId}"/>
	    <input type="hidden" name="strRaisingStoreId" value="${lpIssueDeskTransBean.strRaisingStoreId}"/>
	    <input type="hidden" name="strPoNo" value="${lpIssueDeskTransBean.strPoNo}"/>
	    <input type="hidden" name="strPoStoreId" value="${lpIssueDeskTransBean.strPoStoreId}"/>
	    <input type="hidden" name="chk" value="${lpIssueDeskTransBean.strChk}"/>
	    <input type="hidden" name="strIssueNo" value="${lpIssueDeskTransBean.strIssueNo}"/>
	    <input type="hidden" name="strStoreName" value="${lpIssueDeskTransBean.strStoreName}"/>
	    <input type="hidden" name="strBudgetFlg" value ="${lpIssueDeskTransBean.strBudgetFlg}"/>
	    <input type="hidden" name="strUrgentFlg" value ="${lpIssueDeskTransBean.strUrgentFlg}"/>
	    <input type="hidden" name="strBSReqNo" value ="${lpIssueDeskTransBean.strBSReqNo}"/>
	    <input type="hidden" name="strBillPaidCat" value ="${lpIssueDeskTransBean.strBillPaidCat}"/>
	    <input type="hidden" name="strSCMIntegrationflg" value ="${lpIssueDeskTransBean.strSCMIntegrationflg}"/>
	    <input type="hidden" name="strHospitalCode" value ="${lpIssueDeskTransBean.strHospitalCode}"/> 
	    <input type="hidden" name="strSeatId" value ="<%=session.getAttribute("SEATID").toString()%>"/>  
	    <input type="hidden" name="strDeptName" value ="${lpIssueDeskTransBean.strDeptName}"/>
	    <input type="hidden" name="strAdmissionDtlHidVal" value=""> 
	</html:form>
</body>
</html>