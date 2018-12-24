<!DOCTYPE html>
<html>
<head>

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <title>Record</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<script>
    $(document).on('change', '.test-1', function () {
        var selectedDoctor = $("#selectHospital").val();
        $.ajax({
            type: 'get',
            url: '/recordprocedures',
            data: {
                hospital_id: selectedDoctor
            }
        }).done(function (data) {
            var option = "";
            for (var i = 0; i < data.length ; i++){
                option += '<option value=' + data[i].id + '>' + data[i].name +  '</option>';
            }
            $("#selectProcedure").html(option);
        });
    });

    $(document).on('change', '.test-2', function () {
        var selectedDoctor = $("#selectHospital").val();
        var selectedProcedure = $("#selectProcedure").val();
        $.ajax({
            type: 'get',
            url: '/recorddoctors',
            data: {
                hospital_id: selectedDoctor,
                procedure_id: selectedProcedure
            }
        }).done(function (data) {
            var option = "";
            for (var i = 0; i < data.length ; i++){
                option += '<option value=' + data[i].id + '>' + data[i].lastName +  '</option>';
            }
            $("#selectDoctor").html(option);
        });
    });

    $(document).on('change', '.test-4', function () {
        var selectedDoctor = $("#selectDoctor").val();
        var selectedDate = $("#selectDate").val();

        $.ajax({
            type: 'get',
            url: '/recordtime',
            // dataType: 'json',
            data: {
                doctor_id: selectedDoctor,
                date: selectedDate
            }
        }).done(function (data) {
            var option = "";
            for (var i = 0; i < data.length ; i++){
                option += '<option value=' + data[i].id + '>' + data[i].time +  '</option>';
            }
            $("#selectTime").html(option);
        });
    })

</script>
<body background= "img/wallpaper.jpg">

<nav class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-flex">

    <a class="navbar-brand" href="file://C:\Users\Almaz\Desktop\Khamedzhanov_11_702\Hospitals\src\main\webapp\jsp\starterPageAfterLogin.jsp#">
        <img src="img/logo_withHS.png" width="109" height="49" >
        <!--  <img src="logo_withHS.png">  -->
        <!-- <h1>HS</h1> --></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/starterPage">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="button">
                    Hospitals
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/doctors" role="button">
                    Doctors
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/procedures" role="button">
                    Procedures
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/history" role="button" aria-haspopup="true" aria-expanded="false" style="padding-right: auto">
                    Hello
                </a>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<#--TODO:-->
<#--выбор больницы-->
<#--выбор врача-->
<#--время-->
<#--процедура (связать с доктором и показом номера кабинета)-->

<#--история посещений-->

<main role="main" class="container" style="padding-top: 10vw">
    <div class="container" style="background: aliceblue">
        <div class="row">
            <#if user?? >
                <div class="card col-md-6">
                    <#--<h4> Hospital: ${hospital}</h4>-->
                    <h3>Здесь будут данные о записи на прием</h3>
                        <h5>Больница</h5>
                        <h5>Доктор</h5>
                        <h5>Процедура (мб цена)</h5>
                        <h5>Номер кабинета</h5>
                        <h5>Время</h5>


                </div>
            <#else>
                <form method="post" action="/record">
                    <div class="form-group">
                        <label for="selectHospital">Hospital</label>
                        <select class="form-control test-1" id="selectHospital" name="hospital_id">
                            <#--Если что сделать так-->
                            <#--<c:forEach var="hospital" items="${hospitals}">-->
                                <#--<option value="${hospital.id}">${hospital.address}</option>-->
                            <#--</c:forEach>-->
                             <#list hospitals as hospital>
                                <option value="${hospital.id}">${hospital.address}</option>
                             </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="selectProcedure">Procedure</label>
                        <select class="form-control test-2" id="selectProcedure" name="procedure_id">
                            <#-- <#list procedures as procedure>
                                 <option value="${procedure.id}">${procedure.name}</option>
                             </#list>-->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="selectDoctor">Doctor</label>
                        <select class="form-control test-3" id="selectDoctor" name="doctor_id">
                             <#--<#list doctors as doctor>
                                &lt;#&ndash;<option value="${doctor.id}">${doctor.firstName}</option>&ndash;&gt;
                             </#list>-->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="selectDate">Date</label>
                        <#--<select class="form-control test-4" id="selectDate" name="date">-->
                        <#--</select>-->
                        <input class="form-control test-4" type="date" name="date" id="selectDate">
                     <#--<input type="time" name="cron" value="03:15" min="08:00" max="17:00">-->
                    </div>
                    <div class="form-group">
                        <label for="selectTime">Time</label>
                        <select class="form-control test-5" id="selectTime" name="time">

                        </select>
                        <#--<input type="datetime-local" name="calendar" id="selectTime"  value="03:15" min="08:00" max="17:00">-->
                        <#--<input type="time" name="cron" value="03:15" min="08:00" max="17:00">-->
                    </div>

                    <button type="submit" class="btn btn-primary">Record</button>
                </form>
            </#if>
        </div>
    </div>
</main>

<#--<script>-->
    <#--function selectDoctor(btnId) {-->
        <#--$.ajax({-->
            <#--type: 'post',-->
            <#--url: '/record',-->
            <#--data: {-->
                <#--doctor_id: btnId-->
            <#--}-->
        <#--}).done(function (data) {-->
            <#--var tableHtml = "";-->
            <#--tableHtml += '<table>';-->
            <#--tableHtml +=-->
                <#--'<tr>' +-->
                <#--'<th>' +-->
                <#--'Doctors' +-->
                <#--'</th>' +-->
                <#--// '<th>' +-->
                <#--// 'count' +-->
                <#--// '</th>' +-->
                <#--'</tr>';-->
            <#--for (var i = 0; i < data.length; i++) {-->
                <#--tableHtml += '<tr>' +-->
                        <#--'<td>' + data[i].lastName + '</td>' +-->
                        <#--'</tr>';-->

                <#--tableHtml += '<table id="delete">';-->
                <#--tableHtml += "<tr>";-->
                <#--tableHtml += '<td><button onclick="deleteProduct(' + data[i].id + ')" ">Delete </button></td>'-->
                <#--tableHtml += "</tr>";-->
                <#--tableHtml += "</table>";-->
            <#--}-->
            <#--tableHtml += '</table>';-->
            <#--$("#products_table").html(tableHtml);-->
        <#--}).fail(function () {-->
            <#--alert('ALL BAD')-->
        <#--});-->
    <#--}-->
<#--</script>-->



</body>
</html>