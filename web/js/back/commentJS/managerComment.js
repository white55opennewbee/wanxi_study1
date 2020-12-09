var currentPage = 1;
var maxSize = 4;

function searchComments() {
    let name = $("#name").val()
    let startTime = $("#startTime").val()
    let endTime = $("#endTime").val()
    let data = {
        "name": name,
        "startTime": startTime,
        "endTime": endTime,
        "currentPage": currentPage,
        "maxSize": maxSize
    }
    // let result = myAjax("/back/searchcomments",data,"post")
    //
    // initData(result.comments)
    // setPage(result.counts)

    $.ajax({
        url: "/back/searchcomments",
        method: "post",
        data: data,
        dataType: "json",
        success: function (result) {
            initData(result.comments)
            setPage(result.counts)
        }
    })
}

function setPage(count) {
    let num = Math.ceil(count / maxSize);
    let ps = "";
    for (let i = 0; i < num; i++) {
        let j = i + 1;
        ps += "<a id='pages' href='javascript:void(0);' onclick='setCurrentPage(" + j + ")'>" + j + "</a> &nbsp;"
    }
    $("#bootbar").html(ps)
}

function setCurrentPage(page) {
    currentPage = page
    searchComments()
}


function initData(data) {
    console.log(data)
    let ps = ""
    for (let i = 0; i < data.length; i++) {
        ps += "<div>\n" +
            "            <div>\n" +
            data[i].commonUsername +
            "            </div>\n" +
            "            <div>\n" +
            data[i].userEmail +
            "            </div>\n" +
            "            <div>\n" +
            data[i].userCommon +
            "            </div>\n" +
            "            <div>\n" +
            "<input type='date' value=" + fmtDate(data[i].commonTime) + ">"
            +
            "            </div>\n" +
            "            <div>\n" +
            "            <input type=\"button\" value=\"删除\" onclick='deleteComment(" + data[i].id + ");'>\n" +
            "            </div>\n" +
            "        </div>"
    }
    console.log(ps)
    $(".conContent").html(ps)
}

function fmtDate(obj) {
    let date = new Date(obj);
    let y = 1900 + date.getYear();
    let m = "0" + (date.getMonth() + 1);
    let d = "0" + date.getDate();
    return y + "-" + m.substring(m.length - 2, m.length) + "-" + d.substring(d.length - 2, d.length);
}

function deleteComment(id) {
    $.ajax({
        url: "/back/deletecomment?id=" + id,
        method: "get",
        success: function (data) {
            if ("true" == data) {
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

function send(page) {
    $.ajax({
        url: "/back/showcomment?currentPage=" + page + "&maxsize=4",
        method: "get",
        success: function (data) {
            console.log(data)
            initData(data);
        }
    })
}

// send(1)
// getPage("comment",4)
searchComments();