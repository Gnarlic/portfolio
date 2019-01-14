/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('#attack').on('click', attack());
    
});

function attack() {
    
    var myContextPath = $(this).attr('myContextPath');
    var actualPath = myContextPath + ("/attack");
    console.log(myContextPath);
    console.log(actualPath);
    console.log(window.location.pathname);
    console.log(window.location.hostname);
    
    $.ajax({
        type: 'GET',
        url: "http://localhost:8080/SpellswordGame/attack",
        dataType: 'json',
        success: function(combatInfo) {
            $('#test').text(combatInfo.cInfo);
        },
        error: function(){
          $('#errorMessages').val('Error calling web service. Please try again later.');  
        }
    });
}