package fr.doriandelaval.springbootecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        if (product != null) {
            this.products.add(product);
            product.setProductCategory(this);
        }
    }
    
    public void removeProduct(Product product) {
        if (product != null && products.contains(product)) {
            product.setProductCategory(null);
            products.remove(product);
        }
    }
}
