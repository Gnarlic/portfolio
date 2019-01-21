/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {


    $('#attack').on('click', attack);
    $('#changeWeapon').on('click', listWeapons);
    $('.selectWeapon').on('click', selectWeapon);


});

function selectWeapon(clickedId) {
    
    var actualPath = requestContextPath + ("/selectWeapon/" + clickedId);
    
    $.ajax({
        type: 'GET',
        url: actualPath,
        dataType: 'json',
        success: function (weapon) {
            $('#weapon').empty();
            $('#weapon').append('Weapon: '+weapon.name + ' Attack: ' + weapon.minDmg +'-'+weapon.maxDmg + ' (Crit: ' + weapon.critDmg + ')');
            $('#weaponList').empty();
            console.log(weapon.name);
            console.log(weapon.minDmg);
            console.log(clickedId);
        },
        error: function () {
            $('#errorMessages').val('Error calling web service. Please try again later.');
        }
    });
    
}

function listWeapons() {

    var myContextPath = $(this).attr('myContextPath');
    var actualPath = requestContextPath + ("/listWeapons");

    $.ajax({
        type: 'GET',
        url: actualPath,
        async: false,
        dataType: 'json',
        success: function (weapons) {
            $('#weaponList').empty();
            weapons.forEach(function (weapon) {
                $('#weaponList').append('<div><a id="' + weapon.weaponId + '" class="selectWeapon" onClick="selectWeapon(this.id)"><button>' + weapon.name + '</button></div>')
                console.log(weapon.critDmg);
            });

        },
        error: function () {
            $('#errorMessages').val('Error calling web service. Please try again later.');
        }
    });

}

function attack() {

    var myContextPath = $(this).attr('myContextPath');
    var actualPath = requestContextPath + ("/attack");

    $.ajax({
        type: 'GET',
        url: actualPath,
        async: false,
        dataType: 'json',
        success: function (combatInfo) {
            $('#playerHealth').text("Player Health: " + combatInfo.playerHealth);
            $('#enemyHealth').text("Enemy Health: " + combatInfo.enemyHealth);
            $('#errorMessage').text(combatInfo.gameStatus);
            console.log("success");
            console.log(combatInfo.playerHealth);
            console.log(combatInfo.enemyHealth);
        },
        error: function () {
            $('#errorMessages').val('Error calling web service. Please try again later.');
        }
    });
}

