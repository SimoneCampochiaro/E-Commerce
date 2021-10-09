window.addEventListener("load",function()
{
    document.getElementById("search").addEventListener("keyup",function()
    {
        var cerca = this.value.toLowerCase();

        var all = documents.querySelectorAll(".products");

        for(let i of all)
        {
            let item = i.innerHTML.toLowerCase();
            if(item.indexOf(cerca) == -1){i.classList.add("hide");}
            else{i.classList.remove("hide");}
        }
    })
})