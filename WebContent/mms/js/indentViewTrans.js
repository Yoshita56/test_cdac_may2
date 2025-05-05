
function cancelToDesk()
{
  var mode="CANCEL";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}
function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}
function callingPoPUp(parent,i,strHiddenValue,reqTypeId)
{
  
  if(reqTypeId == 17)
  {
    issueDtlPoPUp(parent,i,strHiddenValue);      //201
  }
  
  if(reqTypeId == 18)
  {
    ReturnRequest(parent,i,strHiddenValue);      //206
  }
  
  if(reqTypeId == 11)
  {
     AnnualPopUp(parent,i,strHiddenValue);        //207
  }
  if(reqTypeId == 12 || reqTypeId == 13)
  {
    LpPatientStaff(parent,i,strHiddenValue);      //202
  }
  if(reqTypeId == 14 || reqTypeId == 10 )
  {
    LpDept(parent,i,strHiddenValue);              //203
  }
  if(reqTypeId == 16)
  {
    IndentCondemnation(parent,i,strHiddenValue);  //204
  }
  if(reqTypeId == 15)
  {
    IndentForImported(parent,i,strHiddenValue);   //205
  }
  

}

function callingPoPUpReceiveThirdParty(paretnt,i,strExpDate,strItemMake,strRateUnit)
{
        var objVal1 = document.getElementById("100");
        
        if(strExpDate!='null')
        {
         
          objVal1.innerHTML = strExpDate; 
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
        var objVal2 = document.getElementById("101");
        
        if(strItemMake!='null')
        {
         
          objVal2.innerHTML = strItemMake; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        var objVal2 = document.getElementById("102");
        
        if(strRateUnit!='null')
        {
         
          objVal2.innerHTML = strRateUnit; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
             
        display_popup_menu(parent,'ReceiveFrmThirdParty','200','');
}



function IndentForImported(parent,i,strHiddenValue)
{
 // strLstPoNo+"^"+
 // strLstPODate+"^"+
 // strLstRecDate+"^"+
 // strLstSupplBy+"^"+
 // strGrpName+"^"+
 // strSubGrpName;
 
  
 
        myArray = strHiddenValue.split("^");
  
        document.getElementById("205").innerHTML =  myArray[6];
         
        var objVal1 = document.getElementById("24");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("25");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("26");
        
        if(myArray[2]!= 'null')
        {
         
          objVal3.innerHTML = myArray[2];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("27");
        
        if(myArray[3]!= 'null')
        {
          
          objVal4.innerHTML = myArray[3];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 


 display_popup_menu(parent,'IndentForImported','200','');
}

function ReturnRequest(parent,i,strHiddenValue)
{
        myArray = strHiddenValue.split("^");
  //    strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strGrpName+"^"+strSubGrpName+"^"+strExpDate; 
        document.getElementById("206").innerHTML =  myArray[6];
        var objVal1 = document.getElementById("21");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("22");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("23");
        
        if(myArray[5]!= 'null'|| myArray[5]!='')
        {
         
          objVal3.innerHTML = myArray[5];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        display_popup_menu(parent,'ReturnRequest','200','');
}




function IndentCondemnation(parent,i,strHiddenValue)
{
     myArray = strHiddenValue.split("^");
    //strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strExpDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName;
    //        
       document.getElementById("204").innerHTML =  myArray[7];
         
        var objVal1 = document.getElementById("17");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("18");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("19");
        
        if(myArray[3]!= 'null')
        {
         
          objVal3.innerHTML = myArray[3];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("20");
        
        if(myArray[4]!= 'null')
        {
          
          objVal4.innerHTML = myArray[4];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        display_popup_menu(parent,'IndentCondemnation','200','');



}
function LpDept(parent,i,strHiddenValue)
{
   myArray = strHiddenValue.split("^");
            
        //strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId;
        
         document.getElementById("203").innerHTML =  myArray[4];
        var objVal1 = document.getElementById("14");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("15");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        var objVal3 = document.getElementById("16");
        
        if(myArray[2]!='null')
        {
         
          objVal3.innerHTML = myArray[2]; 
        }
        else
        {
          objVal3.innerHTML = "  ----";
        }  
        
        
        display_popup_menu(parent,'LpDept','200','');

}


function LpPatientStaff(parent,i,strHiddenValue)
{
   myArray = strHiddenValue.split("^");
            
         document.getElementById("202").innerHTML =  myArray[2]; 
        var objVal1 = document.getElementById("12");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("13");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        display_popup_menu(parent,'LpPatStaff','200','');

}


function AnnualPopUp(parent,i,strHiddenValue)
{    
      
        myArray = strHiddenValue.split("^");
        
         document.getElementById("207").innerHTML =  myArray[7];
        
  //0strLstPoNo+"^"+1strLstPODate+"^"+2strLstRecDate+"^"+3strLstSupplBy+"^"+4strLstYerConsump+"^"+5strReOrderLevel+"^"+6strLstRecQty;        
               //9876578888^07-Jun-2009^07-Jun-2009^Xyz^0 /^50 Each^100 Each"   
        
        
        var objVal1 = document.getElementById("5");
        if(myArray[5]!='null' ||myArray[5]!='')
        {
         
          objVal1.innerHTML = myArray[5];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("6");
        
        if(myArray[4]!='null')
        {
         
          objVal2.innerHTML = myArray[4]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("7");
        
        if(myArray[4]!= 'null')
        {
         
          objVal3.innerHTML = myArray[0];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("8");
        
        if(myArray[1]!= 'null')
        {
          
          objVal4.innerHTML = myArray[1];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        
        var objVal5 = document.getElementById("9");
        
        if(myArray[6]!= 'null')
        {
          
          objVal5.innerHTML = myArray[6];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        
        var objVal6 = document.getElementById("10");
        
        if(myArray[2]!= 'null')
        {
          
          objVal6.innerHTML = myArray[2];  
        }
        else
        {
          objVal6.innerHTML = "----";
        } 
        
        var objVal7 = document.getElementById("11");
        
        if(myArray[3]!= 'null')
        {
          
          objVal7.innerHTML = myArray[3];  
        }
        else
        {
          objVal7.innerHTML = "----";
        } 
        
        
        display_popup_menu(parent,'AnnualPurchase','210','');
	}




function issueDtlPoPUp(parent,i,strHiddenValue)
{    
        myArray = strHiddenValue.split("^");
            
         document.getElementById("201").innerHTML =  myArray[4];
        var objVal1 = document.getElementById("1");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("3");
        
        if(myArray[2]!= 'null')
        {
         
          objVal3.innerHTML = myArray[2];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("4");
        
        if(myArray[3]!= 'null')
        {
          
          objVal4.innerHTML = myArray[3];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        display_popup_menu(parent,'issueDtl','200','');
	}
/*
function issueDtl(parent,i){        
  
  		var strIssueDetail = document.getElementById("strIssueDtl"+i).value;
  
        myArray= strIssueDetail.split("^"); 
        
        var objVal1 = document.getElementById("1");
        
        if(myArray[2]!='null' || myArray[2]!='')
        {
          objVal1.innerHTML = myArray[2];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
        var objVal2 = document.getElementById("2");
        if(myArray[0]!='null')
        {
          objVal2.innerHTML = myArray[0]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("3");
        if(myArray[4]!= 'null')
        {
          objVal3.innerHTML = myArray[4];  
        }
        else
        {
          objVal3.innerHTML = "  ----";
        }  
        
        var strIssQty = document.getElementById("strIssueQty"+i).value;
        
        if(strIssQty > 0){
        
        	display_popup_menu(parent,'issueDtl','300','');
        	
        }else{
        
        	alert("Issue Quantity should be greater than zero");
        }
	}
*/



function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}



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