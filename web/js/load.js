function load(file){
    var fileref=document.createElement('script');
    fileref.setAttribute("type","text/javascript");
    fileref.setAttribute("src", "js/"+ file+ ".js");
    document.getElementsByTagName("head")[0].appendChild(fileref);
}
//carregar scripts diamicamente em progresso 