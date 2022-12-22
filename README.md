# MasterRobot - An online Comic book store

The project displays a list of books and movies. A customer can order a list of items using a cart.

### Tech stack used:
Java spring, oracle jdbc, maven, bootstrap,  junit, postman

[Entity Relationship model](https://github.com/Ajitesh-Sai/Master-Robot-Bookstore/blob/main/Untitled%20Diagram.drawio.png)

### Working of the project:

1.	The customer requires User Id to login. 
2.	The customer selects the items and the quantity that are available from the store.
3.	Items are added to the cart.
4.	Customer goes to the cart and places an order.

### Assumptions about the implemented design:

1.	If attributes are imported from superclass to subclass then these attributes are not mentioned in the subclass ER diagram but have been included during     the creation of subclass tables.
2.	Attributes from weak entities are not mentioned in the ER diagram but are included during the creation of the table. 
3.	Address is stored as a single string. This is why it is not normalized further. 
4.	Sign up is not implemented on the frontend. The project assumes that the customer has already signed up. 
5.	The cartoon movie has the same title as the comic book it is based on. 
6.	Comic books do not have any description and studio name but comic movies do. 
7.	Comic movies do not have any published date.
8.	Customers can see the grand total of the selected items and place orders but the payment gateway has not been implemented.

### Constraints implemented:

1.	The custType of a customer can be of only one of the two values, namely, ‘regular’, or ’gold’.
2.	Phone (or email) must be unique and not null.
3.	The no.of copies of a comicBook or a cartoon movie cannot be < 0.
4.	The no. of copies of any book (or movie) ordered cannot be more than the available no. of copies of that item.
5.	The shippedDate cannot be less than the OrderedDate.
6.	When a regular customer orders books (and/or movies) , the shipping fee is $10. Before the items are shipped (ie. the shippedDate is null), if the         custType of that customer changes to ‘gold’, then the shipping fee must be changed to 0 on all her/his orders that are not shipped yet.
