package tttask3;

import java.util.*;

//Book class to represent book details
class Book {
 private String title;
 private String author;
 private double price;
 private int quantity;

 public Book(String title, String author, double price, int quantity) {
     this.title = title;
     this.author = author;
     this.price = price;
     this.quantity = quantity;
 }

 public String getTitle() {
     return title;
 }

 // Getters and setters for other fields
}

//User class to represent user details
class User {
 private String username;
 private String password;

 public User(String username, String password) {
     this.username = username;
     this.password = password;
 }

 public String getUsername() {
     return username;
 }

 // Getters and setters for password
}

//ShoppingCart class to represent the shopping cart
class ShoppingCart {
 private List<Book> items;

 public ShoppingCart() {
     items = new ArrayList<>();
 }

 public void addItem(Book book) {
     items.add(book);
 }

 public void removeItem(Book book) {
     items.remove(book);
 }

 public List<Book> getItems() {
     return items;
 }
}

//Order class to represent user orders
class Order {
 private User user;
 private List<Book> books;

 public Order(User user, List<Book> books) {
     this.user = user;
     this.books = books;
 }

 // Getters and setters for user and books
}

//BookStore class to manage the main functionalities of the online bookstore
public class OnlineBookStore {
 private Map<String, Book> books;
 private List<User> users;

 public OnlineBookStore() {
     books = new HashMap<>();
     users = new ArrayList<>();
 }

 public void addBook(Book book) {
     books.put(book.getTitle(), book);
 }

 public void addUser(User user) {
     users.add(user);
 }

 public Book findBook(String title) {
     return books.get(title);
 }

 public User findUser(String username) {
     for (User user : users) {
         if (user.getUsername().equals(username)) {
             return user;
         }
     }
     return null;
 }

 public List<Book> getAllBooks() {
     return new ArrayList<>(books.values());
 }

 public List<User> getAllUsers() {
     return users;
 }

 public static void main(String[] args) {
     OnlineBookStore bookstore = new OnlineBookStore();

     // Add some books to the store
     Book book1 = new Book("Java Programming", "John Doe", 29.99, 10);
     Book book2 = new Book("Python Basics", "Jane Smith", 24.99, 8);
     bookstore.addBook(book1);
     bookstore.addBook(book2);

     // Register users
     User user1 = new User("user1", "password1");
     User user2 = new User("user2", "password2");
     bookstore.addUser(user1);
     bookstore.addUser(user2);

     // Sample usage: Search for a book and add it to the shopping cart
     String searchTitle = "Java Programming";
     Book foundBook = bookstore.findBook(searchTitle);
     if (foundBook != null) {
         ShoppingCart cart = new ShoppingCart();
         cart.addItem(foundBook);
         System.out.println("Book added to the shopping cart.");
     } else {
         System.out.println("Book not found.");
     }
 }
}

