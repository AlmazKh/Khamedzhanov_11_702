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
            data: {
                doctor_id: selectedDoctor,
                date: selectedDate
            }
        }).done(function (data) {
            var option = "";
            for (var i = 0; i < data.length ; i++){
                option += '<option value=' + data[i].time + '>' + data[i].time +  '</option>';
            }
            $("#selectTime").html(option);
        });
    })

</script>
<body background= "img/wallpaper.jpg" >

<nav class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-flex">

    <a class="navbar-brand" href="/starterPage">
        <img src="img/logo_withHS.png" width="109" height="49" >
    </a>
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
                    History
                </a>
            </li>

        </ul>
    </div>
</nav>

<main role="main" class="container" style="padding-top: 5vw">
    <div class="container">
        <div class="row justify-content-center">
            <div class="card col-md-8" style="background: aliceblue">
                 <#if user?? >
                     <div class="card col-md-6">
                         <h3>Здесь будут данные о записи на прием</h3>
                         <h5>Больница</h5>
                         <h5>Доктор</h5>
                         <h5>Процедура (мб цена)</h5>
                         <h5>Номер кабинета</h5>
                         <h5>Время</h5>


                     </div>
                 <#else>
                <form method="post" action="/record" class="col-md-6" style="padding-top: 2vw">
                    <div class="form-group">
                        <label for="selectHospital">Hospital</label>
                        <select class="form-control test-1" id="selectHospital" name="hospital_id" required="required">
                             <#list hospitals as hospital>
                                 <option value="${hospital.id}">${hospital.address}</option>
                             </#list>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="selectProcedure">Procedure</label>
                        <select class="form-control test-2" id="selectProcedure" name="procedure_id" required="">
                        <#-- <#list procedures as procedure>
                                 <option value="${procedure.id}">${procedure.name}</option>
                             </#list>-->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="selectDoctor">Doctor</label>
                        <select class="form-control test-3" id="selectDoctor" name="doctor_id" required="">
                        <#--<#list doctors as doctor>
                                <#--<option value="${doctor.id}">${doctor.firstName}</option>-->
                             <#--</#list>-->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="selectDate">Date</label>
                        <input class="form-control test-4" type="date" name="date" id="selectDate" required="">
                    </div>
                    <div class="form-group">
                        <label for="selectTime">Time</label>
                        <select class="form-control test-5" id="selectTime" name="time" required="">
                        </select>
                    </div>

                    <button type="submit" class="btn btn-primary">Record</button>
                </form>
                 </#if>
            </div>
        </div>
    </div>
</main>

</body>
</html>