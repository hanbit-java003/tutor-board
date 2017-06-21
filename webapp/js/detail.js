$(function() {
	$('#board-list').on('click', function() {
		location.href = '/list.view';
	});
	
	$('#board-delete').on('click', function() {
		var no = $('#board-no').val();
		
		location.href = '/delete.do?no=' + no;
	});
});