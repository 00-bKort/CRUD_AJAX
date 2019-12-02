$(document).ready(inicio);
function inicio() {
    $('#doctor').click(doctor);
}
function doctor() {
    $('#doc').show();
    $.ajax({
        method: "GET",
        url: "/doctor/all",
        success: function (response) {
            response.forEach(i => {
                $('#cDoctor').append('<tr>' + '<td>' + i.id + '</td>' + '<td>' + i.nombre + '</td>' + '<td>' + i.direccion + '</td>' + '<td>' + i.especialidad.especialidad + '</td>' + '</tr>');
            });
        }
    });
}