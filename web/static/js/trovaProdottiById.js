window.addEventListener("load", function (Event) {
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);
    var mostra = urlParams.get('q')
    console.log("mostra "+mostra);
    carica(mostra);
})

function carica(q) {
    let urlApi = "http://localhost:8080/api/get-prodotti/"+q

    console.log(urlApi)
    fetch(urlApi,
        {
            method: "GET"
        }).then(function (response) {
        console.log(response)
        return response.json()
    }).then(function (data) {

        console.log(data)
            let productTemplate = document.querySelector('.prodotto');
            productTemplate.setAttribute("id", 'prodotto' + data.idProdotto)
            let div=productTemplate.querySelector(`.prodotto-img_dettagli`)
            div.innerHTML=`<img id="${data.idProdotto}" class="img_dettagli" src="${data.linkImmagine}">`
            let div1=productTemplate.querySelector('.prodotto-nome')
            div1.innerHTML=`${data.componente}`
            let div3=productTemplate.querySelector('.prodotto-prezzo')
            div3.innerHTML=`${data.prezzoDiVendita + "&#8364"}`
            let div4=productTemplate.querySelector('.prodotto-quantita')
            div4.innerHTML=`${data.quantita}`
            let div5=productTemplate.querySelector('.prodotto-disponibilita')
            div5.innerHTML=`${data.disponibilita}`
            let div6=productTemplate.querySelector('.prodotto-descrizione')
            div6.innerHTML=`${data.descrizione}`
            let div7=productTemplate.querySelector('.prodotto-codice-ian')
            div7.innerHTML=`${data.codiceIan13}`


        })



}
