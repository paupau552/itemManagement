//from crud表示
$('#form-select').show();
$('#form-insert').hide();
$('#form-update').hide();
$('#form-delete').hide();

//selectBOX crud表示
$('#crudFunc').change(function(){
	var key = $('option:selected').val();
	
	console.log(key);
	
	switch(key){
	case 'insert':
		$('#form-select').hide();
		$('#form-insert').show();
		$('#form-update').hide();
		$('#form-delete').hide();
	    break;
	case 'update':
		$('#form-select').hide();
		$('#form-insert').hide();
		$('#form-update').show();
		$('#form-delete').hide();
	    break;
	case 'delete':
		$('#form-select').hide();
		$('#form-insert').hide();
		$('#form-update').hide();
		$('#form-delete').show();
	    break;
	default:
		$('#form-select').show();
		$('#form-insert').hide();
		$('#form-update').hide();
		$('#form-delete').hide();
	    break;
	}
	
})