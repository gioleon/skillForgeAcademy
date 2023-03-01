import jwt_decode from "jwt-decode";
import { User } from '../model/user/user';
import { UserResponse } from '../model/user/userResponse';


const SECRET_KEY = "este es el string por ahora";

export const decodeJwt = (token: string) => {
  // takes the token and decode it to UserResponse type.
  const payload: UserResponse = jwt_decode(token);

  // assign each payload parameter to the corresponding parameter into the user.
  const user: User = {
    id: Number(payload.extra.id),
    name: payload.extra.name,
    lastName: payload.extra.lastName,
    email: payload.sub,
    roles: payload.extra.roles.replace('[', '').replace(']', '').split(','),
    exp: payload.exp
  }

  // return user with all parameters setted.
  return user;

};
