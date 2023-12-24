jQuery(function($){
    $('.tabular.menu .item').tab({history:false});
   /* $('.course_content_table .accordion').accordion({
	    selector: {
	      trigger: '.title .icon'
	    }
	  });*/
	  
	  
	  
	let coll = document.getElementsByClassName("collapsible");

	for (let i = 0; i < coll.length; i++) {
	  coll[i].addEventListener("click", function() {
	    this.classList.toggle("collapsibleactive");
	    var content = this.nextElementSibling;
	    if (content.style.maxHeight){
	      content.style.maxHeight = null;
	    } else {
	      content.style.maxHeight = "fit-content";//content.scrollHeight*2 + "px";
	    } 
	  });
	}
	
	function rotate() {
	let lastChild = $('.slider div:last-child').clone();
	$('.slider div').removeClass('firstSlide');
	$('.slider div:last-child').remove();
	$('.slider').prepend(lastChild);
	$(lastChild).addClass('firstSlide')
}

window.setInterval(function(){
	console.log('interval')
},4000);
});

function rotate() {
	let lastChild = $('.slider div:last-child').clone();
	$('.slider div').removeClass('firstSlide');
	$('.slider div:last-child').remove();
	$('.slider').prepend(lastChild);
	$(lastChild).addClass('firstSlide')
}

window.setInterval(function(){
	console.log('interval')
},4000);


const gotoCourseDetailPage = () => {
	console.log('Hi Course')
}

