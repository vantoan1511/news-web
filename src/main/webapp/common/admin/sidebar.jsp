<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

	<ul class="sidebar-nav" id="sidebar-nav">

		<li class="nav-item"><a class="nav-link collapsed"
			data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
				<i class="bi bi-menu-button-wide"></i><span>Quản lí bài viết</span><i
				class="bi bi-chevron-down ms-auto"></i>
		</a>
			<ul id="components-nav" class="nav-content collapse "
				data-bs-parent="#sidebar-nav">
				<li><c:url var="path" value="/admin-news">
						<c:param name="type" value="list" />
						<c:param name="page" value="1" />
						<c:param name="maxPageItem" value="2" />
						<c:param name="sortBy" value="title" />
						<c:param name="sortOrder" value="desc" />
					</c:url> <a href="${path }"> <i class="bi bi-circle"></i><span>DS
							bài viết</span>
				</a></li>
			</ul></li>
	</ul>
</aside>
<!-- End Sidebar-->