<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab7_20206456_20201638.Models.Beans.Jugador" %>
<%@ page import="com.example.lab7_20206456_20201638.Models.Beans.Seleccion" %>
<%@ page import="com.example.lab7_20206456_20201638.Models.Beans.ArraySeleccion" %><%--
  Created by IntelliJ IDEA.
  User: milene
  Date: 9/06/2023
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<ArraySeleccion> listaSelecciones = (ArrayList<ArraySeleccion>) request.getAttribute("listaSelecciones");%>
<html>
    <jsp:include page="/static/head.jsp">
      <jsp:param name="title" value="Lista de Selecciones"/>
    </jsp:include>

    <body id="page-top">

        <jsp:include page="/includes/navbar.jsp">
          <jsp:param name="page" value="selecciones"/>
        </jsp:include>

        <header class="masthead" style="background-image: url('recursos/img/trofeo-mundial-2.jpg');">
          <div class="container">

          </div>
        </header>
        <!-- Services-->
        <section class="page-section" id="selecciones">
          <br>
          <br>
          <div class="container">
            <div class="text-center">
              <h2 class="section-heading text-uppercase">SELECCIONES</h2>
            </div>
            <br>
            <div class="text-lg-end">
              <h7 class="section-subheading text-muted">¿No ve a su selección favorita? ¡Regístrela!<br></h7>
              <a class="btn btn-success" href="<%=request.getContextPath()%>/SeleccionServlet?a=crearSeleccion">Registrar Selección </a>
            </div>

            <br>

            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-success">LISTA DE SELECCIONES</h6>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                      <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Tecnico</th>
                        <th class="text-center">Estadio</th>
                        <th class="text-center">Primer partido</th>
                      </tr>
                    </thead>
                    <tbody>
                      <% for (ArraySeleccion s : listaSelecciones) { %>
                      <tr>
                        <td class="text-center"><%=s.getIdSeleccion()%></td>
                        <td class="text-center"><%=s.getNombre()%></td>
                        <td class="text-center"><%=s.getTecnico()%></td>
                        <td class="text-center"><%=s.getEstadio()%></td>
                        <td class="text-center"><%=s.getPrimerPartido()%></td>
                          <td><a href="<%=request.getContextPath()%>/SeleccionServlet?action=borrar&id=<%=s.getIdSeleccion()%>" style="color: darkred;">Borrar</a></td>
                      </tr>
                      <% } %>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </section>

        <jsp:include page="/static/footer.jsp"/>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
