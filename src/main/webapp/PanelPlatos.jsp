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
                            <a href="#" data-bs-toggle="dropdown" class="nav-icon pe-md-0"></a>
                        </li>
                    </ul>
                </div>
            </nav>
            
            <c:if test="${alertNull == true}">
            	<div class="alert alert-danger alert-dismissable" role="alert">
					No puedes crear un plato sin ingredientes
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${alertNull == false}">
            	<div class="alert alert-success alert-dismissable" role="alert">
					Plato creado con exito!
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${alertDelete == true}">
            	<div class="alert alert-warning alert-dismissable" role="alert">
					se elimino el plato! es posible que se eliminen sus menus asociados
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${updateNull == true}">
            	<div class="alert alert-warning alert-dismissable" role="alert">
					No puedes dejar un plato sin ingredientes
					<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
            </c:if>
            
            <c:if test="${updateNull == false}">
            	<div class="alert alert-warning alert-dismissable" role="alert">
					Plato actualizado con exito!
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
                                Gestion de Platos
                            </h5>
                        </div>
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Tipo</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Boton de agregar platos -->
                                    <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#modalAgregarIngrediente">Agregar Platos</button>
                                    <!-- Modal para agregar -->
                                    <div class="modal fade" id="modalAgregarIngrediente${plato.id}" tabindex="-1" aria-labelledby="modalAgregarIngredienteLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalAgregarIngredienteLabel" style="font-size: 16px;">Agregar</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form id="formularioAgregar" method="post" action="CreatePlato">
                                                        <div class="mb-3">
                                                            <label for="nombreAgregar" class="form-label" style="font-size: 14px;">Nombre:</label>
                                                            <input type="text" class="form-control" id="nombre" name="nombre" required >
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="alergenoModificar" class="form-label" style="font-size: 14px;">Tipo:</label> 
                                                            <select class="form-select" id="tipo" name="tipo" required>
                                                                <option value="" selected disabled>Tipo</option>
                                                                <c:forEach items="${tipos}" var="tipo">
                                                                    <option value="${tipo}"> ${tipo.nombre}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="mb-3">
                                                            <c:forEach var="ingrediente" items="${ingredientes}">
                                                                <div class="form-check">
                                                                    <input class="form-check-input" type="checkbox" value="${ingrediente.id}" id="flexCheckDefault" name="ingredientes[]">
                                                                    <label class="form-check-label" for="flexCheckDefault">${ingrediente.nombre}</label>
                                                                </div>
                                                            </c:forEach>
                                                        </div>								
                                                        <div class="mb-3">
                                                            <!-- Boton para cancelar -->
                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="font-size: 14px;">Cancelar</button>
                                                            <!-- Boton para enviar el formulario -->
                                                            <button type="submit" class="btn btn-primary" style="font-size: 14px;">Enviar</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <c:forEach items="${platos}" var="plato">
                                        <tr>
                                            <td>${plato.id}</td>
                                            <td>${plato.nombre}</td>
                                            <td>${plato.tipo}</td> 
                                            <td class="acciones"> 
                                                <!-- Boton que abre el modal para visualizar datos -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalDatos${plato.id}">
                                                    <i class="fa-solid fa-eye"></i>
                                                </button> <!-- Modal para visualizar datos -->
                                                <div class="modal fade" id="modalDatos${plato.id}" tabindex="-1" aria-labelledby="modalDatosLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="modalDatosLabel" style="font-size: 16px;">Datos</h5>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <!-- Aqui puedes mostrar los datos -->
                                                                <p style="font-size: 14px;">Nombre: ${plato.nombre}</p>
                                                                <p style="font-size: 14px;">Tipo: ${plato.tipo}</p>	
                                                                <p style="font-size: 14px;">ingredientes: ${plato.ingredientes}</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="font-size: 14px;">Cerrar</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> 
                                                <!-- Boton que abre el modal para modificar -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalModificar${plato.id}">
                                                    <i class="fa-solid fa-square-pen"></i>
                                                </button>

                                                <!-- Modal para modificar -->
                                                <div class="modal fade" id="modalModificar${plato.id}" tabindex="-1" aria-labelledby="modalModificarLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="modalModificarLabel" style="font-size: 16px;">Modificar</h5>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form id="formularioModificar${plato.id}" method="post" action="UpdatePlato?id=${plato.id}">
                                                                    <div class="mb-3">
                                                                        <label for="nombreModificar${plato.id}" class="form-label" style="font-size: 14px;">Nombre:</label>
                                                                        <input type="text" class="form-control" id="nombreModificar${plato.id}" name="nombre" required value="${plato.nombre}">
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="tipo${plato.id}" class="form-label" style="font-size: 14px;">Tipo:</label>
                                                                        <select class="form-select" id="tipo${plato.id}" name="tipo" required>
                                                                            <option value="" selected disabled>Tipo</option>
                                                                            <c:forEach items="${tipos}" var="tipo">
                                                                                <option value="${tipo}" ${tipo.nombre.equals(plato.tipo.nombre) ? 'selected' : ''}> ${tipo.nombre}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </div>
                                                                    <div class="mb-3">
                                                                        <label for="ingredientes${plato.id}" class="form-label" style="font-size: 14px;">Ingredientes:</label>
                                                                        <c:forEach var="ingrediente" items="${ingredientes}">
                                                                        
                                                                        	<input type="checkbox" value="${ingrediente.id}" name="ingredientes[]"
                                                                        	<c:forEach items="${plato.ingredientes}" var="ingredientePlato">
                                                                        		<c:if test="${ingrediente.id == ingredientePlato.id}">
                                                                        			checked
                                                                        		</c:if>
                                                                        	</c:forEach> 
                                                                        	/> ${ingrediente.nombre}
                                                                        	
                                                                        </c:forEach>
                                                                    </div>
                                                                    <div class="mb-3">
			                                                            <!-- Boton para cancelar -->
			                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="font-size: 14px;">Cancelar</button>
			                                                            <!-- Boton para enviar el formulario -->
			                                                            <button type="submit" class="btn btn-primary" style="font-size: 14px;">Enviar</button>
			                                                        </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- Boton que abre el modal de eliminacion -->
                                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalEliminar${plato.id}">
                                                    <i class="fa-solid fa-square-minus"></i>
                                                </button>

                                                <!-- Modal de eliminacion -->
                                                <div class="modal fade" id="modalEliminar${plato.id}" tabindex="-1" aria-labelledby="modalEliminarLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="modalEliminarLabel" style="font-size: 16px;">Confirmacion de eliminacion</h5>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body" style="font-size: 14px;">
                                                                ¿Estas seguro de que quieres eliminar este elemento?
                                                            </div>
                                                            <div class="modal-footer">
                                                                <!-- Boton para cancelar -->
                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" style="font-size: 14px;">Cancelar</button>
                                                                <!-- Boton para confirmar la eliminacion -->
                                                                <a href="DeletePlato?id=${plato.id}" class="btn btn-danger" style="font-size: 14px;">Eliminar</a>
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
