window.addEventListener("load", function (Event) {
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);
    var mostra = urlParams.get('id')
    console.log(mostra);
    carica(mostra);
})


let idCarrello= NaN;
const cart = document.querySelector('#cart');
const cartModalOverlay = document.querySelector('.cart-modal-overlay');
const purchaseBtn= document.querySelector('.purchase-btn');
purchaseBtn.addEventListener('click', ()=>{
    if(!isNaN(idCarrello)){
        let urlAPI= "http://localhost:8080/api/save-ordine/"+idCarrello+"/2";
        fetch(urlAPI, {
            method :"POST"
        }).then(r=> r.json()).then((r)=>{
            //alert("Ordine Effettuato. Effettuare il ritiro il :" +r.dataConsegna);
            var url = "http://localhost:8080/api/get-ordine-where";
            fetch(url, {
                method: "POST"
            }).then(
                window.location.replace("http://localhost:63342/E-Commerce/demo/web/profilo.html?q=2"))
        })
    }
})
cart.addEventListener('click', () => {
    if (cartModalOverlay.style.transform === 'translateX(-200%)'){
        cartModalOverlay.style.transform = 'translateX(0)';
    } else {
        cartModalOverlay.style.transform = 'translateX(-200%)';
    }
})
// end of open cart modal

// close cart modal
const closeBtn = document.querySelector ('#close-btn');

closeBtn.addEventListener('click', () => {
    cartModalOverlay.style.transform = 'translateX(-200%)';
});

cartModalOverlay.addEventListener('click', (e) => {
    if (e.target.classList.contains('cart-modal-overlay')){
        cartModalOverlay.style.transform = 'translateX(-200%)'
    }
})


function addItemToCart(id, name, price) {
    var productRow = document.createElement('div');
    productRow.classList.add('product-row');
    productRow.classList.add('row');
    productRow.setAttribute('id', 'product-row-' + id)
    var productCartName = document.createElement('div');
    productCartName.classList.add('cart-name');
    productCartName.classList.add('col-6');
    productCartName.innerHTML = `<div class="name">${name}</div>`
    var productCartPrice = document.createElement('div')
    productCartPrice.classList.add('cart-price')
    productCartPrice.classList.add('col-3')
    productCartPrice.innerHTML = `<span class="price">${price}</span> &#8364`
    var quantita = document.createElement('div')
    quantita.classList.add('cart-number')
    quantita.classList.add('col-3')
    quantita.innerHTML = `1`
    productRow.appendChild(productCartName)
    productRow.appendChild(productCartPrice)
    productRow.appendChild(quantita)
    let cartTemplate = document.querySelector('.product-rows')
    cartTemplate.appendChild(productRow)
    console.log(cartTemplate)


}

function updateCartPrice() {
    const productRow = document.getElementsByClassName('product-row');
    var total = 0
    for (var i = 0; i < productRow.length; i ++) {
        cartRow = productRow[i]
        var priceElement =parseFloat(cartRow.querySelector('.price').innerHTML)
        var quantityElement =parseFloat(cartRow.querySelector('.cart-number').innerHTML)
        total = total + (priceElement * quantityElement )
        console.log(priceElement)
        console.log(quantityElement)
        console.log(cartRow)

    }
    document.getElementsByClassName('total-price')[0].innerText =  total

    document.getElementsByClassName('cart-quantity')[0].textContent = i
}

function performRequest (idProdotto){
    let urlApi="";
    if(isNaN(idCarrello)){
        urlApi="http://localhost:8080/api/save-prodotti-carrello/"+idProdotto

    }else {
        urlApi="http://localhost:8080/api/save-prodotti-carrello/"+idProdotto +"/"+idCarrello
    }
    console.log(urlApi)
    fetch(urlApi,{
        method: "POST"
    }).then(r=> r.json()).then(carrello=> {
        idCarrello= carrello.idCarrello
    })
}

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
        data.forEach(prodotto => {
            let productTemplate = document.querySelector('.product').cloneNode(true);
            productTemplate.classList.remove('d-none')
            productTemplate.setAttribute("id", 'product-' + prodotto.idProdotto)
            let div = productTemplate.querySelector(`.product-image`)
            let redirect = "dettagli.html?q=" + prodotto.idProdotto
            div.innerHTML = `<a target="_blank" href="${redirect}">
                           <img id="${prodotto.idProdotto}"class="product-image" value="${prodotto.linkImmagine}" src="${prodotto.linkImmagine}">
                           </a>
                           `
            let div1 = productTemplate.querySelector('.product-name')
            div1.innerHTML = `${prodotto.componente}`
            let div2 = productTemplate.querySelector('.product-price')
            div2.innerHTML = `${prodotto.prezzoDiVendita}`
            let div3 = productTemplate.querySelector('.product-quantity')
            div3.innerHTML = `${prodotto.quantita}`
            let div4 = productTemplate.querySelector('.product-button')
            div4.innerHTML = `<button class="add-to-cart" id="${prodotto.idProdotto}">Aggiungi al carrello</button>`
            div4.querySelector("button").addEventListener("click", function (e) {
                let idProdottoCarrello = (e.currentTarget.id)
                console.log("Ho cliccato")
                addItemToCart(idProdottoCarrello, div1.innerHTML, div2.innerHTML);
                updateCartPrice();
                performRequest(idProdottoCarrello)
            })
            document.querySelector('.products').appendChild(productTemplate)

        })


    })
}


