window.addEventListener("load", function (Event) {
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);
    var mostra = urlParams.get('q=1')
    console.log("mostra "+mostra);
    carica(mostra);

})

function carica(q) {

    let urlApi = "http://localhost:8080/api/get-cliente/"+q

    console.log(urlApi)
    console.log(q)
    fetch(urlApi,
        {
            method: "GET"
        }).then(function (response) {
        console.log(response)
        return response.json()
    }).then(function (data) {

        console.log(data) //Cancellare dopo aver fatto la post request
        let clientTemplate = document.querySelector('.cliente');
        clientTemplate.setAttribute("q", 'cliente-' + data.idCliente)
        let div1=clientTemplate.querySelector('.cliente-nome')
        div1.innerHTML=`${data.nominativo}`
        let div2=clientTemplate.querySelector('.cliente-username')
        div2.innerHTML=`${data.usernameCliente}`
        let div3=clientTemplate.querySelector('.cliente-cf')
        div3.innerHTML=`${data.codiceFiscale}`
        let div4=clientTemplate.querySelector('.cliente-indirizzo')
        div4.innerHTML=`${data.indirizzo}`
        let div5=clientTemplate.querySelector('.cliente-localita')
        div5.innerHTML=`${data.localita}`
        let div6=clientTemplate.querySelector('.cliente-cap')
        div6.innerHTML=`${data.cap}`


    })



}
