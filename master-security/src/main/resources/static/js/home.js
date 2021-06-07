$(document).ready(function () {

    $('#searchButton').click(function (event) {

        search();

    });

    $('#back-button').click(function (event) {
        $('#searchResultTable').hide();
        $('#TableDiv').show();
        $('#createButton').show();
    });
    
    $(document).on('click', '.dataRow', function() {
        
        var selectedId = $(this).find("td").eq(0).html();
        window.location.href = "display?id=" + selectedId;
    });

});

function search() {

    $('#searchContentRows').empty();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/search?min=' + $('#min').val() + '&max=' + $('#max').val(),
        success: function (data, status) {
            $('#TableDiv').hide();
            $('#createButton').hide();
            $('#searchResultTable').show();
            $.each(data, function (index, data) {
                var id = data.id;
                var property1 = data.property1;
                var property2 = data.property2;
                var property3 = data.property3;
                var property4 = data.property4;

                var row = '<tr class="dataRow">';
                row += '<td>' + id + '</td>';
                row += '<td>' + property1 + '</td>';
                row += '<td>' + property2 + '</td>';
                row += '<td>' + property3 + '</td>';
                row += '<td>' + property4 + '</td>';
                row += '<td><a href="edit?id=' + id + '">Edit</a> | <a href="delete?id=' + id + '">Delete</a>';
                row += '</tr>';

                $('#searchContentRows').append(row);



            });
        },
        error: function () {
            alert('error');
        }
    });
}