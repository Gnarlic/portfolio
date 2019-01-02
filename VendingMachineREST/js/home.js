$(document).ready(function(){
    loadItems();
    setInterval(loadItems,5000);

    $(".a").css({"background-color": "transparent", "border": "none" , "outline": "0", 
        "-webkit-shadow-box": "none", "inner-box-shadow": "none" });
    //$("button").css({"box-shadow": "4px 4px 2px lightgrey"});
    $(".card").css({"box-shadow": "4px 4px 2px lightgrey"});
    $("#fundCounter").val("$0.00");

    $("#dollar").on('click',function(){
        funds+=1.00;
        $("#fundCounter").val("$"+funds.toFixed(2).toString());
        console.log(funds);
    });
    $("#quarter").on('click', function(){
        funds+=0.25;
        $("#fundCounter").val("$"+funds.toFixed(2).toString());
        console.log(funds);
    })
    $("#dime").on('click', function(){
        funds+=0.10;
        $("#fundCounter").val("$"+funds.toFixed(2).toString());
        console.log(funds);
    })
    $("#nickel").on('click', function(){
        funds+=0.05;
        $("#fundCounter").val("$"+funds.toFixed(2).toString());
        console.log(funds);
    })

    $("#b1").on('click', function() {
        $('#itemNumber').val('1');
    })
    $("#b2").on('click', function() {
        $('#itemNumber').val('2');
    })
    $("#b3").on('click', function() {
        $('#itemNumber').val('3');
    })
    $("#b4").on('click', function() {
        $('#itemNumber').val('4');
    })
    $("#b5").on('click', function() {
        $('#itemNumber').val('5');
    })
    $("#b6").on('click', function() {
        $('#itemNumber').val('6');
    })
    $("#b7").on('click', function() {
        $('#itemNumber').val('7');
    })
    $("#b8").on('click', function() {
        $('#itemNumber').val('8');
    })
    $("#b9").on('click', function() {
        $('#itemNumber').val('9');
        console.log(funds);
    })

    $("#buyNow").on('click', function(){
        if($("#itemNumber").val()==null||$("itemNumber").val()==="0"||$('#itemNumber').val()>9||$('#itemNumber').val()==''||$('#itemNumber').val()==undefined){
            $('#messageDisplay').val("Please select an item for purchase");

        } else {
            console.log(funds);
            makePurchase(funds);
            $("#fundCounter").val('$' + funds.toFixed(2).toString());
            loadItems();
        }
    })

    $("#returnChange").on('click', function(){
        var changeCount = funds*100;
        console.log(changeCount);
        var quarterCount = (changeCount/25).toFixed(0);
        changeCount = changeCount%25;
        var dimeCount = (changeCount/10).toFixed(0);
        changeCount = changeCount%10;
        var nickelCount = (changeCount/5).toFixed(0);
        changeCount = changeCount%5;
        var pennyCount = (changeCount/1).toFixed(0);
        changeCount = changeCount%1;
        $('#changeReturn').empty();
        $('#changeReturn').append('Quarters: '+((quarterCount)+
         ' &#13;&#10; Dimes: '+(dimeCount)+
         ' &#13;&#10; Nickels: ' + (nickelCount)+
         ' &#13;&#10; Pennies: '+(pennyCount)));
        clearFunds();
    })

});

var funds = 0.00;

function clearForm() {
    for(i = 0; i<=8; i++) {
        $('#button'+(i+1)).empty();
        $('#item'+(i+1)+'Name').empty();
        $('#item'+(i+1)+'Price').empty();
        $('#item'+(i+1)+'Quantity').empty();
    }    
}

function clearFunds() {
    funds = 0.00;
    $("#fundCounter").val('$'+funds.toFixed(2).toString());
}

function makePurchase(funds) {
    var itemId = $("#itemNumber").val();
    var amount = $("#fundCounter").val();
    console.log(itemId + amount);
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/money/'+funds.toFixed(2)+'/item/'+itemId,
        dataType: 'json',
        success: function(change) {
            $('#messageDisplay').val('Thank you!!!');
            $('#changeReturn').empty();
            $('#changeReturn').append('Quarters: '+((change.quarters)+ ' &#13;&#10; Dimes: '+(change.dimes)+' &#13;&#10; Nickels: ' + (change.nickels)+' &#13;&#10; Pennies: '+(change.pennies)));
            console.log(funds);
            clearFunds();
            clearForm();
        },
        error: function(error){
            $('#messageDisplay').val(error.responseJSON.message);
            clearForm();
        }
    });
}

function loadItems() {

    clearForm();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/VendingMachineSpringMVC/getItems',
        success: function(itemArray) {
            for (var i=0; i<=8; i++) {
                $("#button"+(i+1)).append(itemArray[i].id);
                $("#item"+(i+1)+"Name").append(itemArray[i].itemName);
                $("#item"+(i+1)+"Price").append('$' + itemArray[i].itemPrice.toFixed(2).toString());
                $("#item"+(i+1)+"Quantity").append('Quantity: ' + '<br>'+ itemArray[i].itemInventory);

            }
        },
        error: function (){
            $("#errorMessages").val('Error calling web service. Please try again later.');
        }
    });

}

