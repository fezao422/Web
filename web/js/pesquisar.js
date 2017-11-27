function pesquisar(termo, id){
    var req = new XMLHttpRequest();
    req.onreadystatechange = function (){
        if (this.readyState === 4 && this.status === 200){
            document.getElementById("postagens").innerHTML = req.responseText;
        }  
    };
    req.open("GET", "Postagem\?termo="+termo+"&id="+id, true);
    req.send();
}
    // pesquesa das postagens 