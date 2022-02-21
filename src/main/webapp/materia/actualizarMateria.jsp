
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://kit.fontawesome.com/9fbd14239f.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="../bodyParts/menu.jsp" %>

        <div class="container">

            <div class="row mt-4">
                <div class="col-md-12">
                    <h2 class="text-center">Actualizar materia</h2>                    
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <hr/>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-md-4 ">
                    <form action="${pageContext.request.contextPath}/MateriaControllerServlet?accion=update" method="POST">                        
                        <label class="form-label">Id materia</label>
                        <input class="form-control" type="text" name="idMateria" value="${materia.idMateria}">                        
                        
                        <label class="form-label">Nombre</label>
                        <input class="form-control" type="text" name="nombre" value="${materia.nombre}">

                        <label class="form-label">Costo</label>
                        <input class="form-control" type="text" name="costo" value="${materia.costo}">                        
                        
                        <div class="mt-4 text-center">
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/MateriaControllerServlet">Regresar</a>
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>

                    </form>
                </div>
            </div>
        </div> 
    </body>
</html>
