var pagedata;
var defaultCurrentPage = 1;
var maxSize = 8;
var path="";

function init(data) {
    var production = "";
    for (var i = 0; i < data.length; i++) {
        production += "<div>\n" +
            "                    <div>" + data[i].id + "</div>\n" +
            ""+path+"                    <div><img  src=\"/img\"></div>\n" + data[i].productionImgUrl + "" +
            "                    <div>" + data[i].productionName + "</div>\n" +
            "                    <div>" + data[i].type + "</div>\n" +
            "                    <div>" + data[i].price + "</div>\n" +
            "                    <div>" + data[i].number + "</div>\n" +
            "                    <div>" + data[i].exportPlace + "</div>\n" +
            "                    <div>" + data[i].incountryPlace + "</div>\n" +
            "                    <div>" + data[i].tradeTime + "</div>\n" +
            "                    <div><input type=\"button\" name=\"delete\" value='删除' onclick='deleted(" + data[i].id + ")'></input>\n" +
            "                    <input type=\"button\" name=\"update\" value='编辑' onclick='trasent(" + data[i].id + ")'></input></div>\n" +
            "                </div>"
    }
    $("#product").html(production)
}

function deleted(id) {
    $.ajax({
        url: "/back/deleteproduction?id=" + id,
        method: "get",
        success: function (data) {
            alert("删除成功")
            send(1)
        },
        error: function (data) {
            alert("删除失败")
        }
    })
}

function trasent(num) {
    localStorage.setItem("data", JSON.stringify(num));
    location.href = "editproduction.html?data=" + window.encodeURIComponent(num);
}


function send(currentpage) {
    $.ajax({
        url: "/back/updateproduction?currentPage=" + currentpage,
        method: "get",
        data: JSON,
        success: function (data, textStatus, jqXHR) {
            pagedata = data;
            init(data);
        }
    })
}

function productionSearch(maxsize, currentpage) {
    let searchData;
    let searchByName = $("#searchByName").val()
    let lowestprice = $("#lowestprice").val()
    let maxprice = $("#maxprice").val()
    let selection = $("#selection").val()
    if (selection==null){
        selection = "全部"
    }
    console.log(searchByName)
    console.log(lowestprice)
    console.log(maxprice)
    console.log(selection)

    searchData = {"searchByName": searchByName, "lowestPrice": lowestprice, "maxPrice": maxprice, "selection": selection,"maxSize":maxsize,"currentPage":currentpage};

    $.ajax({
        url: "/back/searchproduction",
        method: "post",
        data: searchData,
        dataType: "json",
        success: function (result) {
            console.log(result)
            init(result.productions)
            setPages(result.counts)
        }
    })

}

function getPath(){

    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    path = result


}



function typeSearch() {
    $.ajax({
        url: "/getproductiontypes",
        method: "post",
        success: function (data) {
            console.log(data)
            let ps = "<option>\n" +
                "            全部\n" +
                "        </option>"
            for (let i = 0; i < data.length; i++) {
                ps += "<option value=" + data[i] + ">\n" +
                    data[i] +
                    "                        </option>"
            }
            $("#selection").html(ps);
        }
    })
}


function setPages(count) {
    console.log(count)
    let num = Math.ceil(count / maxSize);
    console.log(num)
    let ps = "";
    for (let i = 0; i < num; i++) {
        let j = i + 1;
        ps += "<a id='pages' href='javascript:void(0);' onclick='productionSearch(8," + j + ")'>" + j + "</a> &nbsp;"
    }
    $("#bootbar").html(ps)

}
