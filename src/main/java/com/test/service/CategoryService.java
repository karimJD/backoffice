package com.test.service;

import com.test.service.dto.CategoryDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.test.domain.Category}.
 */
public interface CategoryService {
    /**
     * Save a category.
     *
     * @param categoryDTO the entity to save.
     * @return the persisted entity.
     */
    CategoryDTO save(CategoryDTO categoryDTO);

    /**
     * Updates a category.
     *
     * @param categoryDTO the entity to update.
     * @return the persisted entity.
     */
    CategoryDTO update(CategoryDTO categoryDTO);

    /**
     * Partially updates a category.
     *
     * @param categoryDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CategoryDTO> partialUpdate(CategoryDTO categoryDTO);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    List<CategoryDTO> findAll();

    /**
     * Get all the categories with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CategoryDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" category.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CategoryDTO> findOne(Long id);

    /**
     * Delete the "id" category.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
