<!--<th:block th:include="/_header"></th:block>
-->

<div class="header-container">

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
</div>