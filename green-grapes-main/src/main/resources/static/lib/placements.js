
function changeCourseDetails(name) {
	console.log('changeCourseDetails');
	console.log(name);
    $('#course-details-section').children().hide();
    $(name).show();
};