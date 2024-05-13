<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                        </ul>
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
            
            <c:if test="${numeroDisponible == true}">
            	<div class="alert alert-success alert-dismissable" role="alert">
					El cliente fue introducido con exito
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${numeroDisponible == false}">
            	<div class="alert alert-danger alert-dismissable" role="alert">
					El numero introducido ya esta en la Base de Datos
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${esNumero == false}">
            	<div class="alert alert-danger alert-dismissable" role="alert">
					No has introducido un numero de telefono valido
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${warningUpdate == true}">
            	<div class="alert alert-warning alert-dismissable" role="alert">
					Se han actualizado los valores del cliente
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${warningUpdate == false}">
            	<div class="alert alert-danger alert-dismissable" role="alert">
					No se puede cambiar el numero de telefono por integridad referencial
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${alertDelete == true}">
            	<div class="alert alert-warning alert-dismissable" role="alert">
					se elimino el cliente! es posible que se eliminen sus reservas asociadas
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
           
            
            <main class="content px-3 py-2">
                <div class="container-fluid">
                    <div class="mb-3">
                        <h4>Panel de control</h4>
                    </div>
                    
                    <!-- Elementos de la tabla -->
                    <div class="card border-0">
                        <div class="card-header">
                            <h5 class="card-title">
                                Gestion de Clientes
                            </h5>
                        </div>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Telefono</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <!-- Boton de agregar ingrediente -->
                                    <button type="button" class="btn btn-primary mb-3"
                                        data-bs-toggle="modal"
                                        data-bs-target="#modalAgregarCliente">Agregar Cliente</button>
                                    <!-- Modal para agregar cliente -->
                                    <div class="modal fade" id="modalAgregarCliente${cliente.telefono}" tabindex="-1"
                                        aria-labelledby="modalAgregarClienteLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalAgregarClienteLabel"
                                                        style="font-size: 16px;">Agregar Cliente</h5>
                                                    <button type="button" class="btn-close"
                                                        data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form id="formularioAgregar" method="post" action="CreateCliente">
                                                        <div class="mb-3">
                                                            <label for="nombreAgregar" class="form-label"
                                                                style="font-size: 14px;">Nombre:</label>
                                                            <input type="text" class="form-control"
                                                                id="nombre" name="nombre"
                                                                required >
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="TelefonoAgregar" class="form-label"
                                                                style="font-size: 14px;">Telefono:</label>
                                                            <input type="text" class="form-control"
                                                                id="telefono" name="telefono" maxlength="9" minlength="9"
                                                                required >
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="emailAgregar" class="form-label"
                                                                style="font-size: 14px;">Email:</label>
                                                            <input type="email" class="form-control"
                                                                id="email" name="email"
                                                                required >
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
                                 <c:forEach items="${clientes}" var="cliente" >
                                    <tr>
                                        <td>${cliente.nombre}</td>
                                        <td>${cliente.telefono}</td>
                                        <td>${cliente.email}</td>

                                        <td class="acciones"> 
                                            <!-- Boton que abre el modal para visualizar datos -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                    data-bs-target="#modalDatos${cliente.telefono}">
                                                    <i class="fa-solid fa-eye"></i>
                                                </button> 
                                                <!-- Modal para visualizar datos -->

                                                <div class="modal fade" id="modalDatos${cliente.telefono}" tabindex="-1"

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

                                                                <p style="font-size: 14px;">Nombre: ${cliente.nombre}</p>
                                                                <p style="font-size: 14px;">Telefono: ${cliente.telefono}</p>
                                                                <p style="font-size: 14px;">Email: ${cliente.email}</p>
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
                                                data-bs-target="#modalModificar${cliente.telefono}">
                                                <i class="fa-solid fa-square-pen"></i>
                                            </button>

                                            <!-- Modal para modificar -->
                                            <div class="modal fade" id="modalModificar${cliente.telefono}" tabindex="-1"
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
                                                            <form id="formularioModificar" method="post" action="UpdateCliente?telefono=${cliente.telefono}">
                                                                <div class="mb-3">
                                                                    <label for="nombreModificar" class="form-label"
                                                                        style="font-size: 14px;">Nombre:</label>
                                                                    <input type="text" class="form-control"
                                                                        id="nombre" name="nombre"
                                                                        required value="${cliente.nombre}">
                                                                </div>
                                                                <div class="mb-3">
                                                                    <label for="telefonoModificar" class="form-label"
                                                                        style="font-size: 14px;">Telefono:</label>
                                                                    <input type="text" class="form-control"
                                                                        id="telefonoNuevo" name="telefonoNuevo"
                                                                        required value="${cliente.telefono}">
                                                                </div>
                                                                <div class="mb-3">
                                                                    <label for="emailModificar" class="form-label"
                                                                        style="font-size: 14px;">Email:</label>
                                                                    <input type="email" class="form-control"
                                                                        id="email" name="email"
                                                                        required value="${cliente.email}">
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

                                            <!-- Boton que abre el modal de eliminacion -->
                                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#modalEliminar${cliente.telefono}">
                                                <i class="fa-solid fa-square-minus"></i>
                                            </button>

                                            <!-- Modal de eliminacion -->
                                            <div class="modal fade" id="modalEliminar${cliente.telefono}" tabindex="-1"
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
                                                            <a href="DeleteCliente?telefono=${cliente.telefono}" class="btn btn-danger"
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
