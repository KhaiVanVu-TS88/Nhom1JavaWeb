<!doctype html>
<%@page import="course.model.ThongKeHocVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html class="no-js" lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Khóa học Dashboard</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- Favicon-->
<!-- plugin css file  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/dist/assets/plugin/datatables/responsive.dataTables.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/dist/assets/plugin/datatables/dataTables.bootstrap5.min.css">
<!-- project css file  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/dist/assets/css/my-task.style.min.css">
</head>
<%
ThongKeHocVien thongKeHocVien =(ThongKeHocVien) request.getAttribute("ThongKeHocVien");
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
							<li><a class="ms-link" href="<%=request.getContextPath()%>/giangvien"> <span>Danh
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
							<li><a class="ms-link" href="<%=request.getContextPath()%>/hocvien"> <span>Học
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
		<!-- end siderbar-->
		

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
															class="avatar rounded-circle"
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
															class="avatar rounded-circle"
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
															class="avatar rounded-circle"
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
														class="d-flex"> <img class="avatar rounded-circle"
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
												<img class="avatar rounded-circle"
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
												class="icofont-ui-user-group fs-6 me-3"></i>members</a> <a
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
			<div class="body d-flex py-3">
				<div class="container-xxl">
					<div class="row g-3 mb-3 row-deck">
						<div class="col-md-12 col-lg-4 col-xl-4 col-xxl-4">
							<div class="card ">
								<div class="card-body">
									<div class="d-flex align-items-center">
										<div
											class="avatar lg  rounded-1 no-thumbnail bg-lightyellow color-defult">
											<i class="bi bi-journal-check fs-4"></i>
										</div>
										<div class="flex-fill ms-4">
											<div class="">Tổng số học viên</div>
											<h5 class="mb-0 "><%=thongKeHocVien.getTongSoHocVien() %></h5>
										</div>
										<a href="#" title="view-members"
											class="btn btn-link text-decoration-none  rounded-1"><i
											class="icofont-hand-drawn-right fs-2 "></i></a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12 col-lg-4 col-xl-4 col-xxl-4">
							<div class="card ">
								<div class="card-body">
									<div class="d-flex align-items-center">
										<div
											class="avatar lg  rounded-1 no-thumbnail bg-lightblue color-defult">
											<i class="bi bi-list-check fs-4"></i>
										</div>
										<div class="flex-fill ms-4">
											<div class="">Đã tốt nghiệp</div>
											<h5 class="mb-0 "><%=thongKeHocVien.getTongSoHocVienDaHoanThanh() %></h5>
										</div>
										<a href="#" title="space-used"
											class="btn btn-link text-decoration-none  rounded-1"><i
											class="icofont-hand-drawn-right fs-2 "></i></a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-12 col-lg-4 col-xl-4 col-xxl-4">
							<div class="card ">
								<div class="card-body">
									<div class="d-flex align-items-center">
										<div
											class="avatar lg  rounded-1 no-thumbnail bg-lightgreen color-defult">
											<i class="bi bi-clipboard-data fs-4"></i>
										</div>
										<div class="flex-fill ms-4">
											<div class="">Đang học</div>
											<h5 class="mb-0 "><%=thongKeHocVien.getTongSoHocVienDangHoc() %></h5>
										</div>
										<a href="#" title="renewal-date"
											class="btn btn-link text-decoration-none  rounded-1"><i
											class="icofont-hand-drawn-right fs-2 "></i></a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Row End -->
					
					<div class="row g-3 mb-3 row-deck">
						<div class="col-md-12 col-lg-4">
							<div class="card">
								<div class="card-body">
									<h6 class="mb-3 fw-bold ">Doanh thu</h6>
									
									<div class="mt-3" id="doanhthukhoahoc"></div>
								</div>
							</div>
						</div>
						<div class="col-md-12 col-lg-8">
							<div class="card">
								<div
									class="card-header py-3 d-flex justify-content-between align-items-center">
									<div class="info-header">
										<h6 class="mb-0 fw-bold ">Thời gian diễn ra khóa học</h6>
									</div>
									<button class="btn btn-sm btn-link  dropdown-toggle"
										type="button" data-bs-toggle="dropdown" aria-expanded="false"></button>
									<ul class="dropdown-menu border-0 shadow dropdown-menu-end">
										<li><a class="dropdown-item py-2 rounded" href="#">Last
												7 days</a></li>
										<li><a class="dropdown-item py-2 rounded" href="#">Last
												30 days</a></li>
										<li><a class="dropdown-item py-2 rounded" href="#">Last
												60 days</a></li>
									</ul>
								</div>
								<div class="card-body">
									<div id="timelinekhoahoc"></div>
								</div>
							</div>
						</div>
					</div>
					
					
					
				</div>
			</div>

			
			
		</div>
	</div>

	<!-- Jquery Core Js -->
	<script
		src="${pageContext.request.contextPath}/dist/assets/bundles/libscripts.bundle.js"></script>

	<!-- Plugin Js-->
	<script
		src="${pageContext.request.contextPath}/dist/assets/bundles/apexcharts.bundle.js"></script>
	<script
		src="${pageContext.request.contextPath}/dist/assets/bundles/dataTables.bundle.js"></script>

	<!-- Jquery Page Js -->
	<script src="${pageContext.request.contextPath}/js/template.js"></script>
	<script src="${pageContext.request.contextPath}/js/lophoc.js"></script>
	<script src="${pageContext.request.contextPath}/js/page/index.js"></script>

</body>
</html>
