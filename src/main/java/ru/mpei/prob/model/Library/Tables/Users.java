package ru.mpei.prob.model.Library.Tables;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_table", schema = "library")
public class Users {

    @Id
//    @SequenceGenerator(name = "octo_reference_code", sequenceName = "octo_reference_code", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "octo_reference_code")
    @Column(name = "userName")
    @Setter
    @Getter
    private String userName;

    @Setter @Getter
    @Column(name="projectID", nullable = true)
    private String projectID;

    @Column(name="json", nullable = true)
    @Type(type = "org.hibernate.type.TextType")
    @Setter
    @Getter
    private String json;

    @Column(name="currentpage", nullable = true, length = 1024)
    @Setter
    @Getter
    private String currentpage;


}
