# Authentication Service - Step 1

## Objective

Create an authentication endpoint protected by Spring Security.

## Endpoint

Method: GET

URL:

```
http://localhost:8090/authenticate
```

## Authentication

Uses HTTP Basic Authentication.

Username:

```
user
```

Password:

```
pwd
```

## Conclusion

- Spring Security authenticates the user.
- Authentication endpoint is accessible only after successful login.
- JWT generation will be implemented in the next exercise.