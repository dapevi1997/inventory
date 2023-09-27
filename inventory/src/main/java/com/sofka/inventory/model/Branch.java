package com.sofka.inventory.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


@Data
public class Branch {
    @Id
    @Column("id")
    private Long id;
    @Column("branch_id")
    private String branchId;
    @Column("branch_name")
    private String branchName;
    @Column("branch_location")
    private String branchLocation;

}
