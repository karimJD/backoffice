import React, { useEffect } from 'react';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { openFile, byteSize, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './movie.reducer';

export const MovieDetail = (props: RouteComponentProps<{ id: string }>) => {
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(getEntity(props.match.params.id));
  }, []);

  const movieEntity = useAppSelector(state => state.movie.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="movieDetailsHeading">Movie</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{movieEntity.id}</dd>
          <dt>
            <span id="title">Title</span>
          </dt>
          <dd>{movieEntity.title}</dd>
          <dt>
            <span id="duration">Duration</span>
          </dt>
          <dd>{movieEntity.duration}</dd>
          <dt>
            <span id="ageLimit">Age Limit</span>
          </dt>
          <dd>{movieEntity.ageLimit}</dd>
          <dt>
            <span id="description">Description</span>
          </dt>
          <dd>{movieEntity.description}</dd>
          <dt>
            <span id="actors">Actors</span>
          </dt>
          <dd>{movieEntity.actors}</dd>
          <dt>
            <span id="releaseDate">Release Date</span>
          </dt>
          <dd>{movieEntity.releaseDate ? <TextFormat value={movieEntity.releaseDate} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="image">Image</span>
          </dt>
          <dd>
            {movieEntity.image ? (
              <div>
                {movieEntity.imageContentType ? (
                  <a onClick={openFile(movieEntity.imageContentType, movieEntity.image)}>Open&nbsp;</a>
                ) : null}
                <span>
                  {movieEntity.imageContentType}, {byteSize(movieEntity.image)}
                </span>
              </div>
            ) : null}
          </dd>
        </dl>
        <Button tag={Link} to="/movie" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/movie/${movieEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default MovieDetail;
