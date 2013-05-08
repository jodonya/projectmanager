<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	
		<link href="${pageContext.request.contextPath}/resources/datepicker/css/bootstrap-responsive.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/resources/datepicker/css/datepicker.css" media="all" rel="stylesheet" type="text/css"/>
	
    
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
     href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.min.css">	
	
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
							<h2>
								<c:out value="${advert.company}" />
							</h2>
							<br/>
							<h3>
								<c:out value="${advert.name}" /> - Add Details
							</h3>
							
						</div>
						<div class="span4">
							<!--  a href="${pageContext.request.contextPath}/login">Sign In</a -->
							<span>Add Businesses and Adverts !</span>
							<br/>
							<div style="float: right;">
								<a href="/advert">Business Listing</a> <br/>
								<a href="/advert/${advert.company.id}"><c:out value="${advert.company}" /> adverts</a>
							</div>
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
				<!-- h1>Ad Listing</h1 -->
				<br />
				<!-- span>Registered to Post Ads.</span -->
				<br />
				<div class="nobodders">
					<div>
						<form:form class="form-horizontal" action="/addrequirement/${advert.id}" modelAttribute="advertRequirement" >
							<fieldset>
								<legend>Add Requirement</legend>
								<div class="control-group">
									<label class="control-label" for="textarea">Requirement </label>
									<div class="controls">
										<form:textarea path="name" class="input-xlarge" id="requirementName" rows="10"></form:textarea>
									</div>
								</div>
								<div class="form-actions">
									<form:button type="submit" class="btn btn-primary">Save
										Requirement</form:button>
									<form:button class="btn">Cancel</form:button>
								</div>
							</fieldset>
						</form:form>
					</div>
					
					<div>
						<form:form class="form-horizontal" action="/addresponsibility/${advert.id}" modelAttribute="advertResponsibility" >
							<fieldset>
								<legend>Add Responsibility</legend>
								<div class="control-group">
									<label class="control-label" for="textarea">Responsibilty </label>
									<div class="controls">
										<form:textarea path="name" class="input-xlarge" id="responsibilityName" rows="10"></form:textarea>
									</div>
								</div>
								<div class="form-actions">
									<form:button type="submit" class="btn btn-primary">Save
										Responsibilty</form:button>
									<form:button class="btn">Cancel</form:button>
								</div>
							</fieldset>
						</form:form>
					</div>
					

				</div>
			</div>

			<div class="span6">

				<!-- Ads Listing Starts here -->
				<br />
				<h3>Requirements Listing</h3>
				<br/>

				<div>
					<c:if test="${not empty listRequirements}">
						<table class="table table-striped">

							<tbody>
								<c:forEach items="${listRequirements}" var="requirement">
									<tr>
										<td><c:out value="${requirement.name}" /></td>
										<td><a href="company/${requirement.id}">Delete</a></td>
									</tr>
								</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty listRequirements}">
							There are no Requirements yet. 
				  </c:if>
				</div>
				
				<br />
				
				<h3>Responsibilities</h3>
				<br/>
				<div>
				
					<c:if test="${not empty listResponsibilities}">
						<table class="table table-striped">

							<tbody>
								<c:forEach items="${listResponsibilities}" var="responsibility">
									<tr>
										<td><c:out value="${responsibility.name}" /></td>
										<td><a href="company/${responsibility.id}">Delete</a></td>
									</tr>
								</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty listResponsibilities}">
							There are no Responsibilities yet. 
				  </c:if>
				</div>
				</div>



			</div>

		</div>
</body>
</html>