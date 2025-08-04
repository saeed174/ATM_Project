## 📿 ATM\_Project

A **JavaFX-based ATM simulation** project designed to handle common banking operations like withdrawals, deposits, transfers, and account balance management through a graphical user interface.

---

### 🚀 Features

* 🎨 Modern JavaFX GUI
* 🧾 Cash Withdrawal & Deposit
* 🔁 Fund Transfers
* 💼 Wallet and Bank Account Management
* 🔒 Secure Password Handling (basic 4-digit simulation)
* 📊 Account Balance Display
* 🖼️ Responsive background and styled UI elements
* ☕ Built with Java Modules (JPMS)

---

### 🧰 Tech Stack

| Technology   | Version                              |
| ------------ | ------------------------------------ |
| Java         | 17+ (required)                       |
| JavaFX       | 17+                                  |
| Maven        | Optional (for dependency management) |
| SceneBuilder | Optional (for visual FXML design)    |

---

### 📦 Project Structure

```
ATM_Project/
🔼️ com.sfs/                     # Root module
🔼️ ├── entity/                  # BankAccount, WalletAccount classes
🔼️ ├── gui/                     # JavaFX GUI classes (Dashboard, Login, etc.)
🔼️ ├── service/                 # Account logic or business rules
🔼️ └── App.java                 # Main application entry point
🔼️ resources/                   # Assets like images or styles
🔼️ README.md                    # This file
🔼️ pom.xml / module-info.java   # Module or build descriptors
```

---

### 🛠️ Requirements

* JDK 17 or higher
* JavaFX SDK 17+
* IDE: IntelliJ, Eclipse, or VSCode (Pleiades recommended)

---

### 🥪 How to Run

1. **Clone the repo**

   ```bash
   git clone https://github.com/saeed174/ATM_Project.git
   cd ATM_Project
   ```

2. **Open in your Java IDE** (make sure Java 17+ is configured)

3. **Run `App.java`**

4. Make sure JavaFX is properly linked. If using Maven, ensure `javafx-controls` and `javafx-fxml` are dependencies.

---

### ✅ JavaFX Setup Tips

If using **VS Code with Pleiades**:

* Make sure to **update your runtime to Java 17+**
* Update the module path and VM options if needed:

  ```
  --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml
  ```

---

### 🥪 Sample Test Accounts

You can populate test data programmatically using `WalletAccount` or `BankAccount` constructors. Example:

```java
new WalletAccount("01012345678", "Ahmed Hassan", 1500.0, "1234");
```

---

### 🤝 Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss what you’d like to change.

---

### 📄 License

This project is open-source under the [MIT License](LICENSE).

---

### 👤 Author

**Saeed Mohamed**
📧 [saeed174](https://github.com/saeed174)
