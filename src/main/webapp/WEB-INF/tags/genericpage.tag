<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
    <meta name="theme-color" content="#7952b3">
</head>
<body>
<!--
    This header is inspired by this bootstrap
    example: https://getbootstrap.com/docs/5.0/examples/pricing/
-->

<div style=" background-color: #10246c">
    <header class="d-flex flex-column flex-md-row align-items-center p-3 pb-0 px-md-4 mb-4 border-bottom shadow-sm">
        <div class="h5 my-0 me-md-auto fw-normal">
            <img src="${pageContext.request.contextPath}/images/fogBillede.JPG">
            <p style="font-size: larger; margin-top: 10px" class="text-light">
                <jsp:invoke fragment="header"/>
            </p>
        </div>
        <nav class="my-2 my-md-0 me-md-3">
            <c:if test="${addHomeLink == null }">
                <a class="p-2 text-light" href="<%=request.getContextPath()%>">Home</a>
            </c:if>
            <a class="p-2 text-light" href="#">Orders</a>
            <a class="p-2 text-light" href="#">Profile</a>
            <a class="p-2 text-light" href="#">About</a>
        </nav>

        <div>

            <c:if test="${sessionScope.user != null }">
                <p style="text-align: center; color: white; display: inline-block">${sessionScope.user.email}</p>
            </c:if>

            <c:set var="thisPage" value="${pageContext.request.servletPath}"/>
            <c:set var="isNotLoginPage" value="${!fn:endsWith(thisPage,'loginpage.jsp')}"/>
            <c:set var="isNotRegisterPage" value="${!fn:endsWith(thisPage,'registerpage.jsp')}"/>


            <c:if test="${isNotLoginPage && isNotRegisterPage}">
                <c:if test="${sessionScope.user != null }">
                    <a type="button" class="btn btn-sm  btn-outline-light text-light"
                       href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
                </c:if>
                <c:if test="${sessionScope.user == null }">
                    <a type="button" class="btn btn-sm  btn-outline-light text-light"
                       href="${pageContext.request.contextPath}/fc/loginpage">Login</a>
                    <a type="button" class="btn btn-sm  btn-outline-light text-light"
                       href="${pageContext.request.contextPath}/fc/registerpage">Sign up</a>
                </c:if>

            </c:if>

            <a href="${pageContext.request.contextPath}/fc/basketcommand" style="text-decoration: none">
                <c:if test="${sessionScope.user.role == 'customer' }">
                <img style="border-radius: 10%" src="${pageContext.request.contextPath}/images/img_1.png" width="35"
                     height="35">
                <p style="color: white; display: inline-block">(${sessionScope.user.myBasketList.size()})</p>
            </c:if>
            </a>

        </div>
    </header>
</div>

<div id="body" class="container" style="min-height: 20vh;">
    <jsp:doBody/>
</div>


<!-- Footer -->
<div class="container">
    <br>
    <hr>
    <br>
    <jsp:invoke fragment="footer"/>
</div>

</body>
</html>