$(document).ready(function () {

  loadDVDs();

  $('#createButton').click(function(event) {
    $('#dvdTableDiv').hide();
    $('#createDiv').show();
  });

  $('#add-button').click(function(event){
    $.ajax({
      type:'POST',
      url:'http://localhost:8080/dvd',
      data: JSON.stringify({
        title: $('#add-title').val(),
        releaseYear: $('#add-release-year').val(),
        director: $('#add-director').val(),
        rating: $('#add-rating').val(),
        notes: $('#add-notes').val()
      }),
      headers: {
        'Accept':'application/json',
        'Content-Type':'application/json'
      },
      'dataType': 'json',
      success: function() {
        $('#add-title').val('');
        $('#add-release-year').val('');
        $('#add-director').val('');
        $('#add-rating').val('');
        $('#add-notes').val('');

        loadDVDs();
        // $('#createDiv').hide();
        // $('#dvdTableDiv').show();

      },
      error: function() {
          $('#errorMessages')
             .append($('<li>')
             .attr({class: 'list-group-item list-group-item-danger'})
             .text('Error calling web service.  Please try again later.'));
      }
    });
    $('#createDiv').hide();
    $('#dvdTableDiv').show();
  });

  $('#edit-button').click(function(event) {
    $.ajax({
      type:'PUT',
      url:'http://localhost:8080/dvd/'+ $('#edit-dvd-id').val(),
      data: JSON.stringify({
        dvdId: $('#edit-dvd-id').val(),
        title: $('#edit-title').val(),
        releaseYear: $('#edit-release-year').val(),
        director: $('#edit-director').val(),
        rating: $('#edit-rating').val(),
        notes: $('#edit-notes').val()
      }),
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
       'dataType': 'json',
       success: function() {
         $('#errorMessages').empty();
         hideEditForm();
         loadDVDs();
         $('#dvdTableDiv').show();
       },
       error: function() {
         $('#errorMessages')
            .append($('<li>')
            .attr({class: 'list-group-item list-group-item-danger'})
            .text('Error calling web service.  Please try again later.'));
       }
    })
  });

  $('#back-button').click(function(event){
    $('#displayDvd').hide();
    $('#dvdTableDiv').show();
  });

  $('#searchButton').click(function(event){
      $('#searchContentRows').empty();
    var searchContentRows = $('#searchContentRows');

    $.ajax({
      type:'GET',
      // url:'http://localhost:8080/dvds/title/'+ $('#searchTerm').val(),
        url:'http://localhost:8080/dvds/'+$('#selectSearchCategory').val() + '/'+ $('#searchTerm').val(),
      success: function(data, status) {
        $.each(data, function(index, dvd) {
          var title = dvd.title;
          var releaseYear = dvd.releaseYear;
          var director = dvd.director;
          var rating =  dvd.rating;
          var notes = dvd.notes;
          var dvdId = dvd.dvdId;

          var row = '<tr>';
              row += '<td>' + title + '</td>';
              row += '<td>' + releaseYear + '</td>';
              row += '<td>' + director + '</td>';
              row += '<td>' + rating + '</td>';
              row += '<td>' + notes + '</td>';
              row += '</tr>';

            searchContentRows.append(row);

            $('#dvdTableDiv').hide();
            $('#searchResultDvdTable').show();
      });
      }
    })
  });
  $('#back-button2').click(function(event){
    $('#searchResultDvdTable').hide();
    $('#dvdTableDiv').show();
  });

});

function loadDVDs() {

  clearDvdTable();

  var contentRows = $('#contentRows');

  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/dvds',
    success: function(data, status) {
      $.each(data, function(index, dvd) {
        var title = dvd.title;
        var releaseYear = dvd.releaseYear;
        var director = dvd.director;
        var rating =  dvd.rating;
        var notes = dvd.notes;
        var dvdId = dvd.dvdId;

        var row = '<tr>';
            row += '<td><a onclick="displayMovie(' + dvdId + ')">' + title + '</a></td>';
            row += '<td>' + releaseYear + '</td>';
            row += '<td>' + director + '</td>';
            row += '<td>' + rating + '</td>';
            row += '<td>' + notes + '</td>';
            row += '<td><a onclick="showEditForm(' + dvdId +')">Edit</a></td>';
            row += '<td><a onclick="deleteDvd(' + dvdId +')">Delete</a></td>';
            row += '</tr>';

          contentRows.append(row);
    });
  },
  error: function() {
    $('#errorMessages')
        .append($('<li>')
        .attr({class: 'list-group-item list-group-item-danger'})
        .text('Error calling web service.  Please try again later.'));
    }
  });
}


function clearDvdTable() {
    $('#contentRows').empty();
}

function hideAddForm() {
  $('#createDiv').hide();
  $('#dvdTableDiv').show();
}

function showEditForm(dvdId) {
  $.ajax({
    type:'GET',
    url:'http://localhost:8080/dvd/' + dvdId,
    success: function(data, status) {
      $('#edit-title').val(data.title);
      $('#edit-release-year').val(data.releaseYear);
      $('#edit-director').val(data.director);
      $('#edit-rating').val(data.rating);
      $('#edit-notes').val(data.notes);
      $('#edit-dvd-id').val(data.dvdId);
    },
    error: function() {
      $('#errorMessages')
         .append($('<li>')
         .attr({class: 'list-group-item list-group-item-danger'})
         .text('Error calling web service.  Please try again later.'));
    }
  });
  $('#dvdTableDiv').hide();
  $('#editFormDiv').show();
}

function hideEditForm() {
  $('#editFormDiv').hide();
  $('#dvdTableDiv').show();
}

function deleteDvd(dvdId) {
  var confirmDelete = confirm('Do you want to delete this dvd from the collection?');
  if (confirmDelete == true){
  $.ajax({
    type: 'DELETE',
    url: 'http://localhost:8080/dvd/' + dvdId,
    success: function() {
      loadDVDs();
    },
    error: function() {
      $('#errorMessages')
         .append($('<li>')
         .attr({class: 'list-group-item list-group-item-danger'})
         .text('Error calling web service.  Please try again later.'));
    }

  });
}
else {
  return false;
}
}

function displayMovie(dvdId) {
$('#displayDvd').show();
$('#dvdTableDiv').hide();

  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/dvd/'+ dvdId,
    success: function(data, status) {


        $('#movieTitle').append(data.title);
        $('#movieReleaseYear').append(data.releaseYear);
        $('#movieDirector').append(data.director);
        $('#movieRating').append(data.rating);
        $('#movieNotes').append(data.notes);

    },
    erro: function() {
      $('#errorMessages')
         .append($('<li>')
         .attr({class: 'list-group-item list-group-item-danger'})
         .text('Error calling web service.  Please try again later.'));
    }
  });
      $('#movieTitle').empty();
      $('#movieReleaseYear').empty();
      $('#movieDirector').empty();
      $('#movieRating').empty();
      $('#movieNotes').empty();
}
