import dayjs from 'dayjs';
import { ICategory } from 'app/shared/model/category.model';

export interface IMovie {
  id?: number;
  title?: string;
  duration?: number;
  ageLimit?: number;
  description?: string;
  actors?: string;
  releaseDate?: string;
  imageContentType?: string;
  image?: string;
  categories?: ICategory[] | null;
}

export const defaultValue: Readonly<IMovie> = {};
