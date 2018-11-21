<%--
  Created by IntelliJ IDEA.
  User: Almaz
  Date: 23.10.2018
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <title>Users</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<script>
    function initialize() {
        $("#send").on("click", function () {
            $.ajax({
                type: 'POST',
                url: '/users',
                data: {
                    product_id: $("#product_id").val()
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
                    'product_id' +
                    '</th>' +
                    '</tr>';

                for (let i = 0; i < data.length; i++) {
                    tableHtml += '<tr>' +
                        '<td>' + data[i].id + '</td>' +
                        '<td>' + data[i].product_id + '</td>' +
                        '</tr>';
                }
                tableHtml += '</table>';
                $("#users_table").html(tableHtml);
            }).fail(function () {
                alert('ALL BAD')
            });
        });
    }
</script>
<body onload="initialize()">
<div>
    <label for="name">Имя пользователя</label>
    <br>
    <input id="name" placeholder="Name">
    <br>
    <button id="send">Send</button>
    <%--<button onclick="sendUser(document.getElementById('product_id').value)" id="send">Send</button>--%>
</div>
<div id="users_table">

</div>
</body>
</html>
