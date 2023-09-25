
let data;
function getAmount() {
    let options = {
      method: "GET",
      headers: {
        "Content-type": "application/json",
      },
    };
    
    fetch('http://localhost:8095/product/totalamount', options)
      .then((response) => response.json())
      .then((data) => printvalue(data))
      .catch((error) => console.error("Error:", error));
}
function printvalue(data){
    const element = document.querySelector(".amount");
    element.textContent=`Your total amount is: ${data}`;
   
}
getAmount();
function myFunction() {
    let cartId = 8;
    let options = {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
      };
      
      fetch(`http://localhost:8095/product/submit/${cartId}`, options)
        .then((response) => response.json())
        .then((data) => printvalue(data))
        .catch((error) => console.error("Error:", error));
   
}
document.addEventListener('DOMContentLoaded', function () {
    const submitButton = document.getElementById('submitButton');
    submitButton.addEventListener('click', myFunction);
});