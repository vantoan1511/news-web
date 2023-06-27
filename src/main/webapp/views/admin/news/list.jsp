<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news" />
<c:url var="newsURL" value="/admin-news" />
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

		<section class="section">
			<div class="row">
				<div class="col-lg-2">
					<div class="row">
						<div class="">
							<a flag="info" href="<c:url value='/admin-news?type=edit' />"
								class="btn btn-outline-primary" aria-current="page"
								title="Thêm bài viết" data-toggle="tooltip"> <span> <i
									class="bi bi-plus-square"></i>
							</span>
							</a>
							<button id="btnDelete" type="button" class="btn btn-danger"
								data-toggle="tooltip" title="Xóa bài viết">
								<span> <i class="bi bi-trash3"></i>
								</span>
							</button>
						</div>
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-lg-12">
					<div class="row">
						<form action="<c:url value='/admin-news'/> " id="formSubmit"
							method="get">
							<table class="table table-hover" data-check-on-init=true
								data-mobile-responsive=true data-toggle="table">
								<thead>
									<tr>
										<th scope="col"><input class="form-check-input"
											type="checkbox" id="selectAll" value="" aria-label="..."></th>
										<th scope="col">ID</th>
										<th scope="col">Tên bài viết</th>
										<th scope="col">Mô tả</th>
										<th scope="col">Thể loại</th>
										<th scope="col">Tùy chỉnh</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.getLists()}">
										<tr>
											<th scope="col"><input class="form-check-input"
												type="checkbox" id="checkbox_${item.id}" value="${item.id}"
												aria-label="..."></th>
											<th scope="row">${item.id}</th>
											<td>${item.title}</td>
											<td>${item.description}</td>
											<td>${item.categoryId }</td>
											<td><c:url var="editURL" value='/admin-news'>
													<c:param name="type" value="edit" />
													<c:param name="id" value="${item.id}" />
												</c:url> <a class="btn btn-outline-primary" data-toggle="tooltip"
												title="Cập nhật bài viết" href="${editURL}"> <i
													class="bi bi-pencil-square"></i>
											</a></td>
										</tr>
									</c:forEach>
							</table>
							<br />
							<div class="container">
								<ul class="pagination justify-content-center" id="pagination"></ul>
								<input type="hidden" value="list" id="type" name="type">
								<input type="hidden" value="" id="page" name="page"> <input
									type="hidden" value="" id="maxPageItem" name="maxPageItem">
								<input type="hidden" value="" id="sortBy" name="sortBy">
								<input type="hidden" value="" id="sortOrder" name="sortOrder">
							</div>
						</form>
					</div>
				</div>
			</div>

		</section>
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
		
		$('#btnDelete').click((e)=>{
			e.preventDefault();
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function(){
				return $(this).val();
			}).get();
			
			data["ids"] = ids;
			const deleteNews = function (data) {
				$.ajax({
					url: '${APIurl}',
					type: 'DELETE',
					contentType: 'application/json',
					data: JSON.stringify(data),
					success: function(result){
						window.location.href = "${newsURL}?type=list&maxPageItem=2&page=1&sortBy=title&sortOrder=desc";
					},
					error: function(error){
						console.log(error);
					}
				});
			}
			deleteNews(data);
		});
	</script>
</body>
</html>