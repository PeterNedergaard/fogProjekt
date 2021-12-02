<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
            <form action="${pageContext.request.contextPath}/fc/homepagecommand" method="POST">

                    <%--Filters--%>

                <div class="row">
                    <div class="col-3">
                        <div style="border-color: #cfcfcf; border-style: solid; border-width: 1px; background-color: #e6e6e6; padding: 30px; padding-top: 0px">
                            <h3 class="text-center">FILTRE</h3>
                            <br>
                            <table>
                                <thead>
                                <tr>
                                    <th>BREDDE (CM)</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <input name="widthfilter" class="form-check-input" type="checkbox"
                                               value="300"
                                               id="300">
                                        <label class="form-check-label" for="300">
                                            300
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="widthfilter" class="form-check-input" type="checkbox" value="360"
                                               id="360">
                                        <label class="form-check-label" for="360">
                                            360
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="widthfilter" class="form-check-input" type="checkbox" value="390"
                                               id="390">
                                        <label class="form-check-label" for="390">
                                            390
                                        </label>
                                    </td>
                                </tbody>
                            </table>

                            <table>
                                <thead>
                                <tr>
                                    <th>LÆNGDE (CM)</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <input name="lengthfilter" class="form-check-input" type="checkbox" value="480"
                                               id="480">
                                        <label class="form-check-label" for="480">
                                            480
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="lengthfilter" class="form-check-input" type="checkbox" value="540"
                                               id="540">
                                        <label class="form-check-label" for="540">
                                            540
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="lengthfilter" class="form-check-input" type="checkbox" value="600"
                                               id="600">
                                        <label class="form-check-label" for="600">
                                            600
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="lengthfilter" class="form-check-input" type="checkbox" value="720"
                                               id="720">
                                        <label class="form-check-label" for="720">
                                            720
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="lengthfilter" class="form-check-input" type="checkbox" value="780"
                                               id="780">
                                        <label class="form-check-label" for="780">
                                            780
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="lengthfilter" class="form-check-input" type="checkbox" value="810"
                                               id="810">
                                        <label class="form-check-label" for="810">
                                            810
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="lengthfilter" class="form-check-input" type="checkbox" value="910"
                                               id="910">
                                        <label class="form-check-label" for="910">
                                            910
                                        </label>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <button class="btn btn-secondary" type="submit">
                                Filtrér
                            </button>
                            <button class="btn btn-secondary" type="submit" name="removefilters" value="true">
                                Fjern filtrer
                            </button>
                        </div>


                        <div class="row">
                            <div class="col-12" style="margin-top: 12px">
                                <div class="d-flex justify-content-center"
                                     style="width: 100%; height: 100px; border-color: #cfcfcf; border-style: solid; border-width: 1px; background-color: #e6e6e6">
                                    <h5 style="padding-top: 13%">Carport efter egne mål?</h5>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <a href="${pageContext.request.contextPath}/fc/customflatroof">
                                    <button class="btn"
                                            style="width: 100%; border-color: #cfcfcf; border-style: solid; border-width: 1px; background-color: #e6e6e6; border-top: 0px">
                                        <span><b>Fladt tag</b></span>
                                    </button>
                                </a>
                            </div>
                            <div class="col-6">
                                <a href="${pageContext.request.contextPath}/fc/customangleroof">
                                    <button class="btn"
                                            style="width: 100%; border-color: #cfcfcf; border-style: solid; border-width: 1px; background-color: #e6e6e6; border-top: 0px">
                                        <span><b>Rejst tag</b></span>
                                    </button>
                                </a>
                            </div>
                        </div>

                    </div>


                        <%--Carports/products--%>
                    <div class="col-9">
                        <c:forEach var="standardproduct" items="${applicationScope.standardproductlist}"
                                   varStatus="loop">
                            <div class="row" style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                                <div class="col-3">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit"
                                            name="viewcarport" value="${standardproduct.id}"><img
                                            style="width: 100%"
                                            src="${pageContext.request.contextPath}/images/${standardproduct.image}">
                                    </button>
                                </div>
                                <div class="col-9">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit"
                                            name="viewcarport" value="${standardproduct.id}">
                                        <h5 class="text-start">${standardproduct.title}</h5>
                                    </button>
                                    <div class="row d-flex justify-content-end">
                                        <div class="col-12 d-flex justify-content-end">
                                            <span class="align-bottom"><h6
                                                    style="display: inline-block; color: #696969">pr. stk.</h6></span>
                                            &nbsp;
                                            <span class="align-bottom"><h5
                                                    style="display: inline-block; color: #10246c">${standardproduct.price},-</h5></span>
                                        </div>
                                    </div>
                                    <div class="col-12" style="margin-top: 80px">
                                        <div class="row">
                                            <div class="d-flex justify-content-end col-9">
                                                <div class="row align-items-center col-2">
                                                    <label for="amount">ANTAL</label>
                                                </div>

                                                <input style="width: 130px" name="amount${standardproduct.id}"
                                                       type="text" class="text-center" value="1"
                                                       id="amount">
                                            </div>

                                            <div class="d-flex justify-content-end col-3">
                                                <button type="submit" name="addtobasket" value="${standardproduct.id}"
                                                        class="btn btn-warning"
                                                        style="width: 200px">LÆG I
                                                    KURV
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

            </form>

        </div>

    </jsp:body>
</t:genericpage>