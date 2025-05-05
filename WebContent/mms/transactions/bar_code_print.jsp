<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>   

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset=UTF-8">
<title>BAR-Code Generation</title>

<!-- CSS -->

<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>



<!-- JS -->

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<!-- EXT JS -->
<script language="JavaScript" src="../js/BarCodeGene.js"></script>
<!-- <script language="Javascript" src="../../hisglobal/js/jquery-barcode.js"></script>  -->
<script language="Javascript" src="../../hisglobal/js/qrcode.min.js"></script>



<style>

 @media print 
 {
            @page {
			width: 75mm;
			height: 34mm;
			margin-top: 5mm;
			margin-left: 0.5mm;
		}
 }
        
 .label{ width: 120mm; height: 48mm; margin-bottom: 0mm; margin-top: 2mm; margin-left: 8mm;}
 
.donotprint
{
display:none;
}
.divwithborder {
	border: thin solid #FF0000;
	color:#FF0000;
}
.divwithborderblack {
	border: thin solid black;
	color:black;         
}
</style>
<style  media="screen">
.donotprint
{
display:block;
width:100%;
}
.divwithborder {
	border: thin solid #FF0000;
	color:#FF0000;
}
.divwithborderblack {
	border: thin solid black;
	color:black;
}
</style>


<script type="text/javascript">

function DrawCode39Barcode(data, checkDigit)
{

	//alert("inside barcode_code39.js");
	return DrawHTMLBarcode_Code39(data,checkDigit,"yes",
						"in", 0,1.5,0.2,2,
						"bottom","left", "",
						"black","white"); 
}
 
 
 function generateBarCode()
 {
				  
			var crNo = document.getElementById("qrCodeValue").value;	   
		    
		    var qrcode = new QRCode(document.getElementById("qrcode-1"), {
				text: crNo,
				width: 70,
				height: 70,
				colorDark : "#000000",
				colorLight : "#ffffff",
				correctLevel : QRCode.CorrectLevel.H
			});
		    
		    var qrcode = new QRCode(document.getElementById("qrcode-2"), {
				text: crNo,
				width: 70,
				height: 70,
				colorDark : "#000000",
				colorLight : "#ffffff",
				correctLevel : QRCode.CorrectLevel.H
			});
			
		    
		
		
		printitWithoutDialog();
	}
 
 
 
 function printitWithoutDialog()     
	{   
			if ((navigator.appName == "Netscape"))
			{
				window.print() ;
				
			}
			else
			{		
				
				var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"> </OBJECT>';
				document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
				WebBrowser1.ExecWB(6, -1);
				WebBrowser1.outerHTML = "";
				
			}
	}
 
 
</script>


</head>
<body onLoad="generateBarCode();">
<html:form action="/transactions/StockBarCodeTransCNT.cnt"  name="barCodeGeneBean" type="mms.transactions.controller.fb.StockBarCodeTransFB" method="post">
<div id="barcodeDialog" class="label">
<%-- <bean:write name="barCodeGeneBean" property="strBarCodeHLP" filter="false"/> --%>
 <%=((String)session.getAttribute("sampleNoLabelBarCodeString")) %> 

 <!-- <table style="margin-left: 3%; margin-top: 2%;" cellspacing="0" cellpadding="0" width="90%">
    <tr style="font-size: 11px; font-family: Arial;">
    <input type="hidden" id="qrCodeValue" value="123456789^DRUG20240101" />
      <td style="padding-left: 30px;">
        <table cellspacing="1" cellpadding="1" style="margin-left: 3%;">
          <tr>
            <td colspan="4" nowrap="nowrap">
			   <table cellspacing="1" cellpadding="1" style="margin-left: 3%;">
			    <tr>
				     <td colspan="3" rowspan="1"><div id='qrcode-1' class='divBarcodeSlipControls'></div></td> 
					 <td colspan="2"  rowspan="1">
					    <table>
						   <tr>
						   <td colspan="2"  rowspan="1">2,4 DICHLOROBENZYL A</td>						  
						   </tr>
						   <tr>						   
						   <td colspan="2"  rowspan="1">DRUG20240101 - Apr/2024 <br> 10.61 Rs</td>
						   </tr>
						</table>
					 </td>			
			   </table>
			</td>
          </tr>
        </table>
      </td>
      <td style="padding-left: 30px;">
        <table cellspacing="1" cellpadding="1" style="margin-left: 3%;">
          <tr>
            <td colspan="4" nowrap="nowrap">
			   <table cellspacing="1" cellpadding="1" style="margin-left: 3%;">
			    <tr>
			    
				     <td colspan="3" rowspan="1"><div id='qrcode-2' class='divBarcodeSlipControls'></div></td> 
					 <td colspan="2"  rowspan="1">
					    <table>
						   <tr>
						   <td colspan="2"  rowspan="1">2,4 DICHLOROBENZYL A</td>						  
						   </tr>
						   <tr>						   
						   <td colspan="2"  rowspan="1">DRUG20240101 - Apr/2024 <br> 10.61 Rs</td>
						   </tr>
						</table>
					 </td>			
			   </table>
			</td>
          </tr>
        </table>
      </td>
    </tr>
  </table> -->
</div>
		<input type="hidden" name="hmode"/>
		
	
	
</html:form>

</body>
</html>	