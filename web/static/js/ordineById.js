window.addEventListener("load", function (Event) {


    $(callInitiate);
    let urlApi = "http://localhost:8080/api/get-ordine-where"
    console.log(urlApi)
    fetch(urlApi)
        .then(response => response.json())
        .then(data => console.log(data))
        .then(function (data) {
            data.forEach(ordine =>{
        let div = document.querySelector(`.order-product`)
        div.innerHTML =`${ordine.idOrdine}`;
        let div1 =document.querySelector('.order-price');
        div1.innerHTML = `${ordine.importo}`;
            })
    })
})
