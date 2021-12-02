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

                <c:if test="${sessionScope.user == null}">
                    <p style="text-align: center; color: #ad2117">DU SKAL VÆRE LOGGET IND FOR AT LÆGGE EN BESTILLING</p>
                </c:if>

        </div>

    </jsp:body>
</t:genericpage>