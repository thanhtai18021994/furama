import {Role} from './role';

export interface User {
  id:number;
  fullName:string;
  username:string;
  password:string;
  roles:Role[];
}
