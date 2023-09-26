// top_menu
$(document).ready(function() {	
	$('#top_nav li').hover(function() {
		$('ul', this).slideDown(200);
	}, function() {
		$('ul', this).slideUp(100);
	});
	$("#allmn_btn").click(function() {
		$("#allmn_view_wrap").slideToggle(150);
		$(this).toggleClass('active');
	});

	$(document).mouseup(function(e) {
		var sch_btn = $("#allmn_btn");
		var sch_area = $("#allmn_view_wrap");
		if (!sch_btn.is(e.target) && sch_btn.has(e.target).length == 0 && !sch_area.is(e.target) && sch_area.has(e.target).length == 0){
			$('#allmn_view_wrap').slideUp(120);	
			$('#allmn_btn').removeClass('active');
		}	
	});		
	// 스크롤시 메뉴 상단 고정
	$(window).on("scroll",function(){
		if($(window).scrollTop() > 90) { 
			$('#top_nav_wrap').addClass("fixed");
		} else{
			$('#top_nav_wrap').removeClass("fixed");
 		}
		return false;
	});
});