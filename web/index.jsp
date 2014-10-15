<%-- 
    Document   : index
    Created on : 12/10/2014, 11:50:34
    Author     : Matheus
--%>

<%@page import="Model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <title>Buscador</title>
        <script src="script.js"></script>
        <script src="jquery-1.8.3.js"></script>
        <style>
            body {
                font-family: Calibri;
            }

            #busca {
                width: 500px;
                height: 25px;
                border-radius: 20px;
                position: relative;
                z-index: 10;
                left: 50%;
            }

            #entra {
                width: 80px;
                height: 25px;
                border-radius: 20px;
                position: relative;
                z-index: 20;
                top: 0px;
                left: 1.9%;
            }

            #container {
                width: 700px;
                height: auto;
                /*border: 1px solid #000;*/
                margin: 0 auto;
            }

            #divResultado {
                width: 100%;
                height: 400px;
                top: 20px;
                position: relative;
                border: 1px solid #000;
                border-radius: 10px;
                overflow: hidden;
                background-color: #aaa;
            }

            #divHeader_Resultado {
                width: 100%;
                height: 25px;
                background-color: #aaa;
                color: #fff;
                border-radius: 10px 10px 0 0;
                margin-bottom: 10px;
            }

            .classImages {
                position: relative;
                width: 150px;
                height: 150px;
                margin: auto 0;
            }

            .classLogo {
                position: absolute;
                width: 80px;
                height: auto;
                right: 34px;
                top: 15px;
            }

            .divProdutos {
                width: 100%;
                height: calc(50% - 25px);
                position: relative;
                border-bottom: dotted 1px #aaa;
            }

            .nomeProduto {
                position: absolute;
                left: calc(150px + 5%);
                top: 10px;
                font-size: 18px;
                font-weight: 900;
            }

            .precoProduto {
                position: absolute;
                left: calc(150px + 45%);
                top: 10px;
                font-size: 18px;
                font-weight: 900;
            }

            .divDescProduto {
                width: calc(100% - 220px);
                height: 40%;
                position: absolute;
                bottom: 50px;
                left: calc(150px + 5%);
            }

            .descProduto {
            }

            .labelPreco {
                position: absolute;
                left: calc(150px + 40%);
                top: 10px;
                font-size: 12px;
                color: #808080;
            }

            .labelDesc {
                font-size: 12px;
                color: #808080;
            }

            .irLoja {
                position: absolute;
                left: calc(150px + 4.6%);
                bottom: 10px;
            }

            #Produtos {
                top: -10px;
                width: 100%;
                height: 89%;
                position: relative;
                overflow-y: auto;
                background-color: #fff;
            }

            #headerLabel {
                position: relative;
                left: 10px;
                top: 3px;
            }

            #paginas {
                width: 75%;
                height: 15px;
                /*border: 1px solid #000;*/
                margin-top: -9px;
                margin-bottom: 0;
                margin-left: auto;
                margin-right: auto;
                text-align: center;
                color: #fff;
            }
            
            .nenhumResultado {
                text-align: center;
            }
            
            #ordenar{
                position: absolute;
                right: 5px;
            }
            
            #labelOrdenar{
                position: absolute;
                right: 120px;
                top: 3px;
            }
        </style>

    </head>

    <body>
        <div id="container">
            <div id="divBusca">
                <form method="GET" action="BuscaServlet">
                    <input id="busca" type="text" name="busca" />
                    <input id="entra" type="submit" value="Buscar" />
                </form>
            </div>
            <%
                ArrayList <Produto>Produtos = (ArrayList) session.getAttribute("produto");
                int lintCont = 0;
            %>
            <div id="divResultado">
                <div id="divHeader_Resultado">
                    <% if (Produtos != null) {
                            if (Produtos.size() != 0) {%>
                            <label id="headerLabel">Mostrando 1 a <%= Produtos.size() %> de um total de <%= Produtos.size() %> produtos</label>
                    <%} else {%>
                    <label id="headerLabel"></label>
                    <%
                            }
                        }
                    %>
                </div>
                <div id="Produtos">
                    <%
                        if (Produtos != null) {
                            if (Produtos.size() != 0) {

                                for (lintCont = 0; lintCont < Produtos.size(); lintCont++) {
                    %>
                    <div class="divProdutos" data-id-div="<%=lintCont%>">
                        <img src="<%=Produtos.get(lintCont).getImg() %>" class="classImages" /><!-- [PRODUTOS].[IMAGEM] -->
                        <label class="nomeProduto"><%=Produtos.get(lintCont).getNome() %></label><!-- [PRODUTOS].[NOME] -->
                        <label class="labelPreco">Preço: </label>
                        <label class="precoProduto"><%=Produtos.get(lintCont).getPreco() %></label><!-- [PRODUTOS].[PRECO] -->
                        <img class="classLogo" src="<%=Produtos.get(lintCont).getLoja() %>" /><!-- [PRODUTOS].[LOJA] -->
                        <div class="divDescProduto">
                            <label class="labelDesc">Descrição do Produto:</label><br />
                            <label class="descProduto"><%=Produtos.get(lintCont).getDesc() %></label> <!-- [PRODUTOS].[DESCRICAO] -->
                        </div>
                        <input type="button" value="Vá para a loja" class="irLoja" onclick="window.open('<%=Produtos.get(lintCont).getLink() %>')"/><!-- [PRODUTOS].[LINK] -->
                    </div>
                    <%}
                    } else {%>
                    <p class="nenhumResultado"> Sua busca não retornou nenhum resultado </p>
                    <% }

                    } else {%>
                    <p class="nenhumResultado"> Sua busca não retornou nenhum resultado </p>
                    <% }%>
                </div>
                <div id="paginas"></div>
            </div>
        </div>

        <script>
            ajustaCss();
            <%
                if (Produtos != null) {
            %>
            criaLinks(<%= Produtos.size()%>);
            
            <%
                }
            %>
        </script>
    </body>
</html>


