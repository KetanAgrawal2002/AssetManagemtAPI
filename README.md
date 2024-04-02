# ASSET PRO: A DYNAMIC ASSET MANAGEMENT SYSTEM

## Description
The Asset Management API is a robust Spring Boot application tailored for efficient management of organizational assets. It facilitates a variety of operations, including asset addition, assignment to employees, and updates to asset information. The API adopts a RESTful design, ensuring a user-friendly interface for seamless interaction with the asset management system.

## Features
- **Category Management**: Add new categories for assets, each with a unique ID, name, and description.
- **Update Category**: Modify the details of existing asset categories.
- **List All Categories**: Retrieve a comprehensive list of all asset categories.
- **Asset Management**: Introduce new assets into the system with details like name, purchase date, condition, category, and assignment status.
- **List of Assets**: Obtain a full list of all assets within the system.
- **Search Assets**: Locate assets based on their names.
- **Update Asset**: Update existing asset details, including name, purchase date, condition, category, and assignment status.
- **Assign Asset**: Allocate an asset to an employee, ensuring that already assigned assets are not reassigned until recovered.
- **Recover Asset**: Mark an asset as ‘Recovered’ from an employee, making it available for reassignment.
- **Delete Asset**: Remove an asset from the system, with restrictions on deleting assigned assets.

## Getting Started
To set up a local environment and run the application, follow these steps:
1. **Clone the Repository:**
    ```bash
    git clone https://github.com/KetanAgrawal2002/AssetManagemtAPI.git
    ```
2. **Navigate to Project Directory:**
    ```bash
    cd AssetManagemtAPI
    ```
4. **Install Dependencies:**
    ```bash
    mvn install
    ```
5. **Run the Application:**
    ```bash
    mvn spring-boot:run
    ```

## Usage
Once the application is running, you can use an API client like Postman to interact with the API endpoints.
