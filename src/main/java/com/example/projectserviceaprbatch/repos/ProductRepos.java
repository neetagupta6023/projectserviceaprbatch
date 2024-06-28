package com.example.projectserviceaprbatch.repos;

import com.example.projectserviceaprbatch.models.Product;
import com.example.projectserviceaprbatch.projections.productwithTitleandDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepos extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
    void delete(Product product);
    @Override
    Product save(Product product);

    @Query("select p.title, p.description from Product p where p.id=:id")
    productwithTitleandDesc someRandomQueryHQL(@Param("id") Long id);

    @Query(value = "select p.title, p.description from Product p where p.id=:id",nativeQuery = true)
    productwithTitleandDesc someRandomQuerySQL(@Param("id") Long id);
}
