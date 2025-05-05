function validateIndentDeskApprove(form1,mode){
	cmbVal="";
	
	with(form1){
		if(mode=="APPROVE" && document.forms[0].combo[0].value=="0" || document.forms[0].combo[1].value=="0"){
			alert("please select combo value");
			return;
		}
		if( mode == "APPROVE" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}
	}
}
function validateIndentdeskView(form1,mode)
{
 with(form1){
		if(mode=="VIEW" && document.forms[0].combo[0].value=="0" || document.forms[0].combo[1].value=="0"){
			alert("please select combo value");
			return;
		}
		if( mode == "VIEW" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			var check=document.getElementsByName("chk");
		    var indexStr;
            var checkCount=0;
	        for(i=0;i<check.length;i++)
	        {
	         if(check[i].checked==true)
	         {
		      checkCount++;
		      indexStr=i;
	         }	
	        }
            check[indexStr].value=check[indexStr].value.concat("$IndentApprovalDeskCNT.cnt");
			add(mode);
		}
	}
}
function validateIndentdeskReject(form1,mode)
{
	
	//if(len==1)
 //{
   res=prompt("ENTER REMARKS FOR REJECTION!","");
   if(!res=="")
   {
     with(form1)
     {
      var check=document.getElementsByName("chk");
      var indexStr;
      var checkCount=0;
	  for(i=0;i<check.length;i++)
	  {
	    if(check[i].checked==true)
	    {
		  checkCount++;
		  indexStr=i;
	    }	
	  }
         check[indexStr].value=check[indexStr].value.concat(res);
     }
     alert("Reject Value->"+check[indexStr].value);
     sts = confirm("Are you sure");
     if(sts==true)
     {
      /// submitpage(mode);
     }
   }
   else
   {
     if(res=="")
       alert("No Remark entered, enter Remark & then continue");
   }
  //}
	
}
function chkUserDefinedFunc(these){
	var checkCount=0;
	var index;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true)
		{
			checkCount++;
			index=i;
		}	
	}
	if(checkCount==1 && document.forms[0].combo[1].value=="1")
	{
		enableButton("Approve");
		alert("Value To Approval->"+check[index].value);
	}
	else
		disableButton("Approve");
    if(checkCount==1 && document.forms[0].combo[1].value=="2")		
    {
		enableButton("Reject");
		alert("Value To Approval->"+check[index].value);
	}
	else
		disableButton("Reject");	
	if(checkCount==1 && document.forms[0].combo[1].value=="3")		
    {
		enableButton("View");
		alert("Value To Approval->"+check[index].value);
	}
	else
		disableButton("View");		
}	

function cmbFunc()
{
    disableButton("Approve");
    disableButton("Reject");
/*  if(document.forms[0].combo[0].value=="0" && document.forms[0].combo[1].value!="0")
  {
    alert("Select Store name.Please");
    disableButton("Approve");
    disableButton("Reject");	
  }
  else if(document.forms[0].combo[1].value=="1")
  {
    enableButton("Approve");
    disableButton("Reject");	
  }
  else if(document.forms[0].combo[1].value=="2")
  {
    enableButton("Reject");
    disableButton("Approve");
  }
  else
  {
    disableButton("Approve");
    disableButton("Reject");
  }*/
}