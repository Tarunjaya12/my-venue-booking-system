<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/payment.css"/>
</head>
<body>
<div class="container">
 		<div class="card1">
         	<h1>Advance Payment</h1> 
         	<h2>Amount:</h2>
         	<h2>${advanceAmount}</h2>
        </div>
        <div class="card">
          <form action="makePayment">
            <h1>CheckOut</h1>
            <h2>Payment Information</h2>
            <p>Cardholder Name</p>
            <input type="text" class="inputbox" name="name" required />
            <p>Card Number</p>
            <input type="number" class="inputbox" name="card_number" id="card_number" required />
			<p>Card Type</p>
            <select class="inputbox" name="card_type" id="card_type" required>
              <option value="">--Select a Card Type--</option>
              <option value="Visa">Visa</option>
              <option value="RuPay">RuPay</option>
              <option value="MasterCard">MasterCard</option>
            </select>
			<div class="expcvv">
				<p class="expcvv_text">Expiry</p>
            	<input type="date" class="inputbox" name="exp_date" id="exp_date" required />
				<p class="expcvv_text2">CVV</p>
            	<input type="password" class="inputbox" name="cvv" id="cvv" required />
        	</div>
            <p></p>
            <button type="submit" class="button">Make Payment</button>
          </form>
    </div>
</div>
  

</body>
</html>