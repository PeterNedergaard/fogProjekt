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
                        </div>

                        <button type="submit">
                            Filtrér
                        </button>
                        <button type="submit" name="removefilters" value="true">
                            Fjern filtrer
                        </button>

                    </div>


                        <%--Carports/products--%>
                    <div class="col-9">
                        <c:forEach var="standardproduct" items="${applicationScope.standardproductlist}"
                                   varStatus="loop">
                            <div class="row" style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                                <div class="col-3">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit"
                                            name="viewcarport" value="${loop.index+1}"><img
                                            style="width: 100%"
                                            src="${pageContext.request.contextPath}/images/${standardproduct.image}">
                                    </button>
                                </div>
                                <div class="col-9">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit"
                                            name="viewcarport" value="${loop.index+1}">
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
                                                <input style="width: 130px" type="text" class="text-center" value="1"
                                                       id="amount">
                                            </div>
                                            <div class="d-flex justify-content-end col-3">
                                                <button type="button" class="btn btn-warning" style="width: 200px">LÆG I
                                                    KURV
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>


                        <%--<div class="col-9">
                            <div class="row" style="border-color: #cfcfcf; border-style: solid;
                            border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                                <div class="col-3">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="1"><img
                                            style="width: 100%"
                                            src="${pageContext.request.contextPath}/images/carport1.png"></button>
                                </div>
                                <div class="col-9">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="1">
                                        <h5 class="text-start">CARPORT ENKELT 3,60X5,40M CAR01H HØJ REJSNING</h5>
                                    </button>
                                    <div class="row d-flex justify-content-end">
                                        <div class="col-12 d-flex justify-content-end">
                                            <span class="align-bottom"><h6 style="display: inline-block; color: #696969">pr. stk.</h6></span>
                                            &nbsp;
                                            <span class="align-bottom"><h5 style="display: inline-block; color: #10246c">25.000,-</h5></span>
                                        </div>
                                    </div>
                                    <div class="col-12" style="margin-top: 80px">
                                        <div class="row">
                                            <div class="d-flex justify-content-end col-9">
                                                <div class="row align-items-center col-2">
                                                    <label for="amount1">ANTAL</label>
                                                </div>
                                                <input style="width: 130px" type="text" class="text-center" value="1"
                                                       id="amount1">
                                            </div>
                                            <div class="d-flex justify-content-end col-3">
                                                <button type="button" class="btn btn-warning" style="width: 200px">LÆG I
                                                    KURV
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row" style="border-color: #cfcfcf; border-style: solid;
                            border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                                <div class="col-3">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="2"><img
                                            style="width: 100%"
                                            src="${pageContext.request.contextPath}/images/carport2.png"></button>

                                </div>
                                <div class="col-9">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="2">
                                        <h5 class="text-start">CARPORT ENKELT 3,60X7,20M CAR01HR MED REDSKABSRUM 3,20X2,20M</h5>
                                    </button>
                                    <div class="row d-flex justify-content-end">
                                        <div class="col-12 d-flex justify-content-end">
                                            <span class="align-bottom"><h6 style="display: inline-block; color: #696969">pr. stk.</h6></span>
                                            &nbsp;
                                            <span class="align-bottom"><h5 style="display: inline-block; color: #10246c">31.000,-</h5></span>
                                        </div>
                                    </div>
                                    <div class="col-12" style="margin-top: 80px">
                                        <div class="row">
                                            <div class="d-flex justify-content-end col-9">
                                                <div class="row align-items-center col-2">
                                                    <label for="amount2">ANTAL</label>
                                                </div>
                                                <input style="width: 130px" type="text" class="text-center" value="1"
                                                       id="amount2">
                                            </div>
                                            <div class="d-flex justify-content-end col-3">
                                                <button type="button" class="btn btn-warning" style="width: 200px">LÆG I
                                                    KURV
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row" style="border-color: #cfcfcf; border-style: solid;
                            border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                                <div class="col-3">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="3"><img
                                            style="width: 100%"
                                            src="${pageContext.request.contextPath}/images/carport3.png"></button>
                                </div>
                                <div class="col-9">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="3">
                                        <h5 class="text-start">CARPORT ENKELT 3,60X8,10M CARL01HR MED REDSKABSRUM
                                            3,05X3,20M</h5>
                                    </button>
                                    <div class="row d-flex justify-content-end">
                                        <div class="col-12 d-flex justify-content-end">
                                            <span class="align-bottom"><h6 style="display: inline-block; color: #696969">pr. stk.</h6></span>
                                            &nbsp;
                                            <span class="align-bottom"><h5 style="display: inline-block; color: #10246c">33.500,-</h5></span>
                                        </div>
                                    </div>
                                    <div class="col-12" style="margin-top: 80px">
                                        <div class="row">
                                            <div class="d-flex justify-content-end col-9">
                                                <div class="row align-items-center col-2">
                                                    <label for="amount3">ANTAL</label>
                                                </div>
                                                <input style="width: 130px" type="text" class="text-center" value="1"
                                                       id="amount3">
                                            </div>
                                            <div class="d-flex justify-content-end col-3">
                                                <button type="button" class="btn btn-warning" style="width: 200px">LÆG I
                                                    KURV
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row" style="border-color: #cfcfcf; border-style: solid;
                            border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                                <div class="col-3">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="4"><img
                                            style="width: 100%"
                                            src="${pageContext.request.contextPath}/images/carport4.png"></button>

                                </div>
                                <div class="col-9">
                                    <button style="border-width: 0px; background-color: #e6e6e6;" type="submit" name="viewcarport" value="4">
                                        <h5 class="text-start">CARPORT ENKELT 3,90X7,80M CPO01HR MED REDSKABSRUM 2,40X3,30M</h5>
                                    </button>
                                    <div class="row d-flex justify-content-end">
                                        <div class="col-12 d-flex justify-content-end">
                                            <span class="align-bottom"><h6 style="display: inline-block; color: #696969">pr. stk.</h6></span>
                                            &nbsp;
                                            <span class="align-bottom"><h5 style="display: inline-block; color: #10246c">36.000,-</h5></span>
                                        </div>
                                    </div>
                                    <div class="col-12" style="margin-top: 80px">
                                        <div class="row">
                                            <div class="d-flex justify-content-end col-9">
                                                <div class="row align-items-center col-2">
                                                    <label for="amount4">ANTAL</label>
                                                </div>
                                                <input style="width: 130px" type="text" class="text-center" value="1"
                                                       id="amount4">
                                            </div>
                                            <div class="d-flex justify-content-end col-3">
                                                <button type="button" class="btn btn-warning" style="width: 200px">LÆG I
                                                    KURV
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>--%>
            </form>

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