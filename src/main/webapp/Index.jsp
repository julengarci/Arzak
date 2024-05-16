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
    <div class="row" id="nav"><!--navbar-->
      <div class="col-4 col-md-2 d-flex align-items-center justify-content-start">
        <a href="index.html" style="text-decoration: none; color: inherit;">
          <img src="img/Logotipo-Arzak-Since-1897.webp" alt="" style="max-width: 50%; height: auto; float: left;">
        </a>
      </div>
    </div>

    <div class="row" id="main"><!--main-->
      <div class="col-12 col-md-12" id="principal">
        <div class="row">
          <div class="col-12">
            <p id="texto">
              CUANDO QUIERAS SENTIR Y VIVIR LA COCINA DE ARZAK,AQUÍ ESTAMOS.
            </p>
          </div>

          <div class="col-12">
            <a href="reservaCliente.jsp" class="boton">Reserva</a>
          </div>
        </div>
      </div>
    </div>

    <div class="row" id="footer"><!--footer-->
      <div class="col-6" id="ubicacion" style="margin-top: 2%;">
        <div class="row">
          <h1>Donde estamos</h1>
        </div>

        <div class="row" >
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
            <a href="https://www.facebook.com/RestauranteArzak/?locale=es_ES"><i class="bi bi-facebook" id="facebook"></i></a>
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