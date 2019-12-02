$(document).ready(inicio);
function inicio() {
    $('#paciente').click(paciente);
}
function paciente() {
    $.ajax({
        method: "GET",
        url: "/paciente/all",
        success: function (response) {
            response.forEach(i => {
                $('#cPaciente').append('<tr>' + '<td>' + i.idPaciente + '</td>' + '<td>' + i.nombre + '</td>' + '<td>' + i.direccion + '</td>' + '</tr>');
            });
        }
    });
}