function openDiv()
{
	//if(document.getElementsByName("strRaisingReqTypeId")[0].value=="13" || document.getElementsByName("strRaisingReqTypeId")[0].value=="12"){
			document.getElementById("patientDtlId").style.display="block";
			for(var i=0;i< document.getElementsByName("itmnotissued").length;i++)
			{
				if(document.getElementsByName("itmnotissued")[i].value != '')
					alert(document.getElementsByName("itmnotissued")[i].value);
			}
			
	//}
}
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}

function openSpecification(obj,index)
{
	   
       
        
        var strItemDetail = document.getElementById("strItemDtl"+index).value;     
      
       
        myArray = strItemDetail.split("@");
        
        document.getElementById("popUpItemId").innerHTML="Balance Qty. Details";
        //alert("myArray--size"+myArray.length);
       
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[0]+" "+myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2]+" "+myArray[1];; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        display_popup_menu(obj,'itemDtlId','300','');
        	
	
}
function cancelToDesk()
{
	document.forms[0].hmode.value="RETURNTOMAINDESK";
	document.forms[0].submit();
}
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}

function chkradio(obj)
{
	var i;
	if(obj.value == '1')
	{	for(i=0;i< document.getElementsByName("strBSQuantity").length;i++)
			if(parseInt(document.getElementsByName("strBSQuantity")[i].value) == '')
				document.getElementsByName("strBSQuantity")[i].value = '0'; 
			else
				document.getElementsByName("strBSQuantity")[0].focus();
		
		var avlQty,LpQty,sancQty;
		for (i=0;i<document.getElementsByName('strIssueQuantity').length;i++)
		{
			avlQty=parseInt(document.getElementsByName("strItemParamValue")[i].value.split("@")[4]);
			sancQty=parseInt(document.getElementsByName("strItemParamValue")[i].value.split("@")[2]);
			LpQty= parseInt(document.getElementsByName("strBSQuantity")[i].value);
			if(avlQty > sancQty && LpQty > 0)
			{
				confirm("Selected Item is available, still want to raise LP ?");					
				document.getElementsByName("strBSQuantity")[i].focus();
				return false;
			}
		}
	}
	else
		for(i=0;i< document.getElementsByName("strBSQuantity").length;i++)
			document.getElementsByName("strBSQuantity")[i].value = '0';
}

function chkItems(obj)
{
	if(obj.value == '1')
	{
			if(document.forms[0].strItemCategNo.value == '10')
			{
				alert("Utility certificate can only be generated for items");
				document.getElementsByName("strUCReq").value="0";
				document.getElementById("UC2").checked = true;
				return false;
			}
	}
}
function SAVE(){
	var hisValidator = new HISValidator("lpIssueDeskTransBean");
	for (i=0;i<document.getElementsByName('strIssueQuantity').length;i++)
	{
		document.getElementsByName("strIssueQuantity")[i].disabled=false;
		if(document.getElementsByName("strIssueQuantity")[i].value == '')
			document.getElementsByName("strIssueQuantity")[i].value = '0';
		if(document.getElementsByName("strIssueQuantity")[i].value == '0')
			document.getElementsByName("strIssueQuantity")[i].disabled=true;
	    var   avlQty     = document.getElementsByName("strItemParamValue")[i].value.split("@")[4];
		if(parseInt(avlQty,10) < parseInt(document.getElementsByName("strIssueQuantity")[i].value,10) )
		{
			alert("Issue qty can't be greater than avl qty!!!");
			document.getElementsByName("strIssueQuantity")[i].value = '';
			return false;
		}
		
	}
	//alert(document.forms[0].strAdmissionDtlHidVal.value.split("^")[9]);
	//alert(document.forms[0].strBillPaidCat.value);
	if(document.forms[0].strBillPaidCat.value == document.forms[0].strAdmissionDtlHidVal.value.split("^")[9])
		alert("Patient is from paying category!!!");
	//return false;
	//alert(document.getElementsByName('strBSReqNo')[0].value);
	if(document.getElementsByName('strBSReqNo')[0].value == '0')
	{
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
    		
    		for (i=0;i<document.getElementsByName('strIssueQuantity').length;i++)
    		{
    			if(document.getElementsByName("strIssueQuantity")[i].value != '0')
    				chkissue = '1';
    		}
    		if(chkissue != '1')
    		{
    			alert("Atleast one of issue qty should be greater than 0");
    			document.getElementsByName("strIssueQuantity")[0].focus();
    			return false;
    		}
    	}
    }
}
	if(document.getElementsByName("strPatientDtlHidVal")[0].value.split("^")[11] == '1' )
	{
		  alert("Issue can't be processed for a dead patient");
		  return false;
	}
	
	
	if(!document.forms[0].strItemParamValue){
		alert("No item to issue");
		return false;
	}
	//alert(document.forms[0].strBillingInt.value);
	//alert(document.forms[0].strPatAccountNo.value);
	if(document.forms[0].strBillingInt.value == "1")
	{
		if(document.forms[0].strPatAccountNo.value == "null" || document.forms[0].strPatAccountNo.value == "")
		{
			alert("Patient's Billing Account doesn't exist.So, issue can't be processed");
			return false;
		}
	}
	
	//hisValidator.addValidation("strIssueQuantity", "req", "Issue qty is a Mandatory Field" );
	//hisValidator.addValidation("strReceivedby", "req", "Recieved By  is a Mandatory Field" );
	for (i=0;i<document.getElementsByName('strIssueQuantity').length;i++)
	{
		if(document.getElementsByName("strIssueQuantity")[i].value == '')
			document.getElementsByName("strIssueQuantity")[i].value = '0';
	}
	var totamt=0.00;
	for (i=0;i<document.getElementsByName('strIssueQuantity').length;i++)
	{
			if(document.getElementsByName("strIssueQuantity")[i].value == '')
				{
				document.getElementsByName("strIssueQuantity")[i].value = '0';
				}
			var qty=document.getElementsByName("strIssueQuantity")[i].value;
			var temp=document.getElementsByName("strItemParamValue")[i].value;
			mrp=temp.split("@")[6];
			totamt=totamt+ (qty*mrp);
	}
	//
	
	var accBal=document.forms[0].strBillingHiddenValue.value;
	var r=parseInt(((accBal.split('^')[1]))-totamt.toFixed(2));
	var creditAmt=parseInt(accBal.split('^')[2]) ;
	var creditflag=parseInt(accBal.split('^')[3]) ;
	//alert(accBal);
	//alert(totamt);
	//alert(r);
	//alert(creditAmt);
	
	//if(creditAmt !=0)
	if(creditflag>0)
	{
		//alert(parseInt(r+creditAmt));
		if(parseInt(r-creditAmt) < 0)
		{
				alert('Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!');
				return false;
		}
	}
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();	
	
	if(retVal)
	{
		      var conf = confirm("You Are Going To Save Records");
              if(conf == true)
              {
                   var conf1 = confirm("Are you sure !!!");
                   if(conf1 == true)
                   {		
                	   for (i=0;i<document.getElementsByName('strIssueQuantity').length;i++)
                		{
                		   document.getElementsByName("strIssueQuantity")[i].disabled=false;
                		}
						  document.forms[0].hmode.value="INSERT";						  
					      document.forms[0].submit();
                   }
                  else
                   {
                     return false;
                   }
               }
              else
               {
                     return false;
               }     
		
	}
}

function QtyValidation(index)
{
//	alert("1");
		if(document.getElementById("strIssueQuantity"+index).value!="")
		{
			    var issueQty     = document.getElementById("strIssueQuantity"+index).value;
			    var   avlQty     = document.getElementById("strItemParamValue"+index).value.split("@")[4];
			    var bsQty     = document.getElementById("strBSQuantity"+index).value;
			    //var prescQty     = document.getElementById("strPrescQty"+index).value;
			  // alert("issueQty"+issueQty);
			   // alert("avlQty"+avlQty);
			    var ln = document.getElementsByName("strItemParamValue").length;
			   // alert(ln);
			   // if(parseInt(avlQty) <= 0 && parseInt(ln) <= 1)
			    //	{
			    //		alert("Available Qty is 0, issue can't be processed");
			    //		return false;			    		
			   // 	}
				if(parseInt(avlQty,10)<parseInt(issueQty,10))
				{
					
					alert("Issue Quantity cannot be greater than Avaliable Quantity");	
					document.getElementById("strIssueQuantity"+index).value="";
					return false;
					
					var idx = 1;
					
					var t=(document.getElementById("brandHiddenVal"+index+""+idx).value).split("^");
					//document.getElementById("itmNm"+i).innerHTML = t[3];
					//document.getElementById("availQty"+i).innerHTML = t[2];
					var t1 = (document.getElementById("strItemParamValue"+index).value).split("@");
					t1[1]=t[1];
					t1[4]= t[2];
					t1[5]= t[4];
					t1[6]= t[5];
					document.getElementById("strItemParamValue"+index).value = t1[0]+"@"+t1[1]+"@"+t1[2]+"@"+t1[3]+"@"+t1[4]+"@"+t1[5]+"@"+t1[6];
					if(parseInt(t1[4],10) < parseInt(issueQty,10))
					{
						alert("Issue Quantity cannot be greater than Avaliable Quantity");	
						document.getElementById("strIssueQuantity"+index).value="";
						return false;
					}
					
				}
				
				if(parseInt(document.getElementById("strItemParamValue"+index).value.split("@")[2])<parseInt(issueQty,10))
				{
					alert("Issue Quantity cannot be greater than Sanctioned Quantity");					
					document.getElementById("strIssueQuantity"+index).value="";
					return false;
				}
				
				if(parseInt(issueQty,10)<=0 && parseInt(avlQty,10)>0 && parseInt(document.getElementById("strBSQuantity"+index).value) <= 0)
				{
						alert("Issue Quantity cannot be less then or equal to 0");					
						document.getElementById("strIssueQuantity"+index).value="";
						return false;
					
				}
				
				/*if(parseInt(prescQty,10)<parseInt(issueQty,10) || prescQty.length=='0' )
				{
					alert("Issue Quantity cannot be greater than Prescribe Quantity");					
					document.getElementById("strQtyText"+index).value="";
					return false;
				}	*/					
				
		}
		else
		{
			//document.getElementById("strIssueQuantity"+index).value = "0";
		}
		
		if(document.getElementById("strBSQuantity"+index).value!="")
		{
			    var bsQty     = document.getElementById("strBSQuantity"+index).value;
			    var   sancQty     = document.getElementById("strItemParamValue"+index).value.split("@")[2];
			    var   avlQty     = document.getElementById("strItemParamValue"+index).value.split("@")[4];
			    var issueQty = document.getElementById("strIssueQuantity"+index).value;
			    
			    if(parseInt(issueQty,10) + parseInt(bsQty,10) > parseInt(sancQty,10))
			    {
			    	alert("Sum of LP Quantity & Issue Qty cannot be greater than Sanctioned Quantity");					
					document.getElementById("strBSQuantity"+index).value="";
					return false;
			    }
			    //var prescQty     = document.getElementById("strPrescQty"+index).value;
			  // alert("issueQty"+issueQty);
			   // alert("avlQty"+avlQty);
			    var ln = document.getElementsByName("strItemParamValue").length;
			   // alert(ln);
				if(parseInt(sancQty,10)<parseInt(bsQty,10))
				{
					alert("LP Quantity cannot be greater than Sanctioned Quantity");					
					document.getElementById("strBSQuantity"+index).value="";
					return false;
				}
								
				if(parseInt(bsQty,10)<=0 && parseInt(avlQty,10)<=0)
				{
					alert("LP Quantity cannot be less then or equal to 0");					
					document.getElementById("strBSQuantity"+index).value="";
					return false;
				}
				/*if(parseInt(avlQty,10) > 0 && parseInt(bsQty,10) > 0)
				{
					alert("Item is available in store, still raising LP indent?");					
					document.getElementById("strBSQuantity"+index).focus();
					return false;
				}*/
				/*if(parseInt(prescQty,10)<parseInt(issueQty,10) || prescQty.length=='0' )
				{
					alert("Issue Quantity cannot be greater than Prescribe Quantity");					
					document.getElementById("strQtyText"+index).value="";
					return false;
				}	*/					
		}
}

function getReport()
{

var issueNo = document.forms[0].strIssueNo.value;
var storeId =  document.forms[0].strStoreId.value;
var IndentNo=document.forms[0].strLpRequestNo.value;
var IndentDate=document.forms[0].strRequestDate.value;
var ucReq=document.forms[0].strUCReq.value;
/*
alert("issueNo-"+issueNo);
alert("storeId-"+storeId);
alert("IndentNo-"+IndentNo);
alert("IndentDate-"+IndentDate);
alert("ucReq-"+ucReq);*/
//return false;
	if(issueNo!="0" && issueNo != "" )
	{
		document.forms[0].strIssueQuantity.disabled = "true";
		getIssueDtls('1', storeId, issueNo,IndentNo,IndentDate,ucReq);
	}
	document.forms[0].strIssueNo.value ="0";
}

//function called on click of # to view stock details popup


//function called on click of # to view Brand details popup
function callBrandDetails(index)
{
	document.getElementById('divBrandDtlId'+index).style.display="";
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
	else
	{		
		if(mode=="3")	
		{
			var itemStockObj = document.getElementById("stockDtlsDivId");
	
			alert(res);
			
			itemStockObj.innerHTML = res;
	
			popup('popUpDiv', '150', '60');
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

		for(var i=0;i<len;i++)
		{			

			chkObj[i].disabled = true;	
			chkObj1[i].disabled = true;	
			chkObj[i].value    = "";	

		}
		//document.getElementById("strIssueQty"+index).readOnly = false;
		//document.getElementById("strIssueUnitId"+index).readOnly = false;
		//document.getElementById("strIssueQuantity"+index).value  = '';
		document.getElementById("strFinalCost"+index).value    = '0.00';
		document.getElementById("finalCostDivId"+index).value  = '0.00';
	//	document.getElementById("strItemRemarks"+index).value  = '';		
		document.getElementById(gblUserHiddenFieldDivId).value = "";

		hide_popup('popUpDiv');
		totalIssueCost();	

		// document.getElementsByName("finalCostDivId")[0].value = '0.00';
		//document.getElementsByName("strIssueQty")[index].disabled=false;	
		//document.getElementsByName("strIssueUnitId")[index].disabled=false;	
		

	}
	else
	{

		//hide_popup('popUpDiv');

	}

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
		document.getElementById("strAvailableQty"+index).value = "";
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
		totalQty();
		//batchString();


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
/*
function batchString()
{	   
	var costObj  = document.getElementsByName("strAvailableQty");		
	var batchString = "";
	var expString = "";		
	var mrpString="";
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
					mrpString	= "[ "+document.getElementsByName("strMrpDtls")[i].value+" ]";
					

				}
				else
				{
					batchString = batchString +"\n[ "+ document.getElementsByName("strDrugDtls")[i].value+" ]";
					expString   = expString   +"\n[ "+ document.getElementsByName("strExpDtls")[i].value+" ]";
					mrpString   = mrpString   +"\n[ "+ document.getElementsByName("strMrpDtls")[i].value+" ]";
				}
				j++;

			}	
			//costObj[i].disabled = true;		  
		}

	}
	document.getElementById(gblUserDrugDtlDivId).innerHTML=batchString;
	document.getElementById(gblUserExpDtlDivId).innerHTML=expString;
	document.getElementById(gblUserMrpDtlDivId).innerHTML=mrpString;



}*/

function totalIssueCost()
{
	var costObj = document.getElementsByName("strFinalCost");
	var total = parseFloat("0.00");

	if (costObj.length > 0) 
	{

		for ( var i = 1; i <=costObj.length; i++)
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

	total = roundValue(total, 0);
	document.getElementById("strTotalQtyDivId").innerHTML=total;       

}

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

function setItemDtl(i,idx)
{
	var t=(document.getElementById("brandHiddenVal"+idx).value).split("^");
	document.getElementById("itmNm"+i).innerHTML = t[3];
	//document.getElementById("availQty"+i).innerHTML = t[2];
	var t1 = (document.getElementById("strItemParamValue"+i).value).split("@");
	t1[1]=t[1];
	t1[4]= t[2];
	t1[5]= t[4];
	t1[6]= t[5];
	document.getElementById("strItemParamValue"+i).value = t1[0]+"@"+t1[1]+"@"+t1[2]+"@"+t1[3]+"@"+t1[4]+"@"+t1[5]+"@"+t1[6];
	document.getElementById('divBrandDtlId'+i).style.display="none";
	//document.getElementById("autodiv"+i).style.display="";
}

