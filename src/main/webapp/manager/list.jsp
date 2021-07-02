<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .carousel-inner {
            padding-top: 73px;
        }

        .d-flex {
            order: -1;
            grid-column: span 12;
            text-align: center;
            display: inline-block;
        }

        .d-flex form {
            display: flex;
            max-width: 380px;
            border: 1px solid #eee;
            border-radius: 30px;
            margin-left: auto;
        }

        .header-right form button {
            background: transparent;
            color: #fff;
            border: none;
            padding-right: 10px;
        }

        option {
            color: #000;
        }

        .header-right form {
            margin: 0;
        }

        .d-flex form select {
            padding: 0 20px 0 30px;
            border: none;
            -moz-appearance: none;
            -webkit-appearance: none;
            appearance: none;
            border-bottom-left-radius: 13px;
            border-top-left-radius: 13px;
        }



    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
            <div class="container-fluid">
                <img src="https://scontent.xx.fbcdn.net/v/t1.15752-9/200090586_220758086427514_6453941962505498841_n.png?_nc_cat=105&ccb=1-3&_nc_sid=aee45a&_nc_ohc=sUDZXm3mNh8AX9LHDYQ&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=86ad0ae368a44f4599d62d43871e1e51&oe=60E0A7F7"
                     alt="aab" width="10%">
                <a class="navbar-brand" href="/controller">Xhome </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <div class="dropdown">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button"
                               style="color: black;background-color: white" id="dropdownMenuLink"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Category
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <c:forEach items="${listCategory}" var="c">
                                    <li><a class="dropdown-item"
                                           href="/categoryController?action=showByIdCategory&id=${c.id}">${c.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </ul>

                    <div class="navbar-nav me-auto mb-2 mb-lg-0 ">
                        <form class="d-flex" action="/search" method="get">
                            <select name="action" class="form-control">
                                <option value="book">Book</option>
                                <option value="category">Category</option>
                            </select>
                            <input type="text" name="name"/>
                            <button type="submit" style="color: black" class="btn btn-outline-primary">Search</button>
                        </form>
                    </div>
<%--                    <div class="col-3 p-2">--%>
<%--                        <a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button"--%>
<%--                           aria-controls="offcanvasExample" style="width: 200px"> Sign In </a>--%>
<%--                        <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample"--%>
<%--                             aria-labelledby="offcanvasExampleLabel">--%>
<%--                            <div class="offcanvas-header">--%>
<%--                                <h5 class="offcanvas-title" id="offcanvasExampleLabel">Welcome! </h5>--%>
<%--                                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"--%>
<%--                                        aria-label="Close"></button>--%>
<%--                            </div>--%>
<%--                            <div class="offcanvas-body">--%>
<%--                                <div>--%>
<%--                                    <h1>Login Admin</h1>--%>
<%--                                    <form action="">--%>
<%--                                        <div class="mb-3">--%>
<%--                                            <label for="exampleInputEmail1" class="form-label">User Name</label>--%>
<%--                                            <input type="email" class="form-control" id="exampleInputEmail1"--%>
<%--                                                   aria-describedby="emailHelp" name="username">--%>
<%--                                        </div>--%>
<%--                                        <div class="mb-3">--%>
<%--                                            <label for="exampleInputPassword1" class="form-label">Password</label>--%>
<%--                                            <input type="password" class="form-control" id="exampleInputPassword1">--%>
<%--                                        </div>--%>
<%--                                        <div class="mb-3 form-check">--%>
<%--                                            <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
<%--                                            <label class="form-check-label" for="exampleCheck1">Remember--%>
<%--                                                information </label>--%>
<%--                                        </div>--%>
<%--                                        <div class="row">--%>
<%--                                            <div class="col-4">--%>
<%--                                                <button type="submit" class="btn btn-primary"--%>
<%--                                                        style="float: left; width: 100%; height: 100%">Sign In--%>
<%--                                                </button>--%>
<%--                                            </div>--%>
<%--                                            <div class="col-8">--%>
<%--                                                <button type="submit" class="btn btn-primary"--%>
<%--                                                        style="float: left;width: 100%; height: 100%"> Haven't an--%>
<%--                                                    account yet? Register now--%>
<%--                                                </button>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                    </form>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                        aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3"
                        aria-label="Slide 4"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4"
                        aria-label="Slide 5"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://sachhay24h.com/uploads/images/dac-nhan-tam-1.jpg"
                         class="d-block w-100" alt="honda-cbr1000rrr">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Dac Nhan Tam </h5>
                        <p>Dale Carnegie </p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://images8.alphacoders.com/476/thumb-1920-476792.jpg" class="d-block w-100"
                         alt="yzf-r1m">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Cua So Tam Hon </h5>
                        <p>Is Me</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://hinhanhdep.net/wp-content/uploads/2017/12/hinh-anh-cuon-sach-dep-7.jpg"
                         class="d-block w-100" alt="gsx1000r">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Nguon Chi Thuc Vo Tan</h5>
                        <p>Hoc Nay, Hoc Mai</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://motosaigon.vn/wp-content/uploads/2019/03/gia-xe-ducati-panigale-v4-r-2019-motosaigon-4.jpg"
                         class="d-block w-100" alt="gsx1000r">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Ducati Panigale V4R</h5>
                        <p>Some representative placeholder content for the third slide.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://photo-cms-nghenhinvietnam.zadn.vn/w700/Uploaded/2021/zdjwpkrwq/2018_03_27/s1000rr/xedoisong_bmw_s1000rr_carbon_h16_uiup.jpg"
                         class="d-block w-100" alt="gsx1000r">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>BMW S1000RR </h5>
                        <p>Some representative placeholder content for the third slide.</p>
                    </div>
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>
    <div class="col-2"></div>
</div>
<div class="container">
    <div class="row mt-3">
        <c:forEach items="${listBook}" var="b">
            <%--            <a href="#">--%>
            <div class="col-3">
                <div class="card">
                    <a href="/controller?action=contentBook&id=${b.id}">
                        <img style="height: 350px" src="${b.img}"
                             class="card-img-top" alt="...">
                    </a>
                    <div class="card-body">
                        <h5 class="card-title">${b.name}</h5>
                        <p class="card-text">
                            Author : ${b.author}
                        </p>
                        <div>

                            <form action="/controller" method="get">
                                <input type="number" name="id" value="${b.id}" hidden>
                                <input type="text" name="action" value="contentBook" hidden>
                                <button type="submit" class="btn btn-outline-primary">Chi tiet</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <%--            </a>--%>
        </c:forEach>


    </div>
</div>

<div class="row mt-3" style="text-align: center; height: 280px">
    <div class="col-1"></div>
    <div class="col-2">
        <button type="button" class="btn btn-outline-primary"
                style="height: 100%; width: 100%; background-image: url(https://www.holac.de/wp-content/uploads/service-icon.png); background-size: 100%"></button>
    </div>
    <div class="col-2">
        <button type="button" class="btn btn-outline-secondary"
                style="height: 100%; width: 100%; background-image: url(https://st3.depositphotos.com/8440746/18803/v/1600/depositphotos_188039626-stock-illustration-service-icon-vector-customer-star.jpg); background-size: 100%"></button>
    </div>
    <div class="col-2">
        <button type="button" class="btn btn-outline-success"
                style="height: 100%; width: 100%; background-image: url(https://www.iconpacks.net/icons/1/free-information-icon-1086-thumb.png); background-size: 100%"></button>
    </div>
    <div class="col-2">
        <button type="button" class="btn btn-outline-danger"
                style="height: 100%; width: 100%; background-image: url(https://thumbs.dreamstime.com/b/vector-icon-car-steering-wheel-driver-s-hands-layers-gro-grouped-easy-editing-illustration-your-design-120684635.jpg); background-size: 100%"></button>
    </div>
    <div class="col-2">
        <button type="button" class="btn btn-outline-warning"
                style="height: 100%; width: 100% ; background-image: url(https://user-images.githubusercontent.com/10880610/73298918-1f43de80-4206-11ea-8f42-073ecce7bf9f.jpg); background-size: 100%"></button>
    </div>
    <div class="col-1"></div>
</div>
<div class="row mt-3"></div>

<!-- Footer -->
<footer class="text-center text-lg-start bg-light text-muted">
    <!-- Section: Social media -->
    <section
            class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom"
    >
        <!-- Left -->
        <div class="me-5 d-none d-lg-block">
            <span>Get connected with us on social networks:</span>
        </div>
        <!-- Left -->

        <!-- Right -->
        <div>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-google"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-instagram"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-linkedin"></i>
            </a>
            <a href="" class="me-4 text-reset">
                <i class="fab fa-github"></i>
            </a>
        </div>
        <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
        <div class="container text-center text-md-start mt-5">
            <!-- Grid row -->
            <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <!-- Content -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3"></i>Company name
                    </h6>
                    <p>
                        Here you can use rows and columns to organize your footer content. Lorem ipsum
                        dolor sit amet, consectetur adipisicing elit.
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Products
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Angular</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">React</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Vue</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Laravel</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Useful links
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Pricing</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Settings</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Orders</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Help</a>
                    </p>
                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Contact
                    </h6>
                    <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                    <p>
                        <i class="fas fa-envelope me-3"></i>
                        info@example.com
                    </p>
                    <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                    <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                </div>
                <!-- Grid column -->
            </div>
            <!-- Grid row -->
        </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        © 2021 Copyright:
        <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
</footer>
<!-- Footer -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>