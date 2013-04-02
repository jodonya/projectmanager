<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Project Management - ASAL</title>
	<link href="resources/css/bootstrap.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="resources/css/projectmanager.css" media="all" rel="stylesheet" type="text/css"/>
</head>
<body>

 <div class="container">
  
  	<div class="row"><br/>
  			<div class="span12"> <br/>
  			<div>
  				<div class="row">
  					<div class="span8"><h1 class="page-header">ASAL Project Management</h1></div>
  					<div class="span4"><span>Welcome <c:out value="${logedInUser.firstName}"></c:out>  <c:out value="${logedInUser.lastName}"></c:out></span> | <a href="/projectmanager/logout.html">Logout</a> </div>
  				</div>
  				
  					
  				</div>
  			</div>
  			<div class="span2"> <br/>
  				<!-- Login Form place holder -->
  				
  				
  			</div>
  	</div>
    
   
    <div class="row"><br/>
    	<div class="span6"><br/>
    		<div>
    		<legend>Projects List</legend> 
    		<p>
    			<!--  a href="/projectmanager/addgreeting.html">Add Project</a>|
				<a href="/projectmanager/greetings.html">Show all Projects</a>|  -->
				<a href="/projectmanager/project.html">Add Project</a>|
				<a href="/projectmanager/setup.html">Setup</a> 
			</p>
			
			
			<c:if test="${not empty projectList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Code</th>  
            <th>Name</th>
            <th>Location</th> 
            <th>Status</th>
            <th></th>
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${projectList}" var="project">	
         		<tr>  
            		<td><c:out value="${project.code}" /></td>  
            		<td><a href="projects/${project.id}"><c:out value="${project.name}" /> </a></td>  
            		<td><c:out value="${project.location.name}" /> </td>  
            		<td><c:out value="${project.projectStatus.name}" /> </td>
            		<td><a href="projects/${project.id}">Delete</a></td>  
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty projectList}" >
				There are no Projects yet. 
	  </c:if>
		</div>
    	</div>
    	<div class="span6"><br/>
    	<div>
    	<!--   h2>Register User</h2 -->
    		<!-- Start User Register -->
    		<form:form action="index.html" modelAttribute="projectUser">
    		<!--  form class="form-horizontal"-->  
        <fieldset>  
          <legend>Register User</legend> 
          <div class="control-group">  
            <label class="control-label" for="firstName">First Name</label> 
            <font color="red"><form:errors path="firstName" /></font>
            <div class="controls">  
              <form:input path="firstName" type="text" class="input-xlarge" id="firstName" name="firstName"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="lastName">Last Name</label> 
            <font color="red"><form:errors path="lastName" /></font> 
            <div class="controls">  
              <form:input path="lastName" type="text" class="input-xlarge" id="lastName" name="lastName"/>
            </div>  
          </div>  
          <div class="control-group">  
            <label class="control-label" for="emailAddress">Email</label>  
            <font color="red"><form:errors path="email" /></font>
            <div class="controls">  
              <form:input path="email" type="text" class="input-xlarge" id="emailAddress" name="emailAddress"/>
            </div>  
          </div>  
          
          <div class="control-group">  
            <label class="control-label" for="password">Password</label>  
            <div class="controls">  
              <form:input path="password" type="password" class="input-xlarge" id="password" name="password"/>
            </div>  
          </div>  
          
           <div class="control-group">  
            <label class="control-label" for="passwordConfirm">Password Confirm</label>  
            <div class="controls">  
              <input type="password" class="input-xlarge" id="passwordConfirm" name="passwordConfirm"/>
            </div>  
          </div>  
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Save User</button>  
            <button class="btn">Cancel</button>  
          </div>  
        </fieldset>  
		</form:form>
		</div>
		<div>
		<legend>User Listing</legend> 
		<c:if test="${not empty projectUserList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Names</th>  
            <th>Email Address</th>
            <th></th>
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${projectUserList}" var="projectUser">	
         		<tr>  
            		<td><c:out value="${projectUser.firstName}" /><c:out value="  " /><c:out value="${projectUser.lastName}" /></td>  
            		<td><c:out value="${projectUser.email}" /> </td>  
            		<td><a href="users/${projectUser.id}">Delete</a></td>
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty projectUserList}" >
				There are no Users yet. 
	  </c:if>
    		<!-- End User Register -->
    	</div>
    	</div>    
    </div>
 	   
 </div>
</body>
</html>