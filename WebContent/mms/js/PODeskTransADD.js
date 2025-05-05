function cancel(mode)
{
    document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}

function ItemDtlPopUp(parent,RateUnit,BrandName)
{        
        var objVal1 = document.getElementById("1");
        objVal1.innerHTML = BrandName;
        var objVal2 = document.getElementById("2");
        objVal2.innerHTML = RateUnit;        
        display_popup_menu(parent,'ItemDtlPopUp','170','');
}


function ftnTick()
{
  
   if(document.forms[0].strChkBox.checked == true)
   {
      document.forms[0].strAdvanceToPay.disabled  = false;
   }
   else
   {
      document.forms[0].strAdvanceToPay.disabled  = true;
   } 
}


function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}


function goFunc()
{  
   var Indent = document.getElementById("Indent");
   var Agenda = document.getElementById("Agenda");
   var Indent1 = document.getElementById("Indent1");
   var Agenda1 = document.getElementById("Agenda1");
   if(Indent.style.display=="block" && Indent1.style.display=="block")
   {
      Indent.style.display = "none";
      Indent1.style.display = "none";
      document.getElementById("ast1").style.display="block";
      document.getElementById("ast2").style.display="block";
      document.getElementById("ast3").style.display="block";
      document.getElementById("ast4").style.display="block";
      
      document.getElementById("ast11").style.display="none";
      document.getElementById("ast22").style.display="none";
      document.getElementById("ast33").style.display="none";
      document.getElementById("ast44").style.display="none";
   }
   else
   {  
      Indent.style.display = "block";
      Indent1.style.display = "block";
       document.getElementById("ast1").style.display="none";
      document.getElementById("ast2").style.display="none";
      document.getElementById("ast3").style.display="none";
      document.getElementById("ast4").style.display="none";
      
      document.getElementById("ast11").style.display="block";
      document.getElementById("ast22").style.display="block";
      document.getElementById("ast33").style.display="block";
      document.getElementById("ast44").style.display="block";
   } 
   if(Agenda.style.display=="block" && Agenda1.style.display=="block")
   {
      Agenda.style.display = "none";
      Agenda1.style.display = "none";
   }
   else
   {  
     Agenda.style.display = "block";
     Agenda1.style.display = "block";
   }   
}	

