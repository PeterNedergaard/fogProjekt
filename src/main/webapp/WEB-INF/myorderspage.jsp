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

            <form action="${pageContext.request.contextPath}/fc/viewmyordercommand" method="POST">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Ordre nr.</th>
                        <th scope="col">Type</th>
                        <th scope="col">Status</th>
                        <th scope="col">Info</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="myorderitem" items="${applicationScope.myorderlist}" varStatus="loop">
                        <tr>
                            <td>
                                <h5>${myorderitem.id}</h5>
                            </td>
                            <td>
                                <h5>${myorderitem.productType}</h5>
                            </td>
                            <td>
                                <c:if test="${myorderitem.status.equals('Awaits offer')}">
                                    <h5 style="color: #B94444">Afventer tilbud</h5>
                                </c:if>
                                <c:if test="${myorderitem.status.equals('Awaits payment')}">
                                    <h5 style="color: #e3ae1e">Afventer betaling</h5>
                                </c:if>
                                <c:if test="${myorderitem.status.equals('Paid')}">
                                    <h5 style="color: forestgreen">Betalt</h5>
                                </c:if>
                            </td>
                            <td>
                                <button type="submit" name="selectedid" value="${loop.index}" class="btn btn-info">
                                    Se ordre
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>

        </div>


    </jsp:body>
</t:genericpage>