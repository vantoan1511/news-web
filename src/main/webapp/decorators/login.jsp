<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Đăng nhập" /></title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/scripts/bootstrap/bootstrap.min.css">
<!-- IonIcons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/scripts/ionicons/css/ionicons.min.css">
<!-- Toast -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/scripts/toast/jquery.toast.min.css">
<!-- OwlCarousel -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/scripts/owlcarousel/dist/assets/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/scripts/owlcarousel/dist/assets/owl.theme.default.min.css">
<!-- Magnific Popup -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/scripts/magnific-popup/dist/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/scripts/sweetalert/dist/sweetalert.css">
<!-- Custom style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/css/skins/all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/template/web/css/demo.css">

</head>
<body class="skin-orange">

	<!-- Header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- Header -->
	<!-- Body -->
	<dec:body />
	<!-- Body -->
	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- Footer -->

	<!-- JS -->
	<script
		src="${pageContext.request.contextPath}/template/web/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/js/jquery.migrate.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/scripts/bootstrap/bootstrap.min.js"></script>
	<script>
		var $target_end = $(".best-of-the-week");
	</script>
	<script
		src="${pageContext.request.contextPath}/template/web/scripts/jquery-number/jquery.number.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/scripts/owlcarousel/dist/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/scripts/magnific-popup/dist/jquery.magnific-popup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/scripts/easescroll/jquery.easeScroll.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/scripts/sweetalert/dist/sweetalert.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/scripts/toast/jquery.toast.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/js/demo.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/web/js/e-magz.js"></script>

</body>
</html>