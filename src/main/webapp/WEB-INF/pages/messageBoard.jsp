<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>

</head>
<body>

	<div class="container">
	
		<div class="col-md-6">
	
		<div class="input-group">
			<input id="content" type="text" class="form-control"
				placeholder="输入消息内容..."> <span class="input-group-btn">
				<button id="btn" class="btn btn-default" type="button">发布消息</button>
			</span>
		</div>
		
		</div>

		<div class="col-md-6">

		<table class="table" id="tab">


		</table>
		
		</div>
	</div>
</body>

<script type="text/javascript">

	/* $(document)
	$("#aa")
	$(".bb")
	$("div") */

	// 1. 点击发布消息的按钮
	$("#btn").click(function() {
		// 向后台发送文本框的内容
		// 需要一个添加数据的ajax请求
		// 发送的信息: 文本框中输入的内容
		// 一旦添加成功: 就在table中添加一行

		$.ajax({
			url : "addnew",
			type : "get",
			data : {
				content : $("#content").val()
			},
			success : function(res) {
				
				if(res.errorCode == 0){
					var r = res["obj"];
					addNewTR(r.content, r.id, r.up, r.down, true)
				} else {
					/* alert(res.msg) */
				}
			}
		})

		// addNewTR("suibian", 200, 22, 2, true)

	})

	// 2. 访问页面就展示所有的消息列表
	function getAllMessages() {
		// 利用ajax请求所有的数据
		// 利用for循环遍历所有的数据, 在table中依次添加一行

		$.ajax({
			url : "findall",
			success : function(res) {

				for (var i = 0; i < res.length; i++) {
					var ob = res[i];
					addNewTR(ob.content, ob.id, ob.up, ob.down, true)
				}
			}
		})
	}

	getAllMessages()

	// 3. 负责添加一行标签tr
	function addNewTR(content, id, upCount, downCount, how) {

		var tdleft = $("<td></td>").html("<p>" + content + "</p>")
		var tdright = $("<td></td>")

		tdright.append("顶:")
		$("<a href='###'></a>").html(upCount).appendTo(tdright)
		tdright.append("踩:")
		$("<a href='###'></a>").html(downCount).appendTo(tdright)
		
		$("<a href='###'>删除</a>").appendTo(tdright).click(delfunc).attr("num", id)

		// <a href='###' num='2'>删除</a>
		var trOb = $("<tr></tr>").append(tdleft).append(tdright).attr("id",
				"tr" + id)
		// <tr id="tr1"></tr>

		// 把设置好的tr标签加到table中
		
		if(how == true){
			$("#tab").prepend(trOb)
		} else {
			$("#tab").append(trOb)
		}
		
	}
	
	var delfunc = function () {
		
		// 拿到a标签的id值
		var aid = $(this).attr("num")
		// 将要删除的id发送给后台处理
		$.ajax({
			url:"deleteone",
			data:{
				msgid:aid
			},
			success:function(res){
				// 成功之后删除tr标签
				// $("#tr2")
				$("#tr"+res.obj).remove()
			}
		})
	}
		
</script>


</html>