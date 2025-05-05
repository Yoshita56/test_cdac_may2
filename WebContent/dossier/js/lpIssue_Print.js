// global variable declaration
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
function getIssueDtls(strMode, strStoreId, strIssueNo,strIndentNo,strIndentDate,ucReq) {
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
		
		var hmode = "ISSUEDTLSINIT";
		var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
				+ "&strStoreId=" + strStoreId + "&strIssueNo=" + strIssueNo+"&strIndentNo="+gblIndentNo+"&strIndentDate="+gblIndentDate+"&strUCReq="+ucReq;
			//alert(url);	
		//ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");
		ajaxFunction2(url, "119", "getIssueDtlsAjaxResponse");

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

		itemStockObj.innerHTML = res;
		/*+"<p class='example'>.</p>"+res;*/

		popup('popUpDiv', '80', '60');

	}
	
	if (mode == "119") 
	{	//alert('res'+res);
		var itemStockObj = document.getElementById("transferDtlsDivId");
		itemStockObj.innerHTML = res;
		document.getElementById("normalMsg").innerHTML = "Data Saved Successfully";
		//document.forms[0].strStoreId.disabled=false;
		popup('popUpDiv1', '60', '80');	
		
	}

}


function getReport1() 
{    
	//alert('1');
	var transferNo    = document.forms[0].strIssueNo.value;
	//alert(transferNo);
    
	 var storeId       = document.forms[0].strStoreId.value;
	 
	 //alert("transferNo"+transferNo);
	 //alert("storeId"+storeId);
	 if(parseInt(transferNo)!=0 && document.forms[0].printReq.value == 1)
	 { 
		//alert('10'); 
	   var mode="ISSUEDTLSINITONE";
	   var url="LPIssueDeskTransCNT.cnt?hmode="+mode+"&strIssueNo="+ transferNo+"&strStoreId="+storeId+"&strMode=1";
	   ajaxFunction(url,"119");
	 }
}

/**
 * Prints the report.
 * @return
 */
function printData() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document
			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
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

/**
 * saves the report
 * @param fileName - Name that the file should be saved.
 * @return
 */
function saveData( fileName)
{
	document.getElementById("issueDtlsDivId").innerHTML = "";
		
		hide_popup('popUpDiv');
	
	/*
	var contents = document.getElementById('issueDtlsDivId').innerHTML;
		
	var newContent = contents.replace("block" , "none");
		
	writeToFile(newContent ,fileName);	
	*/
	
}


/**
 * is a java script function for saving the file in file system (currently not properly working in Fire Fox)
 * @param sText - contents that should be saved 
 * @param fileName - Name of the File.
 * @return
 */
function writeToFile(sText,fileName){
	 with(document){
	 ir=createElement('iframe');
	 ir.id='ifr';
	 ir.location='about:blank';
	 ir.style.display='none';
	 body.appendChild(ir);
	  with(getElementById('ifr').contentWindow.document){
	   open();
	   write(sText);
	   close();
	    if(document.compatMode && document.all){
	     execCommand('SaveAs',false,fileName+'.html');
	    }else{
	   //  location='data:application/octet-stream,'+encodeURIComponent(sText);
	   location='data:,'+sText;
	    }
	   }

	   setTimeout(function(){body.removeChild(ir);},1000);
	  }
	}


	function hideIssuePopup(){
	
		document.getElementById("issueDtlsDivId").innerHTML = "";
		
		hide_popup('popUpDiv');
		
	}
	function printDataOne(mode) 
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
		if(mode=='1')
		{
			if(document.getElementById('issueDtlsDivId').innerHTML != "")
				newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);	
			else
				newwin.document.write(document.getElementById('transferDtlsDivId').innerHTML);	
		}
		newwin.document.write('</BODY>\n');
		newwin.document.write('</HTML>\n');
		newwin.document.close();
		 document.getElementById("strCrNo").focus();

	}
	function hideIssuePopupOne() 
	{
		//alert('sadasd');
		//alert(document.forms[0].strcallfromipd.value);
		/*if(document.forms[0].strcallfromipd.value == '1')
		{
			//alert('if');
			document.forms[0].hmode.value = "cancelIssuetoIpd";
			document.forms[0].submit();
		}else{*/
			
		document.getElementById("transferDtlsDivId").innerHTML = "";
		hide_popup('popUpDiv1');
		document.forms[0].hmode.value = "RETURNTOMAINDESK";
		document.forms[0].submit();
		//document.getElementById("strCrNo").focus();
		//}
	}