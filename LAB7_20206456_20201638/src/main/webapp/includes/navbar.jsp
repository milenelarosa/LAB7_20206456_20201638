<%--
  Created by IntelliJ IDEA.
  User: milene
  Date: 9/06/2023
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/JugadorServlet"> Clasificatorias Sudamericanas <br>Mundial 2026</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <li class="nav-item">
                    <a class="nav-link <%=request.getParameter("page").equals("jugadores")? "active": "" %>" href="<%=request.getContextPath()%>/JugadorServlet#jugadores">Jugadores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%=request.getParameter("page").equals("selecciones")? "active": "" %>" href="<%=request.getContextPath()%>/SeleccionServlet#selecciones">Selecciones</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

