# 🧾 Microservices Billing System - Spring Boot & Angular

> **Architecture Micro-services pour la gestion de clients, produits et factures**  
> Réalisé avec **Spring Boot**, **Spring Cloud**, **Eureka**, **Gateway**, **OpenFeign** et **Angular**  
> 📎 Repo GitHub : [https://github.com/Labrini-Ouiam/Microservices-Billing-System-Spring-Boot-Angular.git](https://github.com/Labrini-Ouiam/Microservices-Billing-System-Spring-Boot-Angular.git)

---

## 📌 Description

Ce projet illustre la mise en place d'une architecture micro-services distribuée pour gérer :
- Les **clients**
- Les **produits** (inventory)
- Les **factures** liées à des clients et contenant plusieurs produits

Le système repose sur :
- **Spring Boot** pour le développement des services
- **Spring Cloud Eureka** pour la découverte
- **Spring Cloud Config** pour la configuration centralisée
- **Spring Cloud Gateway** pour le routage (statique + dynamique)
- **OpenFeign** pour la communication inter-services
- **Angular** pour le front-end

---

## 🧩 Structure des micro-services

| Service              | Description                                | Port par défaut |
|----------------------|---------------------------------------------|-----------------|
| `eureka-server`      | Annuaire Eureka                             | 8761            |
| `config-server`      | Serveur de configuration                    | 8888            |
| `gateway`           | Spring Cloud Gateway                        | 8080            |
| `customer-service`   | Gestion des clients                         | 8081            |
| `inventory-service`  | Gestion des produits                        | 8082            |
| `billing-service`    | Facturation (avec OpenFeign)                | 8083            |
| `angular-client`     | Interface web Angular                       | 4200            |

---

## ✅ Fonctionnalités

- Création, mise à jour, suppression et consultation de **clients**
- Gestion complète des **produits**
- Création et consultation de **factures** associées à un client
- Routage statique et dynamique via Gateway
- Découverte automatique des services (Eureka)
- Configuration centralisée (Config Server)
- Communication inter-services (OpenFeign)
- Front-end Angular connecté à la Gateway

---

## 🚀 Prérequis

- ✅ **Java 17+**
- ✅ **Maven**
- ✅ **Node.js** + **npm** (ou yarn)
- (Optionnel) Docker & Docker Compose pour le déploiement

---

## 🧭 Démarrage rapide (en local)

### 1️⃣ Démarrer le Config Server
```bash
cd config-server
mvn clean package
java -jar target/config-server-*.jar
# http://localhost:8888

2️⃣ Démarrer Eureka Server

cd eureka-server
mvn clean package
java -jar target/eureka-server-*.jar
# http://localhost:8761

3️⃣ Démarrer les micro-services

# Customer
cd customer-service
mvn clean package
java -jar target/customer-service-*.jar

# Inventory
cd inventory-service
mvn clean package
java -jar target/inventory-service-*.jar

# Billing
cd billing-service
mvn clean package
java -jar target/billing-service-*.jar

4️⃣ Démarrer la Gateway

cd gateway
mvn clean package
java -jar target/gateway-*.jar
# http://localhost:8080

5️⃣ Lancer le client Angular

cd angular-client
npm install
ng serve --open --port 4200
# http://localhost:4200

📁 Arborescence recommandée

.
├── eureka-server
├── config-server
├── gateway
├── customer-service
├── inventory-service
├── billing-service
├── angular-client
└── README.md

👩‍💻 Auteur

Labrini Ouiam
