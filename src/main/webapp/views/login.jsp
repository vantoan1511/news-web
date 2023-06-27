<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<section class="login first grey">
		<div class="container">
			<div class="box-wrapper">
				<div class="box box-border">
					<div class="box-body">
						<h4>ĐĂNG NHẬP</h4>
						<c:if test="${not empty alert }">
							<div class="alert alert-${alert}" role="alert">${message }</div>
						</c:if>
						<form action=" <c:url value='/login' /> " method="post">
							<input type="hidden" name="action" value="login">
							<div class="form-group">
								<label>Tên đăng nhập</label> <input type="text" name="username"
									class="form-control">
							</div>
							<div class="form-group">
								<label class="fw">Mật khẩu <a href="#"
									class="pull-right">Quên mật khẩu?</a>
								</label> <input type="password" name="password" class="form-control">
							</div>
							<div class="form-group text-right">
								<button class="btn btn-primary btn-block">Đăng nhập</button>
							</div>
							<div class="form-group text-center">
								<span class="text-muted">Chưa có tài khoản?</span> <a
									href="register.html">Đăng ký ngay!</a>
							</div>
							<div class="title-line">hoặc</div>
							<a href="#" class="btn btn-social btn-block facebook"><i
								class="ion-social-facebook"></i> Đăng nhập với Facebook</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>