<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewemp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<style>
.head1{
	align:center;
	background-color:black;
	color:white;
</style>
  </head>
  
  <body>
    This is my viewemp page. <br>
    <h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>dayspresent</th><th>Edit</th><th>Delete</th><th>payslip</th></tr>  
   <c:forEach var="emp" items="${emplist}">   
	   <tr>  

	   <td>${emp.id}</td>  
	   <td>${emp.name}</td>  
	   <td>${emp.salary}</td>  
	   <td>${emp.designation}</td>  
	   <td><a href="employeedetails/dayspresent/${emp.id}">dayspresent</a></td>
	   <td><a href="employeedetails/editemp/${emp.id}">Edit</a></td>  
	   <td><a href="employeedetails/deleteemp/${emp.id}">Delete</a></td>  
	   <td><a href="employeedetails/payslipemp/${emp.id}">payslip</a></td>
	   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>  
  </body>
</html>
