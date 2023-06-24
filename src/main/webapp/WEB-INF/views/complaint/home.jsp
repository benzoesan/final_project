
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
  <title>Spring Security Example</title>
</head>
<body>
<h1>Witaj użytkowniku </h1>
<div></div>
<td><a href="add?id=${complaint.id}">Dodaj nową reklamację</a></td>
<td><a href="list?id=${complaint.id}">wyswietl liste</a></td>
</body>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
      <a class="navbar-brand" href="index.html">Start Bootstrap</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
          <li class="nav-item"><a class="nav-link" href="about.html">About</a></li>
          <li class="nav-item"><a class="nav-link" href="add?id=${complaint.id}">Dodaj</a></li>
          <li class="nav-item"><a class="nav-link" href="list?id=${complaint.id}">Lista</a></li>
          <li class="nav-item"><a class="nav-link" href="faq.html">FAQ</a></li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Blog</a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
              <li><a class="dropdown-item" href="blog-home.html">Blog Home</a></li>
              <li><a class="dropdown-item" href="blog-post.html">Blog Post</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdownPortfolio" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Portfolio</a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownPortfolio">
              <li><a class="dropdown-item" href="portfolio-overview.html">Portfolio Overview</a></li>
              <li><a class="dropdown-item" href="portfolio-item.html">Portfolio Item</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- Page Content-->
  <section class="py-5">
    <div class="container px-5 my-5">
      <div class="text-center mb-5">
        <h1 class="fw-bolder">Our Work</h1>
        <p class="lead fw-normal text-muted mb-0">Company portfolio</p>
      </div>
    </div>
  </section>
</main>
<!-- Footer-->
<footer class="bg-dark py-4 mt-auto">
  <div class="container px-5">
    <div class="row align-items-center justify-content-between flex-column flex-sm-row">
      <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; Your Website 2023</div></div>
      <div class="col-auto">
        <a class="link-light small" href="#!">Privacy</a>
        <span class="text-white mx-1">&middot;</span>
        <a class="link-light small" href="#!">Terms</a>
        <span class="text-white mx-1">&middot;</span>
        <a class="link-light small" href="#!">Contact</a>
      </div>
    </div>
  </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>