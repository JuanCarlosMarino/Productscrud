$(document).ready(function () {
  readProducts();
});

function readProducts() {
  $("#content").empty();

  $.ajax({
    method: "GET",
    url: "http://localhost:8080/products/",
    type: "JSON",
    contentType: "aplication/json",
    success: function (data) {
      for (var i = 0; i < data.length; i++) {
        var row = `<tr>
                            <td>${data[i].idProduct}</td>
                            <td>${data[i].productName}</td>
                            <td>${data[i].saleValue}</td>
                            <td>${data[i].purchaseValue}</td>
                            <td>${data[i].amount}</td>
                            <td>${data[i].idTypeProduct.typeProductName}</td>
                            <td>
                                <a href="javascript:editProduct(${data[i].idProduct})" class="btn btn-warning">Editar</span></a>
                                <a href="javascript:deleteProduct(${data[i].idProduct})"   class="btn btn-danger">Borrar</a>
                            </td>
                    </tr>`;
        $("#content").append(row);
      }
    },
  });
}

function deleteProduct(id) {
  var conf = confirm("¿Está seguro, realmente desea eliminar el registro?");
  if (conf == true) {
    $.ajax({
      url: "http://localhost:8080/products/" + id,
      method: "DELETE",
      success: function (result) {
        readProducts();
      },
      error: function (request, msg, error) {
        // handle failure
      },
    });
  }
}

function addProduct() {
  var product = {
    productName: $("#title").val(),
    purchaseValue: $("#purchase").val(),
    saleValue: $("#sale").val(),
    amount: $("#amount").val(),
    idTypeProduct: {
      idTypeProduct: $("#tipo").val(),
    },
  };

  var json = JSON.stringify(product);

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/products/",
    data: json,
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      $("#add_product").modal("hide");
      readProducts();

      $("#name").val("");
      $("#sale").val("");
      $("#purchase").val("");
      $("#amount").val("");
      $("#tipo").val("");
      location.reload();
    },
  });
}

function updateProduct() {
  // get values

  var product = {
    idProduct: sessionStorage.getItem("id"),
    productName: $("#title2").val(),
    purchaseValue: $("#purchase2").val(),
    saleValue: $("#sale2").val(),
    amount: $("#amount2").val(),
    idTypeProduct: {
      idTypeProduct: $("#tipo2").val(),
    },
  };

  var json = JSON.stringify(product);

  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/products/",
    data: json,
    contentType: "application/json; charset=utf-8",
    success: function (data) {
      $("#update_product").modal("hide");
      readProducts();
    },
  });
}

function editProduct(id) {
  sessionStorage.setItem("id", id);
  $.ajax({
    url: "http://localhost:8080/products/" + id,
    method: "GET",
    success: function (data) {
      $("#title2").val(data.productName);
      $("#sale2").val(data.saleValue);
      $("#purchase2").val(data.purchaseValue);
      $("#amount2").val(data.amount);
      $("#tipo2").val(data.idTypeProduct.idTypeProduct);

      $("#update_product").modal("show");
    },
    error: function (request, msg, error) {
      // handle failure
    },
  });
}
