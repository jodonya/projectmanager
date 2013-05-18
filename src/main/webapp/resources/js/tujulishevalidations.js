/*******************************************************************************
 * Tujulishe
 * 
 ******************************************************************************/
$(function(){
	$('.registerwarning').hide();
	
	/****
	 *The Sign Up Button
	 * 
	 **/
	$('.signupbuttontujulishe').click(function(e) {
		
		$('.registerwarning').hide();
		$('.matchingvalues').hide();
		
		$('.textfieldtujulishe').each(function() {
			
			if (!$(this).val()) {
				/** $(this).parents('.registerwarning').show(); * */
				/** $('.registerwarning').show(); * */
				$(this).next('.registerwarning').show();
				$(this).next().next('.registerwarning').show();
				e.preventDefault();
			}
		});
	});
	
	
	
$('.loginButton').click(function(e) {
		
	$('.registerwarninglogin').hide();
	$('.providedemail').hide();
		
		
		$('.textfieldlogin').each(function() {
			
			if (!$(this).val()) {
				/** $(this).parents('.registerwarning').show(); * */
				/** $('.registerwarning').show(); * */
				$(this).next('.registerwarninglogin').show();
				$(this).next().next('.registerwarninglogin').show();
				e.preventDefault();
			}
		});
	});
	
});



