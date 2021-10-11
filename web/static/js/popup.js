// open cart modal
const cart = document.querySelector('#cart');
const cartModalOverlay = document.querySelector('.cart-modal-overlay');

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

// end of close cart modal

// add products to cart
const addToCart = document.getElementsByClassName('add-to-cart');
const productRow = document.getElementsByClassName('product-row');

for (var i = 0; i < addToCart.length; i++) {
    button = addToCart[i];
    button.addEventListener('click', addToCartClicked)
}

function addToCartClicked (event) {
    button = event.target;
    var cartItem = button.parentElement;
    var price = cartItem.getElementsByClassName('product-price')[0].innerText;

    var imageSrc = cartItem.getElementsByClassName('product-image')[0].src;
    addItemToCart (price, imageSrc);
    updateCartPrice()
}

function addItemToCart (price, imageSrc) {
    var productRow = document.createElement('div');
    productRow.classList.add('product-row');
    var productRows = document.getElementsByClassName('product-rows')[0];
    var cartImage = document.getElementsByClassName('cart-image');

    for (var i = 0; i < cartImage.length; i++){
        if (cartImage[i].src == imageSrc){
            alert ('This item has already been added to the cart')
            return;
        }
    }

    var cartRowItems = `
  <div class="product-row">
        <img class="cart-image" src="${imageSrc}" alt="">
        <span class ="cart-price">${price}</span>
        <input class="product-quantity" type="number" value="1">
        <button class="remove-btn">Remove</button>
        </div>
        
      `
    productRow.innerHTML = cartRowItems;
    productRows.append(productRow);
    productRow.getElementsByClassName('remove-btn')[0].addEventListener('click', removeItem)
    productRow.getElementsByClassName('product-quantity')[0].addEventListener('change', changeQuantity)
    updateCartPrice()
}
// end of add products to cart

// Remove products from cart
const removeBtn = document.getElementsByClassName('remove-btn');
for (var i = 0; i < removeBtn.length; i++) {
    button = removeBtn[i]
    button.addEventListener('click', removeItem)
}

function removeItem (event) {
    btnClicked = event.target
    btnClicked.parentElement.parentElement.remove()
    updateCartPrice()
}

// update quantity input
var quantityInput = document.getElementsByClassName('product-quantity')[0];

for (var i = 0; i < quantityInput; i++){
    input = quantityInput[i]
    input.addEventListener('change', changeQuantity)
}

function changeQuantity(event) {
    var input = event.target
    if (isNaN(input.value) || input.value <= 0){
        input.value = 1
    }
    updateCartPrice()
}
// end of update quantity input

// update total price
function updateCartPrice() {
    var total = 0
    for (var i = 0; i < productRow.length; i += 2) {
        cartRow = productRow[i]
        var priceElement = cartRow.getElementsByClassName('cart-price')[0]
        var quantityElement = cartRow.getElementsByClassName('product-quantity')[0]
        var price = parseFloat(priceElement.innerText.replace('$', ''))
        var quantity = quantityElement.value
        total = total + (price * quantity )

    }
    document.getElementsByClassName('total-price')[0].innerText =  '$' + total

    document.getElementsByClassName('cart-quantity')[0].textContent = i /= 2
}
// end of update total price

// purchase items
const purchaseBtn = document.querySelector('.purchase-btn');

const closeCartModal = document.querySelector('.cart-modal');

purchaseBtn.addEventListener('click', purchaseBtnClicked)

function purchaseBtnClicked () {
    alert ('Thank you for your purchase');
    cartModalOverlay.style.transform= 'translateX(-100%)'
    var cartItems = document.getElementsByClassName('product-rows')[0]
    while (cartItems.hasChildNodes()) {
        cartItems.removeChild(cartItems.firstChild)

    }
    updateCartPrice()
}
// end of purchase items

//alert user if cart is empty

/////////////////////////////////////////

window.addEventListener("load", function (Event) {
    var queryString = window.location.search;
    var urlParams = new URLSearchParams(queryString);
    var idAnagraficaPassato = urlParams.get('idAn');

    let urlApi = "http://localhost:8080/api/get-consegne-inattesa-anagrafica/" + idAnagraficaPassato
    carica(urlApi)

    let ordinati = document.querySelector('#ordinati')
    let inAttesa = document.querySelector('#inattesa')
    let etichetta = document.querySelector('#etichetta')
    ordinati.addEventListener("click", function (e){
        inAttesa.classList.remove("nascondi")
        ordinati.classList.add("nascondi")
        etichetta.innerHTML="Lista libri ordinati"
        urlApi = "http://localhost:8080/api/get-consegne-ordinati-anagrafica/" + idAnagraficaPassato
        carica(urlApi)
    })

    inAttesa.addEventListener("click", function (e){
        ordinati.classList.remove("nascondi")
        inAttesa.classList.add("nascondi")
        etichetta.innerHTML="Lista libri in attesa di prenotazione"
        urlApi = "http://localhost:8080/api/get-consegne-inattesa-anagrafica/" + idAnagraficaPassato
        carica(urlApi)
    })

    let conferma = document.querySelector('#conferma')
    conferma.addEventListener("click", function (e) {

        let dataConsegnaIn = document.querySelector('#dataConsegnaIn')
        if (dataConsegnaIn.value != "") {
            let d = dataConsegnaIn.value.split('-')
            let anno = parseInt(d[0])
            let mese = "" + (parseInt(d[1]) + 1)
            let giorno = parseInt(d[2])
            if (mese > 12) {
                mese = 1;
                anno++;
            }
            let dataR = anno + "-" + mese + "-" + giorno
            let recordDaAggiornare=[];
            console.log(urlApi)
            console.log(dataConsegnaIn.value)
            console.log(dataR)
            fetch(urlApi,
                {
                    method: "GET"
                }).then(function (response){
                return response.json()
            }).then(function (data) {
                for(let i=0;i<data.length;i++) {
                    let record = {
                        idConsegna: data[i].idConsegna,
                        descrizione: data[i].descrizione,
                        anagrafica: data[i].anagrafica,
                        dataConsegna: dataConsegnaIn.value,
                        dataRestituzione: dataR,
                        libro: data[i].libro
                    }
                    recordDaAggiornare[i] = record;
                    console.log(recordDaAggiornare)
                    let urlPut= 'http://localhost:8080/api/update-consegne'
                    fetch(urlPut,{
                        method:'PUT',
                        headers:{
                            "content-type":"application/json",
                            "Accept":"*/*",
                            "Accept-Encoding":"gzip,deflate,br",
                            "Connection":"keep-live"
                        },
                        body: JSON.stringify(recordDaAggiornare),
                    }).then(function (response){
                        console.log(response);
                        // return response.json()
                    }).then(data => {
                        console.log('Success:', data);
                    });
                }
            })


        } else {
            let mErrore= document.querySelector('#dataErrore')
            mErrore.classList.remove("nascondi")
        }

    })
})


function carica(urlApi){
    let divProdotti=document.querySelector('#prodotti');
    divProdotti.innerHTML="";
    fetch(urlApi,
        {
            method: "GET"
        }).then(function (response) {
        console.log(response)
        return response.json()
    }).then(function (data) {
        console.log(data)
        for (let i=0; i<data.length; i++){

            let nominativoOrdine=document.querySelector('#Nominativo');
            nominativoOrdine.innerHTML="Le prenotazioni di "+ data[i].anagrafica.nome
            let div= document.createElement("div")
            div.classList.add("d-flex")
            div.classList.add("flex-row")
            div.classList.add("justify-content-between")
            div.classList.add("align-items-center")
            let img= document.createElement("img")
            img.src=data[i].libro.urlCopertina;
            let div1= document.createElement("div")
            let a= document.createElement("a")
            a.href="ProductShow.html?idLib=" + data[i].libro.idLibro;
            a.innerHTML= data[i].libro.titolo
            let div2= document.createElement("div")
            div2.innerHTML ="N. 1"
            let bnt= document.createElement("button")
            bnt.classList.add("bObj")
            bnt.type="button"
            bnt.value=data[i].libro.idLibro
            bnt.innerHTML="Elimina"
            div.appendChild(img)
            div1.appendChild(a)
            div.appendChild(div1)
            div.appendChild(div2)
            div.appendChild(bnt)

            divProdotti.appendChild(div)

        }
    })







