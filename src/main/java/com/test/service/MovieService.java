package com.test.service;

import com.test.service.dto.MovieDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.test.domain.Movie}.
 */
public interface MovieService {
    /**
     * Save a movie.
     *
     * @param movieDTO the entity to save.
     * @return the persisted entity.
     */
    MovieDTO save(MovieDTO movieDTO);

    /**
     * Updates a movie.
     *
     * @param movieDTO the entity to update.
     * @return the persisted entity.
     */
    MovieDTO update(MovieDTO movieDTO);

    /**
     * Partially updates a movie.
     *
     * @param movieDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<MovieDTO> partialUpdate(MovieDTO movieDTO);

    /**
     * Get all the movies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<MovieDTO> findAll(Pageable pageable);

    /**
     * Get the "id" movie.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<MovieDTO> findOne(Long id);

    /**
     * Delete the "id" movie.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
