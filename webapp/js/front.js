$(function() {
	$('#menu-close').on('click', function() {
		closeMenu();
	});
	
	$('#menu-open').on('click', function() {
		openMenu();
	});
	
	function closeMenu() {
		var menuWidth = $('#menu').width();
		
		$('#menu').animate({
			left: -menuWidth,
			opacity: 0
		}, {
			duration: 400
		});
	}
	
	function openMenu() {
		$('#menu').animate({
			left: 0,
			opacity: 1
		}, {
			duration: 400
		});
	}
});