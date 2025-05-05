/*
File Name 		: autoComplete.js
Version	  		: 1.0
Developer 		: Prakhar Misra[Associate Project Engineer]
Supported by 	: Md. Riazuddin Ansari
Guided By		: Mr. A S Cheema
*/

/*
Note -->


*/

//////////////////////////////////js to auto complete the textbox with the selected listbox value//////////////////////////////

/////function search the element matches with the string in the textbox
////event obj - textbox object  listDiv- id of the listbox


function searchInListBox(eve,obj,listDiv)
{

      flag=0;
      var lobj;
      var i = 0;
      var retValue = false;
      var value=  obj.value
      if( value != "")
      { 

            lobj = document.getElementById(listDiv);
            if(lobj.length > 0)           //list box exists
            {
                  for(i=0;i<lobj.length;i++)
                  {
                        listValue = (lobj.options[i].text).toUpperCase();
                        if (listValue.indexOf((value.toString()).toUpperCase()) == 0)      //matched
                        {
                              lobj.selectedIndex = i;
                              retValue = true;
                              document.getElementById(listDiv).style.display="block"
                              break;
                        }
                  }
            }
      }
      else{
      	document.getElementById(listDiv).style.display="none"
      }
      
      if(eve.keyCode==40)//for down arrow key
      {
		document.getElementById(listDiv).style.display="block"
		document.getElementById(listDiv).focus()
		var selectedIndex=document.getElementById(listDiv).selectedIndex;
		var optionsArray=document.getElementById(listDiv).options;
		obj.value=optionsArray[selectedIndex].text;
	  }
      
		
      return retValue;
} //end searchInLi

///////////////////////function populate the textbox with the selected item in the list///////////////////
///obj- listbox ,textbox-name of the textbox
function populateTextBox(obj,textbox)
{
	var selectedIndex=obj.selectedIndex;
	var optionsArray=obj.options;
	document.getElementsByName(textbox)[0].value=optionsArray[selectedIndex].text;
}

///hide the list on blur
///obj- listbox 
function hideList(obj,textbox)
{
	populateTextBox(obj,textbox)
	obj.style.display="none"		

}

