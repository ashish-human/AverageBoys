function rotate() {
	console.log('rotate');
	let lastChild = $('.slider div:last-child').clone();
	$('.slider div').removeClass('firstSlide');
	$('.slider div:last-child').remove();
	$('.slider').prepend(lastChild);
	$(lastChild).addClass('firstSlide')
}

/*window.setInterval(function(){
	console.log('interval');
	rotate();
},4000);*/

$('.card-text').each(function() {
	$(this).html($(this).html().replace(/(\+)/g, '<span style="color: #bb60d5;">+</span>'));
});

$( window ).on( "load", function() {
	$('#loading-section').hide();
}
)

