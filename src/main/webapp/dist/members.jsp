<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html class="no-js" lang="vi" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: My-Task:: Ngày lễ</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon"> <!-- Favicon-->
    <!-- plugin css file  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/assets/plugin/datatables/responsive.dataTables.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/assets/plugin/datatables/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/assets/css/my-task.style.min.css">
    <style>
</style>
</head>
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
		<!-- end sider bar -->
<!-- denday -->

    <!-- main body area -->
    <div class="main px-lg-4 px-md-4">

        <!-- Body: Header -->
        <div class="header">
            <nav class="navbar py-4">
                <div class="container-xxl">
    
                    <!-- header rightbar icon -->
                    <div class="h-right d-flex align-items-center mr-5 mr-lg-0 order-1">
                        <div class="d-flex">
                            <a class="nav-link text-primary collapsed" href="help.html" title="Trợ giúp">
                                <i class="icofont-info-square fs-5"></i>
                            </a>
                            <div class="avatar-list avatar-list-stacked px-3">
                                <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar2.jpg" alt="">
                                <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar1.jpg" alt="">
                                <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar3.jpg" alt="">
                                <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar4.jpg" alt="">
                                <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar7.jpg" alt="">
                                <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar8.jpg" alt="">
                                <span class="avatar rounded-circle text-center pointer" data-bs-toggle="modal" data-bs-target="#addUser"><i class="icofont-ui-add"></i></span>
                            </div>
                        </div>
                        <div class="dropdown notifications zindex-popover">
                            <a class="nav-link dropdown-toggle pulse" href="#" role="button" data-bs-toggle="dropdown">
                                <i class="icofont-alarm fs-5"></i>
                                <span class="pulse-ring"></span>
                            </a>
                            <div id="NotificationsDiv" class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-sm-end p-0 m-0">
                                <div class="card border-0 w380">
                                    <div class="card-header border-0 p-3">
                                        <h5 class="mb-0 font-weight-light d-flex justify-content-between">
                                            <span>Thông báo</span>
                                            <span class="badge text-white">11</span>
                                        </h5>
                                    </div>
                                    <div class="tab-content card-body">
                                        <div class="tab-pane fade show active">
                                            <ul class="list-unstyled list mb-0">
                                                <li class="py-2 mb-1 border-bottom">
                                                    <a href="javascript:void(0);" class="d-flex">
                                                        <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar1.jpg" alt="">
                                                        <div class="flex-fill ms-2">
                                                            <p class="d-flex justify-content-between mb-0 "><span class="font-weight-bold">Dylan Hunter</span> <small>2PHÚT</small></p>
                                                            <span class="">Đã thêm 2021-02-19 my-Task ui/ux Design <span class="badge bg-success">Xem lại</span></span>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="py-2 mb-1 border-bottom">
                                                    <a href="javascript:void(0);" class="d-flex">
                                                        <div class="avatar rounded-circle no-thumbnail">DF</div>
                                                        <div class="flex-fill ms-2">
                                                            <p class="d-flex justify-content-between mb-0 "><span class="font-weight-bold">Diane Fisher</span> <small>13PHÚT</small></p>
                                                            <span class="">Đã thêm công việc Bắt đầu với dự án Fast Cad</span>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="py-2 mb-1 border-bottom">
                                                    <a href="javascript:void(0);" class="d-flex">
                                                        <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar3.jpg" alt="">
                                                        <div class="flex-fill ms-2">
                                                            <p class="d-flex justify-content-between mb-0 "><span class="font-weight-bold">Andrea Gill</span> <small>1GIỜ</small></p>
                                                            <span class="">Đã hoàn thành công việc Đảm bảo chất lượng</span>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="py-2 mb-1 border-bottom">
                                                    <a href="javascript:void(0);" class="d-flex">
                                                        <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar5.jpg" alt="">
                                                        <div class="flex-fill ms-2">
                                                            <p class="d-flex justify-content-between mb-0 "><span class="font-weight-bold">Diane Fisher</span> <small>13PHÚT</small></p>
                                                            <span class="">Thêm dự án mới cho Phát triển ứng dụng</span>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="py-2 mb-1 border-bottom">
                                                    <a href="javascript:void(0);" class="d-flex">
                                                        <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar6.jpg" alt="">
                                                        <div class="flex-fill ms-2">
                                                            <p class="d-flex justify-content-between mb-0 "><span class="font-weight-bold">Andrea Gill</span> <small>1GIỜ</small></p>
                                                            <span class="">Thêm bảng chấm công cho dự án Rhinestone</span>
                                                        </div>
                                                    </a>
                                                </li>
                                                <li class="py-2">
                                                    <a href="javascript:void(0);" class="d-flex">
                                                        <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar7.jpg" alt="">
                                                        <div class="flex-fill ms-2">
                                                            <p class="d-flex justify-content-between mb-0 "><span class="font-weight-bold">Zoe Wright</span> <small class="">1NGÀY</small></p>
                                                            <span class="">Thêm sự kiện lịch</span>
                                                        </div>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <a class="card-footer text-center border-top-0" href="#"> Xem tất cả thông báo</a>
                                </div>
                            </div>
                        </div>
                        <div class="dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center zindex-popover">
                            <div class="u-info me-2">
                                <p class="mb-0 text-end line-height-sm "><span class="font-weight-bold">Dylan Hunter</span></p>
                                <small>Hồ sơ quản trị</small>
                            </div>
                            <a class="nav-link dropdown-toggle pulse p-0" href="#" role="button" data-bs-toggle="dropdown" data-bs-display="static">
                                <img class="avatar lg rounded-circle img-thumbnail" src="${pageContext.request.contextPath}/dist/assets/images/profile_av.png" alt="profile">
                            </a>
                            <div class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-end p-0 m-0">
                                <div class="card border-0 w280">
                                    <div class="card-body pb-0">
                                        <div class="d-flex py-1">
                                            <img class="avatar rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/profile_av.png" alt="profile">
                                            <div class="flex-fill ms-3">
                                                <p class="mb-0"><span class="font-weight-bold">Dylan Hunter</span></p>
                                                <small class="">Dylan.hunter@gmail.com</small>
                                            </div>
                                        </div>
                                        
                                        <div><hr class="dropdown-divider border-dark"></div>
                                    </div>
                                    <div class="list-group m-2 ">
                                        <a href="task.html" class="list-group-item list-group-item-action border-0 "><i class="icofont-tasks fs-5 me-3"></i>Công việc của tôi</a>
                                        <a href="members.html" class="list-group-item list-group-item-action border-0 "><i class="icofont-ui-user-group fs-6 me-3"></i>Thành viên</a>
                                        <a href="ui-elements/auth-signin.html" class="list-group-item list-group-item-action border-0 "><i class="icofont-logout fs-6 me-3"></i>Đăng xuất</a>
                                        <div><hr class="dropdown-divider border-dark"></div>
                                        <a href="ui-elements/auth-signup.html" class="list-group-item list-group-item-action border-0 "><i class="icofont-contact-add fs-5 me-3"></i>Thêm tài khoản cá nhân</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
    
                    <!-- menu toggler -->
                    <button class="navbar-toggler p-0 border-0 menu-toggle order-3" type="button" data-bs-toggle="collapse" data-bs-target="#mainHeader">
                        <span class="fa fa-bars"></span>
                    </button>
    
                    <!-- main menu Search-->
                    <div class="order-0 col-lg-4 col-md-4 col-sm-12 col-12 mb-3 mb-md-0 ">
                        <div class="input-group flex-nowrap input-group-lg">
                            <button type="button" class="input-group-text" id="addon-wrapping"><i class="fa fa-search"></i></button>
                            <input type="search" class="form-control" placeholder="Tìm kiếm" aria-label="search" aria-describedby="addon-wrapping">
                            <button type="button" class="input-group-text add-member-top" id="addon-wrappingone" data-bs-toggle="modal" data-bs-target="#addUser"><i class="fa fa-plus"></i></button>
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
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">Danh sách học viên</h3>
                            <div class="col-auto d-flex w-sm-100">
                                <button type="button" class="btn btn-dark btn-set-task w-sm-100" data-bs-toggle="modal" data-bs-target="#addholiday"><i class="icofont-plus-circle me-2 fs-6"></i>Thêm người dùng</button>
                            </div>
                        </div>
                    </div>
                </div> <!-- Row end  -->
                <div class="row clearfix g-3">
                  <div class="col-sm-12">
                        <div class="card mb-3">
                            <div class="card-body">
                                <table id="myProjectTable" class="table table-hover align-middle mb-0" style="width:100%">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>Tài khoản</th>
                                            <th>Mật khẩu</th>
                                            <th>Tên</th>
                                            <th>SDT</th>
                                            <th>Địa Chỉ</th>
                                            <th>Số dư</th>
                                            <th>Ngày tạo</th>
                                            <th>Ngày cập nhật</th>
                                            
                                            <th>Hành động</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <tr>
                                            <td class="text-danger ">01</td>
                                            <td class="text-danger ">hungplt</td>
                                            <td class="text-danger text-truncate">26 tháng 1, 2021</td>
                                            <td class="text-danger">Ngày Quốc khánh</td>
                                            <td class="text-danger">Ngày Quốc khánh</td>
                                            <td class="text-danger text-truncate">Ngày Quốc      khánh</td>
                                            <td class="text-danger ">Ngày Quốc</td>
                                            <td class="text-danger text-truncate">Ngày Quốssss</td>
                                            <td class="text-danger text-truncate">Ngày Quốc khánh</td>
                                  
                                            <td>
                                                <div class="btn-group" role="group" aria-label="Basic outlined example">
                                                    <button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#editholiday"><i class="icofont-edit text-success"></i></button>
                                                    <button type="button" class="btn btn-outline-secondary deleterow"><i class="icofont-ui-delete text-danger"></i></button>
                                                    <button type="button" class="btn btn-outline-secondary"><i class="icofont-eye text-danger"></i></button>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                  </div>
                </div><!-- Row End -->
            </div>
        </div>
        
        <!-- Modal Members-->
        <div class="modal fade" id="addUser" tabindex="-1" aria-labelledby="addUserLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title  fw-bold" id="addUserLabel">Mời nhân viên</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="inviteby_email">
                        <div class="input-group mb-3">
                            <input type="email" class="form-control" placeholder="Địa chỉ email" id="exampleInputEmail1" aria-describedby="exampleInputEmail1">
                            <button class="btn btn-dark" type="button" id="button-addon2">Gửi</button>
                        </div>
                    </div>
                    <div class="members_list">
                        <h6 class="fw-bold ">Nhân viên</h6>
                        <ul class="list-unstyled list-group list-group-custom list-group-flush mb-0">
                            <li class="list-group-item py-3 text-center text-md-start">
                                <div class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
                                    <div class="no-thumbnail mb-2 mb-md-0">
                                        <img class="avatar lg rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar2.jpg" alt="">
                                    </div>
                                    <div class="flex-fill ms-3 text-truncate">
                                        <h6 class="mb-0  fw-bold">Rachel Carr(bạn)</h6>
                                        <span class="text-muted">rachel.carr@gmail.com</span>
                                    </div>
                                    <div class="members-action">
                                        <span class="members-role ">Quản trị</span>
                                        <div class="btn-group">
                                            <button type="button" class="btn bg-transparent dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="icofont-ui-settings  fs-6"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                              <li><a class="dropdown-item" href="#"><i class="icofont-ui-password fs-6 me-2"></i>Đặt lại mật khẩu</a></li>
                                              <li><a class="dropdown-item" href="#"><i class="icofont-chart-line fs-6 me-2"></i>Báo cáo hoạt động</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item py-3 text-center text-md-start">
                                <div class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
                                    <div class="no-thumbnail mb-2 mb-md-0">
                                        <img class="avatar lg rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar3.jpg" alt="">
                                    </div>
                                    <div class="flex-fill ms-3 text-truncate">
                                        <h6 class="mb-0  fw-bold">Lucas Baker<a href="#" class="link-secondary ms-2">(Gửi lại lời mời)</a></h6>
                                        <span class="text-muted">lucas.baker@gmail.com</span>
                                    </div>
                                    <div class="members-action">
                                        <div class="btn-group">
                                            <button type="button" class="btn bg-transparent dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                                Thành viên
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                              <li>
                                                  <a class="dropdown-item" href="#">
                                                    <i class="icofont-check-circled"></i>
                                                      
                                                    <span>Tất cả quyền hoạt động</span>
                                                   </a>
                                                   
                                                </li>
                                                <li>
                                                     <a class="dropdown-item" href="#">
                                                        <i class="fs-6 p-2 me-1"></i>
                                                           <span>Chỉ mời & quản lý nhóm</span>
                                                       </a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="btn-group">
                                            <button type="button" class="btn bg-transparent dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                                <i class="icofont-ui-settings  fs-6"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                              <li><a class="dropdown-item" href="#"><i class="icofont-delete-alt fs-6 me-2"></i>Xóa thành viên</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="list-group-item py-3 text-center text-md-start">
                                <div class="d-flex align-items-center flex-column flex-sm-column flex-md-column flex-lg-row">
                                    <div class="no-thumbnail mb-2 mb-md-0">
                                        <img class="avatar lg rounded-circle" src="${pageContext.request.contextPath}/dist/assets/images/xs/avatar8.jpg" alt="">
                                    </div>
                                    <div class="flex-fill ms-3 text-truncate">
                                        <h6 class="mb-0  fw-bold">Una Coleman</h6>
                                        <span class="text-muted">una.coleman@gmail.com</span>
                                    </div>
                                    <div class="members-action">
                                        <div class="btn-group">
                                            <button type="button" class="btn bg-transparent dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                                Thành viên
                                            </button>
                                            <ul class="dropdown-menu dropdown-menu-end">
                                              <li>
                                                  <a class="dropdown-item" href="#">
                                                    <i class="icofont-check-circled"></i>
                                                      
                                                    <span>Tất cả quyền hoạt động</span>
                                                   </a>
                                                </li>
                                                <li>
                                                    <a class="dropdown-item" href="#">
                                                        <i class="fs-6 p-2 me-1"></i>
                                                           <span>Chỉ mời & quản lý nhóm</span>
                                                       </a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="btn-group">
                                            <div class="btn-group">
                                                <button type="button" class="btn bg-transparent dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                                                    <i class="icofont-ui-settings  fs-6"></i>
                                                </button>
                                                <ul class="dropdown-menu dropdown-menu-end">
                                                  <li><a class="dropdown-item" href="#"><i class="icofont-ui-password fs-6 me-2"></i>Đặt lại mật khẩu</a></li>
                                                  <li><a class="dropdown-item" href="#"><i class="icofont-chart-line fs-6 me-2"></i>Báo cáo hoạt động</a></li>
                                                  <li><a class="dropdown-item" href="#"><i class="icofont-delete-alt fs-6 me-2"></i>Tạm dừng thành viên</a></li>
                                                  <li><a class="dropdown-item" href="#"><i class="icofont-not-allowed fs-6 me-2"></i>Xóa thành viên</a></li>
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

        <!-- Add Holiday-->
        <div class="modal fade" id="addholiday" tabindex="-1"  aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title  fw-bold" id="addholidayLabel"> Thêm người dùng</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Tên đăng nhập</label>
                        <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
                    </div>
                    <!-- <div class="mb-3">
                        <label for="exampleFormControlInput2778" class="form-label">Ngày lễ</label>
                        <input type="date" class="form-control" id="exampleFormControlInput2778">
                    </div> -->
                    <div class="mb-3">
                        <label for="exampleFormControlInput2" class="form-label">Mật khẩu</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput3" class="form-label">Tên người dùng</label>
                        <input type="text" class="form-control" id="exampleFormControlInput3">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput4" class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" id="exampleFormControlInput4">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput5" class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" id="exampleFormControlInput5">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput7" class="form-label">Số dư</label>
                        <input type="text" class="form-control" id="exampleFormControlInput7">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput6" class="form-label">Vai trò</label>
                            <div class="radio-group">
                            <div class="radio-option">
                            <input type="radio" id="giaovien" name="vaitro" value="giaovien">
                            <label for="giaovien" class="form-label">Giáo viên</label>
                            </div>
  
                            <div class="radio-option">
                            <input type="radio" id="quantrivien" name="vaitro" value="quantrivien">
                            <label for="quantrivien" class="form-label">Quản trị viên</label>
                            </div>
  
                            <div class="radio-option">
                            <input type="radio" id="nguoidung" name="vaitro" value="nguoidung">
                            <label for="nguoidung" class="form-label">Người dùng</label>
                            </div>
                            </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput8" class="form-label">Trình độ</label>
                            <div class="radio-group">
                            <div class="radio-option">
                            <input type="radio" id="A1" name="trinhdo" value="A1">
                            <label for="A1" class="form-label">A1</label>
                            </div>
                            <div class="radio-option">
                            <input type="radio" id="A2" name="trinhdo" value="A2">
                            <label for="A2" class="form-label">A2</label>
                            </div>
                            <div class="radio-option">
                            <input type="radio" id="B1" name="trinhdo" value="B1">
                            <label for="B1" class="form-label">B1</label>
                            </div>
                            <div class="radio-option">
                            <input type="radio" id="B2" name="trinhdo" value="B2">
                            <label for="B2" class="form-label">B2</label>
                            </div>
  
                            <div class="radio-option">
                            <input type="radio" id="C1" name="trinhdo" value="C1">
                            <label for="C1" class="form-label">C1</label>
                            </div>
  
                            <div class="radio-option">
                            <input type="radio" id="C2" name="trinhdo" value="C2">
                            <label for="C2" class="form-label">C2</label>
                            </div>
                            </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy bỏ</button>
                    <button type="submit" class="btn btn-primary">Thêm</button>
                </div>
            </div>
            </div>
        </div>

        <!-- Edit Holiday-->
        <!-- <div class="modal fade" id="editholiday" tabindex="-1"  aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title  fw-bold" id="editholidayLabel">Chỉnh sửa ngày lễ</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleFormControlInputname" class="form-label">Tên ngày lễ</label>
                        <input type="email" class="form-control" id="exampleFormControlInputname" value="Ngày Quốc khánh">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput0243" class="form-label">Ngày lễ</label>
                        <input type="date" class="form-control" id="exampleFormControlInput0243" value="2021-01-26">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Xong</button>
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </div>
            </div>
            </div>
        </div> -->
    </div>
</div>

<!-- Jquery Core Js -->
<script src="${pageContext.request.contextPath}/dist/assets/bundles/libscripts.bundle.js"></script>

<!-- Plugin Js-->
<script src="${pageContext.request.contextPath}/dist/assets/bundles/dataTables.bundle.js"></script>

<!-- Jquery Page Js -->
<script src="${pageContext.request.contextPath}/js/template.js"></script>
<!-- <script>
    // project data table
    $(document).ready(function() {
        $('#myProjectTable')
        .addClass( 'nowrap' )
        .dataTable( {
            responsive: true,
            columnDefs: [
                { targets: [-1, -3], className: 'dt-body-right' }
            ]
        });
        $('.deleterow').on('click',function(){
        var tablename = $(this).closest('table').DataTable();  
        tablename
                .row( $(this)
                .parents('tr') )
                .remove()
                .draw();

        } );
    });
</script> -->
<style>
    td.text-truncate {
    max-width: 70px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
   .radio-group {
    display: flex;
    gap: 20px; /* Khoảng cách giữa các option */
    align-items: center;
    margin-top: 8px;
  }
  
  .radio-option {
    display: flex;
    align-items: center;
    gap: 5px; /* Khoảng cách giữa radio và label */
  }
  
  .radio-option input[type="radio"] {
    margin: 0; /* Bỏ margin mặc định */
  }
</style>
</body>
</html>