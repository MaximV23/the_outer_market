The Outer Market PaaS webshop.

## Technologies
- Java 17
- Spring Boot 3.4.5
- Gradle
- Azure SQL Database
- Deployed on Azure Virtual Machines (Ubuntu 22.04)

## APIs

### 1. List Products
- `GET /theoutermarket/products`
- Returns list of all available products.

### 2. Reserve Products
- `POST /theoutermarket/reserve`
- Body: JSON array of `{productId, quantity}`.
- Returns: `reservationId`.

### 3. Confirm Reservation
- `POST /theoutermarket/confirm?reservationId={id}`
- Finalizes the reservation.

### 4. Cancel Reservation
- `POST /theoutermarket/cancel?reservationId={id}`
- Cancels the reservation and restores stock.

## Deployment
- the outer market running on port 8081
- Accessible via Azure public IP and domain

## Notes
- Supports ACID transactions using Spring's `@Transactional`.
- Multiple products can be reserved in one request.
- Errors rollback full reservation.

