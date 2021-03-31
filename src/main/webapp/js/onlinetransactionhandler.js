$(document).ready(function() {

	function handleResponse(res) {
			if (typeof res != 'undefined' && typeof res.paymentMethod != 'undefined' && 
				typeof res.paymentMethod.paymentTransaction != 'undefined' && 
				typeof res.paymentMethod.paymentTransaction.statusCode != 'undefined' && res.paymentMethod.paymentTransaction.statusCode == '0300') {
						// success block
			} else if (typeof res != 'undefined' && typeof res.paymentMethod != 'undefined' && 
				typeof res.paymentMethod.paymentTransaction != 'undefined' && 
				typeof res.paymentMethod.paymentTransaction.statusCode != 'undefined' && res.paymentMethod.paymentTransaction.statusCode == '0398') {
							// initiated block
			} else {
					// error block
			}   
		};

	$(document).off('click', '#btnSubmit').on('click', '#btnSubmit', function(e){
		e.preventDefault();
		var str = $("#form").serialize();
		$.ajax({
		type: 'POST',
		cache: false,
		data: str,
		url: "/payment/onlineTransactionHandler",                                      
		success: function (response)
			{	
				console.log(response);
				var configJson = response;
				configJson.consumerData.responseHandler = handleResponse;
				$.pnCheckout(configJson);
				if(configJson.features.enableNewWindowFlow){
					pnCheckoutShared.openNewWindow();
				}

			},
		error: function (response)
			{
				alert("Oops!An Error seems to have encountered.");
			}
		});
	});
});
