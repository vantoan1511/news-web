<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Home, Admin" /></title>

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->


<link
	href="${pageContext.request.contextPath}/template/admin/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.22.0/dist/bootstrap-table.min.css">
<link
	href="${pageContext.request.contextPath}/template/admin/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/template/admin/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/template/admin/assets/vendor/quill/quill.snow.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/template/admin/assets/vendor/quill/quill.bubble.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/template/admin/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/template/admin/assets/vendor/simple-datatables/style.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link
	href="${pageContext.request.contextPath}/template/admin/assets/css/style.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"
	integrity="sha512-frFP3ZxLshB4CErXkPVEXnd5ingvYYtYhE5qllGdZmcOlRKNEPbufyupfdSTNmoF5ICaQNO6SenXzOZvoGkiIA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>

	<!-- Header -->
	<%@ include file="/common/admin/header.jsp"%>

	<!-- Sidebar -->
	<%@ include file="/common/admin/sidebar.jsp"%>

	<!-- Body -->
	<dec:body />

	<!-- Footer -->
	<%@ include file="/common/admin/footer.jsp"%>

	<!-- Vendor JS Files -->

	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/chart.js/chart.umd.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/echarts/echarts.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/quill/quill.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/tinymce/tinymce.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script
		src="${pageContext.request.contextPath}/template/admin/assets/js/main.js"></script>

	<script
		src="https://unpkg.com/bootstrap-table@1.22.0/dist/bootstrap-table.min.js"></script>
	<script
		src="https://unpkg.com/bootstrap-table@1.22.0/dist/extensions/mobile/bootstrap-table-mobile.js"></script>


</body>
</html>