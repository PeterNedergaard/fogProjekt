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

            <form name="buyordelete" action="${pageContext.request.contextPath}/fc/buyordeletecommand" method="POST">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Billede</th>
                        <th scope="col">Titel</th>
                        <th scope="col">Pris</th>
                        <th scope="col">Edit</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:set var="totalprice" value="${0}"/>
                    <c:forEach var="productItem" items="${applicationScope.basketlist}" varStatus="loop">

                        <tr>
                            <th scope="row">${loop.index+1}</th>
                            <td>
                                <img style="width: 200px; height: auto"
                                     src="${pageContext.request.contextPath}/images/${productItem.image}">
                            </td>
                            <td>
                                    ${productItem.title}
                            </td>
                            <td>
                                    ${productItem.price},-

                            </td>
                            <td>
                                <button class="btn btn-primary" name="delete" type="submit" value="${loop.index}"
                                        style="background-color: #B94444; border-color: #B94444">Fjern
                                </button>
                            </td>
                        </tr>
                        <c:set var="totalprice" value="${totalprice + productItem.price}"/>
                    </c:forEach>
                    <tr>
                        <td>Total</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>${totalprice} DKK</td>
                    </tr>
                    </tbody>
                </table>


                <div class="col text-center">
                    <c:if test="${applicationScope.basketlist.size() > 0}">
                        <button class="btn btn-primary" type="submit" value="true" name="buy"
                                style="padding-left: 40px; padding-right: 40px; background-color: green; border-color: green">
                            Køb
                        </button>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/fc/index"><input value="Bestil mere"
                                                                                    class="btn btn-primary"
                                                                                    type="button"></a>

                </div>
            </form>

        </div>

    </jsp:body>
</t:genericpage>