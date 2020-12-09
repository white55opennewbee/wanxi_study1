var pagedata;
var maxSize = 4;
var currentPage = 1;

function searchToTopNews() {
    $.ajax({
        url:"/gettotopnews",
        method:"post",
        success:function (result) {
            let ps = "";
            for (let i=0;i<result.length;i++){
                let toTop = "置顶";
                if (result[i].toTop == 1){
                    toTop = "取消置顶";
                }
                ps+="<div class=\"newsStyle\">\n" +
                    "                <div>"+result[i].id+"</div>\n" +
                    "                <div>" + result[i].newsType + "</div>\n" +
                    "                <div>" + result[i].title + "</div>\n" +
                    "                <div>点击编辑查看</div>\n" +
                    "                <div><input type=\"button\" value=\"删除\" onclick=\"Delete(" + result[i].id + ")\"><input type=\"button\" value=\"编辑\" onclick=\"toEdit(" + result[i].id + ")\"><input type=\"button\" id='toTop' value="+toTop+" onclick=\"toTop(" + result[i].id +","+ result[i].toTop+ ")\"></div>\n" +
                    "            </div>"
            }
            $(".TopNewsContent").html(ps);
        }
    })
}



function searchNews() {
    let newsType = $("#newsType").val()
    let newsTitle = $("#newsTitle").val()
    let startTime = $("#startTime").val()
    let endTime = $("#endTime").val()
    if (newsType==undefined||newsType == ""){
        newsType = "全部";
    }
    let data = {"newsType": newsType, "newsTitle": newsTitle, "startTime": startTime, "endTime": endTime,"currentPage":currentPage,"maxSize":maxSize};
    $.ajax({
        url: "/back/searchnews",
        data: data,
        method:"post",
        dataType: "json",
        success: function (result) {
            init(result.news)
            setPages(result.counts)
        }
    })
}


function Delete(id) {
    $.ajax({
        url: "/back/deletenews?id=" + id,
        method: "get",
        success: function (data) {
            if (data == "true") {
                alert("删除成功")
            } else {
                alert("删除失败")
            }
        },
        error: function (data) {
            alert("删除失败")
        }


    })
}


function init(data) {
    let pp = "";
    let ps = "";
    for (let i = 0; i < data.length; i++) {
        let toTop = "置顶";
        if (data[i].toTop == 1){
            toTop = "取消置顶";
        }
        ps += "<div class=\"newsStyle\">\n" +
            "                <div>"+data[i].id+"</div>\n" +
            "                <div>" + data[i].newsType + "</div>\n" +
            "                <div>" + data[i].title + "</div>\n" +
            "                <div>点击编辑查看</div>\n" +
            "                <div><input type=\"button\" value=\"删除\" onclick=\"Delete(" + data[i].id + ")\"><input type=\"button\" value=\"编辑\" onclick=\"toEdit(" + data[i].id + ")\"><input type=\"button\" id='toTop' value="+toTop+" onclick=\"toTop(" + data[i].id +","+ data[i].toTop+ ")\"></div>\n" +
            "            </div>"
        // pp += "<div>" + data[i].id + "</div>\n" +
        //     "        <div>" + data[i].newsType + "</div>\n" +
        //     "        <div>" + data[i].title + "</div>\n" +
        //     "        <div>点击编辑查看</div>\n" +
        //     "        <div><input type=\"button\" value=\"删除\" onclick=\"Delete(" + data[i].id + ")\"></div>\n" +
        //     "        <div><input type=\"button\" id='toTop' value="+toTop+" onclick=\"toTop(" + data[i].id +","+ data[i].toTop+ ")\"></div>\n" +
        //     "        <div style=\"margin-left: 1px\"><input type=\"button\" value=\"编辑\" onclick=\"toEdit(" + data[i].id + ")\"></div>"
    }
    $(".OtherNewsContent").html(ps);
}

function toTop(id,totop) {
    $.ajax({
        url:"/back/canceltotop",
        method:"post",
        data:{"id":id,"toTop":totop},
        success:function (result) {
            searchNews();
            searchToTopNews();
        },
        error:function (result) {
            alert("置顶或取消置顶失败")
        }
    })
}


function toEdit(id) {
    window.location.href = "editnews.html?id=" + id;
}


function send(currentpage) {
    $.ajax({
        url: "/back/updatenews?currentPage=" + currentpage + "&maxSize=4",
        method: "get",
        data: JSON,
        success: function (data, textStatus, jqXHR) {
            console.log(data)
            pagedata = data;
            init(data);
        }
    })
}
function findAllTypes() {
    let ps = "<option>\n" +
        "                全部\n" +
        "            </option>"
    $.ajax({
        url:"/back/getnewstypes",
        method:"post",
        success:function (result) {
            for (let i = 0;i<result.length;i++){
                ps += "<option>\n" +
                    result[i] +
                    "            </option>"
            }
            $("#newsType").html(ps);
        }
    })


}

function setPages(counts) {
    let num = Math.ceil(counts / maxSize);
    console.log(num)
    let ps = "";
    for (let i = 0; i < num; i++) {
        let j = i + 1;
        ps += "<a id='pages' href='javascript:void(0);' onclick='setCurrentPages(" + j +")'>" + j + "</a> &nbsp;"
    }
    $("#bootbar").html(ps)
}

function setCurrentPages(cp) {
    currentPage = cp;
    searchNews();
}