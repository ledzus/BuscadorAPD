/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var mintTotalItens; 

//ajusta os css que necessitarem de algum cálculo
function ajustaCss() {
    $("#busca").css("left", parseFloat($("#busca").css("left")) - (parseFloat($("#busca").css("width")) / 2));
}

//cria os links para as outras páginas
function criaLinks(pintTotalItens) {
    var lintTotalPag = Math.ceil(pintTotalItens / 6);
    var lintCont = 1;
    var lobjFooter = $("#paginas");

    lobjFooter.append('<label id="paginaAnterior" style="margin-right: 15px; cursor: pointer;" onclick="mudaPaginas(' + lintCont + ',' + pintTotalItens + ')">\<\<</label>');

    for (lintCont = 1; lintCont <= lintTotalPag; lintCont++) {
        lobjFooter.append('<label style="margin-right: 15px; cursor: pointer;" onclick="mudaPaginas(' + lintCont + ',' + pintTotalItens + ')">' + lintCont + '</label>');
    }

    lobjFooter.append('<label id="paginaPosterior" style="margin-right: 15px; cursor: pointer;" onclick="mudaPaginas(' + lintCont + ',' + pintTotalItens + ')">\>\></label>');

    mintTotalItens = pintTotalItens;
}

//função que define quais serão os itens mostrados
function mudaPaginas(pintPagina) {

    $(".divProdutos").hide();

    var lintCont = (6 * pintPagina) - 6;
    var lintContAux = 1;
    var lintCont2 = lintCont + 6;

    if (lintCont2 < mintTotalItens) {
        $("#headerLabel").text("Mostrando " + (lintCont + 1) + " a " + (lintCont2) + " de um total de " + mintTotalItens + " produtos.")
    } else {
        $("#headerLabel").text("Mostrando " + (lintCont + 1) + " a " + (mintTotalItens) + " de um total de " + mintTotalItens + " produtos.")
    }
    
    for (lintCont; lintCont < lintCont2; lintCont++) {
        $(".divProdutos").eq(lintCont).show();
    }

}

//Função para inicialização da página
function iniciaPagina(pintTotalItens) {

    $(".divProdutos").hide();

    var lintCont = 1;

    $(".divProdutos").each(function () {
        if (lintCont < 7) {
            if ($(this).data("id-div") == lintCont) {
                $(this).show();
            } else {
                $(this).hide();
            }

            lintCont++;
        }
    });

    //seta controle para saber em qual página está
    $("#paginas").attr("data-control", 1);

}