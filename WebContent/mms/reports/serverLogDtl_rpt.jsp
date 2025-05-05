<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ page import="java.io.*" %>
<%@ page import ="java.util.*,java.text.*" %> 
<%@ page import="hisglobal.hisconfig.*,hisglobal.utility.HisUtil,billing.BillConfigUtil,org.apache.commons.io.FileUtils"%>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
<meta charset=utf-8><title>Server Log Report</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css"> 


<script type="text/javascript"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../transUtil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<style type='text/css'>

pre
{
	/* max-width:700px;
  	word-wrap:break-word; */
}
.i-circle {
    background: #007bff;
    color: #fff;
    padding: 1px 10px;
    border-radius: 50%;
    
}
@media print {thead {display: table-header-group;}}

ul, #myUL {
  list-style-type: none;
}
ul, #myULs {
  list-style-type: none;
}

#myUL {
  margin: 0;
  padding: 0;
}
#myULs {
  margin: 0;
  padding: 0;
}

.caret {
  cursor: pointer;
  -webkit-user-select: none; /* Safari 3.1+ */
  -moz-user-select: none; /* Firefox 2+ */
  -ms-user-select: none; /* IE 10+ */
  user-select: none;
}

.caret::before {
  content: "\f152";
  color: #0087ff;
  display: inline-block;
  margin-right: 6px;
  font-family: 'Font Awesome 5 Free';
  font-weight: 400;
}

.caret-down::before {
  -ms-transform: rotate(90deg); /* IE 9 */
  -webkit-transform: rotate(90deg); /* Safari */'
  transform: rotate(90deg);  
}

.nested {
  display: none;
}

.active {
  display: block;
}
.file
{
color: rgba(249, 29, 6, 0.7);
}

</style>
</head>
<body>
<form action="/reports/ApplicationErrorLogDetailRptCNT.cnt" method="post">
<div class="container-fluid">
<div class="prescriptionTile">			
	<div class="row rowFlex reFlex">
			<div class="col-sm-12" align="center">
				<h5>SERVER LOGS/ SYSTEM SETTINGS/DEPLOYED APPLICATIONS/FTP DIRECTORY</h5>
			</div>
	</div>
			<%
					if(session.getAttribute("serverFilePath")!=null)						
					{
						String file=session.getAttribute("serverFilePath").toString();
						//System.out.println("serverFilePath"+file);
						//String file="E:/server.log";		
					
						try
						{
							File fileObj=new File(file);
							long fileSize = FileUtils.sizeOf(fileObj);							
							//System.out.println(fileSize/(1024*1024) + " bytes");
							
							if(Math.round(fileSize/(1024*1024))>40)
							{
								out.println("<center><font color='red'><h3>File Size is Too Large (>40 MB)</h3></font></center>");
							}
							else
							{	
								BufferedReader reader = new BufferedReader(new FileReader(file));
							    StringBuilder sb = new StringBuilder();
							    String line;
							    while((line = reader.readLine())!= null)
							    {
							    	sb.append(line+"\n");
							    }
							    if(file.contains("hisPath.xml") || file.contains("standalone.xml") || file.contains("module.xml"))
							    	out.println("<textarea rows='65' cols='173'>"+sb.toString()+"</textarea>");
							    else
							    	out.println("<pre>"+sb.toString()+"</pre>");
							    
							    reader.close();
							}
						}
						catch(FileNotFoundException f)
						{
							out.println("<center><font color='red'><h3>No Log File Found at "+file+" </h3></font></center>");
						}
						catch(Exception e)
						{
							out.println("<center><font color='red'><h3>Error While Reading File !!! </h3></font></center>");
						}
						finally
						{
							
						}
					}
					else
					{
				%>
						<hr>
						<bean:write name="applicationErrorLogDetailRptFB" property="strData" filter="false"/>						
				<%		
					}
				%>		    
		    
</div>
</div>	
</form>
<script>
var toggler = document.getElementsByClassName("caret");
var i;

for (i = 0; i < toggler.length; i++) {
  toggler[i].addEventListener("click", function() { 
    this.parentElement.querySelector(".nested").classList.toggle("active");
    this.classList.toggle("caret-down");
  });
}

</script>
</body>
</html>