<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/jstl.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>단일 파일 업로드</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<body>
	<h2>단일 파일 업로드 Test</h2>
	<form id="form" class="upload" method="post"
		enctype="multipart/form-data">
		<input id="file" type="file" name="uploadFile">
	</form>
	<button id="uploadBtn" onclick="uploadFile()">Upload</button>

	<script>
		function uploadFile() {
			// 파일 업로드 시 확장자 체크  

			var fileval = $("#file").val(); // 파일 이름 값
			if (fileval != null) {
				// 확장자명만 분리하여 체크 
				var ext = fileval.split(".").pop().toUpperCase();

				if ($.inArray(ext, [ 'JPG', 'PNG', 'GIF', 'PDF', 'ZIP', 'JPEG', 'BMP' ]) == -1) {
					alert("이미지 및 PDF, ZIP 파일만 업로드 할 수 있습니다.");
					return;
				}
			}

			// 파일 업로드 시 특수문자 제한
			
			var pattern = /[\{\}\/?,;:|*~`!^\+<>@\#$%&\\\=\'\"]/gi;
			var fileName = fileval.split("\\").pop().toLowerCase();
			if (pattern.test(fileName)) {
				alert("파일명에 특수문자가 포함되어 있습니다.");
				return;
			}

			$.ajax({
				type : 'post',
				url : '/singleUploadAjax',
				data : new FormData($("#form")[0]),
				processData : false,
				contentType : false,
				success : function(data) {
					alert("파일 업로드 성공.");
				},
				error : function(error) {
					alert("파일 업로드에 실패하였습니다.");

				}
			})
		}
	</script>

</body>
</html>