# One to Many and Many to One

Here we'll talk about how to implement the one to many relationship between phones and companies and
the applications of it. A phone's manufacturer is a single company, and a company can manufacture
multiple different phones.

## Models

The way we represent this relationship with our Java code is by defining properties whose types are
either another class, or a collection where each element's type is another class.

Take a look at [the `Phone` class](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/java/com/zgulde/demo/Phone.java),
particularly the `manufacturer` property. Notice that it's type is `Company`, which is another model
class in our application. Above this property is the `@ManyToOne` annotation.

Within [the `Company` class](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/java/com/zgulde/demo/Company.java)
there is a `phones` property that is a `List` type where each element is a `Phone` object.

## View

Look at [the `phones-for-one-company.html` thymeleaf html template](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/resources/templates/phones-for-one-company.html). In this template we loop
through the items in `company.phones`, which is the list of `Phone` objects associated with a
single property. Notice that while this property is a relationship, we access it like we would any
other model property.

Inside the body of the loop we access properties of each `Phone` object to generate some HTML.

The first two links on the application's landing page demonstrate this functionality.

## Controller

Take a look at [the `phonesForOneCompany` method](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/java/com/zgulde/demo/DemoApplication.java#L46)
within the `DemoApplication` class. This method defines a parameter `company` that comes from the
url path. Based on the `company` parameter's value, the corresponding `Company` object is found and
passed to the view.

## Recap

We use the `@OneToMany` and `@ManyToOne` annotations on our models to define the relationship.

The `@OneToMany` annotation annotates the property that points to the many side of the relationship
on the model that is on the one side of the relationship. The property has a plural name and is a
collection type. The value of the `mappedBy` parameter in the annotation is the corresponding
property name from the other model.

```java
// on the Company class
@OneToMany(mappedBy = "manufacturer")
private List<Phone> phones;
```
  
The `@ManyToOne` annotation annotates the property that points to the one side of the relationship
on the model that is on the many side of the relationship. The property has singular name and it's
type is another model in our application.

```java
// on the Phone class
@ManyToOne
private Company manufacturer;
```

## Next Steps

1. Run the application so that hibernate creates the database structure
1. Inspect the resulting database tables. How do the table columns relate to the properties of the
   Phone and Company models? (Ignore the information about Carriers for now)
1. Visit `http://localhost:8080/seed` to fill the database with some demo data. ([Read more about it here if you wish.](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/java/com/zgulde/demo/DemoApplication.java#L67))
