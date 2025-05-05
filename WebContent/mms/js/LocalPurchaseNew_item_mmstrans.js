function calMRP(obj)
{
	var i = obj.parentNode.parentNode.id;
	var rt = Math.round((parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value))*10000.0)/10000.0;
	var gstper 	= document.getElementById(parseInt(i)).querySelectorAll("input")[6].value;
	var rtTax = parseFloat(rt) + parseFloat((rt*gstper/100));
	
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML=Math.round((+(rtTax*obj.value)/100.0)*10000.0)/10000.0;
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=Math.round((parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)+(rtTax*obj.value)/100.0)*10000.0)/10000.0;
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


function calRateUnit(obj)
{
	
	console.log('----calRateUnit--S--');
	
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
	{
	 calRateWithTax1(i , parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[6].value));
	}
	console.log('----calRateUnit--E--');
}
function calRateWithTax1(k , val)
{
	console.log('----calRateWithTax1--S--');
	var i = k ; //obj.parentNode.parentNode.id;

	//console.log(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);	
	var rt = Math.round((parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value))*10000.0)/10000.0;
	console.log('2');

	//document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML=   Math.round((rt+(rt*val)/100.0)*10000.0)/10000.0;
	
	 document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML=  parseFloat(rt) + parseFloat((rt*val/100));
	 
	var j = parseInt(i/2) + 1;

    document.getElementsByName("strPurWidTax")[0].value = "0";
  
    document.getElementsByName("strPurWidTax")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
  
	console.log("document.getElementsByName(strBrandId)[j].value"+document.getElementsByName("strBrandId")[j].value);
	console.log("document.multirowitemid.value"+document.forms[0].strMultiRowItemId.value);
	if(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value !='')
	{
		calMRP1(i , parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value)) ;
	}
	console.log('----calRateWithTax1--E--');
}   


function calRateWithTax(obj)
{
	console.log('1');
	var i = obj.parentNode.parentNode.id;
	var rt = Math.round((parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value))*10000.0)/10000.0;
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML=   Math.round((rt+(rt*obj.value)/100.0)*10000.0)/10000.0;
	var j = parseInt(i/2) + 1;
    document.getElementsByName("strPurWidTax")[0].value = "0";
 //   alert('4--->'+document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
    document.getElementsByName("strPurWidTax")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
 	if(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value !='')
	calMRP1(i , parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value)) ;
}   
function calMRP1(k , val)
{
	console.log('----calMRP1--S--');
	
	var i = k ; //obj.parentNode.parentNode.id;
	
	//alert("VALUE---->>"+document.getElementById(parseInt(i)).querySelectorAll("input")[4].value+"--QTY---->>"+document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);
	
	var rt = parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value)/parseFloat(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
	
		
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML=parseFloat((rt*val/100));
	document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=parseFloat(rt) + parseFloat((rt*val/100));
   
	var j = parseInt(i/2) + 1; 
    
	document.getElementsByName("strAdm")[0].value = "0";
    document.getElementsByName("strCosttoPat")[0].value = "0";
    
    document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML);
    document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
    
    var totadmchg = (parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML));// * parseFloat(document.getElementsByName("strTotalQty")[j].value) ) ;
	console.log("parseInt(totadmchg)"+parseInt(totadmchg) );
	
    
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

function calQty(obj){
	
	var i = obj.parentNode.parentNode.id;
	var qty=parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
	
	if(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value !='')
	calRateUnit1(i,qty);
	
	
}
