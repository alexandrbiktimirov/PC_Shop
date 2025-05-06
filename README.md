# CustomPCBuilder
Project for a second-year subject in PJAIT - Distributed Programming Techniques.

## Description:
A web application for building and purchasing custom PCs, where each component’s specifications are checked against the rest of the build for full compatibility. Users select parts—CPU, motherboard, RAM, case, GPU, PSU, storage, cooling, etc.—and receive real-time warnings (e.g., GPU too large for chosen case) along with recommendations for compatible alternatives. A built-in forum allows enthusiasts to discuss optimal part combinations and share build tips.

## Examples of similar websites:

https://pcpartpicker.com

https://www.newegg.com/tools/custom-pc-builder

## Initial Functionalities:

Registration and Login – Authentication and authorization using Spring Security (roles: Customer, Admin)

Component Catalog Management – CRUD for admins on CPU, GPU, motherboard, RAM, storage, PSU, case, cooler, accessories; read-only browsing for customers

Build Planner & Compatibility Checker – Users create “Builds” by adding components to a parts list; system validates socket types, power requirements, physical dimensions, and other constraints, issuing warnings and suggesting compatible alternatives

Orders Management – Customers submit orders for selected build parts; CRUD for customers on their own orders, full CRUD for admins

Categories and Querying – Components organized into categories with advanced search and filters (brand, socket, form factor, price range, TDP); CRUD for admins, read-only for customers

Forum & Discussions – Topic-based message boards where users start threads on builds, troubleshooting, or performance comparisons; moderator controls for admins

Favorites and Build History – Customers save favorite parts and builds; view a history of past builds and orders

Data Validation – All user inputs and file uploads (e.g., product images) undergo server-side validation

Admin Dashboard & Charts – Visual statistics for admins: number of active builds, most popular components, order trends over time, revenue by category, top forum contributors

Email Notifications – Alerts for order status changes, part price drops on watched components, and replies in subscribed forum threads
