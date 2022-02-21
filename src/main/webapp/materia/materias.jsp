<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumnos</title>
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
                    <h1 class="text-center">Materias</h1>
                    <p class="text-center">Ingresa, modifica o elimina una materia.</p>
                    <hr>
                </div>
            </div>                       

            <div class="row mt-4 my-2 justify-content-end">
                <div class="col-auto">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalForm"> 
                        + Agregar materia
                    </button>
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover table-striped">
                        <thead class="table-dark">
                            <tr>                                
                                <th class="text-center">Id</th>
                                <th class="text-center">Nombre</th>
                                <th class="text-center">Costo</th>                                
                                <th class="text-center"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="materia" items="${materias}">
                                <tr>                                
                                    <td class="text-center">${materia.idMateria}</td>
                                    <td class="text-center">${materia.nombre}</td>
                                    <td class="text-center">$ ${materia.costo}</td>                                
                                    <td class="text-center">
                                        <a href="${pageContext.request.contextPath}/MateriaControllerServlet?accion=getById&id=${materia.idMateria}" class="btn btn-warning">
                                            <i class="fas fa-edit"></i>
                                        </a>
                                        <a href="${pageContext.request.contextPath}/MateriaControllerServlet?accion=delete&id=${materia.idMateria}" class="btn btn-danger" onclick="return confirm('Estas seguro de querer eliminar el registro?')">
                                            <i class="fas fa-trash-alt"></i>
                                        </a>                                 
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>            
        </div>

        <%@include file="modalMateria.jsp" %>        

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
