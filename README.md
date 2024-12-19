# Deal Hub API Documentation

The Deal Hub API provides endpoints for managing stores, offers, and contracts between store owners and individuals. This documentation covers all available endpoints, their purpose, and usage.

## Overview
The API consists of the following models:
- **Store:** Represents a store in the system, including its details and status.
- **StoreOffer:** Manages offers made between individuals and stores.
- **StoreContract:** Tracks contracts between individuals and store owners.

### Total Endpoints
- **StoreController:** 2 endpoints
- **StoreOfferController:** 12 endpoints
- **StoreContractController:** 2 endpoints  
**Total:** **16 endpoints**

This documentation is organized into the following sections:
1. **Store API Endpoints**
2. **Store Offer API Endpoints**
3. **Store Contract API Endpoints**

Each section includes a detailed explanation of the endpoints, their request parameters, and expected responses.

# Store Offer API Documentation

The `StoreOfferController` provides endpoints for managing offers between store owners and individuals in the Deal Hub application. Below is a detailed explanation of the available endpoints:

## 1. Get Offers for a Specific Store
**URL:** `GET /api/v1/deal-hub/store-offer/get-by-store/{storeId}`  
**Description:** Retrieves all offers associated with a specific store.  
**Path Parameters:**
- `storeId` (Integer): The ID of the store.  

---

## 2. Get Offers by Store and Individual
**URL:** `GET /api/v1/deal-hub/store-offer/get-by-store-and-individual/{storeId}/{individualId}`  
**Description:** Fetches all offers made by a specific individual for a specific store.  
**Path Parameters:**
- `storeId` (Integer): The ID of the store.
- `individualId` (Integer): The ID of the individual. 

---

## 3. Get Pending Offers by Individual
**URL:** `GET /api/v1/deal-hub/store-offer/pending-by-individual/{individualId}`  
**Description:** Retrieves all pending offers for a specific individual.  
**Path Parameters:**
- `individualId` (Integer): The ID of the individual.  

---

## 4. Get Pending Offers by Owner
**URL:** `GET /api/v1/deal-hub/store-offer/pending-by-owner/{ownerId}`  
**Description:** Retrieves all pending offers for a specific store owner.  
**Path Parameters:**
- `ownerId` (Integer): The ID of the store owner.  

---

## 5. Make Offer with Same Deal
**URL:** `POST /api/v1/deal-hub/store-offer/add-same-deal/{storeId}/{individualId}`  
**Description:** Creates an offer with the same deal as store deal.  
**Path Parameters:**
- `storeId` (Integer): The ID of the store.
- `individualId` (Integer): The ID of the individual. 

---

## 6. Make Counter Offer
**URL:** `POST /api/v1/deal-hub/store-offer/add-counter-deal/{storeId}/{individualId}`  
**Description:** Creates a counteroffer for an store deal.  
**Path Parameters:**
- `storeId` (Integer): The ID of the store.
- `individualId` (Integer): The ID of the individual.  
**Request Body:** `StoreCounterOfferDTOIn` object containing counteroffer details.

---

## 7. Individual Counter Offer
**URL:** `PUT /api/v1/deal-hub/store-offer/counter-by-individual/{offerId}/{individualId}`  
**Description:** Updates an offer with a counter from an individual.  
**Path Parameters:**
- `offerId` (Integer): The ID of the offer.
- `individualId` (Integer): The ID of the individual.  
**Request Body:** `StoreCounterOfferDTOIn` object containing counteroffer details.

---

## 8. Individual Approve Offer
**URL:** `PUT /api/v1/deal-hub/store-offer/approve-by-individual/{offerId}/{individualId}`  
**Description:** Approves an offer as an individual.  
**Path Parameters:**
- `offerId` (Integer): The ID of the offer.
- `individualId` (Integer): The ID of the individual.  

---

## 9. Individual Reject Offer
**URL:** `PUT /api/v1/deal-hub/store-offer/reject-by-individual/{offerId}/{individualId}`  
**Description:** Rejects an offer as an individual.  
**Path Parameters:**
- `offerId` (Integer): The ID of the offer.
- `individualId` (Integer): The ID of the individual.  

---

## 10. Owner Counter Offer
**URL:** `PUT /api/v1/deal-hub/store-offer/counter-by-owner/{offerId}/{ownerId}`  
**Description:** Updates an offer with a counter from a store owner.  
**Path Parameters:**
- `offerId` (Integer): The ID of the offer.
- `ownerId` (Integer): The ID of the owner.  
**Request Body:** `StoreCounterOfferDTOIn` object containing counteroffer details.  

---

## 11. Owner Approve Offer
**URL:** `PUT /api/v1/deal-hub/store-offer/approve-by-owner/{offerId}/{ownerId}`  
**Description:** Approves an offer as a store owner.  
**Path Parameters:**
- `offerId` (Integer): The ID of the offer.
- `ownerId` (Integer): The ID of the owner.  

---

## 12. Owner Reject Offer
**URL:** `PUT /api/v1/deal-hub/store-offer/reject-by-owner/{offerId}/{ownerId}`  
**Description:** Rejects an offer as a store owner.  
**Path Parameters:**
- `offerId` (Integer): The ID of the offer.
- `ownerId` (Integer): The ID of the owner.  


# Store API Documentation

The `StoreController` provides endpoints for managing stores in the Deal Hub application. Below is a detailed explanation of the available endpoints:


---

## 13. Activate Store
**URL:** `PUT /api/v1/deal-hub/store/activate/{id}`  
**Description:** Activates a store, allowing individuals to make offers. Prevents the owner from making changes to the store.  
**Path Parameters:**
- `id` (Integer): The ID of the store to be activated.  

---

## 14. Deactivate Store
**URL:** `PUT /api/v1/deal-hub/store/deactivate/{id}`  
**Description:** Deactivates a store, rejecting all active offers and preventing individuals from making offers. Allows the owner to make changes to the store.  
**Path Parameters:**
- `id` (Integer): The ID of the store to be deactivated.  



# Store Contract API Documentation

The `StoreContractController` provides endpoints for managing store contracts in the Deal Hub application. Below is a detailed explanation of the available endpoints:

---

## 15. Get All Store Contracts by Individual
**URL:** `GET /api/v1/deal-hub/store-contract/get-by-individual/{individualId}`  
**Description:** Retrieves all store contracts associated with a specific individual.  
**Path Parameters:**
- `individualId` (Integer): The ID of the individual.  

---

## 16. Get All Store Contracts by Owner
**URL:** `GET /api/v1/deal-hub/store-contract/get-by-owner/{ownerId}`  
**Description:** Retrieves all store contracts associated with a specific store owner.  
**Path Parameters:**
- `ownerId` (Integer): The ID of the store owner.  

