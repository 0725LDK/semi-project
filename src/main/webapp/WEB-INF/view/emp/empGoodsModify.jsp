<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>934마켓 상품 수정 | 전통주의 모든것, 934마켓</title>

	<!-- CSS link -->
	<jsp:include page="/inc/empHeadScript.jsp"></jsp:include>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			
			//상품 수정시 유효성 검사
			$('#goodsModifyFormBtn').click(function()
					{
						if($('#categoryName').val() == '')
						{
							alert('주종을 입력하세요');
							$('#categoryName').focus();
							return;
						}
						if($('#goodsName').val() == '')
						{
							alert('상품 이름을 입력하세요');
							$('#goodsName').focus();
							return;
						}
						if($('#goodsPrice').val() == '')
						{
							alert('상품 가격을 입력하세요');
							$('#goodsPrice').focus();
							return;
						}
						if($('#goodsContent').val() != $('#pwCheck').val())
						{
							alert('상품설명을 입력하세요');
							$('#goodsContent').focus();
							return;
						}
						if($('#goodsAlcohol').val() == '')
						{
							alert('도수를 입력하세요');
							$('#goodsAlcohol').focus();
							return;
						}
						if($('#goodsLiter').val() == '')
						{
							alert('용량을 입력하세요');
							$('#goodsLiter').focus();
							return;
						}
						if($('#empId').val() == '')
						{
							alert('직원ID를 입력하세요');
							$('#empId').focus();
							return;
						}
						if($('#hit').val() == '')
						{
							alert('hit 값을 입력하세요');
							$('#hit').focus();
							return;
						}
						$('#goodsModifyForm').submit();
					});
			
			$('#CancleBtn').click(function(){
				location.href = '${pageContext.request.contextPath}/emp/empGoodsList';
			});
		});
	</script>
</head>
<body>
	<div class="container-scroller">
		
	<!-- partial:partials/main_navbar.html -->
	<div>
		<jsp:include page="/inc/empMainNavVar.jsp"></jsp:include>]
	</div>
	
	<!-- partial -->
	<div class="container-fluid page-body-wrapper">
		
		<!-- partial:partials/_sidebar.html -->
		<div>
			<jsp:include page="/inc/empSideBar.jsp"></jsp:include>
		</div>
		<div class="main-panel">
			<div class="content-wrapper">
				<div class="row">
					<div class="col-12 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">삼품 수정</h4>
									<form class="forms-sample" id="goodsModifyForm" action="${pageContext.request.contextPath}/emp/empGoodsModify" method="post" enctype="multipart/form-data">
										<table class="table table-striped table-borderless" style="width:100%">
											<tr>
												<td rowspan="12">
													<img src="${pageContext.request.contextPath}/upload/${map.filename}" width="200" height="200">
												</td>
												<th>상품 번호 : </th>
												<td>
													<input class="form-control" type="number" name="goodsCode" value="${map.goodsCode}" readonly="readonly">
												</td>
											</tr>
											<tr>
												<th>상품 카테고리 : </th>
												<td>
													<select class="form-control" name="goodsCategory">
														<option value="${map.goodsCategory}">${map.categoryName}</option>
														<option value="1">탁주</option>
														<option value="2">청주</option>
														<option value="3">과실주</option>
														<option value="4">증류주</option>		
														<option value="5">이벤트1</option>	
														<option value="6">이벤트2</option>	
														<option value="7">이벤트3</option>	
													</select>
												</td>
											</tr>
											<tr>
												<th>상품 주종 : </th>
												<td>
													<input class="form-control" id="categoryName" type="text" name="categoryName" value="${map.categoryName}">
												</td>
											</tr>
											<tr>
												<th>상품 이름 : </th>
												<td>
													<input class="form-control" id="goodsName" type="text" name="goodsName" value="${map.goodsName}">
												</td>
											</tr>
											<tr>
												<th>상품 가격 : </th>
												<td>
													<input class="form-control" id="goodsPrice" type="number" name="goodsPrice" value="${map.goodsPrice}">
												</td>
											</tr>
											<tr>
												<th>상품 설명 : </th>
												<td>		
													<textarea class="form-control" id="goodsContent" name="goodsContent"  rows="10" cols="50">${map.goodsContent}</textarea>
												</td>
											</tr>
											<tr>
												<th>상품 도수(%) : </th>
												<td>
													<input class="form-control" id="goodsAlcohol" type="number" name="goodsAlcohol" value="${map.goodsAlcohol}">
												</td>
											</tr>			
											<tr>
												<th>상품 용량(mL) : </th>
												<td>
													<input class="form-control" id="goodsLiter" type="number" name="goodsLiter" value="${map.goodsLiter}">
												</td>
											</tr>			
											<tr>
												<th>상품 재고 : </th>
												<td>
													<select class="form-control" name="soldout">
														<option value="${map.soldout}">품절/재고</option>
														<option value="Y">품절</option>
														<option value="N">재고 있음</option>
													</select>
												</td>
											</tr>
											<tr>
												<th>직원 아이디 : </th>
												<td>
													<input class="form-control" id="empId" type="text" name="empId" value="${map.empId}">
												</td>
											</tr>
											<tr>
												<th>베스트 상품 : </th>
												<td>
													<input class="form-control" id="hit" type="number" name="hit" value="${map.hit}">
												</td>
											</tr>
											<tr>
												<th>상품 이미지 변경 : </th>
												<td>
													<input class="form-control" type="file" name="goodsImg">
												</td>
											</tr>
										</table><br>
										<div align="center">
											<button id="goodsModifyFormBtn" type="button" class="btn btn-primary mr-2">상품수정</button>
											<button id="CancleBtn" type="button" class="btn btn-light" >취소</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
					<!-- partial:partials/_footer.html -->
				<div>
					<jsp:include page="/inc/empCopyright.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
	
	<!-- CSS script -->
	<div>
		<jsp:include page="/inc/empFooterScript.jsp"></jsp:include>
	</div>
	
</body>
</html>