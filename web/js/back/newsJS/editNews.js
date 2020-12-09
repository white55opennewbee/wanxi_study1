var newsid;
function sub() {
    let newsType = $("#newsType").val()
    let title = $("#title").val()
    let body = $("#body").val()


    let Json = JSON.stringify({"newsType": newsType, "body": body, "title": title, "id": newsid});

    $.ajax({
        url: "/back/refreshnews",
        method: "post",
        data: Json,
        success: function (data) {
            if (data == "true") {
                alert("更新成功")
                window.location.href="managernews.html"
            } else {
                alert("更新失败")
            }
        },
        error: function (data) {
            alert("更新失败")
        }
    })
}

function getSinglenews() {
    let href = location.href;
    let num = href.lastIndexOf("=");
    let id = href.substring(num + 1)
    newsid = id
    console.log(id)
    $.ajax({
        url: "/back/getsinglenews?id=" + id,
        method: "get",
        success: function (data) {
            $("#newsType").val(data.newsType)
            $("#body").val(data.body)
            $("#title").val(data.title)
        }
    })
}

window.onload = getSinglenews();