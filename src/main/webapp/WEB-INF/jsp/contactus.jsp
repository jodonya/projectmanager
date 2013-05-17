<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Tujulishe - Job Advertisements - Checkout who is hiring</title>
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
							<div id="mainheader">
								<h1>Tujulishe</h1>
								<br /> <br />

							</div>
							<span id="keynote">jobs jobs jobs!</span>
						</div>
						<div class="span4 signuptext">
							<c:if test="${empty logedInUser}">
								<a href="${pageContext.request.contextPath}/login">Sign In</a>

							</c:if>
							<c:if test="${ not empty logedInUser}">
								<span style="font-size: 14; font-weight: bold;">Hi! <c:out
										value="${logedInUser}"></c:out></span>
							</c:if>
							<span style="font-size: 12;">|</span> <span><a
								href="/home">Home</a></span>
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
				<div>
					A product of Dachi Ltd <br /> Location: Vedic House, Mama Ngina
					Street, Nairobi. <br /> Email : tujulishe@dachi.co.ke <br />

					Twitter Handle: @tujulishe <br />
				</div>
			</div>

			<div class="span2">
				<br />


			</div>

		</div>

	</div>
</body>
</html>