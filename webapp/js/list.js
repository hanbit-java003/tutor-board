$(function() {
	$('#board-new').on('click', function() {
		location.href = '/new.view';
	});
	
	$('#board-list tbody tr').on('click', function() {
		var page = $('#page').val();
		var no = $(this).attr('no');
		
		location.href = '/detail.view?page=' + page + '&no=' + no;
	});
	
	$('.board-page').on('click', function(event) {
		event.preventDefault();
		
		if ($(this).parent('li').hasClass('disabled')) {
			return;
		}
		
		var page = $(this).attr('page');
		
		location.href = '/list.view?page=' + page;
	});
});