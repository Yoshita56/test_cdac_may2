
function checkTime(eObj,obj)

{
var key
if (window.event)
	   key = window.event.keyCode;
	else if (eObj)
	   key = eObj.which;
	else
	   return true;

//alert(key)
	if(key==32)
		return false

	if(key>=48 && key<=57)

	{
		//alert("obj.value.length="+obj.value.length)
		if(getCursorIdex(obj)==0 && (key>=48 && key<=50) )
		{
			//eObj.keyCode = 0;
			return true;
		}
		else if(getCursorIdex(obj)==0 && !(key>=48 && key<=50) )
		{
			return false
		}


		if(getCursorIdex(obj)==1 && parseInt(obj.value)>1 )
		{
			if( (key>=48 && key<=51) )
			{
			//eObj.keyCode = 0;
				return true;
			}
			else
			{
			return false
			}

		}else if(getCursorIdex(obj)==1 && parseInt(obj.value)<=1) 
			{
				if(key>=48 && key<=57)
				{
					return true
				}
				else
				{
					return false
				}
			}

		

		if(getCursorIdex(obj)==2 && key!=58 && obj.value.length==2)

		{
			if( !(key>=48 && key<=53))

			{
				//eObj.keyCode = 0;
				return false;
			}
			else
				{
				obj.value += ":";	
				return true
				}
		}
		
		if(getCursorIdex(obj)==2 && key!=58 && obj.value.length >2)

		{
			//alert("Enter :")
			obj.value =obj.value.substring(0,2)+ ":" +obj.value.substring(2);
			return true
		}
		
	
		if(getCursorIdex(obj)==3)

		{

			if( (key>=48 && key<=53) )
			{
			//eObj.keyCode = 0;
			
				return true;
			}
			else
			{
			
				return false
			}

		}
		

	}

	else
	{
		if ((key==null) || (key==0) || (key==8) ||
		(key==9) || (key==13) || (key==27) || (key==32) || (key==95) || (getCursorIdex(obj)==2 && key==58))
	   return true;
	else
		return false
		//eObj.keyCode = 0;
	}
}


function onBlurCheckTime(obj)
{
if((obj.value.length!=0) && (obj.value.length!=5) )
{
	//alert("length")
	alert("Use Time Format HH:MM 24Hr");
	obj.value="";
}else
{
	if(!validateTime(obj))
	{
	//alert("value")
	alert("Use Time Format HH:MM 24Hr");
	obj.value="";
	}
}
}

function validateTime(obj)
{
	var valid=true
	value=obj.value
	//alert("value.substr(0,1)="+value.substring(0,1))
	//alert("value.substr(1,2)="+value.substring(1,2))
	//alert("value.substr(2,3)="+value.substring(2,3))
	//alert("value.substr(3,4)="+value.substring(3,4))
	//alert("value.substr(4,5)="+value.substring(4,5))
	if(value.substr(0,1)>2)
	{
		return false
	
	}
	else if(value.substring(0,1)>1 && value.substring(1,2)>3)
	{
		return false
	
	}
	else if(value.substring(2,3)!=":")
	{
		return false
		}
	else if(value.substring(3,4)>5)
	{
		return false
	}
	else 
	{
		return true
	}
	
}

///////////////////////getting index of char on keypress////////////////////////////////////////////////

function getCursorIdex(o) {
	if (o.createTextRange) {
		var r = document.selection.createRange().duplicate()
		r.moveEnd('character', o.value.length)
		if (r.text == '') return o.value.length
		return o.value.lastIndexOf(r.text)
	} else return o.selectionStart
}