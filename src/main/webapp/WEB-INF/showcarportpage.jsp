<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Show carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>

            <div class="row">
                <div class="col-6 d-flex justify-content-end">
                    <img src="${pageContext.request.contextPath}/images/${applicationScope.image}">
                </div>
                <div class="col-6">
                    <div class="row" style="margin-top: 100px; background-color: #e8e8e8; margin-bottom: 5px">
                        <h5>${applicationScope.title}</h5>
                        <div class="col-12">
                            <p>${applicationScope.paragraph}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-4 d-flex align-items-center" style="background-color: #e8e8e8">
                            <h6 style="display: inline-block; color: #696969">pr. stk.</h6>
                            &nbsp;
                            <h5>${applicationScope.price}</h5>
                        </div>
                        <div class="col-4 d-flex align-items-center" style="background-color: #e8e8e8">
                            <div class="row">
                                <div class="row col-4 d-flex align-items-center">
                                    <label for="amount3">ANTAL</label>
                                </div>
                                <div class="col-8">
                                    <input style="width: 100%" type="text" class="text-center"
                                           value="1"
                                           id="amount3">
                                </div>
                            </div>
                        </div>
                        <div class="col-4">
                            <button type="button" class="btn btn-warning" style="width: 100%">LÆG I
                                KURV
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an employee</p>
            <p><a href="fc/employeepage">Employee Page</a>
                </c:if>

                <c:if test="${sessionScope.role == 'customer' }">
            <p style="font-size: larger">This is what you can do, since your
                are logged in as a customer</p>
            <p><a href="fc/customerpage">Customer Page</a>
                </c:if>

        </div>

    </jsp:body>
</t:genericpage>