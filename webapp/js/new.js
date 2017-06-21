$(function() {
	$('#board-cancel').on('click', function() {
		location.href = '/list.view';
	});
	
	$('#board-reset').on('click', function() {
		$('#board-form')[0].reset();
	});
	
	$('#board-send').on('click', function() {
		// Form Validation (폼 검증)
		if ($('#board-title').val().trim() === '') {
			alert('제목을 입력하세요.');
			$('#board-title').val('');
			$('#board-title').focus();
			return;
		}
		else if ($('#board-writer').val().trim() === '') {
			alert('작성자를 입력하세요.');
			$('#board-writer').val('');
			$('#board-writer').focus();
			return;
		}
		else if ($('#board-contents').val().trim() === '') {
			alert('내용을 입력하세요.');
			$('#board-contents').val('');
			$('#board-contents').focus();
			return;
		}
		
		$('#board-form').submit();
	});
});