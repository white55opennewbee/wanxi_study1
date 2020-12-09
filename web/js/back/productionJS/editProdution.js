var productionId;

function uploadimg() {
    if ($("#photoFile").val() == '') {
        return;
    }
    var formData = new FormData();
    formData.append('photo', document.getElementById('photoFile').files[0]);
    $.ajax({
        url: "/back/uploadImg",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            if (data.type == "success") {
                $("#img").attr("src", "../img/" + data.imgname);
                alert("上传图片成功，提交后完成信息更新！")
            } else {
                alert("上传图片失败");
            }
        },
        error: function (data) {
            alert("上传失败")
        }
    });

}


function tijiao() {
    let productionName = document.getElementById("productionName").value;
    let price = document.getElementById("price").value;
    let type = document.getElementById("type").value;
    let number = document.getElementById("number").value;
    let imgfile = document.getElementById("img").src;
    let index = imgfile.lastIndexOf("/");
    let imgname = imgfile.substring(index + 1);
    let exportPlace = document.getElementById("exportPlace").value;
    let incountryPlace = document.getElementById("incountryPlace").value;
    let tradeTime = document.getElementById("tradeTime").value;

    resultString = {
        "id": productionId,
        "productionName": productionName,
        "price": price,
        "type": type,
        "number": number,
        "productionImgUrl": imgname,
        "exportPlace": exportPlace,
        "incountryPlace": incountryPlace,
        "tradeTime": tradeTime
    }
    let s = JSON.stringify(resultString);
    console.log(s)
    $.ajax({
        url: "/back/refreshproductionservlet",
        method: "post",
        data: s,
        success: function (data) {
            alert("提交成功")
        },
        error: function (data) {
            alert("提交失败");
        }

    })
}

window.onload = function () {
    let someUrl = location.search;
    productionId = window.decodeURIComponent(someUrl.split("=")[1]);
    $.ajax({
        url: "/back/getsingleproduction?id=" + productionId,
        method: "get",
        data: JSON,
        success: function (production) {
            console.log(production)
            document.getElementById("productionName").value = production.productionName;
            document.getElementById("price").value = production.price;
            document.getElementById("type").value = production.type;
            document.getElementById("number").value = production.number;
            document.getElementById("img").src = "/img/" + production.productionImgUrl;
            document.getElementById("exportPlace").value = production.exportPlace;
            document.getElementById("incountryPlace").value = production.incountryPlace;
            document.getElementById("tradeTime").value = production.tradeTime;
        }
    })
}