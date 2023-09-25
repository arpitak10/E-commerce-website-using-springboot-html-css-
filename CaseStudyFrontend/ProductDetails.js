function getProduct() {
  let options = {
    method: "GET",
    headers: {
      "Content-type": "application/json",
    },
  };
  
  fetch('http://localhost:8095/product/', options)
    .then((response) => response.json())
    .then((dataArray) => generateTableRows(dataArray))
    .catch((error) => console.error("Error:", error));
}
getProduct();
  // Your code here, including the fetch and generateTableRows
function generateTableRows(data) {
  const tbody = document.querySelector('tbody');
  tbody.innerHTML = ''; // Clear existing rows

  data.forEach((item, index) => {
      const row = document.createElement('tr');
      row.innerHTML = `
          <td>${item.productId}</td>
          <td>${item.productName}</td>
          <td>${item.productPrice}</td>
          <td>${item.productCategory}</td>
          <td>
          
              <button class="add-to-cart" >Add to cart</button>
              
          </td>
      `;

      tbody.appendChild(row);
  });
  addEventListeners();
}
function handleData(data) {
  console.log(data);
}
function handleAddToCartButtonClick(event) {
  console.log('Add to cart button clicked');
  const row = event.target.closest('tr');
  const button = event.target;
  
  if (row) {
    if (event.target.classList.contains('add-to-cart')) {
      
      const addbutton = row.querySelector('td:first-child').textContent;
      button.textContent = "Added";
     
      console.log('Add button clicked in row with ID:', addbutton); 
      addProduct(addbutton);
      
      
     
    }
  }
}
// Function to handle the "Delete" button click

function addEventListeners() {
    const addToCart = document.querySelectorAll('.add-to-cart');
    addToCart.forEach(button => {
      button.addEventListener('click', handleAddToCartButtonClick);
    });
    
}

function addProduct(productId){
  console.log(productId);
  let options = {

      method: "POST",
      headers: {
          "Content-type": "application/json"
      },
      body: JSON.stringify({
          cartId:8,
          productId:productId,
          quantity:1
      }),
  }
  fetch('http://localhost:8095/product/cartPage',options)
  .then((response) => response.json())
  .then((json) => console.log(json));
}



/*
const apiUrl = 'http://localhost:8020/product/';

//generating rows
function generateTableRows(data) {
  const tbody = document.querySelector('tbody');
  tbody.innerHTML = ''; // Clear existing rows

  data.forEach((item, index) => {
      const row = document.createElement('tr');
      row.innerHTML = `
          <td>${item.productId}</td>
          <td>${item.productName}</td>
          <td>${item.productPrice}</td>
          <td>${item.productCategory}</td>
          <td>
              <button class="add-button">Add</button>
              <button class="delete-button">Delete</button>
          </td>
      `;

      tbody.appendChild(row);
  });
  addEventListeners();
}

fetch(apiUrl)
  .then(response => {
    if (response.status === 200) {
      return response.json();
    } else {
      throw new Error('Failed to fetch data');
    }
  })
  .then(dataArray => {
    generateTableRows(dataArray);
    
  })
  .catch(error => {
    console.error(error);
  });
  
function handleData(data) {
  console.log(data);
}
function handleAddButtonClick(event) {
  console.log('Add button clicked');
  const row = event.target.closest('tr');
  if (row) {
    // Find the button's class to determine which button was clicked
    if (event.target.classList.contains('add-button')) {
      const deleteButtonWithId = row.querySelector('td:first-child').textContent;
      console.log('Add button clicked in row with ID:', deleteButtonWithId);
    }
  }
}
// Function to handle the "Delete" button click
function handleDeleteButtonClick(event) {
  //delete button click functionality
  console.log('Delete button clicked');
  const row = event.target.closest('tr');
  if (row) {
    // Find the button's class to determine which button was clicked
    if (event.target.classList.contains('delete-button')) {
      const addButtonWithId = row.querySelector('td:first-child').textContent; 
      console.log('Delete button clicked in row with ID:', addButtonWithId);
    }
  }
}
function addEventListeners() {
    const addButtonElements = document.querySelectorAll('.add-button');
    const deleteButtonElements = document.querySelectorAll('.delete-button');
    const addToCart = 
    addButtonElements.forEach(button => {
      button.addEventListener('click', handleAddButtonClick);
    });
    deleteButtonElements.forEach(button => {
      button.addEventListener('click', handleDeleteButtonClick);
    });
}
*/

