	function calPurRate(obj)
	{
		var i = obj.parentNode.parentNode.id;
		//alert(i);
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value != '' && obj.value != '')
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=parseInt(obj.value)*parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);
		else if(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value == '')
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=parseInt(obj.value);
		else
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=document.getElementById(parseInt(i)).querySelectorAll("input")[5].value;

		if(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value == '' && obj.value == '')
		{
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=0;
		}

		//calQty(obj.children);
		//alert(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);
		//console.log(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value != '')
		calQty1(i , document.getElementById(parseInt(i)).querySelectorAll("input")[5].value );
		//alert(document.getElementById('RowId').querySelectorAll("tr")[3].querySelectorAll("input")[4].value);
		
	}

	function calMRP(obj)
	{
		var i = obj.parentNode.parentNode.id;
		//alert(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
		//(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)*obj.value)
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=((parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)*obj.value)/100).toFixed(2);// +parseFloat(parseInt(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)*obj.value/100.0);
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML=(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML)+parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML)).toFixed(2);
		var j = parseInt(i/2) + 1; 
		document.getElementsByName("strAdm")[0].value = "0";
		document.getElementsByName("strCosttoPat")[0].value = "0";
		document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
		document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML);
		var totadmchg = (parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML)); // * parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML) ) ;
		console.log("parseInt(totadmchg)"+parseInt(totadmchg) );
		if( parseInt(totadmchg) > parseInt(1000)){
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML="1000";
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML=(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML)+parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML)).toFixed(2);
			document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
			document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML);
			
		}
		
	} 

	function calMRP1(k , val )
	{
		var i = k ; // obj.parentNode.parentNode.id;
		console.log("label1"+document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML=((parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)*val)/100).toFixed(2);// +parseFloat(parseInt(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)*obj.value/100.0);
		console.log("label3"+document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML=(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML)+parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML)).toFixed(2);
		console.log("label4"+document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML);
		var j = parseInt(i/2) + 1; 
		document.getElementsByName("strAdm")[0].value = "0";
		document.getElementsByName("strCosttoPat")[0].value = "0";
		document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
		document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML);
		var totadmchg = (parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML)); // * parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML) ) ;
		console.log("parseInt(totadmchg)"+parseInt(totadmchg) );
		if( parseInt(totadmchg) > 1000){
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML="1000";
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML=(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML)+parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML)).toFixed(2);
			document.getElementsByName("strAdm")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[3].innerHTML);
			document.getElementsByName("strCosttoPat")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[4].innerHTML);
				
		}
	} 

	
	function calRateWithTax(obj)
	{
		var i = obj.parentNode.parentNode.id;
		//alert(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
		var amt=parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)+parseFloat(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)*obj.value/100.0);
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML=amt.toFixed(2);
		var j = parseInt(i/2) + 1;
		document.getElementsByName("strPurWidTax")[0].value = "0";
		document.getElementsByName("strPurWidTax")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML);

		if(document.getElementById(parseInt(i)).querySelectorAll("input")[8].value !=''  )
		calMRP1(i , parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[8].value) ) ;
	}   


	function calRateWithTax1(k , val)
	{
		var i = k;// obj.parentNode.parentNode.id;
		//alert(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
		var amt=parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)+parseFloat(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML)*val/100.0);
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML=amt.toFixed(2);
		var j = parseInt(i/2) + 1;
		document.getElementsByName("strPurWidTax")[0].value = "0";
		document.getElementsByName("strPurWidTax")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[2].innerHTML);
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[8].value !=''  )
		calMRP1(i , parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[8].value) ) ;
	}   
	
	function calRateUnit(obj)
	{
		//alert(obj.value);
		var i = obj.parentNode.parentNode.id;
		var qty=parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
		//alert((parseFloat(parseFloat(obj.value)/qty)*100.0)/100.0);
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML=(parseFloat(obj.value)/qty).toFixed(2);
		//onkeypress="return validateData(event,5);"
		var j = parseInt(i/2) + 1;
		document.getElementsByName("strPurRate")[0].value = "0";
		document.getElementsByName("strPurRate")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
		
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value !='' )
		calRateWithTax1(i , parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value));
		
	}

	function calRateUnit1(k , val)
	{
		//alert(obj.value);
		var i = k;//obj.parentNode.parentNode.id;
		var qty=parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
		//alert((parseFloat(parseFloat(obj.value)/qty)*100.0)/100.0);
		document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML=(parseFloat(val)/qty).toFixed(2);
		//onkeypress="return validateData(event,5);"
		var j = parseInt(i/2) + 1;
		document.getElementsByName("strPurRate")[0].value = "0";
		document.getElementsByName("strPurRate")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[1].innerHTML);
		
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value !='' )
		calRateWithTax1(k , parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[7].value));
		
	}


	function calQty1(k, val)
	{
		console.log('calQty1::::::::::');
		var i = k ; //obj.parentNode.parentNode.id;
		//swal(parseInt(i/2));
		//console.log("obj:::::::"+obj.value);
		//console.log("input4:::::"+document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value != '' && val != '')
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=parseInt(val)*parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
		else if(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value == '')
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=parseInt(val);
		else
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=document.getElementById(parseInt(i)).querySelectorAll("input")[4].value;

		if(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value == '' && val == '')
		{
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=0;
		}
		var j = parseInt(i/2) + 1;
		console.log("j:::::::::::"+j);
		console.log("i:::::::::::"+i);
		document.getElementsByName("strTotalQty")[0].value = "0";
		document.getElementsByName("strTotalQty")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
		//document.getElementsByName("strBrandId")[0].value = "0";
		//document.getElementsByName("strBrandId")[j].value = document.forms[0].strMultiRowItemId.value;	
		//console.log("document.getElementsByName(strBrandId)[j].value"+document.getElementsByName("strBrandId")[j].value);
		//console.log("document.multirowitemid.value"+document.forms[0].strMultiRowItemId.value);
		//console.log("multirowitem"+document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].value);
		console.log('Testtttt');
		console.log(document.getElementById(parseInt(i)).querySelectorAll("input")[5].value);
		console.log(parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML));
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[6].value !='')
		calRateUnit1(i , parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML) );
	}

	
	function calQty(obj)
	{
		var i = obj.parentNode.parentNode.id;
		//swal(parseInt(i/2));
		console.log("obj:::::::"+obj.value);
		console.log("input4:::::"+document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value != '' && obj.value != '')
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=parseInt(obj.value)*parseInt(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value);
		else if(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value == '')
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=parseInt(obj.value);
		else
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=document.getElementById(parseInt(i)).querySelectorAll("input")[4].value;

		if(document.getElementById(parseInt(i)).querySelectorAll("input")[4].value == '' && obj.value == '')
		{
			document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML=0;
		}
		var j = parseInt(i/2) + 1;
		console.log("j:::::::::::"+j);
		console.log("i:::::::::::"+i);
		document.getElementsByName("strTotalQty")[0].value = "0";
		document.getElementsByName("strTotalQty")[j].value = parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML);
		//document.getElementsByName("strBrandId")[0].value = "0";
		//document.getElementsByName("strBrandId")[j].value = document.forms[0].strMultiRowItemId.value;	
		//console.log("document.getElementsByName(strBrandId)[j].value"+document.getElementsByName("strBrandId")[j].value);
		//console.log("document.multirowitemid.value"+document.forms[0].strMultiRowItemId.value);
		//console.log("multirowitem"+document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].value);
		if(document.getElementById(parseInt(i)).querySelectorAll("input")[6].value !='')
		calRateUnit1(i , parseFloat(document.getElementById(parseInt(i)+1).querySelectorAll("label")[0].innerHTML) );
	}
