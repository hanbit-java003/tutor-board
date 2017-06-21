$(function() {
	$('#board-new').on('click', function() {
		location.href = '/new.view';
	});
	
	$('#board-list tbody tr').on('click', function() {
		var no = $(this).attr("no");
		
		location.href = '/detail.view?no=' + no;
	});
});