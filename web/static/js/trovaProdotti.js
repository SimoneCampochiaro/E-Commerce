window.addEventListener("load",function()
{
    //https://code-boxx.com/filter-search-list-in-javascript/
    document.getElementById("search").addEventListener("keyup",function()
    {
        var cerca = this.value.toLowerCase();

        var all = document.querySelectorAll(".product");

        for(let i of all)
        {
            let item = i.innerHTML.toLowerCase();
            if(item.indexOf(cerca) == -1){i.classList.add("hide");}
            else{i.classList.remove("hide");}
        }
    })
})