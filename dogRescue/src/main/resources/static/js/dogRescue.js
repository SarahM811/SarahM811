$(document).ready(function () {
    $('#searchButton').click(function (event) {
         event.preventDefault();
        search();
    });
    $('#searchButtonAdoption').click(function (event) {
        event.preventDefault();
        searchFromAdoption();
    });
    $('#AdminSearchButton').click(function (event) {
        event.preventDefault();
        AdminSearch();
    });
    $('#adoptionReportSearchButton').click(function (event) {
        event.preventDefault();
        adoptionReportSearch();
    });
    // $(document).on('click', '#dataDiv', function() {

    //     var selectedId = $(this).find("#dataDiv").eq(0).html();
    //     window.location.href = "display?id=" + selectedId;
    // });

});
function search() {
    $('#searchResultDiv').empty();
    var searchResult = $('#searchResultDiv');
    var selected = $('#lifestageSelect').val();
    var userinput = $('#userinputDiv').val();

    
    var baseUrl = 'http://localhost:8080/search/' + selected;

    $.ajax({
        type: 'GET',
        // url: 'http://localhost:8080/search/' + selected + '?userinput=' + userinput,
        url: buildUrl2(baseUrl, {userinput: userinput}),
        success: function (data, status) {
            console.log(data);
            $('#searchResultContent').show();
            $.each(data, function (index, data) {
                var id = data.id;
                var name = data.name;
                var age = data.age;
                var breed = (data.breed).name;
                var size = (data.size).type;
                var price = data.adoptionPrice;
                var trainLevel = (data.trainLevel).level;
                var lifestage = data.lifeStage.stage;
                var adoption = data.adoption;
                var description = data.description;
                var imagepath = data.imagepath;

                var row = '<div id="dataDiv"> <div class="row"> <div class="col-md-4"><img src="'+imagepath+'" width="200" height="200" /></div> <div class="col-md-4">';             
                row += '<label>Name: </label>' +' '+ name;
                row += '<br><label>Age: </label>' +' '+ age;
                row += '<br><label>Breed: </label>' +' '+ breed;
                row += '<br><label>LifeStage: </label>' +' '+ lifestage + '</div>';
                row += '<div class="col-md-4"> <label>Size:</label>' +' '+ size;
                row += '<br><label>Train Level: </label>'+' ' + trainLevel;
                row += '<br><label>Adoption Fee: </label>' + ' $'+price;
                // row += '<br><label>Description: </label>' + description + '</div>';
                // row += '</div></div><a href="#" th:href="@{/displayDog(id=${dog.id})}" class="btn btn-info">Details</a></div><hr />';
                row += '</div></div><center><a href="display?id=' + id + '" class="btn btn-info">Details</a></center></div><hr />';
                $('#searchResultDiv').append(row);
            });
        },
        error: function (error) {
            console.log(error);
            alert('error');
        }
    });
}

function searchFromAdoption() {
    $('#adoptionSearchResultDiv').empty();
    var searchResult = $('#adoptionSearchResultDiv');
    var selected = $('#lifestageSelect').val();
    var userinput = $('#userinputDiv').val();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/adoption/search/' + selected + '?userinput=' + userinput,
        success: function (data, status) {
            console.log(data);
            $('#adoptionSearchResultContent').show();
            $.each(data, function (index, data) {
                var id = data.id;
                var name = data.name;
                var age = data.age;
                var breed = (data.breed).name;
                var size = (data.size).type;
                var price = data.adoptionPrice;
                var trainLevel = (data.trainLevel).level;
                var lifestage = data.lifeStage;
                var adoption = data.adoption;
                var description = data.description;
                var imagepath = data.imagepath;


                var row = '<div id="dataDiv"> <div class="row"> <div class="col-md-4"><img src="'+imagepath+'" width="200" height="200" /></div> <div class="col-md-4">';
                row += '<label>id: </label>' +' '+ id;
                row += '<br><label>Name: </label>' +' '+ name;
                row += '<br><label>Age: </label>' +' '+ age;
                row += '<br><label>Breed: </label>' +' '+ breed;
                 row += '<br><label>LifeStage: </label>' +' '+ lifestage + '</div>';
                row += '<div class="col-md-4"> <label>Size:</label>' +' '+ size;
                row += '<br><label>Train Level: </label>' +' '+ trainLevel;
                row += '<br><label>Adoption Fee: </label>' +' $'+ price;
                // row += '<br><label>Description: </label>' + description + '</div>';
                // row += '</div></div><a href="#" th:href="@{/displayDog(id=${dog.id})}" class="btn btn-info">Details</a></div><hr />';
                row += '</div></div><center><a href="addAdoption?id=' + id + '" class="btn btn-info">Adopt</a></center></div><hr />';
                $('#adoptionSearchResultDiv').append(row);
            });
        },
        error: function (error) {
            console.log(error);
            alert('error');
        }
    });
}

function AdminSearch() {
    $('#AdminSearchResultDiv').empty();
    var searchResult = $('#AdminSearchResultDiv');
    var selected = $('#lifestageSelect').val();
    var userinput = $('#userinputDiv').val();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/adminDogs/search/' + selected + '?userinput=' + userinput,
        success: function (data, status) {
            console.log(data);
            $('#AdminSearchResultContent').show();
            $.each(data, function (index, data) {
                var id = data.id;
                var name = data.name;
                var age = data.age;
                var breed = (data.breed).name;
                var size = (data.size).type;
                var price = data.adoptionPrice;
                var trainLevel = (data.trainLevel).level;
                var lifestage = data.lifeStage.stage;
                var adoption = data.adoption;
                var description = data.description;
                var imagepath = data.imagepath;

                var row = '<div id="dataDiv"> <div class="row"> <div class="col-md-4"><img src="'+imagepath+'" width="200" height="200" /></div> <div class="col-md-4">';
                row += '<label>id: </label>' +' '+ id;
                row += '<br><label>Name: </label>'+' ' + name;
                row += '<br><label>Age: </label>'+' ' + age;
                row += '<br><label>Breed: </label>'+' ' + breed;
                 row += '<br><label>LifeStage: </label>' +' '+ lifestage + '</div>';
                row += '<div class="col-md-4"> <label>Size:</label>'+' ' + size;
                row += '<br><label>Train Level: </label>'+' ' + trainLevel;
                row += '<br><label>Adoption Fee: </label>' + ' $'+price;
                row += '</div></div><center><a href="editDog?id=' + id + '" class="btn btn-info">Edit</a></center></div><hr />';
                $('#AdminSearchResultDiv').append(row);
            });
        },
        error: function (error) {
            console.log(error);
            alert('error');
        }
    });
}

function adoptionReportSearch() {
    var adoptionReportSearchResultDiv = $('#adoptionReportResultContent');

    adoptionReportSearchResultDiv.hide();

    var userSelect = $('#userSelect').val();
    var fromDate = $('#fromDate').val();
    var toDate = $('#toDate').val();
    var baseUrl = 'http://localhost:8080/adoptionReport/adoptionReportSearch/' + userSelect;
    $.ajax({
        type: 'GET',
        url: buildUrl(baseUrl, {fromdate: fromDate, todate: toDate}),
        success: function (data, status) {

            $('#adoptionReportContentRow').empty();

            $.each(data, function (index, data) {
                var id = data.id;
                var user = data.user.email;
                var dogName = data.dog.name;
                var date = data.date;
                date = date.split('T')[0];

                var row = '<tr class="dataRow">';
                row += '<td>' + id + '</td>';
                row += '<td>' + user + '</td>';
                row += '<td>' + dogName + '</td>';
                row += '<td>' + date + '</td>';
                row += '</tr>';
                $('#adoptionReportContentRow').append(row);
            });

            $('#adoptionReportResultContent').show();
        },
        error: function (error) {
            alert('cant load');
        }

    });
}

function buildUrl(baseUrl, params) {
    var queryParams = [];
    $.each(params, function (key, value) {
        if( value !== "" && value !== null ) queryParams.push(key+"="+value);
    })
    return [ baseUrl , queryParams.join("&") ].join("?");
}

function buildUrl2(baseUrl, params) {
    var queryParams = [];
    $.each(params, function (key, value) {
        if( value !== "" && value !== null ) queryParams.push(key+"="+value);
    })
    return [ baseUrl , queryParams].join("?");
}

