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

        <form action="${pageContext.request.contextPath}/fc/sendrequestcommand" method="POST">
            <div class="row d-flex justify-content-center">
                <div class="col-6"
                     style="padding-top: 12px; border-color: #cfcfcf; border-style: solid; border-width: 1px; background-color: #e6e6e6">
                    <h5>Carport bredde</h5>
                    <select style="width: 100%" name="width" id="width">
                        <option value="" disabled selected>Vælg bredde</option>
                        <c:forEach var="widthItem" items="${applicationScope.widthlist}">
                            <option value="${widthItem}">${widthItem} mm</option>
                        </c:forEach>
                    </select>

                    <br><br>

                    <h5>Carport længde</h5>
                    <select style="width: 100%" name="length" id="length">
                        <option value="" disabled selected>Vælg længde</option>
                        <c:forEach var="lengthItem" items="${applicationScope.lengthlist}">
                            <option value="${lengthItem}">${lengthItem} mm</option>
                        </c:forEach>
                    </select>

                    <br><br>

                    <h5>Tag</h5>
                    <select style="width: 100%" name="roof" id="roof">
                        <option value="" disabled selected>Vælg tag materiale</option>
                        <option value="plasttrapez">Plasttrapez</option>
                    </select>

                    <br><br><br>

                    <h5>Redskabsrum:</h5>
                    <p>NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet</p>

                    <h5>Redskabsrum bredde</h5>
                    <select style="width: 100%" name="shedwidth" id="shedwidth">
                        <option value="0">Ønsker ikke redskabsrum</option>
                        <c:forEach var="shedwidthitem" items="${applicationScope.shedWidthlist}">
                            <option value="${shedwidthitem}">${shedwidthitem} mm</option>
                        </c:forEach>
                    </select>

                    <br><br>

                    <h5>Redskabsrum længde</h5>
                    <select style="width: 100%" name="shedlength" id="shedlength">
                        <option value="0">Ønsker ikke redskabsrum</option>
                        <c:forEach var="shedlengthitem" items="${applicationScope.shedLengthlist}">
                            <option value="${shedlengthitem}">${shedlengthitem} mm</option>
                        </c:forEach>
                    </select>

                    <br><br><br>

                    <div class="row">
                        <div class="col-12" style="padding-left: 40%; padding-bottom: 12px">
                            <button class="btn btn-warning" type="submit">
                                Send forespørgsel
                            </button>
                        </div>
                    </div>


                </div>
            </div>
        </form>


    </jsp:body>
</t:genericpage>