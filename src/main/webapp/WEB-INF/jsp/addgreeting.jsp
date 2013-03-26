<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<title>Project Management</title>
	<link href="resources/css/bootstrap.css" media="all" rel="stylesheet" type="text/css"/>
</head>
 
<body>
 <div class="container">
<h1>Project Manager</h1>
<form:form action="greetings.html" modelAttribute="greetingForm"> 	
	<table>
		<tr>
			<td>Add your greeting:</td>
                        <td><form:input path="greeting.greetingText" size="100"/></td>
		</tr>
		<tr>
			<td>What's your favorite color?</td>
			<td> 
				<form:select path="color.colorCode">
            		<form:option value="" label="--Please Select"/>
            		<form:options items="${colorList}" itemValue="colorCode" itemLabel="colorName"/>
        		</form:select>
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Submit" />	
			</td>
		</tr>
	</table>
</form:form>
 </div>
</body>
</html>