<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Tujulishe</title>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	media="all" rel="stylesheet" type="text/css" />
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.9.0.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/projectmanager.js"></script>
</head>
<body>

	<div class="container">

		<div class="row">
			<br />
			<div class="span12">
				<br />
				<div>
					<div class="row">
						<div class="span8">
							<h1>Tujulishe - Ad Listing</h1>
						</div>
						<div class="span4">
							<!--  a href="${pageContext.request.contextPath}/login">Sign In</a -->
							<span>Add Businesses and Adverts !</span>
						</div>
					</div>


				</div>
			</div>
			<div class="span2">
				<br />
				<!-- Login Form place holder -->


			</div>
		</div>


		<div class="row">
			<br />
			<div class="span6">
				<br />
				
				<!-- Business Listing Starts Here -->
				
				<div>
					
					<c:if test="${not empty listCompany}" >
					<table class="table table-striped">  
			      
			         <tbody>  
			         	<c:forEach items="${listCompany}" var="company">	
			         		<tr>  
			            		<td class="adText"> <a href="/advert/${company.id}"> <c:out value="${company.name}" /></a> <br/>
			            		<br/>
			            		<hr/>
			            			<span>|<a href="/companyphotos/${company.id}">Add Photo</a>|</span>
			            		</td>  
			            		<td><c:out value="${company.location}" /> </td> 
			            		<td><c:out value="${company.phoneNo}" /> </td> 
			            		<td><a href="company/${company.id}">Delete</a></td> 
			          		</tr>  
			          	</c:forEach>
			      	</table>  
			      </c:if>
			      <c:if test="${empty listCompany}" >
							There are no companies/businesses yet. 
				  </c:if>
					</div>
	
	
			</div>

			<div class="span6">
				<br />

				<div class="nobodders">
					<div>
						<form:form class="form-horizontal"  action="advert" modelAttribute="company">
							<fieldset>
								<legend>Register Business</legend>
								<div class="control-group">
									<label class="control-label" for="input01">Name</label>
									<div class="controls">
										<form:input path="name" type="text"  class="input-xlarge" id="name"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="textarea">Physical
										Location</label>
									<div class="controls">
										<form:textarea  path="location"  class="input-xlarge" id="location" rows="3"></form:textarea>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="input01">Contact
										Person</label>
									<div class="controls">
										<form:input path="contactPerson" type="text" class="input-xlarge" id="contactPerson"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="input01">Phone No.</label>
									<div class="controls">
										<form:input  path="phoneNo" type="text" class="input-xlarge" id="phoneNo"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="input01">Email</label>
									<div class="controls">
										<form:input path="email" type="text" class="input-xlarge" id="email"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="input01">Website</label>
									<div class="controls">
										<form:input path="webaddress" type="text" class="input-xlarge" id="webaddress"/>
										<!-- p class="help-block">In addition to freeform text, any HTML5 text-based input appears like so.</p -->
									</div>
								</div>
								<div class="form-actions">
									<button type="submit" class="btn btn-primary">Save
										Business</button>
									<button class="btn">Cancel</button>
								</div>
							</fieldset>
						</form:form>
					</div>

				</div>


			</div>

		</div>

	</div>
</body>
</html>