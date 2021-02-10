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
    
    <title>My JSP 'payslipemp.jsp' starting page</title>
    
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
	#head1{
	background-color:black;
	color:white;
	}
	</style>
  </head>
  
  <body>

  <%float totaldays=30; %>
  <% float basic_sal=0; 
  	int pid=0;
  	String pname=null;
  	String ppancard=null;
  	int pdayspresent=0;
  	
  %>
  <%
  	float basic_pay = 0;
  	float da = 0;
  	float hra = 0;
  	float pf = 0;
  	float pt = 0;
  	float net_salary = 0;
  	float gross_total =0;
  	gross_total = ((basic_sal/totaldays)*(pdayspresent));
  	basic_pay = (int) ((0.4) * (gross_total));
  	da = (int) ((0.3) * (gross_total));
  	hra = (int) ((0.3) * (gross_total));
  	pf = (int) ((0.125) * (gross_total));
  	if (gross_total < 15000) {
  		pt = 150;
  	} else {
  		pt = 200;
  	}
  	net_salary = ((gross_total) - (pf + pt));
  %>
	
	<div class="container col-xs-12 col-sm-12 col-md-11 col-lg-11">
	<table class="table table-control table-striped table-bordered table-condensed table-hover">
		<thead>
			<tr id="head1">
			<th colspan="12"><h1>Employees payslip List</h1></th>
			</tr>
			<tr>
			<th>EmpId</th><th>Name</th><th>grosstotal</th>
			<th>dayspresent</th><th>Salary</th><th>basicpay</th><th>DA</th><th>HRA</th><th>PF</th><th>PT</th><th>NETSALARY</th> 
			</tr>
		</thead>
		<tbody>
			<tr>
   <c:forEach var="emp" items="${emplistp}">   
	   <tr>  

	   <td>${emp.id}</td>  
	   <td>${emp.name}</td>  
	   <td>${emp.salary}</td>  
	   <td>${emp.dayspresent}</td>  
	   <td>${emp.salary}</td> 
	   <td>${emp.salary/30*emp.dayspresent} </td> 
	   <td>${(0.3)*(emp.salary/30*emp.dayspresent)}</td> 
	   <td>${(0.3)*(emp.salary/30*emp.dayspresent)}</td> 
	   <td>${(0.125)*(emp.salary/30*emp.dayspresent)}</td> 
	   <td>${(0.1)*(emp.salary/30*emp.dayspresent)}</td>
	   <td>${(emp.salary/30*emp.dayspresent)-(((0.125)*(emp.salary/30*emp.dayspresent))+((0.1)*(emp.salary/30*emp.dayspresent)))}</td>  
	   </tr>  
   </c:forEach> 
			</tr>
		</tbody>
	</table>   
	 </div> 		
  </body>
</html>
