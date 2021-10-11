window.addEventListener("load", function (Event) {
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);
    var mostra = urlParams.get('id')
    console.log(mostra);
    carica(mostra);
})

function carica(id) {
    let urlApi = "http://localhost:8080/api/get-prodotti/"

    console.log(urlApi)
    fetch(urlApi,
        {
            method: "GET"
        }).then(function (response) {
        console.log(response)
        return response.json()
    }).then(function (data) {

        console.log(data) //Cancellare dopo aver fatto la post request
        data.forEach(prodotto=>{
            let productTemplate = document.querySelector('.product').cloneNode(true);
            productTemplate.classList.remove('d-none')
            productTemplate.setAttribute("id", 'product-' + prodotto.idProdotto)
            let div=productTemplate.querySelector(`.product-image`)
            let redirect = "dettagli.html?q=" +prodotto.idProdotto
            div.innerHTML=`<a target="_blank" href="${redirect}">
                           <img id="${prodotto.idProdotto}"class="product-image" value="${prodotto.linkImmagine}" src="${prodotto.linkImmagine}">
                           </a>
                           `
            let div1=productTemplate.querySelector('.product-name')
            div1.innerHTML=`${prodotto.componente}`
            let div2=productTemplate.querySelector('.product-price')
            div2.innerHTML=`${prodotto.prezzoDiVendita + "&#8364"}`
            let div3=productTemplate.querySelector('.product-quantity')
            div3.innerHTML=`${prodotto.quantita}`
            let div4=productTemplate.querySelector('.product-button')
            div4.innerHTML='<button class="add-to-cart" id="${prodotto.idProdotto}">Aggiungi al carrello</button>'


            document.querySelector('.products').appendChild(productTemplate)

        })


    })
}