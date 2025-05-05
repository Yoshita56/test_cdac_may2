var gblMode 			= "0";
var gblStockStatus 		= "0";
var gblGenItemId 		= "0";
var gblItemId 			= "0";
var gblIssueQty 		= "0";
var gblIssueQtyInBase 	= "0"; 
var gblCountedQtyName 	= "" ;
var gblVarianceQtyName  = "";
var gblVarianceCostName = "";
var gblStoreId 			= "0";
var gblCatCode 			= "0";
var gblReservedFlag		= "0";
var gblUserHiddenFieldDivId 	= "";
var gblIndexId = "";
var gblUserDefinedFuncName = "";
var gblUserDefinedArg = "";
var gblUserDrugDtlDivId 	    = "";
var gblUserExpDtlDivId = "";
var gblUserMrpDtlDivId = "";
/**
 * Developer : Amit Kumar
 * Version : 1.0 
 * Date : 09/Aug/2011
 *  Module:MMS
 * Unit:Issue Desk Transaction
  *
 */
function totalCost()
{	   
       	    var costObj = document.getElementsByName("strCost");
			var total = parseFloat("0.00");
		   	if (costObj.length > 0) 
			{
		        
				for ( var i = 1; i <costObj.length+1; i++)
				{		        					
					total = total + parseFloat(document.getElementById("strCost"+i).value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strTotalCostDivId").value = roundValue(total, 2);
        document.forms[0].strApproxAmt.value=roundValue(total, 2);
       
}

function cancelProcess()
{
 
  	
  	document.forms[0].hmode.value = "CANCELPAGE_NA";
	document.forms[0].submit();
  	
  	
}

function cancelToDesk()
{
	
 	document.forms[0].hmode.value = "CANCELTODESK";	
	document.forms[0].submit();
  	
  	
}


function cancelToDesk_View()
{  
	//alert("CANCELPAGE");
	hide_popup('popUpDiv');
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();	
  	
}

function hidePopup() 
{

	hide_popup('popUpDiv');
	document.forms[0].hmode.value = "CANCELPAGE_NA";
	document.forms[0].submit();

}

/**
This function is used to set condition during change of name of reciever.
**/
function checkValCombo()
{
	var recievedByName=document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text;
	if(document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text=='Other' ){
		
		document.getElementById("labelId").className="LABEL";
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		if(document.forms[0].strReceivedBy.readOnly)
			document.forms[0].strReceivedBy.readOnly=false;
		document.forms[0].strReceivedBy.value="";
		document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Name of the Receiver";
		document.forms[0].strReceivedBy.focus();
	
	}else if(document.forms[0].strReceivedComboBy.value!="0" && document.forms[0].strReceivedComboBy.value!="1"){
		
		document.getElementById("labelId").className="LABEL";
		
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		document.getElementById("labelNameId").innerHTML="Name of the Receiver";
		document.forms[0].strReceivedBy.value=recievedByName;
		if(!document.forms[0].strReceivedBy.readOnly)
			document.forms[0].strReceivedBy.readOnly=true;
		document.getElementsByName("strRemarks")[0].focus();
		
		
	}else{
		document.getElementById("labelId").className="CONTROL";
		document.getElementById("nameOtherFld").style.display="none";
		document.getElementById("labelNameId").innerHTML="";
	}
}


function printDataOne() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n')
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
	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}

function printData1() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n')
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
	newwin.document.write(document.getElementById('issueDtlsPrintDivId').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}


function totalIssueCost()
{
       	    var costObj = document.getElementsByName("strFinalCost");
			var total = parseFloat("0.00");
			
		   	if (costObj.length > 0) 
			{
		        
				for ( var i = 0; i <costObj.length; i++)
				{		        					
					total = total + parseFloat(document.getElementById("strFinalCost"+i).value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strApproxAmtDivId").disabled = false;
	    document.getElementById("strApproxAmtDivId").value = total;
	     document.getElementById("strApproxAmtDivId").disabled = true;
        document.forms[0].strFinalApproxAmt.value=total;
       
}


function totalQty()
{
       	    var costObj = document.getElementsByName("strAvailableQty");
			var total = parseInt("0.00");
			
		   	if (costObj.length > 0) 
			{
		        
				for ( var i = 0; i <costObj.length; i++)
				{		        
					if(costObj[i].disabled==false &&  costObj[i].value.length>0 )
						total = total + parseInt(costObj[i].value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strTotalQtyDivId").innerHTML=total;       
       
}
/**
 * checkAvailQtyTwo - Qty validation.
 * @param {String} unitName
 * @param {String} qtyName  
 */
function checkAvailQtyTwo(index,  qtyName, unitName,costDiv) 
{      
		
	var drugBatchAvlQty   = document.getElementById("strDrugBatchAvlQty"+""+index).value;
	var         rateObj   = document.getElementById("strPurchaseRate"+""+index).value;
	var         qtyObj    = document.getElementById("strAvailableQty"+""+index).value;		
	var  qty_base_value   = document.getElementById("strAvailableQtyUnit"+""+index).value.split("^")[1];
	var avlQty   = parseInt(drugBatchAvlQty,10);				
	var    qty   = parseInt(qtyObj,10);	
	var   rate   = rateObj;
	var  count   = 0;

	if(isNaN(rate) || rate=="") rate = "0";
	if(isNaN(qty)  || qty=="") qty = "0";


	//		alert("Avl Qty:::"+avlQty+"::Issue Qty::"+qty);
	if(avlQty >= qty)
	{
		var total = parseFloat("0.00");


		if(qty=='0')		
		{
			qty_base_value = '0';	
			total = parseFloat(qty * qty_base_value * rate);
		}
		else
		{
			total = parseFloat(qty * qty_base_value * rate);
		} 		
		
		document.getElementById(costDiv.substring(0,12)+""+index).value = roundValue(total, 2);
		document.getElementById("strCost"+index).value = roundValue(total, 2);
		       
		var strLen = parseInt(document.getElementsByName("strExpiryRemainDays").length);



		var drugAvl 	= 0;
		var drugIssue 	= 0;
		var flagCount 	= 0;
		for(var k=0; k<strLen; k++)
		{

			if( (document.getElementsByName("strAvailableQty")[k].value!='') )
				flagCount = k;							

		}

		// alert(index);
		for(var j = 0; j<flagCount ; j++)
		{

			drugAvl 	= parseInt(document.getElementsByName("strDrugBatchAvlQty")[j].value);
			drugIssue 	= parseInt(document.getElementsByName("strAvailableQty")[j].value);

			//alert(drugAvl);
			//alert(drugIssue);

			if(drugIssue!=0 && drugAvl != drugIssue)
				count++;
		}


		totalQty();
		totalCost();
		if(parseInt(count)>0) 
		{
			res = prompt("Enter Remarks to Issue Less Expiry \n Because  ["+count+"] No of Durg(s) are Near Expiry Compare to Selected Drug(s)","");
//			alert(res);				   	      
			if(res!=null && !res=="")
			{				           
				document.getElementById(gblUserDrugExpDrugRemarksId).value=res;	
			}
			else if(res==null || res=="")
			{ 
				alert("Enter REMARKS For NOT Issuing Drugs having Lesser Expiry");
				document.getElementsByName("strAvailableQty")[(index-1)].value='';
			}

		}		
	}
	else
	{
		alert("Issue Qty of Batch [ "+document.getElementById("strAvlDrugBatch"+""+index).value +" ] is Greater than Available Quantity!!!");
		document.getElementById("strAvailableQty"+""+index).value = '';
		totalQty();
		totalCost();
		return false;

	}


	return true;
}
function validatePopUp() 
{
		
 		var chkObj = document.getElementsByName("strStockDtlsChk");
 		var count = parseInt("0");
 		var qtyValue = parseFloat("0");
 		var chkValue = "";
 		var costObj   ="";
 		var totalCost ="";
 		var index = document.forms[0].strIndex.value;
 		for ( var i = 0; i < chkObj.length; i++)
        {
			
 			if(chkObj[i].checked)
 			{
 				document.getElementById("strAvailableQtyUnit"+(i+1)).disabled= false;
 				count = count + 1;
 				
 				var qtyObj    = document.getElementById("strAvailableQty"+(i+1));
 				var unitObj   = document.getElementById("strAvailableQtyUnit"+(i+1));
 				// Here we Check Condition Either Budget Flag is On or Off
 				if(document.forms[0].strBudgetFlg.value=='1')
 				{
 				  costObj   = document.getElementById("strCost"+(i+1)).value;
 				  totalCost = document.forms[0].strApproxAmt.value;
 				  
 				  document.getElementById("finalCostDivId"+index).disabled  = false;	
 				 
 				  document.getElementById("finalCostDivId"+index).value  = 	totalCost;	
 				  document.getElementById("strFinalCost"+index).value  = 	totalCost;	
 				   document.getElementById("finalCostDivId"+index).disabled  = true;	
 				  
 				  
 				}
 				else
 				{
 					costObj   = "0";
 				    totalCost = "0";
 				    //document.getElementById("finalCostDivId"+index).disabled  = false;
 				    //document.getElementById("finalCostDivId"+index).value  = '0.00';
 				    //document.getElementById("strFinalCost"+index).value    = '0.00';	
 				    //document.getElementById("finalCostDivId"+index).disabled  = true;
 				}
 				 				
 				if(qtyObj.value.length < 1)
 				{
 					
 					alert("Please Enter the Quantity");
 					qtyObj.focus();
 					if(document.forms[0].strBudgetFlg.value=='1')
 				    {
 					 document.getElementById("finalCostDivId"+index).disabled  = false;
 					 document.getElementById("finalCostDivId"+index).value  ='0.00';
 					 document.getElementById("strFinalCost"+index).value    = '0.00';	
 					 document.getElementById("finalCostDivId"+index).disabled  = true;
 				    } 
 					
 					return false;
 				}
 				else
 				{
 					
 					
 					if(count == 1)
 					{
 						
 						chkValue = chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value+"^"+costObj+"^"+totalCost;
 						
 					}
 					else
 					{
 						
 						chkValue = chkValue +"#" + chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value+"^"+costObj+"^"+totalCost;
 						
 					}
 					
 					var unitBaseVal = unitObj.value.split('^')[1];
 					
 					qtyValue = qtyValue + (parseFloat(qtyObj.value) * parseFloat(unitBaseVal))
 					
 				}
 				
 			}
		}
 		

 		if(count > 0)
 		{
 			
 			var issueQty 	 = parseFloat(document.forms[0].strItemIssueQty.value); 			
 			var issueBaseVal = parseFloat(document.forms[0].strItemIssueQtyBaseVal.value);
 			
 			var issueVal = issueQty * issueBaseVal;
 			
 			
 			if(qtyValue != issueVal)
 			{
 				// Here we Check Condition Either Budget Flag is On or Off
 				if(document.forms[0].strBudgetFlg.value=='1')
 				{
	 				var costObj = document.getElementsByName("strCost");
					var total = parseFloat("0.00");
				   	if (costObj.length > 0) 
					{
				        
						for ( var i = 1; i <costObj.length; i++)
						{		        					
							document.getElementById("strCost"+i).value="0.00";
							document.getElementById("strStockCost"+i).value="0.00";
							document.getElementById("strTotalCostDivId").innerHTML = "0.00";
							document.getElementById("strAvailableQty"+i).value="0";
							
							
				 		}
				
					}
					document.getElementById("finalCostDivId"+index).disabled  = false;
	 				document.getElementById("finalCostDivId"+index).value  ='0.00';	
	 				document.getElementById("strFinalCost"+index).value    = '0.00';
	 				document.getElementById("finalCostDivId"+index).disabled  = true;
	 				totalIssueCost();
 				}
 				
 				
 				
 				alert("Quantity Total should be Equal to Issue Quantity");

				document.getElementById("strTotalCostDivId").value = '0.00';

 				return false;
 			}
 			
 		}
 		else
 		{
 			
 			alert("Please Select Atleast One Record");
 			if(document.forms[0].strBudgetFlg.value=='1')
 			{
	 			document.getElementById("finalCostDivId"+index).value  ='0.00';	
	 			document.getElementById("strFinalCost"+index).value    = '0.00';
 			}		
 			return false;
 		}
 		if(document.forms[0].strBudgetFlg.value=='1')
 		{
        /* This Method is Used to Calculate Total Approx Issue Cost(Rs.)   */
           totalIssueCost();
 		}  
 		
 		batchString();
 		document.getElementById(gblUserHiddenFieldDivId).value = chkValue;
 		
 		hide_popup('popUpDiv');
 		
 		 		
 		return true;
}


/**
 * checkAvailQty - Qty validation.
 * @param {String} unitName
 * @param {String} qtyName  
 */
function checkAvailQty(index,  qtyName, unitName) 
{      
	  
	    var rateObj = document.getElementById("strPurchaseRate"+""+index).value;
		var qtyObj  = document.getElementById("strAvailableQty"+""+index).value;
		
	    var qty_base_value = document.getElementById("strAvailableQtyUnit"+""+index).value.split("^")[1];
       					
			var qty    = qtyObj;	
			var rate   = rateObj;
		
			var total = parseFloat("0.00");
				
					if(isNaN(rate) || rate=="") rate = "0";
					if(isNaN(qty)  || qty=="") qty = "0";
				    if(qty=='0')		
					{
					  qty_base_value = '0';	
					  total = parseFloat(qty * qty_base_value * rate);
					}
					else
					{
					  total = parseFloat(qty * qty_base_value * rate);
					} 											
			document.getElementById("strStockCost"+index).value =  roundValue(total, 2);
			document.getElementById("strCost"+index).value =  roundValue(total, 2);
			
				totalCost();
	return true;
}


/**
 * This Method is used for Avalaible Budget Pop-Up
 * Created By Amit Kumar 10-Aug-2011
 */


function avlBudgetDtl(obj) 
{

	parentPopUp = obj;

	var strBalQtyDetail = document.forms[0].strAvalaibleBudgetDtl.value;

	myArray = strBalQtyDetail.split("$$");

	var objVal1 = document.getElementById("1");

	if (myArray[0] != 'null' || myArray[0] != '') 
	{
		objVal1.innerHTML = myArray[0];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null') 
	{
		objVal2.innerHTML = myArray[1];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}

	display_popup_menu(parentPopUp, 'avalaibleBudgetDtlId', '300', '');

}

function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}



/**
 * Developer : Amit Kumar
 * Version : 1.0 
 * Date : 11/June/2009
 *  Module:MMS
 * Unit:Issue Desk Transaction
  *
 */
/* This function is Used to change color which we show in Properties file  */
function changeReOrderColor()
{
	if(document.forms[0].strBudgetFlg.value=='1')
	{
		document.getElementById("budgetIDOne").style.display="block";
		document.getElementById("budgetIDTwo").style.display="block";
	}
	else
	{
		document.getElementById("budgetIDOne").style.display="none";
		document.getElementById("budgetIDTwo").style.display="none";
	}
	var issueNo = document.forms[0].strIssueNo.value;
	if(issueNo="0")
	{
		var   colorOne = document.forms[0].strReOrderFlgColor.value;
		var    noOfRow = document.getElementsByName("reOrderFlag");
		var  budgetFlg = document.forms[0].strBudgetFlg.value; 
		document.getElementById("manFld").color = colorOne; 
		var length = noOfRow.length;
		for(var i=0;i<length;i++)
        {
        	
        	if(noOfRow[i].value=='0')
        	{
        		document.getElementById("td1"+i).style.backgroundColor = colorOne; 
        		document.getElementById("td2"+i).style.backgroundColor = colorOne;  
        		document.getElementById("td3"+i).style.backgroundColor = colorOne;  
        		document.getElementById("td4"+i).style.backgroundColor = colorOne;  
        		document.getElementById("td5"+i).style.backgroundColor = colorOne;  
        		document.getElementById("td6"+i).style.backgroundColor = colorOne;  
        		document.getElementById("td7"+i).style.backgroundColor = colorOne;   
        		if(budgetFlg=='1')
        		document.getElementById("td8"+i).style.backgroundColor = colorOne;   				
        		
        	}
        }
		
	}
	
	
}
// function to show report after save data

function getReport()
{

	var issueNo = document.forms[0].strIssueNo.value;
	var storeId =  document.forms[0].strStoreId.value;
	var IndentNo=document.forms[0].strIndentNo.value;
	var IndentDate=document.forms[0].strIndentDate.value;
	var strMode = "2"


	if(issueNo!="0")
	{
		//getIssueDtls('2', storeId, issueNo,IndentNo,IndentDate);
		
		    var itemStockObj = document.getElementById("issueDtlsDivId");

			if (itemStockObj.innerHTML == "") 
			{

				var hmode = "ISSUEDTLSINIT";
				var url = "IssueDeskTransCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
						+ "&strStoreId=" + storeId + "&strIssueNo=" + issueNo+"&IndentNo="+gblIndentNo+"&strIndentDate="+IndentDate;
				//	alert(url);	
				ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");

			} else {
				// set for 1024 * 760 screen don't change this
				popup('popUpDiv', '80', '60');
			}
	}
	document.forms[0].strIssueNo.value ="0";
}


function getNAVoucher() 
{ 	
    var fromStoreId = document.forms[0].strRaisingStoreId.value;
    var indentNo    = document.forms[0].strIndentNo.value;
    var toStoreId   = document.forms[0].strStoreId.value;

		//alert(document.forms[0].indentNo.value+"---"+document.forms[0].tmpIndentNo.value);
 
		if (parseInt(indentNo)>0 && indentNo !=null) 
		{

			var hmode = "INDENT_NA_CERTIFICATE";
			var url = "IndentTransADDCNT.cnt?hmode=" + hmode + "&strMode=1 &fromStoreId=" + fromStoreId + "&indentNo=" + indentNo+"&toStoreId="+toStoreId;
			
			ajaxFunction2(url, "2", "getIssueDtlsAjaxResponse");

		} 
	

}


/**
 * customized ajax response function.
 * @param res
 * @param mode
 * @return
 */
function getIssueDtlsAjaxResponse(res, mode) 
{

	//STOCKDTLSINIT
	if (mode == '1') 
	{
       // alert(res);
		var itemStockObj = document.getElementById("issueDtlsDivId");

		//itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;;
		
		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}
	if (mode == '2') 
	{
        //alert("Mode-2--"+res);
		var itemStockObj = document.getElementById("issueDtlsDivId");

		//itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;;
		
		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}

}


// function to save issue data
function validate1()
{
	var saveObj = document.getElementById("saveId");
	
		if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
		{
					//if(document.getElementsByName('strBSReqNo')[0].value == '0')
					//{
					var radios = document.forms[0].strBSIndent, i,flag='0',b='0';
					
						var chktrue='0',chkissue='0';
					
				    for (i=0; i<radios.length; i++)
				    {
				      if (radios[i].checked) 
				      {
				        flag = 1;
				        b=radios[i].value;
				        break;
				      }
				      else
				    	  flag = 0;
				    }
				  //  alert("flag "+flag);
				    if(flag == '0')
				    {
				    	alert("Raise LP Indent , select yes/no");
				    	return false;
				    }
				    else
				    {
				    	if(b=="1")
				    	{
				    	//	hisValidator.addValidation("strBSQuantity", "req", "LP Qty is a Mandatory Field" );
				    		for(i=0;i< document.getElementsByName("strBSQuantity").length;i++)
				    			if(document.getElementsByName("strBSQuantity")[i].value == "")
				    				document.getElementsByName("strBSQuantity")[i].value = "0";
				    		for(i=0;i< document.getElementsByName("strBSQuantity").length;i++)
				    			if(document.getElementsByName("strBSQuantity")[i].value > "0")
				    				chktrue='1';
				    		if(chktrue != '1')
				    		{
				    			alert("LP can't be raised with 0 qty")
				    			return false;
				    		}
				    	}
				    	if(b=='0')
				    	{
				    		for(i=0;i< document.getElementsByName("strBSQuantity").length;i++)
				    			document.getElementsByName("strBSQuantity")[i].value = "0";
				    		
				    		for (i=0;i<document.getElementsByName('strIssueQty').length;i++)
				    		{
				    			if(document.getElementsByName("strIssueQty")[i].value != '0')
				    				chkissue = '1';
				    			
				    			if(parseInt(document.getElementsByName("strIssueQty")[i].value) > parseInt(document.getElementsByName("strBalQty")[i].value.trim()))
				    			{
				    				alert("Issue Qty is greater than sanction qty");
				    				document.getElementsByName("strIssueQty")[i].value="";
				    				return false;
				    			}
				    			if(parseInt(document.getElementsByName("strIssueQty")[i].value) > parseInt(document.getElementsByName("strAvlQty")[i].value.split("@")[0]))
				    			{
				    				alert("Issue Qty is greater than available qty");
				    				document.getElementsByName("strIssueQty")[i].value="";
				    				return false;
				    			}
				    		}
				    		if(chkissue != '1')
				    		{
				    			
				    			alert("Atleast one item should be issued");
				    			document.getElementsByName("strIssueQty")[0].focus();
				    			getNAVoucher();
				    			//return false;
				    		}
				    	}
				    }
				//}
				   
				saveObj.style.display = "none"; 

		       var      retVal = true;
			   var    issueQty = document.getElementsByName("strIssueQty");
		       var issueUnitId = document.getElementsByName("strIssueUnitId");
		       var ItemRemarks = document.getElementsByName("strItemRemarks");
		       var      length = issueQty.length;
		       var       count = 0;
		     
		          for(var i=0;i<length;i++)
		          {
		          	if(issueQty[i].value!="" && issueQty[i].value!="0" )
		          	{
		          		count++;
		          		if(issueUnitId[i].value=="0")
		          		{
		          			alert("Please Select Issue Qty Unit");
		          			issueUnitId[i].focus();
		          			retVal = false;
		          		}
		          		//issueQty[i].disabled    = false;
		          		//issueUnitId[i].disabled = false;
		          		
		          	/*	if(ItemRemarks[i].value=="")
		          		{
		          			alert("Please Select Remarks");
		          			ItemRemarks[i].focus();
		          			retVal = false;
		          		}*/
		          	}
		          	else{
		          		issueQty[i].value = "0";
		          	}
		          	
		          }
		          if(count==0 && b=="0")
		          {
		          			alert("Please Issue At Least One Item");
		          			issueQty[0].focus();
		          			retVal = false;
		          }
           
		       
		  
       
	         if(retVal)
	         {
         	
         	
              var hisValidator = new HISValidator("issueDeskTransBean"); 
      		  hisValidator.addValidation("strReceivedComboBy","dontselect=0","Please Select a Value from Received By Combo" );
		      //hisValidator.addValidation("strReceivedBy", "req", "Name of the Receiver is a Mandatory Field");
		      hisValidator.addValidation("strRemarks","req","Remarks is a Mandatory Field" );
	          hisValidator.addValidation("strRemarks", "maxlen=150", "Remarks should have less than or equal to 150 Characters" );
              retVal = hisValidator.validate(); 
             }
		    else
		  	{
		  	    saveObj.style.display = '';
				retVal = false;
		  	}	 
          
          
          if(retVal)
          {
                         
				      		
				      		
				      		  var conf = confirm("You Are Going To Save Records");
			                  if(conf == true)
			                  {
			                       var conf1 = confirm("Are you sure !!!");
			                       if(conf1 == true)
			                       {
			                       	      for(var i=0;i<length;i++)
								          {								          	
								          		issueQty[i].disabled    = false;
								          		issueUnitId[i].disabled = false;							          	
								          }
			                       	
			 						    document.forms[0].hmode.value = "SAVE";
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

// function called on enter issue qty to check the validation of issue qty

function QtyValidation(index)
{
		if(document.getElementById("strIssueUnitId"+index).value!="0" && document.getElementById("strIssueQty"+index).value!="")
		{
			var issueQty     		= document.getElementById("strIssueQty"+index).value;
			var issueQtyUnit 		= document.getElementById("strIssueUnitId"+index).value;
			var temp                = issueQtyUnit.split("^");
			var issueQtyUnitBaseVal = temp[1];
			var isDecimalAllow = temp[2];
			
			if (issueQty.indexOf('.') > -1 && temp[2] == '0') 
			{
			
						alert("Issue Quantity must be an Integer ");
						document.getElementById('strIssueQty'+index).value = "";
						document.getElementById('strIssueUnitId'+index).value = "0"
						return false;
						
			}
			
			var issueQtyUnitVal = parseInt(issueQty,10)*parseFloat(issueQtyUnitBaseVal);
			var sancQtyBaseVal  = document.getElementById("strBalQtyBaseVal"+index).value;
			var avlQtyBaseVal   = document.getElementById("strAvlQtyBaseVal"+index).value;;
				//alert("sancQtyBaseVal-"+sancQtyBaseVal);
				//alert("issueQtyUnitVal-"+issueQtyUnitVal); 
				//alert("avlQtyBaseVal-"+avlQtyBaseVal); 
			
				if(parseFloat(avlQtyBaseVal)<issueQtyUnitVal)
				{
					alert("Issue Quantity cannot be greater than Available Quantity");
					//document.getElementById('strIssueUnitId'+index).value = "0";
					document.getElementById("strIssueQty"+index).value="";
					return false;
				}
				if(parseFloat(sancQtyBaseVal)<issueQtyUnitVal)
				{
					alert("Issue Quantity cannot be greater than Sanction Quantity");
					//document.getElementById('strIssueUnitId'+index).value = "0";
					document.getElementById("strIssueQty"+index).value="";
					return false;
				}
			
		}
}

/**
 	 * cancelStockDetails 
 	 */
 	 /**
 	 * cancelStockDetails 
 	 */
 	 function cancelStockDetails(obj, index) 
 	 {
 	 	
 	 	var conf = confirm("Are you Sure, The Data(s) will be Reset");
 	 	
 	 	if(conf)
 	 	{ 	 			   			 
 	 			  var index   = document.getElementById("strIndex").value;
 	 			  var chkObj  = document.getElementsByName("strAvailableQty");
                  var chkObj1 = document.getElementsByName("strAvailableQtyUnit");
	              var     len = chkObj.length;
	              
					for(i=0;i<len;i++)
					{			
									
						  	 chkObj[i].disabled = true;	
						  	chkObj1[i].disabled = true;	
						  	 chkObj[i].value    = "";	
						  						
					}
					document.getElementById("strIssueQty"+index).disabled = false;
					document.getElementById("strIssueUnitId"+index).disabled = false;
					//document.getElementById("strIssueQty"+index).value  = '';
					//document.getElementById("strFinalCost"+index).value    = '0.00';
					//document.getElementById("finalCostDivId"+index).value  = '0.00';
					document.getElementById("strItemRemarks"+index).value  = '';		
					document.getElementById(gblUserHiddenFieldDivId).value = "";
					 
					if(document.forms[0].strBudgetFlg.value=='1')
			 		{
			        /* This Method is Used to Calculate Total Approx Issue Cost(Rs.)   */
			           totalIssueCost();
			 		}  	
				   
 	 			 // document.getElementsByName("finalCostDivId")[0].value = '0.00';
 	 			//document.getElementsByName("strIssueQty")[index].disabled=false;	
 	 			//document.getElementsByName("strIssueUnitId")[index].disabled=false;	
 	 			hide_popup('popUpDiv');
 	 		
 	 	}
 	 	else
 	 	{
 	 		
 	 		//hide_popup('popUpDiv');
 	 		
 	 	}
 	 	
 	 }



 	function getVoucher() 
 	{    
 		//alert('1');
 	   var strChk            = document.forms[0].strChk.value;  
 	   var strStoreId        = document.forms[0].strStoreId.value;
 	   var strReqTypeId      = document.getElementsByName("combo")[1].value;
 	   var strItemCategoryNo = document.forms[0].strItemCategoryNo.value;
 		 
 	   var mode="BEFOREISSUEPRINT";
 	   var url="IssueDeskTransCNT.cnt?hmode="+mode+"&strChk="+ strChk+"&strStoreId="+strStoreId+"&strReqTypeId="+strReqTypeId+"&strItemCategoryNo="+strItemCategoryNo;
 	   ajaxFunction(url,"5");
 		 
 	}

 	function callStockDetails(obj,index)
 	{
 		
 		//alert("index----"+index);
 		
 		if(document.getElementById("strIssueQty"+index).value=="")
 		{
 			alert("Please Enter Issue Quantity One");
 			document.getElementById("strIssueQty"+index).focus();		
 		}
 		else if(document.getElementById("strIssueUnitId"+index).value=="0")
 		{
 			alert("Please Select Issue Quantity Unit");
 			document.getElementById("strIssueUnitId"+index).focus();		
 		}
 		else
 		{
 			if(document.getElementById("strAvlQtyForChk"+index).value != "0")
 			{
 				
 				
 					var               hiddenVal =  document.getElementById("strItemDetailsChk"+index).value;
 					//alert("hiddenVal-"+hiddenVal); // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
 														// ^strItemCategory^strRaisingStoreId
 					var             	   temp = hiddenVal.split("^");
 					var         	    strMode = "1^"+document.forms[0].strBudgetFlg.value+"^"+index;
 					//alert("strMode----"+"1^"+document.forms[0].strBudgetFlg.value+"^"+index);
 					var     	 strStockStatus = "";
 					var      	   strGenItemId = temp[0];
 					var       	      strItemId = temp[1];				
 					var             strIssueQty = document.getElementById("strIssueQty"+index).value;
 					var       strIssueQtyUnitId = document.getElementById("strIssueUnitId"+index).value;
 					var              strUnitObj = document.getElementById("strIssueUnitId"+index);
 					var        	    strUnitName = strUnitObj[strUnitObj.selectedIndex].text;				 
 					var               	  temp2 = strIssueQtyUnitId.split("^");
 					var  strIssueQtyUnitBaseVal = parseFloat(temp2[1]);				
 					var              strCatCode = temp[6];
 					var                 storeId = document.forms[0].strStoreId.value;
 					var         strReservedFlag = temp[2];
 					var strUserHiddenFieldDivId = "stockDtlsId"+index;
 					document.getElementById("strIssueQty"+index).disabled=true;
 					document.getElementById("strIssueUnitId"+index).disabled=true;			
 					
 					gblMode 					= strMode;
 					gblStockStatus 				= strStockStatus;
 					gblGenItemId 				= strGenItemId;
 					gblItemId 					= strItemId;
 					gblIssueQty 				= strIssueQty;
 					gblIssueQtyInBase 			= strIssueQtyUnitBaseVal; 
 					gblStoreId 					= storeId;
 					gblCatCode 					= strCatCode;
 					gblReservedFlag			    = strReservedFlag;	
 					gblUserHiddenFieldDivId     = strUserHiddenFieldDivId;
 					
 					// div id is a hardcoded value.
 							   var itemStockObj = document.getElementById("stockDtlsDivId");
 							   var        hmode = "STOCKDTLSINIT";
 								var      hidVal = document.getElementById("stockDtlsId"+index).value.replace(/#/g , "@");
 								var         url = "IssueDeskTransCNT.cnt?hmode=" + hmode + 
 								                  "&strMode="+strMode+
 								                  "&strStockStatus="+strStockStatus +
 								                  "&strGenItemId="+strGenItemId+
 								                  "&strItemId="+strItemId+
 												  "&strIssueQty="+strIssueQty+
 												  "&strIssueQtyInBase="+parseFloat(temp2[1])+
 												  "&strStoreId="+storeId+
 												  "&strCatCode="+strCatCode+
 												  "&strReservedFlag="+strReservedFlag+
 												  "&strHiddenFieldVal="+hidVal+
 												  "&strUnitName="+strUnitName;
 								
 								ajaxFunction(url,"3");
 			}
 			else
 			{
 				alert("No Batches to be Select!!");
 				return false;
 			}					
 							
 		}
 				
 	}
/**
 *  Function called by ajaxFunction 
 
 *  With mode=1 , it will call the GETPOPUP method of CNT 
	which will use procedure to get the output
	and set the flag value as concatenated output string with corresponding index.
	In response it will get 3 things 	
	* temp[0]=whole pop up window
	* temp[1]=concatenated string of all data values
	* temp[2]=index of the corresponding link	 
	
 *	With mode=1 ,it will call the GETPOPUPDATA method of CNT 
	which will use value of request parameter(flag) to get the output 
	
 */
function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
      } 
      else
       {
 
	 	if(mode==1)
		 {
	 	    var obj=document.getElementById("popup");
	 	   // alert("res-"+res);
           	temp=res.split("@");
	 		i=temp[2];
	 		//alert("i-"+i);
	 		document.getElementById('flag'+indexglobal).value=temp[1];
	 		obj.innerHTML  = temp[0];
			display_popup_menu(parentPopup,'popup','',''); 
     
		}
	
		if(mode==2)	
		{
			var obj=document.getElementById("popup");
       	 	obj.innerHTML  = res;
			display_popup_menu(parentPopup,'popup','',''); 
	
		}
		if(mode=="3")	
		{
			var itemStockObj = document.getElementById("stockDtlsDivId");
	
			//alert(res);
			
			itemStockObj.innerHTML = res;
	
			popup('popUpDiv', '150', '60');
		}
		
		if(mode=="4")	
		{
			//$('html,body').scrollTop(0);
			//alert(res);
			var itemStockObj = document.getElementById("stockDtlsDivId");	
			itemStockObj.innerHTML = res;	
			popup('popUpDiv', '100', '60');
		}
		
		 if(mode=="5")
	     {
	          
				var itemStockObj = document.getElementById("issueDtlsPrintDivId");
				itemStockObj.innerHTML = res;
				
				popup('popUpDivPrint', '60', '80');	
				
		}
	}
}


/**
 	 * validatePhyStockPopUp
 	  
 	 */
 	 function validatePhyStockPopUp() {
 	 	
 	 	var chkObj = document.getElementsByName("strStockDtlsChk");
 		var count = parseInt("0");
 		var qtyValue = parseFloat("0");
 		var chkValue = "";
 		
 		for ( var i = 0; i < chkObj.length; i++) {
			
 			if(chkObj[i].checked){
 				
 				count = count + 1;
 				
 				var qtyObj  = document.getElementById("strAvailableQty"+(i+1));
 				var unitObj = document.getElementById("strAvailableQtyUnit"+(i+1));
 				
 				if(qtyObj.value.length < 1){
 					
 					alert("Please Enter the Quantity");
 					qtyObj.focus();
 					
 					return false;
 				}else{
 					
 					
 					if(count == 1){
 						
 						chkValue = chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value;
 						
 					}else{
 						
 						chkValue = chkValue +"#" + chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value;
 						
 					}
 					
 					var unitBaseVal = unitObj.value.split('^')[1];
 					
 					qtyValue = qtyValue + (parseFloat(qtyObj.value) * parseFloat(unitBaseVal))
 					
 				}
 				
 				
 				
 			}
		}
 		
 	 		
		if(count == 0){
 			 			
 			alert("Please Select Atleast One Record");
 			return false;
 		}
 		document.getElementById(gblUserHiddenFieldDivId).value = chkValue;
 		
 		
 		hide_popup('popUpDiv');
 		
 		
 		
 		
 		if (gblUserDefinedFuncName != "" && gblUserDefinedFuncName.length > 0) {
		if (gblUserDefinedArg != "" && gblUserDefinedArg.length > 0) // with user
		// argument
		{
			eval(gblUserDefinedFuncName + "('" + gblUserDefinedArg + "')");
		} else // without user argument
		{
			eval(gblUserDefinedFuncName);
		}
	}
 		
 		
 		return true;
 	 	
 	 	
}
function checkStockDetails(obj, index) 
{
	
	if(obj.checked)
	{
		
		document.getElementById("strAvailableQty"+index).disabled = false;
		//document.getElementById("strAvailableQtyUnit"+index).disabled = false;
		
	}
	else
	{
		
		//document.getElementById("strAvailableQtyUnit"+index).disabled = false;		
		document.getElementById("strAvailableQty"+index).value = "0";
		document.getElementById("strAvailableQty"+index).disabled = true;	
		//document.getElementById("strAvailableQtyUnit"+index).selectedIndex = 0;
		document.getElementById("strAvailableQtyUnit"+index).disabled = true;  
        document.getElementById("strStockCost"+index).disabled = false;
		document.getElementById("strCost"+index).disabled = false;    
		document.getElementById("strStockCost"+index).value = "0.00";
		document.getElementById("strCost"+index).value = "0.00";		
		document.getElementById("strStockCost"+index).disabled = true;
		document.getElementById("strCost"+index).disabled = true;
		totalCost();
		
		
	}
	
}



/**
 * checkAvailQty - Qty validation.
 * @param {String} unitName
 * @param {String} qtyName  
 */
function checkAvailQty(index,  qtyName, unitName) 
{
		var unitObj = document.getElementById(unitName+""+index);
		var qtyObj = document.getElementById(qtyName+""+index);
        
		
			var qtyDeceimal = qtyObj.value;

			var unitVal = unitObj.value.split('^')[2];

			if (qtyDeceimal.indexOf('.') > -1 && unitVal == '0') 
			{
				alert("Qty must be an Integer ");
				qtyObj.value = '0';
   			    return false;
			}
		
	return true;
}

// function called on click of + button to show indent details
function clickPlus()
{
document.getElementById("MinusDivId").style.display="block";
document.getElementById("ReqDtlsDiv").style.display="block";
document.getElementById("PlusDivId").style.display="none";

}   

// function called on click of - button to hide indent details
function clickMinus()
{

document.getElementById("MinusDivId").style.display="none";
document.getElementById("ReqDtlsDiv").style.display="none";
document.getElementById("PlusDivId").style.display="block";

}   
  
  // function called on view button of list page
function callViewCnt(form1,mode){
	cmbVal="";
	with(form1){
		if(mode=="VIEW" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select A Store");
			return;
		}
		if( mode == "VIEW" && document.forms[0].combo[0].value!="0" ){
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
			//alert(document.forms[0].combo[1].value);
			if(document.forms[0].combo[1].value=="1" )
			{
			   add("VIEW1");
			}
			else
			{
			   add("VIEW2");  // In Case of Issued
			}
			
		}
		}
 }
 
// call on cancel button 
function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}


// call on cancel button 
function cancel(){
	document.forms[0].hmode.value="CANCELTODESK";
	document.forms[0].submit();
}

// function called on issue button of list page
function validateIssue(form1,mode){
	cmbVal="";
	var retVal=true;
	with(form1){
		if(mode=="ISSUE" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select A Store");
			return;
		}
		if( mode == "ISSUE" && document.forms[0].combo[0].value!="0" ){
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
			
			
		var check=document.getElementsByName("chk");
		
		
		for(i=0;i<check.length;i++)
		{
			/*
			if(check[i].checked==true)
			{
			
				var temp = (check[i].value).split('@');
				var urgentCount = temp[3];
				var temp2 = temp[4].split('$');
				var urgentFlag = temp2[0];
				if(parseInt(urgentCount) > 0 && urgentFlag=='0')
				{
					retVal = confirm("First You Should have Selected An Urgent Request ,\n But You have Selected Normal Request. \n Do You Want To Continue?");
				}
				break;
			}*/
		}
 		
		
		if(retVal){
			add(mode);
			}
			else{
			return false;
			}
		}
	}
}

/**
 * issueDeskButtonStatus
 * @param {Object} form1 
 */
 function issueDeskButtonStatus(these) {
 	
 		
 		var checkCount=0;
		var check=document.getElementsByName("chk");
		
		for(i=0;i<check.length;i++){
		
			if(check[i].checked==true)
			checkCount++;
		}
 		
 	
 	if(checkCount == 1){ 	 		
 		if(document.forms[0].combo[1].value == "1"){
 			
 			enableButton("Issue");
 			enableButton("View");
			 			
 		}else{
 			
 			disableButton("Issue");
 			enableButton("View");
 		}
 		 		
 	}else{
 		
 		disableButton("Issue");
 		disableButton("View");
 	}
 }
 
 
/**
 *  global variable 
 */
var parentPopup="";
var indexglobal="";

/**
 *  function to call AJAX function to show the pop up window 
 * if any link is clicked on first time it will pass mode=1 
 	and GETPOPUP method of CNT as url with ITEM ID 
 * else(if any link is clicked again) it will pass mode=2 
 	and GETPOPUPDATA method of CNT as url with corresponding flag value i.e
 	concatenated string of pop up data
 */
	function showPopUp(obj,i){	
	
	indexglobal=i;

		parentPopup=obj;
	//if(document.getElementById('flag'+i).value=="0"){	

//	alert("showPopUp flag"+document.getElementsByName("flag")[i].value);

		 var mode = "GETPOPUP";
		 var url = "IssueDeskTransCNT.cnt?hmode="+mode+"&hiddenVal="+document.getElementById('strItemDetailsChk'+i).value+"&index="+i+"&storeId="+document.forms[0].strStoreId.value;
//		 alert("url-"+url);
		 ajaxFunction(url,"1");
	//}
	/*else{	
//	alert("showPopUp flag"+document.getElementById('flag'+i).value);
		var hidVal = document.getElementById('flag'+i).value;
	    var mode = "GETPOPUPDATA";
		var url = "IssueDeskTransCNT.cnt?hmode="+mode+"&popupData="+hidVal;
		 
		ajaxFunction(url,"2");
	}*/
}



// called on select a checkbox (NOT USED AFTER 12-JUNE-09)
function ClickCheckBox(obj,i)
{
if(document.getElementById('strIssueQty'+i).disabled==true)
{
document.getElementById('strIssueQty'+i).disabled=false;
document.getElementById('strIssueUnitId'+i).disabled=false;
}
else{

document.getElementById('strIssueQty'+i).disabled=true;
document.getElementById('strIssueUnitId'+i).disabled=true;

}
}

function hideIssuePopup(){
	
	document.getElementById("issueDtlsDivId").innerHTML = "";
		
		hide_popup('popUpDiv');
		
		 document.forms[0].hmode.value = "LIST";
         document.forms[0].submit();
	
}


function clearPage()
{
	
	var lengthOfDrugList = document.getElementsByName("strIssueQty").length;
	for(var i=0;i<lengthOfDrugList;i++)
	{
		document.getElementsByName("strIssueQty")[i].disabled=false;
		document.getElementsByName("strIssueUnitId")[i].disabled=false;
	}
	
}

//function called on click of # to view stock details popup
function callStockDetails(obj,index)
{
	if(document.getElementById("strIssueQty"+index).value=="")
	{
		alert("Please Enter Issue Quantity Two !!");
		document.getElementById("strIssueQty"+index).focus();		
	}

	else
	{
		if(document.getElementById("strAvlQtyForChk"+index).value != "0")
		{
			var               hiddenVal =  document.getElementById("strItemDetailsChk"+index).value;
			//alert("hiddenVal-"+hiddenVal); // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
			// ^strItemCategory^strRaisingStoreId
			//alert("index----"+index);
			
			var             	   temp = hiddenVal.split("^");
			var         	    strMode = "1^"+document.forms[0].strBudgetFlg.value+"^"+index;
			//alert("strMode----"+strMode);
			var     	 strStockStatus = "10";
			var      	   strGenItemId = temp[0];
			var       	      strItemId = temp[1];				
			var             strIssueQty = document.getElementById("strIssueQty"+index).value;
			var       strIssueQtyUnitId = document.getElementById("strIssueUnitId"+index).value;
			var        	    strUnitName = "No.";				 
			var               	  temp2 = strIssueQtyUnitId.split("^");
			var  strIssueQtyUnitBaseVal = parseFloat(temp2[1]);				
			var              strCatCode = temp[6];
			var                 storeId = document.forms[0].strStoreId.value;
			var         strReservedFlag = temp[2];
			var strUserHiddenFieldDivId = "stockDtlsId"+index;
			var     strUserDrugDtlDivId = "issueDrugDtl"+index;
			var     strUserExpDtlDivId = "expDrugDtl"+index;

			var   strUserDrugExpRemarks = "strItemRemarks"+index; 	

			//document.getElementById("strIssueQty"+index).readOnly = true;
			//document.getElementById("strIssueUnitId"+index).readOnly = true;			
			document.getElementById("issueDrugDtl"+index).innerHTML="";
			document.getElementById("expDrugDtl"+index).innerHTML="";


			gblMode 					= strMode;
			gblStockStatus 				= strStockStatus;
			gblGenItemId 				= strGenItemId;
			gblItemId 					= strItemId;
			gblIssueQty 				= strIssueQty;
			gblIssueQtyInBase 			= strIssueQtyUnitBaseVal; 
			gblStoreId 					= storeId;
			gblCatCode 					= strCatCode;
			gblReservedFlag			    = strReservedFlag;	
			gblUserHiddenFieldDivId     = strUserHiddenFieldDivId;
			gblUserDrugDtlDivId         = strUserDrugDtlDivId;
			gblUserExpDtlDivId          = strUserExpDtlDivId;
			gblUserDrugExpDrugRemarksId = strUserDrugExpRemarks;

			var        hmode = "STOCKDTLSINIT";
			var      hidVal = document.getElementById("stockDtlsId"+index).value.replace(/#/g , "@");
			var         url = "IssueDeskTransCNT.cnt?hmode=" + hmode + "&strMode=" + strMode+"&strStockStatus="+
			strStockStatus +"&strGenItemId="+strGenItemId+"&strItemId="+strItemId+
			"&strIssueQty="+strIssueQty+"&strIssueQtyInBase="+parseFloat(temp2[1])+
			"&strStoreId="+storeId+"&strCatCode="+strCatCode+"&strReservedFlag="+strReservedFlag+"&strHiddenFieldVal="+hidVal+"&strUnitName="+strUnitName;
			//getStockDtls(strMode, strStockStatus, strGenItemId, strItemId, strIssueQty, strIssueQtyUnitBaseVal,storeId, strCatCode, strReservedFlag, strUnitName, strUserHiddenFieldDivId);
			//alert(url);
			
			ajaxFunction(url,"4");
		}
		else
		{
			alert("No Batches to be Select!!");
			return false;
		}					

	}
}
	
	
	function validatePopUp() 
	{

		var chkObj = document.getElementsByName("strStockDtlsChk");
		var count = parseInt("0");
		var qtyValue = parseFloat("0");
		var chkValue = "";
		var costObj   ="";
		var totalCost ="";
		var index = document.forms[0].strIndex.value;
		for ( var i = 0; i < chkObj.length; i++)
		{

			if(chkObj[i].checked)
			{
				document.getElementById("strAvailableQtyUnit"+(i+1)).disabled= false;
				count = count + 1;

				var qtyObj    = document.getElementById("strAvailableQty"+(i+1));
				var unitObj   = document.getElementById("strAvailableQtyUnit"+(i+1));
				// Here we Check Condition Either Budget Flag is On or Off
				if(document.forms[0].strBudgetFlg.value=='1')
				{
					costObj   = document.getElementById("strCost"+(i+1)).value;
					totalCost = document.forms[0].strApproxAmt.value;

					document.getElementById("finalCostDivId"+index).disabled  = false;	

					document.getElementById("finalCostDivId"+index).value  = 	totalCost;	
					document.getElementById("strFinalCost"+index).value  = 	totalCost;	
					document.getElementById("finalCostDivId"+index).disabled  = true;	


				}
				else
				{
					costObj   = "0";
					totalCost = "0";
					
				}

				if(qtyObj.value.length < 1)
				{

					alert("Please Enter the Quantity");
					qtyObj.focus();
					if(document.forms[0].strBudgetFlg.value=='1')
					{
						document.getElementById("finalCostDivId"+index).disabled  = false;
						document.getElementById("finalCostDivId"+index).value  ='0.00';
						document.getElementById("strFinalCost"+index).value    = '0.00';	
						document.getElementById("finalCostDivId"+index).disabled  = true;
					} 

					return false;
				}
				else
				{
					/*
					 * 11. Store id,        1
					 * 12. Generic Item Id  2
					 * 13. Item Id          3
					 * 15. Batch No.        4
					 * 14. Stock Status Code 5 
					 * 18. Expiry Date       6 
					 * 19. Manufacture Date  7
					 * 20. Inhand Qty        8
					 * 21. Inhand Qty UnitId 9
					 * 23. Rate             10
					 * 24. Rate Unit Id     11
					 * 38. Sale Price       12
					 * 39. Sale Price Unit Id,13
					 * 45. Purchase Rate      14 
					 * 46. Expiry Remaining Day(s) 15 
					 * 5 . Mfg Name                16
					 * 45. Rate With Unit Name     17
					 * 47. Exp Date in Jun/2013 Format 18
					 *     Issue Qty   19
					 *     Issue Qty Unit[630001^0^1] 20 ^ 21 ^ 22
					 *     Batch Cost    23
					 *     Total COst    24 
					 */

					if(count == 1)
					{

						chkValue = chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value+"^"+costObj+"^"+totalCost+"^"+chkObj[i].value.split('^')[5];
						

					}
					else
					{

						chkValue = chkValue +"#" + chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value+"^"+costObj+"^"+totalCost+"^"+chkObj[i].value.split('^')[5];
						

					}

					var unitBaseVal = unitObj.value.split('^')[1];

					qtyValue = qtyValue + (parseFloat(qtyObj.value) * parseFloat(unitBaseVal));

				}

			}
		}


		if(count > 0)
		{

			var issueQty 	 = parseFloat(document.forms[0].strItemIssueQty.value); 			
			//var issueBaseVal = parseFloat(document.forms[0].strItemIssueQtyBaseVal.value);

			//var issueVal = issueQty * issueBaseVal;
			var issueVal = issueQty ;


			if(qtyValue != issueVal)
			{
				// Here we Check Condition Either Budget Flag is On or Off
				if(document.forms[0].strBudgetFlg.value=='1')
				{
					var costObj = document.getElementsByName("strCost");
					if (costObj.length > 0) 
					{

						for ( var i = 1; i <costObj.length; i++)
						{		        					
							document.getElementById("strCost"+i).value="0.00";
							document.getElementById("strStockCost"+i).value="0.00";
							document.getElementById("strTotalCostDivId").innerHTML = "0.00";
							document.getElementById("strAvailableQty"+i).value="0";


						}

					}
					document.getElementById("finalCostDivId"+index).disabled  = false;
					document.getElementById("finalCostDivId"+index).value  ='0.00';	
					document.getElementById("strFinalCost"+index).value    = '0.00';
					document.getElementById("finalCostDivId"+index).disabled  = true;
					if(document.forms[0].strBudgetFlg.value=='1')
			 		{
			        /* This Method is Used to Calculate Total Approx Issue Cost(Rs.)   */
			           totalIssueCost();
			 		}  
				}



				alert("Quantity Total should be Equal to Issue Quantity");

				document.getElementById("strTotalCostDivId").value = '0.00';

				return false;
			}

		}
		else
		{

			alert("Please Select Atleast One Record");
			if(document.forms[0].strBudgetFlg.value=='1')
			{
				document.getElementById("finalCostDivId"+index).value  ='0.00';	
				document.getElementById("strFinalCost"+index).value    = '0.00';
			}		
			return false;
		}
		if(document.forms[0].strBudgetFlg.value=='1')
		{
			/* This Method is Used to Calculate Total Approx Issue Cost(Rs.)   */
			totalIssueCost();
		}  
		batchString();
		
		document.getElementById(gblUserHiddenFieldDivId).value = chkValue;
		
		

		hide_popup('popUpDiv');

		document.getElementById(gblUserHiddenFieldDivId).focus();
		return true;

}

function batchString()
{
	
	//alert("hii");
	var costObj  = document.getElementsByName("strAvailableQty");		
	var batchString = "";
	var expString = "";		
	var j=parseInt("0");

	if (costObj.length > 0) 
	{		        
		for ( var i = 0; i < costObj.length; i++)
		{					
			if(parseInt(costObj[i].value) > 0)
			{

				if(j==0)
				{
					batchString = "[ "+document.getElementsByName("strDrugDtls")[i].value+" ]";
					expString   = "[ "+document.getElementsByName("strExpDtls")[i].value+" ]";

				}
				else
				{
					batchString = batchString +"\n[ "+ document.getElementsByName("strDrugDtls")[i].value+" ]";
					expString   = expString   +"\n[ "+ document.getElementsByName("strExpDtls")[i].value+" ]";
				}
				j++;

			}	
			//costObj[i].disabled = true;		  
		}

	}
	document.getElementById(gblUserDrugDtlDivId).innerHTML=batchString;
	document.getElementById(gblUserExpDtlDivId).innerHTML=expString;



}
