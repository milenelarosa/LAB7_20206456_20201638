<%@ page import="com.example.lab7_20206456_20201638.Models.Beans.Seleccion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.lang.model.util.ElementScanner6" %>
<%@ page import="com.example.lab7_20206456_20201638.Models.Beans.Estadio" %><%--
  Created by IntelliJ IDEA.
  User: milene
  Date: 9/06/2023
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Estadio> estadio  = (ArrayList<Estadio>) request.getAttribute("estadio");%>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Registrar Selecciones"/>
</jsp:include>

<body id="page-top">
<jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="selecciones"/>
</jsp:include>

<section class="page-section" id="contact" style="background-image: url('recursos/img/map-image.png');">
    <!-- Masthead-->
    <br>
    <br>
    <br>
    <div class="container">
        <div class="col-12 col-xl-auto mb-3">
            <a href="<%=request.getContextPath()%>/SeleccionServlet#selecciones" class="m-0 font-weight-bold text-bg-light">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-left me-1"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>
                <b>Volver a la lista de selecciones</b>
            </a>
        </div>

        <div class="text-center">
            <br>
            <h2 class="section-heading text-uppercase">Registrar una Selección</h2>
            <br>
            <br>
            <br>
        </div>


        <form id="contactForm" data-sb-form-api-token="API_TOKEN" method="POST" action="<%=request.getContextPath()%>/SeleccionServlet#selecciones">
            <div class="row align-items-stretch mb-5">
                <div class="col-md-6">
                    <div class="form-group">
                        <!-- Name input-->
                        <input class="form-control" name="nombre" id="nombre" type="text" placeholder="Nombre *" data-sb-validations="required" />
                        <div class="invalid-feedback" data-sb-feedback="name:required">Ingrese un nombre.</div>
                    </div>
                    <div class="form-group mb-md-0">
                        <label for="estadio_id" class="m-0 font-weight-bold text-light">Seleccionar Estadio</label>
                        <select name="estadio_id" id="estadio_id" class="form-control">
                            <% for (Estadio e: estadio) {%>
                                <option value="<%=e.getId_estadio()%>"><%=e.getNombreEstadio()%>
                            </option>
                            <% }%>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <input class="form-control" name="tecnico" id="tecnico" type="text" placeholder="Tecnico *" data-sb-validations="required" />
                        <div class="invalid-feedback" data-sb-feedback="email:required">Ingrese un tecnico.</div>
                    </div>
                </div>
            </div>

            <div class="text-center"><button class="btn btn-primary btn-xl" type="submit">Guardar Cambios</button></div>
        </form>
    </div>
</section>

<jsp:include page="/static/footer.jsp"/>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>

