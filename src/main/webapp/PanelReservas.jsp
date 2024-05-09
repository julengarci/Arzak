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
            <main class="content px-3 py-2">
                <div class="container-fluid">
                    <div class="mb-3">
                        <h4>Panel de control</h4>
                    </div>
                    
                    <!-- Elementos de la tabla -->
                    <div class="card border-0">
                        <div class="card-header">
                            <h5 class="card-title">
                                Gestion de Reservas
                            </h5>
                        </div>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Hora</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Numero de personas</th>
                                        <th scope="col">Observaciones</th>
                                        <th scope="col">Telefono</th>
                                        <th scope="col">Id Menu</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <!-- Boton de agregar reserva -->
                                    <button type="button" class="btn btn-primary mb-3"
                                        data-bs-toggle="modal"
                                        data-bs-target="#modalAgregarReserva">Agregar Reserva</button>
                                    <!-- Modal para modificar -->
                                    <div class="modal fade" id="modalAgregarReserva${reserva.id}" tabindex="-1"
                                        aria-labelledby="modalAgregarReservaLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalAgregarReservaLabel"
                                                        style="font-size: 16px;">Agregar Reserva</h5>
                                                    <button type="button" class="btn-close"
                                                        data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form id="formularioAgregar" method="post" action="CreateReserva">
                                                        <div class="mb-3">
                                                                        <label for="emailModificar" class="form-label"
                                                                            style="font-size: 14px;">Hora:</label>
                                                                        <select class="form-select" id="hora"
                                                                            name="hora" required>
                                                                            <option value="" selected disabled>Selecciona la hora</option>
                                                                            <option value="13:00">13:00</option>
                                                                            <option value="13:30">13:30</option>
                                                                            <option value="14:00">14:00</option>
                                                                            <option value="14:30">14:30</option>
                                                                            <option value="15:00">15:00</option>
                                                                            <option value="20:00">20:00</option>
                                                                            <option value="20:30">20:30</option>
                                                                            <option value="21:00">21:00</option>
                                                                            <option value="21:30">21:30</option>
                                                                            <option value="22:00">22:00</option>
                                                                        </select>
                                                        </div>
                                                        <div class="mb-3">
                                                                        <label for="fechaAgregar" class="form-label"
                                                                            style="font-size: 14px;">Fecha:</label>
                                                                        <input type="date" class="form-control"
                                                                            id="fecha" name="fecha" pattern="\d{4}/\d{2}/\d{2}" placeholder="YYYY/MM/DD" required"
                                                                            required value="${reserva.fecha}">
														</div>
														<div class="mb-3">
                                                                        <label for="personasModificar" class="form-label"
                                                                            style="font-size: 14px;">Numero de personas:</label>
                                                                        <select class="form-select" id="numPersonas"
                                                                            name="numPersonas" required>
                                                                            <option value="" selected disabled>Selecciona
                                                                                el número de personas</option>
                                                                            <option value="1">1</option>
                                                                            <option value="2">2</option>
                                                                            <option value="3">3</option>
                                                                            <option value="4">4</option>
                                                                            <option value="5">5</option>
                                                                            <option value="6">6</option>
                                                                            <option value="7">7</option>
                                                                            <option value="8">8</option>
                                                                            <option value="9">9</option>
                                                                            <option value="10">10</option>
                                                                        </select>
														</div>
                                                        <div class="mb-3">
														    <label for="observacionesAgregar" class="form-label" style="font-size: 14px;">Observaciones:</label>
														    <textarea type="text" class="form-control"  rows="4" id="observacionesModificar" selected name="observaciones"><c:out value="${reserva.observaciones}"/> </textarea> 

														</div>
														<div class="mb-3">
                                                            <label for="telefonoAgregar" class="form-label" style="font-size: 14px;">Telefono:</label>                                                            <select class="form-select" id="telefono"
                                                                name="telefono" required>
                                                                <option value="" selected disabled>Telefono</option>
                                                                <c:forEach items="${clientes}" var="cliente">
                                                                    <option value="${cliente.telefono}"> ${cliente.telefono}</option>
                                                                </c:forEach>
                                                            </select>
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
                                    <c:forEach items="${reservas}" var="reserva">
                                        <tr>
                                            <td>${reserva.id}</td>
                                            <td>${reserva.hora}</td>
                                            <td>${reserva.fecha}</td>
                                            <td>${reserva.numPersonas}</td>
                                            <td>${reserva.observaciones}</td>
                                            <td>${reserva.cliente.telefono}</td>
                                            <td>${reserva.menu}</td>
                                            <td class="acciones"> 
                                                <!-- Boton que abre el modal para visualizar datos -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                    data-bs-target="#modalDatos${reserva.id}">
                                                    <i class="fa-solid fa-eye"></i>
                                                </button> 
                                                <!-- Modal para visualizar datos -->
                                                <div class="modal fade" id="modalDatos${reserva.id}" tabindex="-1"
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
                                                                <p style="font-size: 14px;">Hora: ${reserva.hora}</p>
                                                                <p style="font-size: 14px;">Fecha: ${reserva.fecha}</p>
                                                                <p style="font-size: 14px;">Numero de personas: ${reserva.numPersonas}</p>
                                                                <p style="font-size: 14px;">Observaciones: ${reserva.observaciones}</p>
                                                                <p style="font-size: 14px;">Telefono: ${reserva.cliente.telefono}</p>
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
                                                    data-bs-target="#modalModificar${reserva.id}">
                                                    <i class="fa-solid fa-square-pen"></i>
                                                </button>
                                                <!-- Modal para modificar -->
                                                <div class="modal fade" id="modalModificar${reserva.id}" tabindex="-1"
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
                                                                <form id="formularioModificar" method="post" action="UpdateReserva?id=${reserva.id}" data-bs-target="${reserva.id}">
                                                                    <div class="mb-3">
                                                                        <label for="horaModificar${reserva.id}" class="form-label"
                                                                            style="font-size: 14px;">Hora:</label>
                                                                        <select class="form-select" id="hora${reserva.id}"
                                                                            name="hora"}">
																			<option value="${hora}" disabled>${reserva.hora}</option>
                                                                            <option value="13:00" ${reserva.hora.equals('13:00') ? 'selected' : ''}>13:00</option>
                                                                            <option value="13:30" ${reserva.hora.equals('13:30') ? 'selected' : ''}>13:30</option>
                                                                            <option value="14:00" ${reserva.hora.equals('14:00') ? 'selected' : ''}>14:00</option>
                                                                            <option value="14:30" ${reserva.hora.equals('14:30') ? 'selected' : ''}>14:30</option>
                                                                            <option value="15:00" ${reserva.hora.equals('15:00') ? 'selected' : ''}>15:00</option>
                                                                            <option value="20:00" ${reserva.hora.equals('20:00') ? 'selected' : ''}>20:00</option>
                                                                            <option value="20:30" ${reserva.hora.equals('20:30') ? 'selected' : ''}>20:30</option>
                                                                            <option value="21:00" ${reserva.hora.equals('21:00') ? 'selected' : ''}>21:00</option>
                                                                            <option value="21:30" ${reserva.hora.equals('21:30') ? 'selected' : ''}>21:30</option>
                                                                            <option value="22:00"${reserva.hora.equals('22:00') ? 'selected' : ''}>22:00</option>
                                                                        </select>
                                                       	 			</div>
                                                                    <div class="mb-3">
                                                                        <label for="fechaModificar" class="form-label"
                                                                            style="font-size: 14px;">Fecha:</label>
                                                                        <input type="date" class="form-control"
                                                                            id="fecha" name="fecha" value="${reserva.fecha}">
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="personasModificar" class="form-label"
                                                                            style="font-size: 14px;">Numero de personas:</label>
                                                                        <select class="form-select" id="numPersonas"
                                                                            name="numPersonas" value="${reserva.numPersonas}" >
                                                                            <option value="${numPersonas}" disabled >${reserva.numPersonas}</option>
                                                                            <option value="1" ${reserva.numPersonas.equals('1') ? 'selected' : ''}>1</option>
                                                                            <option value="2" ${reserva.numPersonas.equals('2') ? 'selected' : ''}>2</option>
                                                                            <option value="3" ${reserva.numPersonas.equals('3') ? 'selected' : ''}>3</option>
                                                                            <option value="4" ${reserva.numPersonas.equals('4') ? 'selected' : ''}>4</option>
                                                                            <option value="5" ${reserva.numPersonas.equals('5') ? 'selected' : ''}>5</option>
                                                                            <option value="6" ${reserva.numPersonas.equals('6') ? 'selected' : ''}>6</option>
                                                                            <option value="7" ${reserva.numPersonas.equals('7') ? 'selected' : ''}>7</option>
                                                                            <option value="8" ${reserva.numPersonas.equals('8') ? 'selected' : ''}>8</option>
                                                                            <option value="9" ${reserva.numPersonas.equals('9') ? 'selected' : ''}>9</option>
                                                                            <option value="10" ${reserva.numPersonas.equals('10') ? 'selected' : ''}>10</option>
                                                                        </select>
                                                                    </div>
                                                                    <div class="mb-3">
														    			<label for="observacionesModficar" class="form-label" style="font-size: 14px;">Observaciones</label>
														    			<textarea type="text" class="form-control"  rows="4" id="observacionesModificar" selected name="observaciones"><c:out value="${reserva.observaciones}"/> </textarea> 
																	</div>
																	<div class="mb-3">
			                                                            <label for="telefonoAgregar" class="form-label" style="font-size: 14px;">Telefono:</label>                                                            <select class="form-select" id="telefono"
			                                                                name="telefono" required>
			                                                                <option value="" selected disabled>Telefono</option>
			                                                                <c:forEach items="${clientes}" var="cliente">
			                                                                    <option value="${cliente.telefono}"> ${cliente.telefono}</option>
			                                                                </c:forEach>
			                                                            </select>
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
                                                    data-bs-target="#modalEliminar${reserva.id}">
                                                    <i class="fa-solid fa-square-minus"></i>
                                                </button>
                                                <!-- Modal de eliminacion -->
                                                <div class="modal fade" id="modalEliminar${reserva.id}" tabindex="-1"
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
                                                                <a href="DeleteReserva?id=${reserva.id}" class="btn btn-danger"
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
