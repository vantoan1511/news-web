<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<main id="main" class="main">

		<div class="pagetitle">
			<h1>Danh sách bài viết</h1>
			<nav>
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href="<c:url value='/admin-home'/>">Trang chủ</a></li>
					<li class="breadcrumb-item active">Danh sách bài viết</li>
				</ol>
			</nav>
		</div>
		<!-- End Page Title -->
		<form action="<c:url value='/admin-news-list'/> " id="formSubmit"
			method="get">
			<section class="section">
				<div class="row">
					<div class="col-lg-12">
						<div class="row">
							<table class="table table-hover" data-check-on-init=true
								data-mobile-responsive=true data-toggle="table">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Tên bài viết</th>
										<th scope="col">Mô tả</th>
										<th scope="col">Thể loại</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.getLists()}">
										<tr>
											<th scope="row">${item.getId()}</th>
											<td>${item.title}</td>
											<td>${item.description}</td>
											<td>${item.categoryId }</td>
										</tr>
									</c:forEach>
							</table>
							<div class="container">
								<ul class="pagination justify-content-center" id="pagination"></ul>
								<input type="hidden" value="" id="page" name="page">
								<input type="hidden" value="" id="maxPageItem" name="maxPageItem">
								<input type="hidden" value="" id="sortBy" name="sortBy">
								<input type="hidden" value="" id="sortOrder" name="sortOrder">
							</div>

						</div>
					</div>
				</div>
			</section>
		</form>
	</main>
	<!-- End #main -->
	<script type="text/javascript">
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 2;
		$('#pagination').twbsPagination({
			totalPages : totalPages,
			visiblePages : 5,
			startPage : currentPage,
			next : 'Tiếp',
			prev : 'Lùi',
			first : 'Đầu',
			last : 'Cuối',
			onPageClick : function(event, page) {
				if (page != currentPage) {
					console.log(currentPage);
					$('#maxPageItem').val(limit);
					$('#page').val(page);
					$('#sortBy').val('title');
					$('#sortOrder').val('desc');
					$('#formSubmit').submit();
				}	
			}
		});
	</script>
</body>
</html>