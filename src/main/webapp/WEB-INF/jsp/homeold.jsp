<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<c:choose>
	<c:when test="${not empty company}">

		<title><c:out value="${company.name}" />- Jobs - tujulishe.com
		</title>

	</c:when>
	<c:when test="${not empty advertCategory}">

		<title><c:out value="${advertCategory.name}" />- Jobs -
			tujulishe.com</title>

	</c:when>
	<c:otherwise>
		<title>Tujulishe - Jobs Advertisements in Kenya - Checkout who
			is hiring</title>
	</c:otherwise>
</c:choose>

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

		<div class="row topmost">
			<br />
			<div class="span12">
				<br />
				<div>
					<div class="row">
						<div class="span8">
							<!--img alt="Job" src="${pageContext.request.contextPath}/resources/images/job.jpg"/-->
							<div id="mainheader">
								<h1>Tujulishe</h1>
								<br /> <br />

							</div>
							<span id="keynote">Who is hiring?</span>

						</div>
						<div class="span4 signuptext">
							<c:if test="${empty logedInUser}">
								<a href="${pageContext.request.contextPath}/login">Sign In</a>

								<br />
							</c:if>
							<c:if test="${ not empty logedInUser}">
							<span style="font-size: 14; font-weight: bold;">Hi! <c:out
										value="${logedInUser}"></c:out></span>
								<br />
								<span> <a
									href="${pageContext.request.contextPath}/logout">Logout</a>
								</span>
							</c:if>
							<hr />
							<!-- a href="${pageContext.request.contextPath}/home">All Adverts</a> <br/> <br/ -->
							<a href="${pageContext.request.contextPath}/contactus">Contact
								Us</a><br />
							<br /> 
							<c:if test="${ empty logedInUser}">
							<span style="font-size: 12px">Not a member? </span> <a
								href="/main">Register!</a>
								<br /><br/> 
								</c:if>
								<a style="font-size: 12px;"
								href="/home">Active Adverts!</a> <span style="font-size: 12px;">|</span> <a style="font-size: 12px;"
								href="/homeexpired">Expired Adverts!</a>
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
						<!-- input type="text" class="span3"
								placeholder="search…" -->
						<!--span class="help-inline">Associated
								help text!</span> < label class="checkbox"> <input
								type="checkbox"> Check me out
							</label>
							< button type="submit" class="btn">Submit</button -->
					</form>
				</div>

				<div>

					<c:if test="${not empty listAdvert}">
						<table class="table table-striped">


							<c:forEach items="${listAdvert}" var="advert">

								<tr>
									<td>
										<!-- img src="${pageContext.request.contextPath}/resources/images/thumbnailtujulishelogo.png"></img -->
										<c:choose>
											<c:when test="${empty advert.company.companyPhoto}">

												<img
													src="${pageContext.request.contextPath}/resources/images/thumbnailtujulishelogo.png"></img>

											</c:when>
											<c:otherwise>
												<img
													src="${pageContext.request.contextPath}/companyphotothumbnail/${advert.company.companyPhoto.id}" />
											</c:otherwise>
										</c:choose>

									</td>
									<td><span class="adText"><c:out
												value="${advert.name}" /> </span><br /> <span> <c:if
												test="${not empty advert.categoryList}">
												<c:forEach items="${advert.categoryList}" var="category">
													<a href="/home/category/${category.id}"><c:out
															value="${category.name}" /></a> | 
										</c:forEach>
											</c:if> <!-- a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a -->
									</span> <br /> <span> source : <a
											href="${advert.sourceWebsite}">${advert.sourceName}</a>
											Adverts
									</span></td>
									<td><a href="/home/company/${advert.company.id}"><c:out
												value="${advert.company.name}" /></a></td>
									<td><span style="color: red;">Deadline</span> <br />
									<fmt:formatDate value="${advert.deadLine}" type="both"
											pattern="dd MMMM yyyy" /></td>
									<td><a href="/addetails/${advert.id}">Full Details</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
					<c:if test="${empty listAdvert}">
							There are no Adverts yet. 
				  </c:if>
				</div>

				<!-- div>
						<table>
							<tr>
								<td><img src="${pageContext.request.contextPath}/resources/images/thumbnailfinlayimage.jpg"></img></td>
								<td><span class="adText">Regional Financial Controller Eastern
									Africa </span><br />
									<span>
										<a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a>
									</span> <br/>
									<span>
										<a href="http://www.nation.co.ke/">from The Daily Nation adverts</a>
									</span>
									

								</td>
								<td><a href="http://www.utangranser.se/eng/">Swedish Corporative Center</a>	
								</td>
								<td>Deadline is 20/05/2013</td>
								<td><a href="/addetails">Details</a></td>
							</tr>

							<tr>
								<td><img src="${pageContext.request.contextPath}/resources/images/thumbnailfinlayimage.jpg"></img></td>
								<td>
									<span class="adText">Assistant Research Manager</span><br/>
									<span>
										<a href="">Business</a>| <a href="">Account</a>| <a href="">ICT</a>
									</span>	<br/>
									
									<span>
										<a href="http://www.nation.co.ke/">from The Daily Nation adverts</a>
									</span>
																
								
								</td>
								<td><a href="http://www.finlays.net/">Finlays</a></td>
								<td>Deadline is 20/05/2013</td>
								<td><a href="/addetails">Details</a></td>
							</tr>

						</table>
					</div -->
			</div>

			<div class="span2">
				<br /> <span>Click on Category to filter adverts by Category!</span>
				<br /> <br />
				<c:if test="${not empty listCategory}">
					<c:forEach items="${listCategory}" var="category">
						<span><a href="/home/category/${category.id}"><c:out
									value="${category.name}" /></a></span>
						<br />
					</c:forEach>
				</c:if>

				<br /> <br /> <span>Click on Category to filter adverts by
					Company!</span> <br /> <br />
				<c:if test="${not empty listCompany}">
					<c:forEach items="${listCompany}" var="company">
						<span><a href="/home/company/${company.id}"><c:out
									value="${company.name}" /></a></span>
						<br />
					</c:forEach>
				</c:if>
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