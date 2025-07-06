# 🛒 Fawry Internship E-Commerce System (Java)

This project was developed as part of the **Fawry Rise Journey Internship Challenge**.  
It demonstrates object-oriented design and console-based order checkout with shipping logic.

## 📌 Features

- Define products with name, price, quantity
- Products may:
  - Expire (e.g., Cheese, Biscuits)
  - Require shipping (with weight)
  - Be non-shippable (e.g., Mobile Scratch Cards)
- Customer cart functionality
  - Add products (ensures no expired/out-of-stock items)
  - Checkout:
    - Calculates subtotal, shipping, total
    - Updates customer balance
    - Validates edge cases (empty cart, low balance, expired items)
- Shipping Service:
  - Accepts a list of shippable items via interface (`Shippable`)
  - Prints total weight and grouped shipment details

## ✅ Console Output Example

2x Cheese 400g

1x Biscuits 700g

Total package weight 1.1kg

**Checkout receipt**

  -2x Cheese 200

  -1x Biscuits 150
  
-------------------------
Subtotal 350

Shipping 30

Amount 380


## 🧠 Technologies

- Java 21 (OpenJDK)
- Object-Oriented Programming
- Java Streams & Lambdas (optional use)
- CLI-based output

## 🛠 How to Run

```bash
javac *.java
java Main
```
-------------------------
👤 Author

Yossef Essam

<a href="https://github.com/YossefEFM">GitHub Profile</a>
