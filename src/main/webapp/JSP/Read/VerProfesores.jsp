<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="es">
<head>
    <jsp:include page="../../INC/metas.jsp">
        <jsp:param name="titulo" value="CRUD - Read" />
    </jsp:include>
</head>
<body>
<c:import url="../../INC/header.jsp"/>

<main class="hero">
    <div class="container">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="display-1">Ver todos los profesores</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <table class="table table-striped table-hover table-bordered">
                    <thead class="table-dark">
                    <tr>
                        <th scope="col">Nombre Completo</th>
                        <th scope="col">Calle</th>
                        <th scope="col">Número</th>
                        <th scope="col">Población</th>
                        <th scope="col">Provincia</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${empty requestScope.profesores}">
                            <tr>
                                <td colspan="5" class="text-center">No hay profesores registrados todavía</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${requestScope.profesores}" var="profesor">
                                <tr>
                                    <td>${profesor.nombre} ${profesor.ape1} ${profesor.ape2}</td>
                                    <td>${profesor.direccion.calle}</td>
                                    <td>${profesor.direccion.numero}</td>
                                    <td>${profesor.direccion.poblacion}</td>
                                    <td>${profesor.direccion.provincia}</td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>

<c:import url="../../INC/footer.jsp"/>
</body>
</html>
