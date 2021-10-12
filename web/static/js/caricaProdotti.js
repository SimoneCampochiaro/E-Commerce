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
            div4.innerHTML=`<button class="add-to-cart" id="${prodotto.idProdotto}">Aggiungi al carrello</button>`
            div4.querySelector("button").addEventListener("click",function (e){
                let idProdottoCarrello= (e.currentTarget.id)
                console.log("Ho cliccato" )
                //addToCartClicked(e, idProdottoCarrello, div1.innerHTML, div2.innerHTML);
                addItemToCart(idProdottoCarrello, div1.innerHTML, div2.innerHTML);
            })
            document.querySelector('.products').appendChild(productTemplate)

        })



        function addItemToCart (id, name, price) {
            var productRow = document.createElement('div');
            productRow.classList.add('product-row');
            productRow.classList.add('row');
            productRow.setAttribute('id','product-row-'+id)
            var productCartName= document.createElement('div');
            productCartName.classList.add('cart-name');
            productCartName.classList.add('col-6');
            productCartName.innerHTML=`<div class="name">${name}</div>`
            var productCartPrice= document.createElement('div')
            productCartPrice.classList.add('cart-price')
            productCartPrice.classList.add('col-3')
            productCartPrice.innerHTML=`<div class="price">${price}</div>`
            var quantita= document.createElement('div')
            quantita.classList.add('cart-number')
            quantita.classList.add('col-3')
            quantita.innerHTML=`1`
            productRow.appendChild(productCartName)
            productRow.appendChild(productCartPrice)
            productRow.appendChild(quantita)
            let cartTemplate = document.querySelector('.product-rows')
            cartTemplate.appendChild(productRow)
            console.log(cartTemplate)


        }




    })
}


