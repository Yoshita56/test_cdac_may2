<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<html>
<head>
	<title>Store Hierarchy Wise Report</title>
	<link href="../css/master.css" rel="stylesheet" type="text/css">
	<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">	
	<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
	<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
	<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
	<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
	<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>

<script type="text/javascript">
function printModalContent() {
    var modalContent = document.getElementById("modalResponseContent");
    var styleElement = document.querySelector("style"); 
    var printWindow = window.open('', '', 'width=800,height=600');
    printWindow.document.open();
    printWindow.document.write('<html><head><title>Print</title>');
    if (styleElement) {
        printWindow.document.write(styleElement.outerHTML);
    }
    printWindow.document.write('</head><body>');
    if (modalContent) {
        printWindow.document.write('<div>' + modalContent.innerHTML + '</div>');
    }
    printWindow.document.write('</body></html>');
    printWindow.document.close();
    printWindow.print();
    printWindow.close();
}
function exportToExcel() {
	
    $('#modalResponseContent').table2excel({
        exclude: ".noExl", 
        name: "Worksheet Name",
        filename: "exported-data" 
    });
}
function openModal(response) {
    var modal = document.getElementById("myModal");
    var modalContent = document.getElementById("modalResponseContent");
    modalContent.innerHTML = response;
    modal.style.display = "block";
}
function closeModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}
function getReport() {
    var storeID = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
    var mode = "SHOWRPT";
    var url = "StoreHierarchyViewCNT.cnt?hmode=" + mode + "&storeId=" + storeID;
    $.ajax({
        url: url,
        type: "GET",
        dataType: "text", 
        success: function(res) {
        	console.log(res);
        	openModal(res);
        },
        error: function(xhr, status, error) {
            console.error("AJAX Error: " + status + " - " + error);
        }
    });
}
</script>
<style type="text/css">

.container {
  width: 100%;
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
  margin: 2%;
}

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
	
.modal {
    display: none;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
    position: relative;
    background-color: #fff;
    margin: 2% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
/*     max-width: 600px; */
	max-width: 60%;
    animation: modal-animation 0.3s ease;
}

.close {
    color: white;
    background-color: red;
    padding: 5px 10px;
    cursor: pointer;
    opacity: 1;
    float: left;
}

.modal-content .float-right {
	margin: 1%;
}

@keyframes modal-animation {
    from {
        transform: scale(0.8);
        opacity: 0;
    }
    to {
        transform: scale(1);
        opacity: 1;
    }
}
</style>
</head>
	<body>
		<html:form action="/reports/StoreHierarchyViewCNT" method="post">
			<div class="container-fluid">
				<div class="prescriptionTile">
					<div class='legendHeader' style='font-size: 16px;font-weight: bold;'>
					<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Store Hierarchy Wise Report</div>
						<div class="legend3" style="margin-top: -5%;" id='nonPrintableLegend2'>
							<button type="button" title="Cancel"  class="float-right btn btn-danger mt-1 btn-icon "style="border-radius:50%; padding:12px 12px" onClick="cancelFunc();">	
								<div class="popupToast" style="color: #fff;">
									<i class="fas fa-times " title="Cancel"></i>
								</div>
							</button>
							<button  type="button" title="Generate" class="float-right btn btn-success mt-1 btn-icon"  style="border-radius:50%; padding:12px 11px;" tabindex='2' onClick="getReport();"  data-toggle="" data-target="#previewModal" >
								<div class="popupToast" style="color: #fff;">
									<i class="fas fa-code-branch" title="Generate"></i>
								</div>
							</button>
			 			</div> 
					<div class="container">	
						<div class="row" style="margin: 2%;margin-top: 8%;">
							<div class="col-sm-3 py-2" style="text-align: right;"><label><b>Store Name</b><font color="red">*</font></label></div>
							<div class="col-sm-4" id="storeDivId"> 
								<select name="strStoreId" class='custom-select'> 
									<bean:write name="StoreHierarchyViewBEAN" property="strStoreCmb" filter="false" />
								</select>
							</div>
						</div>
					</div>
					<div id="myModal" class="modal">
			    <!-- Modal content -->
			    <div class="modal-content">
			        <div class="col-sm-12" style="margin-top: -4%;">
			            <span class="close" onclick="closeModal()">&times;</span>
						<img style="cursor: pointer; cursor: pointer; float: right;padding: 8px; background-color: mediumaquamarine;" text-align="right" title="Print Page" src="../../hisglobal/images/excel.png" onclick="exportToExcel();">
						<img style="cursor: pointer; cursor: pointer; float: right;padding: 1%; background-color: coral; margin-bottom: 3%; margin-right: 3%;"  text-align="right" title="Print Page" src="../../hisglobal/images/printer_symbol.gif" onclick="printModalContent();">
			        </div>
			        <div id="modalResponseContent"></div>
			    </div>
			</div>
				<input type="hidden" name="hmode"/>
				</div>
			</div>
		</html:form>
	<tag:autoIndex></tag:autoIndex>
	</body>
</html>