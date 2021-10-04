<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Worldline Admin</title>
	<style >
		table, td, th {
 			border: 1px solid black;
		}
		table {
			width: 100%;
  			border-collapse: collapse;
		}
		#success{
			font: 15px Arial, sans-serif;
			color: green;
    		background:lightgreen;
  			padding: 25px;
		}
		#error{
			font: 15px Arial, sans-serif;
			color: darkred;
    		background:salmon;
  			padding: 25px;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
    		$("#success").fadeIn().delay(1000).fadeOut('slow');
    		$("#error").fadeIn().delay(1000).fadeOut('slow');
    		showHideSIDetailsAtMerchantEnd();
    		$("#enableEmandate").change(function () {
    	        showHideSIDetailsAtMerchantEnd();
    	   });
		});
		function showHideSIDetailsAtMerchantEnd() {
		    if ($("#enableEmandate").val() == "false") {
		    	 $("#admin .enableSIDetailsAtMerchantEnd").hide();
		    	 $("#admin .amountType").hide();
		    	 $("#admin .frequency").hide();
		    	 $("#enableSIDetailsAtMerchantEnd").val('false');
		    	 $("#amountType").val('M');
		    	 $("#frequency").val('ADHO');
		    } else { 
		    	$("#admin .enableSIDetailsAtMerchantEnd").show();
		    	$("#admin .amountType").show();
		    	$("#admin .frequency").show();
		    }
		}
	</script>
</head>

<body>

<c:if test="${not empty response}">
	<div id ="success">
   		${response}
  	</div>
</c:if>
<c:if test="${not empty error}">
	<div id ="error">
   		${error}
  	</div>
</c:if>


	<img style="height:40px; width:230px" src="<c:url value="/images/Worldline-Mint-Horizontal.jpg"/>"/><h2>Worldline Admin</h2>
	<form action="admin" method="post" >
		<table  cellpadding="10" cellspacing="10" id='admin'>
			<tr>
				<th>
					<label for="description">Description</label>
				</th>
				<td>
					Worldline ePayments is India's leading digital payment solutions company. Being a company with more than 45 years of global payment experience, we are present in India for over 20 years and are powering over 550,000 businesses with our tailored payment solution. 
				</td>
			</tr>

			<tr>
				<th>
					<label for="merchantCode">Merchant Code</label>
				</th>
				<td>
					<input type="text" id="merchantCode" name="merchantCode" value="${merchantData.merchantCode}" required=true/>
				</td>
			</tr>

			<tr>
				<th>
					<label for="merchantSchemeCode">Merchant Scheme Code</label>
				</th>
				<td>
					<input type="text" id="merchantSchemeCode" name="merchantSchemeCode" value="test" required=true/>
				</td>
			</tr>

			<tr>
				<th>
					<label for="salt">S.A.L.T</label>
				</th>
				<td>
					<input type="text" id="salt" name="salt" value="3976262521OAOQBJ" required=true/>
				</td>
			</tr>

			<tr>
				<th>
					<label for="currency">Currency</label>
				</th>
				<td>
					<select id="currency" name="currency">
   						<option value="INR" ${merchantData.currency =='INR'? 'selected="true"' : '' }>INR</option>
   						<option value="USD" ${merchantData.currency =='USD'? 'selected="true"' : '' }>USD</option>
   						<%-- <c:forEach var="currency" items="${currency}">
        					<option value="${item.key}" ${item.key == selectedDept ? 'selected="selected"' : ''}>${item.value}</option>
    					</c:forEach> --%>
					</select> 
					<br><br>
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentType">Type of Payment</label>
				</th>
				<td>
					<select id="paymentType" name="typeOfPayment">
   						<option value="TEST"${merchantData.typeOfPayment =='TEST'? 'selected="true"' : '' }>TEST</option>
   						<option value="LIVE"${merchantData.typeOfPayment =='LIVE'? 'selected="true"' : '' }>LIVE</option>
					</select> 
					<br><br>
					For TEST mode amount will be charge 1
				</td>
			</tr>

			<tr>
				<th>
					<label for="primaryColor">Primary Color</label>
				</th>
				<td>
					<input type="text" id="primaryColor" name="primaryColor" value="${merchantData.primaryColor}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="secondaryColor">Secondary Color</label>
				</th>
				<td>
					<input type="text" id="secondaryColor" name="secondaryColor"  value="${merchantData.secondaryColor}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="buttonColor1">Button Color 1</label>
				</th>
				<td>
					<input type="text" id="buttonColor1" name="buttonColor1" value="${merchantData.buttonColor1}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="buttonColor2">Button Color 2</label>
				</th>
				<td>
					<input type="text" id="buttonColor2" name="buttonColor2" value="${merchantData.buttonColor2}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="logoUrl">logo URL</label>
				</th>
				<td>
					<input type="text" id="logoUrl" name="logoURL" value="${merchantData.logoURL}" required=true/>
					<br><br>
					An absolute URL pointing to a logo image of merchant which will show on checkout popup
				</td>
			</tr>

			<tr>
				<th>
					<label for="expresspay">Enable ExpressPay</label>
				</th>
				<td>
					<select id="expresspay" name="enableExpressPay">
   						<option value="false"${merchantData.enableExpressPay ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.enableExpressPay ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					To enable saved payments set its value to yes
				</td>
			</tr>

			<tr>
				<th>
					<label for="separateCardMode">Separate Card Mode</label>
				</th>
				<td>
					<select id="separateCardMode" name="separateCardMode">
   						<option value="false"${merchantData.separateCardMode ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.separateCardMode ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If this feature is enabled checkout shows two separate payment mode(Credit Card and Debit Card)
				</td>
			</tr>

			<tr>
				<th>
					<label for="newWindowFlow">Enable New Window Flow</label>
				</th>
				<td>
					<select id="newWindowFlow" name="enableNewWindowFlow">
   						<option value="false"${merchantData.enableNewWindowFlow ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.enableNewWindowFlow ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If this feature is enabled, then bank page will open in new window
				</td>
			</tr>

			<tr>
				<th>
					<label for="merchantMessage">Merchant Message</label>
				</th>
				<td>
					<input type="text" id="merchantMessage" name="merchantMessage"  value="${merchantData.merchantMessage}"/>
					<br><br>
					Customize message from merchant which will be shown to customer in checkout page
				</td>
			</tr>

			<tr>
				<th>
					<label for="dislaimerMessage">Disclaimer Message</label>
				</th>
				<td>
					<input type="text" id="dislaimerMessage" name="disclaimerMessage" value="${merchantData.disclaimerMessage}"/>
					<br><br>
					Customize disclaimer message from merchant which will be shown to customer in checkout page
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentMode">Payment Mode</label>
				</th>
				<td>
					<select id="paymentMode" name="paymentMode">
   						<option value="all"${merchantData.paymentMode =='all'? 'selected="true"' : '' }>all</option>
   						<option value="cards"${merchantData.paymentMode =='cards'? 'selected="true"' : '' }>cards</option>
   						<option value="netBanking"${merchantData.paymentMode =='netBanking'? 'selected="true"' : '' }>netBanking</option>
   						<option value="UPI"${merchantData.paymentMode =='UPI'? 'selected="true"' : '' }>UPI</option>
   						<option value="imps"${merchantData.paymentMode =='imps'? 'selected="true"' : '' }>imps</option>
   						<option value="wallets"${merchantData.paymentMode =='wallets'? 'selected="true"' : '' }>wallets</option>
   						<option value="cashCards"${merchantData.paymentMode =='cashCards'? 'selected="true"' : '' }>cashCards</option>
   						<option value="NEFTRTGS"${merchantData.paymentMode =='NEFTRTGS'? 'selected="true"' : '' }>NEFTRTGS</option>
   						<option value="emiBanks"${merchantData.paymentMode =='emiBanks'? 'selected="true"' : '' }>emiBanks</option>
					</select>
					<br><br>
					If Bank selection is at Worldline ePayments India Pvt. Ltd. end then select all, if bank selection at Merchant end then pass appropriate mode respective to selected option
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentModeOrder">Payment Mode Order</label>
				</th>
				<td>
					<textarea id="paymentModeOrder" name="paymentModeOrder" required=true style="margin: 0px; width: 576px; height: 36px;">${merchantData.paymentModeOrder}</textarea>
					<br><br>
					Please pass order in this format: cards,netBanking,imps,wallets,cashCards,UPI,MVISA,debitPin,NEFTRTGS,emiBanks.
       				Merchant can define their payment mode order
				</td>
			</tr>

			<tr>
				<th>
					<label for="instrumentDeregistration">Enable Instrument De-Registration</label>
				</th>
				<td>
					<select id="instrumentDeregistration" name="enableInstrumentDeRegistration">
   						<option value="false"${merchantData.enableInstrumentDeRegistration ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.enableInstrumentDeRegistration ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If this feature is enabled, you will have an option to delete saved cards
				</td>
			</tr>

			<tr>
				<th>
					<label for="transactionType">Transaction Type</label>
				</th>
				<td>
					<select id="transactionType" name="transactionType">
   						<option value="SALE">SALE</option>
					</select>
				</td>
			</tr>

			<tr>
				<th>
					<label for="hideSaveInstruments">Hide SavedInstruments</label>
				</th>
				<td>
					<select id="hideSaveInstruments" name="hideSavedInstruments">
   						<option value="false"${merchantData.hideSavedInstruments ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.hideSavedInstruments ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If enabled checkout hides saved payment options even in case of enableExpressPay is enabled
				</td>
			</tr>

			<tr>
				<th>
					<label for="saveInstrument">Save Instrument</label>
				</th>
				<td>
					<select id="saveInstrument" name="saveInstrument">
   						<option value="false"${merchantData.saveInstrument ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.saveInstrument ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					Enable this feature to vault instrument
				</td>
			</tr>

			<tr>
				<th>
					<label for="displayTransactionMsg">Display Transaction Message on Popup</label>
				</th>
				<td>
					<select id="displayTransactionMsg" name="displayTransactionMessageOnPopup">
   						<option value="false"${merchantData.displayTransactionMessageOnPopup ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.displayTransactionMessageOnPopup ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
				</td>
			</tr>

			<tr>
				<th>
					<label for="embeddedPaymentGateway">Embed Payment Gateway On Page</label>
				</th>
				<td>
					<select id="embeddedPaymentGateway" name="embedPaymentGatewayOnPage">
   						<option value="false"${merchantData.embedPaymentGatewayOnPage ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.embedPaymentGatewayOnPage ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
				</td>
			</tr>
			
			<tr>
                <th>
                	<label>Enable SI</label>
                </th>
                <td>
                    <select id="enableEmandate" name="enableEmandate" >
                       <option value="false" ${merchantData.enableEmandate ==false? 'selected="true"' : '' }>Disabled</option>
                       <option value="true" ${merchantData.enableEmandate ==true? 'selected="true"' : '' }>Enabled</option>
                    </select>
                    <br><br>
                    Enable eMandate using this feature
               </td>
             </tr>
             
             <tr>
                <th>
                	<label>Hide SI details</label>
                </th>
                <td>
                    <select id="hideSIDetails" name="hideSIDetails" >
                       <option value="false" ${merchantData.hideSIDetails ==false? 'selected="true"' : '' }>Disabled</option>
                       <option value="true" ${merchantData.hideSIDetails ==true? 'selected="true"' : '' }>Enabled</option>
                    </select>
                    <br><br>
                    Enable this feature to hide SI details from the customer
               </td>
             </tr>
                        
             <tr>
                 <th>
                 	<label>Hide SI Confirmation</label>
                 </th>
                 <td>
                    <select id="hideSIConfirmation" name="hideSIConfirmation" >
                         <option value="false" ${merchantData.hideSIConfirmation ==false? 'selected="true"' : '' }>Disabled</option>
                       	 <option value="true" ${merchantData.hideSIConfirmation ==true? 'selected="true"' : '' }>Enabled</option>
                    </select>
                    <br><br>
                    Enable this feature to hide SI details from the customer
                </td>
            </tr>
            <tr>
                <th>
                	<label>Expand SI Details</label>
                </th>
                <td>
                    <select id="expandSIDetails" name="expandSIDetails" >
                         <option value="false" ${merchantData.expandSIDetails ==false? 'selected="true"' : '' }>Disable</option>
                         <option value="true" ${merchantData.expandSIDetails ==true? 'selected="true"' : '' }>Enable</option>
                    </select>
                    <br><br>
                    Enable this feature to show eMandate/eNACH/eSign details in expanded mode by default
                </td>
           </tr>
           <tr>
                <th>
                	<label>Enable Debit Day</label>
                </th>
                <td>
                    <select id="enableDebitDay" name="enableDebitDay" >
                         <option value="false"  ${merchantData.enableDebitDay ==false? 'selected="true"' : '' }>Disable</option>
                         <option value="true"  ${merchantData.enableDebitDay ==true? 'selected="true"' : '' }>Enable</option>
                    </select>
                    <br><br>
                    Enable this feature to accept debit day value eMandate/eNACH/eSign registration
                </td>
           </tr>
           <tr>
                <th>
               		<label>Show SI Response Msg</label>
               	</th>
                <td>
                    <select id="showSIResponseMsg" name="showSIResponseMsg" >
                         <option value="false" ${merchantData.showSIResponseMsg ==false? 'selected="true"' : '' }>Disable</option>
                         <option value="true" ${merchantData.showSIResponseMsg ==true? 'selected="true"' : '' }>Enable</option>
                    </select>
                    <br><br>
                    Enable this feature to show eMandate/eNACH/eSign registrations details also in final checkout response
                </td>
           </tr>
           <tr>
                <th>
                	<label>Show SI Confirmation</label>
                </th>
                <td>
                    <select id="showSIConfirmation" name="showSIConfirmation" >
                         <option value="false" ${merchantData.showSIConfirmation ==false? 'selected="true"' : '' }>Disable</option>
                         <option value="true" ${merchantData.showSIConfirmation ==true? 'selected="true"' : '' }>Enable</option>
                    </select>
                    <br><br>
                    Enable this feature to show confirmation screen for registration
               </td>
           </tr>
           <tr>
               <th>
               		<label>Enable Txn For NonSI Cards</label>
               </th>
               <td>
                   <select id="enableTxnForNonSICards" name="enableTxnForNonSICards" >
                        <option value="false" ${merchantData.enableTxnForNonSICards ==false? 'selected="true"' : '' }>Disable</option>
                        <option value="true" ${merchantData.enableTxnForNonSICards ==true? 'selected="true"' : '' }>Enable</option>
                   </select>
                   <br><br>
                   Enable this feature to proceed with a normal transaction with same card details
               </td>
           </tr>
           <tr>
              <th>
              	 	<label>Show All Modes with SI</label>
              </th>
              <td>
                    <select id="showAllModesWithSI" name="showAllModesWithSI" >
                         <option value="false" ${merchantData.showAllModesWithSI ==false? 'selected="true"' : '' }>Disable</option>
                         <option value="true" ${merchantData.showAllModesWithSI ==true? 'selected="true"' : '' }>Enable</option>
                    </select>
                    <br><br>
                    Enable this feature to show all modes with SI
              </td>
           </tr>
           
           <tr class="enableSIDetailsAtMerchantEnd" >
                <th>
                	<label>Enable SI Details At Merchant End</label>
                </th>
                <td>
                     <select class="enableSIDetailsAtMerchantEnd" id="enableSIDetailsAtMerchantEnd" name="enableSIDetailsAtMerchantEnd" >
                          <option value="false" ${merchantData.enableSIDetailsAtMerchantEnd ==false? 'selected="true"' : '' }>Disable</option>
                          <option value="true" ${merchantData.enableSIDetailsAtMerchantEnd ==true? 'selected="true"' : '' }>Enable</option>
                     </select>
                </td>
           </tr>
           
           <tr class="amountType" >
                <th>
                	<label>Amount Type</label>
                </th>
                <td>
                     <select id="amountType" name="amountType" >
                          <option value="M" ${merchantData.amountType =='Variable'? 'selected="true"' : '' }>Variable</option>
                          <option value="F" ${merchantData.amountType =='Fixed'? 'selected="true"' : '' }>Fixed</option>
                     </select>
                </td>
           </tr>
           
            <tr class="frequency" >
                <th>
                	<label>Frequency</label>
                </th>
                <td>
                     <select id="frequency" name="frequency" >
                          <option value="ADHO" ${merchantData.frequency =='ADHO'? 'selected="true"' : '' }>As and when presented</option>
                          <option value="DAIL" ${merchantData.frequency =='DAIL'? 'selected="true"' : '' }>Daily</option>
                          <option value="WEEK" ${merchantData.frequency =='WEEK'? 'selected="true"' : '' }>Weekly</option>
                          <option value="MNTH" ${merchantData.frequency =='MNTH'? 'selected="true"' : '' }>Monthly</option>
                          <option value="QURT" ${merchantData.frequency =='QURT'? 'selected="true"' : '' }>Quarterly</option>
                          <option value="MIAN" ${merchantData.frequency =='MIAN'? 'selected="true"' : '' }>Semi annually</option>
                          <option value="YEAR" ${merchantData.frequency =='YEAR'? 'selected="true"' : '' }>Yearly</option>
                          <option value="BIMN" ${merchantData.frequency =='BIMN'? 'selected="true"' : '' }>Bi- monthly</option>
                     </select>
                </td>
           </tr>
		</table>
		<div><input type="submit" value="Submit"></div>
	</form>

</body>
</html>




