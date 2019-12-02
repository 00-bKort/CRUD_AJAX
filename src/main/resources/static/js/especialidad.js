$(document).ready(inicio);
function inicio() {
    $('#esp').click(especialidad);
}
function especialidad() {
    $('#espe').show();
    $.ajax({
        method: "GET",
        url: "/especialidad/all",
        success: function (response) {
            response.forEach(i => {
                $('#cEsp').append('<tr>' + '<td>' + i.id + '</td>' + '<td>' + i.especialidad + '</td>' + '</tr>');
            });
        }
    });
}