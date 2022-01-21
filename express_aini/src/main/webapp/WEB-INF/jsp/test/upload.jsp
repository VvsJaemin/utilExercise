<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/jstl.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>파일업로드</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<body>
	<h2>파일 업로드 Test</h2>
	<form class="upload" method="post" enctype="multipart/form-data">
		<input id="file" type="file" name="uploadFile" multiple>
	</form>
	<button id="uploadBtn">Upload</button>

	<script>
		$(document).ready(function() {
			$("#uploadBtn").on("click", function(e) {
				// 파일 업로드 시 특수문자 제한
				var fileval = $("#file").val(); // 파일 이름 값
				var pattern = /[\{\}\/?,;:|*~`!^\+<>@\#$%&\\\=\'\"]/gi;
				var fileName = fileval.split("\\").pop().toLowerCase();
				if (pattern.test(fileName)) {
					alert("파일명에 특수문자가 포함되어 있습니다.");
					return;
				}
				
				function checkExtension(fileName) {
					if (fileval != null) {
						// 확장자명만 분리하여 체크 
						var ext = fileval.split(".").pop().toUpperCase();

						if ($.inArray(ext, [ 'JPG', 'PNG', 'GIF', 'PDF', 'ZIP', 'JPEG', 'BMP' ]) == -1) {
							alert("이미지 및 PDF, ZIP 파일만 업로드 할 수 있습니다.");
							return;
						}
					}
				}
				
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;

				for (var i = 0; i < files.length; i++) {
					if (checkExtension(fileval)) {
						return false;
					}
					formData.append("uploadFile", files[i])
				}

				$.ajax({
					type : 'post',
					url : '/uploadAjaxAction',
					data : formData,
					processData : false,
					contentType : false,
					success : function(data) {
						alert("파일 업로드 성공.");
					},
					error : function(error) {
						alert("파일 업로드에 실패하였습니다.");

					}
				})
			})
		})
	</script>

</body>
</html>
