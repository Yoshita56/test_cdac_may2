function chkCondemnDtls(){

	if(document.forms[0].strCondemnationTypeName.value == "Auction"){
			document.getElementById("showCondemnDtls").style.display= "block";
	
	} else{
			document.getElementById("showCondemnDtls").style.display= "none";
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



/*
function openPopUp(obj,index)
{
	parentPopUp = obj; 
	display_popup_menu(parentPopUp,"specificationId"+index,"300","");
}
*/
var parentPopUp = "";




function openSpecification(obj,index)
{
	   
       
        
        var strItemDetail = document.getElementById("strItemDtl"+index).value;     
       // alert("strItemDetail--->"+strItemDetail)   
       
        myArray = strItemDetail.split("@");
        document.getElementById("popUpItemId").innerHTML=myArray[0]+"-"+"Item Details";
        //alert("myArray--size"+myArray.length);
       
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
         var objVal3 = document.getElementById("3");
        var temp=myArray[3].split("^");
        if(myArray[1]!='null')
        {
          objVal3.innerHTML = temp[0]; 
        }
        else
        {
          objVal3.innerHTML = "  ----";
        }    
          
        var objVal4 = document.getElementById("4");
       
        if(myArray[1]!='null')
        {
          objVal4.innerHTML = temp[1]; 
        }
        else
        {
          objVal4.innerHTML = "  ----";
        }
        
           objVal4 = document.getElementById("5");
       
        if(myArray[1]!='null')
        {
          objVal4.innerHTML = myArray[4]; 
        }
        else
        {
          objVal4.innerHTML = "  ----";
        }  
        
        objVal4 = document.getElementById("6");
       
        if(myArray[1]!='null')
        {
          objVal4.innerHTML = myArray[5]; 
        }
        else
        {
          objVal4.innerHTML = "  ----";
        }    
        	display_popup_menu(obj,'itemDtlId','300','');
        	
	
}


function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}
function cancelWindow()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].submit();
}

