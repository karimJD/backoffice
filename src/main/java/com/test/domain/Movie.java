package com.test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Movie.
 */
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @NotNull
    @Column(name = "age_limit", nullable = false)
    private Float ageLimit;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "actors", nullable = false)
    private String actors;

    @NotNull
    @Column(name = "release_date", nullable = false)
    private ZonedDateTime releaseDate;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    @NotNull
    @Column(name = "image_content_type", nullable = false)
    private String imageContentType;

    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties(value = { "movies" }, allowSetters = true)
    private Set<Category> categories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Movie id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public Movie title(String title) {
        this.setTitle(title);
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public Movie duration(Integer duration) {
        this.setDuration(duration);
        return this;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Float getAgeLimit() {
        return this.ageLimit;
    }

    public Movie ageLimit(Float ageLimit) {
        this.setAgeLimit(ageLimit);
        return this;
    }

    public void setAgeLimit(Float ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getDescription() {
        return this.description;
    }

    public Movie description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActors() {
        return this.actors;
    }

    public Movie actors(String actors) {
        this.setActors(actors);
        return this;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public ZonedDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public Movie releaseDate(ZonedDateTime releaseDate) {
        this.setReleaseDate(releaseDate);
        return this;
    }

    public void setReleaseDate(ZonedDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public byte[] getImage() {
        return this.image;
    }

    public Movie image(byte[] image) {
        this.setImage(image);
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return this.imageContentType;
    }

    public Movie imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        if (this.categories != null) {
            this.categories.forEach(i -> i.removeMovie(this));
        }
        if (categories != null) {
            categories.forEach(i -> i.addMovie(this));
        }
        this.categories = categories;
    }

    public Movie categories(Set<Category> categories) {
        this.setCategories(categories);
        return this;
    }

    public Movie addCategory(Category category) {
        this.categories.add(category);
        category.getMovies().add(this);
        return this;
    }

    public Movie removeCategory(Category category) {
        this.categories.remove(category);
        category.getMovies().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Movie)) {
            return false;
        }
        return id != null && id.equals(((Movie) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Movie{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", duration=" + getDuration() +
            ", ageLimit=" + getAgeLimit() +
            ", description='" + getDescription() + "'" +
            ", actors='" + getActors() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            "}";
    }
}
