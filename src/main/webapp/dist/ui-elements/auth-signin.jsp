<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <title>Đăng nhập</title>
    <link rel="icon" href="../favicon.ico" type="image/x-icon"> <!-- Favicon-->
    <!-- project css file  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/assets/css/my-task.style.min.css">
</head>

<body>

<div id="mytask-layout" class="theme-indigo">

    <!-- main body area -->
    <div class="main p-2 py-3 p-xl-5 ">
        
        <!-- Body: Body -->
        <div class="body d-flex p-0 p-xl-5">
            <div class="container-xxl">

                <div class="row g-0">
                    <div class="col-lg-6 d-none d-lg-flex justify-content-center align-items-center rounded-lg auth-h100">
                        <div style="max-width: 25rem;">
                            <div class="text-center mb-5">
                                 <svg  width="4rem" fill="currentColor" class="bi bi-clipboard-check" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                                    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
                                    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
                                </svg>
                            </div>
                            <div class="mb-5">
                                <h2 class="color-900 text-center">A strong English foundation today, opens vast doors to your future tomorrow.</h2>
                            </div>
                            <!-- Image block -->
                            <div class="">
                                <img src="${pageContext.request.contextPath}/dist/assets/images/login-img.svg" alt="login-img">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 d-flex justify-content-center align-items-center border-0 rounded-lg auth-h100">
                        <div class="w-100 p-3 p-md-5 card border-0 bg-dark text-light" style="max-width: 32rem;">
                            <!-- Form -->
                            <form class="row g-1 p-3 p-md-4" action = "${pageContext.request.contextPath}/signin" method ="post">
                                <div class="col-12 text-center mb-1 mb-lg-5">
                                    <h1>Đăng nhập</h1>
                                    <span>Đăng nhập vào tài khoản của bạn</span>
                                </div>
                                <div class="col-12 text-center mb-4">
                                    <a class="btn btn-lg btn-outline-secondary btn-block" href="#">
                                        <span class="d-flex justify-content-center align-items-center">
                                            <img class="avatar xs me-2" src="${pageContext.request.contextPath}/dist/assets/images/google.svg" alt="Image Description">
                                            Đăng nhập với Google
                                        </span>
                                    </a>
                                    <span class="dividers text-muted mt-4">HOẶC</span>
                                </div>
                                <div class="col-12">
                                    <div class="mb-2">
                                        <label class="form-label">Địa chỉ Email</label>
                                        <input type="text" name ="email" class="form-control form-control-lg" placeholder="name@example.com" >
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="mb-2">
                                        <div class="form-label">
                                            <span class="d-flex justify-content-between align-items-center">
                                                Mật khẩu
                                                <a class="text-secondary" href="auth-password-reset.html">Quên mật khẩu?</a>
                                            </span>
                                        </div>
                                        <input type="password" name ="password" class="form-control form-control-lg" placeholder="***************" >
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Nhớ tài khoản
                                        </label>
                                    </div>
                                </div>
                                <div class="col-12 text-center mt-4">
                                    <!-- <a href="index.html" class="btn btn-lg btn-block btn-light lift text-uppercase" atl="signin">SIGN IN</a> -->
                                    <button type="submit" class="btn btn-lg btn-block btn-light lift text-uppercase">ĐĂNG NHẬP</button>
                                </div>
                                <div class="col-12 text-center mt-4">
                                    <span class="text-muted">Bạn chưa có tài khoản?<a href="${pageContext.request.contextPath}/signup" class="text-secondary"> Đăng ký</a></span>
                                </div>
                            </form>
                            <!-- End Form -->
                        </div>
                    </div>
                </div> <!-- End Row -->
            </div>
        </div>
    </div>
</div>

<!-- Jquery Core Js -->
<script src="${pageContext.request.contextPath}/dist/assets/bundles/libscripts.bundle.js"></script>

</body>
</html>