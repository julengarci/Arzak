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
                                        <th scope="col">Alergenos</th>
                                        <th scope="col">Observaciones</th>
                                        <th scope="col">Id Cliente</th>
                                        <th scope="col">Id Menu</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${reservas}" var="reserva">
                                        <tr>
                                            <td>${reserva.id}</td>
                                            <td>${reserva.hora}</td>
                                            <td>${reserva.fecha}</td>
                                            <td>${reserva.numPersonas}</td>
                                            <td>${reserva.alergenos}</td>
                                            <td>${reserva.observaciones}</td>
                                            <td>${reserva.cliente}</td>
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
                                                                <p style="font-size: 14px;">Alergenos: ${reserva.alergeno}</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal" style="font-size: 14px;">Cerrar</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> <!-- Boton que abre el modal para modificar -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                    data-bs-target="#modalModificar${cliente.id}">
                                                    <i class="fa-solid fa-square-pen"></i>
                                                </button>
                                                <!-- Modal para modificar -->
                                                <div class="modal fade" id="modalModificar${cliente.id}" tabindex="-1"
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
                                                                <form id="formularioModificar" method="post" action="UpdateCliente?id=${cliente.id}">
                                                                    <div class="mb-3">
                                                                        <label for="nombreModificar" class="form-label"
                                                                            style="font-size: 14px;">Hora:</label>
                                                                        <input type="text" class="form-control"
                                                                            id="nombre" name="nombre"
                                                                            required value="${reserva.hora}">
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="telefonoModificar" class="form-label"
                                                                            style="font-size: 14px;">Fecha:</label>
                                                                        <input type="date" class="form-control"
                                                                            id="telefono" name="telefono"
                                                                            required value="${reserva.fecha}">
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="emailModificar" class="form-label"
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
                                                                        <label for="alergenoModificar" class="form-label"
                                                                            style="font-size: 14px;">Alergeno:</label>
                                                                        <select class="form-select" id="alergeno"
                                                                            name="alergeno" required>
                                                                            <option value="" selected disabled>Alergeno</option>
                                                                            <c:forEach items="${alergenos}" var="alergeno">
                                                                                <option value="${alergeno}"> ${alergeno}</option>
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
                                                            <div class="modal-footer">
                                                                <!-- Boton para cancelar -->
                                                                <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal"
                                                                    style="font-size: 14px;">Cancelar</button>
                                                                <!-- Boton para enviar el formulario -->
                                                                <button type="submit" form="UpdateCliente?id=${reserva.id}"
                                                                    class="btn btn-primary"
                                                                    style="font-size: 14px;">Enviar</button>
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
                                                                <a href="DeleteCliente?id=${reserva.id}" class="btn btn-danger"
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
