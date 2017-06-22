$(function() {
	$('#board-list').on('click', function() {
		var page = $('#page').val();
		
		location.href = '/list.view?page=' + page;
	});
	
	$('#board-delete').on('click', function() {
		var no = $('#board-no').val();
		
		location.href = '/delete.do?no=' + no;
	});
	
	$('#board-edit').on('click', function() {
		var page = $('#page').val();
		var no = $('#board-no').val();
		
		location.href = '/edit.view?page=' + page + '&no=' + no;
	});
});









