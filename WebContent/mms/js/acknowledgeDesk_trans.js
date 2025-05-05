
function notGreaterThanReceQty(_these,index)
{
	var recevQty = _these.value;
	var avlQty   = document.getElementById("strHiddenValue"+index).value.split("^")[2];
	//var brkQty = document.getElementById("strBkgQty"+index).value;
	if(recevQty.length==0)
	{		
		recevQty.value='0';
		//parseFloat(brkQty).toFixed(2) = parseFloat(avlQty).toFixed(2);
		return false;	
	}	
	
	brkQty = parseFloat(avlQty).toFixed(2) - parseFloat(recevQty).toFixed(2);
//	document.getElementById("strBkgQty"+index).value=parseFloat(brkQty).toFixed(2);
}

function FuncTick(obj)
{
  if(obj.value == '1')
  {
    document.forms[0].strApproved.checked = true;
    document.forms[0].strRejected.checked = false;
    document.forms[0].strAckAppFlg.value = "1";
    document.forms[0].strRemarks.value = "Acknowledge Approval Remarks";
    
  }
  else
  {
     document.forms[0].strRejected.checked = true;
     document.forms[0].strApproved.checked = false;
     document.forms[0].strAckAppFlg.value = "2";
     document.forms[0].strRemarks.value = "Acknowledge Rejection Remarks";
     
     
  }
  
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function getCmbValView(){
	
	
	if(document.forms[0].strComboVal.value == '0'){
		document.getElementById('ackDtlDivId').style.display="none";
	}else if(document.forms[0].strComboVal.value == '1'){
		document.getElementById('ackDtlDivId').style.display="block";
	}
}



function chkUserDefinedFunc(these){
	
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
		}			
	}
	try{    
		if(checkCount==1){
		       if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value == 0){
				enableButton("Acknowledge");
				enableButton("View");
				}else if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value == 1){
				
					disableButton("Acknowledge");
					enableButton("View");
					enableButton("Print");
				}
			} 
			else
				{
					disableButton("Acknowledge");
					disableButton("View");
					disableButton("Print");
				}
	}catch(Err){
		alert(Err);
	}
}

/**

function chkStatusFunc(){

	if(document.forms[0].combo[1].value == "0"){
			
					enableButton("Acknowledge");
					enableButton("View");
				
			}
			
			
	}else if(document.forms[0].combo[1].value == "1"){
			
					disableButton("Acknowledge");	
					enableButton("View");
				
		}
	}
*/

function callPage1(form1,mode){
	
	cmbVal="";
	
	if(document.forms[0].combo[0].value == "0"){
		alert("Please Select Drug Warehouse Name from Drug Warehouse Combo");
	}else{
	with(form1){
	if( mode == "ACKNOWLEDGE" && document.forms[0].combo[0].value!="0" ){
			cmbVal =combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
	document.forms[0].hmode.value="ACKNOWLEDGE";
	document.forms[0].submit();
			}
		}
	}
}

function viewAcknowledge(){
		
	document.forms[0].hmode.value="VIEW";
	document.forms[0].submit();
			
}

function resetPage()
{
   var saveObj = document.getElementById("saveId");
    saveObj.style.display = "block";
   document.forms[0].reset();
	
}
function cancelToDesk()
{
	showMenuFrame();
	document.forms[0].hmode.value="RETURNTODESK";
	document.forms[0].submit();
}

function validate2()
{
	var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
		var checkCount=1;
		var check=document.getElementsByName("strReceivedQty");
		
		
		for(i=0;i<check.length;i++)
		{
			var avlQty   = document.getElementById("strHiddenValue"+i).value.split("^")[2];
			
			if(parseInt(avlQty,10)<parseInt(check[i].value,10))
			{
				alert("Received Quantity Can't be Greater than Issue Quantity!!!");
				check[i].value = parseInt(avlQty,10);
				//document.getElementById("strBkgQty"+i).value = '0';
				check[i].focus();
				saveObj.style.display = '';
				return false;
			}
			//else
			//{
			//  document.getElementById("strBkgQty"+i).value = parseInt(avlQty,10) - parseInt(check[i].value,10) ;	
			//}
		
			if(parseInt(check[i].value,10) > 0) checkCount = 0;
					
		}
	    
		if(checkCount==1)
		{
		    var conf1 =  confirm("Received Quantity for All Drug(s) are Zero!!!\n\nYou still want to save");
		    if(conf1 == false) {
		    	saveObj.style.display = '';
		    	return false;
		    }
		    
		} 
				
		var hisValidator = new HISValidator("acknowledgeTransBean");
		hisValidator.addValidation("strRemarks", "req", "Remarks is mandatory" );
		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
		var retVal = hisValidator.validate(); 
		hisValidator.clearAllValidations();
		
		if(retVal)
		{
				
					  var conf = confirm("You Are Going To Acknowledge Records");
	                  if(conf == true)
	                  {
	                       var conf1 = confirm("Are you sure !!!");
	                       if(conf1 == true)
	                       {
	                       	  saveObj.style.display = 'none';
	                          document.forms[0].hmode.value = "INSERT";
	                          document.forms[0].submit();
	                       }
	                      else
	                       {
	                       	 saveObj.style.display = '';
	                         return false;
	                       }
	                   }
	                  else
	                   {	                   	
	                   	 saveObj.style.display = '';
	                         return false;
	                   }
				                
				//}
					             
			              
		}		
		else
		{
			 saveObj.style.display = '';
			return false;
		}
	  }
  else
  {
  	    saveObj.style.display = '';
		return false;
  }
}

function changeCombo(obj){
	
	if(obj[0].value == '0' || obj[1].value == '0'){
		
			disableButton("Acknowledge");
			disableButton("View");
	}
}
function printData()
{
	
	newwin = window.open('', 'printwin',
	'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');
	
	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	
	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
}


var gblMode = "0";
var gblStoreId = "0";
var gblIssueNo = "0";
var gblIndentDate;
var gblIndentNo;

/**
 * gets and displays the issue details new popup in Report Format.
 * 
 * @param strMode - there are two modes are available they are
 * 					1. Items Issued to Patient / Staff
 * 					2. Items Issued to Sub Stores / Departments.
 * 
 * @param strStoreId - From Store Id.
 * @param strIssueNo - Issue No.	
 * @return
 */
function getVoucher(strMode, strStoreId, strIssueNo,strIndentNo,strIndentDate) {

	gblMode = strMode;
	gblStoreId = strStoreId;
	gblIssueNo = strIssueNo;
	if(!isNaN(strIndentNo)){
		 if(strIndentNo.length>0){
	  	gblIndentNo=strIndentNo;
	  	gblIndentDate=strIndentDate;
	  }else{
	  		gblIndentNo="0";
	  		gblIndentDate="0";
	  }
	}else{
		    gblIndentNo="0";
	  		gblIndentDate="0";
	}
    var itemStockObj = document.getElementById("issueDtlsDivId");

	if (itemStockObj.innerHTML == "") {

		var hmode = "ACKVOUCHER";
		var url = "AcknowledgeTransCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
				+ "&strStoreId=" + strStoreId + "&strIssueNo=" + strIssueNo+"&strIndentNo="+gblIndentNo+"&strIndentDate="+gblIndentDate;
		//	alert(url);	
		ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");

	} else {
		// set for 1024 * 760 screen don't change this
		popup('popUpDiv', '80', '60');
	}

}

/**
 * customized ajax response function.
 * @param res
 * @param mode
 * @return
 */
function getIssueDtlsAjaxResponse(res, mode) {

	//STOCKDTLSINIT
	if (mode == '1') {

		var itemStockObj = document.getElementById("issueDtlsDivId");

		//itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;;
		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}

}


function getPrintReport2()
{
	//alert("Req type:::"+document.getElementsByName("strRequestTypeId")[0].value);
    if(parseInt(document.getElementsByName("strRequestTypeId")[0].value)==51)
    {    	
    	  //alert("------getPrintReport2.getReport2()--Req_Type---:::"+document.getElementsByName("strRequestTypeId")[0].value);
    	  document.forms[0].strAckStatus.value ="1";
    	  getReport2();	    
    	  
    }
    else
    {
    	   //alert("------getPrintReport2.getReport1()--Req_Type---:::"+document.getElementsByName("strRequestTypeId")[0].value);
    	   document.forms[0].strAckStatus.value ="1";
    	   getReport1();
    }
	
	 if(parseInt(document.getElementsByName("strReqTypeId")[0].value)==18)
	 {
		//alert("------getPrintReport2.getReturnRequestReport()--Req_Type---:::"+document.getElementsByName("strRequestTypeId")[0].value);
	 	getReturnRequestReport();
	 }
}


function getPrintReport()
{
	//alert("Req type:::"+document.getElementsByName("strRequestTypeId")[0].value);
    if(parseInt(document.getElementsByName("strRequestTypeId")[0].value)==51)
    {
    	var strAckStatus = document.forms[0].strAckStatus.value;
    	//alert("strAckStatus::"+strAckStatus);
    	if(parseInt(strAckStatus)!=0)
	    {
    		 //alert("------getPrintReport --> getReport2()--Req_Type---:::"+document.getElementsByName("strRequestTypeId")[0].value);
    		 
    	  getReport2();
	    }  
    	  
    }
    else
    {
    	//alert("------getPrintReport --> getReport1()--Req_Type---:::"+document.getElementsByName("strRequestTypeId")[0].value);
    	getReport1();
    }
	
}
// function to show report after save data
function getReport2()
{
	 var transferNo    = document.forms[0].strTransNo.value;
	 var storeId       = document.forms[0].strStoreId.value;
	 if(parseInt(transferNo)==0)
	 { 
       transferNo= document.getElementsByName("strHidVal")[0].value.split("^")[4];
	 }  
	 if(parseInt(transferNo)!=0)
	 { 
	   var mode="TRANSFERDTL";
	   var url="AcknowledgeTransCNT.cnt?hmode="+mode+"&transferNo="+ transferNo+"&storeId="+storeId+"&dwhName="+document.forms[0].strHidVal.value
	   ajaxFunction(url,"1");
	 }  	
    	
	
}
function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
      } 
     
     if(mode=="1")
     {
     	
     	 var objVal2 = document.getElementById("transferDtlsDivId");
     	 objVal2.innerHTML = res;
     	 popup('popUpDiv1', '130', '200');
     	 document.forms[0].strTransNo.value ="0";
     	
     }
}


function getReport1()
{
	var strAckStatus = document.forms[0].strAckStatus.value;
	var strStoreId =  document.forms[0].strStoreId.value;
	var strTransNo =  document.forms[0].strTransNo.value;
    
	if(parseInt(strAckStatus)!=0)
	{
		getVoucher('4', strStoreId, strTransNo);
		
			
		document.getElementById("normalMsg").innerHTML="Record Saved Successfully!!!";
	}
	document.forms[0].strAckStatus.value ="0";
	document.forms[0].strRequestTypeId.value="0";
	
}

function hideTransferPopup(mode)
{
		
				 
          document.getElementById("transferDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		  document.forms[0].strAckStatus.value = '1';
		 
		
}

function printDataForTransfer() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	
	newwin.document.write(document.getElementById('transferDtlsDivId').innerHTML);
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	


function getReturnRequestReport()
{
		 	
	// alert("strReqTypeId->"+document.forms[0].strReqTypeId.value);
	// alert("strStoreId->"+document.forms[0].strStoreId.value);
	// alert("strReturnStatus->"+document.forms[0].strReturnStatus.value);
	 //alert("strTransNo->"+document.forms[0].strTransNo.value);
	 
	 if(document.forms[0].strReturnStatus.value=="1")
	 {
		 getVoucher('5', document.forms[0].strStoreId.value,document.forms[0].strTransNo.value) ;
	 }
}