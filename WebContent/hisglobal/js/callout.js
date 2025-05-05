function ShowCallout(calloutText, evt)
{
    var divCallout = document.getElementById('divCallout');
   
    evt = evt || window.event;                      
    document.getElementById("divCalloutText").innerHTML = calloutText;                  
     //document.getElementById("divCalloutText").style.color="#ffffff";        
        document.getElementById("divCalloutText").style.backgroundColor="#ffffff";  
    SetCalloutPosition(evt, divCallout, 0, 0);               
   
    divCallout.style.display = "block";
}

function HideCallout()
{
    divCallout.style.display = "none";
}

function SetCalloutPosition(sEvent, divCallOut, marginLeft, marginTop)
{  
    if(divCallOut)
    {                                               
        // Get x and y coordinates to show callout at mouse position   
        var xPos = 0; var yPos = 0;
        if (sEvent.pageX || sEvent.pageY)
        {
            xPos = sEvent.pageX;
            yPos = sEvent.pageY;
        }
        else if (sEvent.clientX || sEvent.clientY)
        {
            xPos = sEvent.clientX + document.documentElement.scrollLeft + 10;
            yPos = sEvent.clientY + document.documentElement.scrollTop;
        }
           
        divCallOut.style.left = xPos + marginLeft + "px";
        divCallOut.style.top = yPos - marginTop + "px";    
    }                   
}