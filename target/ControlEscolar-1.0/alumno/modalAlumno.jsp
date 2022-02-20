<!-- Modal -->
<div class="modal fade" id="modalForm" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar alumno</h5>                
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/AlumnoControllerServlet?accion=add" method="POST" id="formAdd">
                <div class="modal-body">
                    <label class="form-label">Nombre</label>
                    <input class="form-control" type="text" name="nombre">

                    <label class="form-label">Apellido paterno</label>
                    <input class="form-control" type="text" name="apellidoPaterno">

                    <label class="form-label">Apellido materno</label>
                    <input class="form-control" type="text" name="apellidoMaterno">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-success">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
