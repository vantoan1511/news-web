<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật bài viết</title>
</head>
<body>
	<main id="main" class="main">
		<div class="pagetitle">
			<h1>Cập nhật bài viết</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="<c:url value='/admin-home'/>">Trang chủ</a></li>
					<li class="breadcrumb-item"><a
						href="<c:url value='/admin-news?type=list&page=1&maxPageItem=2&sortBy=title&sortOrder=desc'/>">Danh
							sách bài viết</a></li>
					<li class="breadcrumb-item active">Cập nhật bài viết</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<section class="section">
			<div class="row">
				<div class="container">
					<c:if test="${not empty messgae }">
						<div class="alert alert-${alert}" role="alert">${message }</div>
					</c:if>
					<form id="formSubmit">
						<div class="row justify-content-start">
							<label class="control-label col-sm-3">Thể loại</label>
							<div class="col-sm-3">
								<select class="form-select" name="categoryCode"
									id="categoryCode">
									<option selected>--Chọn thể loại--</option>
									<c:if test="${ empty model.categoryCode }">
										<c:forEach var="item" items="${categories }">
											<option value="${item.code }">${item.name }</option>
										</c:forEach>
									</c:if>
									<c:if test="${not empty model.categoryCode }">
										<c:forEach var="item" items="${categories }">
											<option
												<c:if test="${item.code == model.categoryCode }">selected</c:if>
												value="${item.code }">${item.name }</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</div>
						<br />
						<div class="row justify-content-start">
							<label class="col-sm-3 control-label">Tiêu đề</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="title" name="title"
									value="${model.title }" />
							</div>
						</div>
						<br />
						<div class="row justify-content-start">
							<label class="col-sm-3 control-label">Hình đại diện</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="thumbnail"
									name="thumbnail" value="" />
							</div>
						</div>
						<br />
						<div class="row justify-content-start">
							<label class="col-sm-3 control-label">Mô tả ngắn</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="description"
									name="description" value="${model.description }" />
							</div>
						</div>
						<br />
						<div class="row justify-content-start">
							<label class="col-sm-3 control-label">Nội dung</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="content"
									name="content" value="${model.content }" />
							</div>
						</div>
						<br />
						<div class="row justify-content-center">
							<div class="col-sm-2">
								<c:if test="${not empty model.id }">
									<input type="button" class="form-control" id="btnAddOrUpdate"
										name="btnAddOrUpdate" value="Cập nhật bài viết" />
								</c:if>
								<c:if test="${empty model.id }">
									<input type="button" class="form-control" id="btnAddOrUpdate"
										name="btnAddOrUpdate" value="Thêm bài viết" />
								</c:if>
							</div>
						</div>
						<input type="hidden" value="${model.id }" id="id" name="id" />
					</form>
				</div>
			</div>
		</section>
	</main>
	<!-- End #main -->
	<script type="text/javascript">
		$('#btnAddOrUpdate').click( (e)=>{
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, (i, v) => {
				console.log(v);
				data[""+v.name+""] = v.value; 
			});
			
			const addNews = function (data) {
				$.ajax({
					url: '${APIurl}',
					type: 'POST',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function(result){
						console.log(result);
					},
					error: function(error){
						console.log(error);
					}
				});
			}
			const updateNews = function (data){
				$.ajax({
					url: '${APIurl}',
					type: 'PUT',
					contentType: 'application/json',
					data: JSON.stringify(data),
					dataType: 'json',
					success: function(result){
						console.log(result);
					},
					error: function(error){
						console.log(error);
					}
				});
			}
			
			var id = $('#id').val();
			if(id == "") {
				addNews(data);
			}else {
				updateNews(data);
			}
		} );
	</script>
</body>
</html>