<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Complaints Application</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link" href="add?id=${complaint.id}">Nowa reklamacja</a></li>
          <li class="nav-item"><a class="nav-link" href="list?id=${complaint.id}">Wszystkie reklamacje</a></li>
          <li>
            <form id="logout" action="/logout" method="post">
              <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
              <button type="submit" class="btn btn-link nav-link">Wyloguj</button>
            </form>
          </li>

        </ul>
      </div>
    </div>
  </nav>
  <!-- Page Content-->
  <section class="py-5">
    <div class="text-center">
      <img src="https://www.magazyngalerie.pl/wp-content/uploads/2019/03/Reserved-fot-1.jpg" style="width: 100%;">
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
</html>
