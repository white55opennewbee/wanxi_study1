function sub() {
  let newsType = $("#newsType").val()
  let title = $("#title").val()
  let body = $("#body").val()
  let Json = JSON.stringify({"newsType": newsType, "body": body, "title": title});

  $.ajax({
    url: "/back/addnews",
    method: "post",
    data: Json,
    success: function (data) {
      if (data == "true") {
        alert("新增成功")
      } else {
        alert("新增失败")
      }
    },
    error: function (data) {
      alert("新增失败")
    }
  })
}