/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/

function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="StockLedgerRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
		document.forms[0].strGroupId.value="0";
		document.forms[0].strItemId.value="0";
	}
}	

//Below Function is added by Aadil on 25-Jul-2013
function getItemCatCmb1(){ 

	if(document.forms[0].strStoreId.value!=0){
		var url ="StockLedgerRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
 		ajaxFunction(url,"4");
 	}else{
	document.forms[0].strItemCatNo.value="0";
	//document.forms[0].strGroupId.value="0";
	document.forms[0].strItemId.value="0";
}
}

function getGroupCmb(){ 

	if(document.forms[0].strItemCatNo.value!=0){
		var url ="StockLedgerRptCNT.cnt?hmode=GROUPCMB&itemCatId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 		}else{
		document.forms[0].strGroupId.value="0";
		document.forms[0].strItemId.value="0";
	}
}	

function getItemCmb(){ 

	if(document.forms[0].strGroupId.value!=0){
		var url ="StockLedgerRptCNT.cnt?hmode=ITEMCMB&groupId="+document.forms[0].strGroupId.value+"&storeId="+document.forms[0].strStoreId.value+"&itemCatId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"3");
 		}else{
		document.forms[0].strGroupId.value="0";
	}
}

//Below Function is added by Aadil on 25-Jul-2013
function getItemCmb1(){ 

		var url ="StockLedgerRptCNT.cnt?hmode=ITEMCMB&groupId=0&storeId="+document.forms[0].strStoreId.value+"&itemCatId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"5");
}

function enableBatchWise()
{
	if(document.getElementsByName("strStoreId")[0].value > 0 && document.getElementsByName("strItemId")[0].value > 0)
	{
		document.getElementsByName("strWhetherBatchWise")[0].disabled = false;
	}
	else
	{
		document.getElementsByName("strWhetherBatchWise")[0].checked = false;
		document.getElementsByName("strWhetherBatchWise")[0].disabled= true;
	}
	document.getElementById("stockLedgerDetailDivId").style.display='none';
	document.getElementById("showButtonID").style.display='none';
	
}

function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		
		
			var objVal= document.getElementById("stockLedgerDetailDivId");
			objVal.innerHTML = res;		
			document.getElementById("stockLedgerDetailDivId").style.display='';
			document.getElementById("showButtonID").style.display='';
	}	
	
	if(mode=="2"){ 
		
		
			var objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupId' class='comboNormal' onchange='getItemCmb();'>"+res+"</select>";		
		
	}	
	if(mode=="3"){ 
		
		
			var objVal= document.getElementById("itemDivId");
			objVal.innerHTML = "<select name ='strItemId' class='comboNormal' >"+res+"</select>";		
		
	}
	
	// Below modes are added by Aadil
	if(mode=="4"){ 
		
		var objVal= document.getElementById("itemCatDivId");
		objVal.innerHTML = "<select name='strItemCatNo' class='comboNormal' onchange='getItemCmb1();'>"+res+"</select>";
		//document.getElementById("stockLedgerDetailDivId").style.display='';
		//document.getElementById("showButtonID").style.display='';
		getItemCmb1();
	}	
	
	if(mode=="5"){ 
		
			//alert("inside ajax->mode=5");
			var objVal= document.getElementById("itemDivId");
			objVal.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='enableBatchWise()' >"+res+"</select>";
			
			if(document.getElementsByName("strItemCatNo")[0].value=="10"){
				document.getElementById("drugLabelDivId").style.display="";
				document.getElementById("itemLabelDivId").style.display="none";
			}else{
				document.getElementById("drugLabelDivId").style.display="none";
				document.getElementById("itemLabelDivId").style.display="";
			}
			enableBatchWise();
		
	}
}
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function clearPage(){
	document.forms[0].strStoreId.value="0";
	document.getElementById("itemCatDivId").innerHTML = "<select name='strItemCatNo' class='comboNormal' onchange='getItemCmb1();'><option value='0'>Select Value</option></select>";
	document.getElementById("itemDivId").innerHTML = "<select name ='strItemId' class='comboNormal' onchange='enableBatchWise()' ><option value='0'>All</option></select>";
	document.forms[0].strItemId.value="0";
	document.getElementsByName("strWhetherBatchWise")[0].checked=false;
	document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value;
	document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value;
	document.getElementById("showButtonID").style.display="none";
	document.getElementById("stockLedgerDetailDivId").style.display="none";
		
}


function onLoadPage(){
		
		document.forms[0].strStoreId.value="0";
		document.getElementsByName("strWhetherBatchWise")[0].disabled = true;
		document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value;
		document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value;

}


function validate()
{
	var hisValidator = new HISValidator("stockLedgerRpt");
	if( document.getElementsByName("strStoreId")[0].value==0){
		
		alert("Please Select Store Name");
		return false;
		
	}
	if(document.getElementsByName("strItemCatNo")[0].value==0) 	
	{
		alert("Please Select Item Category");
		return false;
	}
		if( document.getElementsByName("strStoreId")[0].value==0){
			
			if(document.getElementsByName("strItemCatNo")[0].value==0) 	
			{
				alert("Please Select Item Category");
				return false;
			}
			if(document.getElementsByName("strItemId")[0].value==0) 	
			{
				alert("Please Select atleast one of Store Name or Item/Drug Name");
				return false;
			}
		}
		
		
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
	//	hisValidator.addValidation("strFromDate","dtlt="+document.forms[0].strCurrentDate.value,"Please Select From Date Less Than Current Date");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than Or Equal to Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select From Date Less Than Or Equal to To-Date");
		
	
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
	
		if(retVal){
		
				document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
				document.forms[0].strDrugName.value = document.forms[0].strItemId[document.forms[0].strItemId.selectedIndex].text;
				
				
				
				//document.getElementById("showButtonID").style.display="block";
				 
				//document.getElementById("consolidatedChallanDetailDIV").innerHTML = "";
				
				//document.getElementById("stockLedgerDetailDivId").innerHTML = "";
				
				 var batchFlag;
				 
				 if(document.getElementsByName("strWhetherBatchWise")[0].checked==true)
				 {
				 	batchFlag = '1';
				 }
				 else
				 {
				 	batchFlag = '0';
				 }
				 
				 
			
				var mode="getStockLedgerDtl";
				
				var url="StockLedgerRptCNT.cnt?hmode="+mode+
				"&storeId="+document.forms[0].strStoreId.value+
				"&itembrandId="+document.forms[0].strItemId.value+
				"&batchFlag="+batchFlag+
				"&fromDate="+document.forms[0].strFromDate.value+
				"&toDate="+document.forms[0].strToDate.value+
				"&storeName="+document.forms[0].strStoreName.value+
				"&drugName="+document.forms[0].strDrugName.value+
				"&strItemCatNo="+document.forms[0].strItemCatNo.value;
				
				
				
				//alert("storeId"+document.forms[0].strStoreId.value);
				//alert("itembrandId"+document.forms[0].strItemId.value);
				//alert("batchFlag"+batchFlag);
				//alert("fromDate"+document.forms[0].strFromDate.value);
				//alert("toDate"+document.forms[0].strToDate.value);
				
				url = (url.replace(/%/g, '@@@@'));
				ajaxFunction(url,"1");
		}
		else
		{
			return false;
		}
}


function GetIndex(index,endVal)  // Pagenation  One
{
	
	   //alert("Index::::"+index);
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
		
			 
}


function GetIndex1(index,endVal)  // Pagenation  One
{
	
	 if(index == document.forms[0].TotalLayer1.value)
	 {
	      document.getElementById("closingDiv").style.display="block";
	  
	 }
	 else
	 {
	     document.getElementById("closingDiv").style.display="none";
	 }
	   //alert("Index::::"+index);
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg1'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg1'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId1"+i).style.display="none";
		  }
		  document.getElementById("DivId1"+index).style.display="block";
		
			 
}



//To open View Page
function openViewPage()
{
	viewData(document.forms[0]);
	//document.getElementsByName("strViewCheckBox")[0].checked=false;
}

function viewData(form1) //View Page
{


					document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
					document.forms[0].strDrugName.value = document.forms[0].strItemId[document.forms[0].strItemId.selectedIndex].text;
					
					//alert("strStoreName"+document.forms[0].strStoreName.value );
					//alert("strDrugName"+document.forms[0].strDrugName.value );
					
				 	var batchFlag;
					 
					 if(document.getElementsByName("strWhetherBatchWise")[0].checked==true)
					 {
					 	batchFlag = '1';
					 }
					 else
					 {
					 	batchFlag = '0';
					 }

					var mode	=	'GETVIEWPAGE';
			
					var url="StockLedgerRptCNT.cnt?hmode="+mode+
					"&storeId="+document.forms[0].strStoreId.value+
					"&itembrandId="+document.forms[0].strItemId.value+
					"&batchFlag="+batchFlag+
					"&fromDate="+document.forms[0].strFromDate.value+
					"&toDate="+document.forms[0].strToDate.value+
					"&storeName="+document.forms[0].strStoreName.value+
					"&drugName="+document.forms[0].strDrugName.value+
					"&strItemCatNo="+document.forms[0].strItemCatNo.value;
					
					
			window.open(url, "popupWindow",	"width=1000,height=600,top=250,left=100,scrollbars=yes");
	
	
}


function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("suppPerformanceDtlsDivIdMain").innerHTML = "";			
		  hide_popup('popUpDivMain');
		} 

}

function printThis()
{
	var divObj = document.getElementById("saveId");
	
	divObj.style.display="none";
	window.print();
	divObj.style.display="block";
}

/**
 * Prints the report.
 * @return
 */
function printData(mode) 
{

	newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	
	newwin.document.write('window.close();\n');

	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	



/**
 * 
 */
function chkBoxClick(obj,index)
{	  
	  	 /* Value Pass in Web Row Set
		  1.  STR_NAME
		  2.  ITEM_NAME	
		  3.  BATCH_NO	
		  4.  OP_BALANCE	
		  5.  ACTIVE_ISSUE	
		  6.  INACTIVE_ISSUE	
		  7.  QUARTINE_ISSUE	
		  8.  ACTIVE_REC	
		  9.  INACTIVE_REC	
		  10  QUARTINE_REC									  
		  11. STR_ID
		  12. ITEM_ID
          	 */    	   	
	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	   
	   
	   
	   var storeId 		= 	hiddenVal.split("^")[10];  	
	   var itemBrandId  = 	hiddenVal.split("^")[11]; 
	   var batchNo 		=	hiddenVal.split("^")[2];
	   var fromDate		=	document.forms[0].strFromDate.value;
	   var toDate		=	document.forms[0].strToDate.value;
	   var storeName	=	hiddenVal.split("^")[0]; 
	   var drugName		=	hiddenVal.split("^")[1];
	   var op_balance	=	hiddenVal.split("^")[3];
	   var catcode 		= 	hiddenVal.split("^")[12];
	   var rate			= 	hiddenVal.split("^")[13];
	  // alert(catcode);
	   var batchFlg;
	   
	 // alert("hiddenVal"+hiddenVal);
	 //  alert("fromDate"+fromDate);
	 //  alert("toDate"+toDate);
	//   alert("op_balance"+op_balance);
	   
	   
	   // Set Selected Record Value For Show Report Method
     //  document.forms[0].strProcRelatedValue.value = hiddenVal;
     
     if(document.getElementsByName("strWhetherBatchWise")[0].checked==true)
     {
     	document.getElementsByName("strWhetherBatchWise")[0].value = '1'; 
     	batchFlg =   '1';
     }
     else
     {
     	document.getElementsByName("strWhetherBatchWise")[0].value = '0';
     	batchFlg =   '0';
     }
	   
	    
	   
	   
	  var mode="getDetailedStockLedgerDtl";
	var url="StockLedgerRptCNT.cnt?hmode="+mode+
			"&storeId="+storeId+
			"&itembrandId="+itemBrandId+
			"&batchNo="+batchNo+
			"&fromDate="+fromDate+
			"&toDate="+toDate+
			"&storeName="+storeName+
			"&drugName="+drugName+
			"&openingBalanceActive="+op_balance.split("#")[0]+
			"&openingBalanceInActive="+op_balance.split("#")[1]+
			"&openingBalanceQuarantine="+op_balance.split("#")[2]+
			"&batchFlg="+batchFlg+
			"&catcode="+catcode+
			"&rate="+rate;
	
	
	 url = (url.replace(/%/g, '@@@@'));
	
	
	window.open(url, "popupWindow",	"width=1000,height=600,top=250,left=100,scrollbars=yes");
	
}



/**
 * 
 */
function printDetailedStockLedgerReport(obj,index)
{	  
    	  
         
         /* Value Pass in Web Row Set
		  1.	TRANS_DATE
		  2.	PARTICULARS	
		  
		  3.	ACTIVE_ISSUE	
		  4.	INACTIVE_ISSUE	
		  5.	QUARTINE_ISSUE
		  	
		  6.	ACTIVE_REC	
		  7.	INACTIVE_REC	
		  8.	QUARTINE_REC
		  	
		  9.	STR_NAME	
		  10.	ITEM_NAME	
		  11.	HSTSTR_BATCH_SL_NO

          	 */    	  	 
	 	
	    	
	  // var hiddenVal = document.getElementById("strCheckHidValue"+(index-1)).value; 
	   
	   var previousParameters = document.getElementsByName("strHiddenParameter")[0].value;
	   
	 //   alert("hiddenVal"+hiddenVal);
	    
	    // values in previous parameters
	 //   vo.getStrDWHId()+"^"+vo.getStrItemBrandId()+"^"+vo.getStrFromDate()	+"^"+vo.getStrToDate() +"^"+vo.getStrBatchNo()+"^"+vo.getStrOpeningBalance() +"^"+ vo.getStrStoreName() +"^"+ vo.getStrDrugName() + "^"+vo.getStrBatchFlag();
	 
	   // alert("previousParameters"+previousParameters);
	    
	 //  alert("fromDate"+fromDate);
	 //  alert("toDate"+toDate);
	 //  alert("op_balance"+op_balance);
	   
	   var storeId 		= 	previousParameters.split("^")[0];  	
	   var itemBrandId  = 	previousParameters.split("^")[1]; 
	   var batchNo 		=	previousParameters.split("^")[4];
	   var fromDate		=	previousParameters.split("^")[2];
	   var toDate		=	previousParameters.split("^")[3];
	   var storeName	=	previousParameters.split("^")[6]; 
	   var drugName		=	previousParameters.split("^")[7];
	   var op_balance	=	previousParameters.split("^")[5];
	   var batchFlg     = 	previousParameters.split("^")[8];
	   var itemcatno     = 	previousParameters.split("^")[9];
	   var rate     = 	previousParameters.split("^")[10];
	   //alert("batchNo"+batchNo);
	 // alert("hiddenVal"+hiddenVal);
	 //  alert("fromDate"+fromDate);
	 //  alert("toDate"+toDate);
	  // alert("op_balance"+op_balance);
	   //alert("batchFlg"+batchFlg);
	   
	   // Set Selected Record Value For Show Report Method
     //  document.forms[0].strProcRelatedValue.value = hiddenVal;
	   
	  var mode="printDetailedStockLedgerReport";
	var url="StockLedgerRptCNT.cnt?hmode="+mode+
			"&storeId="+storeId+
			"&itembrandId="+itemBrandId+
			"&batchNo="+batchNo+
			"&fromDate="+fromDate+
			"&toDate="+toDate+
			"&storeName="+storeName+
			"&drugName="+drugName+
			"&openingBalanceActive="+op_balance.split("#")[0]+
			"&openingBalanceInActive="+op_balance.split("#")[1]+
			"&openingBalanceQuarantine="+op_balance.split("#")[2]+
			"&batchFlg="+batchFlg+
			"&catcode="+itemcatno+
			"&rate="+rate;								
	
	url = (url.replace(/%/g, '@@@@'));
	
	window.close(); 
	
	window.open(url, "popupWindow",	"width=1000,height=600,top=250,left=100,scrollbars=yes");
	
}


