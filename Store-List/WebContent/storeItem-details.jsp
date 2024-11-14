<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Store</title>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <style>
        .card {
            background-color: #F2F2F2;
            transition: transform 0.2s;
            position: relative;
        }

        .card-title {
            color: #333;
        }

        .card-text {
            color: #555;
        }

        .card:hover {
            transform: scale(1.05);
            background-color: #CDC1FF;
        }

        .card-body {
            flex-grow: 1;
        }

        .add-to-cart-button {
            position: absolute;
            bottom: 10px;
            right: 20px;
        }

        .card img {
            height: 200px;
            object-fit: cover;
            width: 100%;
            border-bottom: 1px solid #ddd;
        }

        /* Modal Styling */
        .modal-body img {
            width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <br>
    <div class="container">
        <h1 class="text-center">Special Offers</h1>
        <br>
        <hr>
        <br>
        
        <div class="row">
            <c:forEach var="store" items="${menuList}">
                <div class="col-md-4">
                    <div class="card mb-4">
                        <img src="${store.image}" alt="Food Image" class="card-img-top"> <!-- Display the image -->
                        <div class="card-body">
                            <h4 class="card-title">${store.menuName}</h4>
                            <p class="card-text">
                                <strong>Category ID:</strong> ${store.categoryID}<br>
                                <strong>Price:</strong> ${store.price}<br>
                                <strong>Discount:</strong> ${store.discount}%
                            </p>
                            <button class="btn btn-primary btn-cart add-to-cart-button" data-toggle="modal" data-target="#viewMoreModal"
                                    onclick="showDetails('${store.menuName}', '${store.price}', '${store.discount}', '${store.description}', '${store.categoryID}', '${store.image}', '${store.startDate}', '${store.endDate}')">
                                View more
                            </button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="viewMoreModal" tabindex="-1" role="dialog" aria-labelledby="viewMoreModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="viewMoreModalLabel">Item Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <img id="modal-image" src="" alt="Food Image" class="img-fluid mb-3">
                    <h4 id="modal-menu-name"></h4>
                    <p><strong>Category ID:</strong> <span id="modal-category-id"></span></p>
                    <p><strong>Price:</strong> <span id="modal-price"></span></p>
                    <p><strong>Discount:</strong> <span id="modal-discount"></span>%</p>
                    <p><strong>Description:</strong> <span id="modal-description"></span></p>
                    <p><strong>Start Date:</strong> <span id="modal-start-date"></span></p>
                    <p><strong>End Date:</strong> <span id="modal-end-date"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXn2x2x5Bf5f5Vg5f5Vg5f5w5D"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-o5NQOvGB6jkHtr6Bf5f5f5f5f5mJZf4/cW5F5j5okp5s5l5r5N5r5N5r5T5V5s5C5k5"
        crossorigin="anonymous"></script>

    <script>
        function showDetails(menuName, price, discount, description, categoryID, image, startDate, endDate) {
            document.getElementById('modal-menu-name').textContent = menuName;
            document.getElementById('modal-price').textContent = price;
            document.getElementById('modal-discount').textContent = discount || '0';
            document.getElementById('modal-description').textContent = description || 'No description available.';
            document.getElementById('modal-category-id').textContent = categoryID;
            document.getElementById('modal-start-date').textContent = startDate;
            document.getElementById('modal-end-date').textContent = endDate;
            document.getElementById('modal-image').src = image;
        }
    </script>

    <hr>
    <jsp:include page="footer.jsp" />
</body>
</html>
