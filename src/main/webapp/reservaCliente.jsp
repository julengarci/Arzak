<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Arzak</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
        integrity="sha512-fC2c9Y2eD6wEjYvVvSu8B3ji9x5kkT2mzZnC2NzZ8NhE7v0Ot6HQJfeISqpxCgeiTfWGmFVXISvXg2cU39e0kw=="
        crossorigin="anonymous" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">

    <link rel="stylesheet" href="landing.css">
</head>

<body>
    <div class="container-fluid text-center">
        <div class="row" id="nav">
            <!--navbar-->
            <div class="col-4 col-md-2 d-flex align-items-center justify-content-start">
                <a href="Index.jsp" style="text-decoration: none; color: inherit;">
                    <img src="img/Logotipo-Arzak-Since-1897.webp" alt="" style="max-width: 50%; height: auto; float: left;">
                </a>
            </div>
            
            <div class="col-4 offset-2">
            	<c:if test="${fechaIsAfter == true}">
            		<div class="alert alert-success alert-dismissable mx-4" role="alert">
						Reserva creada
						<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
            	</c:if>
            </div>
            
            <div class="col-4 offset-2">
            	<c:if test="${fechaIsAfter == false}">
            		<div class="alert alert-danger alert-dismissable mx-4" role="alert">
						No se pudo crear la reserva
						<button type="button" class="btn-close float-end" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
            	</c:if>
            </div>
            
        </div>

        <div class="row" id="main">
            <!--main-->
            <div class="col-12 col-md-12 d-flex justify-content-center" id="principal">
                <div class="row mb-5">
                    <div class="col-12">
                        <p id="texto">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="well-block" id="formulario-container">
                                        <div class="well-title">
                                            <h2>Reserva tu mesa</h2>
                                        </div>
                                        <form id="formularioAgregar" method="post" action="CreateClienteReserva">
                                            <!-- Contenedor nombre -->
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="nombre">Nombre</label>
                                                        <input id="nombre" name="nombre" type="text" placeholder="Nombre"
                                                            class="form-control input-md">
                                                    </div>
                                                </div>
                                                <!-- Contenedor del email -->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="email">Email</label>
                                                        <input id="email" name="email" type="text" placeholder="E-Mail"
                                                            class="form-control input-md">
                                                    </div>
                                                </div>
                                                <!-- Contenedor telefono -->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="telefono">Teléfono</label>
                                                        <input id="telefono" name="telefono" type="tel"
                                                            placeholder="Teléfono"
                                                            class="form-control input-md" maxlength="9" >
                                                    </div>
                                                </div>
                                                <!-- Contenedor hora-->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="emailModificar" class="control-label">Hora:</label>
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
                                                </div>

                                                <!-- Contenedor fecha-->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="fecha">Fecha</label>
                                                        <input id="fecha" name="fecha" type="date" class="form-control input-md" pattern="\d{4}/\d{2}/\d{2}" placeholder="YYYY/MM/DD">
                                                    </div>
                                                </div>

                                                <!-- Select Basic -->
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label for="personasModificar" class="control-label">Numero de personas:</label>
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
                                                </div>   
                                                <!-- Contenedor Observaciones -->
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label class="control-label" for="observaciones">Observaciones</label>
                                                        <textarea id="observaciones" name="observaciones" type="text" placeholder=""
                                                            class="form-control input-md" rows="3"></textarea>
                                                    </div>
                                                </div>
                                                <!-- Button -->
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <button type="submit" id="singlebutton" name="singlebutton"
                                                            class="btn btn-default">Reservar</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </p>
                    </div>
                </div>
                
            </div>
        </div>

        <div class="row" id="footer">
            <!--footer-->
            <div class="col-6" id="ubicacion" style="margin-top: 2%;">
                <div class="row mt-4">
                    <h1>Donde estamos</h1>
                </div>

                <div class="row">
                    <div class="col">
                        <a href="https://acortar.link/dGsUL3"><i class="bi bi-geo-alt-fill" id="ubicacion"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-6" id="redes">
                <div class="row mt-4">
                    <h1>Redes sociales</h1>
                </div>

                <div class="row">
                    <div class="col-12">
                        <a href="https://www.instagram.com/arzakrestaurant/"><i class="bi bi-instagram"
                                id="instagram"></i></a>
                        <a href="https://www.facebook.com/RestauranteArzak/?locale=es_ES"><i class="bi bi-facebook"
                                id="facebook"></i></a>
                        <a href="https://twitter.com/arzakrestaurant?lang=es"><i class="bi bi-twitter"
                                id="twitter"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>

</html>