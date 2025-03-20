# 📱 Experiment 4 - Android Lab

## 🛠️ Customer Management Application

This Android project is a simple Customer Management System that allows users to add customers, store them in a database, and view/filter them.

## ✨ Features
- ➕ Add a new customer with ID, Name, Phone, Gender, and Email.
- 🗄️ Store customer details in an SQLite database.
- 🔍 Retrieve and display all customers.
- 🎯 Filter customers by ID.

## 📂 Files and Structure
### 1. **🏠 MainActivity.java**
- 📋 Displays a list of customers stored in the SQLite database.
- ➕ Provides a button to add a new customer.
- 🔎 Includes a filter feature to search customers by ID.

### 2. **📝 AddCustomerActivity.java**
- 🖊️ Contains a form to input customer details.
- 🔄 Uses a spinner to select gender.
- 💾 Saves the customer data to the SQLite database.

### 3. **👤 Customer.java**
- 🏷️ A model class representing a customer.
- 📌 Contains attributes: `ID`, `Name`, `Phone`, `Gender`, and `Email`.
- ⚙️ Provides getter and setter methods for each attribute.

### 4. **🗃️ DataBaseHelper.java**
- 🏗️ Manages the SQLite database.
- 📄 Defines the `Customer` table schema.
- 🔄 Implements methods to insert and retrieve customers.

## 🚀 How to Run
1. Clone this repository:
   ```sh
   git clone <https://github.com/SajaAsfour/Experiment-4-Android-Lab>
   ```
2. Open the project in **Android Studio**.
3. ▶️ Build and run the project on an emulator or physical device.

## 📜 License
This project is for educational purposes and does not have a specific license.

