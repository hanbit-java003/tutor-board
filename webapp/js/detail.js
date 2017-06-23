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
	
	$('#board-reply-send').on('click', function() {
		if ($('#board-reply-writer').val().trim() === '') {
			alert('댓글 작성자를 입력하세요.');
			$('#board-reply-writer').val('');
			$('#board-reply-writer').focus();
			return;
		}
		else if ($('#board-reply').val().trim() === '') {
			alert('댓글을 입력하세요.');
			$('#board-reply').val('');
			$('#board-reply').focus();
			return;
		}
		
		var form = $('<form></form>');
		form.attr('method', 'post');
		form.attr('action', '/reply.do');
		
		$('.board-reply-box').wrap(form);
		$('#board-reply-writer').attr('name', 'writer');
		$('#board-reply').attr('name', 'contents');

		form = $('.board-reply-box').parent('form');
		
		var inputNo = $('<input>');
		inputNo.attr('type', 'hidden');
		inputNo.attr('name', 'no');
		inputNo.val($('#board-no').val());
		
		form.append(inputNo);
		
		form.submit();
	});
});




















