var qu={q:null ,b:0}
$(function() {
	switch (menu) {
	case 'home':
		$('#home').addClass('active');
		break;
	case 'allHotels':
		$('#allHotels').addClass('active');
		break;
	case 'about':
		$('#about').addClass('active');
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;

	default:
		$('#contact').addClass('active');
		break;

	}
});

$('.query').on('keyup',function(){

	qu.q=this.value;
    console.log("hello");
    if(this.value.length == 0){
    	qu.q=null;
    }

    var resultObj = $('#hotel-list');

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/assignment/search_hotels',
            data: qu,
            searchQuery:this.value,
            resultObj: this.resultObj,
            dataType:'html',
            success: function (html) {
            	resultObj.html('');
            	$('#hotel-list').append(html);
            }});

});

$('.city-search').on('click',function(){

	
	qu.b=this.id;
	$('.city-search').css("background-color", "");
	$("#"+this.id+"").css("background-color", "#343a40");
    var resultObj = $('#hotel-list');

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/assignment/search_hotels',
            data: qu,
            searchQuery:this.value,
            resultObj: this.resultObj,
            dataType:'html',
            success: function (html) {
            	resultObj.html('');
            	$('#hotel-list').append(html);
            }});

});
	/*
	
	switch (menuCity) {
	case 'home':
		$('#home').addClass('active');
		break;
	case 'allHotels':
		$('#allHotels').addClass('active');
		break;
	case 'about':
		$('#about').addClass('active');
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;

	default:
		$('#contact').addClass('active');
		break;

	}*/

/*	
	$("#search").on("keyup", function() {
		   var value = $(this).val();

		    $("#table tr").each(function(index) {
		        if ((index != 0) && (index != 1)) {

		            $row = $(this);

		            var id = $row.find("td").text();
		            var idsrig = String(id);
		           
		            if (!idsrig.includes(value)) {
		              //console.log("index :- "+index+" value=  "+value+" id= "+id+" | "+idsrig.indexOf(value)+" | "+idsrig);
		                $(this).hide();
		            }
		            else {
		                $(this).show();
		            }
		        }
		    })
		});*/
