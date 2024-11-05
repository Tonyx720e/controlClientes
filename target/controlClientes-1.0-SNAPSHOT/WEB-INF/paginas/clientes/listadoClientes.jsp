<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section id="personas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Personas</h4>
                    </div>
                    <table class="table table-striped table-hover table-bordered table-sm">
                        <thead class="table-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="persona" items="${personas}" varStatus="status">
                                <tr>
                                    <th scope="row">${status.count}</th>
                                    <td>${persona.nombre}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServerControlador?accion=editar&id_persona=${persona.id_persona}"
                                        class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i>Editar
                                    </a>
                                        <!-- Puedes agregar aquí botones de acciones estilizados -->
                                        
                                        <button class="btn btn-primary btn-sm">Modificar</button>
                                        <button class="btn btn-danger btn-sm">Eliminar</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="agregarPersona.jsp" />
