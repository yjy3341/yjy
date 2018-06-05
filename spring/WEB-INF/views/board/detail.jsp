<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<section class="content">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">상세보기</h3>
			</div>

			<div class="box-body">
				<div class="form-group">
					<label>제목</label> <input type="text" name="title"
						class="form-control" value="${vo.title}" readonly="readonly" />
				</div>

				<div class="form-group">
					<label>내용</label>
					<textarea name="content" rows="5" readonly="readonly"
						class="form-control">${vo.content}</textarea>
				</div>

				<div class="form-group">
					<label>작성자</label> <input type="text" class="form-control"
						value="${vo.nickname}" readonly="readonly" />
				</div>
			</div>
			<div class="box-footer">
				<button class="btn btn-success" id="mainbtn">메인</button>
				<c:if test="${user.email == vo.email}">
					<button class="btn btn-warning" id="updatebtn">수정</button>
					<button class="btn btn-danger" id="deletebtn">삭제</button>
				</c:if>
				<button class="btn btn-primary" id="listbtn">목록</button>
				<button class="btn btn-info" id="replyadd">댓글작성</button>
			</div>
		</div>
	</section>
	
	<!-- 댓글 작성 및 수정 대화상자 영역 -->
	<div class="box-body" style="display:none" id="replyform">
		<label for="nickname">작성자</label>
		<input class="form-control" type="text" id="nickname"
		value="${user.nickname}" readonly="readonly" />
		<label for="replytext">댓글내용</label>
		<input type="text" class="form-control" id="replytext"
		placeholder="댓글 내용을 작성하세요!" />
	</div>
	
	
	<%@ include file="../include/footer.jsp"%>
	<script>
		//댓글 작성 버튼을 눌렀을 때 수행할 내용
		document.getElementById("replyadd").addEventListener(
			"click", function(){
			$('#replyform').dialog({
				resizable:false,
				height:'auto',
				width:400,
				model:true,
				buttons:{
					"저장":function(){
						$(this).dialog("close");
						//입력한 내용 가져오기
						replytext = document.getElementById("replytext").value;
						$.ajax({
							url:"../reply/register",
							data:{
								"bno":'${vo.bno}',
								"email":'${user.email}',
								"nickname":'${user.nickname}',
								"replytext": replytext
							},
							dataType:"json",
							success:function(data){
								alert(data.result)
							}
						});
					},
					"취소":function(){
						$(this).dialog("close");
					}
				}
			});
		});
	
		//메인 버튼을 눌렀을 때 처리
		document.getElementById("mainbtn").addEventListener("click",
				function() {
					location.href = "../";
				});
		//목록 버튼을 눌렀을 때 처리
		document.getElementById("listbtn").addEventListener("click",
				function() {
					location.href = "list?page=${criteria.page}&perPageNum=${criteria.perPageNum}";
				});
		<c:if test = "${user.email == vo.email}">
		//수정 버튼을 눌렀을 때 처리
		document.getElementById("updatebtn").addEventListener("click",
				function() {
					location.href = "update?bno=" + ${vo.bno} +"&page=${criteria.page}&perPageNum=${criteria.perPageNum}";
				});
		</c:if>
	</script>

	
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

		<div id="dialog-confirm" title="정말로 삭제?" style="display: none">
			<p>삭제하시면 복구할 수 없습니다. 그래도 삭제하실 건가요?</p>
		</div>
	<!-- 로그인 한 유저와 작성자가 동일한 경우 -->
	<c:if test="${user.email == vo.email}">
		<script>
			//삭제 버튼을 눌렀을 때 처리
			document.getElementById("deletebtn").addEventListener(
					"click", function(){
						$("#dialog-confirm").dialog({
						      resizable: false,
						      height: "auto",
						      width: 400,
						      modal: true,
						      buttons: {
						        "삭제": function() {
						          $(this).dialog("close");
						          location.href="delete?bno=${vo.bno}" +"&page=${criteria.page}&perPageNum=${criteria.perPageNum}";
						        },
						        "취소": function() {
						          $(this).dialog("close");
						        }
						      }
						    });
						
			});
		</script>

	</c:if>