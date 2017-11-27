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
    
function apagar(id){
    event.preventDefault;
    var req = new XMLHttpRequest();
    req.open("POST", "Postagem", true);
    
    req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    req.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200){
                       
        }
    };
    req.send("id_postagem="+id);
}
