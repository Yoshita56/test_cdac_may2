function calMRP(obj)
{
	var i = obj.parentNode.parentNode.id;
	var rt = Math.round((parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value))*10000.0)/10000.0;
	//alert(rt);
	//alert(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML=Math.round((+(rt*obj.value)/100.0)*10000.0)/10000.0;
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=Math.round((parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)+(rt*obj.value)/100.0)*10000.0)/10000.0;
    var j = parseInt(i/2) + 1; 
    document.getElementsByName("strAdm")[0].value = "0";
    document.getElementsByName("strCosttoPat")[0].value = "0";
    document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML);
    document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
    var totadmchg = (parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML)); // * parseFloat(document.getElementsByName("strTotalQty")[j].value) ) ;
	console.log("parseInt(totadmchg)"+parseInt(totadmchg) );
	/*
	if( parseInt(totadmchg) > 1000){
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML="1000";
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML)+parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)).toFixed(2);
		document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML);
		document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
		
	}
	*/
} 

function calMRP1(k , val)
{
	var i = k ; //obj.parentNode.parentNode.id;
	var rt = Math.round((parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value))*10000.0)/10000.0;
	//alert(rt);
	//alert(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML=Math.round((+(rt*val)/100.0)*10000.0)/10000.0;
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=Math.round((parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)+(rt*val)/100.0)*10000.0)/10000.0;
    var j = parseInt(i/2) + 1; 
    document.getElementsByName("strAdm")[0].value = "0";
    document.getElementsByName("strCosttoPat")[0].value = "0";
    document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML);
    document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
    
    var totadmchg = (parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML));// * parseFloat(document.getElementsByName("strTotalQty")[j].value) ) ;
	console.log("parseInt(totadmchg)"+parseInt(totadmchg) );
	/*
	if( parseInt(totadmchg) > 1000){
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML="1000";
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML)+parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)).toFixed(2);
		document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML);
		document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
	}
    */
} 

function calRateWithTax(obj)
{
	console.log('1');
	var i = obj.parentNode.parentNode.id;

	//console.log(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);	
	var rt = Math.round((parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value))*10000.0)/10000.0;
	console.log('2');
//	console.log(rt);
	//alert(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
//	console.log(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML=   Math.round((rt+(rt*obj.value)/100.0)*10000.0)/10000.0;
	var j = parseInt(i/2) + 1;
	 console.log("i::"+i+" j::"+j);
	  console.log('3');
    document.getElementsByName("strPurWidTax")[0].value = "0";
    console.log('4');
    document.getElementsByName("strPurWidTax")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
    console.log('5');
     //document.getElementsByName("strBrandId")[0].value = "0";
	//document.getElementsByName("strBrandId")[j].value = document.forms[0].strMultiRowItemId.value;	
	console.log('6');
	//console.log("document.getElementsByName(strBrandId)[j].value"+document.getElementsByName("strBrandId")[j].value);
	//console.log("document.multirowitemid.value"+document.forms[0].strMultiRowItemId.value);
	if(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value !='')
	calMRP1(i , parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value)) ;
}   


function calRateWithTax1(k , val)
{
	console.log('1');
	var i = k ; //obj.parentNode.parentNode.id;

	//console.log(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);	
	var rt = Math.round((parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value))*10000.0)/10000.0;
	console.log('2');
//	console.log(rt);
	//alert(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
//	console.log(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML=   Math.round((rt+(rt*val)/100.0)*10000.0)/10000.0;
	var j = parseInt(i/2) + 1;
	 console.log("i::"+i+" j::"+j);
	  console.log('3');
    document.getElementsByName("strPurWidTax")[0].value = "0";
    console.log('4');
    document.getElementsByName("strPurWidTax")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
    console.log('5');
    // document.getElementsByName("strBrandId")[0].value = "0";
	// document.getElementsByName("strBrandId")[j].value = document.forms[0].strMultiRowItemId.value;	
	console.log('6');
	console.log("document.getElementsByName(strBrandId)[j].value"+document.getElementsByName("strBrandId")[j].value);
	console.log("document.multirowitemid.value"+document.forms[0].strMultiRowItemId.value);
	if(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value !='')
		calMRP1(i , parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value)) ;
}   



function calRateUnit(obj)
{
	//alert(obj.value);
	var i = obj.parentNode.parentNode.id;
	var qty=parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
	//alert((parseFloat(parseFloat(obj.value)/qty)*10000.0)/10000.0);
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=Math.round((parseFloat(obj.value)/qty)*10000.0)/10000.0;
	//onkeypress="return validateData(event,5);"
	var j = parseInt(i/2) + 1;
	document.getElementsByName("strPurRate")[0].value = "0";
	document.getElementsByName("strPurRate")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
	if(document.getElementById(parseInt(i)).querySelectorAll("input")[6].value !='')
	calRateWithTax1(i , parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[6].value));
}



function calRateUnit1(k,val)
{
	//alert(obj.value);
	var i = k ; //obj.parentNode.parentNode.id;
	var qty=parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
	//alert((parseFloat(parseFloat(obj.value)/qty)*10000.0)/10000.0);
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=Math.round((parseFloat(val)/qty)*10000.0)/10000.0;
	//onkeypress="return validateData(event,5);"
	var j = parseInt(i/2) + 1;
	document.getElementsByName("strPurRate")[0].value = "0";
	document.getElementsByName("strPurRate")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
	if(document.getElementById(parseInt(i)).querySelectorAll("input")[6].value !='')
	calRateWithTax1(i , parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[6].value));
}

function calQty(obj,i)
{
	
	//console.log("Qty---"+obj.value);
	
	var qty     = parseFloat(document.getElementById("strTotalQty"+i).value);	
	var purRate = parseFloat(document.getElementById("strPurRate"+i).value);
	var tax     = parseFloat(document.getElementById("strGST"+i).value);
	var admnChg = parseFloat(document.getElementById("strAdmchg"+i).value);
	
	//console.log("-Index--"+i+"--qty--"+qty+"-purRate--"+purRate+"--tax--"+tax+"---admnChg--"+admnChg);
	
	var qtyV     = parseFloat("0");
	var purRateV = parseFloat("0");
	var taxV     = parseFloat("0");
	var admnChgV = parseFloat("0");
 
	  
	if(isNaN(qty)       || qty==""      ||qty.length == 0 )     
		qtyV = "0";
	else
		qtyV = qty;
	if(isNaN(purRate)   || purRate==""  ||purRate.length == 0 ) 
		purRateV = "0";
	else
		purRateV = purRate;
	if(isNaN(tax)       || tax==""      ||tax.length == 0 )     
		taxV = "0";
	else
		taxV = tax;
	if(isNaN(admnChg)   || admnChg==""  ||admnChg.length == 0 ) 
		admnChgV = "0";
	else
		admnChgV = admnChg;
	
	/*
	console.log("-Index--"+i+"--qtyV--"+qtyV+"-purRateV--"+purRateV+"--taxV--"+taxV+"---admnChgV--"+admnChgV);
	
	console.log("Len---"+document.getElementsByName("strTotalQty").length);
	
	
    console.log("-strTotalQty--"+i+"-"+parseFloat(document.getElementById("strTotalQty"+i).value));
    console.log("-strPurRate-"+i+"--"+parseFloat(document.getElementById("strPurRate"+i).value));
    console.log("-strGST-"+i+"--"+parseFloat(document.getElementById("strGST"+i).value));
    console.log("-strAdmchg-"+i+"--"+parseFloat(document.getElementById("strAdmchg"+i).value));
	*/ 	
	
		 
   	var totalTax       =   roundValue((parseFloat(taxV) + parseFloat(admnChgV)),2) ;
   	       	
   		
    var purRateWthTax  =  parseFloat(purRateV) + ( parseFloat(purRateV) *  ( parseFloat(totalTax) /100) ) ;
    
      	
   	var costWthTax     = roundValue((parseFloat(purRateWthTax)*parseFloat(qtyV)),2);
   	
   
   
   	var cost           = roundValue((parseFloat(qtyV)*parseFloat(purRateV)),2);
   	
    	
   	document.getElementById("purRateWthTaxDiv"+i).innerHTML=roundValue(purRateWthTax,2);
    document.getElementById("strPurWidTax"+i).value = roundValue(purRateWthTax,2);
   
    document.getElementById("strCosttoPat"+i).value = roundValue(costWthTax,2);    
   	document.getElementById("costtopat1Div"+i).innerHTML=roundValue(costWthTax,2);
   	
   	document.getElementById("TotalCost"+i).innerHTML=roundValue(costWthTax,2);
   	
   	 
   	
     var costObj = document.getElementsByName("strCosttoPat");
     var  qtyObj = document.getElementsByName("strTotalQty");
  	 
	 var totalQty  = parseInt("0");
	 var totalCost = parseFloat("0");

	 var z;
	 for(var m=0; m<costObj.length; m++) 
	 {
		 if(z==0)
		 {
			 totalCost = parseFloat(costObj[m].value);
			 totalQty  = parseInt(qtyObj[m].value);
	  	 } 
		 else
		 {
				
			 totalCost =  totalCost + parseFloat(costObj[m].value);
			 totalQty  =  totalQty  + parseInt(qtyObj[m].value);
		 }
		 
		 ++z;
	
	 }	 
	 document.getElementById("totalQtyDiv").innerHTML=totalQty;
	 document.getElementById("totalCostDiv").innerHTML=roundValue(totalCost,2);
	
   	
   	   	    	
}
