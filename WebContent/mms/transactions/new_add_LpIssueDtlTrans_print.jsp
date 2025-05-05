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

    <style>
    	.container-fluid > div.row > div > div > p{
    		margin-bottom:5px;
    	}
    	.underDvlpmntMsg{
    			display: none;
    		}
    	@media print{
    		.disposableOnPrint, .underDvlpmntMsg, #printid1{
    			display: none;
    		} 
    	}
    </style>
</head>
<body>
<html:form action="/transactions/LPIssueDeskTransCNT"  name="lpIssueDeskTransBean" type="mms.transactions.controller.fb.LPIssueDeskTransFB" method="post">
<script>
$(document).ready(function(){
});
function saveData(e){
	   $.ajax({
			url:"/HBIMS/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=NEWISSUESAVE&toPrintFlg=1&issueDtlJson="+$('input[name=issueDtlJson]').val(),
			async:true, 
			success: function(result){
				alert("Saved Successfully");
				$(e).hide();
				}
		}); 
	console.log($('input[name=issueDtlJson]').val());
}
</script>
<div class="container-fluid">
<!-- 	<div class="row">
		<div class="col-sm-12 text-center">
			<img class="img-responsive" src="/HIS/hisglobal/images/login/nims-logo.jpg" style="float:left;width: 65px;"/>
			<h4>Nizam's Institute of Medical Sciences</h4>
			<p>Hyderabad - 500082, Telangana, India</p>
		</div>
	</div> -->
	<div class="row">
		<div class="col-xs-3 col-sm-4">
		  <img class="img-responsive" src="/HIS/hisglobal/images/AIIMS_Logo.jpg" style="float:right;width: 65px;">
		</div>
		<div class="col-xs-9 col-sm-6 col-lg-4 text-center">
			<h4>All India Institute of Medical Sciences</h4>
			<p>000000</p>
		</div>
	</div>
	
	<div class="row disposableOnPrint">
		<div class="col-sm-12">
			<p class="text-right" style="font-size:22px;padding-right:15px;">
				<!-- <a class="saveLnk" href="javascript:;" onclick="saveData(this);"><i class="fa fa-save"></i></a> --> 
				<a href="javascript:;" onclick="window.print();"><i class="fa fa-print"></i></a>  
				<!-- <a href="javascript:;" onclick="window.close();"><i class="fa">&#xf00d;</i></a> -->
			</p>
		</div>
	</div>
<!-- 	<div class="row">
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Store Name :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueStoreName"></small></p>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Date :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><script>document.write(new Date().toLocaleString());</script></p> 
			</div>
		</div>
	</div> -->
	<br>
	<div class="row">
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Issuing Store :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issuingStore"></small> (<small class="issueAdd"></small>)</p>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>CR No :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueCRNo"></small></p> 
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Issue Date :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueDate"></small></p> 
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Patient Name :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueToName"></small></p> 
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Issue No :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueNo"></small></p>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Patient Category :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issuePatCat"></small></p>
			</div> 
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Tin No :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueTinNo"></small></p>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Ward :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueWardName"></small></p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>D.L. No :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueDLNo"></small></p> 
			</div>
		</div>
		<div class="col-sm-6">
			<div class="col-xs-6 text-right">
				<p><b>Bill Receipt No :</b></p> 
			</div>
			<div class="col-xs-6">
				<p><small class="issueBillRcNo"></small></p> 
			</div>
		</div>
	</div> 
	<div class="row underDvlpmntMsg">
		<div class="col-sm-12 text-center"> 
			<h3>(Under Development)</h3>
		</div> 
	</div>
	<hr>
	
	<div class="row">
		<div class="col-sm-12"> 
			<table class="table table-hover table-striped itemListTable table-bordered">
				<thead>
					<tr>
						<th>S.No.</th>
						<th>Item Name</th>
						<th>Batch No</th>
						<th>Exp. Date</th> 
						<th>Issue Qty</th>
						<th>Unit Rate</th>
						<th>Cost</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6" class="text-right"><b>Total Rs.(Round) : </b></td>
						<td class="grandTotalCost" style="font-weight:bold"></td>
					</tr>
				</tfoot>
			</table> 
		</div>
	</div>
	<hr style="border-top-style: dashed;border-color: #787878;">
	<div class="row">
		<div class="col-sm-7">
			<p><b>Rcv. By :-</b><font class="strRcvByName"></font></p>
			<p><b>Remarks :-</b></p>
			<p><b>Print Date :-</b> <font><script>document.write(new Date().toLocaleString());</script></font></p> 
		</div>
		<div class="col-sm-5 text-center">
			<p><b>Username</b></p>
			<p>(<b class="strUserName"></b>)</p>
		</div>
	</div> 
</div>

<script>
$(document).ready(function(){
/* 	var toSaveFlg = "0";
	if(toSaveFlg=="0")
		$('.saveLnk').hide();
	
	var totalCost = 0;
	$('.cost').each(function(){
		totalCost+= Number($(this).text());
		});
	$('.grandTotalCost').text(totalCost.toFixed(2)); */

	var storeId = "<%=session.getAttribute("storeId") %>"; 
	var issueNo = "<%=session.getAttribute("issueNo") %>";
	var hmode = "ISSUEDTLSINITSERVICE";  //ISSUEDTLSINIT
	$.ajax({
		url:"/HBIMS/mms/transactions/MmsCNT.cnt?hmode="+hmode+"&strMode=1&strStoreId="+storeId+"&strIssueNo="+issueNo+"&strIndentNo=0&strIndentDate=0&strUCReq=0",
		async:false,
		success:function(data){
			/* $('.container-fluid').html(data); 
			$('tr td font').css('font-size','16px !important');
			$('font[size=1]').attr('size','2'); */
			if(JSON.stringify(data) == "{}")
				return;
			
			var tempStr ="";
			console.log(data.ItemList.length);
			for(var i=0; i<data.ItemList.length;i++)
			{ 
				$('.itemListTable tbody').append('<tr><td>'+(i+1)+'</td><td>'+data.ItemList[i].strItemName+'</td><td>'+data.ItemList[i].strBatchSlNo+'</td><td>'+data.ItemList[i].strExpDate+'</td><td>'+data.ItemList[i].strIssueQty+'</td><td>'+data.ItemList[i].strRatePerUnit+'</td><td>'+data.ItemList[i].strItemCost+'</td></tr>');
			}
			$('.grandTotalCost').text(data.BasicDtl.totalCostWithoutSC);
			$('.issueStoreName').text(data.BasicDtl.strStoreName);
			$('.issueAdd').text(data.BasicDtl.strLocDL.split('@')[0]);
			$('.issueDLNo').text(data.BasicDtl.strLocDL.split('@')[1]);
			$('.issueTinNo').text(data.BasicDtl.strTinNo);
			$('.issueCRNo').text(data.BasicDtl.strCrno);
			$('.issueNo').text(data.BasicDtl.strIssueNo);
			$('.issueDate').text(data.BasicDtl.strIssueDate);
			$('.issueToName').text(data.BasicDtl.strIssueTo);
			$('.issueBillRcNo').text(data.BasicDtl.strBillNo);
			$('.issuingStore').text(data.BasicDtl.strStoreName);
			$('.strUserName').text(data.BasicDtl.strUserName); 
			$('.issuePatCat').text(data.BasicDtl.strPatCat);
			$('.issueWardName').text(data.BasicDtl.strWardName);  
			$('.strRcvByName').text(data.BasicDtl.strRcvByName);  
			

			 
		}
	}); 
});	

function printData(){
	window.print();
};
function cancelToDesk(){
	window.close();
};
function hideIssuePopup(){
	 
}; 	
</script>
<input type="hidden" name="issueDtlJson"> 
</html:form>
</body>
</html>