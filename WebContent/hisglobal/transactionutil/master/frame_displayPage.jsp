  <!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Transaction in Frames</title>
</head>
<meta charset=utf-8>
<frameset cols="15%%,70%,15%" target="_self">
	<frame frameborder="0" noresize="noresize" scrolling="no" id="frame1" name="frame1" src='../../hisglobal/transactionutil/master/frame_buttonLayOut1.jsp?cnt_page=<%=(String)request.getAttribute("cnt_page")%>'>
	<frame frameborder="0" noresize="noresize" scrolling="no" id="frame2" name="frame2" src="../../hisglobal/transactionutil/master/frame_list_page.jsp?cnt_page=<%=(String)request.getAttribute("cnt_page")%>">		
	<frame frameborder="0" noresize="noresize" scrolling="no" id="frame3" name="frame3" src='../../hisglobal/transactionutil/master/frame_buttonLayOut2.jsp?cnt_page=<%=(String)request.getAttribute("cnt_page")%>'>
</frameset>

</html>