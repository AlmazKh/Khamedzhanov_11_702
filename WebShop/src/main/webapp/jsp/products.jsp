<%--
  Created by IntelliJ IDEA.
  User: Almaz
  Date: 30.10.2018
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <title>Products</title>
</head>
<script>
    function select(btnId) {

            $.ajax({
                type: 'POST',
                url: '/products',
                data: {
                    name: $("#" + btnId).text(),
                    cost: 999
                }
            }).done(function (data) {
                let tableHtml = "";
                tableHtml += '<table>';
                tableHtml +=
                    '<tr>' +
                    '<th>' +
                    'id' +
                    '</th>' +
                    '<th>' +
                    'name' +
                    '</th>' +
                    '<th>' +
                    'cost' +
                    '</th>' +
                    '</tr>';

                for (let i = 0; i < data.length; i++) {
                    tableHtml += '<tr>' +
                        '<td>' + data[i].id + '</td>' +
                        '<td>' + data[i].name + '</td>' +
                        '<td>' + data[i].cost + '</td>' +
                        '</tr>';
                }
                tableHtml += '</table>';
                $("#products_table").html(tableHtml);
            }).fail(function () {
                alert('ALL BAD')
            });

    }
</script>
<body onload="select()">
<div>
    <button onclick="select('product_1')" id="product_1">Product #1</button>
    <button onclick="select('product_2')" id="product_2">Product #2</button>
    <button onclick="select('product_3')" id="product_3">Product #3</button>
    <button id="basket">Basket</button>
    <%--<button onclick="sendUser(document.getElementById('name').value)" id="send">Send</button>--%>
</div>
<div id="products_table">

</div>
</body>
</html>
