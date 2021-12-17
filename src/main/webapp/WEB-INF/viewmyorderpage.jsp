<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>

    <jsp:attribute name="header">
         Custom carport
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>

            <div class="row">
                <div class="col-4" style="display: inline-block; margin: 0 auto; margin-right: 0px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px; padding: 20px; padding-top: 12px">

                        <h4 style="text-align: center">Kundeinformation</h4>
                        <br>

                        <h5>Kontaktoplysninger:</h5>

                        <b><span>Email: </span></b> ${applicationScope.customer.email}
                        <br>
                        <b><span>Tlf. nummer: </span></b>${applicationScope.customer.telephone}

                        <br><br><br>

                        <h5>Adresse:</h5>

                        <b><span>By: </span></b>${applicationScope.customer.city}
                        <br>
                        <b><span>Postnummer: </span></b>${applicationScope.customer.zipcode}
                        <br>
                        <b><span>Vej: </span></b>${applicationScope.customer.street}
                        <br>
                        <b><span>Husnummer: </span></b>${applicationScope.customer.houseNumber}

                    </div>
                </div>

                <div class="col-4"
                     style="display: inline-block; margin: 0 auto; margin-left: 0px; padding-bottom: 12px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px; height: 100%; padding-left: 20px">

                        <h4 style="text-align: center">Carportinformation</h4>
                        <br>


                        <h5>Pris:</h5>

                        <c:if test="${applicationScope.orderstatus.equals('Awaits offer')}">
                            <span style="color: #B94444"><b><span>Afventer tilbud</span></b></span>
                        </c:if>

                        <c:if test="${applicationScope.orderstatus.equals('Awaits payment')}">
                            <span style="color: #e3ae1e"><b><span>Afventer betaling: </span></b> ${applicationScope.customproduct.price} DKK</span>
                        </c:if>

                        <c:if test="${applicationScope.orderstatus.equals('Paid')}">
                            <span style="color: forestgreen"><b><span>Betalt: </span></b> ${applicationScope.customproduct.price} DKK</span>
                        </c:if>

                        <br><br>


                        <h5>Carport mål:</h5>
                        <b><span>Længde: </span></b> ${applicationScope.customproduct.length} mm
                        <br>
                        <b><span>Bredde: </span></b> ${applicationScope.customproduct.width} mm

                        <br><br>

                        <c:if test="${applicationScope.customproduct.shedLength > 0}">
                            <h5>Redskabsskur mål:</h5>
                            <b><span>Længde: </span></b> ${applicationScope.customproduct.shedLength} mm
                            <br>
                            <b><span>Bredde: </span></b> ${applicationScope.customproduct.shedWidth} mm

                            <br><br>
                        </c:if>

                        <h5>Tag:</h5>
                        <b><span>Tagtype: </span></b>${applicationScope.customproduct.roofType}
                        <br>
                        <b><span>Tagmateriale: </span></b>${applicationScope.customproduct.roofMaterial}

                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-10">
                    <div style="border-color: #cfcfcf; border-style: solid;
                            border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px; padding: 12px; height: 430px">
                            ${applicationScope.svgdrawing}
                    </div>
                </div>
            </div>
        </div>


        <c:if test="${applicationScope.orderstatus.equals('Paid')}">
            <div class="row" style="margin-top: 12px">
                <div class="col-10" style="display: inline-block; margin: 0 auto">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6">
                        <table class="table table-striped" style="margin-bottom: 0px">
                            <thead>
                            <tr>
                                <th scope="col">Varenummer</th>
                                <th scope="col">Materiale</th>
                                <th scope="col">Længde</th>
                                <th scope="col">Antal</th>
                                <th scope="col">Enhed</th>
                                <th scope="col">Beskrivelse</th>
                                <th scope="col">Pris (DKK)</th>
                                <th scope="col">Total (DKK)</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="totalprice" value="${0}"/>
                            <c:forEach var="materialitem" items="${applicationScope.materiallist}">
                                <tr style="border-bottom-color: black; border-bottom-style: solid; border-bottom-width: 1px">
                                    <td>
                                            ${materialitem.id}
                                    </td>
                                    <td>
                                            ${materialitem.name}
                                    </td>
                                    <td>
                                            ${materialitem.length}
                                    </td>
                                    <td>
                                            ${materialitem.amount}
                                    </td>
                                    <td>
                                        Stk
                                    </td>
                                    <td>
                                            ${materialitem.description}
                                    </td>
                                    <td>
                                            ${materialitem.strPrice}
                                    </td>
                                    <td>
                                            ${materialitem.strTotalPrice}
                                        <c:set var="totalprice" value="${totalprice + materialitem.totalPrice}"/>
                                    </td>
                                </tr>
                            </c:forEach>

                            <tr style="border-color: black; border-style: solid; border-width: 1px; border-top-width: 0px">
                                <th>SUM (ex. moms)</th>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <th>${applicationScope.strsumprice} DKK</th>
                            </tr>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </c:if>
        </div>

        <form action="${pageContext.request.contextPath}/fc/viewmyordercommand" method="POST">
            <c:if test="${applicationScope.orderstatus.equals('Awaits payment')}">
                <div class="row justify-content-center" style="margin-top: 12px">
                    <div class="col-4 d-flex justify-content-center" style="border-color: #cfcfcf; border-style: solid;
                                border-width: 1px; background-color: #e6e6e6">
                        <div style="padding: 12px; padding-right: 25px">
                            <input class="btn btn-success" type="submit"
                                   value="Acceptér tilbud" name="acceptoffer">
                        </div>

                        <input hidden name="selectedid" value="${applicationScope.selectedid}">

                        <div style="padding: 12px; padding-left: 25px">
                            <input class="btn btn-danger" type="submit"
                                   value="Afvis tilbud" name="denyoffer">
                        </div>
                    </div>
                </div>
            </c:if>
        </form>


    </jsp:body>
</t:genericpage>