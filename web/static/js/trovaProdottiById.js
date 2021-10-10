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
        data.forEach(prodotto=>{
            let productTemplate = document.querySelector('.prodotto');
            productTemplate.setAttribute("q", 'prodotto-' + prodotto.idProdotto)
            let div=productTemplate.querySelector(`.prodotto-img_dettagli`)
            div.innerHTML=`<img id="${prodotto.idProdotto}" src="${prodotto.linkImmagine}">`
            let div1=productTemplate.querySelector('.prodott-nome')
            div1.innerHTML=`${prodotto.componente}`
            let div3=productTemplate.querySelector('.prodotto-prezzo')
            div3.innerHTML=`${prodotto.prezzoDiVendita + "&#8364"}`
            let div4=productTemplate.querySelector('.prodotto-quantita')
            div4.innerHTML=`${prodotto.quantita}`
            let div5=productTemplate.querySelector('.prodotto-disponibilita')
            div5.innerHTML=`${prodotto.disponibilita}`
            let div6=productTemplate.querySelector('.prodotto-descrizione')
            div6.innerHTML=`${prodotto.descrizione}`
            let div7=productTemplate.querySelector('.prodotto-codice-ian')
            div7.innerHTML=`${prodotto.codiceIan13}`


        })


    })
}
