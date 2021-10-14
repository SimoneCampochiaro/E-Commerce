window.addEventListener("load", function (Event) {
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);
    var mostra = urlParams.get('q')
    console.log("mostra "+mostra);
    carica(mostra);
    caricaOrdini(3);

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

        console.log(data)
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
        let div7=clientTemplate.querySelector('.cliente-provincia')
        div7.innerHTML=`${data.provincia}`
        let div8=clientTemplate.querySelector('.cliente-email')
        div8.innerHTML=`${data.email}`



    })



}

function caricaOrdini(id) {
    let urlApi = "http://localhost:8080/api/get-ordine-where/"+id

    console.log(urlApi)
    fetch(urlApi,
        {
            method: "GET"
        }).then(function (response) {
        console.log(response)
        return response.json()
    }).then(function (data) {
        let ord =document.querySelector('#order-name');
        console.log(data)
        for(let i=0; i<data.length; i++ ){
            let div= document.createElement('div');
            div.innerHTML= data[i]
            ord.appendChild(div)
        }

    })



}


