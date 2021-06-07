$(document).ready(function () {

    loadItems();

    var totalMoney = 0;
    var change;

    $('#addDollar').click(function (event) {
        change = $('#changeBox').val();
        if (change == '') {
            totalMoney += 1.00;
            $('#moneyInput').val(totalMoney);
        } else {
            $('#messageBox').val('Take your change.');
        }
    });

    $('#addQuarter').click(function (event) {
        change = $('#changeBox').val();
        if (change == '') {
            totalMoney += 0.25;
            $('#moneyInput').val(totalMoney);
        } else {
            $('#messageBox').val('Take your change.');
        }
    });

    $('#addDime').click(function (event) {
        change = $('#changeBox').val();
        if (change == '') {
            totalMoney += 0.10;
            $('#moneyInput').val(totalMoney);
        } else {
            $('#messageBox').val('Take your change.');
        }
    });

    $('#addNickel').click(function (event) {
        change = $('#changeBox').val();
        if (change == '') {
            totalMoney += 0.05;
            $('#moneyInput').val(totalMoney);
        } else {
            $('#messageBox').val('Take your change.');
        }
    });

    $('#changeReturnButton').click(function (event) {
        $('#changeBox').val('');
        totalMoney = 0;
        $('#moneyInput').val(0);
        $('#messageBox').val('');
        $('#selectedItem').val('');
        loadItems();
    });

    $('#makePurchaseButton').click(function(event) {
        makePurchase();
    });
});

function loadItems() {
    clearItems();

    var itemOptionsDiv = $('#itemOptionsDiv');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function (itemArray) {
            // console.log(itemArray);
            $.each(itemArray, function (index, item) {
                var id = item.id;
                var name = item.name;
                var price = parseFloat(item.price).toFixed(2);
                var quantity = item.quantity;
                var button = '<div class="col-md-4"><button type="button" class="btn btn-default itemButton" onclick="selectItem(' + id + ')">';
                
                button += '<table class="itemTable">';
                button += '<tr><td class="tableId">' + id + '</tr></td>';
                button += '<tr><td class="tableName">' + name + '</tr></td>';
                button += '<tr><td class="tablePrice">' + '$' + price + '</tr></td>';
                button += '<tr><td class="tableQuantity">' + 'Quantity Left: ' + quantity + '</tr></td>';
                button += '</table></button></div>';

                itemOptionsDiv.append(button);
            });
        },
        error: function () {
            alert('Could not generate buttons- error with service.');
        }
    });
}

function selectItem(id) {
    $('#messagesBox').val('');
    $('#messagesBox').empty();
    $('#selectedItem').val(id);
}

function clearItems() {
    $('#itemOptionsDiv').empty();
  }

function makePurchase() {
  clearItems();
    $('#changeBox').val('');
    var itemArray = loadItems();

    if($('#selectedItem').val() == '') {
        $('#messageBox').val('item must be selected');
    } else {
        var itemId = $('#selectedItem').val();
        var moneyInput = $('#moneyInput').val();
        if (moneyInput == '') {
            moneyInput = 0;
          }

        $.ajax({
            type:'GET',
            url:'http://localhost:8080/money/'+ moneyInput + '/item/' +itemId,
            success: function(data, status) {
                returnChange(data);
                $('#messageBox').val('Thank you!!!');
                totalMoney = 0;
            },
            error: function(data) {
                var errorMessage = data.responseJSON.message;
                
                $('#messageBox').val(errorMessage);
            }
        });
    }
}

function returnChange(data) {
    var quarters = data.quarters;
    var dimes = data.dimes;
    var nickels = data.nickels;
    var pennies = data.pennies;
    var change = ('');
    

    if (quarters > 0) {
        change += 'Quarter: ' + quarters + ' ';
    }

    if (dimes > 0) {
        change += 'Dime: ' + dimes + '';
    }

    if (nickels > 0) {
        change += 'Nickel: ' + nickels + '';
    }

    if (pennies > 0) {
        change += 'Pennies: ' + pennies + '';
    }
    if(change == '') {
        change = 'Please press "Change Return" to continue.'
      }

    $('#changeBox').val(change);
    $('#moneyInput').val(0);
   
}