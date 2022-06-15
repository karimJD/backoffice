package com.test.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.test.domain.Movie} entity.
 */
public class MovieDTO implements Serializable {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private Integer duration;

    @NotNull
    private Float ageLimit;

    @NotNull
    private String description;

    @NotNull
    private String actors;

    @NotNull
    private ZonedDateTime releaseDate;

    @Lob
    private byte[] image;

    private String imageContentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Float getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Float ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public ZonedDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(ZonedDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MovieDTO)) {
            return false;
        }

        MovieDTO movieDTO = (MovieDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, movieDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MovieDTO{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", duration=" + getDuration() +
            ", ageLimit=" + getAgeLimit() +
            ", description='" + getDescription() + "'" +
            ", actors='" + getActors() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", image='" + getImage() + "'" +
            "}";
    }
}
