# Many to Many

Now we will explain the implementation and application of the many to many relationship between
phones and carriers. A phone can work with multiple carriers, and a carrier supplies service to
multiple different phones.

## Models

Take a look at [the `Carrier` class](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/java/com/zgulde/demo/Carrier.java).
In it is a `phones` property that has quite a bit of annotation above it. The `@ManyToMany`
annotation, along with the type of this property, `List<Phone>` is what tells hibnernate how phones
and carriers are related. The `@JoinTable` annotation lets us specify how the join table necessary
for this relationship is created, that is, the table's name and the names of the columns within the table.

Within [the `Phone` class](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/java/com/zgulde/demo/Phone.java),
the `carriers` property has a much more simple annotation. Within the annotation, we specify "phones"
for the `mappedBy` parameter, where "phones" is the name of the property on the `Carrier` class.

It does not matter which model gets which annotations, so long as they are all present.

## Views

Take a look at the [`phones-by-carrier.html`](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/resources/templates/phones-by-carrier.html)
and [`carriers-by-phone.html`](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/resources/templates/carriers-by-phone.html)
thymeleaf templates. Within each is a nested loop to access either the carriers or phones for each of the outer elements.

For example, in the `carriers-by-phone.html` template, we first loop through each of the phones that
were passed from the controller. Within each loop body we access the `carriers` property and loop
through it to display all the carriers that service that phone, each as one list item.

## Controller

Take a look at [the `phonesByCarrier` and `carriersByPhone` methods](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/src/main/java/com/zgulde/demo/DemoApplication.java#L54).
These provide the corresponding views with a single list of either phones or carriers. That list is
passed to the view and through it, the list of carriers or phones can be accessed and looped through
to generate the necessary HTML.

## Recap

We used the `@ManyToMany` annotation on our models to define this relationship.

Each property annotated by the `@ManyToMany` annotation is a collection type, and the type of each
element is that of the other model class. One side of the relationship will contain the `@JoinTable`
annotation as well, and the other side will define the `mappedBy` parameter in the `@ManyToMany`
annotation.

```java
// in the Carrier class
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
    name = "carriers_phones",
    joinColumns = {@JoinColumn(name = "carrier_id")},
    inverseJoinColumns = {@JoinColumn(name = "phone_id")}
)
private List<Phone> phones = new ArrayList<>();
```

```java
// in the Phone class
@ManyToMany(mappedBy = "phones")
private List<Carrier> carriers = new ArrayList<>();
```

It does not matter which side of the relationship has which annotations.

## Next Steps

1. Inspect the database structure as it relates to phones and carriers. How do the database tables relate to the Java models?
1. Start to work on the exercise!
