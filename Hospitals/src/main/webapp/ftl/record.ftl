<!DOCTYPE html>
<html>
<head>
    <title>Record</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
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
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownH" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Hospitals
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownD" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Doctors
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownP" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Procedures
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" role="button" aria-haspopup="true" aria-expanded="false" style="padding-right: auto">
                    Hello, ${UserName}
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

<main role="main" class="container">
    <div class="container">
        <div class="row">

            <form method="get">
                <div class="form-group">
                    <label for="selectHospital">Hospital</label>
                    <select class="form-control" id="selectHospital">
                        <#--Если что сделать так-->
                        <#--<c:forEach var="hospital" items="${hospitals}">-->
                            <#--<option value="${hospital.id}">${hospital.address}</option>-->
                        <#--</c:forEach>-->
                         <#list hospitals as hospital>
                            <option value="${hospital.id}">${hospital.address}</option>
                         </#list>
                    </select>
                </div>
                <#--<div class="form-group">-->
                    <#--<label for="exampleSelect2">Example multiple select</label>-->
                    <#--<select multiple class="form-control" id="exampleSelect2">-->
                        <#--<option>1</option>-->
                        <#--<option>2</option>-->
                        <#--<option>3</option>-->
                        <#--<option>4</option>-->
                        <#--<option>5</option>-->
                    <#--</select>-->
                <#--</div>-->
                <#--<div class="form-group">-->
                    <#--<label for="exampleTextarea">Example textarea</label>-->
                    <#--<textarea class="form-control" id="exampleTextarea" rows="3"></textarea>-->
                <#--</div>-->
                <#--<div class="form-group">-->
                    <#--<label for="exampleInputFile">File input</label>-->
                    <#--<input type="file" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp">-->
                    <#--<small id="fileHelp" class="form-text text-muted">This is some placeholder block-level help text for the above input. It's a bit lighter and easily wraps to a new line.</small>-->
                <#--</div>-->
                <#--<fieldset class="form-group">-->
                    <#--<legend>Radio buttons</legend>-->
                    <#--<div class="form-check">-->
                        <#--<label class="form-check-label">-->
                            <#--<input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios1" value="option1" checked>-->
                            <#--Option one is this and that&mdash;be sure to include why it's great-->
                        <#--</label>-->
                    <#--</div>-->
                    <#--<div class="form-check">-->
                        <#--<label class="form-check-label">-->
                            <#--<input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios2" value="option2">-->
                            <#--Option two can be something else and selecting it will deselect option one-->
                        <#--</label>-->
                    <#--</div>-->
                    <#--<div class="form-check disabled">-->
                        <#--<label class="form-check-label">-->
                            <#--<input type="radio" class="form-check-input" name="optionsRadios" id="optionsRadios3" value="option3" disabled>-->
                            <#--Option three is disabled-->
                        <#--</label>-->
                    <#--</div>-->
                <#--</fieldset>-->
                <#--<div class="form-check">-->
                    <#--<label class="form-check-label">-->
                        <#--<input type="checkbox" class="form-check-input">-->
                        <#--Check me out-->
                    <#--</label>-->
                <#--</div>-->
                <button type="submit" class="btn btn-primary">Record</button>
            </form>
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