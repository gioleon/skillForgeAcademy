import jwt_decode from "jwt-decode";
import { User } from '../model/user/user';
import { UserResponse } from '../model/user/userResponse';


const SECRET_KEY = "este es el string por ahora";

export const decodeJwt = (token: string) => {
  const payload: UserResponse = jwt_decode(token);

  const user: User = {
    id: Number(payload.extra.id),
    name: payload.extra.name,
    lastName: payload.extra.lastName,
    email: payload.sub,
    roles: payload.extra.roles.replace('[', '').replace(']', '').split(','),
  }

  return user;

};
