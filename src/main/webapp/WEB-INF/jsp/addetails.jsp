<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link
	href="${pageContext.request.contextPath}/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" />
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
							<h1>Tujulishe</h1>
						</div>
						<div class="span4">
							<a href="${pageContext.request.contextPath}/login">Sign In</a>
							<br/>
							<span><a href="/home">Home</a></span>
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
			<div class="span10">
				<br />
				<!-- h1>welcome to Tujulishe</h1> <br/>
    		<span>Connect, communicate, keep in touch.</span -->

				<div class="nobodders">
					<!-- form class="well" -->
					<form>
						<!-- label>Label name</label -->
						<input type="text" class="span3" placeholder="search…">
						<!--span class="help-inline">Associated
								help text!</span> < label class="checkbox"> <input
								type="checkbox"> Check me out
							</label>
							< button type="submit" class="btn">Submit</button -->
					</form>
				</div>

				<div>
					<table>
						<tr>
							<td><img
								src="${pageContext.request.contextPath}/resources/images/thumbnailtujulishelogo.png"></img></td>
						</tr>
						<tr>

							<td><span class="adText"><c:out
										value="${advert.name}" /></span><br /> <span> <!-- a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a -->
							</span> <br /> <span> from : <a href="${advert.sourceWebsite}"><c:out
											value="${advert.sourceName}" /></a> adverts
							</span></td>
						</tr>

						<tr>
							<td><a href="${advert.company.webaddress}"><c:out
										value="${advert.company.name}" /></a></td>
						</tr>
						<tr>
							<td><span style="color: red;">Deadline is :</span> <fmt:formatDate value="${advert.deadLine}" type="both"
									pattern="dd MMMM yyyy" /></td>
						</tr>

						<tr>
							<td>
								<h3>Requirements</h3>

								<div>

									<c:if test="${not empty listRequirement}">
										<table class="table table-striped">


											<c:forEach items="${listRequirement}" var="requirement">

												<tr>
													<td><span><c:out value="${requirement.name}" />
													</span><br /> <span> <!-- a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a -->
													</span> <br /></td>
												</tr>
											</c:forEach>
										</table>
									</c:if>
									<c:if test="${empty listRequirement}">
							There are no Requirements. 
				  </c:if>
								</div>


							</td>
						</tr>
						
						<tr>
							<td>
								<h3>Job Responsibilities</h3>

								<div>

									<c:if test="${not empty listResponsibility}">
										<table class="table table-striped">


											<c:forEach items="${listResponsibility}" var="responsibility">

												<tr>
													<td><span><c:out value="${responsibility.name}" />
													</span><br /> <span> <!-- a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a -->
													</span> <br /></td>
												</tr>
											</c:forEach>
										</table>
									</c:if>
									<c:if test="${empty listResponsibility}">
							There are no Responsibilities. 
				  </c:if>
								</div>


							</td>
						</tr>
						<tr>
							<td>
								<h3>Contacts</h3>
								<table>
									<tr>
										<td>You can contact <c:out value="${advert.company.name}" />
											using :
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>email: <c:out value="${advert.company.email}" /></td>
						</tr>
						<tr>
							<td>website: <c:out value="${advert.company.webaddress}" /></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="span2">
				<br />
				<!-- 
    	<form:form accept-charset="UTF-8" action="main" autocomplete="off" class="home-signup" modelAttribute="projectUser">
    	<div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="oIUnZW17rd+yyLcJHLyM6f+xx4VB+Xa9M5IonS42KKA=" /></div> 
    	  <dl class="form">
            <dd>
            	<form:input path="firstName"  type="text" name="firstName" class="textfield" placeholder="Provide First Name"  />
            </dd>
          </dl>
          
           <dl class="form">
            <dd>
            	<form:input path="lastName"  type="text" name="lastName" class="textfield" placeholder="Provide Last Name"/>
            </dd>
          </dl>

          <dl class="form">
            <dd>
              <form:input path="email"  type="text" name="email" class="textfield" placeholder="Your email" />
            </dd>
          </dl>

          <dl class="form">
            <dd>
              <form:input path="password" type="password" name="password" class="textfield" placeholder="Provide Password" />
              <p class="note">Tip: use at least one number and at least 7 characters.</p>
            </dd>
          </dl>

         

          <button class="btn btn-success" type="submit">Sign up for free</button>
</form:form> -->

			</div>

		</div>

	</div>
</body>
</html>