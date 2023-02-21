export interface UserResponse {
    sub: string;
    extra: {
        lastName: string;
        name: string;
        roles: string;
        id: string;
    }
}