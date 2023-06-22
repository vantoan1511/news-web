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
				<li><a
					href="<c:url value='/admin-news-list?page=1&maxPageItem=2&sortBy=title&sortOrder=desc'/>">
						<i class="bi bi-circle"></i><span>DS bài viết</span>
				</a></li>
			</ul></li>
	</ul>

</aside>
<!-- End Sidebar-->