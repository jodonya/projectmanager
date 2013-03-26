<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Project Management - ASAL - Login</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
	<link href="resources/css/bootstrap.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="resources/css/projectmanager.css" media="all" rel="stylesheet" type="text/css"/>
</head>
<body onload='document.f.j_username.focus();'>
	<div class="container">
	<div class="row"><br/>
	<div class="span4"> <br/>
	
	</div>
	<div class="span4"> <br/>
		<!-- Start of Middle Column -->
		<h3>Project Manager Login </h3>
 
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
 
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		<table>
			<tr>
				<td>Email:</td>
				<td><input type='text' name='j_username' value=''>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td colspan='2' align="center"><input name="submit" type="submit"
					value="Login" class="btn btn-primary" /> <input name="reset" type="reset" value="Cancel" class="btn" />
				</td>
				<td colspan='2'>
				</td>
			</tr>
			<tr>
				
			</tr>
		</table>
 
	</form>
		<!-- End of Middle Column -->
	</div>
	<div class="span4"> <br/>
	
	</div>
	
	</div>
	</div>
</body>
</html>