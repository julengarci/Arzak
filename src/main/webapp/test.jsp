<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Arzak</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
    integrity="sha512-fC2c9Y2eD6wEjYvVvSu8B3ji9x5kkT2mzZnC2NzZ8NhE7v0Ot6HQJfeISqpxCgeiTfWGmFVXISvXg2cU39e0kw=="
    crossorigin="anonymous" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css" rel="stylesheet">

  <link rel="stylesheet" href="style.css">
</head>

<body>
  <div class="container-fluid h-100">
    <div class="row h-100">
      <div class="col-1 bg-light sidebar">
        <div class="row">gestion clientes</div>
        <div class="row">gestion menus</div>
        <div class="row">gestion platos</div>
        <div class="row">gestion ingrediente</div>
        <div class="row">gestion reservas</div>
      </div>

      <div class="col-11 bg-light main-content">
        <div class="row" id="nav">
          <!-- navbar -->
          <div class="col-4 col-md-2 d-flex align-items-center justify-content-start">
            <a href="index.jsp" style="text-decoration: none; color: inherit;">
              <img src="Logotipo-Arzak-Since-1897.webp" alt=""
                style="max-width: 50%; height: auto; float: left;">
            </a>
          </div>
        </div>


        <table class="table table-secondary table-striped">
          <!-- main -->
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">FECHA</th>
              <th scope="col">HORA</th>
              <th scope="col">NUMPERSONAS</th>
              <th scope="col">ALERGENOS</th>
              <th scope="col">OBSERVACIONES</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${reservas}" var="reserva" >
                <tr>
                    <td>${reserva.id}</td>
                    <td>${reserva.fecha}</td>
                    <td>${reserva.hora}</td>
                    <td>${reserva.numPersonas}</td>
                    <td>${reserva.alergenos}</td>
                    <td>${reserva.observaciones}</td>
                </tr>
            </c:forEach>
        </tbody>
        </table>

        <div class="row" id="footer">
          <!-- footer -->
          <div class="col-6" id="ubicacion" style="margin-top: 2%;">
            <div class="row">
              <h1>Donde estamos</h1>
            </div>

            <div class="row">
              <div class="col">
                <a href="https://acortar.link/dGsUL3"><i class="bi bi-geo-alt-fill" id="ubicacion"></i></a>
              </div>
            </div>
          </div>

          <div class="col-6" id="redes">
            <div class="row">
              <h1>Redes sociales</h1>
            </div>

            <div class="row">
              <div class="col-12">
                <a href="https://www.instagram.com/arzakrestaurant/"><i class="bi bi-instagram" id="instagram"></i></a>
                <a href="https://www.facebook.com/RestauranteArzak/?locale=es_ES"><i class="bi bi-facebook"
                    id="facebook"></i></a>
                <a href="https://twitter.com/arzakrestaurant?lang=es"><i class="bi bi-twitter" id="twitter"></i></a>
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