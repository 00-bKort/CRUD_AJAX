$(document).ready(inicio);
function inicio() {
    $('#consulta').click(consultar);
}
function consultar() {
    $.ajax({
        method: "GET",
        url: "/consulta/all",
        success: function (response) {
            response.forEach(i => {
                $('#cConsulta').append('<tr>' +
                    '<td>' + i.idConsulta + '</td>' +
                    '<td>' + i.fecha + '</td>' +
                    '<td>' + i.sintomas + '</td>' +
                    '<td>' + i.diagnostico + '</td>' +
                    '<td>' + i.doctor.nombre + '</td>' +
                    '<td>' + i.paciente.nombre + '</td>' +
                    '</tr>'
                );
            });
        }
    });
}