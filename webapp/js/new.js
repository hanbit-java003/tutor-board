$(function() {
	$('#board-cancel').on('click', function() {
		location.href = '/list.view';
	});
	
	$('#board-reset').on('click', function() {
		$('#board-form')[0].reset();
	});
});