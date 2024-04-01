package raph.dev.springboot_rest_api_demo_1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor // from @Getter, @Setter, @NoArgsConstructor are from lombok
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;

    @Column(length = 150)
    private String description;

    @Column
    private Integer price;

}
