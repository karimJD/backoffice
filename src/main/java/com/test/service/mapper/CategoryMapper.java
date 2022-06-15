package com.test.service.mapper;

import com.test.domain.Category;
import com.test.domain.Movie;
import com.test.service.dto.CategoryDTO;
import com.test.service.dto.MovieDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
    @Mapping(target = "movies", source = "movies", qualifiedByName = "movieIdSet")
    CategoryDTO toDto(Category s);

    @Mapping(target = "removeMovie", ignore = true)
    Category toEntity(CategoryDTO categoryDTO);

    @Named("movieId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    MovieDTO toDtoMovieId(Movie movie);

    @Named("movieIdSet")
    default Set<MovieDTO> toDtoMovieIdSet(Set<Movie> movie) {
        return movie.stream().map(this::toDtoMovieId).collect(Collectors.toSet());
    }
}
