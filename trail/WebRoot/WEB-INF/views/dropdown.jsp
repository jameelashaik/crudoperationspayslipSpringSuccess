<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dropdown.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
     <form:form action="./employeedetails/dayspresentsave" method="post" modelAttribute="employeedetails"> 
<form:hidden  path="id"  />   
 <!--   Emp id:  <select name="empId" id="empId">
		     <c:forEach items="${emplist1}" var="emp">
		        <option value="${emp.id}">${emp.name}</option>
		    </c:forEach></select><br></br>  -->
	 number of dayspresent: <form:input path="dayspresent" />         
       <input type="submit" value="Submit" />  
        <br><br>  
	</form:form>
  </body>
</html>
