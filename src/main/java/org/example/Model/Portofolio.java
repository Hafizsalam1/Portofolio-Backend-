package org.example.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Portofolio")
public class Portofolio {
    @Id
    @Column(name = "id")
    @Generated(value = "UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "title",nullable = false)
    private String Title;
    @Column(name = "description",nullable = false)
    private String Description;
    @Column(name = "Thumbnail",nullable = false)
    private String Thumbnail;
    @Column(name = "Year_of_production",nullable = false)
    private String productionYear;
}
