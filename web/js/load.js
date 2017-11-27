function load(file){
    var fileref=document.createElement('script');
    fileref.setAttribute("type","text/javascript");
    fileref.setAttribute("src", file);
    document.getElementsByTagName("head")[0].appendChild(fileref);
}
//carregar scripts diamicamente 