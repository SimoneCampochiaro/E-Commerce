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

        console.log(data) //Cancellare dopo aver fatto la post request
            let productTemplate = document.querySelector('.prodotto');
            productTemplate.setAttribute("q", 'prodotto-' + data.idProdotto)
            let div=productTemplate.querySelector(`.prodotto-img_dettagli`)
            div.innerHTML=`<img id="${data.idProdotto}" class="img_dettagli" src="${data.linkImmagine}">`
            let div1=productTemplate.querySelector('.prodotto-nome')
            div1.innerHTML=`${data.componente}`
            let div2=productTemplate.querySelector('.prodotto-prezzo')
            div2.innerHTML=`${data.prezzoDiVendita + "&#8364"}`
            let div3=productTemplate.querySelector('.prodotto-quantita')
            div3.innerHTML=`${data.quantita}`
            let div4=productTemplate.querySelector('.prodotto-disponibilita')
            if(data.disponibilita === true){
                data.disponibilita = "Disponibile"}
                else
                {
                    data.disponibilita = "Non Disponibile"
                }
            div4.innerHTML=`${data.disponibilita}`
            let div5=productTemplate.querySelector('.prodotto-descrizione')
            div5.innerHTML=`${data.descrizione}`
            let div6=productTemplate.querySelector('.prodotto-codice-ian')
            div6.innerHTML=`${data.codiceIan13}`


        })



}
