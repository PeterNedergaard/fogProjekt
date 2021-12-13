<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register as new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input id="email" class="form-control" type="text" name="email" value="${param.email}" placeholder="Enter a valid email">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="tlf">Phone number:</label>
                    <div class="col-sm-4">
                        <input id="tlf" class="form-control" type="text" name="tlf" placeholder="Enter a valid phone number">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="zipcode">Zipcode:</label>
                    <div class="col-sm-4">
                        <input id="zipcode" class="form-control" type="text" name="zipcode" placeholder="Enter a valid zipcode">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="city">City:</label>
                    <div class="col-sm-4">
                        <input id="city" class="form-control" type="text" name="city" placeholder="Enter a valid city">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="street">Street:</label>
                    <div class="col-sm-4">
                        <input id="street" class="form-control" type="text" name="street" placeholder="Enter a valid street">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="housenum">House number:</label>
                    <div class="col-sm-4">
                        <input id="housenum" class="form-control" type="text" name="housenum" placeholder="Enter a valid house number">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password1">Password</label>
                    <div class="col-sm-4">
                        <input id="password1" class="form-control" type="password" name="password1"  value="${param.password1}"  placeholder="Enter your password">
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password2">Password</label>
                    <div class="col-sm-4">
                        <input id="password2" class="form-control" type="password" name="password2" value="${param.password2}"  placeholder="Repeat the password">
                    </div>
                </div>

                <input class="btn btn-primary" type="submit" type="submit" value="Submit">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


