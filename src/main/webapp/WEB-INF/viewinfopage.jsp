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

                        <br><br>

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

                <div class="col-6" style="display: inline-block; margin: 0 auto; margin-left: 0px; padding-bottom: 12px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px; height: 100%">

                        <table class="table table-striped" style="margin-bottom: 0px; height: 100%">
                            <thead style="border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: black">
                            <tr>
                                <th scope="col">
                                    Pris
                                </th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>
                                    Indkøbspris ex. moms:
                                </td>
                                <td>

                                    <fmt:formatNumber type="number" maxFractionDigits="2"
                                                      value="${applicationScope.strsumprice}"/> DKK
                                </td>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div>
                                        <span>Dækningsgrad:</span>
                                    </div>
                                </td>
                                <td>
                                    <input style="color: #b31919; width: 50%" type="text" value="80"> %
                                </td>
                                <td>
                                    <button class="btn btn-info">
                                        Opdatér dækningsgrad
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Dækningsbidrag:
                                </td>
                                <td style="color: #b31919">
                                    <c:set var="daekning" value="${applicationScope.strsumprice * 0.8}"/>
                                    <span><fmt:formatNumber type="number"
                                                            maxFractionDigits="2"
                                                            value="${daekning}"/> DKK</span>
                                </td>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Tilbudspris ex. moms:
                                </td>
                                <td>
                                    <c:set var="tilbudex" value="${applicationScope.strsumprice + daekning}"/>
                                    <fmt:formatNumber type="number"
                                                      maxFractionDigits="2"
                                                      value="${tilbudex}"/> DKK
                                </td>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Tilbudspris incl. moms:
                                </td>
                                <td style="color: forestgreen">
                                    <fmt:formatNumber type="number"
                                                      maxFractionDigits="2"
                                                      value="${tilbudex * 1.25}"/> DKK
                                </td>
                                <td>
                                </td>
                            </tr>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

            <div class="row" style="margin-top: 12px">
                <div class="col-4" style="display: inline-block; margin: 0 auto; margin-right: 0px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px; padding: 20px; padding-top: 12px">

                        <h4 style="text-align: center">Carportinformation</h4>
                        <br>

                        <h5>Mål:</h5>

                        <b><span>Længde: </span></b> ${applicationScope.customproduct.length} mm
                        <br>
                        <b><span>Bredde: </span></b>${applicationScope.customproduct.width} mm

                        <br><br>

                        <h5>Tag:</h5>

                        <b><span>Tagtype: </span></b>${applicationScope.customproduct.roofType}
                        <br>
                        <b><span>Tagmateriale: </span></b>${applicationScope.customproduct.roofMaterial}

                    </div>
                </div>
                <div class="col-6" style="display: inline-block; margin: 0 auto; margin-left: 0px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px; padding: 12px">
                            ${applicationScope.svgdrawing}
                    </div>
                </div>
            </div>

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
        </div>


    </jsp:body>
</t:genericpage>