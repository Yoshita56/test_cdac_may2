<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="java.io.*" %>
<%@ page import ="java.util.*,java.text.*" %> 
<%@page import="hisglobal.hisconfig.*,hisglobal.utility.HisUtil,billing.BillConfigUtil,org.apache.commons.io.FileUtils"%>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
<meta charset=utf-8><title>Server Log Report</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css" media="print">
<script type="text/javascript"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../transUtil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<style type='text/css'>
.SLIPCONTROL {
	
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-style: normal;
}
.SLIPCONTROLBOLD {
	
	font-family: Courier New;;
	font-size: 16px;
	font-style: inherit;
	font-weight: bold;
}

pre{
	max-width:700px;
  	word-wrap:break-word;

}

@media print {thead {display: table-header-group;}}
</style>
</head>
<body>
<form action="/reports/ApplicationErrorLogDetailRptCNT.cnt" method="post">
			
	<table  width="100%" cellspacing="0"  cellpadding="0">
		<tr>
			<td><div align="center"><b>SERVER LOGS/ SYSTEM SETTINGS</b></div></td>
		</tr>
		<tr>
			<td width="100%">	
			<%
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
		    %>
		    </td>
		</tr>		
	</table>
</form>
</body>
</html>