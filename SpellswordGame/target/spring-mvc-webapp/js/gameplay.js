/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $('#attack').on('click', attack);
    
});

function attack() {
    
    var myContextPath = $(this).attr('myContextPath');
    var actualPath = requestContextPath + ("/attack");
    
    $.ajax({
        type: 'GET',
        url: actualPath,
        async: false,
        dataType: 'json',
        success: function(combatInfo) {
            $('#playerHealth').text("Player Health: " + combatInfo.playerHealth);
            $('#enemyHealth').text("Enemy Health: " + combatInfo.enemyHealth);
            $('#errorMessage').text(combatInfo.gameStatus);
            console.log("success");
            console.log(combatInfo.playerHealth);
            console.log(combatInfo.enemyHealth);
        },
        error: function(){
          $('#errorMessages').val('Error calling web service. Please try again later.');  
        }
    });
}

