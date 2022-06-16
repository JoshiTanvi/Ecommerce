# Ecommerce

Entities:
Product -> Brands -> Items

Relation :

	1. Product -> Brands : 1 Product have many Brands
	2. Brands -> Items : 1 Brand have many Items
	3. Iteam -> Brands : Many items associted with single brand
	4. Brands -> Product : Many Beands associated with single product

Module : 

	1. Product Management
	2. Brand Management
	3. Item Management

Basic Operation:

	Manage Product(Add/Update/Delete/View)
	Manage Brand(Add/Update/Delete/view)
	Manage Items(Add/Update/Delete/view)

Advance Operation
	
	REST API to fetch Brands detil associate with Products
	REST API to fetch Items detail associate with Brands
	REST API to fetch individual Product detail with associated brands and brand's items in a single response
