let cartData;

function getCartItems() {
  let options = {
    method: "GET",
    headers: {
      "Content-type": "application/json",
    },
  };

  fetch('http://localhost:8095/product/cart', options)
    .then((response) => response.json())
    .then((dataArray) => {
      cartData = dataArray; // Store cart data in the variable
      generateTableRows(cartData);
    })
    .catch((error) => console.error("Error:", error));
}

getCartItems();

function generateTableRows(data) {
  const tbody = document.querySelector('tbody');
  tbody.innerHTML = ''; // Clear existing rows

  data.forEach((item, index) => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${item.product.productName}</td>
      <td>${item.product.productPrice}</td>
      <td>
        <span class="quantity">${item.cartItems.quantity}</span>
        <span class="icon" data-index="${index}"><i class="fas fa-plus"></i></span>
        <span class="icon" data-index="${index}"><i class="fas fa-minus"></i></span>
      </td>
      <td>${item.cartItems.quantity * item.product.productPrice}</td>
      <td>
        <button class="add-button" data-index="${item.product.productId}">Add</button>
        <button class="remove-button" data-index="${item.cartItems.quantity}">Remove</button>
      </td>`; 

    tbody.appendChild(row);
  });

  const plusIcons = document.querySelectorAll('.fa-plus');
  const minusIcons = document.querySelectorAll('.fa-minus');
  const addButtons = document.querySelectorAll('.add-button');
  const removeButtons = document.querySelectorAll('.remove-button');

  plusIcons.forEach((plusIcon) => {
    plusIcon.addEventListener('click', (event) => {
      const index = event.target.parentElement.getAttribute('data-index');
      handleAddButtonClick(index);
    });
  });

  minusIcons.forEach((minusIcon) => {
    minusIcon.addEventListener('click', (event) => {
      const index = event.target.parentElement.getAttribute('data-index');
      handleSubtractButtonClick(index);
    });
  });

  addButtons.forEach((addButton) => {
    addButton.addEventListener('click', (event) => {
      const index = event.target.getAttribute('data-index');
      handleAddToCartButtonClick(index);
    });
  });

  removeButtons.forEach((removeButton) => {
    removeButton.addEventListener('click', (event) => {
      const index = event.target.getAttribute('data-index');
      handleRemoveFromCartButtonClick(index);
    });
  });
}

function handleAddButtonClick(index) {
  // Increase quantity and update the table
  cartData[index].cartItems.quantity += 1;
  generateTableRows(cartData); // Update the table with the modified data
}

function handleSubtractButtonClick(index) {
  // Decrease quantity and update the table
  if (cartData[index].cartItems.quantity > 1) {
    cartData[index].cartItems.quantity -= 1;
  }
  generateTableRows(cartData); // Update the table with the modified data
}

function handleAddToCartButtonClick(index) {
  // Make an API call to add the item to the cart in the database
  const itemId = cartData[index].product.productId;
  const quantity = cartData[index].cartItems.quantity;
  console.log(quantity);
  const options = {
    method: "POST",
    headers: {
      "Content-type": "application/json",
    },
  };

  fetch(`http://localhost:8095/product/addinCart/${itemId}/${quantity}`, options)
    .then(() => {
      // Update the cart data by making a new GET request
      getCartItems();
    })
    .catch((error) => console.error("Error:", error));
}

function handleRemoveFromCartButtonClick(index) {
  // Make an API call to remove the item from the cart in the database
  const itemId = cartData[index].product.productId;
  const options = {
    method: "POST",
    headers: {
      "Content-type": "application/json",
    },
  };

  fetch(`http://localhost:8095/product/deleteFromCart/${itemId}`, options)
    .then(() => {
      // Update the cart data by making a new GET request
      getCartItems();
    })
    .catch((error) => console.error("Error:", error));
}
