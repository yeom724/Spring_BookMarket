function addToCart(action){
	document.addForm.action = action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가되었습니다.")	
}

function removeFromCart(action){
	console.log("삭제시작")
	document.removeForm.action = action;
	document.removeForm.submit();
	window.location.reload();
	
}