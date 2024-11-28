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

function deleteConfirm(id){
	if (confirm("삭제합니다!!")==true) location.href = "/spring_BookMarket/books/delete?id="+id;
	else return;
}