var maxSize = 6;
var currentPage = 1;

function send(){
    let json = {"currentPage":currentPage,"maxSize":maxSize}
    $.ajax({
        url:"/news",
        method:"post",
        data:json,
        dataType:"json",
        success:function (result) {
            console.log(result)
            initNews(result.news)
            initNewsTypes(result.newstypes)
        }
    })
}

function changeCurrentPage(page) {
    console.log(page)
    alert(page)
    currentPage = page
    send()
}

function initNewsTypes(data) {
    let ps = "";
    for (let i=0;i<data.length;i++){
        ps+="<div style=\"position:relative;width: 100px;color: white;float: left;text-align: center\">\n" +
            "            <label style=\"width:100px;margin: 0 auto;text-align: center\">"+data[i]+"</label>\n" +
            "        </div>"
    }
    $("#newsTypes").html(ps)
}
function initNews(data){
    let ps = ""
    for(let i=0;i<data.length;i++){
        let time = new Date(data[i].date)
        ps+="<li style=\"list-style: none;border-bottom: 1px dotted #dbd4cd;\">\n" +
            "                <div style=\"display: flex\">\n" +
            "                    <div style=\"background-color: orangered;margin: 20px 5px;width: 60px;height: 60px;\">\n" +
            "                        <span style=\"display:inline-block;line-height:41px;color:#fff;font-size:24px;margin: 0 auto;text-align:center;width: inherit;height: auto\">\n" +
            "                            "+time.getDay()+"\n" +
            "                        </span>\n" +
            "                        <span style=\"color:#fff;font-size:13px;display:block;height: 18px;line-height: 18px;text-align: center \">\n" +
            "                            "+time.getFullYear()+"-"+time.getMonth()+"\n" +
            "                        </span>\n" +
            "                    </div>\n" +
            "                    <div style=\"margin-left: 20px\" >\n" +
            "                        <p style=\"display: inline-block;font-family: Microsoft YaHei;font-size: 14px;color: #000000;font-weight: bold;text-decoration: none;line-height: 140%;\">\n" +
            "                            "+data[i].title+"\n" +
            "                        </p>\n" +
            "                        <p style=\"line-height: 120%;margin-top:0;display: inline-block;font-family: Microsoft YaHei;font-size: 12px;color: #666666;font-weight: normal;text-decoration: none;text-align: justify;width: 99%;overflow: hidden;\">\n" +
            "                           "+ data[i].body+"\n" +
            "                        </p>\n" +
            "                    </div>\n" +
            "                </div>\n" +
            "            </li>"
    }
    $("#newsUl").html(ps)
}


send()
getPage("news",maxSize)