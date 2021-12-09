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
                <div class="col-2" style="display: inline-block">
                </div>
                <div class="col-4" style="display: inline-block; margin: 0 auto; margin-left: 0px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px; padding: 20px; padding-top: 12px">

                        <h4 style="text-align: center">Carportinformation</h4>
                        <br>

                        <h5>Mål:</h5>

                        <b><span>Længde: </span></b> ${applicationScope.customproduct.length} mm
                        <br>
                        <b><span>Bredde: </span></b>${applicationScope.customproduct.width} mm

                        <br><br><br><br>

                        <h5>Tag:</h5>

                        <b><span>Tagtype: </span></b>${applicationScope.customproduct.roofType}
                        <br>
                        <b><span>Tagmateriale: </span></b>${applicationScope.customproduct.roofMaterial}

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-4" style="display: inline-block; margin: 0 auto; margin-right: 0px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                        <h6>pris</h6>

                    </div>
                </div>
                <div class="col-2" style="display: inline-block">
                </div>
                <div class="col-4" style="display: inline-block; margin: 0 auto; margin-left: 0px">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                        <h6>SVG</h6>

                    </div>

                </div>
            </div>

            <div class="row">
                <div class="col-10" style="display: inline-block; margin: 0 auto">
                    <div style="border-color: #cfcfcf; border-style: solid;
                        border-width: 1px; background-color: #e6e6e6; margin-bottom: 12px">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">Materiale</th>
                                <th scope="col">Længde</th>
                                <th scope="col">Antal</th>
                                <th scope="col">Enhed</th>
                                <th scope="col">Beskrivelse</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="materialitem" items="${applicationScope.materiallist}">
                                <tr>
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
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>

        </div>


    </jsp:body>
</t:genericpage>