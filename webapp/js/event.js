$(function() {
	var key = {
		ESC: 27,
		SPACE: 32,
		LEFT: 37,
		UP: 38,
		RIGHT: 39,
		DOWN: 40,
		PLUS: 107,
		MINUS: 109
	};
	
	var distance = 10;
	var duration = 20;
	
	var minX = 0;
	var minY = 0;
	var maxX = 0;
	var maxY = 0;
	
	var moving = false;
	var moveTimer;
	
	function move(keyCode, forceMove) {
		if (moving === false && !forceMove) {
			return;
		}
		
		moving = true;
		
		clearTimeout(moveTimer);
		
		var x = $('#box').offset().left;
		var y = $('#box').offset().top;
		
		if (keyCode === key.LEFT) {
			x -= distance;
			x = Math.max(x, minX);
			keyCode = x === minX ? key.RIGHT : key.LEFT;
		}
		else if (keyCode === key.UP) {
			y -= distance;
			y = Math.max(y, minY);
			keyCode = y === minY ? key.DOWN : key.UP;
		}
		else if (keyCode === key.RIGHT) {
			x += distance;
			x = Math.min(x, maxX);
			keyCode = x === maxX ? key.LEFT : key.RIGHT;
		}
		else if (keyCode === key.DOWN) {
			y += distance;
			y = Math.min(y, maxY);
			keyCode = y === maxY ? key.UP : key.DOWN;
		}
		
		$('#box').offset({
			top: y,
			left: x
		});
		
		moveTimer = setTimeout(function() {
			move(keyCode); // 재귀호출 (Recursive Call)
		}, duration);
	}
	
	function resize() {
		maxX = $(window).width() - $('#box').width();
		maxY = $(window).height() - $('#box').height();
	}
	
	function reset() {
		$('#box').offset({
			top: 0,
			left: 0
		});
	}
	
	function changeSpeed(keyCode) {
		if (keyCode === key.PLUS) {
			distance += 5;
			distance = Math.min(distance, 50);
		}
		else if (keyCode === key.MINUS) {
			distance -= 5;
			distance = Math.max(distance, 5);
		}
	}
	
	function stop() {
		moving = false;
		clearTimeout(moveTimer);
	}
	
	$(window).on('resize', function() {
		resize();
	});
	
	$(window).on('keydown', function(event) {
		console.log(event.keyCode);
		
		switch (event.keyCode) {
			case key.ESC: {
				reset();
				break;
			}
			case key.SPACE: {
				stop();
				break;
			}
			case key.LEFT:
			case key.UP:
			case key.RIGHT:
			case key.DOWN: {
				move(event.keyCode, true);
				break;
			}
			case key.PLUS:
			case key.MINUS: {
				changeSpeed(event.keyCode);
				break;
			}
		}
	});
	
	resize();
});