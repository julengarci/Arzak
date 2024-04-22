<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Formulario de Cliente</h1>
    <form action="TestFormulario" method="post">
        <label>ID:</label><br>
        <input type="text" name="id"><br>
        
        <label>Nombre:</label><br>
        <input type="text" name="nombre"><br>
        
        <label>Teléfono:</label><br>
        <input type="text" name="telefono"><br>
        
        <label>Email:</label><br>
        <input type="text" name="email"><br>
        
        <input type="submit" value="Guardar">
    </form>
</body>
</html>