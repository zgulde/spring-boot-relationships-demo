# Starting Out

For this lesson we'll be taking a look at several parts of a small application that demonstrates how to use relationships in spring boot.
You can find the application in this github repo, and these markdown documents are meant to guide you through the application piece by piece.
Of course you can always choose to skip to the end and peruse this repository in the order or manner that you want.

## Before You Go

Before we begin, go ahead and clone this repository from IntelliJ and create a MySQL database named
`demo_db` so that you can run the code locally. Familiarize yourself with the application so that
you know what the end product looks like.

As you progress along the path, make sure you are taking adequate time to pause at each step. This
repo (and the curriculum) will give you a starting place for what code to look at, but you should
not look *just* at the code you are told to. Consider the project as a whole, think about how it
relates to the work you have done, and be curious about (and investigate!) where all the pieces come from.

Let's make sure we have everything we need before embarking on our journey towards spring boot relationships.

### Review: Spring Boot

Spring boot is a Java framework for quickly developing scalable applications. We are focused on the web portion of the framework.

- **Controllers**
    - Controllers orchestrate and implement business logic.
    - Controllers define application urls, define which html templates (*views*) correspond to them, and contain logic to pass any data required to the view.
- **HTML View Generation w/ Thymeleaf**
    - Thymeleaf is all about injecting data into HTML.
    - Thymeleaf lets us loop through collections and generate HTML for each item.
- **Database Interaction**
    - Models with JPA Annotations map to database tables.
    - Repositories are our *data access objects* that let our us perform CRUD operations.

### Review: Relational Database Relationship Types

- **One-to-many** and **many-to-one**

    - The case where data from multiple rows one table is associated with a single record from another table.
    - Remember that one-to-many and many-to-one are the same relationship, seen from different sides of it.
    - The table on the many side of the relationship will have a column that is a *foreign key* to the *primary key* of the other table.
    - Examples:
        - users (one) -> blog posts (many). A user has many blog posts and a blog post belongs to a single user.
        - students (many) -> cohorts (one). A student belongs to a single cohort, and a cohort has many students in it.

- **Many-to-many**

    - The case where data from multiple rows one table can be associated with multiple records from another table.
    - Neither table has a foreign key on it, rather a *join table* or *link table* is created that contains foreign keys to the other tables.
    - Examples:
        - blog posts <-> topics. A blog post might be about many different topics, and a single topic might have multiple blog posts.
        - students <-> instructors. A student has many instructors and an instructor teaches many students.
        
## Begin With the End in Mind

[Do a search for "software development" on amazon](https://smile.amazon.com/s?k=software+development).
Take a look at the information in the resulting page. If you were building this web page, what
models would you make? What would their attributes be? What are the relationships between them?

## Next Steps

- Take a look at [the README](https://github.com/zgulde/spring-boot-relationships-demo/blob/main/readme.md) for this repository to get a broad overview of the application, the 3 entities in it, and how they are related.
- Head back to the map and move on to the many to one and one to many step.
