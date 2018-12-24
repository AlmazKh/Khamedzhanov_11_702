<!DOCTYPE html>
<html>
<head>
    <title>Doctors</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="text-center" background= "img/wallpaper.jpg">

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

<main role="main" class="container" style="padding-top: 5vw">
    <div class="card" style="background: aliceblue">
        <div class="row justify-content-center">

            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="page-header">List of doctors</h1>

                <form method="post">
                    <div class="row">
                        <div class="col-md-4">
                            <label for="selectHospital">Please, choose hospital</label>
                            <select class="form-control" id="selectHospital" name="hospital_id">
                                <#list hospitals as hospital>
                                    <option value="${hospital.id}">${hospital.address}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-md-4" align="left" style="padding-top: 31px">
                            <button type="submit" class="btn btn-primary">Show</button>
                        </div>
                    </div>
                </form>
                <div class="row">

                    <h2 class="sub-header" style="padding-top: 5vw">Here you can see list of doctors</h2>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Cabinet Number</th>
                                <th>Rating</th>
                            </tr>
                            </thead>
                            <#list doctors as doctor>
                            <tbody>
                            <tr>
                                <td>${doctor?counter}</td>
                                <td>${doctor.firstName}</td>
                                <td>${doctor.lastName}</td>
                                <td>${doctor.cabinetNumber}</td>
                                <td>${doctor.rating}</td>
                            </tr>
                            </tbody>
                            </#list>
                        </table>
                </div>
            </div>
        </div>
    </div>
</main>

<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="starter-template.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous">
</body>
</html>