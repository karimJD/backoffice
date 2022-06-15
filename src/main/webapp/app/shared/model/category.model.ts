import { IMovie } from 'app/shared/model/movie.model';

export interface ICategory {
  id?: number;
  name?: string;
  movies?: IMovie[] | null;
}

export const defaultValue: Readonly<ICategory> = {};
