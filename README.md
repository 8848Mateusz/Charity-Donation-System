# Charity Donation System
## Project Description
The Charity Donation System application is designed to allow users to donate items to selected charitable institutions. The system enables managing donation categories, institutions, and donation-related operations. The application was built using Spring Boot, JPA (Java Persistence API), and MySQL.

## Technologies Used
- Java 17
- Spring Boot 3.3.0
- Spring Data JPA
- MySQL – as the database
- Hibernate 
- Maven – for dependency management
## Project Structure
### Packages
- domain: Entity classes that represent the database tables.
  - `Category`: Represents donation categories.
  - `Donation`: Represents a single donation.
  - `Institution`: Represents institutions to which donations can be sent.
- repository: Repository interfaces for CRUD operations on entities.
  - `CategoryRepository`
  - `DonationRepository`
  - `InstitutionRepository`
- service: Business logic layer.
  - `CategoryService`, `CategoryServiceImpl`
  - `DonationService`, `DonationServiceImpl`
  - `InstitutionService`, `InstitutionServiceImpl`
- web: Controllers layer for handling HTTP requests.
  - `DonationController`
  - `HomeController`
### Database
Tables:
- category: Stores information about donation categories.
- institution: Stores information about charitable institutions.
- donation: Stores information about donations, such as pickup date, quantity, pickup address, and institution ID.
  - Columns: `pick_up_date`, `pick_up_time`, `quantity`, `institution_id`, `city`, `phone_number`, `pick_up_comment`, `street`, `zip_code`
- donation_categories: A relational table linking donations with categories. Many-to-many relationship between the `donation` and `category` tables.
### Database Relationships:
- The `donation_categories` table handles the many-to-many relationship between donations (`donation`) and categories (`category`).
- The `donation` table has a foreign key (`institution_id`) that points to an institution in the `institution` table.
## Installation and Setup
1. Clone the repository
```bash
git clone https://github.com/YourRepository.git
cd charity-donation
```
2. Database Configuration
In the `application.properties` file, configure the connection to your MySQL database:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/charity_donation
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
3. Run the application
To run the application, use the following command:

```bash
mvn spring-boot:run
```
The application will be accessible at `http://localhost:8080`.

## Application Features
Users can add donations by selecting donation categories and institutions.
A user form allows specifying donation pickup details (date, time, address, contact phone).
The application enables browsing available institutions and their associated donation categories.
## Authors
Mateusz Maciejewski
## License
This project is licensed under the MIT License. 


