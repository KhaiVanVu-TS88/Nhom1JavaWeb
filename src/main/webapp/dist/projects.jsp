<!doctype html>
<%@page import="course.model.NguoiDung"%>
<%@page import="course.model.LopHoc"%>
<%@page import="course.model.KhoaHoc"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html class="no-js" lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Khoa hoc</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- Favicon-->

<!-- project css file  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/dist/assets/css/my-task.style.min.css">

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>

<%
List<KhoaHoc> list = (List<KhoaHoc>) request.getAttribute("KhoaHoc");
List<NguoiDung> listNguoiDung = (List<NguoiDung>) request.getAttribute("NguoiDung");
//List<LopHoc> listLopHoc = (List<LopHoc>) request.getAttribute("LopHoc");
%>

<body>

	<div id="mytask-layout" class="theme-indigo">

		<!-- sidebar -->
		<div class="sidebar px-4 py-4 py-md-5 me-0">
			<div class="d-flex flex-column h-100">
				<a href="index.html" class="mb-0 brand-icon"> <span
					class="logo-icon"> <svg width="35" height="35"
							fill="currentColor" class="bi bi-clipboard-check"
							viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
								d="M10.854 7.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 9.793l2.646-2.647a.5.5 0 0 1 .708 0z" />
                            <path
								d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z" />
                            <path
								d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z" />
                        </svg>
				</span> <span class="logo-text">My-Task</span>
				</a>
				<!-- Menu: main ul -->

				<ul class="menu-list flex-grow-1 mt-3">
					<li class="collapsed"><a class="m-link active"
						data-bs-toggle="collapse" data-bs-target="#dashboard-Components"
						href="#"> <i class="icofont-home fs-5"></i> <span>Dashboard</span>
							<span class="arrow icofont-dotted-down ms-auto text-end fs-5"></span></a>
						<!-- Menu: Sub menu ul -->
						<ul class="sub-menu collapse show" id="dashboard-Components">
							<li><a class="ms-link active"
								href="<%=request.getContextPath()%>/Dashboard"> <span>Admin
										Dashboard</span></a></li>
							<li><a class="ms-link"
								href="<%=request.getContextPath()%>/KhoaHocDashboard"> <span>Khóa
										học Dashboard</span></a></li>
						</ul></li>
					<li class="collapsed"><a class="m-link"
						data-bs-toggle="collapse" data-bs-target="#project-Components"
						href="#"> <i class="icofont-briefcase"></i><span>Khóa
								học</span> <span
							class="arrow icofont-dotted-down ms-auto text-end fs-5"></span></a> <!-- Menu: Sub menu ul -->
						<ul class="sub-menu collapse" id="project-Components">
							<!--<li><a class="ms-link" href="projects.html"><span>Khóa học</span></a></li>  -->
							<li><a class="ms-link"
								href="<%=request.getContextPath()%>/KhoaHoc"><span>Khóa
										học</span></a></li>
						</ul></li>

					<li class="collapsed"><a class="m-link"
						data-bs-toggle="collapse" data-bs-target="#client-Components"
						href="#"><i class="icofont-user-male"></i> <span>Giảng
								viên</span> <span
							class="arrow icofont-dotted-down ms-auto text-end fs-5"></span></a> <!-- Menu: Sub menu ul -->
						<ul class="sub-menu collapse" id="client-Components">
							<li><a class="ms-link"
								href="<%=request.getContextPath()%>/giangvien"> <span>Danh
										sách</span></a></li>
							<li><a class="ms-link" href="profile.html"> <span>Hồ
										sơ giảng viên</span></a></li>
						</ul></li>
					<li class="collapsed"><a class="m-link"
						data-bs-toggle="collapse" data-bs-target="#emp-Components"
						href="#"><i class="icofont-users-alt-5"></i> <span>Học
								viên</span> <span
							class="arrow icofont-dotted-down ms-auto text-end fs-5"></span></a> <!-- Menu: Sub menu ul -->
						<ul class="sub-menu collapse" id="emp-Components">
							<li><a class="ms-link"
								href="<%=request.getContextPath()%>/hocvien"> <span>Học
										viên</span></a></li>
							<li><a class="ms-link" href="employee-profile.html"> <span>Hồ
										sơ học viên</span></a></li>
						</ul></li>
				</ul>
				<!-- Theme: Switch Theme -->
				<ul class="list-unstyled mb-0">
					<li class="d-flex align-items-center justify-content-center">
						<div class="form-check form-switch theme-switch">
							<input class="form-check-input" type="checkbox" id="theme-switch">
							<label class="form-check-label" for="theme-switch">Enable
								Dark Mode!</label>
						</div>
					</li>
					<li class="d-flex align-items-center justify-content-center">
						<div class="form-check form-switch theme-rtl">
							<input class="form-check-input" type="checkbox" id="theme-rtl">
							<label class="form-check-label" for="theme-rtl">Enable
								RTL Mode!</label>
						</div>
					</li>
				</ul>

				<!-- Menu: menu collepce btn -->
				<button type="button"
					class="btn btn-link sidebar-mini-btn text-light">
					<span class="ms-2"><i class="icofont-bubble-right"></i></span>
				</button>
			</div>
		</div>
		<!-- end siderbar -->
		<!-- main body area -->
		<div class="main px-lg-4 px-md-4">

			<!-- Body: Header -->
			<div class="header">
				<nav class="navbar py-4">
					<div class="container-xxl">

						<!-- header rightbar icon -->
						<div
							class="h-right d-flex align-items-center mr-5 mr-lg-0 order-1">
							<div class="d-flex">
								<a class="nav-link text-primary collapsed" href="help.html"
									title="Get Help"> <i class="icofont-info-square fs-5"></i>
								</a>
								<div class="avatar-list avatar-list-stacked px-3">
									<img class="avatar rounded-circle"
										src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar2.jpg"
										alt=""> <img class="avatar rounded-circle"
										src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar1.jpg"
										alt=""> <img class="avatar rounded-circle"
										src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar3.jpg"
										alt=""> <img class="avatar rounded-circle"
										src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar4.jpg"
										alt=""> <img class="avatar rounded-circle"
										src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar7.jpg"
										alt=""> <img class="avatar rounded-circle"
										src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar8.jpg"
										alt=""> <span
										class="avatar rounded-circle text-center pointer"
										data-bs-toggle="modal" data-bs-target="#addUser"><i
										class="icofont-ui-add"></i></span>
								</div>
							</div>
							<div class="dropdown notifications zindex-popover">
								<a class="nav-link dropdown-toggle pulse" href="#" role="button"
									data-bs-toggle="dropdown"> <i class="icofont-alarm fs-5"></i>
									<span class="pulse-ring"></span>
								</a>
								<div id="NotificationsDiv"
									class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-sm-end p-0 m-0">
									<div class="card border-0 w380">
										<div class="card-header border-0 p-3">
											<h5
												class="mb-0 font-weight-light d-flex justify-content-between">
												<span>Notifications</span> <span class="badge text-white">11</span>
											</h5>
										</div>
										<div class="tab-content card-body">
											<div class="tab-pane fade show active">
												<ul class="list-unstyled list mb-0">
													<li class="py-2 mb-1 border-bottom"><a
														href="javascript:void(0);" class="d-flex"> <img
															class="avatar rounded-circle"
															src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar1.jpg"
															alt="">
															<div class="flex-fill ms-2">
																<p class="d-flex justify-content-between mb-0 ">
																	<span class="font-weight-bold">Dylan Hunter</span> <small>2MIN</small>
																</p>
																<span class="">Added 2021-02-19 my-Task ui/ux
																	Design <span class="badge bg-success">Review</span>
																</span>
															</div>
													</a></li>
													<li class="py-2 mb-1 border-bottom"><a
														href="javascript:void(0);" class="d-flex">
															<div class="avatar rounded-circle no-thumbnail">DF</div>
															<div class="flex-fill ms-2">
																<p class="d-flex justify-content-between mb-0 ">
																	<span class="font-weight-bold">Diane Fisher</span> <small>13MIN</small>
																</p>
																<span class="">Task added Get Started with Fast
																	Cad project</span>
															</div>
													</a></li>
													<li class="py-2 mb-1 border-bottom"><a
														href="javascript:void(0);" class="d-flex"> <img
															class="avatar rounded-circle sm"
															src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar3.jpg"
															alt="">
															<div class="flex-fill ms-2">
																<p class="d-flex justify-content-between mb-0 ">
																	<span class="font-weight-bold">Andrea Gill</span> <small>1HR</small>
																</p>
																<span class="">Quality Assurance Task Completed</span>
															</div>
													</a></li>
													<li class="py-2 mb-1 border-bottom"><a
														href="javascript:void(0);" class="d-flex"> <img
															class="avatar rounded-circle sm"
															src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar5.jpg"
															alt="">
															<div class="flex-fill ms-2">
																<p class="d-flex justify-content-between mb-0 ">
																	<span class="font-weight-bold">Diane Fisher</span> <small>13MIN</small>
																</p>
																<span class="">Add New Project for App
																	Developemnt</span>
															</div>
													</a></li>
													<li class="py-2 mb-1 border-bottom"><a
														href="javascript:void(0);" class="d-flex"> <img
															class="avatar rounded-circle sm"
															src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar6.jpg"
															alt="">
															<div class="flex-fill ms-2">
																<p class="d-flex justify-content-between mb-0 ">
																	<span class="font-weight-bold">Andrea Gill</span> <small>1HR</small>
																</p>
																<span class="">Add Timesheet For Rhinestone
																	project</span>
															</div>
													</a></li>
													<li class="py-2"><a href="javascript:void(0);"
														class="d-flex"> <img class="avatar rounded-circle sm"
															src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar7.jpg"
															alt="">
															<div class="flex-fill ms-2">
																<p class="d-flex justify-content-between mb-0 ">
																	<span class="font-weight-bold">Zoe Wright</span> <small
																		class="">1DAY</small>
																</p>
																<span class="">Add Calander Event</span>
															</div>
													</a></li>
												</ul>
											</div>
										</div>
										<a class="card-footer text-center border-top-0" href="#">
											View all notifications</a>
									</div>
								</div>
							</div>
							<div
								class="dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center zindex-popover">
								<div class="u-info me-2">
									<p class="mb-0 text-end line-height-sm ">
										<span class="font-weight-bold">Dylan Hunter</span>
									</p>
									<small>Admin Profile</small>
								</div>
								<a class="nav-link dropdown-toggle pulse p-0" href="#"
									role="button" data-bs-toggle="dropdown"
									data-bs-display="static"> <img
									class="avatar lg rounded-circle img-thumbnail"
									src="${pageContext.request.contextPath}/dist/assets/images/profile_av.png"
									alt="profile">
								</a>
								<div
									class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-end p-0 m-0">
									<div class="card border-0 w280">
										<div class="card-body pb-0">
											<div class="d-flex py-1">
												<img class="avatar rounded-circle sm"
													src="${pageContext.request.contextPath}/dist/assets/images/profile_av.png"
													alt="profile">
												<div class="flex-fill ms-3">
													<p class="mb-0">
														<span class="font-weight-bold">Dylan Hunter</span>
													</p>
													<small class="">Dylan.hunter@gmail.com</small>
												</div>
											</div>

											<div>
												<hr class="dropdown-divider border-dark">
											</div>
										</div>
										<div class="list-group m-2 ">
											<a href="task.html"
												class="list-group-item list-group-item-action border-0 "><i
												class="icofont-tasks fs-5 me-3"></i>My Task</a> <a
												href="members.html"
												class="list-group-item list-group-item-action border-0 "><i
												class="icofont-ui-user-group fs-6 me-3"></i>Giảng viên</a> <a
												href="ui-elements/auth-signin.html"
												class="list-group-item list-group-item-action border-0 "><i
												class="icofont-logout fs-6 me-3"></i>Signout</a>
											<div>
												<hr class="dropdown-divider border-dark">
											</div>
											<a href="ui-elements/auth-signup.html"
												class="list-group-item list-group-item-action border-0 "><i
												class="icofont-contact-add fs-5 me-3"></i>Add personal
												account</a>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- menu toggler -->
						<button class="navbar-toggler p-0 border-0 menu-toggle order-3"
							type="button" data-bs-toggle="collapse"
							data-bs-target="#mainHeader">
							<span class="fa fa-bars"></span>
						</button>

						<!-- main menu Search-->
						<div
							class="order-0 col-lg-4 col-md-4 col-sm-12 col-12 mb-3 mb-md-0 ">
							<div class="input-group flex-nowrap input-group-lg">
								<button type="button" class="input-group-text"
									id="addon-wrapping">
									<i class="fa fa-search"></i>
								</button>
								<input type="search" class="form-control" placeholder="Search"
									aria-label="search" aria-describedby="addon-wrapping">
								<button type="button" class="input-group-text add-member-top"
									id="addon-wrappingone" data-bs-toggle="modal"
									data-bs-target="#addUser">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</div>

					</div>
				</nav>
			</div>

			<!-- Body: Body -->
			<div class="body d-flex py-lg-3 py-md-2">
				<div class="container-xxl">
					<div class="row align-items-center">
						<div class="border-0 mb-4">
							<div
								class="card-header p-0 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
								<h3 class="fw-bold py-3 mb-0">Khóa học</h3>
								<div class="d-flex py-2 project-tab flex-wrap w-sm-100">
									<button type="button" class="btn btn-dark w-sm-100"
										data-bs-toggle="modal" data-bs-target="#createKhoaHoc">
										<i class="icofont-plus-circle me-2 fs-6"></i>Thêm khóa học
									</button>
									<ul
										class="nav nav-tabs tab-body-header rounded ms-3 prtab-set w-sm-100"
										role="tablist">
										<li class="nav-item"><a class="nav-link active"
											data-bs-toggle="tab" href="#All-list" role="tab">Tất cả</a></li>
										<li class="nav-item"><a class="nav-link"
											data-bs-toggle="tab" href="#Started-list" role="tab">Đang
												diễn ra</a></li>
										<li class="nav-item"><a class="nav-link"
											data-bs-toggle="tab" href="#Approval-list" role="tab">Chờ
												phê duyệt</a></li>
										<li class="nav-item"><a class="nav-link"
											data-bs-toggle="tab" href="#pause-list" role="tab">Tạm dừng</a></li>
										<li class="nav-item"><a class="nav-link"
											data-bs-toggle="tab" href="#Completed-list" role="tab">Hoàn
												thành</a></li>
												
												
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- Row end  -->

					<div class="row align-items-center">
						<div class="col-lg-12 col-md-12 flex-column">
							<div class="tab-content mt-4">
							
								<div class="tab-pane fade show active" id="All-list">
									<div class="row g-3 gy-5 py-3 row-deck">

										<%
										for (KhoaHoc khoaHoc : list) {
										%>
										<!-- start card -->
										<div
											class="col-xxl-4 col-xl-4 col-lg-4 col-md-6 col-sm-6 card-khoahoc">
											<div class="card">
												<div class="card-body">
													<div
														class="d-flex align-items-center justify-content-between mt-5">
														<div class="lesson_name">
															<div class="project-block light-info-bg">
																<i class="icofont-book-alt"></i>
															</div>
															<h6 class="mb-0 fw-bold  fs-6  mb-2"><%=khoaHoc.getKhoahoc_ten()%></h6>
														</div>
														<div class="btn-group" role="group"
															aria-label="Basic outlined example">
															<button type="button"
																class="btn btn-outline-secondary btn-hienthi-danhsachlophoc"
																data-bs-toggle="modal"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-target="#readLopHoc">
																<i class="icofont-eye text-success"></i>
															</button>
															<button type="button" class="btn btn-outline-secondary"
																data-bs-toggle="modal" data-bs-target="#editKhoaHoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>">
																<i class="icofont-edit text-success"></i>
															</button>
															<button type="button"
																class="btn btn-outline-secondary btn-xoa-khoahoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-toggle="modal">

																<i class="icofont-ui-delete text-danger"></i>
															</button>
														</div>
													</div>
													<div class="d-flex align-items-center">
														<div class="avatar-list avatar-list-stacked pt-2">
															<img class="avatar rounded-circle sm"
																src="assets/images/xs/avatar2.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar1.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar3.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar4.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar8.jpg" alt=""> <span
																class="avatar rounded-circle text-center pointer sm"
																data-bs-toggle="modal" data-bs-target="#addUser"><i
																class="icofont-ui-add"></i></span>
														</div>
													</div>
													<div class="row g-2 pt-4">
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-paper-clip"></i> <span class="ms-2">5
																	Attach</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-sand-clock"></i> <span class="ms-2">4
																	Month</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-group-students "></i> <span
																	class="ms-2">Giảng viên</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-ui-text-chat"></i> <span class="ms-2">10</span>
															</div>
														</div>
													</div>
													<div class="dividers-block"></div>
													<div
														class="d-flex align-items-center justify-content-between mb-2">
														<h4 class="small fw-bold mb-0">Progress</h4>
														<span class="small light-danger-bg  p-1 rounded"><i
															class="icofont-ui-clock"></i> 35 Days Left</span>
													</div>
													<div class="progress" style="height: 8px;">
														<div class="progress-bar bg-secondary" role="progressbar"
															style="width: 25%" aria-valuenow="15" aria-valuemin="0"
															aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 25%" aria-valuenow="30"
															aria-valuemin="0" aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 10%" aria-valuenow="10"
															aria-valuemin="0" aria-valuemax="100"></div>
													</div>
												</div>
											</div>
										</div>
										<!-- end card -->
										<%
										}
										%>
									</div>
								</div>
								
								<div class="tab-pane fade" id="Started-list">
									<div class="row g-3 gy-5 py-3 row-deck">
										
											
											<%
										for (KhoaHoc khoaHoc : list) {
										%>
										<% if (khoaHoc.getKhoahoc_trangthai().equals("Đang mở")) { %>
										<!-- start card -->
										<div
											class="col-xxl-4 col-xl-4 col-lg-4 col-md-6 col-sm-6 card-khoahoc">
											<div class="card">
												<div class="card-body">
													<div
														class="d-flex align-items-center justify-content-between mt-5">
														<div class="lesson_name">
															<div class="project-block light-info-bg">
																<i class="icofont-book-alt"></i>
															</div>
															<h6 class="mb-0 fw-bold  fs-6  mb-2"><%=khoaHoc.getKhoahoc_ten()%></h6>
														</div>
														<div class="btn-group" role="group"
															aria-label="Basic outlined example">
															<button type="button"
																class="btn btn-outline-secondary btn-hienthi-danhsachlophoc"
																data-bs-toggle="modal"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-target="#readLopHoc">
																<i class="icofont-eye text-success"></i>
															</button>
															<button type="button" class="btn btn-outline-secondary"
																data-bs-toggle="modal" data-bs-target="#editKhoaHoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>">
																<i class="icofont-edit text-success"></i>
															</button>
															<button type="button"
																class="btn btn-outline-secondary btn-xoa-khoahoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-toggle="modal">

																<i class="icofont-ui-delete text-danger"></i>
															</button>
														</div>
													</div>
													<div class="d-flex align-items-center">
														<div class="avatar-list avatar-list-stacked pt-2">
															<img class="avatar rounded-circle sm"
																src="assets/images/xs/avatar2.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar1.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar3.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar4.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar8.jpg" alt=""> <span
																class="avatar rounded-circle text-center pointer sm"
																data-bs-toggle="modal" data-bs-target="#addUser"><i
																class="icofont-ui-add"></i></span>
														</div>
													</div>
													<div class="row g-2 pt-4">
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-paper-clip"></i> <span class="ms-2">5
																	Attach</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-sand-clock"></i> <span class="ms-2">4
																	Month</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-group-students "></i> <span
																	class="ms-2">Giảng viên</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-ui-text-chat"></i> <span class="ms-2">10</span>
															</div>
														</div>
													</div>
													<div class="dividers-block"></div>
													<div
														class="d-flex align-items-center justify-content-between mb-2">
														<h4 class="small fw-bold mb-0">Progress</h4>
														<span class="small light-danger-bg  p-1 rounded"><i
															class="icofont-ui-clock"></i> 35 Days Left</span>
													</div>
													<div class="progress" style="height: 8px;">
														<div class="progress-bar bg-secondary" role="progressbar"
															style="width: 25%" aria-valuenow="15" aria-valuemin="0"
															aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 25%" aria-valuenow="30"
															aria-valuemin="0" aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 10%" aria-valuenow="10"
															aria-valuemin="0" aria-valuemax="100"></div>
													</div>
												</div>
											</div>
										</div>
										<!-- end card -->
										<%
										}
										%>
										<%
										}
										%>
										

									</div>
								</div>
								<div class="tab-pane fade" id="Approval-list">
									<div class="row g-3 gy-5 py-3 row-deck">
										<%
										for (KhoaHoc khoaHoc : list) {
										%>
										<% if (khoaHoc.getKhoahoc_trangthai().equals("Sắp mở")) { %>
										<!-- start card -->
										<div
											class="col-xxl-4 col-xl-4 col-lg-4 col-md-6 col-sm-6 card-khoahoc">
											<div class="card">
												<div class="card-body">
													<div
														class="d-flex align-items-center justify-content-between mt-5">
														<div class="lesson_name">
															<div class="project-block light-info-bg">
																<i class="icofont-book-alt"></i>
															</div>
															<h6 class="mb-0 fw-bold  fs-6  mb-2"><%=khoaHoc.getKhoahoc_ten()%></h6>
														</div>
														<div class="btn-group" role="group"
															aria-label="Basic outlined example">
															<button type="button"
																class="btn btn-outline-secondary btn-hienthi-danhsachlophoc"
																data-bs-toggle="modal"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-target="#readLopHoc">
																<i class="icofont-eye text-success"></i>
															</button>
															<button type="button" class="btn btn-outline-secondary"
																data-bs-toggle="modal" data-bs-target="#editKhoaHoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>">
																<i class="icofont-edit text-success"></i>
															</button>
															<button type="button"
																class="btn btn-outline-secondary btn-xoa-khoahoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-toggle="modal">

																<i class="icofont-ui-delete text-danger"></i>
															</button>
														</div>
													</div>
													<div class="d-flex align-items-center">
														<div class="avatar-list avatar-list-stacked pt-2">
															<img class="avatar rounded-circle sm"
																src="assets/images/xs/avatar2.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar1.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar3.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar4.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar8.jpg" alt=""> <span
																class="avatar rounded-circle text-center pointer sm"
																data-bs-toggle="modal" data-bs-target="#addUser"><i
																class="icofont-ui-add"></i></span>
														</div>
													</div>
													<div class="row g-2 pt-4">
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-paper-clip"></i> <span class="ms-2">5
																	Attach</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-sand-clock"></i> <span class="ms-2">4
																	Month</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-group-students "></i> <span
																	class="ms-2">Giảng viên</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-ui-text-chat"></i> <span class="ms-2">10</span>
															</div>
														</div>
													</div>
													<div class="dividers-block"></div>
													<div
														class="d-flex align-items-center justify-content-between mb-2">
														<h4 class="small fw-bold mb-0">Progress</h4>
														<span class="small light-danger-bg  p-1 rounded"><i
															class="icofont-ui-clock"></i> 35 Days Left</span>
													</div>
													<div class="progress" style="height: 8px;">
														<div class="progress-bar bg-secondary" role="progressbar"
															style="width: 25%" aria-valuenow="15" aria-valuemin="0"
															aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 25%" aria-valuenow="30"
															aria-valuemin="0" aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 10%" aria-valuenow="10"
															aria-valuemin="0" aria-valuemax="100"></div>
													</div>
												</div>
											</div>
										</div>
										<!-- end card -->
										<%
										}
										%>
										<%
										}
										%>

									</div>
								</div>
								<div class="tab-pane fade" id="Completed-list">
									<div class="row g-3 gy-5 py-3 row-deck">
										<%
										for (KhoaHoc khoaHoc : list) {
										%>
										<% if (khoaHoc.getKhoahoc_trangthai().equals("Đóng")) { %>
										<!-- start card -->
										<div
											class="col-xxl-4 col-xl-4 col-lg-4 col-md-6 col-sm-6 card-khoahoc">
											<div class="card">
												<div class="card-body">
													<div
														class="d-flex align-items-center justify-content-between mt-5">
														<div class="lesson_name">
															<div class="project-block light-info-bg">
																<i class="icofont-book-alt"></i>
															</div>
															<h6 class="mb-0 fw-bold  fs-6  mb-2"><%=khoaHoc.getKhoahoc_ten()%></h6>
														</div>
														<div class="btn-group" role="group"
															aria-label="Basic outlined example">
															<button type="button"
																class="btn btn-outline-secondary btn-hienthi-danhsachlophoc"
																data-bs-toggle="modal"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-target="#readLopHoc">
																<i class="icofont-eye text-success"></i>
															</button>
															<button type="button" class="btn btn-outline-secondary"
																data-bs-toggle="modal" data-bs-target="#editKhoaHoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>">
																<i class="icofont-edit text-success"></i>
															</button>
															<button type="button"
																class="btn btn-outline-secondary btn-xoa-khoahoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-toggle="modal">

																<i class="icofont-ui-delete text-danger"></i>
															</button>
														</div>
													</div>
													<div class="d-flex align-items-center">
														<div class="avatar-list avatar-list-stacked pt-2">
															<img class="avatar rounded-circle sm"
																src="assets/images/xs/avatar2.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar1.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar3.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar4.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar8.jpg" alt=""> <span
																class="avatar rounded-circle text-center pointer sm"
																data-bs-toggle="modal" data-bs-target="#addUser"><i
																class="icofont-ui-add"></i></span>
														</div>
													</div>
													<div class="row g-2 pt-4">
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-paper-clip"></i> <span class="ms-2">5
																	Attach</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-sand-clock"></i> <span class="ms-2">4
																	Month</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-group-students "></i> <span
																	class="ms-2">Giảng viên</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-ui-text-chat"></i> <span class="ms-2">10</span>
															</div>
														</div>
													</div>
													<div class="dividers-block"></div>
													<div
														class="d-flex align-items-center justify-content-between mb-2">
														<h4 class="small fw-bold mb-0">Progress</h4>
														<span class="small light-danger-bg  p-1 rounded"><i
															class="icofont-ui-clock"></i> 35 Days Left</span>
													</div>
													<div class="progress" style="height: 8px;">
														<div class="progress-bar bg-secondary" role="progressbar"
															style="width: 25%" aria-valuenow="15" aria-valuemin="0"
															aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 25%" aria-valuenow="30"
															aria-valuemin="0" aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 10%" aria-valuenow="10"
															aria-valuemin="0" aria-valuemax="100"></div>
													</div>
												</div>
											</div>
										</div>
										<!-- end card -->
										<%
										}
										%>
										<%
										}
										%>

									</div>
								</div>
								
								<div class="tab-pane fade" id="pause-list">
									<div class="row g-3 gy-5 py-3 row-deck">
										<%
										for (KhoaHoc khoaHoc : list) {
										%>
										<% if (khoaHoc.getKhoahoc_trangthai().equals("Tạm dừng")) { %>
										<!-- start card -->
										<div
											class="col-xxl-4 col-xl-4 col-lg-4 col-md-6 col-sm-6 card-khoahoc">
											<div class="card">
												<div class="card-body">
													<div
														class="d-flex align-items-center justify-content-between mt-5">
														<div class="lesson_name">
															<div class="project-block light-info-bg">
																<i class="icofont-book-alt"></i>
															</div>
															<h6 class="mb-0 fw-bold  fs-6  mb-2"><%=khoaHoc.getKhoahoc_ten()%></h6>
														</div>
														<div class="btn-group" role="group"
															aria-label="Basic outlined example">
															<button type="button"
																class="btn btn-outline-secondary btn-hienthi-danhsachlophoc"
																data-bs-toggle="modal"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-target="#readLopHoc">
																<i class="icofont-eye text-success"></i>
															</button>
															<button type="button" class="btn btn-outline-secondary"
																data-bs-toggle="modal" data-bs-target="#editKhoaHoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>">
																<i class="icofont-edit text-success"></i>
															</button>
															<button type="button"
																class="btn btn-outline-secondary btn-xoa-khoahoc"
																data-id-khoahoc="<%=khoaHoc.getKhoahoc_id()%>"
																data-bs-toggle="modal">

																<i class="icofont-ui-delete text-danger"></i>
															</button>
														</div>
													</div>
													<div class="d-flex align-items-center">
														<div class="avatar-list avatar-list-stacked pt-2">
															<img class="avatar rounded-circle sm"
																src="assets/images/xs/avatar2.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar1.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar3.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar4.jpg" alt=""> <img
																class="avatar rounded-circle sm"
																src="assets/images/xs/avatar8.jpg" alt=""> <span
																class="avatar rounded-circle text-center pointer sm"
																data-bs-toggle="modal" data-bs-target="#addUser"><i
																class="icofont-ui-add"></i></span>
														</div>
													</div>
													<div class="row g-2 pt-4">
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-paper-clip"></i> <span class="ms-2">5
																	Attach</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-sand-clock"></i> <span class="ms-2">4
																	Month</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-group-students "></i> <span
																	class="ms-2">Giảng viên</span>
															</div>
														</div>
														<div class="col-6">
															<div class="d-flex align-items-center">
																<i class="icofont-ui-text-chat"></i> <span class="ms-2">10</span>
															</div>
														</div>
													</div>
													<div class="dividers-block"></div>
													<div
														class="d-flex align-items-center justify-content-between mb-2">
														<h4 class="small fw-bold mb-0">Progress</h4>
														<span class="small light-danger-bg  p-1 rounded"><i
															class="icofont-ui-clock"></i> 35 Days Left</span>
													</div>
													<div class="progress" style="height: 8px;">
														<div class="progress-bar bg-secondary" role="progressbar"
															style="width: 25%" aria-valuenow="15" aria-valuemin="0"
															aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 25%" aria-valuenow="30"
															aria-valuemin="0" aria-valuemax="100"></div>
														<div class="progress-bar bg-secondary ms-1"
															role="progressbar" style="width: 10%" aria-valuenow="10"
															aria-valuemin="0" aria-valuemax="100"></div>
													</div>
												</div>
											</div>
										</div>
										<!-- end card -->
										<%
										}
										%>
										<%
										}
										%>

									</div>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal Members-->
			<div class="modal fade" id="addUser" tabindex="-1"
				aria-labelledby="addUserLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title  fw-bold" id="addUserLabel">Thêm
								giảng viên</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="inviteby_email">
								<div class="input-group mb-3">
									<input type="email" class="form-control"
										placeholder="Địa chỉ email" id="exampleInputEmail1"
										aria-describedby="exampleInputEmail1">
									<button class="btn btn-dark" type="button" id="button-addon2">Gửi</button>
								</div>
							</div>
							<div class="members_list">
								<h6 class="fw-bold ">Giảng viên</h6>
								<ul
									class="list-unstyled list-group list-group-custom list-group-flush mb-0">
									<li class="list-group-item py-3 text-center text-md-start">
										<div
											class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
											<div class="no-thumbnail mb-2 mb-md-0">
												<img class="avatar lg rounded-circle"
													src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar2.jpg"
													alt="">
											</div>
											<div class="flex-fill ms-3 text-truncate">
												<h6 class="mb-0  fw-bold">Rachel Carr(you)</h6>
												<span class="text-muted">rachel.carr@gmail.com</span>
											</div>
											<div class="members-action">
												<span class="members-role ">Admin</span>
												<div class="btn-group">
													<button type="button"
														class="btn bg-transparent dropdown-toggle"
														data-bs-toggle="dropdown" aria-expanded="false">
														<i class="icofont-ui-settings  fs-6"></i>
													</button>
													<ul class="dropdown-menu dropdown-menu-end">
														<li><a class="dropdown-item" href="#"><i
																class="icofont-ui-password fs-6 me-2"></i>ResetPassword</a>
														</li>
														<li><a class="dropdown-item" href="#"><i
																class="icofont-chart-line fs-6 me-2"></i>ActivityReport</a>
														</li>
													</ul>
												</div>
											</div>
										</div>
									</li>
									<li class="list-group-item py-3 text-center text-md-start">
										<div
											class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
											<div class="no-thumbnail mb-2 mb-md-0">
												<img class="avatar lg rounded-circle"
													src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar3.jpg"
													alt="">
											</div>
											<div class="flex-fill ms-3 text-truncate">
												<h6 class="mb-0  fw-bold">
													Lucas Baker<a href="#" class="link-secondary ms-2">(Resend
														invitation)</a>
												</h6>
												<span class="text-muted">lucas.baker@gmail.com</span>
											</div>
											<div class="members-action">
												<div class="btn-group">
													<button type="button"
														class="btn bg-transparent dropdown-toggle"
														data-bs-toggle="dropdown" aria-expanded="false">
														Members</button>
													<ul class="dropdown-menu dropdown-menu-end">
														<li><a class="dropdown-item" href="#"> <i
																class="icofont-check-circled"></i> <span>All
																	operations permission</span>
														</a></li>
														<li><a class="dropdown-item" href="#"> <i
																class="fs-6 p-2 me-1"></i> <span>Only Invite &
																	manage team</span>
														</a></li>
													</ul>
												</div>
												<div class="btn-group">
													<button type="button"
														class="btn bg-transparent dropdown-toggle"
														data-bs-toggle="dropdown" aria-expanded="false">
														<i class="icofont-ui-settings  fs-6"></i>
													</button>
													<ul class="dropdown-menu dropdown-menu-end">
														<li><a class="dropdown-item" href="#"><i
																class="icofont-delete-alt fs-6 me-2"></i>Delete Member</a></li>
													</ul>
												</div>
											</div>
										</div>
									</li>
									<li class="list-group-item py-3 text-center text-md-start">
										<div
											class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
											<div class="no-thumbnail mb-2 mb-md-0">
												<img class="avatar lg rounded-circle"
													src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar8.jpg"
													alt="">
											</div>
											<div class="flex-fill ms-3 text-truncate">
												<h6 class="mb-0  fw-bold">Una Coleman</h6>
												<span class="text-muted">una.coleman@gmail.com</span>
											</div>
											<div class="members-action">
												<div class="btn-group">
													<button type="button"
														class="btn bg-transparent dropdown-toggle"
														data-bs-toggle="dropdown" aria-expanded="false">
														Members</button>
													<ul class="dropdown-menu dropdown-menu-end">
														<li><a class="dropdown-item" href="#"> <i
																class="icofont-check-circled"></i> <span>All
																	operations permission</span>
														</a></li>
														<li><a class="dropdown-item" href="#"> <i
																class="fs-6 p-2 me-1"></i> <span>Only Invite &
																	manage team</span>
														</a></li>
													</ul>
												</div>
												<div class="btn-group">
													<div class="btn-group">
														<button type="button"
															class="btn bg-transparent dropdown-toggle"
															data-bs-toggle="dropdown" aria-expanded="false">
															<i class="icofont-ui-settings  fs-6"></i>
														</button>
														<ul class="dropdown-menu dropdown-menu-end">
															<li><a class="dropdown-item" href="#"><i
																	class="icofont-ui-password fs-6 me-2"></i>ResetPassword</a>
															</li>
															<li><a class="dropdown-item" href="#"><i
																	class="icofont-chart-line fs-6 me-2"></i>ActivityReport</a>
															</li>
															<li><a class="dropdown-item" href="#"><i
																	class="icofont-delete-alt fs-6 me-2"></i>Suspend member</a></li>
															<li><a class="dropdown-item" href="#"><i
																	class="icofont-not-allowed fs-6 me-2"></i>Delete Member</a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Create khoahoc-->
			<div class="modal fade" id="createKhoaHoc" tabindex="-1"
				aria-hidden="true">
				<div
					class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
					<form method="post">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title  fw-bold" id="createKhoaHoclLabel">Thêm
									khóa học</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<div class="mb-3">
									<label for="exampleFormControlInput77" class="form-label">Tên
										khóa học</label> <input type="text" name="khoahoc_ten"
										class="form-control" id="khoahoc_ten"
										placeholder="Tên khóa học">
								</div>
								<!-- ✅ TRÌNH ĐỘ VÀ PHÂN LOẠI - NGANG HÀNG -->
								<div class="row mb-3">
									<div class="col-md-6">
										<label class="form-label">Trình độ</label> <select
											class="form-select" name="khoahoc_trinhdo"
											id="khoahoc_trinhdo">
											<option value="A1" selected>A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
										</select>
									</div>
									<div class="col-md-6">
										<label class="form-label">Phân loại</label> <select
											class="form-select" name="khoahoc_loai" id="khoahoc_loai">
											<option value="1" selected>Giao tiếp</option>
											<option value="2">IELTS</option>
											<option value="3">TOEFL</option>
											<option value="4">TOEIC</option>
											<option value="5">Ngữ pháp</option>
											<option value="6">Phát âm</option>
											<option value="7">Từ vựng</option>
										</select>
									</div>
								</div>

								<div class="row g-3 mb-3">
									<div class="col">
										<label for="datepickerded" class="form-label">Ngày bắt
											đầu</label> <input type="date" name="khoahoc_ngaybatdau"
											class="form-control" id="khoahoc_ngaybatdau">
									</div>
									<div class="col">
										<label for="datepickerdedone" class="form-label">Ngày
											kết thúc</label> <input type="date" name="khoahoc_ngayketthuc"
											class="form-control" id="khoahoc_ngayketthuc">
									</div>
								</div>

								<!-- Căn ngang khoahoc_gia và khoahoc_thoiluong -->
								<div class="row mb-3">
									<div class="col-md-6">
										<label for="khoahoc_gia" class="form-label">Giá</label> <input
											type="text" name="khoahoc_gia" class="form-control"
											id="khoahoc_gia" placeholder="Giá khóa học">
									</div>
									<div class="col-md-6">
										<label for="khoahoc_thoiluong" class="form-label">Thời
											lượng</label> <input type="text" name="khoahoc_thoiluong"
											class="form-control" id="khoahoc_thoiluong"
											placeholder="Thời lượng khóa học(giờ)">
									</div>
								</div>
								<div class="mb-3">
									<label for="exampleFormControlTextarea78" class="form-label">Mô
										tả(Không bắt buộc)</label>
									<textarea class="form-control" id="khoahoc_mota" rows="3"
										name="khoahoc_mota"
										placeholder="Thêm bất kỳ chi tiết bổ sung nào về yêu cầu"></textarea>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Thoát</button>
								<button id="btn-add-khoahoc" type="submit"
									class="btn btn-primary">Thêm</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- end create khoahoc-->

			<!-- Edit khoahoc-->
			<div class="modal fade" id="editKhoaHoc" tabindex="-1"
				aria-hidden="true">
				<div
					class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
					<form method="post">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title  fw-bold" id="editKhoaHoclLabel">Cập
									nhật khóa học</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>

							<div class="modal-body">
								<!-- Căn ngang khoahoc_id và khoahoc_ten -->
								<div class="row mb-3">
									<div class="col-md-6">
										<label for="khoahoc_id" class="form-label">ID khóa học</label>
										<input type="text" name="khoahoc_id_update"
											class="form-control" id="khoahoc_id_update"
											placeholder="ID khóa học">
									</div>
									<div class="col-md-6">
										<label for="khoahoc_ten" class="form-label">Tên khóa
											học</label> <input type="text" name="khoahoc_ten_update"
											class="form-control" id="khoahoc_ten_update"
											placeholder="Tên khóa học">
									</div>
								</div>

								<div class="mb-3">
									<label class="form-label">Trạng thái</label> <select
										class="form-select" name="khoahoc_trangthai_update"
										id="khoahoc_trangthai_update">
										<option value="Đang mở" selected>Đang mở</option>
										<option value="Sắp mở">Sắp mở</option>
										<option value="Đóng">Đóng</option>
										<option value="Tạm dừng">Tạm dừng</option>
									</select>
								</div>
								<div class="row mb-3">
									<div class="col-md-6">
										<label class="form-label">Trình độ</label> <select
											class="form-select" name="khoahoc_trinhdo_update"
											id="khoahoc_trinhdo_update">
											<option value="A1" selected>A1</option>
											<option value="A2">A2</option>
											<option value="B1">B1</option>
											<option value="B2">B2</option>
											<option value="C1">C1</option>
											<option value="C2">C2</option>
										</select>
									</div>
									<div class="col-md-6">
										<label class="form-label">Phân loại</label> <select
											class="form-select" name="khoahoc_loai_update"
											id="khoahoc_loai_update">
											<!--  
											<option value="1" selected>Giao tiếp</option>
											<option value="2">IELTS</option>
											<option value="3">TOEFL</option>
											<option value="4">TOEIC</option>
											<option value="5">Ngữ pháp</option>
											<option value="6">Phát âm</option>
											<option value="7">Từ vựng</option>
											-->
											<option value="Giao tiếp">Giao tiếp</option>
											<option value="IELTS">IELTS</option>
											<option value="TOEFL">TOEFL</option>
											<option value="TOEIC">TOEIC</option>
											<option value="Ngữ pháp">Ngữ pháp</option>
											<option value="Phát âm">Phát âm</option>
											<option value="Từ vựng">Từ vựng</option>
										</select>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col">
										<label for="khoahoc_ngaybatdau_update" class="form-label">Ngày
											bắt đầu</label> <input type="date" name="khoahoc_ngaybatdau_update"
											class="form-control" id="khoahoc_ngaybatdau_update">
									</div>
									<div class="col">
										<label for="khoahoc_ngayketthuc_update" class="form-label">Ngày
											kết thúc</label> <input type="date" name="khoahoc_ngayketthuc_update"
											class="form-control" id="khoahoc_ngayketthuc_update">
									</div>
								</div>
								<!-- Căn ngang khoahoc_gia và khoahoc_thoiluong -->
								<div class="row mb-3">
									<div class="col-md-6">
										<label for="khoahoc_gia_update" class="form-label">Giá</label>
										<input type="text" name="khoahoc_gia_update"
											class="form-control" id="khoahoc_gia_update"
											placeholder="Giá khóa học">
									</div>
									<div class="col-md-6">
										<label for="khoahoc_thoiluong_update" class="form-label">Thời
											lượng</label> <input type="text" name="khoahoc_thoiluong_update"
											class="form-control" id="khoahoc_thoiluong_update"
											placeholder="Thời lượng khóa học(giờ)">
									</div>
								</div>
								<div class="mb-3">
									<label for="khoahoc_mota" class="form-label">Mô tả
										(Không bắt buộc)</label>
									<textarea class="form-control" id="khoahoc_mota_update"
										rows="3" name="khoahoc_mota_update"
										placeholder="Thêm bất kỳ chi tiết bổ sung nào về yêu cầu"></textarea>
								</div>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Thoát</button>
								<button id="btn-update-khoahoc" type="submit"
									class="btn btn-primary">Cập nhật</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- end edit khoahoc-->

			<!-- Modal  Delete Folder/ File-->
			<div class="modal fade" id="deleteproject" tabindex="-1"
				aria-hidden="true">
				<div
					class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title  fw-bold" id="deleteprojectLabel">
								Xóa khóa học</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body justify-content-center flex-column d-flex">
							<i
								class="icofont-ui-delete text-danger display-2 text-center mt-2"></i>
							<p class="mt-4 fs-5 text-center">Bạn chắc chắn muốn xóa khóa
								học này</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Thoát</button>
							<button type="button" class="btn btn-danger color-fff">Xóa</button>
						</div>
					</div>
				</div>
			</div>

<!-- readlophoc -->
			<div class="modal fade" id="readLopHoc" tabindex="-1"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-xl ">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title fw-bold" id="readLopHocLabel">Danh
								sách lớp học</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>

						<div class="modal-body justify-content-center flex-column d-flex">
							<div class="card mb-3">
								<div class="card-body"
									style="max-height: 600px; overflow-y: auto;">
									<table id="patient-table"
										class="table table-hover align-middle mb-0"
										style="width: 100%; table-layout: fixed;">
										<thead
											style="position: sticky; top: 0; background: white; z-index: 1;">
											<tr>
												<th>Id lớp học</th>
												<th>Giáo viên</th>
												<th>Số học sinh</th>
												<th>Mô tả</th>
												<th>Ngày bắt đầu</th>
												<th>Ngày kết thúc</th>
												<th>Tiến độ</th>
												<th>Trạng thái</th>
												<th>Hoạt động</th>
											</tr>
										</thead>
										<tbody id="lophoc-tbody">
											<!--  -->
										</tbody>
									</table>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-dark w-sm-100"
								data-bs-toggle="modal" data-bs-target="#createLopHoc">
								<i class="icofont-plus-circle me-2 fs-6"></i>Thêm lớp học
							</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Thoát</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>


	<!-- Modal  Read class-->
	
	<div class="modal fade" id="readclass" tabindex="-1" aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-xl modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title  fw-bold" id="readclassLabel">Danh sách học viên trong lớp</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>

				</div>

				<div class="modal-body justify-content-center flex-column d-flex">
					<div class="card mb-3">
						<!--  <div class="card-header py-3  bg-transparent border-bottom-0">
							<h6 class="mb-0 fw-bold ">Danh sách sinh viên trong lớp</h6>
							
						</div>-->
						<div class="card-body">
							<table id="patient-table"
								class="table table-hover align-middle mb-0" style="width: 100%;">
								<thead>
									<tr>
										<th>Id sinh viên</th>
										<th>Họ tên</th>
										<th>Điểm số</th>
										<th>Ngày đăng ký</th>
										<th>Trạng thái</th>
										<th>Hoạt động</th>
									</tr>
								</thead>
								<tbody id="danhsachhocvien-tbody">
									<!-- start 1 sinh vien trong lop 
									
									 end 1 sinh vien trong lop -->
									<!-- end danh sach  sinh vien trong lop -->
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Thoát</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end  Read class Folder/ File-->

	<!-- Create Class-->
	<!-- Create Class-->
	<div class="modal fade" id="createLopHoc" tabindex="-1"
		aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
			<!-- -->
			<form method="post">
				<!-- -->
				<div class="modal-content">
					<!-- -->
					<div class="modal-header">
						<h5 class="modal-title  fw-bold" id="createclasslLabel">Thêm
							lớp học</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- -->
					<div class="modal-body">
						<div class="row mb-3">
							<div class="col md-6">
								<label for="lophoc_khoahoc_id" class="form-label">ID
									khóa học</label> <input type="text" class="form-control"
									id="lophoc_khoahoc_id" name="lophoc_khoahoc_id"
									placeholder="ID khóa học">
							</div>

							<div class="col md-6">
								<label for="lophoc_ten" class="form-label">Tên lớp học</label> <input
									type="text" class="form-control" id="lophoc_ten"
									name="lophoc_ten" placeholder="Tên lớp học">
							</div>
						</div>

						<div class="mb-3">
							<label for="lophoc_tailieu" class="form-label">Tài liệu</label> <input
								type="text" class="form-control" id="lophoc_tailieu"
								name="lophoc_tailieu" placeholder="Tài liệu lớp học">
						</div>

						<div class="row g-3 mb-3">
							<div class="col">
								<label for="lophoc_ngaybatdau" class="form-label">Ngày
									bắt đầu</label> <input type="date" class="form-control"
									id="lophoc_ngaybatdau" name="lophoc_ngaybatdau">
							</div>
							<div class="col">
								<label for="lophoc_ngayketthuc" class="form-label">Ngày
									kết thúc</label> <input type="date" class="form-control"
									id="lophoc_ngayketthuc" name="lophoc_ngayketthuc">
							</div>
						</div>

						<div class="mb-3">
							<label class="form-label">Giảng viên</label> <select
								class="form-select" id="lophoc_giaovien_id"
								name="lophoc_giaovien_id">
								<% for (NguoiDung nguoiDung : listNguoiDung){ %>
								<option value="<%=nguoiDung.getNguoidung_id()%>" ><%=nguoiDung.getNguoidung_hoten()%></option>
								
								<% } %>
							</select>
						</div>

						<div class="mb-3">
							<label for="lophoc_mota" class="form-label">Mô tả(Không
								bắt buộc)</label>
							<textarea class="form-control" id="lophoc_mota"
								name="lophoc_mota" rows="3" placeholder="Thêm mô tả"></textarea>
						</div>
					</div>
					<!-- -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Thoát</button>
						<button id="btn-add-lophoc" type="submit" class="btn btn-info">Thêm</button>
					</div>
					<!-- -->
				</div>
				<!-- -->
			</form>
			<!-- -->
		</div>
	</div>
	
	<!-- edit lophoc -->
	<div class="modal fade" id="editLopHoc" tabindex="-1"
		aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
			<!-- -->
			<form method="post">
				<!-- -->
				<div class="modal-content">
					<!-- -->
					<div class="modal-header">
						<h5 class="modal-title  fw-bold" id="editLopHocLabel">Cập nhật
							lớp học</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- -->
					<div class="modal-body">
						<div class="row mb-3">
							<div class="col md-6">
								<label for="lophoc_khoahoc_id_update" class="form-label">ID
									khóa học</label> <input type="text" class="form-control"
									id="lophoc_khoahoc_id_update" name="lophoc_khoahoc_id_update"
									placeholder="ID khóa học">
							</div>

							<div class="col md-6">
								<label for="lophoc_id_update" class="form-label">ID lớp học</label> 
								<input
									type="text" class="form-control" id="lophoc_id_update"
									name="lophoc_id_update" placeholder="Tên lớp học">
							</div>
						</div>
						
						<div class="row mb-3">
						<div class="col md-6">
								<label for="lophoc_ten_update" class="form-label">Tên lớp học</label> <input
									type="text" class="form-control" id="lophoc_ten_update"
									name="lophoc_ten_update" placeholder="Tên lớp học">
							</div>

						
						<div class="col md-6">
							<label class="form-label">Trạng thái</label> <select
								class="form-select" id="lophoc_trangthai_update"
								name="lophoc_trangthai_update">
								<!--  
								<option value="Chưa bắt đầu" selected>Chưa bắt đầu</option>
								<option value="Đang học">Đang học</option>
								<option value="Đã kết thúc">Đã kết thúc</option>
								<option value="Tạm dừng">Tạm dừng</option>
								-->
								<option value="1" selected>Chưa bắt đầu</option>
								<option value="2">Đang học</option>
								<option value="3">Đã kết thúc</option>
								<option value="4">Tạm dừng</option>
								
							</select>
						</div>
						</div>

						<div class="mb-3">
							<label for="lophoc_tailieu_update" class="form-label">Tài liệu</label> <input
								type="text" class="form-control" id="lophoc_tailieu_update"
								name="lophoc_tailieu_update" placeholder="Tài liệu lớp học">
						</div>

						<div class="row g-3 mb-3">
							<div class="col">
								<label for="lophoc_ngaybatdau_update" class="form-label">Ngày
									bắt đầu</label> <input type="date" class="form-control"
									id="lophoc_ngaybatdau_update" name="lophoc_ngaybatdau_update">
							</div>
							<div class="col">
								<label for="lophoc_ngayketthuc_update" class="form-label">Ngày
									kết thúc</label> <input type="date" class="form-control"
									id="lophoc_ngayketthuc_update" name="lophoc_ngayketthuc_update">
							</div>
						</div>

						<div class="mb-3">
							<label class="form-label">Giảng viên</label> <select
								class="form-select" id="lophoc_giaovien_id_update"
								name="lophoc_giaovien_id_update">
								<% for (NguoiDung nguoiDung : listNguoiDung){ %>
								<option value="<%=nguoiDung.getNguoidung_hoten()%>" ><%=nguoiDung.getNguoidung_hoten()%></option>
								
								<% } %>
							</select>
						</div>

						<div class="mb-3">
							<label for="lophoc_mota_update" class="form-label">Mô tả(Không
								bắt buộc)</label>
							<textarea class="form-control" id="lophoc_mota_update"
								name="lophoc_mota_update" rows="3" placeholder="Thêm mô tả"></textarea>
						</div>
					</div>
					<!-- -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Thoát</button>
						<button id="btn-update-lophoc" type="submit" class="btn btn-info">Cập nhật</button>
					</div>
					<!-- -->
				</div>
				<!-- -->
			</form>
			<!-- -->
		</div>
	</div>
	<!-- end edit lophoc -->


	<!-- Modal  Delete Folder/ File-->
	<div class="modal fade" id="deleteclass" tabindex="-1"
		aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title  fw-bold" id="deleteclassLabel">Xóa lớp
						học</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body justify-content-center flex-column d-flex">
					<i class="icofont-ui-delete text-danger display-2 text-center mt-2"></i>
					<p class="mt-4 fs-5 text-center">Bạn chắc chắn muốn xóa lớp học
						này</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Thoát</button>
					<button type="button" class="btn btn-danger color-fff">Xóa</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Create student-->
	<div class="modal fade" id="createstudent" tabindex="-1"
		aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title  fw-bold" id="createstudentlLabel">
						Thêm học viên</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="mb-3">
						<label for="exampleFormControlInput77" class="form-label">Tên
							học viên</label> <input type="text" class="form-control"
							id="exampleFormControlInput77" placeholder="Tên lớp học">
					</div>

					<div class="deadline-form">
						<form>

							<div class="row g-3 mb-3"></div>
						</form>
					</div>
					<div class="row g-3 mb-3"></div>
					<div class="mb-3">
						<label for="exampleFormControlTextarea78" class="form-label">Đánh
							giá(Không bắt buộc)</label>
						<textarea class="form-control" id="exampleFormControlTextarea78"
							rows="3" placeholder="Thêm đánh giá cho học viên"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Thoát</button>
					<button type="button" class="btn btn-primary">Thêm</button>
				</div>
			</div>
		</div>
	</div>


	<!-- Modal  Delete student/ File-->
	<div class="modal fade" id="deletestudent" tabindex="-1"
		aria-hidden="true">
		<div
			class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title  fw-bold" id="deleteLabel">Xóa học viên</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body justify-content-center flex-column d-flex">
					<i class="icofont-ui-delete text-danger display-2 text-center mt-2"></i>
					<p class="mt-4 fs-5 text-center">Bạn chắc chắn muốn xóa học
						viên này</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Thoát</button>
					<button type="button" class="btn btn-danger color-fff">Xóa</button>
				</div>
			</div>
		</div>
	</div>




	<!--  Jquey js -->
	<script src="${pageContext.request.contextPath}/js/khoahoc.js"></script>
	<script src="${pageContext.request.contextPath}/js/lophoc.js"></script>


	<!-- Jquery Core Js -->
	<script
		src="${pageContext.request.contextPath}/dist/assets/bundles/libscripts.bundle.js"></script>

	<!-- Jquery Page Js -->
	<script src="${pageContext.request.contextPath}/js/template.js"></script>

</body>

</html>