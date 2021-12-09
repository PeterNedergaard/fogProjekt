<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Custom carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>

            <form action="${pageContext.request.contextPath}/fc/viewinfocommand" method="POST">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Email</th>
                        <th scope="col">Status</th>
                        <th scope="col">Info</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="orderitem" items="${applicationScope.orderslist}" varStatus="loop">
                        <tr>
                            <td>
                                <h5>${orderitem.email}</h5>
                            </td>
                            <td>
                                <c:if test="${orderitem.status.equals('Awaits offer')}">
                                    <h5 style="color: #B94444">Afventer tilbud</h5>
                                </c:if>
                                <c:if test="${orderitem.status.equals('Awaits payment')}">
                                    <h5 style="color: #e3ae1e">Afventer betaling</h5>
                                </c:if>
                                <c:if test="${orderitem.status.equals('Paid')}">
                                    <h5 style="color: forestgreen">Betalt</h5>
                                </c:if>
                            </td>
                            <td>
                                <button type="submit" name="vieworder" value="${loop.index}" class="btn btn-info">
                                    Se ordre
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                        <%--<tr>
                            <td>
                                <h5>email@email.com</h5>
                            </td>
                            <td>
                                <h5 style="color: #e3ae1e">Afventer betaling</h5>
                            </td>
                            <td>
                                <button class="btn btn-info">
                                    Se ordre
                                </button>
                            </td>
                        </tr>--%>
                    </tbody>
                </table>
            </form>

        </div>


    </jsp:body>
</t:genericpage>