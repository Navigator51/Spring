function piu() {
    let pasword = $("#password")[0].value;
    let repeatPassword =$("#repeat-password")[0].value;
    let body = {
        login: $("#user_name")[0].value,
        password: pasword
    }
    if(pasword === repeatPassword) {
        $.post( {
            url: "/api/v1/registry/controller",
            contentType: 'application/json',
            data: JSON.stringify(body),
            success: function (response) {
                window.location.replace("/login")
            },
            error: function (response) {
                alert("Что-то пошло не так  " + response.responseText)
            }
            } )
    } else {
        alert("Пароли не совпадают, проверьте правильность ввода")
    }

}