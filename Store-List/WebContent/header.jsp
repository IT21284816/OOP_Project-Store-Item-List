<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Insert title here</title>
<style>
    .navbar {
        background-color: #6439FF; 
    }

    .nav-link {
        font-size: 18px; 
        color: #fff; 
        padding: 15px 10px; 
    }

    .nav-link i {
        font-size: 20px; 
    }

    @media (max-width: 768px) {
        .nav-link {
            font-size: 16px; 
            padding: 10px; 
        }

        .navbar {
            height: auto; 
        }
    }
</style>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/all-list">
                <i class="fas fa-home"></i> Home
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-shopping-cart"></i> Cart</a></li>
                    <li class="nav-item"><a href="${pageContext.request.contextPath}/list" class="nav-link"><i class="fas fa-cogs"></i> Admin</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-info-circle"></i> About Us</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-envelope"></i> Contact Us</a></li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-user-plus"></i> Register</a></li>
                    <li class="nav-item"><a href="#" class="nav-link"><i class="fas fa-sign-in-alt"></i> Login</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
