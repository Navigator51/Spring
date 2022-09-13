function piu() {
    let password = $("#password")[0];
    let repeatPassword =$("#repeat-password")[0];
    let body = {
        login: $("#login")[0],
        password: password
    }
    if(password === repeatPassword) {
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