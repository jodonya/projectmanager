<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Project Management - ASAL - Setup</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/resources/css/projectmanager.css" media="all" rel="stylesheet" type="text/css"/>
</head>
<body>

 <div class="container">
  
  	<div class="row"><br/>
 			<div class="span12">
 				<div class="row">
 						<div class="span8"><h1 class="page-header">Project Management - Setup</h1></div>
 						<div class="span4"><span>Welcome <c:out value="${logedInUser.firstName}"></c:out>  <c:out value="${logedInUser.lastName}"></c:out></span> | <a href="/projectmanager/logout.html">Logout</a> | <a href="/projectmanager/index.html">Home</a></div>
 				</div>
 			</div>
 		</div>
    
   
    <div class="row"><br/>
    	<div class="span6"><br/>
    	<div>
    	<form:form class="form-horizontal" action="role.html" modelAttribute="role"> 
    		<!--  form class="form-horizontal"-->  
        <fieldset>  
          <legend>Role</legend> 
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
            	
              <form:input path="name" type="text" class="input-xlarge"   id="name" name="name"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="description">Description</label>  
            <div class="controls">  
              <form:textarea path="description" class="input-xlarge"   id="description" rows="3"/>  
            </div>  
          </div>
        
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Add Role</button>  
            <button class="btn">Cancel</button>  
          </div>  
        </fieldset>  
		</form:form>
		</div>
		<div>
     <legend>Role List</legend> 
 
 	 <c:if test="${not empty roleList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Name</th>  
            <th>Description</th>
            <th></th>  
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${roleList}" var="role">	
         		<tr>  
            		<td><c:out value="${role.name}" /></td>  
            		<td><c:out value="${role.description}" /> </td> 
            		<td><a href="roles/${role.id}">Delete</a></td> 
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty roleList}" >
				There are no roles yet. 
	  </c:if>


      	</div>
      	<div>
      	<!--  
      		********Location **************
      	 -->
      	 <form:form class="form-horizontal" action="location.html" modelAttribute="location"> 
      	     		<!--  form class="form-horizontal"-->  
        <fieldset>  
          <legend>Location</legend> 
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
              <form:input path="name" type="text" class="input-xlarge" id="name" name="name"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="description">Description</label>  
            <div class="controls">  
              <form:textarea path="description"  class="input-xlarge" id="description" rows="3"/>  
            </div>  
          </div>
        
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Add Location</button>  
            <button class="btn">Cancel</button>  
          </div>  
        </fieldset>  
		</form:form>
		</div>
		<div>
    		<legend>Locations List</legend> 
			
		<c:if test="${not empty locationList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Name</th>  
            <th>Description</th>
            <th></th>
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${locationList}" var="location">	
         		<tr>  
            		<td><c:out value="${location.name}" /></td>  
            		<td><c:out value="${location.description}" /> </td>
            		<td><a href="locations/${location.id}">Delete</a></td>
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty locationList}" >
				There are no locations yet. 
	  </c:if>

      	 </div>
      	 <!-- Location End -->
      
    	</div>
    	<div class="span6"><br/>
    	<div>
    		 <form:form class="form-horizontal" action="projecttype.html" modelAttribute="projectType">
     		<!-- form class="form-horizontal" -->  
        <fieldset>  
          <legend>Project Type</legend> 
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
              <form:input path="name"  type="text" class="input-xlarge" id="name" name="name"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="description">Description</label>  
            <div class="controls">  
              <form:textarea path="description" class="input-xlarge" id="description" rows="3"/>  
            </div>  
          </div>
        
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Add Type</button>  
            <button class="btn">Cancel</button>  
          </div>  
        </fieldset>  
		</form:form>
		</div>
		<div>
    		<legend>Types List</legend> 
			
		<c:if test="${not empty projectTypeList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Name</th>  
            <th>Description</th>
            <th></th>  
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${projectTypeList}" var="projectType">	
         		<tr>  
            		<td><c:out value="${projectType.name}" /></td>  
            		<td><c:out value="${projectType.description}" /> </td>
            		<td><a href="projecttypes/${projectType.id}">Delete</a></td>  
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty projectTypeList}" >
				There are no Project Types yet. 
	  </c:if>
	  </div>
	  <div>
    		<!-- End Project Type -->
    		<!-- Start Project Status -->
    	 <form:form class="form-horizontal" action="projectstatus.html" modelAttribute="projectStatus">	
    	<!--  form class="form-horizontal"-->  
        <fieldset>  
          <legend>Project Status</legend> 
          <div class="control-group">  
            <label class="control-label" for="name">Name</label>  
            <div class="controls">  
              <form:input path="name"  type="text" class="input-xlarge" id="name" name="name"/>    
            </div>  
          </div>
          <div class="control-group">  
            <label class="control-label" for="description">Description</label>  
            <div class="controls">  
              <form:textarea path="description"   class="input-xlarge" id="description" rows="3"/>  
            </div>  
          </div>
        
          <div class="form-actions">  
            <button type="submit" class="btn btn-primary">Add Status</button>  
            <button class="btn">Cancel</button>  
          </div>  
        </fieldset>  
		</form:form>
		</div>
		<div>
    		<legend>Status List</legend> 
			
		 <c:if test="${not empty projectStatusList}" >
		<table class="table table-striped">  
        <thead>  
          <tr>  
            <th>Name</th>  
            <th>Description</th>  
            <th></th>
         </tr>  
         </thead>
         <tbody>  
         	<c:forEach items="${projectStatusList}" var="projectStatus">	
         		<tr>  
            		<td><c:out value="${projectStatus.name}" /></td>  
            		<td><c:out value="${projectStatus.description}" /> </td>
            		<td><a href="projectstatuses/${projectStatus.id}">Delete</a></td>  
          		</tr>  
          	</c:forEach>
	 	</tbody>  
      	</table>  
      </c:if>
      <c:if test="${empty projectStatusList}" >
				There are no Statuses yet. 
	  </c:if>

    		</div>
    		<!-- End Project Status -->
    	</div>    
    </div>
 	   
 </div>
</body>
</html>