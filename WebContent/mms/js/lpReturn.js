function openDiv()
{
	if(document.getElementsByName("strRaisingReqTypeId")[0].value=="13" || document.getElementsByName("strRaisingReqTypeId")[0].value=="12"){
		document.getElementById("patientDtlId").style.display="block";
	}
	if(!(document.forms[0].strReturnQty)){
		document.getElementById("recommendationId").style.display="none";
	}
	
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
    var itemParamValue= document.getElementById("strItemParamValue"+index).value;    
    var myArray = strItemDetail.split("@");
    document.getElementById("popUpItemId").innerHTML="Balance Qty. Details";
    var myArray2=itemParamValue.split("@");      
    var objVal1 = document.getElementById("1");
   
    if(myArray[0]!='null' || myArray[0]!='')
    {
      objVal1.innerHTML = myArray2[0]+" "+myArray[1];
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
function SAVERETURN()
{

	if(!(document.forms[0].strReturnQty)){
	
		alert('All Item have been Expired');
		return false;
	}
	else{
			var hisValidator = new HISValidator("lpIssueDeskTransBean"); 
			hisValidator.addValidation("strReturnQty", "req", "Return Qty is a Mandatory Field" );
			hisValidator.addValidation("strRecommendBy","dontselect=0","Please Select Recomended by" );
		   var retVal = hisValidator.validate(); 
		  hisValidator.clearAllValidations();	
		
		  var admDtl = document.forms[0].strBillingHiddenValue.value;
		  //alert(admDtl);
		  var accstatus=admDtl.split('^')[0];
		  //alert(accstatus);
		  if( accstatus == '0')
			  {
			  	alert('Patient Account Not exists !!!');
			  	return false
			  }
		  
		  if(retVal){
		  	retVal=chkValReturn();
		  	
		  }if(retVal){
		  	retVal=chkValReturnUnit();
		  }
		if(retVal){
				document.forms[0].hmode.value="INSERTRET";
				document.forms[0].submit();
		}
	}
}


function quantityUnitValue(index)
{
	if(document.getElementById('strUnit'+index).value!='0'){
	
		var temp="";
		
		var hiddenVal=document.getElementById('strItemParamValue'+index).value;	
		temp=hiddenVal.split("@");
		var balQty = document.getElementById('strBalanceQty'+index).value;
		var returnQty = document.getElementById('strReturnQty'+index).value;
		var returnUnit = document.getElementById('strUnit'+index).value;
		var temp1 = returnUnit.split('^');
		var returnValue = parseFloat(returnQty) * parseFloat(temp1[1]);
		if(returnValue>parseFloat(balQty)*parseFloat(temp[14]))
		{
			
			alert("Return Quantity must be less than Balance Quantity");
			document.getElementById('strReturnQty'+index).value = "";
			//document.getElementById('strUnit'+index).value = "0"
			//document.getElementById('strTotalCost'+index).value = "0.00";
				
			return false;
		}else{
					
			
			var qty = document.getElementById('strReturnQty'+index).value;
			var unit = document.getElementById('strUnit'+index).value;	
			
			var unitBase = unit.split('^');
			var costValue1 = parseFloat(qty) * parseFloat(unitBase[1]);
			
		
			var rateIndex = temp[10]
			var rateValues = temp[11].split('^');
			
			var costValue2 = parseFloat(rateIndex / parseFloat(rateValues[1]));
			
			
			var cost = costValue1 * costValue2;
			document.getElementById('itemCostId'+index).innerHTML ="";
			cost = roundValue(cost, 2);
			if(isNaN(cost)){
				document.getElementById('itemCost'+index).value='0';
				document.getElementById('itemCostId'+index).innerHTML ="";
				document.getElementById('itemCostId'+index).innerHTML ="0.00";
			}else{
				document.getElementById('itemCost'+index).value = cost;
				document.getElementById('itemCostId'+index).innerHTML ="";
				document.getElementById('itemCostId'+index).innerHTML = cost;
			}
			
			
		
			
			var netCost = 0;
			var totalCost = document.getElementsByName('itemCost');
			var length = totalCost.length;
			
			for(var i=0;i<length;i++)
			{
				var costVal = totalCost[i].value;
				netCost = netCost + parseFloat(costVal);
				
			}
			
			netCost = roundValue(netCost,2);
			if(isNaN(netCost)){
				document.getElementById('finalCostId').innerHTML="<font color='red'><b>Rs.0.00</b></font>";
				document.getElementsByName('strFinalCost')[0].value="0.00";
			}else{
				document.getElementById('finalCostId').innerHTML = "<font color='red'><b>Rs. "+netCost+"</b></font>";
				document.getElementsByName('strFinalCost')[0].value = netCost;
			}	
				
		}
	}
	
	checkUnitQty(index);	

}


function checkUnitQty(index) {

		var returnQty = document.getElementById('strReturnQty'+index).value;
		var returnUnit = document.getElementById('strUnit'+index).value;
		
		var temp = returnUnit.split('^');
		
		var returnValue = parseFloat(returnQty) * parseFloat(temp[1]);

			if (returnQty.indexOf('.') > -1 && temp != '0') {

			alert("Qty must be an Integer ");
			document.getElementById('strReturnQty'+index).value = "";
			//document.getElementById('strUnit'+index).value = "0"
			return false;
			}

}
/*
 * this function used to check whether aleast one return Qty must be greater than 0
 */
function chkValReturn(){
	var arrayReturn=document.getElementsByName("strReturnQty");
	var flag=true;
	if(arrayReturn.length==1){
		if(arrayReturn[0].value<="0"){
			alert("Please Enter Return Qty greater than 0");
			arrayReturn[0].value="";
			arrayReturn[0].focus();
			return false;
		}
		else{
			return true;
		}
		
	}else{
		for(var i=0;i<arrayReturn.length;i++){
			if(arrayReturn[i].value=="0"){
				flag=false;
			}
			else{
				flag=true;
				break;
			}
		}
	}
	if(flag){
		return true
	}else{
		alert("Please Enter At Least One Return Qty Greater Than 0");
		return false;
	}
}
function chkValReturnUnit(){
	var arrayReturnUnit=document.getElementsByName("strUnit");
	var arrayReturn=document.getElementsByName("strReturnQty");
	var flag=true;
	if(arrayReturnUnit.length==1){
		if(arrayReturnUnit[0].value=="0"){
			alert('Please Select Unit Combo');
			return false;
		}else{
			return true;
		}
		
	}else{
		for(var i=0;i<arrayReturnUnit.length;i++){
			if(parseInt(arrayReturn[i].value)>0 && arrayReturnUnit[i].value=="0"){
				alert('Please Select Unit Combo');
				arrayReturnUnit[i].focus();
				return false;
			}
			else{
				continue;
			}
		}
	}
	return true;
	
}

function getReport()
{

var issueNo = document.forms[0].strReturnNo.value;
var storeId =  document.forms[0].strStoreId.value;
//var IndentNo=document.forms[0].strLpRequestNo.value;
//var IndentDate=document.forms[0].strRequestDate.value


//alert("IndentNo-"+IndentNo);
//alert("IndentDate-"+IndentDate);
//return false;
	if(issueNo!="0" && issueNo != "" )
	{
		getIssueDtls('6', storeId, issueNo,"0","0");
	}
	document.forms[0].strReturnNo.value ="0";
}
