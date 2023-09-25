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
});




const gotoCourseDetailPage = () => {
	console.log('Hi Course')
}

