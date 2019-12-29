$(function () {


    var user = JSON.parse(localStorage.getItem('user'));


    // alert(user.token);

    $('#username').val(user.token);

});
