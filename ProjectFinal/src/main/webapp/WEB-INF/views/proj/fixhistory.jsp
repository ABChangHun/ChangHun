<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://uicdn.toast.com/grid/latest/tui-grid.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://uicdn.toast.com/grid/latest/tui-grid.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../header.jsp" %>
<body>
<div class="wrapper">
<div class="content" style="width: 1400px;">
<div id="grid" style="width: 890px;">
<button onclick="selectFixhistory()">조회</button>
</div>
</div>
</div>
	<button onclick="location.href='./fbs.do'">FBS 이동</button>
	<button onclick="location.href='./wbs.do'">WBS 이동</button>
	<button onclick="location.href='./moveFixhistory.do'">작성이력 이동</button>
</body>
<script type="text/javascript">
var Grid = tui.Grid;
var el;
var options;
	const grid = new Grid({
			  el: document.getElementById('grid'),
			  columns: [
				 	 {
					    header: '작성 내용',
					    name: 'fixContent',
					  },
					  {
						    header: '작성자',
						    name: 'fixName',
						},
			]
		});
	var arrData = function (){
		
		$.ajax({
			url : "./selectFixhistory.do",
			method : "POST",
			success : function(result){
				console.log('안뇽하세용!!');
				grid.resetData(result);
			}
		});
}
	function selectFixhistory(){
		arrData();
	}
	
</script>

</html>