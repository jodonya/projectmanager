<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<!--link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	media="all" rel="stylesheet" type="text/css" / -->
<!--link
	href="${pageContext.request.contextPath}/resources/css/projectmanager.css"
	media="all" rel="stylesheet" type="text/css" / -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/functions.js">
        </script>
    </head>
    <body>
        <div class="row-top-segment">
        </div>
        <div class="row-top">
            <!-- logo -->
            <div class="logo">
            </div>
            <!-- <span class="font-header-8">Select Town</span> --><!-- buttons -->
            <div class="navirow">
                <div class="header-navirow">
                    <ul class="sf-menu">
                        <li class=" home">
                            <a href="/home">HOME</a>
                        </li>
                        <li class="photoshop">
                            <a href="/aboutus">ABOUT US</a>
                        </li>
                        <li class=" icons">
                            <a href="/contactus">CONTACT US</a>
                        </li>
                        <li class="active design ">
                            <a href="/main">Sign Up</a>
                        </li>
                    </ul>
                </div>
                <!-- search -->
                <div class="second-layer">
                    <form class="input-append pull-right" method="GET" action="/search/">
                        <input type="text" class="select2-search" autocomplete="off" tabindex="-1">
                    </form><span class="login-cred"><a href="">Welcome Japheth</a></span>
                    <span class="logout"><a href="">Logout</a></span>
                </div>
            </div>
        </div>
        <div class="advert-holder">
            <span class="advert">Who is hiring? </span>
            <span class="advert2"> Tujulishe Platform </span>
            <div class="advertexpired"><span style="float: right;"><a href="/home">All Active Jobs</a> | <a href="/homeexpired">Expired Jobs (Old)</a> </span><br/> <span style="float: right;">  Sort By <a href="/homebyexpiry">Expiry</a> | <a href="/homebydateposted">Posted</a></span></div>
        </div>
        <div class="middle-body">
            <div class="right-panel">
            	
            	<div class="side_div">
                    <div class="side_header_design">
                    	<span class="groupedheader"> Unexpired Jobs Added</span>
                      
                    </div>
                    <article class="spacing-3">
                    
                    	
						<div class="sidelink">
                           <span><a href="/todayads">Today (10)</a></span>
                        </div>
                        <div class="sidelink">
                           <span><a href="/yesterdayads">Yesterday (5)</a></span>
                        </div>
                        
                        <div class="sidelink">
                           <span><a href="/lastweekads">Less than a week ago (5)</a></span>
                        </div>
                        
                        <div class="sidelink">
                           <span><a href="/last2weekads">Less than 2 weeks ago (5)</a></span>
                        </div>
                        
                         <div class="sidelink">
                           <span><a href="/lastmonth">Less than a month (5)</a></span>
                        </div>
                        
                         <div class="sidelink">
                           <span><a href="/home">All Active (100)</a> </span>
                        </div>
						
                    </article>
                </div>
            
                <div class="side_div">
                    <div class="side_header_design">
                    	<span class="groupedheader">Job Categories</span>
                    </div>
                    <article class="spacing-3">
                    
                    	<c:if test="${not empty listCategory}">
						<c:forEach items="${listCategory}" var="category">
						<div class="sidelink">
                            <a href="/home/category/${category.id}"><c:out
									value="${category.name}" /></a>
                        </div>
						</c:forEach>
						</c:if>
                    </article>
                </div>
                
                <div class="side_div">
                    <div class="side_header_design">
                      <span class="groupedheader">Companies</span>
                    </div>
                    <article class="spacing-3">
 						
 						<c:if test="${not empty listCompany}">
					<c:forEach items="${listCompany}" var="company">
						<div class="sidelink">
                           <a href="/home/company/${company.id}"><c:out
									value="${company.name}" /></a>
                        </div>
					</c:forEach>
					</c:if>
                    </article>
                </div>
                
				
                <div class="plain-side-outerborder">
                    <span class="font-header-2">Live Feeds</span>
                    <div class="main-contents-details">
                        <div class="img-float">
                            <img src="${pageContext.request.contextPath}/resources/images/advert.png" width="80px"/>
                        </div>
                        <p class="story_4">
                            Advertise at tujulishe and let you company be known by
                            a large crowd
                        </p>
                    </div>
                </div>
                <div class="plain-side-outerborder">
                    <span class="font-header-2">Live Feeds</span>
                    <div class="main-contents-details">
                        <div class="img-float">
                            <img src="${pageContext.request.contextPath}/resources/images/advert.png" width="80px"/>
                        </div>
                        <p class="story_4">
                            Advertise at tujulishe and let you company be known by
                            a large crowd
                        </p>
                    </div>
                </div>
            </div>
            <div class="middle-panel-jobs">
                <!-- jobs & vacancies -->
                <!-- Loop starts here  -->
						<!-- Start of Middle Column -->
		<h3>Login </h3>
 
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
					value="Login" class="btn btn-primary" /> 
				</td>
				<td colspan='2'>
				</td>
			</tr>
			<tr>
				
			</tr>
		</table>
 
	</form>
		<!-- End of Middle Column -->
                <!-- End of loop here -->

            </div>
        </div>
    </body>
</html>