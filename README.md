# 📱 SportEmpire Mobile Automation Framework

This project is a **mobile automation framework** built for testing the **SportEmpire** Android application using **Appium**, **Cucumber**, and **TestNG**.

It follows **Page Object Model (POM)** best practices and is designed for clean, scalable, and maintainable mobile test automation.

---

## 🚀 Technologies and Tools Used

- **Java 14**
- **Maven**
- **Appium** (Java client)
- **Selenium 4** (for WebElement control)
- **TestNG** (test runner)
- **Cucumber** (BDD and Gherkin syntax)
- **Lombok** (for boilerplate code reduction)

---

## 🏗️ Project Structure

| Folder | Description |
|:-------|:------------|
| `src/main/java` | Page Objects, Driver Factory, Utilities |
| `src/test/java` | Step Definitions, Hooks, Test Runners |
| `src/test/resources/features` | Cucumber Feature files |
| `src/main/resources/` | Configuration files (properties files like `login.properties`, etc.) |

---

## ⚙️ How to Set Up and Run Tests

### Prerequisites:

- JDK 14+ installed
- Android Emulator running (or real device connected)
- Appium Server running (Appium 2.x recommended)
- Maven installed
- IntelliJ IDEA or similar IDE

### Running the Tests

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd SportEmpireAppiumAutomationTests
