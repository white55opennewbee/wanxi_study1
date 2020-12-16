function typeSearch() {
    $.ajax({
        url: "/getproductiontypes",
        method: "post",
        success: function (data) {
            console.log(data)
            let ps = ""
            // let ps = "<option>\n" +
            //     "            全部\n" +
            //     "        </option>"
            for (let i = 0; i < data.length; i++) {
                ps += "<div style='position:relative;width: 100px;color: white;float: left;text-align: center'>" +
                    "<label style='width:100px;margin: 0 auto'>" + data[i] + "</label>" +
                    "</div>"
            }
            $("#allTypes").html(ps);
        }
    })
}

function init(data) {
    var production = "";
    for (var i = 0; i < data.length; i++) {
        production += "<li class='production' style='vertical-align:top;width:260px;margin-right:10px;list-style:none;float: left'>"+
            "<div style='margin-bottom: 8px;overflow: hidden;position: relative;height:200px;width:260px;text-align:center;vertical-align:middle;display:table-cell;'>"+
            "<img src=\"../img/"+data[i].productionImgUrl+ "\" style='position: relative; max-width: 260px; margin: 0px auto; max-height: 200px; height: 200px; width: 260px; display: inline;'>"+
            "</div>"+
            "<div  style='padding: 0 3px 0 6px;height: 70px;'>"+
            "<p style='position:relative;font: normal 100% 'Microsoft yahei', Arial, Verdana;margin:0 auto;'><a href='#'>"+data[i].productionName+"</a></p>"+
            "<span style='margin: 0 auto;padding: 0;'><a href='#'>"+data[i].type+"</a></span>"+
            "<div style='display: block;font-family: Microsoft YaHei;font-size: 13px;line-height: 136%;'>"+
            "出口:"+data[i].exportPlace+"/n"+
            "国内："+data[i].incountryPlace+"/n"+
            "交货："+data[i].tradeTime +"</div>"+
            "</div>"+
            "</li>"
    }
    $("#productionList").html(production)
}


function send(currentpage) {
    $.ajax({
        url: "/product?currentPage="+currentpage,
        method: "get",
        success: function (data) {
            data = JSON.parse(data)
            console.log(data)
            console.log(data.productions)
            init(data.productions);
        }
    })
}

function getPage(type,maxsize) {
    $.ajax({
        url:"/getpage",
        method:"get",
        data:{"Pagetype":type},
        success:function (data) {
            console.log(maxsize)
            let num = Math.ceil(data/maxsize);
            console.log(num)
            let ps = "";
            for(let i = 0;i<num;i++){
                let j = i+1;
                ps+="<a id='pages' href='javascript:void(0);' onclick='send("+j+")'>"+j+"</a> &nbsp;"
            }
            $("#bootbar").html(ps)
        }
    })
}



getPage("production",8)
send(1)
typeSearch()