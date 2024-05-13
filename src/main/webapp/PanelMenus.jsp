<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Arzak panel de control</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/ae360af17e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="estilo.css">
</head>

<body>
    <div class="wrapper">
        <aside id="sidebar" class="js-sidebar">
            <!-- Contenido de la sidebar -->
            <div class="h-100">
                <div class="sidebar-logo">
                    <img src="img/Logotipo-Arzak-Since-1897.webp" alt="arzak logo">
                </div>
                <ul class="sidebar-nav">
                    <li class="sidebar-header">
                        Gestion de elementos
                    </li>
                    <li class="sidebar-item">
                        <a href="PanelMenu" class="sidebar-link " 
                            aria-expanded="false"><i class="fa-solid fa-utensils"></i>
                            Menu
                        </a>
                        <a href="PanelReserva" class="sidebar-link " 
                            aria-expanded="false"><i class="fa-solid fa-book-open"></i>
                            Reservas
                        </a>
                        <a href="PanelCliente" class="sidebar-link " 
                            aria-expanded="false"><i class="fa-solid fa-user"></i>
                            Clientes
                        </a>
                        <a href="PanelPlato" class="sidebar-link " 
                            aria-expanded="false"><i class="fa-solid fa-drumstick-bite"></i>
                            Platos
                        </a>
                        <a href="PanelIngrediente" class="sidebar-link "
                            aria-expanded="false"><i class="fa-solid fa-seedling"></i>
                            Ingredientes
                        </a>  
                        <a href="PanelHistorico" class="sidebar-link "
                            aria-expanded="false"><i class="fa-solid fa-clock-rotate-left"></i>
                            Historico
                        </a>  
                    </li>
                </ul>
            </div>
        </aside>
        <div class="main">
            <nav class="navbar navbar-expand px-3 border-bottom">
                <button class="btn" id="sidebar-toggle" type="button">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse navbar">
                    <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                            <a href="#" data-bs-toggle="dropdown" class="nav-icon pe-md-0">
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main class="content px-3 py-2">
                <div class="container-fluid">
                    <div class="mb-3">
                        <h4>Panel de control</h4>
                    </div>
                    
                    <!-- Elementos de la tabla -->
                    <div class="card border-0">
                        <div class="card-header">
                            <h5 class="card-title">
                                Gestion de Menus
                            </h5>
                        </div>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Precio</th>
                                        <th scope="col">Fecha inicio</th>
                                        <th scope="col">Fecha fin</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Boton de agregar reserva -->
                                    <button type="button" class="btn btn-primary mb-3"
                                        data-bs-toggle="modal"
                                        data-bs-target="#modalAgregarMenu">Agregar menu</button>
                                    <!-- Modal para agregar -->
                                    <div class="modal fade" id="modalAgregarMenu${menu.id}" tabindex="-1"
                                        aria-labelledby="modalAgregarMenuLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalAgregarMenuLabel"
                                                        style="font-size: 16px;">Agregar Menu</h5>
                                                    <button type="button" class="btn-close"
                                                        data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form id="formularioAgregar" method="post" action="CreateMenu">
                                                        <div class="mb-3">
                                                            <label for="precioAgregar" class="form-label" style="font-size: 14px;">Precio:</label>
                                                            <div class="input-group">
                                                                <span class="input-group-text">$</span>
        														<input type="number" class="form-control" id="precio" name="precio"  maxlength="3" required>
                                                            </div>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="fechaAgregar" class="form-label"
                                                                style="font-size: 14px;">Fecha Inicio:</label>
                                                            <input type="date" class="form-control"
                                                                id="fechaInicio" name="fechaInicio" pattern="\d{4}/\d{2}/\d{2}" placeholder="YYYY/MM/DD" required"
                                                                required value="${menu.fechaInicio}">
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="fechaAgregar2" class="form-label"
                                                                style="font-size: 14px;">Fecha Fin:</label>
                                                            <input type="date" class="form-control"
                                                                id="fechaFin" name="fechaFin" maxlenght="3" placeholder="YYYY/MM/DD" required"
                                                                required value="${menu.fechaFin}">
                                                        </div>
                                                        <div class="mb-3 row">
														    <c:forEach var="plato" items="${platos}" varStatus="status">
														        <div class="col-md-6">
														            <div class="form-check">
														                <input class="form-check-input" type="checkbox" value="${plato.id}" id="flexCheckDefault${status.index}" name="platos[]"
														                <c:forEach items="${menu.platos}" var="platoMenu">
														                    <c:if test="${plato.id == platoMenu.id}">
														                        checked
														                    </c:if>
														                </c:forEach> 
														                />
														                <label class="form-check-label" style="font-size: 14px">${plato.nombre}</label>
														            </div>
														        </div>
														    </c:forEach>
														</div>				
														                                                        <div class="mb-3">
                                                            <!-- Boton para cancelar -->
                                                            <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal"
                                                                style="font-size: 14px;">Cancelar</button>
                                                            <!-- Boton para enviar el formulario -->
                                                            <button type="submit" class="btn btn-primary" style="font-size: 14px;">Enviar</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:forEach items="${menus}" var="menu" >
                                        <tr>
                                            <td>${menu.id}</td>
                                            <td>${menu.precio}$</td>
                                            <td>${menu.fechaInicio}</td>
                                            <td>${menu.fechaFin}</td>
                                            <td class="acciones"> 
                                                <!-- Boton que abre el modal para visualizar datos -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                    data-bs-target="#modalDatos${menu.id}">
                                                    <i class="fa-solid fa-eye"></i>
                                                </button> 
                                                <!-- Modal para visualizar datos -->
                                                <div class="modal fade" id="modalDatos${menu.id}" tabindex="-1"
                                                    aria-labelledby="modalDatosLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="modalDatosLabel"
                                                                    style="font-size: 16px;">Datos</h5>
                                                                <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <!-- Aquí puedes mostrar los datos -->
                                                                <p style="font-size: 14px;">Precio: ${menu.precio}$</p>
                                                                <p style="font-size: 14px;">Fecha Inicio: ${menu.fechaInicio}</p>
                                                                <p style="font-size: 14px;">Fecha Fin: ${menu.fechaFin}</p>
																<p style="font-size: 14px;">Platos: ${menu.platos}</p>
                                                                
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal" style="font-size: 14px;">Cerrar</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <!-- Boton que abre el modal para modificar -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                    data-bs-target="#modalModificar${menu.id}">
                                                    <i class="fa-solid fa-square-pen"></i>
                                                </button>
                                                <!-- Modal para modificar -->
                                                <div class="modal fade" id="modalModificar${menu.id}" tabindex="-1"
                                                    aria-labelledby="modalModificarLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="modalModificarLabel"
                                                                    style="font-size: 16px;">Modificar</h5>
                                                                <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form id="formularioModificar" method="post" action="UpdateMenu?id=${menu.id}">
                                                                    <div class="mb-3">
                                                                        <label for="precioModificar" class="form-label" style="font-size: 14px;">Precio:</label>
                                                                        <div class="input-group">
                                                                            <span class="input-group-text">$</span>
                                                                            <input type="text" class="form-control" id="precio" name="precio"  maxlength="3" required value="${menu.precio} ${precio.equals(menu.precio) ? 'selected' : ''}">
                                                                        </div>
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="fechaModificar" class="form-label"
                                                                            style="font-size: 14px;">Fecha Inicio:</label>
                                                                        <input type="date" class="form-control"
                                                                            id="fechaModificar" name="fechaModificar" pattern="\d{4}/\d{2}/\d{2}" placeholder="YYYY/MM/DD" required"
                                                                            required value="${menu.fechaInicio}">
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="fechaModificar2" class="form-label"
                                                                            style="font-size: 14px;">Fecha Fin:</label>
                                                                        <input type="date" class="form-control"
                                                                            id="fechaModificar2" name="fechaModificar2" pattern="\d{4}/\d{2}/\d{2}" placeholder="YYYY/MM/DD" required"
                                                                            required value="${menu.fechaFin}">
                                                                    </div>
	                                                                    <div class="mb-3 row">
																		        <c:forEach var="plato" items="${platos}" varStatus="status">
																		            <div class="col-md-6">
																		                <input type="checkbox" value="${plato.id}" name="platos[]"
																		                <c:forEach items="${menu.platos}" var="platoMenu">
																		                    <c:if test="${plato.id == platoMenu.id}">
																		                        checked
																		                    </c:if>
																		                </c:forEach> 
																		                /> <span style="font-size: 14px">${plato.nombre}</span>
																		            </div>
																		        </c:forEach>													    
																		</div>                                                                
																	 <!-- Boton para cancelar -->
                                                                        <button type="button" class="btn btn-secondary"
                                                                            data-bs-dismiss="modal"
                                                                            style="font-size: 14px;">Cancelar</button>
                                                                        <!-- Boton para enviar el formulario -->
                                                                        <button type="submit" class="btn btn-primary" style="font-size: 14px;">Enviar</button>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Boton que abre el modal de eliminacion -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                    data-bs-target="#modalEliminar${menu.id}">
                                                    <i class="fa-solid fa-square-minus"></i>
                                                </button>
                                                <!-- Modal de eliminacion -->
                                                <div class="modal fade" id="modalEliminar${menu.id}" tabindex="-1"
                                                    aria-labelledby="modalEliminarLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="modalEliminarLabel"
                                                                    style="font-size: 16px;">Confirmacion de eliminacion
                                                                </h5>
                                                                <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body" style="font-size: 14px;">
                                                                ¿Estas seguro de que quieres eliminar este elemento?
                                                            </div>
                                                            <div class="modal-footer">
                                                                <!-- Boton para cancelar -->
                                                                <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal"
                                                                    style="font-size: 14px;">Cancelar</button>
                                                                <!-- Boton para confirmar la eliminacion -->
                                                                <a href="DeleteMenu?id=${menu.id}" class="btn btn-danger"
                                                                    style="font-size: 14px;">Eliminar</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </main>
            
            <footer class="footer">
                <div class="container-fluid">
                    <div class="row text-muted">
                        <div class="col-6 text-start">
                            <p class="mb-0">
                                <a href="index.html" class="text-muted">
                                    <strong>Arzak</strong>
                                </a>
                            </p>
                        </div>
                        <div class="col-6 text-end">
                            <ul class="list-inline">
                                <li class="list-inline-item">
                                    <a href="#" class="text-muted">@Ejemplo</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>