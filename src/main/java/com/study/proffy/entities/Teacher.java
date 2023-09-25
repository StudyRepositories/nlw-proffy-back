package com.study.proffy.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Entity
@Table(name = Teacher.TABLE_NAME)
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = Teacher.COLUMN_ID_NAME)),
        @AttributeOverride(name = "resource", column = @Column(name = Teacher.COLUMN_RESOURCE_NAME))
})
public class Teacher extends BaseEntity {

    public static final String TABLE_NAME = "TEACHERS";
    protected static final String COLUMN_ID_NAME = "TCHR_SQ_TEACHER";
    protected static final String COLUMN_RESOURCE_NAME = "TCHR_SQ_RESOURCE";
    protected static final String COLUMN_FIRSTNAME_NAME = "tchr_ds_firstname";
    protected static final String COLUMN_LASTNAME_NAME = "tchr_ds_lastname";
    protected static final String COLUMN_DESCRIPTION_NAME = "tchr_ds_teacher";
    protected static final String COLUMN_PROFILE_NAME = "tchr_ds_profile";
    protected static final String COLUMN_CELLPHONE_NAME = "tchr_nu_cellphone";

    public Teacher() {
        super();
    }

    @Column(name = COLUMN_FIRSTNAME_NAME, nullable = false)
    private String firstname;

    @Column(name = COLUMN_LASTNAME_NAME, nullable = false)
    private String lastname;

    @Column(name = COLUMN_DESCRIPTION_NAME, nullable = false)
    private String description;

    @Column(name = COLUMN_PROFILE_NAME, nullable = false)
    private String profilePicture;

    @Column(name = COLUMN_CELLPHONE_NAME, unique = true)
    private String cellphone;

    @Override
    public Teacher setId(Long id) {
        super.setId(id);
        return this;
    }

    @Override
    public Teacher setResource(UUID resource) {
        super.setResource(resource);
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Teacher setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Teacher setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Teacher setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Teacher setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
        return this;
    }

    public String getCellphone() {
        return cellphone;
    }

    public Teacher setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        if (!super.equals(o)) return false;

        return cellphone.equals(teacher.cellphone);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cellphone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Teacher{");
        sb.append("firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", profilePicture='").append(profilePicture).append('\'');
        sb.append(", cellphone='").append(cellphone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
