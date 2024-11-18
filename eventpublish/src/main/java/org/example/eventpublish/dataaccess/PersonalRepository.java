package org.example.eventpublish.dataaccess;

import org.example.eventpublish.models.Personal;
import org.example.eventpublish.models.ProductProjection;
import org.example.eventpublish.models.Products;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalRepository extends MongoRepository<Personal, String> {
    Optional<Personal> findByEmail(String email);

    Optional<Personal> findByNameAndSurname(String name, String surname);


    @Query(value = "{ 'email': ?0, 'products': { $elemMatch: { 'productName': ?1 } } }",
            fields = "{ 'products.$': 1 }")
    List<ProductProjection> findProductsByEmailAndProductName(String email, String productName);



    @Query(value = "{ 'email': ?0, 'products': { $elemMatch: { 'productName': ?1 } } }",
            fields = "{ 'products.$': 1 }")
    List<Personal> findProductsByEmail(String email);

}
