// sign up form
const ToggleForm = document.querySelector('.toggle-form');
const ToggleInner = ToggleForm.lastElementChild;
const Login = document.getElementsByClassName('form-control')[0]
const SignUp = document.getElementsByClassName('form-control')[1]

function ChangeForm() {
    if (ToggleInner.classList.contains('actived')) {
        ToggleInner.classList.remove('actived')
        Login.classList.add('logout')
        Login.classList.remove('login-an')
        SignUp.classList.remove('signup')
    } else {
        ToggleInner.classList.add('actived')
        Login.classList.remove('logout')
        Login.classList.add('login-an')
        SignUp.classList.add('signup')
    }
}

function checkResPwd(elem){
    var pwd=document.getElementById("respwd")
    if(pwd.value != elem.value){
        alert("Le password non coincidono")
        pwd.value="";
        elem.value="";
        return false;
    }
}


    const bottone = document.querySelector('.login');
    bottone.addEventListener('click',() =>{
        window.location.replace("http://localhost:63342/E-Commerce/demo/web/shop.html");
    })

ToggleForm.addEventListener('click', ChangeForm)

const menuIcon = document.querySelector
(".hamburger-menu");
const navbar = document.querySelector(".navbar")

menuIcon.addEventListener("click", () =>
{
    navbar.classList.toggle('change');
});

